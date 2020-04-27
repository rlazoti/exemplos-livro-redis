package br.com.casadocodigo.redis.capitulo6.exemplo05;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class Top5Jogadores {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        Set<String> jogadores = jedis.zrevrange("scores", 0, 4);
        Iterator<String> iterator = jogadores.iterator();

        for (int index = 1; iterator.hasNext(); index++) {
            System.out.println(
                    String.format("Posição %d - %s", index, iterator.next())
            );
        }

    }

}
