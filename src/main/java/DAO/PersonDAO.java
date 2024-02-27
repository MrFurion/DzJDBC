package DAO;

import models.Person;

import java.util.List;

public interface PersonDAO extends DefaultDAO<Person, Integer> {
    List<Person> getAllWithAddress();

    List<Person> getByName(String name);

    List<Person> getByCountry(int country);
}
