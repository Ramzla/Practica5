import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Suite de pruebas ajustada al nuevo formato visual.
 */
class JuegoTest {

    private Mazo mazo;
    private Jugador jugador;

    @BeforeEach
    void setUp() {
        mazo = new Mazo();
        jugador = new Jugador("Prueba");
    }

    @Test
    @DisplayName("Validar formato visual personalizado de las cartas")
    void testRepresentacionCarta() {
        Carta as = new Carta(1, Palo.CORAZONES);
        Carta diez = new Carta(10, Palo.ESPADAS);
        Carta reina = new Carta(12, Palo.ESPADAS);

        assertEquals("⟦ AS de CORAZONES ⟧", as.toString());
        assertEquals("⟦ 10 de ESPADAS ⟧", diez.toString());
        assertEquals("⟦ REINA de ESPADAS ⟧", reina.toString());
    }

    @Test
    @DisplayName("Validar fallo ante cartas con valor fuera del rango 1-13")
    void testValorCartaInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Carta(0, Palo.CORAZONES));
        assertThrows(IllegalArgumentException.class, () -> new Carta(15, Palo.TREBOLES));
    }

    @Test
    @DisplayName("Validar que el mazo comience con 52 unidades")
    void testMazoInicializacion() {
        assertEquals(52, mazo.getCantidadCartasRestantes());
    }

    @Test
    @DisplayName("Validar obtención de muestra de cartas iniciales")
    void testObtenerPrimerasCartas() {
        String muestra = mazo.obtenerPrimerasCartas(2);
        assertEquals("⟦ AS de CORAZONES ⟧ ⟦ 2 de CORAZONES ⟧", muestra);
    }

    @Test
    @DisplayName("Validar el reparto de 15 cartas en total")
    void testRepartirCartas() {
        List<Jugador> listaJugadores = List.of(
                new Jugador("J1"),
                new Jugador("J2"),
                new Jugador("J3")
        );

        mazo.repartir(listaJugadores, 5);

        assertEquals(5, listaJugadores.get(0).getMano().size());
        assertEquals(37, mazo.getCantidadCartasRestantes());
    }

    @Test
    @DisplayName("Validar el formato impreso de la mano del jugador")
    void testJugadorCartasFormateadas() {
        jugador.recibirCarta(new Carta(10, Palo.ESPADAS));
        jugador.recibirCarta(new Carta(1, Palo.CORAZONES));

        assertEquals("⟦ 10 de ESPADAS ⟧ ⟦ AS de CORAZONES ⟧", jugador.obtenerCartasFormateadas());
        assertEquals("▶ Prueba posee: ⟦ 10 de ESPADAS ⟧ ⟦ AS de CORAZONES ⟧", jugador.toString());
    }
}