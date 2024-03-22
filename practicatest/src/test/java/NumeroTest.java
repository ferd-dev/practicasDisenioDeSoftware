import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import usfx.practica.Numero;

import static org.junit.jupiter.api.Assertions.*;

public class NumeroTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23})
    void numerosPrimos(int n) {
        Numero numero = new Numero();
        assertTrue(numero.esPrimo(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20})
    void numerosNoPrimos(int n) {
        Numero numero = new Numero();
        assertFalse(numero.esPrimo(n));
    }

    @Test
    void siElNumeroEsCero() {
        Numero numero = new Numero();
        assertFalse(numero.esPrimo(0));
    }

    @Test
    void siElNumeroEsUno() {
        Numero numero = new Numero();
        assertFalse(numero.esPrimo(1));
    }

    @Test
    void siElNumeroEsPrimo() {
        Numero numero = new Numero();
        assertTrue(numero.esPrimo(7));
    }

    @Test
    void siElNumeroNoEsPrimo() {
        Numero numero = new Numero();
        assertFalse(numero.esPrimo(4));
    }

    @Test
    void siElNumeroEsNegativo() {
        Numero numero = new Numero();
        assertFalse(numero.esPrimo(-7));
    }

    @Test
    void verificarElMaximoNumero() {
        Numero numero = new Numero();
        assertTrue(numero.esPrimo(Integer.MAX_VALUE));
    }

    @Test
    void verificarElMinimoNumero() {
        Numero numero = new Numero();
        assertFalse(numero.esPrimo(Integer.MIN_VALUE));
    }
}
