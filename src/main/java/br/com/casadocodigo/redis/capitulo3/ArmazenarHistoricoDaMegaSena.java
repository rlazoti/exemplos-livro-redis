package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ArmazenarHistoricoDaMegaSena {

	public static void main(String[] args) {
		String dataDoSorteio1 = "04-09-2013";
		String numerosDoSorteio1 = "2, 13, 24, 41, 42, 44";
		String chave1 = String.format("resultado:megasena:%s", dataDoSorteio1);

		String dataDoSorteio2 = "07-09-2013";
		String numerosDoSorteio2 = "2, 21, 30, 35, 45, 50";
		String chave2 = String.format("resultado:megasena:%s", dataDoSorteio2);

		String dataDoSorteio3 = "11-09-2013";
		String numerosDoSorteio3 = "7, 15, 20, 23, 30, 41";
		String chave3 = String.format("resultado:megasena:%s", dataDoSorteio3);
		
		Jedis jedis = new Jedis("localhost");
		String resultado = jedis.mset(chave1, numerosDoSorteio1, chave2, numerosDoSorteio2, chave3, numerosDoSorteio3);
		
		System.out.println(resultado);
	}
}