package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNegativo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import fiuba.algo3.tp1.Excepciones.ExcepcionStringVacio;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductoTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCrearProductoConNombreNuloNoDebePermitirse(){
        thrown.expect(ExcepcionParametroNulo.class);
        new Producto(null,10000D);
    }

    @Test
    public void testCrearProductoConPrecioNegativooNoDebePermitirse(){
        thrown.expect(ExcepcionNumeroNegativo.class);
        new Producto("Notebook",-200D);
    }

    @Test
    public void testCrearProductoConPrecioNuloNoDebePermitirse(){
        thrown.expect(ExcepcionParametroNulo.class);
        new Producto("Notebook",null);
    }

    @Test
    public void testCrearProductoConUnNombreVacioNoDebePermitirse(){
        thrown.expect(ExcepcionStringVacio.class);
        new Producto("",200D);
    }

}
