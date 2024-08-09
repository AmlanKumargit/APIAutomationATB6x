package com.amlankumar.tests.Parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {

    @BeforeMethod
    public void BeforeMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("Before Test Method. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod1(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod2(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod3(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod4(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @Test
    public void TestMethod5(){
        long id = Thread.currentThread().getId();
        System.out.println("Test Method1. Thread id:" +id+'\n'+ getClass());
    }
    @AfterMethod
    public void AfterMethod1(){
        long id = Thread.currentThread().getId();
        System.out.println("After Test Method. Thread id:" +id+'\n'+ getClass());
    }
}
