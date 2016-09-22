package com.isatimur.ocp.package_3.dao.step3;

import java.util.Collection;

/**
 * Created by tisachenko on 02.03.16.
 */
public interface DeptDAO {
    int create(Dept dept);

    Dept get(int id);

    boolean update(Dept e);

    boolean delete(Dept e);

    Collection<Dept> getAll();
}

