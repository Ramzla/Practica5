public class Main {
    public static void main(String[] args) {
        Visualizador.carta(new Carta(1, Palo.ESPADAS), new Posicion(20, 40));
        Visualizador.carta(new Carta(12, Palo.CORAZONES), new Posicion(120, 40));
        Visualizador.carta(new Carta(7, Palo.DIAMANTES), new Posicion(220, 40));
    }
}