package org.joaquinalvarez.argentinaprograma.ejercicios.guia5.modelo.guia5.modelo;

public class ItemCarrito {

    //Declaramos los atributos
    private Producto producto;
    private Integer cantidadProducto;

    //Declaramos los metodos
    //CONSTRUCTOR

    public ItemCarrito() {
    }

    //GETTERS Y SETTERS

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    //METODOS PARTICULARES DE LA CLASE
    public double calcularSubtotal(){
        return cantidadProducto * producto.getPrecio();
    }
}
