package pers.zyc.aps.echo.server;

import pers.zyc.tools.network.DefaultRequestHandlerFactory;

/**
 * @author zhangyancheng
 */
public class EchoHandlerFactory extends DefaultRequestHandlerFactory {
	{
		register(new EchoHandler());
	}
}
