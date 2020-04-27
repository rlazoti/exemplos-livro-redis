package br.com.casadocodigo.redis.capitulo6.exemplo06;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Iterator;
import java.util.Set;

public class Top5JogadoresComScore {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        Set<Tuple> jogadores = jedis.zrevrangeWithScores("scores", 0, 4);
        Iterator<Tuple> iterator = jogadores.iterator();

        for (int index = 1; iterator.hasNext(); index++) {
            Tuple tuple = iterator.next();
            System.out.println(
                    String.format(
                            "Posição %d - %s (%.0f pontos)",
                            index,
                            tuple.getElement(),
                            tuple.getScore()
                    )
            );
        }

    }

}
