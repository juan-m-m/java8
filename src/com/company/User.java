package com.company;

/**
 * @author Juan Montaño
 */
public class User {

    private String nombre;

    public User(String nombre) {
        this.nombre = nombre;
    }

    public static void referenciaMethodEstatico() {
        System.out.println("probando referencia a metodo statico");
    }

    public void referenciaAmetodoParticular() {
        System.out.println("probando a metodo de objeto particular");
    }

    public void mostrarNombre() {
        System.out.println(nombre);
    }
}
