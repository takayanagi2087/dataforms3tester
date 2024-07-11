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
 * tomcat-users.xmlファイルのクラス。
 *
 */
public class TomcatUsersXml extends BaseXml {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LogManager.getLogger(TomcatUsersXml.class);
	

/*	private static String XML = """
			<role rolename="admin-gui"/>
			<role rolename="admin-script"/>
			<role rolename="manager-gui"/>
			<role rolename="manager-script"/>
			<user username="admin" password="admin" roles="admin-gui,admin-script,manager-gui,manager-script"/>
			""";
*/	
	/**
	 * コンストラクタ。
	 * @param xml web.xmlのファイル。
	 * @throws Exception 例外。
	 */
	public TomcatUsersXml(final File xml) throws Exception {
		super(xml);
	}

	/**
	 * roleのノードを取得する。
	 * @param name roleの名称。
	 * @return roleのノード。
	 * @throws Exception 例外。
	 */
	public Node getRole(final String name) throws Exception {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = this.getDocument();
		Node ret = (Node) xpath.evaluate("//role[@rolename='" + name + "']", doc, XPathConstants.NODE);
		logger.debug("node=" + ret);
		return ret;
	}
	
	/**
	 * ロールノードを作成します。
	 * @param name ロールの名称。
	 * @return 追加したノード。
	 * @throws Exception 例外。
	 */
	public Node createRoleNode(final String name) throws Exception {
		Document doc = this.getDocument();
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node root = (Node) xpath.evaluate("/tomcat-users", doc, XPathConstants.NODE);
		Element role = doc.createElement("role");
		role.setAttribute("rolename", name);
		root.appendChild(role);
		return role;
	}
	
	/**
	 * ロールノードを追加します。
	 * @param name ロール名。
	 * @return ロールノード。
	 * @throws Exception 例外。
	 */
	public Node addRole(final String name) throws Exception {
		Node node = this.getRole(name);
		if (node == null) {
			node = this.createRoleNode(name);
		}
		return node;
	}
	

	/**
	 * roleのノードを取得する。
	 * @param name roleの名称。
	 * @return roleのノード。
	 * @throws Exception 例外。
	 */
	public Node getUser(final String name) throws Exception {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = this.getDocument();
		Node ret = (Node) xpath.evaluate("//user[@username='" + name + "']", doc, XPathConstants.NODE);
		logger.debug("user=" + ret);
		return ret;
	}

	/**
	 * ユーザのノードを作成する。
	 * @param name ユーザの名称。
	 * @param password パスワード。
	 * @param roles ロールリスト。
	 * @return 作成したノード。
	 * @throws Exception 例外。
	 */
	public Node createUserNode(final String name, final String password, final String roles) throws Exception {
		Document doc = this.getDocument();
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node root = (Node) xpath.evaluate("/tomcat-users", doc, XPathConstants.NODE);
		Element role = doc.createElement("user");
		role.setAttribute("username", name);
		role.setAttribute("password", password);
		role.setAttribute("roles", roles);
		root.appendChild(role);
		return role;
	}

	/**
	 * ユーザのノードを追加します。
	 * @param name ユーザ名。
	 * @param password パスワード。
	 * @param roles ロールリスト。
	 * @return 作成したノード。
	 * @throws Exception 例外。
	 */
	public Node addUser(final String name, final String password, final String roles) throws Exception {
		Node node = this.getUser(name);
		if (node == null) {
			node = this.createUserNode(name, password, roles);
		}
		return node;
	}
	
}
