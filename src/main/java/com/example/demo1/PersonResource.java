package com.example.demo1;

import com.example.demo1.model.bl.PersonBL;
import com.example.demo1.model.da.PersonDA;
import com.example.demo1.model.to.Person;
import jakarta.ws.rs.*;

import java.util.ArrayList;

@Path("person")
public class PersonResource {


    private PersonBL personBL = new PersonBL();

    @GET
    @Path("/")
    @Produces("application/json")
    public ArrayList<Person> index() throws Exception {
        return personBL.all();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Person show(@PathParam("id") int id) throws Exception {
        return personBL.find(id);
    }


    @POST
    @Path("/")
    @Produces("application/json")
    public Person store(
            @QueryParam("name") String name,
            @QueryParam("number") String number
    ) throws Exception {
        Person person = new Person();
        person.setName(name);
        person.setNumber(number);
        personBL.add(person);
        return person;
    }

    @PUT
    @Path("{id}")
    @Produces("application/json")
    public Person update(
            @PathParam("id") int id,
            @QueryParam("name") String name,
            @QueryParam("number") String number
    ) throws Exception {
        Person person = personBL.find(id);
        person.setName(name);
        person.setNumber(number);
        return personBL.update(person);
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public void delete(@PathParam("id") int id) throws Exception {
        PersonBL personBL = new PersonBL();
        personBL.delete(id);
    }


}
