package org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo;

import java.awt.color.ICC_ColorSpace;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Carrito {

    //Declaracion de atributos
    private Integer numeroCarrito;
    private ItemCarrito[] itemsCarrito;
    private LocalDate fechaCompra;
    private double descuento;


    //Declaracion e implementacion de metodos

    //CONSTRUCTOR
    public Carrito() {
        descuento = 0;
        this.itemsCarrito = new ItemCarrito[3];
    }

    //GETTERS AND SETTERS
    public Integer getNumeroCarrito() {
        return numeroCarrito;
    }

    public void setNumeroCarrito(Integer numeroCarrito) {
        this.numeroCarrito = numeroCarrito;
    }

    public ItemCarrito[] getItemCarrito() {
        return itemsCarrito;
    }

    public void setItemCarrito(ItemCarrito[] itemCarrito) {
        this.itemsCarrito = itemCarrito;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    //METODOS PARTICULARES DE LA CLASE
    public double calcularTotal() throws Exception {
        double total = 0;
        for(ItemCarrito item : this.itemsCarrito){
            Producto productoEnCarrito = item.getProducto();
            total = total + productoEnCarrito.getPrecio();
        }

        System.out.println("\n SUBTOTAL DEL CARRITO: " + total);

        //Vemos los descuentos
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea aplicar algún descuento sobre el valor total de la compra? y/n");
        String decision = scanner.next();

        if(decision.equalsIgnoreCase("y")) {
            System.out.println("Desea indicar un descuento fijo o un porcentaje sobre el valor de la compra? \n (f) Descuento fijo \n (p) Descuento porcentual");
            decision = scanner.next();
            if (decision.equalsIgnoreCase("f")) {
                DescuentoFijo descuentoFijo = new DescuentoFijo();
                System.out.println("Indique a continuacion el valor que desea descontar del valor de la compra");
                descuentoFijo.setValorDescuento(scanner.nextDouble());
                this.descuento = descuentoFijo.getValorDescuento();
                total = descuentoFijo.calcularDescuento(total);
            } else {
                DescuentoPorcentaje descuentoPorcentaje = new DescuentoPorcentaje();
                System.out.println("Indique a continuacion el porcentaje que desea descontar del valor de la compra");
                descuentoPorcentaje.setPorcentajeDescuento(scanner.nextDouble());
                descuentoPorcentaje.setValorDescuento(descuentoPorcentaje.getPorcentajeDescuento(), total);
                this.descuento = descuentoPorcentaje.getValorDescuento();
                total = descuentoPorcentaje.calcularDescuento(total);
            }
        }

        System.out.println("\n DESCUENTO EN ($): " + this.descuento);
        System.out.println("===========================================");
        return total;
    }

    public double calcularTotal(Descuento descuento){
        double total = 0;
        for(ItemCarrito item : this.itemsCarrito){
            Producto productoEnCarrito = item.getProducto();
            total = total + productoEnCarrito.getPrecio();
        }

        System.out.println("===========================================");

        return total - descuento.getValorDescuento();
    }



    public void agregarItem(ItemCarrito itemCarrito){
        boolean bandera = false; //bandera para saber si el carrito esta lleno o no
        for(int i = 0; i < this.itemsCarrito.length; i++){
            if (itemsCarrito[i] == null) {
                itemsCarrito[i] = itemCarrito;
                bandera = true;
                break;
            }
        }
        if (!bandera){
            System.out.println("¡El carrito de compras esta lleno!");
        }
    }
}
