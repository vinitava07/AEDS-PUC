public class TP1E11 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean ehPalindromo(String s, int i, int j) {

        boolean palin = true;

        if ((i < s.length() - 1 / 2)) {
            if (s.charAt(i) == s.charAt(j)) {
                palin = ehPalindromo(s, ++i, --j);
            } else {
                palin = false;
            }
        }
        return palin;

    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;
        for (int i = 0; i < numEntrada; i++) {

            if (ehPalindromo(entrada[i], 0, entrada[i].length() - 1)) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
        }
    }

}