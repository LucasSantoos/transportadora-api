/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.transportes.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author lucas
 */
@Path("hello")
public class HelloWorldResource {
    
    @GET
    public String helloWorld()  {
        return "Hello World Java Web Services!";
    }
    
}
