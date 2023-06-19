package local.hal.night.javawebscottadminmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JavaWebScottAdminMVC Sample Src03
 *
 * DAOクラスの親クラス。
 * @author yuyas
 *
 */
public class ParentDAO {
	/**
	 * DBコネクションオブジェクト。
	 */
	protected Connection _con;

	/**
	 * コンストラクタ。
	 *
	 * @param con DBコネクションオブジェクト。
	 */
	public ParentDAO(Connection con) {
		_con = con;
	}

	/**
	 * PreparedStatementオブジェクトをクローズするメソッド。
	 *
	 * @param ps クローズ対象のPreparedStatementオブジェクト。
	 */
	protected void close(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			}
			catch(SQLException ex) {
				System.out.println("Statementオブジェクト切断中にSQLExceptionが発生しました。：" + ex.getMessage());
			}
		}
	}

	/**
	 * ResultSetオブジェクトをクローズするメソッド。
	 *
	 * @param rs クローズ対象のResultSetオブジェクト。
	 */
	protected void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch(SQLException ex) {
				System.out.println("ResultSetオブジェクト切断中にSQLExceptionが発生しました。：" + ex.getMessage());
			}
		}
	}
}
