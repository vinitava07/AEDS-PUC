public class cifraCesar {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void ciframento(String s) {

        String nova = "";
        int letra;

        for (int i = 0; i < s.length(); i++) {

            letra = (int) s.charAt(i) + 3;
            nova += (char) letra;

        }
        MyIO.println(nova);
    }

    public static void main(String[] args) {
        int numEntrada = 0;
        String[] entrada = new String[1000];
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;
        for (int i = 0; i < numEntrada; i++) {

            ciframento(entrada[i]);
        }

    }

}
