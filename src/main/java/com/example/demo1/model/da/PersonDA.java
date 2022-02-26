package com.example.demo1.model.da;


import com.example.demo1.Utils.BaseDA;
import com.example.demo1.model.to.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonDA extends BaseDA<Person> {

    public PersonDA() {
        table = "person";
        primaryKey = "id";
        fields = new ArrayList<>(Arrays.asList("id", "name", "number"));
        gaurd = new ArrayList<>(Arrays.asList("id"));
    }

    @Override
    protected Connection createConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
    }

    @Override
    protected Person newInstance() {
        return new Person();
    }

    public ArrayList<Person> searchByName(String name) throws Exception {
        Connection connection = createConnection();
        ArrayList<Person> people = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from " + table + " where name like ?");
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt(1));
            person.setName(resultSet.getString(2));
            person.setNumber(resultSet.getString(3));
            people.add(person);
        }
        closeConnection(connection);
        return people;
    }

    public ArrayList<Person> searchByNumber(String number) throws Exception {
        Connection connection = createConnection();
        ArrayList<Person> people = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from " + table + " where number = ?");
        statement.setString(1, number);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt(1));
            person.setName(resultSet.getString(2));
            person.setNumber(resultSet.getString(3));
            people.add(person);
        }
        closeConnection(connection);
        return people;
    }

    public void deleteById(int id) throws Exception {
        Connection connection = createConnection();
        PreparedStatement st = connection.prepareStatement("delete from person where " + primaryKey + "=?");
        st.setInt(1, id);
        st.executeUpdate();
        closeConnection(connection);
    }
}
