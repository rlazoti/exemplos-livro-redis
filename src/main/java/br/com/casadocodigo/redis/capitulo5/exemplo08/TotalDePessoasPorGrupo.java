package br.com.casadocodigo.redis.capitulo5.exemplo08;

import redis.clients.jedis.Jedis;

public class TotalDePessoasPorGrupo {

    public void mostrarQuantidadeDeMembros(String grupo) {
        String chave = String.format("grupos:%s:membros", grupo);
        Jedis jedis = new Jedis("localhost");
        long resultado = jedis.scard(chave);

        System.out.println(
                String.format("Grupo (%s) tem %d membros", grupo, resultado)
        );
    }

    public static void main(String[] args) {
        TotalDePessoasPorGrupo grupo =
                new TotalDePessoasPorGrupo();

        grupo.mostrarQuantidadeDeMembros("video-game");
        grupo.mostrarQuantidadeDeMembros("judo");
        grupo.mostrarQuantidadeDeMembros("natacao");
        grupo.mostrarQuantidadeDeMembros("kung-fu");
        grupo.mostrarQuantidadeDeMembros("violao");
        grupo.mostrarQuantidadeDeMembros("ciclismo");
        grupo.mostrarQuantidadeDeMembros("cachorro");
        grupo.mostrarQuantidadeDeMembros("moto");
        grupo.mostrarQuantidadeDeMembros("carro");
        grupo.mostrarQuantidadeDeMembros("livro");
        grupo.mostrarQuantidadeDeMembros("novela");
    }

}
