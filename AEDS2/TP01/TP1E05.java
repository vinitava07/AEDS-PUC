import java.lang.*;
import java.io.*;

public class TP1E05 {

    public static int strSize = 0;
    public static char respFinal;

    public static boolean isFim(String s) {
        return (s.length() == 1 && s.charAt(0) == '0');
    }

    public static String and(String s) {

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                return "0";
            }
            
        }
        return "1";

    }

    public static String or(String s) {

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                return "1";
            }
            
        }
        return "0";

    }

    public static String not(char A) {

    //    System.out.println("char not" +A);
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

        int temExpr = temExp(s, i + 2);
        // System.out.println(temExpr);
         if (i < strSize-1) {
            if (s.charAt(i) == 'a') {
                if (temExpr > 0) {
                    evaluator1(s, i + 2);
                } else {

                    int fecha = fechaParen(s, i);
                    String resp = "";
                    resp += (and(s.substring(i+2, fecha)));
                    // System.out.println("No comeco: "+strSize);
                    s.replace(i,fecha+1,resp);
                    strSize = s.length();
                    // System.out.println("No final: " +strSize);
                    evaluator1(s, 0);
                    // System.out.println("string final: " +s);

                }

            }
            else if (s.charAt(i) == 'n') {
                if (temExpr > 0) {
                    evaluator1(s, i + 2);
                } else {
                    int fecha = fechaParen(s, i);
                    String resp = "";
                    resp += not(s.charAt(i+2));
                    // System.out.println("No comeco: "+not(s.charAt(i)));
                    s.replace(i,fecha+1,resp);
                    strSize = s.length();
                    // System.out.println("No final: " +strSize);
                    evaluator1(s, 0);
                    // System.out.println("string final: " +s);
                }
            }
            else if(s.charAt(i) == 'o'){
                if (temExpr > 0) {
                    evaluator1(s, i + 2);
                } else {
                    // System.out.println("teste");

                    int fecha = fechaParen(s, i);
                    String resp = "";
                    resp += (or(s.substring(i+2, fecha)));
                    // System.out.println("No comeco: "+strSize);
                    s.replace(i,fecha+1,resp);
                    strSize = s.length();
                    // System.out.println("No final: " +strSize);
                    evaluator1(s, 0);

                }
            }
            else{
                evaluator1(s, i+1);
            }
        }
        else {
        System.out.println(s);
        }



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
            // MyIO.println(respFinal);
            entrada[numEntrada] = MyIO.readLine();
        }

    }

}
// public static void evaluator(String s, int i) {

// // String respFinal = "";
// char[] st = s.toCharArray();
// char sub;
// boolean a;
// int temExpr;
// int temOper;
// int temOper2;

// if (i < strSize) {
// // System.out.println("i: " +i);
// // System.out.println("tamanho string: " + strSize);
// System.out.println("string inicio: " + s);
// // if (strSize <= 2) {
// // respFinal = s.charAt(0);
// // }
// // System.out.println("i: " + i);
// temExpr = temExp(s, i + 1);
// temOper = temZero(s, i + 1);
// temOper2 = temOper;
// // System.out.println("char detectado: " + s.charAt(i));
// // System.out.println("temExpr: " + temExpr);
// // System.out.println("temOper: " + temOper);

// if (s.charAt(i) == 'a') { // VERIFICAR TEM0
// if (temExpr == 0) {
// if (temOper > 2) {
// for (int j = 0; j < temOper - 1; j++) {
// System.out.println(s);
// System.out.println("i + temoper -1:" + (i + temOper2 - 1));
// System.out.println((i + temOper2));
// sub = and(s.charAt(i + temOper2 - 1), s.charAt(i + temOper2));
// st[i + temOper2 - 1] = sub;

// System.out.println(sub);

// // System.out.println(s.charAt(i+temOper2-1) );
// for (int k = i + temOper2 - 1; k < strSize; k++) {
// st[k] = st[k + 2];
// }
// if (j == temOper - 1) {
// strSize -= 2;
// } else {
// strSize--;
// }
// s = String.valueOf(st);
// // System.out.println(s);
// temOper2--;

// }
// evaluator(s, temExpr);

// } else {
// sub = and(s.charAt(i + 1), s.charAt(i + 2));
// st[i] = sub;
// // System.out.println("AND FINAL: "+sub);
// for (int j = i + 1; j < st.length - 2; j++) {
// st[j] = st[j + 2];
// }
// s = String.valueOf(st);
// // System.out.println(s);
// strSize -= 2;
// evaluator(s, temExpr);
// }
// } else {
// evaluator(s, temExpr);

// }

// } else if (s.charAt(i) == 'o') {
// if (temExpr == 0) {
// if (temOper > 2) {
// for (int j = 0; j < temOper - 1; j++) {
// // System.out.println(i);
// sub = or(s.charAt(i + temOper2 - 1), s.charAt(i + temOper2));
// st[i + temOper2 - 2] = sub;
// // System.out.println("i + temoper -1:" + (i + temOper2 - 1));
// // System.out.println(st);

// // System.out.println(s.charAt(i+temOper2-1) );
// // System.out.println(s.charAt(i + temOper2) );
// for (int k = i + temOper2 - 1; k < strSize; k++) {
// st[k] = st[k + 2];
// }
// if (j == temOper - 1) {
// strSize -= 2;
// } else {
// strSize--;
// }
// s = String.valueOf(st);
// // System.out.println(s);
// temOper2--;

// }
// evaluator(s, temExpr);

// } else {
// sub = or(s.charAt(i + 1), s.charAt(i + 2));
// st[i] = sub;
// // System.out.println("AND FINAL: "+sub);
// for (int j = i + 1; j < st.length - 2; j++) {
// st[j] = st[j + 2];
// }
// s = String.valueOf(st);
// // System.out.println(s);
// strSize -= 2;
// evaluator(s, temExpr);
// }
// } else {
// evaluator(s, temExpr);

// }
// } else if (s.charAt(i) == 'n') {
// // System.out.println("entrou not");
// // System.out.println("i+1: " +strSize);
// if ((s.charAt(i + 1) == '0' || s.charAt(i + 1) == '1')) {
// sub = not(s.charAt(i + 1));
// st[i] = (char) sub;

// for (int j = i + 1; j < st.length - 1; j++) {
// st[j] = st[j + 1];
// }
// s = String.valueOf(st);
// strSize -= 1;
// // System.out.println("string no not: " +s);

// evaluator(s, 0);

// } else {
// evaluator(s, i += 1);
// }
// }
// }

// // MyIO.println(s.charAt(0));

// }