package com.neogiciel;

import com.neogiciel.model.A;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;


@Path("/")
public class HomeController {

    //Classe A
    @Inject
    //@Context
    A a; 

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
       String display = a.get();
       return display;
       //return "test";
       
    }


    
       
}
