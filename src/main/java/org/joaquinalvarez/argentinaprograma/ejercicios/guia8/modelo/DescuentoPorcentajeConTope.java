package org.joaquinalvarez.argentinaprograma.ejercicios.guia8.modelo;

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
            double resultadoDescuento = (total * this.porcentajeDescuento) / 100;
            if(resultadoDescuento >= 0){
                return resultadoDescuento;
            }else{
                throw new Exception("El valor del descuento aplicado no puede superar el valor de la compra realizada.");
            }
        }else{
            throw new Exception("El porcentaje de descuento ha superado el tope permitido");
        }

    }
}


