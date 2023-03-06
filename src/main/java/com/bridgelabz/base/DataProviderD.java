package com.bridgelabz.base;

import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;

public class DataProviderD {
    @DataProvider(name = "dataProvider")
    public static Object[][] getDataForTestExecution(Method m){
        if(m.getName().equalsIgnoreCase("webinarScreen"))
        {return  new Object[][]{
                {"67878744","abc@yopmail.com"},
                {"678647867","xyz@yopmail.com"},
                {"8989897","yh@yopmail.com"},
                {"703805368","test@yopmail.com"}
        };
        }
        else {
            return  new Object[][]{
                    {"abc@yopmail.com"},
                    {"xyz@yopmail.com"},
                    {"yh@yopmail.com"},
                    {"test@yopmail.com"}
            };
        }
    }
}
