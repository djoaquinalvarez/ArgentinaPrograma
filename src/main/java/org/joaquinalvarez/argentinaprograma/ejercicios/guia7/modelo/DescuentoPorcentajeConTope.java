package org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje{

    private double topeDescuento;

    public DescuentoPorcentajeConTope() {
        super();
        this.topeDescuento = 0;
    }

    public double getTopeDescuento() {
        return topeDescuento;
    }

    public void setTopeDescuento(double topeDescuento) {
        this.topeDescuento = topeDescuento;
    }
}
