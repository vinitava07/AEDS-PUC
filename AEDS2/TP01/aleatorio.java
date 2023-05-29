import java.util.Random;

public class aleatorio {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String altAl(String entrada, char a, char b) {

        StringBuilder nova = new StringBuilder();
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == a) {
                nova.append(b);
            } else {
                nova.append(entrada.charAt(i));
            }

        }

        return nova.toString();
    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        char a, b;
        int numEntrada = 0;
        Random gerador = new Random();
        gerador.setSeed(4);
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;
        for (int i = 0; i < numEntrada; i++) {
            a = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            b = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            entrada[i] = altAl(entrada[i], a, b);
            MyIO.println(entrada[i]);
        }

    }

}
