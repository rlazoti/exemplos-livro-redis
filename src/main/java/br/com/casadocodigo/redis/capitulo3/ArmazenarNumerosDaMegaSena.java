package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ArmazenarNumerosDaMegaSena {

    public static void main(String[] args) {
        String chave = "resultado:megasena";
        String numerosDoUltimoSorteio = "2, 13, 24, 41, 42, 44";

        Jedis jedis = new Jedis("localhost");
        String resultado = jedis.set(chave, numerosDoUltimoSorteio);

        System.out.println(resultado);
    }
}