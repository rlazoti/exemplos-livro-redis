package br.com.casadocodigo.redis.capitulo3.exemplo03;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class FiltrarHistoricoDaMegaSena {

    public Set<String> filtrarResultados(int mes, int ano) {
        String chave = "resultado:*-%02d-%04d:megasena";
        Jedis jedis = new Jedis("localhost");

        return jedis.keys(String.format(chave, mes, ano));
    }

    public static void main(String[] args) {
        int mes = 10;
        int ano = 2013;
        Set<String> chaves = new FiltrarHistoricoDaMegaSena().filtrarResultados(mes, ano);

        System.out.println(chaves);
    }
}