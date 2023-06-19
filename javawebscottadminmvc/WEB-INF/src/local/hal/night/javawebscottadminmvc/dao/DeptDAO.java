package local.hal.night.javawebscottadminmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import local.hal.night.javawebscottadminmvc.entity.Dept;

/**
 * JavaWebScottAdminMVC Sample Src07
 *
 * deptテーブルへのデータ操作クラス。
 * @author yuyas
 *
 */

public class DeptDAO extends ParentDAO {
	/**
	 * コンストラクタ。
	 *
	 * @param con DBコネクションオブジェクト。
	 */
	public DeptDAO(Connection con) {
		super(con);
	}

	/**
	 * 主キーdeptnoによる検索。
	 *
	 * @param deptno 主キーであるdeptno。
	 * @return 該当するDeptオブジェクト。ただし、該当データがない場合はnull。
	 * @throws SQLException DBから発生する例外。
	 */
	public Dept findByPK(Integer deptno) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Dept dept = null;

		String sql = "SELECT * FROM dept WHERE deptno=?";

		try {
			stmt = _con.prepareStatement(sql);

			stmt.setInt(1, deptno);

			rs = stmt.executeQuery();

			while (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				dept = new Dept();

				dept.setDeptno(deptno);
				dept.setDname(dname);
				dept.setLoc(loc);
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return dept;
	}

	/**
	 * 全部門情報検索。
	 *
	 * @return 全部門情報が格納されたMapオブジェクト。キーは部門番号、値はDeptエンティティオブジェクト。
	 * @throws SQLException DBから発生する例外。
	 */
	public Map<Integer, Dept> findAll() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM dept ORDER BY deptno";

		Map<Integer, Dept> resultList = new LinkedHashMap<>();
		try {
			stmt = _con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				Dept dept = new Dept();
				dept.setDeptno(deptno);
				dept.setDname(dname);
				dept.setLoc(loc);

				resultList.put(deptno, dept);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return resultList;
	}

	/**
	 * 部門情報登録。
	 *
	 * @param dept 登録情報が格納されたDeptオブジェクト。
	 * @return 登録件数。
	 * @throws SQLException DBから発生する例外。
	 */
	public int insert(Dept dept) throws SQLException {
		PreparedStatement stmt = null;

		String sql = "INSERT INTO dept (deptno,dname,loc) VALUES (?,?,?)";

		int result = 0;

		try {
			stmt = _con.prepareStatement(sql);

			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());

			result = stmt.executeUpdate();
		} finally {
			close(stmt);
		}
		return result;
	}

	/**
	 * 部門情報更新。更新対象は１レコードのみ。
	 *
	 * @param dept　更新情報が格納されたDeptオブジェクト。主キーがこのオブジェクトのdeptnoの値のレコードを更新する。
	 * @return 更新件数。
	 * @throws SQLException DBから発生する例外。
	 */
	public int update(Dept dept) throws SQLException {
		PreparedStatement stmt = null;

		String sql = "UPDATE dept SET dname = ?,loc = ? WHERE deptno = ?";

		int result = 0;

		try {
			stmt = _con.prepareStatement(sql);

			stmt.setString(1, dept.getDname());
			stmt.setString(2, dept.getLoc());
			stmt.setInt(3, dept.getDeptno());

			result = stmt.executeUpdate();
		} finally {
			close(stmt);
		}
		return result;
	}

	/**
	 * 部門情報削除。削除対象は１レコードのみ。
	 *
	 * @param deptno 削除対象の主キー。
	 * @return 削除件数。
	 * @throws SQLException DBから発生する例外
	 */
	public int delete(Integer deptno) throws SQLException {
		PreparedStatement stmt = null;

		String sql = "DELETE FROM dept WHERE deptno=?";

		int result = 0;

		try {
			stmt = _con.prepareStatement(sql);
			stmt.setInt(1, deptno);

			result = stmt.executeUpdate();
		} finally {
			close(stmt);
		}
		return result;
	}
}
