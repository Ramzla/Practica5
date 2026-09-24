import java.util.List;

public class Juego {

    public static void main(String[] args) {
        // 1. INICIAR
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

        // 4. MUESTRA POST-BARAJADO
        System.out.println(">>> Muestra de las primeras 5 cartas (Tras barajar):");
        System.out.println(mazo.obtenerPrimerasCartas(5) + "\n");

        // 5. REGISTRO DE JUGADORES
        System.out.println("=== REGISTRANDO 3 JUGADORES ===");
        Jugador j1 = new Jugador("Ana");
        Jugador j2 = new Jugador("Carlos");
        Jugador j3 = new Jugador("María");

        System.out.println("• Jugador 1: " + j1.nombre);
        System.out.println("• Jugador 2: " + j2.nombre);
        System.out.println("• Jugador 3: " + j3.nombre + "\n");

        List<Jugador> jugadores = List.of(j1, j2, j3);

        // 6. REPARTO
        System.out.println("=== REPARTIENDO 5 CARTAS A CADA PARTICIPANTE ===");
        mazo.repartir(jugadores, 5);
        System.out.println("-> ¡Reparto completado con éxito!\n");

        // 7. ESTADO DE LAS MANOS
        System.out.println("=== CARTAS ASIGNADAS A CADA JUGADOR ===");
        for (Jugador j : jugadores) {
            System.out.println(j.toString());
        }
        System.out.println();

        // 8. ESTADO DEL MAZO
        System.out.println("=== ESTADO DEL MAZO TRAS REPARTIR ===");
        System.out.println("-> Naipes disponibles en reserva: " + mazo.getCantidadCartasRestantes());
        System.out.println("-> Próximas 5 cartas en la pila: " + mazo.obtenerPrimerasCartas(5) + "\n");

        // 9. LA PILA DE CARTAS (Devolución)
        System.out.println("=== GESTIÓN DE PILA (DEVOLVER CARTA AL MAZO) ===");
        Carta descartada = j1.deshacerseDeCarta(0);
        System.out.println("-> " + j1.nombre + " ha descartado la carta: " + descartada);

        mazo.agregarCartaPila(descartada); // <--- Uso explícito del método requerido
        System.out.println("-> Carta regresada con éxito al mazo.");
        System.out.println("-> Naipes en reserva actualizados: " + mazo.getCantidadCartasRestantes());
    }
}