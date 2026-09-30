public class Visualizador {

    public static void carta(Carta c, Posicion p) {
        if (c == null || p == null) {
            return;
        }

        String color = (c.getTipo() == Palo.CORAZONES || c.getTipo() == Palo.DIAMANTES) ? "red" : "black";

        cuadrado(p.getX(), p.getY(), 70, "black");
        cuadrado(p.getX() + 3, p.getY() + 3, 64, "white");

        int cx = p.getX() + 35;
        int cy = p.getY() + 35;

        switch (c.getTipo()) {
            case CORAZONES -> {
                circulo(cx - 24, cy - 21, 26, color);
                circulo(cx - 2, cy - 21, 26, color);
                triangulo(cx, cy + 24, -24, 46, color);
            }
            case DIAMANTES -> {
                triangulo(cx, cy - 26, 26, 34, color);
                triangulo(cx, cy + 26, -26, 34, color);
            }
            case TREBOLES -> {
                circulo(cx - 10, cy - 24, 20, color);
                circulo(cx - 24, cy - 6, 20, color);
                circulo(cx + 4, cy - 6, 20, color);
                triangulo(cx, cy + 4, 22, 18, color);
            }
            case ESPADAS -> {
                triangulo(cx, cy - 26, 28, 44, color);
                circulo(cx - 22, cy - 6, 24, color);
                circulo(cx - 2, cy - 6, 24, color);
                triangulo(cx, cy + 12, 14, 16, color);
            }
        }

        System.out.println("Desplegando gráficamente " + c + " en la posición (" + p.getX() + ", " + p.getY() + ")");
    }

    private static void cuadrado(int x, int y, int lado, String color) {
        Square s = new Square();
        s.changeSize(lado);
        s.changeColor(color);
        s.moveHorizontal(x - 310);
        s.moveVertical(y - 120);
        s.makeVisible();
    }

    private static void circulo(int x, int y, int diametro, String color) {
        Circle ci = new Circle();
        ci.changeSize(diametro);
        ci.changeColor(color);
        ci.moveHorizontal(x - 230);
        ci.moveVertical(y - 90);
        ci.makeVisible();
    }

    private static void triangulo(int x, int y, int alto, int ancho, String color) {
        Triangle t = new Triangle();
        t.changeSize(alto, ancho);
        t.changeColor(color);
        t.moveHorizontal(x - 210);
        t.moveVertical(y - 140);
        t.makeVisible();
    }
}