package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Montaño
 */
public class ReferenciaMetodo {
        /*
        tipos de metodos de referencia

        tipo                            Syntax                       Method Reference      Lambda expresion
        -----------------------------------------------------------------------------------------------------------
        referencia a static method     Class::staticMethod           Math::abs              n -> Math.abs(n)
        -----------------------------------------------------------------------------------------------------------
        referencia a un metodo         instancia::metodoInstancia    s::toString            () -> "string".toString
        de una instancia de un
        objeto particular
        -----------------------------------------------------------------------------------------------------------
        referencia a un metodo         Class::metodoInstancia         String::toString       s -> s.toString()
        de una instancia de un
        objeto arbitrario de un
        tipo particular
        -----------------------------------------------------------------------------------------------------------
        referencia a un                Class::new                     String::new            () -> new String
        constructor
        */

    public static void main(String[] args) {
//        referencia a static method     Class::staticMethod           Math::abs              n -> Math.abs(n)

        Trabajo trabajo = new Trabajo() {
            @Override
            public void action() {
                User.referenciaMethodEstatico();
            }
        };

        Trabajo trabajo1 = () -> User.referenciaMethodEstatico();
        Trabajo trabajomr = User::referenciaMethodEstatico;
        trabajomr.action();

        /*
        referencia a un metodo         instancia::metodoInstancia    s::toString            () -> "string".toString
        de una instancia de un
        objeto particular
         */

        User user = new User("Juan");

        Trabajo trabajo2 = () -> user.referenciaAmetodoParticular();
        Trabajo trabajo3 = user::referenciaAmetodoParticular;

        trabajo3.action();

        /*
        referencia a un metodo         Class::metodoInstancia         String::toString       s -> s.toString()
        de una instancia de un
        objeto arbitrario de un
        tipo particular
         */

        TrabajoString trabajoString = (palabra) -> palabra.toUpperCase();
        TrabajoString trabajoStringrm = String::toUpperCase;
        System.out.println(trabajoStringrm.accion("juanito"));

        List<User> users = new ArrayList<>();
        users.add(new User("juan"));
        users.add(new User("pepe"));
        users.add(new User("antonio"));
        users.add(new User("jorge"));

        //users.forEach(nombre -> nombre.mostrarNombre());
        users.forEach(User::mostrarNombre);

        /*
        referencia a un                Class::new                     String::new            () -> new String
        constructor
         */

        IUser user1 = new IUser() {
            @Override
            public User create(String nombre) {
                return new User(nombre);
            }
        };
        IUser user2 = (nombre -> new User(nombre));
        IUser user3 = User::new;
        System.out.println(user3.create("pepito"));
    }
}
