package jp.dataforms.test.xml;

import java.io.File;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * server.xmlの設定変更。
 *
 */
public class ServerXml extends BaseXml {
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(ServerXml.class);
	
	/**
	 * コンストラクタ。
	 * @param xml XMLファイル。
	 * @throws Exception 例外。
	 */
	public ServerXml(final File xml) throws Exception {
		super(xml);
	}

	/**
	 * アプリケーションのコンテキスト名名称を取得します。
	 * @param appurl アプレケーションの名称。
	 * @return アプリケーションのコンテキスト名。
	 */
	private String getContext(final String appurl) {
		String [] sp = appurl.split("/");
		String context = sp[sp.length - 1];
		return context;
	}
	
	/**
	 * アプリケーションコンテキストを設定します。
	 * @param appurl アプリケーションURL。
	 * @throws Exception 例外。
	 */
	public void setAppContext(final String appurl) throws Exception {
		String context = this.getContext(appurl);
		logger.debug("context=" + context);
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = this.getDocument();
		Element element = (Element) xpath.evaluate("//Context[@docBase='" + context + "']", doc, XPathConstants.NODE);
		if (element != null) {
			element.setAttribute("reloadable", "true");
			logger.info("server.xmlのcontext(" + context + ")をreloadable=\"true\"に設定しました。");
		} else {
			throw new Exception("serverにアプリケーション(" + context + ")を追加してください。");
/*			element = doc.createElement("Context");
			element.setAttribute("docBase", context);
			element.setAttribute("path", "/" + context);
			element.setAttribute("reloadable", "true");
			element.setAttribute("source", "org.eclipse.jst.jee.server:" + context);
			Element host = (Element) xpath.evaluate("//Host[@appBase='webapps']", doc, XPathConstants.NODE);
			host.appendChild(element);
			logger.info("server.xmlにcontext(" + context + ")を追加しました。");*/
		}
	}

}
