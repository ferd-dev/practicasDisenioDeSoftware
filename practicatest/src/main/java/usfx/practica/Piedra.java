package usfx.practica;

import java.util.Arrays;

public class Piedra {
    int[] pesos;

    public Piedra(int[] _pesos) {
        pesos = _pesos;
    }

    public int minimaDiferenciaMontones() {
        int total = Arrays.stream(pesos).sum();
        boolean[] medio = new boolean[total + 1];
        medio[0] = true;

        for (int peso : pesos) {
            for (int j = total; j >= peso; j--) {
                medio[j] = medio[j - peso];
            }
        }

        int minDif = Integer.MAX_VALUE;
        for (int i = total / 2; i >= 0; i--) {
            if (medio[i]) {
                minDif = Math.min(minDif, total - 2 * i);
            }
        }

        return minDif;
    }
}
