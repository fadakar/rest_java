package com.example.demo1;

import jakarta.ws.rs.*;

@Path("/hello")
public class HelloResource {
    @GET
    @Path("/")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    @GET
    @Path("say")
    @Produces("text/plain")
    public String person() {
        return "say hello";
    }


    @GET
    @Path("show")
    @Produces("text/plain")
    public String edit(@QueryParam("id") int id, @QueryParam("name") String name) {
        return "show[ " + id + " ]: " + name;
    }

    @GET
    @Path("edit/{id}")
    @Produces("text/plain")
    public String edit(@PathParam("id") int id) {
        return "edit: " + id;
    }


    @GET
    @Path("person")
    @Produces("application/json")
    public Person getPerson() {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("reza");
        person.setLastName("fadakar");
        return person;
    }
}