package pers.zyc.aps.daytime.client;

import io.netty.channel.Channel;
import pers.zyc.aps.daytime.Daytime;
import pers.zyc.aps.daytime.DaytimeAck;
import pers.zyc.aps.daytime.DaytimeCommandFactory;
import pers.zyc.aps.daytime.server.DaytimeServer;
import pers.zyc.tools.network.NetClient;

/**
 * @author zhangyancheng
 */
public class DaytimeClient {

	public static void main(String[] args) throws InterruptedException {
		NetClient daytimeClient = new NetClient();
		daytimeClient.setCommandFactory(new DaytimeCommandFactory());
		daytimeClient.start();

		Channel channel = daytimeClient.createChannel("localhost", DaytimeServer.PORT);
		int i = 3;
		while (i-- > 0) {
			Daytime daytime = new Daytime();
			daytime.setChannel(channel);

			DaytimeAck ack = (DaytimeAck) daytimeClient.sendSync(daytime);
			System.out.println(ack.getDaytime());
			Thread.sleep(1000);
		}
		daytimeClient.stop();
	}
}
