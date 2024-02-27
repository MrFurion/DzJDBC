package DAO.Impl;
import Connection.DataSource;
import DAO.PersonDAO;
import models.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDAO {
    public void save(Person person){
        Connection connection = DataSource.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement("insert into person(name, age) values (?, ?)")){
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Person entity) {

    }

    @Override
    public void delete(Person entity) {

    }

    @Override
    public List<Person> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Person> person = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("select * from person")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Person person1 = new Person();
                person1.setId(resultSet.getInt("id"));
                person1.setName(resultSet.getString("name"));
                person1.setAge(resultSet.getInt("age"));

                person.add(person1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person getById(Integer id) {
        return null;
    }

    @Override
    public List<Person> getAllWithAddress() {
        return null;
    }

    @Override
    public List<Person> getByName(String name) {
        return null;
    }

    @Override
    public List<Person> getByCountry(int country) {
        return null;
    }
}
