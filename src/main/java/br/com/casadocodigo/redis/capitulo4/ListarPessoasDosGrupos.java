package br.com.casadocodigo.redis.capitulo4;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class ListarPessoasDosGrupos {

	public void listarMembros(String grupo) {
		String chave = String.format("grupos:%s:membros", grupo);
		Jedis jedis = new Jedis("localhost");
		Set<String> membros = jedis.smembers(chave);

		System.out.println(
				String.format(
					"Membros do grupo (%s): %s", grupo, membros.toString()
				)
		);
	}

	public static void main(String[] args) {
		ListarPessoasDosGrupos grupos = new ListarPessoasDosGrupos();
		
		grupos.listarMembros("video-game"); 
		grupos.listarMembros("judo");
		grupos.listarMembros("natacao");
		grupos.listarMembros("kung-fu");
		grupos.listarMembros("violao");
		grupos.listarMembros("ciclismo");
		grupos.listarMembros("cachorro");
		grupos.listarMembros("moto");
		grupos.listarMembros("carro");
		grupos.listarMembros("livro");
		grupos.listarMembros("novela");
	}

}
