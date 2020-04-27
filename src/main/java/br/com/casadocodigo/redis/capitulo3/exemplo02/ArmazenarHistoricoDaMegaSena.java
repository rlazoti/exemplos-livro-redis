package br.com.casadocodigo.redis.capitulo3.exemplo02;

import redis.clients.jedis.Jedis;

public class ArmazenarHistoricoDaMegaSena {

    public static void main(String[] args) {
        String dataDoSorteio1 = "04-09-2013";
        String numerosDoSorteio1 = "10, 11, 18, 42, 55, 56";
        String chaveDoSorteio1 = String.format("resultado:%s:megasena", dataDoSorteio1);

        String dataDoSorteio2 = "07-09-2013";
        String numerosDoSorteio2 = "2, 21, 30, 35, 45, 50";
        String chaveDoSorteio2 = String.format("resultado:%s:megasena", dataDoSorteio2);

        String dataDoSorteio3 = "21-09-2013";
        String numerosDoSorteio3 = "2, 13, 24, 41, 42, 44";
        String chaveDoSorteio3 = String.format("resultado:%s:megasena", dataDoSorteio3);

        String dataDoSorteio4 = "02-10-2013";
        String numerosDoSorteio4 = "7, 15, 20, 23, 30, 41";
        String chaveDoSorteio4 = String.format("resultado:%s:megasena", dataDoSorteio4);

        Jedis jedis = new Jedis("localhost");
        String resultado = jedis.mset(
                chaveDoSorteio1, numerosDoSorteio1,
                chaveDoSorteio2, numerosDoSorteio2,
                chaveDoSorteio3, numerosDoSorteio3,
                chaveDoSorteio4, numerosDoSorteio4
        );

        System.out.println(resultado);
    }
}