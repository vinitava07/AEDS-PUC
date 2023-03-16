//VINICIUS TAVARES COIMBRA RIBEIRO
import java.util.Scanner;


public class L3ex9 {

    public static double media(double nota, double alunos)
    {
        double media = nota/alunos;
        return media;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double n,z = 0,x = 0;
        double cont = 0;
        while(true){//Loop infinito igual é pedido na questão
            System.out.println("Digite a nota ");
            n = sc.nextDouble();
            if(n >= 6)
            {   
                if(cont == 0)
                {
                    cont++;
                    z = media(n,cont);
                    x += z;
                    System.out.println("A média de notas dos alunos aprovados é: "+z);
                }
                else
                {
                    cont++;
                    x += n;
                    z = media(x,cont);
                    System.out.println("A média de notas dos alunos aprovados é: "+z);
                }
            }
            else{
            System.out.println("A média de notas dos alunos aprovados é: "+z);
            }
        }
    }
    
}