package com.company;

public class Lambda implements PorDefecto {

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

        Sumar sumar = new Sumar() {
            @Override
            public int suma(int a, int b) {
                return a + b;
            }
        };

        System.out.println(sumar.suma(1, 3));

        Sumar suma1 = (a, b) -> a + b;
        System.out.println(suma1.suma(1, 2));

        Sumar suma2 = (a, b) -> {
            a = b * b;
            a = a + b;
            System.out.println("mensaje dentro de lambda");
            return a;
        };
        System.out.println(suma2.suma(1, 1));

        Lambda l = new Lambda();

        System.out.println(l.nombrePorDefecto("Juan"));
    }

    @Override
    public void mostrarNombre(String nombre) {

    }
}
