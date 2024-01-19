# 📍 Projeto
> Foi passssado uma ```entradaBase64 = "BSAAAAAJAAABrAACAAIAAQAEAAMAAAAAAAAAAAAAAAAAAAAAAAA=";``` teriamos que transformar em <em><strong>bytes</strong></em> e logo a saída seria um print com as reapectivas palavras juntamente com numero <em>Interiro</em>. <em><strong>CONSUMO 1 && 2</strong></em>, <em><strong>Reajoleria 1 && 2 </strong></em>, <em><strong>Nível da Bateria</strong></em> e <em><strong>Quantidade de Registro</strong></em>
---

# 💻 Tecnologia 
> -> Java

# Objetivo 
> -> Trabalhar a lógica de Programação. 

## Solução 
> -> Primeiro transformei em Bytes e adiciono dentro do {`ByteBuffer`}
> ```java
>   String entradaBase64 = "BSAAAAAJAAABrAACAAIAAQAEAAMAAAAAAAAAAAAAAAAAAAAAAAA=";
>   byte[] decodeBase64 = Base64.getDecoder().decode(entradaBase64);
>   ByteBuffer byteBuffer = ByteBuffer.wrap(decodeBase64); 
> ```
> -> Armazenei os btyes numa variável e também peguei o seus <em>índice</em> e o <em>range</em>
> ```java
>        int quantidadeRegistro = decodeBase64[0];
>        int nivelDaBateria = decodeBase64[1];
>
>        int relojoaria01H6 = byteBuffer.getInt(2);
>        int relojoaria02H6 = byteBuffer.getInt(6);
>
>        int[] consumoRL01 = new int[10];
>        int[] consumoRL02 = new int[10];
>        byte[] consumoRL01Range = Arrays.copyOfRange(decodeBase64, 10,20);
>        byte[] cosumoRL02Range = Arrays.copyOfRange(decodeBase64, 28, 38);
>        byte[] relojoaria01H6Range = Arrays.copyOfRange(decodeBase64, 20,23);
>        byte[] relojoaria02H6Range = Arrays.copyOfRange(decodeBase64, 24,27);
> ```
> -> A saída do código
> ```java
>        System.out.println("<QT de registro>: "   + quantidadeRegistro);
>        System.out.println("<Nível da bateria>: " + nivelDaBateria);
>        System.out.println("<Relojoaria 01 H6>: " + relojoaria01H6);
>        System.out.println("<Relojoaria 02 H6>: " + relojoaria02H6);
> ```
> -> Temos dois consumo cada consumo possuimos 10 {`bytes`}. Usei um operado {`%`} para pegar impar e par.
> -> <p>Pegamos o {`bytes[10][20]` do consumo}</p>
> ```java
>       for (int i = 0; i < consumoRL01Range.length; i++) {
>            int bb = byteBuffer.position(0).get();
>            if((bb + i) % 2 == 0) {
>                consumoRL02[i] = consumoRL01Range[i];
>                out.println("<consumo (RL02)>: " + consumoRL02[i]);
>            } else {
>                consumoRL01[i] = consumoRL01Range[i];
>                out.println("<consumo (RL01)>: " + consumoRL01[i]);
>            }
>        }
> ```
> -> Aqui foi usada a mesma lógica para pegar os {`bytes[28][38]` do consumo}
> ```java
>       for (int i = 0; i < cosumoRL02Range.length; i++) {
>            int bb = byteBuffer.position(0).get();
>            if((bb + i) % 2 == 0) {
>                consumoRL02[i] = cosumoRL02Range[i];
>                out.println("<consumo (RL02)>: " + consumoRL02[i]);
>            } else {
>                consumoRL01[i] = cosumoRL02Range[i];
>                out.println("<consumo (RL01)>: " + consumoRL01[i]);
>            }
>        }
> ```
> -> Pega os {`bytes`} da relojoaria01H6 {`bytes[20][23]`}  e relojoaria02H6 {`bytes[24][27]`}
> ```java
>       for (byte b : relojoaria01H6Range) {
>            out.println("<relojoaria 01 H6>: " + b);
>            break;
>        }
>
>        for (byte b : relojoaria02H6Range) {
>            out.println("<relojoaria 02 H6>: " + b);
>            break;
>        }
> ```
