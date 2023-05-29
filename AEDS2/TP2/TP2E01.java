public class TP2E01 {

    public static boolean ehFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String str = MyIO.readLine();
        Personagem personagem1 = new Personagem();
        while (ehFim(str) == false) {
            personagem1.ler(str);
            personagem1.imprimir();
            str = MyIO.readLine();
        }
    }

}
