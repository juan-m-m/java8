package com.company;

public class Main {

    public static void main(String[] args) {

        /*
        ()->"mi nonbre"
        (n)->n*n
        (n)->n==2
         */

        MiNombre miNombreAnonima = new MiNombre() {
            @Override
            public String miNombre() {
                return "Juan";
            }
        };
        System.out.println(miNombreAnonima.miNombre());

        MiNombre miNombreLambda = () -> "juan lambda";

        System.out.println(miNombreLambda.miNombre());
    }
}
