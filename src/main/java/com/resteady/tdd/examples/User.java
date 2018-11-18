package com.resteady.tdd.examples;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private String emailId;
    private String phone;

    private static  String toString( User user){

        String resp = "User details \n id : "+user.getId()+"\n emailId : "+user.getEmailId()+"\n name : "+user.getName()+"\n phone : "+user.getPhone();

        return resp;
    }

    public static  User getByID(String id){

        User user = new User();

        user.setId(id);
        user.setEmailId("user1@gmail.com");
        user.setName("user1");
        user.setPhone("9098789832");

        return user;
    }
}
