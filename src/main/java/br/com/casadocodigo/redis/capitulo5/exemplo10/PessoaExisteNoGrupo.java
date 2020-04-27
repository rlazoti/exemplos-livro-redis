package br.com.casadocodigo.redis.capitulo5.exemplo10;

import redis.clients.jedis.Jedis;

public class PessoaExisteNoGrupo {

    public void existe(String grupo, String pessoa) {
        String chave = String.format("grupos:%s:membros", grupo);
        Jedis jedis = new Jedis("localhost");
        boolean resultado = jedis.sismember(chave, pessoa);

        System.out.println(
                String.format(
                        "%s é membro do grupo (%s)? %s",
                        pessoa,
                        grupo,
                        resultado ? "SIM" : "NÃO"
                )
        );
    }

    public static void main(String[] args) {
        PessoaExisteNoGrupo pessoa = new PessoaExisteNoGrupo();

        pessoa.existe("judo", "rodrigo");
        pessoa.existe("livro", "gustavo");
        pessoa.existe("cachorro", "cristiane");
        pessoa.existe("cachorro", "andressa");
        pessoa.existe("violao", "carlos");
    }
}
