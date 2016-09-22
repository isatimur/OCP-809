package main.com.isatimur.ocp.package_3.dao.step1;

/**
 * Created by tisachenko on 02.03.16.
 */
public class Client {
    public static void main(String args[]) {
        Emp emp = new Emp();
        emp.id = 10;
        emp.name = "Harry";
        emp.age = 39;
        emp.address = "UK";
        EmpDAO dao = new EmpDAOImpl();
        dao.create(emp);
        emp.name = "Harry M";
        emp.age = 40;
        dao.update(emp);
        Emp emp2 = dao.get(11);
        if (emp2 != null)
            dao.delete(emp2);
    }
}