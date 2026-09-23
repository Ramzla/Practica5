import java.util.List;

public class Juego {

    public static void main(String[] args) {
        // 1. INICIALIZACIÓN
        System.out.println("=== CONFIGURANDO MAZO DE 52 CARTAS ===");
        Mazo mazo = new Mazo();
        System.out.println("-> Baraja inicializada con " + mazo.getCantidadCartasRestantes() + " naipes.\n");

        // 2. MUESTRA INICIAL
        System.out.println(">>> Muestra de las primeras 5 cartas (Orden original):");
        System.out.println(mazo.obtenerPrimerasCartas(5) + "\n");

        // 3. BARAJA
        System.out.println("=== MEZCLANDO LA BARAJA ===");
        mazo.barajar();
        System.out.println("-> ¡El mazo ha sido mezclado correctamente!\n");

}