package org.joaquinalvarez.argentinaprograma.ejercicios.guia8.modelo;

public class Descuento {
    protected double valorDescuento;

    public Descuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double calcularDescuento(double total) throws Exception {
        return 0;
    }
}
