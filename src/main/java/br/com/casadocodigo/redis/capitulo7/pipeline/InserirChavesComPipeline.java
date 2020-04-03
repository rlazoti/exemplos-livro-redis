package br.com.casadocodigo.redis.capitulo7.pipeline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class InserirChavesComPipeline {

    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        Jedis jedis = new Jedis("localhost");
        Pipeline pipeline = jedis.pipelined();

        for (int i = 1; i <= 100000; i++) {
            pipeline.set("chave-" + i, String.valueOf(i));
        }

        pipeline.sync();

        long tempoFinal = System.currentTimeMillis();
        System.out.println(String.format("Tempo total: %.2f segundos", ((tempoFinal - tempoInicial) / 1000.0)));
    }

}
