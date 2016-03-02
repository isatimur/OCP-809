package com.isatimur.ocp.package_3.dao.step2;

/**
 * Created by tisachenko on 02.03.16.
 */
public abstract class DAOFactory {
    public static int ORACLE = 1;
    public static int MYSQL = 2;

    public static EmpDAO getEmpDAOInstance(int DBType) {
        EmpDAO dao = null;
        if (DBType == ORACLE) {
            dao = new EmpDAOOracleImpl();
        } else if (DBType == MYSQL) {
            dao = new EmpDAOMySQLImpl();
        }
        return dao;
    }

}
