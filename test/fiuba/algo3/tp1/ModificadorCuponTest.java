package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import fiuba.algo3.tp1.modificadores.ModificadorCupon;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ModificadorCuponTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCrearModificadorCupon20PorcientoVerificarCosto(){

        ModificadorCupon modificador = new ModificadorCupon(new Cupon(20D));
        Assert.assertEquals(Double.valueOf(800),modificador.aplicarModificador(1000D));
    }

    @Test
    public void testCrearModificadorCuponConCuponNulo(){
        thrown.expect(ExcepcionParametroNulo.class);
        Cupon cupon = null;
        new ModificadorCupon(cupon);
    }
}
