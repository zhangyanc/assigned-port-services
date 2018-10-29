package pers.zyc.aps.echo.server;

import pers.zyc.aps.Commands;
import pers.zyc.aps.SyncExecutor;
import pers.zyc.aps.echo.Echo;
import pers.zyc.aps.echo.EchoAck;
import pers.zyc.tools.network.Response;
import pers.zyc.tools.network.SingleRequestSupportRequestHandler;

/**
 * @author zhangyancheng
 */
public class EchoHandler extends SingleRequestSupportRequestHandler<Echo> {

	{
		//echo命令处理简单，在handle调用线程执行
		setExecutor(SyncExecutor.INSTANCE);
	}

	@Override
	public int supportedRequestType() {
		return Commands.ECHO;
	}

	@Override
	protected Response handle0(Echo echo) {
		return new EchoAck(echo.getId(), echo.getMsg());
	}
}
