package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ArmazenarDadosDaMegaSena {

	public static void main(String[] args) {
		String ganhadores = "22";
		String dataSorteio = "21-09-2014";
		String numeros = "2, 13, 24, 41, 42, 44";
		String hash = "resultado:megasena";

		Jedis jedis = new Jedis("localhost");
		long resultado1 = jedis.hset(hash, "ganhadores", ganhadores);
		long resultado2 = jedis.hset(hash, "dataSorteio", dataSorteio);
		long resultado3 = jedis.hset(hash, "numeros", numeros);
		
		String mensagem = String.format(
				"Resultado 1 = %d, Resultado 2 = %d, Resultado 3 = %d",
				resultado1, 
				resultado2, 
				resultado3
		);

		System.out.println(mensagem);
	}
}