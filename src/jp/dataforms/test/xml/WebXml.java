package jp.dataforms.test.xml;

import java.io.File;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import jp.dataforms.test.proj.WebAppProject;


/**
 * web.xmlファイルのクラス。
 *
 */
public class WebXml extends BaseXml {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(WebXml.class);
	

	/**
	 * JAVAのソースパスのcontext-param名称。
	 */
	private static final String JAVA_SOURCE_PATH = "java-source-path";

	/**
	 * Webのソースパスのcontext-param名称。
	 */
	private static final String WEB_SOURCE_PATH = "web-source-path";

	/**
	 * コンストラクタ。
	 * @param xml web.xmlのファイル。
	 * @throws Exception 例外。
	 */
	public WebXml(final File xml) throws Exception {
		super(xml);
	}

	/**
	 * 指定されたcontext-paramをコメントアウトしたノードを取得する。
	 * @param param context-paramの名称。
	 * @return 該当するコメントノード。
	 */
	public Node getContextParamComment(final String param) throws Exception {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = this.getDocument();
		Node ret = (Node) xpath.evaluate("//comment()[contains(., '<param-name>" + param + "</param-name>')]", doc, XPathConstants.NODE);
		return ret;
	}
	
	/**
	 * context-paramのノードを取得する。
	 * @param name context-paramの名称。
	 * @return context-paramのノード。
	 * @throws Exception 例外。
	 */
	public Node getContextParam(final String name) throws Exception {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = this.getDocument();
		Node ret = (Node) xpath.evaluate("//context-param/param-name[contains(text(), '" + name + "')]", doc, XPathConstants.NODE);
		if (ret != null) {
			return ret.getParentNode();
		} else {
			return ret;
		}
	}
	
	/**
	 * 指定したcontext-paramを削除します。
	 * @param name context-paramの名称。
	 * @throws Exception 例外。
	 */
	public void removeContextParam(final String name) throws Exception {
		Node root = this.getDocument().getChildNodes().item(0);
		Node node = this.getContextParam(name);
		if (node != null) {
			Node nn = node.getNextSibling();
			if (nn.getNodeType() == Node.TEXT_NODE) {
				root.removeChild(nn);
			}
			root.removeChild(node);
		}
	}
	
	/**
	 * context-paramのノードを作成する。
	 * @param name context-paramの名称。
	 * @param value context-paramの値。
	 * @return context-paramのノード。
	 */
	public Node createContextParamNode(final String name, final String value) {
		Document doc = this.getDocument();
		Element cp = doc.createElement("context-param");
		{
			{
				Element pn = doc.createElement("param-name");
				pn.appendChild(doc.createTextNode(name));
				cp.appendChild(pn);
			}
			{
				Element pv = doc.createElement("param-value");
				pv.appendChild(doc.createTextNode(value));
				cp.appendChild(pv);
			}
		}
		return cp;
	}
	
	
	
	/**
	 * プロジェクトのソースパスを設定する。
	 * @param project プロジェクト。。
	 * @throws Exception 例外。
	 */
	public void setSourcePath(final WebAppProject project) throws Exception{
		Node root = this.getDocument().getChildNodes().item(0);
		{
			this.removeContextParam(JAVA_SOURCE_PATH);
			Node javaNode = this.getContextParamComment(JAVA_SOURCE_PATH);
			String javaSrc = project.getJavaSrcPath();
			logger.debug("javaSrc=" + javaSrc);
			Node cp = this.createContextParamNode(JAVA_SOURCE_PATH, javaSrc);
			root.insertBefore(cp, javaNode);
			Text nl = this.getDocument().createTextNode("\n\t");
			root.insertBefore(nl, javaNode);
		}
		{
			this.removeContextParam(WEB_SOURCE_PATH);
			Node webappNode = this.getContextParamComment(WEB_SOURCE_PATH);
			String webapp = project.getWebSrcPath();
			logger.debug("webapp=" + webapp);
			Node cp = this.createContextParamNode(WEB_SOURCE_PATH, webapp);
			root.insertBefore(cp, webappNode);
			Text nl = this.getDocument().createTextNode("\n\t");
			root.insertBefore(nl, webappNode);
		}
		// this.setContextParam("client-log-leve", "debug");
	}

	/**
	 * web.xmlのcontext-paramを設定します。
	 * @param pname パラメータ名。
	 * @param value 値。
	 * @throws Exception 例外。
	 */
	public void setContextParam(final String pname, final String value) throws Exception {
		Node node = this.getContextParam(pname);
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node vnode = (Node) xpath.evaluate("param-value", node, XPathConstants.NODE);
		vnode.setTextContent(value);
	}
	
	
	/**
	 * dump。
	 */
	public void dump() throws Exception {
		logger.debug("web.xml dump");
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = this.getDocument();
		NodeList list = (NodeList) xpath.evaluate("//context-param", doc, XPathConstants.NODESET);
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			String name = (String) xpath.evaluate("param-name/text()", node, XPathConstants.STRING);
			String value = (String) xpath.evaluate("param-value/text()", node, XPathConstants.STRING);
			logger.debug("context-param: " + name + " = " + value);
		}
	}
		

}
