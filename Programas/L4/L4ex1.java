import java.util.Scanner;

public class L4ex1 {
    
    public static int soma(int x)
    {   
        if(x<10)
        {
                return x;//caso seja menor que 10 o algarismo é o próprio numero.
        }
        return (x%10) + soma(x/10);//soma o resto com o retorno da divisão para separar o numero em partes, como INT não usa decimal o retorno funcionara apenas pra parte inteira.
        

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n,x;
        System.out.println("Digite o número INTEIRO: ");
        n = sc.nextInt();
        x = soma(n);
        System.out.println("Resultado da soma dos algarismos: "+x);
        
    }
}
