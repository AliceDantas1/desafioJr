import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Poligono> poligonos = new ArrayList<>();

        while (true) {
            System.out.println("Informe o número de lados do polígono (3 para triângulo, 4 para quadrado) ou 0 para calcular as áreas:");
            int numLados = lerNumeroDeLados();

            if (numLados == 0) {
                break;
            }

            if (numLados != 3 && numLados != 4) {
                System.out.println("Número de lados inválido. Apenas triângulos (3 lados) e quadrados (4 lados) são aceitos.");
                continue;
            }

            System.out.println("Informe o tamanho do lado (em cm):");
            double tamanhoLado = lerTamanhoLado();

            if (tamanhoLado <= 0) {
                System.out.println("Tamanho do lado inválido. O valor deve ser positivo.");
                continue;
            }

            String tipo = numLados == 3 ? "Triângulo" : "Quadrado";
            poligonos.add(new Poligono(tipo, tamanhoLado));
        }

        calcularEExibirAreas(poligonos);
        scanner.close(); 
    }

    private static int lerNumeroDeLados() {
        while (true) {
            try {
                int numLados = scanner.nextInt();
                if (numLados >= 0) {
                    return numLados;
                } else {
                    System.out.println("Número de lados inválido. Por favor, insira um número inteiro não negativo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); 
            }
        }
    }

    private static double lerTamanhoLado() {
        while (true) {
            try {
                double tamanhoLado = scanner.nextDouble();
                if (tamanhoLado > 0) {
                    return tamanhoLado;
                } else {
                    System.out.println("Tamanho do lado inválido. Por favor, insira um valor positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número decimal.");
                scanner.next(); 
            }
        }
    }

    private static void calcularEExibirAreas(ArrayList<Poligono> poligonos) {
        double areaTotal = 0;

        for (Poligono poligono : poligonos) {
            System.out.println(poligono);
            areaTotal += poligono.area;
        }

        System.out.printf("Área total %.2f cm²%n", areaTotal);
    }
}
