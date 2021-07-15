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

        Map<String, String> personMap = parser.parseObjectToMap(person);
        Map<String, String> houseMap = parser.parseObjectToMap(house);
        Map<String, String> autoMap = parser.parseObjectToMap(auto);

        for (Map.Entry<String, String> entryPerson : personMap.entrySet()) {
            System.out.print(entryPerson + " ");
        }
        System.out.println();
        for (Map.Entry<String, String> entryHouse : houseMap.entrySet()) {
            System.out.print(entryHouse + " ");
        }

        System.out.println();
        for (Map.Entry<String, String> entryAuto : autoMap.entrySet()) {
            System.out.print(entryAuto + " ");
        }
        System.out.println();
        System.out.println("================================");

        Object personInstance =  parser.perseMapToObject(personMap, Person.class);
        Object houseInstance =  parser.perseMapToObject(houseMap, House.class);
        Object autoInstance =  parser.perseMapToObject(autoMap, Auto.class);
        System.out.println(personInstance);
        System.out.println(houseInstance);
        System.out.println(autoInstance);

    }
}
