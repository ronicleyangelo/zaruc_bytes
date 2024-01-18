package org.example;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;

import static java.lang.System.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String entradaBase64 = "BSAAAAAJAAABrAACAAIAAQAEAAMAAAAAAAAAAAAAAAAAAAAAAAA=";
        byte[] decodeBase64 = Base64.getDecoder().decode(entradaBase64);

        ByteBuffer byteBuffer = ByteBuffer.wrap(decodeBase64);

        int quantidadeRegistro = decodeBase64[0];
        int nivelDaBateria = decodeBase64[1];

        int relojoaria01H6 = byteBuffer.getInt(2);
        int relojoaria02H6 = byteBuffer.getInt(6);

        int[] consumoRL01 = new int[10];
        int[] consumoRL02 = new int[10];
        byte[] range  = Arrays.copyOfRange(decodeBase64, 10,20);
        byte[] range2 = Arrays.copyOfRange(decodeBase64, 28, 37);

        System.out.println("<QT de registro>: "   + quantidadeRegistro);
        System.out.println("<Nível da bateria>: " + nivelDaBateria);
        System.out.println("<Relojoaria 01 H6>: " + relojoaria01H6);
        System.out.println("<Relojoaria 02 H6>: " + relojoaria02H6);

        for (int i = 0; i < range.length; i++) {
            int bb = byteBuffer.position(0).get();
            if((bb + i) % 2 == 0) {
                consumoRL02[i] = range[i];
                out.println("<consumo (RL02)>: " + consumoRL02[i]);
            } else {
                consumoRL01[i] = range[i];
                out.println("<consumo (RL01)>: " + consumoRL01[i]);
            }

        }

    }
}