import java.lang.*;
import java.io.*;

public class TP1E5 {

    public static int strSize = 0;
    public static char respFinal;

    public static boolean isFim(String s) {
        return (s.length() == 1 && s.charAt(0) == '0');
    }

    public static String and(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                return "0";
            }

        }
        return "1";

    }

    public static String or(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return "1";
            }

        }
        return "0";

    }

    public static String not(char A) {

        // System.out.println("char not" +A);
        if (A == '1') {
            return "0";
        }
        return "1";

    }

    public static int temExp(StringBuilder s, int x) {

        int a = 0;
        for (int i = x; i < strSize; i++) {
            if ((s.charAt(i) != '1' && s.charAt(i) != '0') && s.charAt(i) != '(' && s.charAt(i) != ')') {
                // System.out.println(s.charAt(i));
                // System.out.println("i:" + i);
                a++;
            }

        }
        return a;

    }

    public static int fechaParen(StringBuilder s, int x) {

        for (int i = x; i < strSize; i++) {
            if ((s.charAt(i) == ')')) {
                return i;
            }

        }
        return 0;

    }

    public static int temZero(StringBuilder s, int x) {

        int a = 0;
        for (int i = x; i < strSize; i++) {
            if ((s.charAt(i) == '1' || s.charAt(i) == '0')) {
                a++;
            }

        }
        return a;

    }

    public static boolean intToBool(int x) {

        if (x > 0) {
            return true;
        }
        return false;
    }

    public static void evaluator1(StringBuilder s, int i) {

        int temExpr = 0;
        while (i < strSize - 1){
            temExpr = temExp(s, i + 2);
            if (s.charAt(i) == 'a') {
                if (temExpr > 0) {
                    i += 2;
                } else {

                    int fecha = fechaParen(s, i);
                    String resp = "";
                    resp += (and(s.substring(i + 2, fecha)));
                    // System.out.println("No comeco: "+strSize);
                    s.replace(i, fecha + 1, resp);
                    strSize = s.length();
                    // System.out.println("No final: " +strSize);
                    i = 0;
                    // System.out.println("string final: " +s);

                }

            } else if (s.charAt(i) == 'n') {
                if (temExpr > 0) {
                    i += 2;
                } else {
                    int fecha = fechaParen(s, i);
                    String resp = "";
                    resp += not(s.charAt(i + 2));
                    // System.out.println("No comeco: "+not(s.charAt(i)));
                    s.replace(i, fecha + 1, resp);
                    strSize = s.length();
                    // System.out.println("No final: " +strSize);
                    i = 0;
                    // System.out.println("string final: " +s);
                }
            } else if (s.charAt(i) == 'o') {
                if (temExpr > 0) {
                    i += 2;
                } else {
                    // System.out.println("teste");

                    int fecha = fechaParen(s, i);
                    String resp = "";
                    resp += (or(s.substring(i + 2, fecha)));
                    // System.out.println("No comeco: "+strSize);
                    s.replace(i, fecha + 1, resp);
                    strSize = s.length();
                    // System.out.println("No final: " +strSize);
                    i = 0;

                }
            } else {
                i += 1;
            }
    }
            System.out.println(s);
        
    }

    public static void remonta(String s) {

        StringBuilder novaExp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a') {

                novaExp.append("a");
                i += 2;

            } else if (s.charAt(i) == 'o') {
                novaExp.append("o");
                i += 1;

            } else if (s.charAt(i) == 'n') {
                novaExp.append("n");
                i += 2;
            } else if (s.charAt(i) == 'A') {
                novaExp.append(s.charAt(2));

            } else if (s.charAt(i) == 'B') {
                novaExp.append(s.charAt(4));

            } else if (s.charAt(i) == 'C') {
                novaExp.append(s.charAt(6));

            } else if (s.charAt(i) == '(') {
                novaExp.append("(");

            } else if (s.charAt(i) == ')') {
                novaExp.append(")");

            }

        }
        strSize = novaExp.length();
        // System.out.println(novaExp);

        evaluator1(novaExp, 0);

    }

    public static void main(String[] args) {

        String[] entrada = new String[1000];
        int numEntrada = 0;
        entrada[numEntrada] = MyIO.readLine();
        while (!isFim(entrada[numEntrada])) {
            remonta(entrada[numEntrada]);
            entrada[numEntrada] = MyIO.readLine();
        }

    }

}
