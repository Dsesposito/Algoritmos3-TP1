package fiuba.algo3.tp1;

import fiuba.algo3.tp1.modificadores.ModificadorDePrecio;
import fiuba.algo3.tp1.modificadores.ModificadorEnvio;
import fiuba.algo3.tp1.modificadores.ModificadorGarantia;

import java.util.ArrayList;
import java.util.List;

public class AlgoBay {

    private List<Producto> productos;

    public AlgoBay(){
        productos = new ArrayList<>();
    }

    public long getCantidadDeProductos(){
        return (long) productos.size();
    }

    public Producto agregarProductoConPrecio(String nombre, int precio){
        Producto producto = new Producto(nombre, (double) precio);
        productos.add(producto);
        return producto;
    }

    public Producto getProducto(String nombre){
        return productos.stream()
                .filter( producto -> producto.tieneNombre(nombre))
                .findFirst()
                .orElse(null);
    }

    public Compra crearNuevaCompra(){
        return new Compra();
    }

    public Compra crearNuevaCompraConEnvio(){
        ModificadorDePrecio modificadorEnvio = new ModificadorEnvio(100.0,5000.0);
        return new Compra(modificadorEnvio);
    }

    public Compra crearNuevaCompraConEnvioYGarantia(){
        ModificadorDePrecio modificadorGarantia = new ModificadorGarantia(10D);
        ModificadorDePrecio modificadorEnvio = new ModificadorEnvio(100.0,5000.0);
        Compra compra = new Compra();
        compra.agregarModificador(modificadorGarantia);
        compra.agregarModificador(modificadorEnvio);
        return compra;
    }

    public Compra crearNuevaCompraConGarantia(){
        ModificadorDePrecio modificadorGarantia = new ModificadorGarantia(10D);
        return new Compra(modificadorGarantia);
    }

    public void agregarCuponEnCompra(Cupon cupon, Compra compra){
        compra.agregarCupon(cupon);
    }

    public void agregarProductoEnCompra(Producto producto, Compra compra){
        compra.agregarProducto(producto);
    }

    public Double getPrecioTotalDe(Compra compra){
        return compra.getPrecioTotal();
    }

    public Cupon crearCuponConPorcentaje(int porcentaje){
        return (new Cupon((double) porcentaje));
    }
}
