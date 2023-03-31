package org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo;

public class DescuentoFijo extends Descuento{

    public DescuentoFijo() {
        super(0);
    }

    @Override
    public double calcularDescuento(double total) {
        return (total - this.valorDescuento);
    }
}
