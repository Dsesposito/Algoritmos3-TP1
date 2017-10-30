package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNegativo;
import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNoPositivo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CuponTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCrearCuponDeDescuento10Porciento(){
        Cupon cupon = new Cupon(10D);
        Assert.assertEquals(Double.valueOf(10),cupon.getPorcentaje());
    }

    @Test
    public void testCrearCuponDeDescuentoConValorNegativo(){

        thrown.expect(ExcepcionNumeroNoPositivo.class);
        new Cupon(-3D);
    }

    @Test
    public void testCrearCuponDeDescuentoConValorNulo(){
        thrown.expect(ExcepcionParametroNulo.class);
        new Cupon(null);
    }
}
