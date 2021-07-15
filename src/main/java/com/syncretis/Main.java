package com.syncretis;

import com.syncretis.model.Auto;
import com.syncretis.model.House;
import com.syncretis.model.Person;
import com.syncretis.util.Parser;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,  IllegalAccessException, InstantiationException, InvocationTargetException {
        Parser parser = new Parser();

        Person person = new Person("Olya", 456l);
        House house = new House(12, "TSK");
        Auto auto = new Auto("Red", "BMW");

        Map<String, String> parserMap = parser.parseObjectToMap(auto);

        for (Map.Entry<String, String> entry : parserMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("================================");

        Object person1 =  parser.perseMapToObject(parserMap, Auto.class);
        System.out.println(person1);

    }
}
