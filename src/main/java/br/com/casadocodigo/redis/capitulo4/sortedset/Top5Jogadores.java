package br.com.casadocodigo.redis.capitulo4.sortedset;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

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
