package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
       final List<Person> persons = new ArrayList<>();
        persons.add(new Person("Гоша","Савченко", 20, Sex.MAN, Education.FURTHER ));
        persons.add(new Person("Вася","Пупкин", 17, Sex.MAN, Education.SECONDARY ));
        persons.add(new Person("Ольга","Паршина", 31, Sex.WOMAN, Education.ELEMENTARY ));
        persons.add(new Person("Коля","Лаврушкин", 10, Sex.MAN, Education.ELEMENTARY ));
        persons.add(new Person("Жанна","Хохлова", 22, Sex.WOMAN, Education.HIGHER ));
        persons.add(new Person("Вася","Медведкин", 18, Sex.MAN, Education.FURTHER ));
        persons.add(new Person("Галина","Петровна", 71, Sex.WOMAN, Education.HIGHER ));

            long count = persons.stream()
                    .filter(value-> value.getAge() < 18)
                    .count();
            System.out.println("меньше 18: " +count);

             persons.stream()
                    .filter(x-> x.getAge() >= 18)
                     .filter(x-> x.getSex() == Sex.MAN)
                    .map(x-> x.getFamily() + ": готов служить родине")
                    .forEach(System.out::println);

             List<Person> y = persons.stream()
                     .filter(x-> x.getAge() > 18)
                     .filter(x-> x.getEducation() == Education.HIGHER)
                     .sorted(Comparator.comparing(Person::getFamily))
                     .collect(Collectors.toList());
             System.out.println(y);
        }
    }

