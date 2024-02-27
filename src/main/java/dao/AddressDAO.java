package dao;

import models.Address;

import java.util.List;

public interface AddressDAO extends DefaultDAO<Address, Integer>{
    List<Address> getByCountry(String country);
}
