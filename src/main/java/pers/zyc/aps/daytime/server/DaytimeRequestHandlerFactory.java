package pers.zyc.aps.daytime.server;

import pers.zyc.tools.network.DefaultRequestHandlerFactory;

/**
 * @author zhangyancheng
 */
class DaytimeRequestHandlerFactory extends DefaultRequestHandlerFactory {

	{
		register(new DaytimeRequestHandler());
	}
}
