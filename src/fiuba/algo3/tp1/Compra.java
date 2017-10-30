package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import fiuba.algo3.tp1.modificadores.ModificadorCupon;
import fiuba.algo3.tp1.modificadores.ModificadorDePrecio;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private List<Producto> productos;
    private List<ModificadorDePrecio> modificadores;
    private List<Cupon> cupones;

    public Compra(){
        productos = new ArrayList<>();
        modificadores = new ArrayList<>();
        cupones = new ArrayList<>();
    }

    public Compra(ModificadorDePrecio modificador){

        if(modificador == null){
            throw new ExcepcionParametroNulo("El modificador de precio debe ser distinto de nulo");
        }

        productos = new ArrayList<>();
        modificadores = new ArrayList<>();
        cupones = new ArrayList<>();
        this.agregarModificador(modificador);

    }

    public void agregarProducto(Producto producto){

        if(producto == null){
            throw new ExcepcionParametroNulo("El producto debe ser distinto de nulo");
        }

        productos.add(producto);
    }

    public void agregarModificador(ModificadorDePrecio modificador){

        if(modificador == null){
            throw new ExcepcionParametroNulo("El modificador de precio debe ser distinto de nulo");
        }

        modificadores.add(modificador);
    }

    public Double getPrecioTotal(){

        Double precioTotal = this.sumarPrecios();

        precioTotal = this.aplicarModificadoresDePrecio(precioTotal);

        precioTotal = this.aplicarDescuento(precioTotal);

        return precioTotal;
    }

    private Double aplicarDescuento(Double precioOriginal){
        ModificadorCupon modificadorCupon = new ModificadorCupon(this.cupones);
        precioOriginal = modificadorCupon.aplicarModificador(precioOriginal);
        return precioOriginal;
    }

    private Double aplicarModificadoresDePrecio(Double precioOriginal){
        for (ModificadorDePrecio modificador : this.modificadores) {
            precioOriginal = modificador.aplicarModificador(precioOriginal);
        }
        return precioOriginal;
    }

    private Double sumarPrecios(){
        return this.productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
    }

    public void agregarCupon(Cupon cupon){

        if(cupon == null){
            throw new ExcepcionParametroNulo("El cupon debe ser distinto de nulo");
        }

        cupones.add(cupon);
    }

}
