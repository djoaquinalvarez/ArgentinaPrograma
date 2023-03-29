package org.joaquinalvarez.argentinaprograma.ejercicios.guia5.modelo.guia5.modelo;

import java.time.LocalDate;

public class Carrito {

    //Declaracion de atributos
    private Integer numeroCarrito;
    private ItemCarrito[] itemsCarrito;
    private LocalDate fechaCompra;


    //Declaracion e implementacion de metodos

    //CONSTRUCTOR
    public Carrito() {
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


    //METODOS PARTICULARES DE LA CLASE
    public double calcularTotal(){
        double total = 0;
        for(ItemCarrito item : this.itemsCarrito){
            Producto productoEnCarrito = item.getProducto();
            total = total + productoEnCarrito.getPrecio();
        }
        return total;
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
