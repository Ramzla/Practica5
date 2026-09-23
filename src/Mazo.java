import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private final List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        restablecerMazo();
    }

    public void restablecerMazo() {
        cartas.clear();
        for (Palo palo : Palo.values()) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public void repartir(List<Jugador> jugadores, int cartasPorJugador) {
        int cartasNecesarias = jugadores.size() * cartasPorJugador;
        if (cartasNecesarias > cartas.size()) {
            throw new IllegalStateException("Cantidad insuficiente de cartas en el mazo.");
        }

        for (int i = 0; i < cartasPorJugador; i++) {
            for (Jugador jugador : jugadores) {
                jugador.recibirCarta(quitarCartaPila());
            }
        }
    }

    public void agregarCartaPila(Carta carta) {
        if (carta != null) {
            cartas.add(carta);
        }
    }

    public Carta quitarCartaPila() {
        if (cartas.isEmpty()) {
            throw new IllegalStateException("El mazo se encuentra completamente vacío.");
        }
        return cartas.remove(0);
    }

    public int getCantidadCartasRestantes() {
        return cartas.size();
    }

    public String obtenerPrimerasCartas(int cantidad) {
        StringBuilder sb = new StringBuilder();
        int limite = Math.min(cantidad, cartas.size());
        for (int i = 0; i < limite; i++) {
            sb.append(cartas.get(i).toString()).append(" ");
        }
        return sb.toString().trim();
    }
}