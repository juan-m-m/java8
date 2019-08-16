package com.company;

/**
 * @author Juan Montaño
 */
public interface PorDefecto {

    void mostrarNombre(String nombre);

    default String nombrePorDefecto(String nombre) {
        return nombre + " default";
    }
}
