public class TP1E15 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean real(String s, int i, int v) {

        
        
        s = s.toLowerCase();
        if (i < s.length()) {
            if (s.charAt(i) == ',' || s.charAt(i) == '.') {
                v++;
            }
            if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ',' && s.charAt(i) != '.') {

                return false;
            }
            if (v > 1) {
                return false;
            }
            return real(s, ++i,v);
        }
        return true;

    }

    public static boolean inteiro(String s,int i) {

        s = s.toLowerCase();
        if (i < s.length()) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {

                return false;
            }
            return inteiro(s, ++i);
        }
        return true;

    }

    public static boolean consoante(String s, int i) {


        s = s.toLowerCase();
        if (i < s.length()) {
            if ((s.charAt(i) < 97) || (s.charAt(i) > 122)) {
                return false;
            } else if (!(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o'
                    && s.charAt(i) != 'u')) {
                return false;
            }
            return consoante(s, ++i);
        }
        return true;
    }

    public static boolean vogal(String s, int i) {

        s = s.toLowerCase();
        if (i < s.length()) {
            if ((s.charAt(i) < 97 || s.charAt(i) > 122)) {
                return  false;
            } else if (!(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u')) {
                return false;
            }
            return vogal(s, ++i);
        }
        return true;
        
    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        int numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();

        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;
        for (int i = 0; i < numEntrada; i++) {
            if (vogal(entrada[i],0)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (consoante(entrada[i],0)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (inteiro(entrada[i],0)) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (real(entrada[i],0,0)) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NAO");
            }
            System.out.println();

        }
    }

}
