package com.isatimur.ocp.package_3.dao.step3;

import java.util.Collection;

/**
 * Created by tisachenko on 02.03.16.
 */
public interface EmpDAO {
    int create(Emp emp);

    Emp get(int id);

    boolean update(Emp e);

    boolean delete(Emp e);

    Collection<Emp> getAll();
}
