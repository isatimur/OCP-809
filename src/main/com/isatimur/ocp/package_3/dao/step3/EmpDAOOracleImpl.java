package main.com.isatimur.ocp.package_3.dao.step3;

import java.util.Collection;

/**
 * Created by tisachenko on 02.03.16.
 */
public class EmpDAOOracleImpl implements EmpDAO {
    @Override
    public int create(Emp emp) {
        System.out.println("EmpDAOOracleImpl");
        return 0;
    }

    @Override
    public Emp get(int id) {
        return null;
    }

    @Override
    public boolean update(Emp e) {
        return false;
    }

    @Override
    public boolean delete(Emp e) {
        return false;
    }

    @Override
    public Collection<Emp> getAll() {
        return null;
    }
}
