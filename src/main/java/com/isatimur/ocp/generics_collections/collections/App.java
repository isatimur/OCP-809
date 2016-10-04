package com.isatimur.ocp.generics_collections.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class App {

    public static final class City {
        public long countryId;
        public long regionId;

        public City(long countryId, long regionId) {
            this.countryId = countryId;
            this.regionId = regionId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            City city = (City) o;

            if (countryId != city.countryId) return false;
            return regionId == city.regionId;

        }

        @Override
        public int hashCode() {
            int result = (int) (countryId ^ (countryId >>> 32));
            result = 31 * result + (int) (regionId ^ (regionId >>> 32));
            return result;
        }
    }

    public static void main(String[] args) {

        Set s = new LinkedHashSet<City>();
        s.add(new City(1, 1));
        s.add(new City(1, 2));
        s.add(new City(2, 1));
        s.add(new City(1, 1));

        System.out.println(s.size());
    }

}