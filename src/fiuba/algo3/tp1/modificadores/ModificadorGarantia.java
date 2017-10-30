package fiuba.algo3.tp1.modificadores;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNegativo;
import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNoPositivo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;

public class ModificadorGarantia implements ModificadorDePrecio {

    private Double precioGarantia;

    public ModificadorGarantia(Double precioGarantia){

        this.validarPreCondiciones(precioGarantia);

        this.precioGarantia = precioGarantia;
    }

    private void validarPreCondiciones(Double precioGarantia){
        if(precioGarantia == null){
            throw new ExcepcionParametroNulo("El costo de la garantía debe ser distinto de nulo");
        }
        if(precioGarantia <= 0){
            throw new ExcepcionNumeroNoPositivo("El costo de la garantía debe ser mayor a cero");
        }
    }

    @Override
    public Double aplicarModificador(Double precioOriginal) {

        if(precioOriginal == null){
            throw new ExcepcionParametroNulo("El precio original debe ser distinto de nulo");
        }

        return (precioOriginal * (1 + (this.precioGarantia / 100.0)));
    }
}
