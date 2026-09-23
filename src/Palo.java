public enum Palo {
    CORAZONES("CORAZONES"),
    DIAMANTES("DIAMANTES"),
    TREBOLES("TRÉBOLES"),
    ESPADAS("ESPADAS");

    private final String nombre;

    Palo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}