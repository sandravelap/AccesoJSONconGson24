package menus;

import controllers.EscribirInstiJSON;
import controllers.LeerInstiJSON;

import java.nio.file.Path;
import java.util.Scanner;

import static libs.UserData.*;

public class MenuPrincipal {
    private boolean salir = false;
    private Scanner sc = new Scanner(System.in);
    private LeerInstiJSON leerInstiJSON = new LeerInstiJSON();
    private EscribirInstiJSON escribirInstiJSON = new EscribirInstiJSON();

    public void muestraMenu() {
        String opcion;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Leer insti.json con Gson.");
            System.out.println("2. Escribir instituto con Gson.");
            System.out.println("0. Salir");
            opcion = this.pideOpcion();
            this.procesaOpcion(opcion);
        } while (!salir);
    }

    private String pideOpcion() {
        return this.sc.nextLine();
    }

    private void procesaOpcion(String opcion) {
        switch (opcion) {
            case "0" -> salir = true;
            case "1" -> {
                Path p = pedirRutaJson("Introduce la ruta del archivo Json");
                System.out.println(leerInstiJSON.leerJson(p));
                }
            case "2" -> {
                Path p = pedirRuta("Introduce la carpeta donde crear el archivo:");
                System.out.println(escribirInstiJSON.escribir(p));
            }
            default -> System.out.println("Opción incorrecta");
        }
    }
}
