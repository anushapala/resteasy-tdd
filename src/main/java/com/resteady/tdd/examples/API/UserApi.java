package com.resteady.tdd.examples.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resteady.tdd.examples.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/v1/api")
public class UserApi {

    @GET
    @Path("/user")
    public Response getUserById(@QueryParam("id") String userId){

        try{

            System.out.println(" userId : "+userId);
            if( userId == null){
                throw new IllegalArgumentException("Invalid userId");
            }


            User userInfo   =   User.getByID( userId );

            System.out.println(" userInfo : "+userInfo.toString());

            return Response.ok( new ObjectMapper().writeValueAsString(userInfo)).build();

        }catch (Exception e){
            System.out.println("message : "+e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity( e.getMessage()).build();

        }

    }

}
