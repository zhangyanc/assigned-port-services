package pers.zyc.aps.echo.server;

import pers.zyc.aps.echo.EchoCommandFactory;
import pers.zyc.tools.network.NetServer;

import java.io.IOException;

/**
 * @author zhangyancheng
 */
public class EchoServer {

	public static final int PORT = 7;

	public static void main(String[] args) throws IOException {
		NetServer echoServer = new NetServer();
		echoServer.setPort(PORT);

		echoServer.setRequestHandlerFactory(new EchoHandlerFactory());
		echoServer.setCommandFactory(new EchoCommandFactory());

		echoServer.start();

		char quit = (char) System.in.read();
		if (quit == '9') {
			echoServer.stop();
		}
	}
}
