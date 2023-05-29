public class TP1E06 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean real(String s) {

        boolean res = true;
        int i = 0;
        int v = 0;
        s = s.toLowerCase();
        while (res && i < s.length()) {

            if(s.charAt(i) == ',' || s.charAt(i) == '.')  {
                v++;
            }
            if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ',' && s.charAt(i) != '.') {

                res = false;
            }
            i++;
        }
        if(v > 1) {
            res = false;
        }

        return res;

    }

    public static boolean inteiro(String s) {
        boolean res = true;
        int i = 0;
        s = s.toLowerCase();
        while (res && i < s.length()) {

            if (s.charAt(i) < '0' || s.charAt(i) > '9') {

                res = false;
            }
            i++;
        }

        return res;
    }

    public static boolean consoante(String s) {
        boolean res = true;
        int i = 0;
        s = s.toLowerCase();
        while (res && i < s.length()) {

            if ((s.charAt(i) < 97) || (s.charAt(i) > 122)) {
                res = false;
            } else if (!(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o'
                    && s.charAt(i) != 'u')) {
                res = false;
            }
            i++;
        }

        return res;
    }

    public static boolean vogal(String s) {

        boolean res = true;
        int i = 0;
        s = s.toLowerCase();
        while (res && i < s.length()) {

            if ((s.charAt(i) < 97 || s.charAt(i) > 122)) {
                res = false;
            } else if (!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u')) {
                res = false;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        int numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();

        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;
        for (int i = 0; i < numEntrada; i++) {
            if (vogal(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (consoante(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (inteiro(entrada[i])) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (real(entrada[i])) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NAO");
            }
            System.out.println();

        }
    }

}
