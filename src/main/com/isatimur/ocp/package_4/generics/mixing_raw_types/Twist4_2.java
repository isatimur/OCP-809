package main.com.isatimur.ocp.package_4.generics.mixing_raw_types;

interface MyMap<K, V> {
    void put(K key, V value);

    V get(K key);
}

/**
 * Created by tisachenko on 11.03.16.
 */
public class Twist4_2 {
    public static void main(String[] args) {
        CustomMap map = new CustomMap<Integer, String>();
        map.put(new String("1"), "Selvan");
// won't compile because of object return type        String strVal = map.get(new Integer(1));
        //need to manually cast return type to String
        String strVal = map.get(new Integer(1)).toString();
        System.out.println(strVal);
    }
}

class CustomMap<K, V> implements MyMap<K, V> {
    K key;
    V value;

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public V get(K key) {
        return this.value;
    }
}
