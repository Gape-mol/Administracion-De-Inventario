package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu(inicializarProductos());
    }
    public static Object[][] inicializarProductos(){
        Object[][] productos = new Object[10][3];
        return productos;
    }

    public static Object[][] agregarProductos(Object[][] productos, int id, String nombre, int cantidad){
        if (verificarProducto(productos, id)){
            modificarStock(productos, id);
        }
        else {
            for (int i = 0; i < productos.length; i++) {
                if (Objects.isNull(productos[i][0])) {
                    productos[i][0] = id;
                    productos[i][1] = nombre;
                    productos[i][2] = cantidad;
                    break;
                }
            }
        }
        return productos;
    }
    public static Object[][] modificarStock(Object[][] productos, int id){
        for (int i = 0; i < productos.length; i++) {
            if (Objects.nonNull(productos[i][0]) && (int) productos[i][0] == id) {
                productos[i][2] = (int) productos[i][2] + solicitarCantidad();
                break;
            }
        }
        return productos;
    }

    public static boolean verificarProducto(Object[][] productos, int id){
        for (int i = 0; i < productos.length; i++) {
            if (Objects.nonNull(productos[i][0]) && (int) productos[i][0] == id) {
                return true;
            }
        }
        return false;
    }
    public static Object[][] restarProductos(Object[][] productos, int id, String nombre, int cantidad) {
        if (!productoExiste(productos, id)){
            System.out.println("El producto no existe");
        }
        else {
            for (int i = 0; i < productos.length; i++) {
                if (Objects.nonNull(productos[i][0]) && (int) productos[i][0] == id) {
                    if ((int) productos[i][2] < cantidad) {
                        System.out.println("No hay suficientes productos");
                        break;
                    } else {
                        productos[i][2] = (int) productos[i][2] - cantidad;
                        break;
                    }
                }
            }
        }
        return productos;
    }
    public static boolean productoExiste(Object[][] productos, int id){
        for (int i = 0; i < productos.length; i++) {
            if (Objects.nonNull(productos[i][0]) && (int) productos[i][0] == id) {
                return true;
            }
        }
        return false;
    }
    public static void consultarProductos(Object[][] productos, int id) {
        if (!productoExiste(productos, id)){
            System.out.println("El producto no existe");
        }
        else {
            for (int i = 0; i < productos.length; i++) {
                if (Objects.nonNull(productos[i][0]) && (int) productos[i][0] == id) {
                    System.out.println("ID: " + productos[i][0]);
                    System.out.println("Nombre: " + productos[i][1]);
                    System.out.println("Cantidad: " + productos[i][2]);
                    break;
                }
            }
        }
    }
    public static void listarProductos(Object[][] productos) {
        for (int i = 0; i < productos.length; i++) {
            if (Objects.nonNull(productos[i][0])) {
                System.out.println("ID: " + productos[i][0]);
                System.out.println("Nombre: " + productos[i][1]);
                System.out.println("Cantidad: " + productos[i][2]);
            }
        }
    }
    public static void menu(Object[][] productos){
        int opcion = -1;
        printMenu();
        while(true){
            opcion = leerOpcion();
            if (opcion == 5){
                break;
            } else if (opcion == 0) {
                printMenu();
            } else{
                seleccionMenu(opcion, productos);
            }
        }
    }
    public static void printMenu(){
        System.out.println("\n-------------------------");
        System.out.println("    Menu de seleccion");
        System.out.println("-------------------------");
        System.out.println("1. Agregar productos");
        System.out.println("2. Restar productos");
        System.out.println("3. Consultar productos");
        System.out.println("4. Listar productos");
        System.out.println("5. Salir");
    }
    public static int leerOpcion(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese una opcion: ");
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un Numero entero");
                scan.next();
            }
        }
    }
    public static void seleccionMenu(int opcion, Object[][] productos) {
        switch (opcion) {
            case 1:
                agregarProductos(productos, solicitarID(), solicitarNombre(), solicitarCantidad());
                break;
            case 2:
                restarProductos(productos, solicitarID(), solicitarNombre(), solicitarCantidad());
                break;
            case 3:
                consultarProductos(productos, solicitarID());
                break;
            case 4:
                listarProductos(productos);
                break;
            case 5:
                System.out.println("Saliendo del programa");
                break;
            default:
                System.out.println("Opcion no valida");
                System.out.println("Si neceeita ayuda, presione 0");
                break;
        }
    }
    public static int solicitarID() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto: ");
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un Numero entero");
                scan.next();
            }
        }
    }
    public static int solicitarCantidad() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la cantidad del producto: ");
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un Numero entero");
                scan.next();
            }
        }
    }
    public static String solicitarNombre() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto: ");
        while (true) {
            try {
                return scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar texto");
                scan.next();
            }
        }
    }
}
