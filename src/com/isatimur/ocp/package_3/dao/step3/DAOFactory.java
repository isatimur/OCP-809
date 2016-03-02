package com.isatimur.ocp.package_3.dao.step3;

/**
 * Created by tisachenko on 02.03.16.
 */
public abstract class DAOFactory {

    public EmpDAO getEmpDAOInstance() {
        return getEmpDAO();
    }

    public DeptDAO getDeptDAOInstance() {

        return getDeptDAO();
    }

    protected abstract EmpDAO getEmpDAO();

    protected abstract DeptDAO getDeptDAO();


}
