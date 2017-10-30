package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNoPositivo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;

import java.util.List;

public class Cupon {

    private Double porcentaje;

    public Cupon(Double porcentaje){

        this.validarPreCondiciones(porcentaje);

        this.porcentaje = porcentaje;
    }

    private void validarPreCondiciones(Double porcentaje){
        if(porcentaje == null){
            throw new ExcepcionParametroNulo("El porcentaje del cupon debe ser distinto de nulo");
        }

        if(porcentaje <= 0){
            throw new ExcepcionNumeroNoPositivo("El porcentaje del cupon debe ser mayor a cero");
        }
    }

    public static Cupon obtenerCuponConMayorDescuento(List<Cupon> cupones){

        if(cupones == null){
            throw new ExcepcionParametroNulo("La lista de cupones debe ser distinta de nulo");
        }

        Cupon maxDescuento = cupones.stream().max(
            (cupon, otroCupon) -> Double.compare(cupon.getPorcentaje(),otroCupon.getPorcentaje())
        ).get();
        return maxDescuento;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }
}
