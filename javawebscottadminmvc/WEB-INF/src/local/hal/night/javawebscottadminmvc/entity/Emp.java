package local.hal.night.javawebscottadminmvc.entity;

import java.sql.Date;

public class Emp {

	/**
	 * 従業員番号
	 */
	private Integer _empno;
	/**
	 * 従業員名
	 */
	private String _ename;
	/**
	 * 役職
	 */
	private String _job;
	/**
	 * 上司番号
	 */
	private Integer _mgr;
	/**
	 * 雇用日
	 */
	private Date _hiredate;
	/**
	 * 雇用日(年)
	 */
	private int _hiredateYear;
	/**
	 * 雇用日(月)
	 */
	private int _hiredateMonth;
	/**
	 * 雇用日(日)
	 */
	private int _hiredateDay;
	/**
	 * 給与
	 */
	private Double _sal;
	/**
	 * 歩合
	 */
	private Double _comm;
	/**
	 * 部門番号
	 */
	private Integer _deptno;

	//以下アクセサメソッド。

	public Integer getEmpno() {
		return _empno;
	}

	public void setEmpno(Integer empno) {
		_empno = empno;
	}

	public String getEname(){
		return _ename;
	}
	public void setEname(String ename) {
		_ename = ename;
	}

	public String getJob() {
		return _job;
	}
	public void setJob(String job) {
		_job = job;
	}

	public Integer getMgr() {
		return _mgr;
	}
	public void setMgr(Integer mgr) {
		_mgr = mgr;
	}

	public Date getHiredate() {
		return _hiredate;
	}
	public void setHiredate(Date hiredate) {
		_hiredate = hiredate;
	}

	public int getHiredateYear() {
		return _hiredateYear;
	}
	public void setHiredateYear(int hiredateYear) {
		_hiredateYear = hiredateYear;
	}
	public int getHiredateMonth() {
		return _hiredateMonth;
	}
	public void setHiredateMonth(int hiredateMonth) {
		_hiredateMonth = hiredateMonth;
	}
	public int getHiredateDay() {
		return _hiredateDay;
	}
	public void setHiredateDay(int hiredateDay) {
		_hiredateDay = hiredateDay;
	}

	public Double getSal() {
		return _sal;
	}
	public void setSal(Double sal) {
		_sal = sal;
	}

	public Double getComm() {
		return _comm;
	}
	public void setComm(Double comm) {
		_comm = comm;
	}

	public Integer getDeptno() {
		return _deptno;
	}

	public void setDeptno(Integer deptno) {
		_deptno = deptno;
	}

}
