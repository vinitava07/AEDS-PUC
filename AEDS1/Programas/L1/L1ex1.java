//Vinícius Tavares Coimbra Ribeiro

import java.util.Scanner;

class L1ex1{

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int x,y;
        System.out.println("Digite um número");
        x = sc.nextInt();
        System.out.println("Digite uo 2º numero");
        y = sc.nextInt();
        x = x+ y;
        if(x >= 10) //Verifica se o número é maior ou igual a 10
        {
            x = x+ 5;
        }
        else//Se não soma 7
        {
            x =x +7;
        }
        System.out.printf("Numero final: %d", x);
        sc.close();
    }

}