package org.joaquinalvarez.argentinaprograma.ejercicios.guia8.modelo;

public class DescuentoPorcentaje extends Descuento{

    protected double porcentajeDescuento;

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

    @Override
    public double calcularDescuento(double total) throws Exception {
        double resultadoDescuento = total - (total * this.porcentajeDescuento) / 100;
        if(resultadoDescuento >= 0){
            return resultadoDescuento;
        }else{
            throw new Exception("El valor del descuento aplicado no puede superar el valor de la compra realizada.");
        }
    }
}
