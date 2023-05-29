//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;

public class L3ex1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double a,b,c,n;
        char x;
        System.out.println("Digite a quantidade de alunos: ");
        n = sc.nextDouble();
        for(int i = 1; i <= n; i++)
        {
            System.out.println("Digite a primeira nota: ");
            a = sc.nextDouble();
            System.out.println("Digite a segunda nota: ");
            b = sc.nextDouble();
            System.out.println("Digite a terceira nota: ");
            c = sc.nextDouble();
            System.out.println("Digite o procedimento: ");
            x = sc.next().charAt(0);
            sc.nextLine();
            media(a,b,c,x,i);
        }
        sc.close();
        
    }
    public static void media(double a, double b, double c, char x, int i)
    {
        if(x == 'p' || x == 'P')
        {
            
            double z;
            z = ((a*5)+(b*3)+(c*2))/3;
            System.out.printf("A média ponderada do aluno %d é: %.2f\n",i,z);
        }
        else if(x == 'A' || x == 'a')
        {
            double z;
            z = (a+b+c)/3;
            System.out.printf("A média aritimética do aluno %d é: %.2f\n",i,z);
        }
    }
    
    
}


