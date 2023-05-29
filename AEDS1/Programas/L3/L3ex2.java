//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;

public class L3ex2 {

    public static void media(Scanner sc){

        int n,f;
        double salario = 0,t = 0;
        System.out.println("Digite a quantide de habitantes:");
        n = sc.nextInt();
        for(int i = 0; i < n; i++)//Loop para perguntar os salários e os filhos
        {
            System.out.println("Digite o salário:");
            salario = sc.nextDouble();
            System.out.println("Digite o número de filhos:");
            f = sc.nextInt();
            t += salario;
        }
        salario = t/n;
        System.out.printf("A média salarial é: %.2f",salario);

    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        media(sc);
        sc.close();
    }
    
}
