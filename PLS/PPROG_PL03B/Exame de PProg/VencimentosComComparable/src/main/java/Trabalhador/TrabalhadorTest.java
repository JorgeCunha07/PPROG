package Trabalhador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrabalhadorTest {


    @Test
    void calcularVencimento() {
        TrabalhadorHora ta = new TrabalhadorHora("a", 200, 2);
        TrabalhadorHora tb = new TrabalhadorHora("b", 160, 1);
        float expected1 = 400, expected2 = 160;
        assertEquals(ta.calcularVencimento(),expected1);
        assertEquals(tb.calcularVencimento(),expected2);
    }

    @Test
    void compareTo() {
        TrabalhadorHora ta = new TrabalhadorHora("a", 200, 2);
        TrabalhadorHora tb = new TrabalhadorHora("b", 160, 1);
        float expected = 1;
        float compare = ta.compareTo(tb);
        assertEquals(expected,compare);
    }
}