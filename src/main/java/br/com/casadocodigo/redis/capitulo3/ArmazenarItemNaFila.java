package br.com.casadocodigo.redis.capitulo3;

import redis.clients.jedis.Jedis;

public class ArmazenarItemNaFila {

	public void agendarAutorizacaoDeUsuario(String nome, String email) {
		String chave = "fila-confirmar-usuario";
		Jedis jedis = new Jedis("localhost");

		String mensagem = String.format("{\"nome\": \"%s\", \"email\": \"%s\"}", nome, email);

		Long resultado = jedis.rpush(chave, mensagem);
		System.out.println(String.format("Email Agendado: %d", resultado));
	}

	public static void main(String[] args) {
		ArmazenarItemNaFila fila = new ArmazenarItemNaFila();
		
		fila.agendarAutorizacaoDeUsuario(
				"Daenerys Targaryen", "daenerys@rargaryen.com"
		);

		fila.agendarAutorizacaoDeUsuario(
				"Jon Snow", "jon@snow.com"
		);

		fila.agendarAutorizacaoDeUsuario(
				"Tyrion Lannister", "tyrion@lannister.com"
		);
	}

}
