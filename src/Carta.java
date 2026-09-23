/**
 * Representa una carta individual de la baraja.
 */
public class Carta {
    private final int valor;
    private final Palo tipo;

    public Carta(int valor, Palo tipo) {
        if (valor < 1 || valor > 13) {
            throw new IllegalArgumentException("El valor de la carta debe estar entre 1 y 13.");
        }
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public Palo getTipo() {
        return tipo;
    }

    private String obtenerRepresentacionValor() {
        return switch (this.valor) {
            case 1 -> "AS";
            case 11 -> "JOTA";
            case 12 -> "REINA";
            case 13 -> "REY";
            default -> String.valueOf(this.valor);
        };
    }

    @Override
    public String toString() {
        return "⟦ " + obtenerRepresentacionValor() + " de " + tipo + " ⟧";
    }
}