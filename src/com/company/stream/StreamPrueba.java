package com.company.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        //filter
        setUpUser();
        List<User> userFilter = users.stream()
                .filter(user -> user.getName() != "Alberto")
                .filter(user -> user.getId() < 3)
                .collect(Collectors.toList());
        userFilter.stream().forEach(user -> System.out.println(user.getId() + " " + user.getName()));

        System.out.println("------------------------------find first ------------------------");
        setUpUser();
        User user = users.stream()
                .filter(user1 -> user1.getName().equals("Alberto"))
                .findFirst()
                .orElse(null);
        System.out.println(user.getId() + " " + user.getName());

        //flatMap

        List<List<String>> nombresVariasListas = new ArrayList<List<String>>(
                Arrays.asList(
                        new ArrayList<String>(Arrays.asList("Alberto", "Maria", "Pedro")),
                        new ArrayList<String>(Arrays.asList("Monica", "Pablo"))
                )
        );
        List<String> nombreUnicaLista = nombresVariasListas.stream()
                .flatMap(lista -> lista.stream())
                .collect(Collectors.toList());
        nombreUnicaLista.stream().forEach(listunica -> System.out.println(listunica));

        System.out.println("------------------------------peek ------------------------");
        List<User> users2 = users.stream()
                .peek(user1 -> user1.setName(user1.getName() + " " + "apellido")).collect(Collectors.toList());
        users2.stream().forEach(user1 -> System.out.println(user1.getName()));

        System.out.println("------------------------------count------------------------");
        long numeroFiltrado = users.stream()
                .filter(user1 -> user1.getId() < 3)
                .count();
        System.out.println(numeroFiltrado);
        System.out.println("------------------------------skip and limit ------------------------");

        String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};

        List<String> abcFilter = Arrays.stream(abc)
                .skip(2)
                .limit(4)
                .collect(Collectors.toList());
        abcFilter.stream().forEach(e -> System.out.println(e));

        System.out.println("------------------------------sorted ------------------------");

        setUpUser();
        users = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
        imprimirLista();


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
