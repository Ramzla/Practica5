import java.util.ArrayList;
import java.util.List;

public class Jugador {
    public String nombre; // Accesible directamente
    private final List<Carta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public void recibirCarta(Carta carta) {
        if (carta != null) {
            mano.add(carta);
        }
    }

    public Carta deshacerseDeCarta(int indice) {
        if (indice < 0 || indice >= mano.size()) {
            throw new IndexOutOfBoundsException("Posición de carta inválida.");
        }
        return mano.remove(indice);
    }

    public List<Carta> getMano() {
        return mano;
    }

    public String obtenerCartasFormateadas() {
        StringBuilder sb = new StringBuilder();
        for (Carta c : mano) {
            sb.append(c.toString()).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "▶ " + nombre + " posee: " + obtenerCartasFormateadas();
    }
}