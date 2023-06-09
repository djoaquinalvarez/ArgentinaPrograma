package org.joaquinalvarez.argentinaprograma.ejercicios.guia7.modelo;

import javax.swing.tree.ExpandVetoException;

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

    @Override
    public double calcularDescuento(double total) throws Exception {
        if(this.porcentajeDescuento <= this.topeDescuento){
            return (total * this.porcentajeDescuento) / 100;

        }else{
            throw new Exception("El porcentaje de descuento ha superado el tope permitido");
        }

    }
}


