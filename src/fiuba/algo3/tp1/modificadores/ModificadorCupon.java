package fiuba.algo3.tp1.modificadores;

import fiuba.algo3.tp1.Cupon;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModificadorCupon implements ModificadorDePrecio {

    private List<Cupon> cupones;

    public ModificadorCupon(List<Cupon> cupones){

        if(cupones == null){
            throw new ExcepcionParametroNulo("La lista de cupones debe ser distinta de nulo");
        }

        this.cupones = cupones;
    }

    public ModificadorCupon(Cupon cupon){

        if(cupon == null){
            throw new ExcepcionParametroNulo("La lista de cupones debe ser distinta de nulo");
        }

        this.cupones = new ArrayList<>(Arrays.asList(cupon));
    }


    @Override
    public Double aplicarModificador(Double precioOriginal) {

        if(precioOriginal == null){
            throw new ExcepcionParametroNulo("El precio original debe ser distinto de nulo");
        }

        if(cupones.isEmpty()){
            return precioOriginal;
        }

        Cupon maxDescuento = Cupon.obtenerCuponConMayorDescuento(cupones);

        return (precioOriginal * (1 - (maxDescuento.getPorcentaje() / 100)));
    }
}
