package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ObterDadosDaMegaSena {

	public static void main(String[] args) {
		String hash = "resultado:09-11-2013:megasena";
		Jedis jedis = new Jedis("localhost");

		String ganhadores = jedis.hget(hash, "ganhadores");
		String numeros = jedis.hget(hash, "numeros");
		
		String mensagem = String.format(
				"Ganhadores = %s, Numeros = [%s]",
				ganhadores, 
				numeros
		);

		System.out.println(mensagem);
	}
}