package pers.zyc.aps.daytime.server;

import pers.zyc.aps.Commands;
import pers.zyc.aps.daytime.Daytime;
import pers.zyc.aps.daytime.DaytimeAck;
import pers.zyc.tools.network.Response;
import pers.zyc.tools.network.SingleTypeRequestHandler;

/**
 * @author zhangyancheng
 */
public class DaytimeRequestHandler extends SingleTypeRequestHandler<Daytime> {

	@Override
	public int supportedRequestType() {
		return Commands.DAYTIME;
	}

	@Override
	protected Response handle0(Daytime request) {
		return new DaytimeAck(request.getId());
	}
}
