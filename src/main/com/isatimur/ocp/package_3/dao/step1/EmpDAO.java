package com.isatimur.ocp.package_3.dao.step1;

import com.isatimur.ocp.package_2.ocp.enums.A;
import java.util.Collection;

/**
 * Created by tisachenko on 02.03.16.
 */
public interface EmpDAO {
    int create(Emp emp);

    Emp get(int id);

    boolean update(Emp e);

    boolean delete(Emp e);

    Collection<A> getAll();
}
