package br.com.casadocodigo.redis.capitulo4.sortedset;

import redis.clients.jedis.Jedis;

public class GerarNovoJogador {

    public void adicionarNovoJogador(String jogador) {
        String chave = "scores";
        double pontuacaoInicial = 50;
        Jedis jedis = new Jedis("localhost");
        long resultado = jedis.zadd(chave, pontuacaoInicial, jogador);

        System.out.println(
                String.format(
                        "Novo Jogador: %s com %.0f pontos iniciais. Resultado: %d",
                        jogador,
                        pontuacaoInicial,
                        resultado
                )
        );
    }

    public static void main(String[] args) {
        GerarNovoJogador novoJogo = new GerarNovoJogador();

        novoJogo.adicionarNovoJogador("Aragorn");
        novoJogo.adicionarNovoJogador("Gandalf");
        novoJogo.adicionarNovoJogador("Legolas");
        novoJogo.adicionarNovoJogador("Gandalf");
        novoJogo.adicionarNovoJogador("Frodo");
        novoJogo.adicionarNovoJogador("Bilbo");
        novoJogo.adicionarNovoJogador("Gimli");
        novoJogo.adicionarNovoJogador("Sam");
        novoJogo.adicionarNovoJogador("Boromir");
        novoJogo.adicionarNovoJogador("Gollum");
    }

}
