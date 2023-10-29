package org.acme;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "name")
    public String name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hola xGeek!";
    }

    @GET
    @Path("/greeting")
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return "Kube Native Java with " + this.name;
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> listAll() {
        return Person.listAll();
    }

    @GET
    @Path("/person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person findById(@PathParam("id") Long id) {
        return Person.findById(id);
    }

}
