import java.util.Scanner;

class Programa{

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int x,y;
        int p = 0, n = 0, z = 0;
        System.out.println("Digite quantos inteiros você deseja inserir: ");
        x = sc.nextInt();
        for(int i = 0; i< x; i++)
        {
            System.out.println("Digite um número: ");
            y = sc.nextInt();
            if(y> 0)
            {
                p++;
            }
            else if(y<0)
            {
                n++;
            }
            else
            {
                z++;
            }

        }
        System.out.printf("O numero de positivos é: %d\n", p);
        System.out.printf("O número de negativos é: %d\n", n);
        System.out.printf("O número de zeros é: %d", z);
        sc.close();
        
    }

}