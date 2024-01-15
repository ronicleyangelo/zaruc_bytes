package org.example;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String entradaBase64 = "BSAAAAAJAAABrAACAAIAAQAEAAMAAAAAAAAAAAAAAAAAAAAAAAA=";
//        ByteBuffer byteBuffer = Base64.
        byte[] decodeBase64 = Base64.getDecoder().decode(entradaBase64);
        ByteBuffer byteBuffer = ByteBuffer.wrap(decodeBase64);

        int quantidadeRegistro = byteBuffer.position(0).getInt();
        int nivelDaBateria = byteBuffer.position(0).getInt();
        int relojoaria01H6   = byteBuffer.get(decodeBase64, 2, 6).getInt();
        int relojoaria02H6   = byteBuffer.get(decodeBase64, 7, 10).getInt();

        int[] consumoRL01 = new int[10];
        int[] consumoRL02 = new int[10];

        for (int i = 0; i < 10; i++) {
            consumoRL01[i] = byteBuffer.getInt();
            consumoRL02[i] = byteBuffer.getInt();
        }

        System.out.println("QT de registro: " + quantidadeRegistro);
        System.out.println("Nível da bateria: " + nivelDaBateria);
        System.out.println("Relojoaria 01 H6: " + relojoaria01H6);
        System.out.println("Relojoaria 02 H6: " + relojoaria02H6);
        System.out.println("Consumo (RL01): " + consumoRL01);
        System.out.println("Consumo (RL02): " + consumoRL02);

//        for (int i = 0; i < 10; i++) {
//            System.out.println("Consumo (RL01) - " + i + ": " + consumoRL01[i]);
//            System.out.println("Consumo (RL02) - " + i + ": " + consumoRL02[i]);
//        }
        int relojoaria01H6_2 = byteBuffer.get(decodeBase64, 20, 24).getInt();
        int relojoaria02H6_2 = byteBuffer.get(decodeBase64, 24, 28).getInt();

        System.out.println("<relojoaria 01 H6>: " + relojoaria01H6_2);
        System.out.println("<relojoaria 02 H6>: " + relojoaria02H6_2);
    }
}