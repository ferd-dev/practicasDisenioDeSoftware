package usfx.practica;

public class Main {
    public static void main(String[] args) {
        int[] pesos = {5, 8, 13, 27, 14};
        //int[] pesos = {100, 50, 20, 20, 10};
        Piedra piedra = new Piedra(pesos);
        System.out.println(piedra.minimaDiferenciaMontones());
    }
}