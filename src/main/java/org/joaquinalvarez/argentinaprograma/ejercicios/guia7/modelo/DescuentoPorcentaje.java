package org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo;

public class DescuentoPorcentaje extends Descuento{

    private double porcentajeDescuento;

    public DescuentoPorcentaje(double valorDescuento) {
        super(valorDescuento);
        this.porcentajeDescuento = 0;
    }

    public DescuentoPorcentaje() {
        super(0);
    }

    public void setValorDescuento(double porcentajeDescuento, double total) {
        this.valorDescuento = (total * porcentajeDescuento) / 100;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
