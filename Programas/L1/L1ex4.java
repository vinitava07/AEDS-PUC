import java.util.Scanner;
//Vinícius Tavares Coimbra Ribeiro
public class L1ex4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double salario,tsalario = 0,media,maior = 0,p100 = 0,t100,filhos;
        int cont = 0,tfilhos = 0;
        System.out.println("Digite o salário: ");
        salario = sc.nextDouble();
        while(salario >=0)//Loop para perguntar os salários e os filhos
        {
            System.out.println("Digite a quantidade de filhos: ");
            filhos = sc.nextInt();
            tfilhos += filhos;//Total de filhos
            if(salario<100)//Conta a quantidade de pessoas com salario<100
            {
                p100++;
            } 
            if( salario > maior)//Atualiza o maior salário
            {
                maior = salario;
            }
            tsalario = salario + tsalario;//Soma dos salarios
            cont++;//conta a quantidade de usuários
            System.out.println("Digite o salário: ");
            salario = sc.nextDouble();
        }
        t100 = 100*p100/cont;//Porcentagem de pessoas com salario < 100
        media = tsalario/cont;//Media dos salarios
        filhos = tfilhos/cont;//Media dos filhos
        System.out.printf("A média do salario da população é: %.2f\n", media);
        System.out.printf("A média do número de filhos é: %.2f\n", filhos);
        System.out.printf("O maior salário é: %.2f\n", maior);
        System.out.printf("O percentual de pessoas com salário até 100 é: %.2f%%\n", t100);
        sc.close();
    }
    
}
