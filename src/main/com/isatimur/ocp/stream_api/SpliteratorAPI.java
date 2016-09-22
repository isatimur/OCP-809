package main.com.isatimur.ocp.stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by dns2 on 05.07.2016.
 */
public class SpliteratorAPI {
    public static void main(String[] args) {
        Path filePath = Paths.get("people.txt");

        try (Stream<String> lines = Files.lines(filePath);) {

            Spliterator<String> lineSliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSliterator);

            Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);

            people.forEach(System.out::println);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Person {
    private String name;
    private int age;
    private String city;

    public Person() {
    }

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", city='" + city + '\'' +
            '}';
    }
}