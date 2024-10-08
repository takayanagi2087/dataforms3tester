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

/**
 * context.xmlファイルのクラス。
 *
 */
public class ContextXml extends BaseXml {
	
	/**
	 * Logger.
	 */
	private Logger logger = LogManager.getLogger(ContextXml.class);
	
	/**
	 * コンストラクタ。
	 * @param xml context.xmlのファイル。
	 * @throws Exception 例外。
	 */
	public ContextXml(final File xml) throws Exception {
		super(xml);
	}
	
	/**
	 * データソースのノードを取得する。
	 * @return データソースのノード。
	 * @throws Exception 例外。
	 */
	private Node getDatasource() throws Exception {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = this.getDocument();
		Node ret = (Node) xpath.evaluate("//Resource[@name='jdbc/dfdb']", doc, XPathConstants.NODE);
		return ret;
	}
	
	/**
	 * データベースのパスを設定します。
	 * @param dbpath データベースのパス。
	 * @throws Exception 例外。
	 */
	public void setDatabasePath(final File dbpath) throws Exception {
		Element ds = (Element) this.getDatasource();
		logger.debug("ds=" + ds.getNodeName());
		ds.setAttribute("url", "jdbc:derby:" + dbpath + ";create=true");
	}
}
