public class TP1E13 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String ciframento(String s, int i) {

        char[] st = s.toCharArray();
        
        int letra;
        if (i < s.length()) {
            letra = s.charAt(i) + 3;
            st[i] = (char) letra;
            // System.out.println( letra);
            s = String.valueOf(st);

            ciframento(s, ++i);
        }
        else{
            MyIO.println(s);
        }
        return s;
    }

    public static void main(String[] args) {
        int numEntrada = 0;
        String[] entrada = new String[1000];
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;
        for (int i = 0; i < numEntrada; i++) {

            entrada[i] = ciframento(entrada[i], 0);
        }

    }

}
