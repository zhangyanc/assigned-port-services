package pers.zyc.aps.echo.client;

import pers.zyc.aps.echo.Echo;
import pers.zyc.aps.echo.EchoAck;
import pers.zyc.aps.echo.EchoCommandFactory;
import pers.zyc.aps.echo.server.EchoServer;
import pers.zyc.tools.network.NetClient;
import pers.zyc.tools.network.Response;
import pers.zyc.tools.utils.SystemMillis;

/**
 * @author zhangyancheng
 */
public class EchoClient {

	public static void main(String[] args) throws InterruptedException {
		NetClient echoClient = new NetClient();
		echoClient.setCommandFactory(new EchoCommandFactory());
		echoClient.start();

		int i = 3;
		while (i-- > 0) {
			Echo echo = new Echo(SystemMillis.current() + " - " + Math.random());
			echo.setChannel(echoClient.createChannel("localhost", EchoServer.PORT));

			Response response = echoClient.sendSync(echo);

			EchoAck ack = (EchoAck) response;

			if (!echo.getMsg().equals(ack.getMsg())) {
				throw new Error();
			}
			echo.getChannel().close().awaitUninterruptibly();
			Thread.sleep(1000);
		}
		echoClient.stop();
	}
}
