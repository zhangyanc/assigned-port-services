package pers.zyc.aps.discard;

import pers.zyc.tools.network.NetServer;

/**
 * @author zhangyancheng
 */
public class DiscardServer {

	static final int DISCARD_SERVICE_PORT = 9;

	public static void main(String[] args) {
		NetServer discardServer = new NetServer();
		discardServer.setPort(DISCARD_SERVICE_PORT);

		discardServer.setCommandFactory(new DiscardCommandFactory());
		discardServer.setRequestHandlerFactory(new DiscardRequestHandlerFactory());

		discardServer.start();
	}
}
