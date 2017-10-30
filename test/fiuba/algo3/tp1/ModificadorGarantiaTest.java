package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNoPositivo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import fiuba.algo3.tp1.modificadores.ModificadorGarantia;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ModificadorGarantiaTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private static final double DELTA = 1e-10;

    @Test
    public void testCrearModificadorGarantia10PorcientoVerificarCosto(){
        ModificadorGarantia modificador = new ModificadorGarantia(10D);
        Assert.assertEquals(1650D,modificador.aplicarModificador(1500D),DELTA);
    }

    @Test
    public void testCrearModificadorGarantiaConPorcentajeNegativo(){
        thrown.expect(ExcepcionNumeroNoPositivo.class);
        new ModificadorGarantia(-100D);
    }

    @Test
    public void testCrearModificadorGarantiaConPorcentajeNulo(){
        thrown.expect(ExcepcionParametroNulo.class);
        new ModificadorGarantia(null);
    }
}
