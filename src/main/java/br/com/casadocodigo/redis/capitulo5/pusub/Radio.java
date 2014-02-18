package br.com.casadocodigo.redis.capitulo5.pusub;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Radio {

	static class Ouvinte {
		private final String nome;
		private final String estacao;
		private static final Executor threadPool = 
			Executors.newCachedThreadPool();

		Ouvinte(String nome, String estacao) {
			this.nome = nome;
			this.estacao = estacao;
		}

		public void ouvirEstacao() {
			Runnable ouvinte = new Runnable() {

				public void run() {
					Jedis jedis = new Jedis("localhost");
					JedisPubSub jedisPubSub = new JedisPubSub() {

						@Override
						public void onUnsubscribe(String channel, 
								int subscribedChannels) {
							System.out.println(
								String.format(
									"%s deixou de escutar a estação %s", 
									nome, 
									channel
								)
							);
						}

						@Override
						public void onSubscribe(String channel, 
								int subscribedChannels) {
							System.out.println(
								String.format(
									"%s começou a escutar a estação %s", 
									nome, 
									channel
								)
							);
						}

						@Override
						public void onMessage(String channel, String message) {
							System.out.println(
								String.format(
									"%s está ouvindo %s na estação %s",
									nome, 
									message,
									channel
								)
							);
						}

						@Override
						public void onPUnsubscribe(String pattern, 
								int subscribedChannels) {
						}

						@Override
						public void onPSubscribe(String pattern, 
								int subscribedChannels) {
						}

						@Override
						public void onPMessage(String pattern, String channel, 
								String message) {
						}
					};

					jedis.subscribe(jedisPubSub, estacao);
				}

			};

			threadPool.execute(ouvinte);
		}

	};

	public static void main(String[] args) {
		Ouvinte rodrigo = new Ouvinte("Rodrigo", "punk-rock");
		rodrigo.ouvirEstacao();

		Ouvinte rafael = new Ouvinte("Rafael", "punk-rock");
		rafael.ouvirEstacao();

		Ouvinte andressa = new Ouvinte("Andressa", "surf-music");
		andressa.ouvirEstacao();
	}

}