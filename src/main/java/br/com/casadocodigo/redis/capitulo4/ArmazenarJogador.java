package br.com.casadocodigo.redis.capitulo4;

import redis.clients.jedis.Jedis;

public class ArmazenarJogador {

    public static void main(String[] args) {
        int codigoJogador = 1;
        String nomeJogador = "Rafael";
        String chave = String.format("jogador:%04d:codigo", codigoJogador);

        Jedis jedis = new Jedis("localhost");
        long resultado1 = jedis.hset(chave, "nome", nomeJogador);
        long resultado2 = jedis.hset(chave, "pontuacao", "0");

        String mensagem = String.format(
                "Resultado 1 = %d, Resultado 2 = %d",
                resultado1,
                resultado2
        );

        System.out.println(mensagem);
    }

}
