package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNegativo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import fiuba.algo3.tp1.Excepciones.ExcepcionStringVacio;

public class Producto {

    private Double precio;
    private String nombre;

    public Producto(String nombre , Double precio){

        this.validarPrecondiciones(nombre,precio);

        this.precio = precio;
        this.nombre = nombre;
    }

    private void validarPrecondiciones(String nombre,Double precio){

        if(nombre == null){
            throw new ExcepcionParametroNulo("El nombre del producto debe ser distinto de nulo");
        }

        if(nombre.isEmpty()){
            throw new ExcepcionStringVacio("El nombre del producto debe ser distinto de vacio");
        }

        if(precio == null){
            throw new ExcepcionParametroNulo("El precio del producto debe ser distinto de nulo");
        }

        if(precio < 0){
            throw new ExcepcionNumeroNegativo("El precio del producto debe ser mayor o igual a cero");
        }
    }

    public Boolean tieneNombre(String nombre){
        return this.nombre.equals(nombre);
    }

    public Double getPrecio (){
        return this.precio;
    }
}
