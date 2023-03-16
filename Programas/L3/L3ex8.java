//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;

public class L3ex8 {

    public static double calculo(double n)
    {
        double total = 0;
        for(double i = n; i > 0; i--)
        {
            total = total + ((i*i + 1)/(i+3));
        }
        return total;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double n,x;
        System.out.println("Digite N ");
        n = sc.nextDouble();
        x = calculo(n);
        System.out.println("O total S é: " +x);
        sc.close();
        
    }
    
}
