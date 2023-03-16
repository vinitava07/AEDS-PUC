import java.util.Scanner;

class L2ex2{

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int x,y;
        int p = 0, n = 0, z = 0,cont = 0,pp=0,pn=0,pz=0;
        System.out.println("Digite quantos inteiros você deseja inserir: ");
        x = sc.nextInt();
        for(int i = 0; i< x; i++)
        {
            System.out.println("Digite um número: ");
            y = sc.nextInt();
            if(y> 0)//if para verificar qual o numero digitado
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
            cont++;

        }
        System.out.printf("O numero de positivos é: %d\n", p);
        System.out.printf("O número de negativos é: %d\n", n);
        System.out.printf("O número de zeros é: %d\n", z);
        if(cont != 0)//realiza o calculo de porcentagem apenas quando há numeros digitados
        {
            pp = 100*p/cont;
            pn = 100*n/cont;
            pz = 100*z/cont;
        }
        System.out.printf("O numero de positivos é: %d%%\n", pp);
        System.out.printf("O número de negativos é: %d%%\n", pn);
        System.out.printf("O número de zeros é: %d%%", pz);
        sc.close();
    }

}