package com.isatimur.ocp.package_3.dao.step3;

/**
 * Created by tisachenko on 02.03.16.
 */
public class MySQLDAOFacvtory extends DAOFactory{

    @Override
    protected EmpDAO getEmpDAO() {
        return new EmpDAOMySQLImpl();
    }

    @Override
    protected DeptDAO getDeptDAO() {
        return new DeptDAOMySQLImpl();
    }
}
