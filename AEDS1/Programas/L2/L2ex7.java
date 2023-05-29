import java.util.Scanner;

public class L2ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=0,b=0,c=0,d=0,n=0,br=0,voto;
        System.out.println("Digite o seu voto:");
        voto = sc.nextInt();
        while (voto != 0)
        {
            if(voto == 1)//if para verificar para quem é o voto, pode ser utilizado o switch
            {
                a++;
            }
            else if(voto == 2) 
            {
                b++;
            }
            else if(voto == 3)
            {
                c++;
            }
            else if(voto == 4)
            {
                d++;
            }
            else if (voto == 5) 
            {
                n++;
            }
            else if (voto == 6) 
            {
                br++;
            }
            System.out.println("Digite o seu voto:");
            voto = sc.nextInt();
        }
        System.out.printf("Votos para o candidato 1: %d\nVotos para o candidato 2: %d\nVotos para o candidato 3: %d\nVotos para o candidato 4: %d\n", a,b,c,d);
        System.out.printf("Votos em branco: %d\n", br);
        System.out.printf("Votos nulos: %d\n", n);
        
        sc.close();
    }
    
}