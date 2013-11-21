package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ArmazenarDadosDaMegaSena {

	public static void main(String[] args) {
		String ganhadores = "22";
		String dataSorteio = "09-11-2013";
		String numeros = "8, 18, 26, 42, 56, 58";
		String chave = String.format("resultado:%s:megasena", dataSorteio);

		Jedis jedis = new Jedis("localhost");
		long resultado1 = jedis.hset(chave, "ganhadores", ganhadores);
		long resultado2 = jedis.hset(chave, "numeros", numeros);
		
		String mensagem = String.format(
				"Resultado 1 = %d, Resultado 2 = %d",
				resultado1, 
				resultado2
		);

		System.out.println(mensagem);
	}
}