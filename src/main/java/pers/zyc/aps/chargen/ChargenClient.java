package pers.zyc.aps.chargen;

import io.netty.channel.Channel;
import pers.zyc.tools.network.NetClient;

/**
 * @author zhangyancheng
 */
public class ChargenClient {

	public static void main(String[] args) {
		NetClient chargenClient = new NetClient();

		chargenClient.setCommandFactory(new ChargenCommandFactory());
		chargenClient.setRequestHandlerFactory(new ChargenRequestHandlerFactory());
		chargenClient.start();

		Channel channel = chargenClient.createChannel("localhost", ChargenServer.PORT);

		//telnet localhost 19
	}
}
