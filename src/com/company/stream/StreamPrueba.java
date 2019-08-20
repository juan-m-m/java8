package com.company.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        System.out.println("------------------------------min max ------------------------");

        User userMin = users.stream()
                .min(Comparator.comparing(User::getId))
                .orElse(null);
        System.out.println(userMin.getId());

        User userMax = users.stream()
                .max(Comparator.comparing(User::getId))
                .orElse(null);
        System.out.println(userMax.getId());

        System.out.println("------------------------------distint------------------------");
        String[] abc1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "a", "c"};

        List<String> listDistint = Arrays.stream(abc1)
                .distinct()
                .collect(Collectors.toList());
        listDistint.stream().forEach(e -> System.out.println(e));

        System.out.println("------------------------------allMach anyMach noneMach------------------------");
        List<Integer> listNumeros = Arrays.asList(100, 300, 900, 5000);

        boolean allMach = listNumeros.stream().allMatch(e -> e > 301);
        System.out.println(allMach);

        boolean anyMach = listNumeros.stream().anyMatch(e -> e > 301);
        System.out.println(anyMach);

        boolean noneMach = listNumeros.stream().noneMatch(e -> e > 10000);
        System.out.println(noneMach);

        System.out.println("------------------------------sum average range------------------------");
        double result = users.stream()
                .mapToInt(User::getId)
                .average()
                .orElse(0);
        System.out.println(result);
        result = users.stream()
                .mapToInt(User::getId)
                .sum();
        System.out.println(result);
        System.out.println(IntStream.range(0, 100).sum());

        System.out.println("------------------------------Reduce------------------------");
        setUpUser();
        int numero = users.stream()
                .map(User::getId)
                .reduce(100, Integer::sum);
        System.out.println(numero);

        System.out.println("------------------------------joining------------------------");
        setUpUser();
        String names = users.stream()
                .map(User::getName)
                .collect(Collectors.joining(" - "))
                .toString();
        System.out.println(names);
        System.out.println("------------------------------ toSet ------------------------");
        Set<String> setNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toSet());
        setNames.stream().forEach(e -> System.out.println(e));

        System.out.println("------------------------------ summarizingDouble------------------------");
        setUpUser();
        DoubleSummaryStatistics statistics = users.stream()
                .collect(Collectors.summarizingDouble(User::getId));
        System.out.println(statistics.getAverage() + " " + statistics.getMax() + " " + statistics.getMin() + " " + statistics.getCount());

        DoubleSummaryStatistics statistics1 = users.stream()
                .mapToDouble(User::getId)
                .summaryStatistics();
        System.out.println(statistics.getAverage() + " " + statistics.getMax() + " " + statistics.getMin() + " " + statistics.getCount());
        System.out.println(statistics.getAverage() + " " + statistics.getMax() + " " + statistics.getMin() + " " + statistics.getCount());

        System.out.println("------------------------------ partitioningBy------------------------");
        setUpUser();
        List<Integer> numeros = Arrays.asList(5, 7, 34, 56, 2, 3, 67, 4, 98);
        Map<Boolean, List<Integer>> esMayor = numeros.stream()
                .collect(Collectors.partitioningBy(e -> e > 10));
        esMayor.get(true).stream().forEach(e -> System.out.println(e));
        esMayor.get(false).stream().forEach(e -> System.out.println(e));
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
