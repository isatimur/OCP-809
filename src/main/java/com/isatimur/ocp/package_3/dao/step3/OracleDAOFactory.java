package com.isatimur.ocp.package_3.dao.step3;

/**
 * Created by tisachenko on 02.03.16.
 */
public class OracleDAOFactory extends DAOFactory {

    protected EmpDAO getEmpDAO() {
        return new EmpDAOOracleImpl();
    }

    protected DeptDAO getDeptDAO() {
        return new DeptDAOOracleImpl();
    }
}
