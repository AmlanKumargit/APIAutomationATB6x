package com.amlankumar.tests.Parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass2 {

    @BeforeMethod
    public void BeforeMethod2(){
        long id = Thread.currentThread().getId();
        System.out.println("Before Test Method. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod21(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod22(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod23(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod24(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod25(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @AfterMethod
    public void AfterMethod2(){
        long id = Thread.currentThread().getId();
        System.out.println("After Test Method. Thread id:" +id+'\n'+ getClass());
    }
}
