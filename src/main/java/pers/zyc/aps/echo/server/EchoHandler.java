package pers.zyc.aps.echo.server;

import pers.zyc.aps.Commands;
import pers.zyc.aps.echo.Echo;
import pers.zyc.aps.echo.EchoAck;
import pers.zyc.tools.network.Response;
import pers.zyc.tools.network.SingleTypeRequestHandler;

/**
 * @author zhangyancheng
 */
public class EchoHandler extends SingleTypeRequestHandler<Echo> {

	@Override
	public int supportedRequestType() {
		return Commands.ECHO;
	}

	@Override
	protected Response handle0(Echo echo) {
		return new EchoAck(echo.getId(), echo.getMsg());
	}
}
