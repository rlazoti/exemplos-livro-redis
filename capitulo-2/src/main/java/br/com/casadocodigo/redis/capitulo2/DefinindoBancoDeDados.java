package br.com.casadocodigo.redis.capitulo2;

import redis.clients.jedis.Jedis;

public class DefinindoBancoDeDados {

	public static void main(String[] args) {
		/*
		 * Para executar este exemplo o Redis (redis-server ou redis-server.exe) 
		 * precisar estar sendo executado.
		 */

		Jedis jedis = new Jedis("localhost");
		String resultado = jedis.select(8);
		System.out.println(resultado); // imprime OK
		System.out.println(jedis.getDB()); // imprime 8
	}

}