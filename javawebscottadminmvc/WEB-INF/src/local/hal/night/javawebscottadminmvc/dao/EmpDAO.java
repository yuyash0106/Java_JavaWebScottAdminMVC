package local.hal.night.javawebscottadminmvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import local.hal.night.javawebscottadminmvc.entity.Dept;
import local.hal.night.javawebscottadminmvc.entity.Emp;
public class EmpDAO extends ParentDAO{
	/**
	 * コンストラクタ。
	 *
	 * @param con DBコネクションオブジェクト。
	 */
	public EmpDAO(Connection con) {
		super(con);
	}

	/**
	 * 主キーdeptnoによる検索。
	 *
	 * @param deptno 主キーであるdeptno。
	 * @return 該当するDeptオブジェクト。ただし、該当データがない場合はnull。
	 * @throws SQLException DBから発生する例外。
	 */
	public Emp findByPK(Integer empno) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Emp emp = null;

		String sql = "SELECT * FROM emp WHERE empno=?";

		try {
			stmt = _con.prepareStatement(sql);

			stmt.setInt(1, empno);

			rs = stmt.executeQuery();

			while (rs.next()) {
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");


				emp = new Emp();

				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setJob(job);
				emp.setMgr(mgr);
				emp.setHiredate(hiredate);
				emp.setSal(sal);
				emp.setComm(comm);
				emp.setDeptno(deptno);
			}
		} finally {
			close(rs);
			close(stmt);
		}

		return emp;
	}

	/**
	 * 全部門情報検索。
	 *
	 * @return 全部門情報が格納されたMapオブジェクト。キーは部門番号、値はDeptエンティティオブジェクト。
	 * @throws SQLException DBから発生する例外。
	 */
	public Map<Integer, Emp> findAll() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM emp ORDER BY empno";

		Map<Integer, Emp> resultList = new LinkedHashMap<>();
		try {
			stmt = _con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Integer mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				Integer deptno = rs.getInt("deptno");

				Emp emp = new Emp();

				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setJob(job);
				emp.setMgr(mgr);
				emp.setHiredate(hiredate);
				emp.setSal(sal);
				emp.setComm(comm);
				emp.setDeptno(deptno);

				resultList.put(empno, emp);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return resultList;
	}



	///////////////////////////////////////////////////////////////////////////////////////
	public Map<Integer,Emp> findMgr() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT empno,ename FROM emp ORDER BY empno";

		Map<Integer,Emp> resultListMgr = new LinkedHashMap<>();
		try {
			stmt = _con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Integer empno = rs.getInt("empno");
				String ename = rs.getString("ename");


				Emp emp = new Emp();


				emp.setEmpno(empno);
				emp.setEname(ename);


				resultListMgr.put(empno, emp);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return resultListMgr;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * 部門情報登録。
	 *
	 * @param dept 登録情報が格納されたDeptオブジェクト。
	 * @return 登録件数。
	 * @throws SQLException DBから発生する例外。
	 */
	public int insert(Emp emp) throws SQLException {
		PreparedStatement stmt = null;

		String sql = "INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		int result = 0;

		try {
			stmt = _con.prepareStatement(sql);

			stmt.setInt(1, emp.getEmpno());
			stmt.setString(2, emp.getEname());
			stmt.setString(3, emp.getJob());
			stmt.setInt(4, emp.getMgr());
			stmt.setDate(5, emp.getHiredate());
			stmt.setDouble(6, emp.getSal());
			stmt.setDouble(7, emp.getComm());
			stmt.setInt(8, emp.getDeptno());

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
	public int update(Emp emp) throws SQLException {
		PreparedStatement stmt = null;

		String sql = "UPDATE emp SET ename = ?,job = ?,mgr = ?,hiredate = ?,sal = ?,comm = ?,deptno = ? "
				+ "WHERE empno = ?";

		int result = 0;

		try {
			stmt = _con.prepareStatement(sql);

			stmt.setString(1, emp.getEname());
			stmt.setString(2, emp.getJob());
			stmt.setInt(3, emp.getMgr());
			stmt.setDate(4, emp.getHiredate());
			stmt.setDouble(5, emp.getSal());
			stmt.setDouble(6, emp.getComm());
			stmt.setInt(7, emp.getDeptno());
			stmt.setInt(8, emp.getEmpno());

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
	public int delete(Integer empno) throws SQLException {
		PreparedStatement stmt = null;

		String sql = "DELETE FROM emp WHERE empno=?";

		int result = 0;

		try {
			stmt = _con.prepareStatement(sql);
			stmt.setInt(1, empno);

			result = stmt.executeUpdate();
		} finally {
			close(stmt);
		}
		return result;
	}

	public Map<Integer, Dept> findDept() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT deptno,dname FROM dept ORDER BY deptno";

		Map<Integer, Dept> resultListDept = new LinkedHashMap<>();
		try {
			stmt = _con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");


				Dept dept = new Dept();

				dept.setDeptno(deptno);;
				dept.setDname(dname);

				resultListDept.put(deptno, dept);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return resultListDept;
	}
}
