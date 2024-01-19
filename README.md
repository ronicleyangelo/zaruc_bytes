# 📍 Projeto
> Foi passssado uma ```entradaBase64 = "BSAAAAAJAAABrAACAAIAAQAEAAMAAAAAAAAAAAAAAAAAAAAAAAA=";``` teriamos que transformar em <em><strong>bytes</strong></em> e logo a saída seria um print com as reapectivas palavras juntamente com numero <em>Interiro</em>. <em><strong>CONSUMO 1 && 2</strong></em>, <em><strong>Reajoleria 1 && 2 </strong></em>, <em><strong>Nível da Bateria</strong></em> e <em><strong>Quantidade de Registro</strong></em>
---

# 💻 Tecnologia 
> -> Java

# Objetivo 
> -> Trabalhar a lógica de Programação. 

## Solução 
> -> Primeiro transformei em Bytes
> ```java
String entradaBase64 = "BSAAAAAJAAABrAACAAIAAQAEAAMAAAAAAAAAAAAAAAAAAAAAAAA=";
byte[] decodeBase64 = Base64.getDecoder().decode(entradaBase64);
ByteBuffer byteBuffer = ByteBuffer.wrap(decodeBase64); 
```
> -> Adicionei esses bytes no ByteBuffer
