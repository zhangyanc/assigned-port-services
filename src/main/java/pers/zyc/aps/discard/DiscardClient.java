package pers.zyc.aps.discard;

import io.netty.channel.Channel;
import pers.zyc.tools.network.NetClient;

/**
 * @author zhangyancheng
 */
public class DiscardClient {

	public static void main(String[] args) throws InterruptedException {
		NetClient discardClient = new NetClient();
		discardClient.start();

		Channel channel = discardClient.createChannel("localhost", DiscardServer.DISCARD_SERVICE_PORT);

		Discard discard = new Discard(System.currentTimeMillis() + " + " + Math.random());
		discard.setChannel(channel);

		discardClient.sendOneWay(discard);

		channel.close().await();
		discardClient.stop();
	}
}
