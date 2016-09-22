package main.com.isatimur.ocp.package_3.dao.step2;

/**
 * Created by tisachenko on 02.03.16.
 */
public class Client {
    public static void main(String args[]) {

        EmpDAO dao = DAOFactory.getEmpDAOInstance(DAOFactory.ORACLE);

        Emp emp = new Emp();
        emp.id = 10;
        emp.name = "Harry";
        dao.create(emp);
    }
}