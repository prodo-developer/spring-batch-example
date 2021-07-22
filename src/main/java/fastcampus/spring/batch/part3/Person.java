package fastcampus.spring.batch.part3;

import lombok.Getter;

@Getter
public class Person {
    private int id;
    private String name;
    private String age;
    private String address;

    public Person(int id, String name, String age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
