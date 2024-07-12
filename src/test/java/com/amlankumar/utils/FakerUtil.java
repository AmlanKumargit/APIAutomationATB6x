package com.amlankumar.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    Faker faker = new Faker();

    public String GetFirstname(){
        return faker.name().firstName();
    }
    public String GetLastname(){
        return faker.name().firstName();
    }
}
