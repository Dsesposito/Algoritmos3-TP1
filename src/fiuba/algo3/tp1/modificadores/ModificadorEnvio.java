package fiuba.algo3.tp1.modificadores;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNegativo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;

public class ModificadorEnvio implements ModificadorDePrecio {

    private Double costoDeEnvio;
    private Double limiteDeBonificacion;

    public ModificadorEnvio(Double costoDeEnvio,Double limiteDeBonificacion){

        this.validarPrecondiciones(costoDeEnvio,limiteDeBonificacion);

        this.costoDeEnvio = costoDeEnvio;
        this.limiteDeBonificacion = limiteDeBonificacion;
    }

    public ModificadorEnvio(Double costoDeEnvio){
        this.validarPrecondiciones(costoDeEnvio,null);

        this.costoDeEnvio = costoDeEnvio;
    }

    private void validarPrecondiciones(Double costoDeEnvio,Double limiteDeBonificacion){
        if(costoDeEnvio == null){
            throw new ExcepcionParametroNulo("El costo de envio debe ser distinto de nulo");
        }
        if(costoDeEnvio < 0){
            throw new ExcepcionNumeroNegativo("El costo de envio debe ser mayor o igual a cero");
        }
        if(limiteDeBonificacion != null && limiteDeBonificacion <= 0){
            throw new ExcepcionNumeroNegativo("El limite de bonificacion debe ser mayor que cero");
        }
    }

    @Override
    public Double aplicarModificador(Double precioOriginal) {

        if(precioOriginal == null){
            throw new ExcepcionParametroNulo("El precio original debe ser distinto de nulo");
        }

        if (this.limiteDeBonificacion == null) {
            return precioOriginal + this.costoDeEnvio;
        }

        if(precioOriginal < this.limiteDeBonificacion){
            return precioOriginal + this.costoDeEnvio;
        }

        return precioOriginal;
    }
}
