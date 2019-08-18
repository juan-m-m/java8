package com.company;

import java.util.Optional;

/**
 * @author Juan Montaño
 */
public class OptionalPrueba {

    public static void main(String[] args) {
        // pruebaOptional(null);
        //orElseOptional(null);
        orElseThtow(null);
    }

    public static void pruebaOptional(String name) {
        System.out.println(name.length());
    }

    public static void crearOptional() {
        Optional<String> optional = Optional.empty();
        optional.get();
    }

    public static void orElseOptional(String nombre) {
        Optional<String> optional = Optional.ofNullable(nombre);
        //Optional<String> optional1 = Optional.of(nombre);

        String nombreOfNullable = optional.orElse("vacio");
        //String nombreOF = optional1.orElse("vacio");

        System.out.println(nombreOfNullable);
        //System.out.println(nombreOF);
    }

    public static void orElseThtow(String nombre) {
        Optional<String> optional = Optional.ofNullable(nombre);

        optional.orElseThrow(NullPointerException::new);
        String nombre1 = optional.get();
        System.out.println(nombre1);
    }
}
