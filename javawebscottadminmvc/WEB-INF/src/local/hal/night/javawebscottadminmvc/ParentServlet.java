package local.hal.night.javawebscottadminmvc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

/*:
 * javaWebScottAdminMVC Sample Src01
 *
 * サーブレットの親クラス。
 * DB接続処理、切断処理などが書かれている。
 *
 */
public class ParentServlet extends HttpServlet{
	/**
	 * エラー画面JSPパス。
	 */
	protected static final String ERROR_JSP = "/error.jsp";

	/**
	 * データソース名。
	 */
	protected static final String DATASOURCE_NAME = "java:comp/env/javawebdb";

	/**
	 * データソースからConnectionオブジェクトを取得するメソッド。
	 *
	 * @return 取得したコネクションオブジェクト。
	 * @throws NamingException
	 * @throws SQLException
	 */
	protected Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup(DATASOURCE_NAME);
		Connection con = ds.getConnection();
		return con;
	}

	/**
	 * Connectionオブジェクトをクローズするメソッド。
	 *
	 * @param con クローズ対象のConnectionオブジェクト。
	 */
	protected void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println("DB接続切断中にSQLExceptionが発生しました：" + ex.getMessage());
			}
		}
	}

	/**
	 * トランザクションをコミットするメソッド。
	 *
	 * @param con コミット対象トランザクションのConnectionオブジェクト。
	 */
	protected void commit(Connection con) {
		if (con != null) {
			try {
				con.close();
				System.out.println("コミットしました。");
			} catch (SQLException ex) {
				System.out.println("コミット中にSQLExceptionが発生しました：" + ex.getMessage());
			}
		}
	}

	/**
	 * トランザクションをロールバックするメソッド。
	 *
	 * @param con ロールバック対象トランザクションのConnectionオブジェクト。
	 */
	protected void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
				System.out.println("ロールバックしました。");
			} catch (SQLException ex) {
				System.out.println("ロールバック中にSQLExceptionが発生しました：" + ex.getMessage());
			}
		}
	}
}
