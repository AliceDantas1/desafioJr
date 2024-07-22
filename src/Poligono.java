public class Poligono {
    String tipo;
    double lado;
    double area;

    public Poligono(String tipo, double lado) {
        this.tipo = tipo;
        this.lado = lado;
        this.area = calcularArea();
    }

    private double calcularArea() {
        switch (tipo) {
            case "Triângulo":
                return (Math.sqrt(3) / 4) * Math.pow(lado, 2);
            case "Quadrado":
                return Math.pow(lado, 2);
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s de lado %.2f cm e área %.2f cm²", tipo, lado, area);
    }
}
