package com.company.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Juan Montaño
 */
public class StreamPrueba {

    private static List<User> users;

    public static void main(String[] args) {
        setUpUser();
        Stream.of(users);
        users.stream();
        //forEach
        users.stream().forEach(user -> user.setName(user.getName() + " Apellido"));
        imprimirLista();

        //Map Collector.toList
        List<String> list = users.stream().map(user -> user.getName()).collect(Collectors.toList());
        list.stream().forEach(userName -> System.out.println(userName));
    }

    private static void imprimirLista() {
        users.stream().forEach(user -> System.out.println(user.getId() + " " + user.getName()));
    }

    private static void setUpUser() {
        users = new ArrayList<>();

        users.add(new User(1, "Alberto"));
        users.add(new User(2, "Marta"));
        users.add(new User(3, "Maria"));
        users.add(new User(4, "Pablo"));
        users.add(new User(5, "Adolfo"));
        users.add(new User(6, "Alberto"));
    }
}
