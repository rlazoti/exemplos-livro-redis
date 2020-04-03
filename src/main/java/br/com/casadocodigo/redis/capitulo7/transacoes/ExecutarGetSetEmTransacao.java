package br.com.casadocodigo.redis.capitulo7.transacoes;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class ExecutarGetSetEmTransacao {

    public String getSet(String chave, String novoValor) {
        Jedis jedis = new Jedis("localhost");
        Transaction transaction = jedis.multi();

        transaction.get(chave);
        transaction.set(chave, novoValor);

        List<Object> resultados = transaction.exec();

        return (String) resultados.get(0);
    }

    public static void main(String[] args) {
        String valorNovo = "20";
        String chave = "numero-de-acessos";

        ExecutarGetSetEmTransacao transacao =
                new ExecutarGetSetEmTransacao();

        String valorAntigo = transacao.getSet(chave, valorNovo);

        System.out.println(
                String.format(
                        "O valor antigo da chave %s é %s e o novo é %s",
                        chave,
                        valorAntigo,
                        valorNovo
                )
        );
    }

}
