package pers.zyc.aps.daytime.server;

import pers.zyc.aps.Commands;
import pers.zyc.aps.SyncExecutor;
import pers.zyc.aps.daytime.Daytime;
import pers.zyc.aps.daytime.DaytimeAck;
import pers.zyc.tools.network.Response;
import pers.zyc.tools.network.SingleRequestSupportRequestHandler;

/**
 * @author zhangyancheng
 */
public class DaytimeRequestHandler extends SingleRequestSupportRequestHandler<Daytime> {

	{
		//daytime命令处理简单，在handle调用线程执行
		setExecutor(SyncExecutor.INSTANCE);
	}

	@Override
	public int supportedRequestType() {
		return Commands.DAYTIME;
	}

	@Override
	protected Response handle0(Daytime request) {
		return new DaytimeAck(request.getId());
	}
}
