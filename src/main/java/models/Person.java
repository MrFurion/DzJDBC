package models;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private List<Address> addresses;
}
