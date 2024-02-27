import dao.Impl.PersonDaoImpl;
import dao.PersonDAO;
import models.Person;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDaoImpl();
        Person person = new Person();
        person.setName("Jerry");
        person.setAge(2020);
        personDAO.save(person);

        System.out.println(personDAO.getAll());
    }
}
