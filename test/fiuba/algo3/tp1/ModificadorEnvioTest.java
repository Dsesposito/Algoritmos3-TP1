package fiuba.algo3.tp1;

import fiuba.algo3.tp1.Excepciones.ExcepcionNumeroNegativo;
import fiuba.algo3.tp1.Excepciones.ExcepcionParametroNulo;
import fiuba.algo3.tp1.modificadores.ModificadorEnvio;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ModificadorEnvioTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCrearModificadorDeEnvioConBonificacionNegativa(){
        thrown.expect(ExcepcionNumeroNegativo.class);
        new ModificadorEnvio(100D,-500D);
    }

    @Test
    public void testCrearModificadorDeEnvioConBonificacionVerificarCosto(){
        ModificadorEnvio modificador = new ModificadorEnvio(200D,500D);
        Assert.assertEquals(Double.valueOf(1500),modificador.aplicarModificador(1500D));
    }

    @Test
    public void testCrearModificadorDeEnvioConCostoNegativo(){
        thrown.expect(ExcepcionNumeroNegativo.class);
        ModificadorEnvio modificador = new ModificadorEnvio(-100D);
    }

    @Test
    public void testCrearModificadorDeEnvioVerificarCosto(){
        ModificadorEnvio modificador = new ModificadorEnvio(200D);
        Assert.assertEquals(Double.valueOf(1700),modificador.aplicarModificador(1500D));
    }

    @Test
    public void testCrearModificadorDeEnvioConCostoNulo(){
        thrown.expect(ExcepcionParametroNulo.class);
        new ModificadorEnvio(null);
    }

}
