package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Object[][] productos = new Object[10][3];
    Main main = new Main();
    @BeforeEach
    void setup(){
        productos[0] = new Object[]{1, "Producto 1", 10};
        productos[1] = new Object[]{2, "Producto 2", 20};
        productos[2] = new Object[]{3, "Producto 3", 30};
    }
    @Test
    void testAgregarProductos() {
        main.agregarProductos(productos, 4, "Producto 4",40);
        assertEquals(4, productos[3][0]);
        assertEquals("Producto 4", productos[3][1]);
        assertEquals(40, productos[3][2]);
        assertEquals(null, productos[4][0]);
        assertEquals(null, productos[4][1]);
        assertEquals(null, productos[4][2]);
    }
    /*@Test
    void testModificarStock() {
        main.modificarStock(productos, 1);
        //Aca va un input del usuario y el @test no me deja ingresar...
        assertEquals(20, productos[0][2]);
    }*/

    @Test
    void restarProductos() {
        main.restarProductos(productos, 1, "Producto 1", 5);
        assertEquals(1, productos[0][0]);
        assertEquals("Producto 1", productos[0][1]);
        assertEquals(5, productos[0][2]);
    }

    @Test
    void restarProductosNoSuficientes() {
        main.restarProductos(productos, 1, "Producto 1", 15);
        assertEquals(10, productos[0][2]);
    }
    @Test
    void restarProductosNoExistentes(){
        main.restarProductos(productos, 4, "Producto 4", 5);
        assertEquals(null, productos[3][0]);
        assertEquals(null, productos[3][1]);
        assertEquals(null, productos[3][2]);
    }

    @Test
    void consultarProductos() {
        main.consultarProductos(productos, 1);
        main.consultarProductos(productos, 4);
    }

    @Test
    void listarProductos() {
        main.listarProductos(productos);
    }

}