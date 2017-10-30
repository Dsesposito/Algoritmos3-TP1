package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import fiuba.algo3.tp1.modificadores.ModificadorEnvio;
import fiuba.algo3.tp1.modificadores.ModificadorGarantia;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CompraTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCompraAgregarCuponInvalido() {

        thrown.expect(ExcepcionParametroNulo.class);
        new Compra().agregarProducto(null);
    }

    @Test
    public void testCompraAgregarModificadorInvalido(){

        thrown.expect(ExcepcionParametroNulo.class);
        new Compra().agregarModificador(null);
    }

    @Test
    public void testCompraAgregarProductoInvalido(){

        thrown.expect(ExcepcionParametroNulo.class);
        new Compra().agregarProducto(null);
    }

    @Test
    public void testCompraEstandarDeDosProductosObtenerPrecio(){

        Compra compra = new Compra();
        compra.agregarProducto(new Producto("Notebook",10000d));
        compra.agregarProducto(new Producto("Secador de pelo", 2000d));

        Assert.assertEquals(Double.valueOf(12000),compra.getPrecioTotal());
    }

    @Test
    public void testCompraProductosConEnvio(){

        Compra compra = new Compra();
        compra.agregarProducto(new Producto("Notebook",10000D));
        compra.agregarProducto(new Producto("Celular",8000D));
        compra.agregarModificador(new ModificadorEnvio(500D));
        Assert.assertEquals(Double.valueOf(18500),compra.getPrecioTotal());
    }

    @Test
    public void testCompraProductosConEnvioBonificado(){
        Compra compra = new Compra();
        compra.agregarProducto(new Producto("Notebook",10000D));
        compra.agregarProducto(new Producto("Celular",8000D));
        compra.agregarModificador(new ModificadorEnvio(500D,5000D));
        Assert.assertEquals(Double.valueOf(18000),compra.getPrecioTotal());
    }

    @Test
    public void testCompraProductosConGarantia(){
        Compra compra = new Compra();
        compra.agregarProducto(new Producto("Notebook",10000D));
        compra.agregarProducto(new Producto("Celular",8000D));
        compra.agregarModificador(new ModificadorGarantia(10D));
        Assert.assertEquals(Double.valueOf(19800),compra.getPrecioTotal());
    }

    @Test
    public void testCompraProductosConGarantiaYCuponDeDescuento(){
        Compra compra = new Compra();
        compra.agregarProducto(new Producto("Notebook",10000D));
        compra.agregarProducto(new Producto("Celular",8000D));
        compra.agregarModificador(new ModificadorGarantia(10D));
        compra.agregarCupon(new Cupon(20D));
        Assert.assertEquals(Double.valueOf(15840),compra.getPrecioTotal());
    }

    @Test
    public void testCompraProductosConGarantiaYEnvio(){
        Compra compra = new Compra();
        compra.agregarProducto(new Producto("Notebook",10000D));
        compra.agregarProducto(new Producto("Celular",8000D));
        compra.agregarModificador(new ModificadorGarantia(10D));
        compra.agregarModificador(new ModificadorEnvio(200D));
        Assert.assertEquals(Double.valueOf(20000),compra.getPrecioTotal());
    }
}
