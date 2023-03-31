package org.joaquinalvarez.argentinaprograma.ejercicios.guia8.modelo;

public class DescuentoFijo extends Descuento{

    public DescuentoFijo() {
        super(0);
    }

    @Override
    public double calcularDescuento(double total) throws Exception {
        double resultadoDescuento = total - this.valorDescuento;
        if(resultadoDescuento >= 0){
            return resultadoDescuento;
        }else{
            throw new Exception("El valor del descuento aplicado no puede superar el valor de la compra realizada.");
        }
    }
}
