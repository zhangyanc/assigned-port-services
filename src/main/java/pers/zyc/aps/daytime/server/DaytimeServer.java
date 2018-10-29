package pers.zyc.aps.daytime.server;

import pers.zyc.aps.daytime.DaytimeCommandFactory;
import pers.zyc.tools.network.NetServer;

/**
 * @author zhangyancheng
 */
public class DaytimeServer {

	public static final int PORT = 13;

	public static void main(String[] args) throws Exception {
		NetServer daytimeServer = new NetServer();
		daytimeServer.setCommandFactory(new DaytimeCommandFactory());
		daytimeServer.setRequestHandlerFactory(new DaytimeRequestHandlerFactory());
		daytimeServer.setPort(PORT);

		daytimeServer.start();

		char quit = (char) System.in.read();
		if (quit == '9') {
			daytimeServer.stop();
		}
	}
}
