package br.com.casadocodigo.redis.capitulo4;

import java.util.List;

import redis.clients.jedis.Jedis;

public class ObterTresUltimasPaginasVisitadas {
 
	public static void main(String[] args) {
		String chave = "ultimas_paginas_visitadas";
		Jedis jedis = new Jedis("localhost");
		List<String> paginas = jedis.lrange(chave, 0, 2);

		System.out.println("As 3 ultimas paginas visitadas são:");

		for (String pagina : paginas) {
			System.out.println(pagina);
		}
	}

}
