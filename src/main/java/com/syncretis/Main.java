package com.syncretis;

import com.syncretis.annotation.FieldName;
import com.syncretis.model.Auto;
import com.syncretis.model.House;
import com.syncretis.model.Person;
import com.syncretis.util.Parser;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {

        Parser parser = new Parser();

        Person person = new Person("Olya", 456l);
        House house = new House(12, "TSK");
        Auto auto = new Auto("Red", "BMW");

        Map<String, String> parserMap = parser.parseObjectToMap(auto);

        for (Map.Entry<String, String> entry : parserMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("================================");

        Object person1 = parser.perseMapToObject(parserMap, Person.class);
        System.out.println(person1);

//        Field[] fields = person.getClass().getDeclaredFields();
//        FieldName fieldName  =  fields[0].getDeclaredAnnotation(FieldName.class);
//
//        System.out.println(fields[0].getName());


//        Class<Person> personClass = Person.class;
//        Field[] fields = person.getClass().getDeclaredFields();
//        fields[0].setAccessible(true);
//        FieldName annotation = fields[0].getDeclaredAnnotation(FieldName.class);

//        Annotation annotation = personClass.getDeclaredAnnotation(FieldName.class);
//        System.out.println(annotation);
    }
}
