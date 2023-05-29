public class boolAlg {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean zeroOrOne(char L) {

        if (L == '0') {
            return false;
        }
        return true;

    }

    public static boolean avaliaNum(char L, String s) {

        if (L == 'A') {
            return zeroOrOne(s.charAt(2));
        } else if (L == 'B') {
            return zeroOrOne(s.charAt(4));
        } else {
            return zeroOrOne(s.charAt(6));
        }

    }

    public static boolean doExp(char exp, char A, char B, String s) {

        int nA, nB;
        boolean res;
        switch (exp) {
            case 'a':
                res = avaliaNum(A, s) && avaliaNum(B, s);
                break;
            case 'n':
                res = !avaliaNum(A, s);
                break;
            case 'o':
                res = avaliaNum(A, s) || avaliaNum(B, s);
                break;
            default:
                res = false;
                break;
        }

        return res;
    }

    public static boolean expDois(String s) {

        boolean res = true;
        int a = 0;
        for (int i = 6; i < s.length(); a++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'n' || s.charAt(i) == 'o') {
                if (s.charAt(i) == 'o') {
                    if (s.charAt(i + 3) == 'A' || s.charAt(i + 3) == 'B') {
                        res = doExp(s.charAt(i), s.charAt(i + 3), s.charAt(i + 7), s);
                    }
                    else{
                        i+=2;
                    }
                }
                if (s.charAt(i) == 'n') {
                    if (s.charAt(i + 4) == 'A' || s.charAt(i + 4) == 'B') {
                        res = doExp(s.charAt(i), s.charAt(i + 4), 'P', s);
                    }
                    else{
                        i+=3;
                    }
                } else {
                    if (s.charAt(i + 4) == 'A' || s.charAt(i + 4) == 'B') {
                        res = doExp(s.charAt(i), s.charAt(i + 4), s.charAt(i + 8), s);
                    }
                    else{
                        i+=3;
                    }
                }
            }
            i++;
            
        }
        return res;

    }

    public static boolean analisaExp(String s) {

        if (s.charAt(0) == '2') {
            return expDois(s);
        } else {
            // return expTres(s);
            return true;
        }

    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        int numEntrada = 0;
        entrada[numEntrada] = MyIO.readLine();
        while (!isFim(entrada[numEntrada])) {
            if (analisaExp(entrada[0])) {
                MyIO.println("1");
            } else {
                MyIO.println("0");
            }
            entrada[numEntrada] = MyIO.readLine();
        }

    }

}
