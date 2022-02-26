package com.example.demo1;

import jakarta.ws.rs.*;

@Path("person")
public class PersonResource {

    @GET
    @Path("show")
    @Produces("application/json")
    public Person show() {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("reza");
        person.setLastName("fadakar");
        return person;
    }


    @GET
    @Path("store")
    @Produces("application/json")
    public Person store(
            @QueryParam("id") int id,
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName
    ) {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }


    @GET
    @Path("cal/{number1}/{number2}")
    @Produces("text/plane")
    public String cal(@PathParam("number1") int number1, @PathParam("number2") int number2) {
        Integer sum = number1 + number2;
        return sum.toString();
    }
}
