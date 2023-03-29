package org.joaquinalvarez.argentinaprograma.ejercicios.guia7.prueba;

import org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo.Carrito;
import org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo.Descuento;
import org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo.ItemCarrito;
import org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo.Producto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EjemploCarrito {
    public static void main(String[] args) throws IOException {
        //Creamos una instancia de carrito como ejemplo
        Carrito carrito = new Carrito();

        //Para crear los items y los productos, vamos a tomar los datos de un archivo
        String archivo = "C:\\Users\\Usuario\\Desktop\\Escritorio\\UTN\\Curso Argentina Programa - Java\\Argentina Programa - Curso Java\\src\\main\\java\\org\\joaquinalvarez\\argentinaprograma\\ejercicios\\guia7\\datos.txt";
        for(String linea : Files.readAllLines(Paths.get(archivo))){
            String[] datos = linea.split(";");

            //Extraemos los datos en variables
            int cantidad = Integer.parseInt(datos[0]);
            double precioUnitario = Double.parseDouble(datos[1]);
            String nombreProducto = datos[2];

            //Creamos los objetos solicitados en el enunciado
            //1. Primero creamos el producto (con su nombre y su precio extraídos del archivo)
            Producto producto = new Producto();
            producto.setNombre(nombreProducto);
            producto.setPrecio(precioUnitario);

            //2. Creamos el itemCarrito para poder asociar cada producto con el carrito creado
            ItemCarrito item = new ItemCarrito();
            item.setCantidadProducto(cantidad);
            item.setProducto(producto); //le seteamos el producto recientemente creado

            //3. Agregamos el itemCarrito creado recientemente al carrito creado al inicio del programa
            carrito.agregarItem(item);
        }

        //Agregamos un descuento
        //carrito.setDescuento(100);
        imprimirDatosCarrito(carrito);
    }


    public static void imprimirDatosCarrito(Carrito carrito){
        System.out.println("CANTIDAD || PRECIO || PRODUCTO");
        for(ItemCarrito item : carrito.getItemCarrito()){
            System.out.print("    " + item.getCantidadProducto() + "    ||");
            System.out.print("  " + item.getProducto().getPrecio() + "  ||");
            System.out.println(" " + item.getProducto().getNombre());
        }
        System.out.println("\n SUBTOTAL DEL CARRITO: " + carrito.calcularTotal());

        Descuento descuento = carrito.calcularDescuento(carrito.calcularTotal());
        System.out.println("\n DESCUENTO EN ($): " + descuento.getValorDescuento());

        System.out.println("\n TOTAL DE LA COMPRA: " + carrito.calcularTotal(descuento));
    }
}
