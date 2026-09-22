package mx.itson.devops.descuento;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Pruebas basicas que ya venian con el proyecto. */
class DescuentoSmokeTest {

    private final Descuento descuento = new Descuento();

    @Test
    void sinUnidadesNoHayDescuento() {
        assertEquals(0, descuento.porcentaje(0));
    }

    @Test
    void pedidoPequenoNoTieneDescuento() {
        assertEquals(0, descuento.porcentaje(50));
    }

    @Test
    void cantidadNegativaEsUnError() {
        assertThrows(IllegalArgumentException.class, () -> descuento.porcentaje(-1));
    }

    @Test
    void totalCentavosConDescuento() {
        long precioUnitario = 1000; // $10.00
        int unidades = 100;
        long esperado = 90000; // $90.00
        assertEquals(esperado, descuento.totalCentavos(precioUnitario, unidades));
    }
}
