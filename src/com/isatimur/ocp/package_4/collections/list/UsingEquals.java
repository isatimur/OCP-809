package com.isatimur.ocp.package_4.collections.list;

import java.util.ArrayList;

/**
 * Created by tisachenko on 11.03.16.
 */
public class UsingEquals {
    public static void main(String[] args) {
        ArrayList<Emp> list = new ArrayList<>();
        list.add(new Emp(121,"Max"));
        list.add(new Emp(55,"Tolik"));
        list.add(new Emp(15,"Toha"));
        list.add(new Emp(121,"Max"));
        System.out.println(list.size());

        Emp emp = new Emp(121,"Max");
        list.remove(emp);

        System.out.println(list.size());

    }


}

class Emp {
    int id;
    String name;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Emp){
            Emp emp = (Emp) o;
            if(emp.id == this.id && emp.name.equals(this.name)){
                return true;
            }
        }
        return false;

//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Emp emp = (Emp) o;
//
//        if (id != emp.id) return false;
//        return name.equals(emp.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}