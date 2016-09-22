package main.com.isatimur.ocp.package_3.dao.step2;

import main.com.isatimur.ocp.package_2.ocp.enums.A;
import java.util.Collection;

/**
 * Created by tisachenko on 02.03.16.
 */
public class EmpDAOImpl implements EmpDAO {

    @Override
    public int create(Emp emp) {
        System.out.println("create");
        return 0;
    }

    @Override
    public Emp get(int id) {
        System.out.println("get" + id);
        return null;
    }

    @Override
    public boolean update(Emp e) {

        System.out.println("update");
        return false;
    }

    @Override
    public boolean delete(Emp e) {

        System.out.println("create");
        return false;
    }

    @Override
    public Collection<A> getAll() {
        return null;
    }
}
