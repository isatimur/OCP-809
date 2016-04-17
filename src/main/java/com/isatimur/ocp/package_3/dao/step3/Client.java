package com.isatimur.ocp.package_3.dao.step3;

/**
 * Created by tisachenko on 02.03.16.
 */
public class Client {
    public static void main(String args[]) {

        DAOFactory factory = new OracleDAOFactory();
        EmpDAO dao = factory.getEmpDAOInstance();

        Emp emp = new Emp();
        emp.id = 10;
        emp.name = "Harry";

        dao.create(emp);

        DeptDAO deptDao = factory.getDeptDAOInstance();

        Dept dept = new Dept();
        dept.deptNo = 11;
        dept.departmentName = "Krasnodar's Department";
        deptDao.update(dept);
    }
}