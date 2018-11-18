package com.resteady.tdd.examples.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rameshdev.resteasy.ResteasyResource;
import com.github.rameshdev.resteasy.ResteasyServer;
import com.github.rameshdev.resteasy.ResteasyUnit;
import com.resteady.tdd.examples.User;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class UserApiTest {


    @Test
    public void getUserById_200_test() throws  IOException {

        ResteasyServer server     = ResteasyUnit.newServer(UserApi.class);

        ResteasyResource resource = server.resource("/v1/api/user?id=1233433321");

        MockHttpResponse response   = resource.get();

        System.out.println("response : "+response.getContentAsString());

        User user =  new ObjectMapper().readValue( response.getContentAsString(), User.class);

        Assert.assertEquals(200, response.getStatus());

        Assert.assertEquals("1233433321",user.getId());

    }


    @Test
    public void getUserById_400_test() throws  IOException {

        ResteasyServer server     = ResteasyUnit.newServer(UserApi.class);

        ResteasyResource resource = server.resource("/v1/api/user");

        MockHttpResponse response   = resource.get();

        System.out.println("response : "+response.getContentAsString());

        Assert.assertEquals(400, response.getStatus());

        Assert.assertEquals("Invalid userId",response.getContentAsString());

    }







}
