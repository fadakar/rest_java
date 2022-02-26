package com.example.demo1.model.bl;


import com.example.demo1.model.da.PersonDA;
import com.example.demo1.model.to.Person;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersonBL {

    private PersonDA personDA = new PersonDA();

    public ArrayList<Person> all() throws Exception {
        return (ArrayList<Person>) personDA.all()
                .stream()
                .collect(Collectors.toList());
    }

    public Person find(int id) throws Exception {
        return personDA.find(id);
    }

    public Person add(Person person) throws Exception {
        return personDA.add(person);
    }

    public Person update(Person person) throws Exception {
        return personDA.update(person);
    }

    public void delete(int id) throws Exception {
        personDA.deleteById(id);
    }

    public ArrayList<Person> searchByName(String name) throws Exception {
        return personDA.searchByName(name);
    }

    public ArrayList<Person> searchByNumber(String number) throws Exception {
        return personDA.searchByNumber(number);
    }
}
