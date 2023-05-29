import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TP1E08 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void padroesPagina(String s) {

        int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0, x9 = 0, x10 = 0, x11 = 0, x12 = 0, x13 = 0,
                x14 = 0, x15 = 0, x16 = 0, x17 = 0, x18 = 0, x19 = 0, x20 = 0, x21 = 0, x22 = 0, x23 = 0, x24 = 0,
                x25 = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (Character.toString(s.charAt(i))) {
                case "a":
                    x1++;
                    break;
                case "e":
                    x2++;
                    break;
                case "i":
                    x3++;
                    break;
                case "o":
                    x4++;
                    break;
                case "u":
                    x5++;
                    break;
                case "\u00e1":
                    x6++;
                    break;
                case "\u00e9":
                    x7++;
                    break;
                case "\u00ed":
                    x8++;
                    break;
                case "\u00f3":
                    x9++;
                    break;
                case "\u00fa":
                    x10++;
                    break;
                case "\u00e0":
                    x11++;
                    break;
                case "\u00e8":
                    x12++;
                    break;
                case "\u00ec":
                    x13++;
                    break;
                case "\u00f2":
                    x14++;
                    break;
                case "\u00f9":
                    x15++;
                    break;
                case "\u00e3":
                    x16++;
                    break;
                case "\u00f5":
                    x17++;
                    break;
                case "\u00e2":
                    x18++;
                    break;
                case "\u00ea":
                    x19++;
                    break;
                case "\u00ee":
                    x20++;
                    break;
                case "\u00f4":
                    x21++;
                    break;
                case "\u00fb":
                    x22++;
                    break;
                default:
                    if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                        x23++;
                    }
                    break;
            }
            if (s.charAt(i) == '<' && s.charAt(i + 1) == 'b' && s.charAt(i + 2) == 'r' && s.charAt(i + 3) == '>') {
                x24++;
            } else if (s.charAt(i) == '<' && s.charAt(i + 1) == 't' && s.charAt(i + 2) == 'a' && s.charAt(i + 3) == 'b'
                    && s.charAt(i + 4) == 'l' && s.charAt(i + 5) == 'e' && s.charAt(i + 6) == '>') {
                x25++;
            }
        }
        System.out.printf(
                "a(%d) e(%d) i(%d) o(%d) u(%d) \u00e1(%d) \u00e9(%d) \u00ed(%d) \u00f3(%d) \u00fa(%d) \u00e0(%d) \u00e8(%d) \u00ec(%d) \u00f2(%d) \u00f9(%d) \u00e3(%d) \u00f5(%d) \u00e2(%d) \u00ea(%d) \u00ee(%d) \u00f4(%d) \u00fb(%d) consoante(%d) <br>(%d) <table>(%d) ",
                x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22,
                x23, x24, x25);

    }

    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    public static void main(String[] args) {
        String entradaLink, entradaNome, html;
        int numEntrada = 0;
        Scanner s = new Scanner(System.in, "utf-8");

        do {
            entradaNome = s.nextLine();
            if (!isFim(entradaNome)) {
                entradaLink = s.nextLine();
                html = getHtml(entradaLink);
                padroesPagina(html);
                System.out.println(entradaNome);
            }

        } while (!isFim(entradaNome));
        s.close();
    }

}
