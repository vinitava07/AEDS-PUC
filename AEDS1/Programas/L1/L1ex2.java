import java.util.Scanner;

//Vinícius Tavares Coimbra Ribeiro
public class L1ex2 {
    public static void main(String[] args) {

        double x;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua nota: ");
        x = sc.nextDouble();
        if(x < 5) //Verifica se o numero digitado está entre as categorias da tabela
        {
            System.out.println("Insatisfatório");
        }
        else if( x>= 5 && x <7)
        {
            System.out.println("Regular");
        }
        else if(x >= 7 && x< 8)
        {
            System.out.println("Bom");
        }
        else if(x >= 8 && x<=10)
        {
            System.out.println("Ótimo");
        }
        sc.close();
    }

    
}
