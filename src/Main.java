public class Main {
    public static void main(String[] args) {
        Carta asEspadas = new Carta(1, Palo.ESPADAS);
        Carta asDiamantes = new Carta(1, Palo.DIAMANTES);
        Carta asCorazones = new Carta(1, Palo.CORAZONES);
        Carta asTreboles = new Carta(1, Palo.TREBOLES);

        Visualizador.carta(asEspadas, new Posicion(20, 40));
        Visualizador.carta(asDiamantes, new Posicion(120, 40));
        Visualizador.carta(asCorazones, new Posicion(220, 40));
        Visualizador.carta(asTreboles, new Posicion(320, 40));
    }
}