//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;
public class L3ex4 {

    public static void valida(double lado1, double lado2, double lado3)
    {
        if ((lado1 < lado2 + lado3) && (lado2 < lado1 + lado3) && (lado3 < lado1 + lado2)) {
            if (lado1 == lado2 && lado1 == lado3) {
                System.out.println("Triangulo Equilatero");
            } else if ((lado1 == lado2) || (lado1 == lado3)) {
                System.out.println("Triangulo Isosceles");
            } else
                System.out.println("Triângulo Escaleno");
        } else {
            System.out.println("Não é um triangulo!");
        }
    }
    public static void main(String[] args) {
        double lado1, lado2, lado3;
    
            Scanner sc = new Scanner(System.in);
    
            System.out.println("Entre com o lado 1:");
            lado1 = sc.nextDouble();
            System.out.println("------------------------------------------------");
            System.out.println("Entre com lado 2:");
            lado2 = sc.nextDouble();
            System.out.println("------------------------------------------------");
            System.out.println("Entre com lado 3:");
            lado3 = sc.nextDouble();
            System.out.println("------------------------------------------------");
            valida(lado1,lado2,lado3);
            System.out.println("------------------------------------------------");
            sc.close();
    }
}
        
