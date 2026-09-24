package mx.itson.devops.descuento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * P3 - Nueva regla de negocio: nivel de 15 % desde 500 unidades.
 *
 * Estructura AAA (Arrange / Act / Assert) explicita en cada prueba.
 * Las dos primeras ya estan resueltas como ejemplo de estilo; completa
 * las que dicen TODO.
 */
class DescuentoNivelesTest {

    private final Descuento descuento = new Descuento();

    @Test
    void sinDescuentoAntesDeLaPrimeraFrontera() {
        // Arrange
        int unidades = 99;
        // Act
        int obtenido = descuento.porcentaje(unidades);
        // Assert
        assertEquals(0, obtenido);
    }

    @Test
    void diezPorCientoEnLaPrimeraFrontera() {
        // Arrange
        int unidades = 100;
        // Act
        int obtenido = descuento.porcentaje(unidades);
        // Assert
        assertEquals(10, obtenido);
    }

    @Test
    void diezPorCientoJustoAntesDelSegundoNivel() {
        // Arrange
        int unidades = 499;
        // Act
        int obtenido = descuento.porcentaje(unidades);
        // Assert
        assertEquals(10, obtenido);
    }

    @Test
    void quincePorCientoEnElSegundoNivel() {
        // Arrange
        int unidades = 500;
        // Act
        int obtenido = descuento.porcentaje(unidades);
        // Assert
        assertEquals(15, obtenido);
    }

    @Test
    void precioUnitarioInvalidoLanzaExcepcion() {
        //Arrange
        long precioUnitarioCentavos = 0L;
        int unidades = 10;
        //Act y Assert
        assertThrows(IllegalArgumentException.class, () -> descuento.totalCentavos(precioUnitarioCentavos, unidades));
    }
}
