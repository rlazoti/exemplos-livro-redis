package br.com.casadocodigo.redis.capitulo4;

import redis.clients.jedis.Jedis;

public class LimitandoUltimasPaginasVisitadas {
 
	public static void main(String[] args) {
		String chave = "ultimas_paginas_visitadas";
		Jedis jedis = new Jedis("localhost");
		String resultado = jedis.ltrim(chave, 0, 2);

		System.out.println(String.format("Resultado: %s", resultado));
	}

}
