package pers.zyc.aps.daytime;

import pers.zyc.aps.Commands;
import pers.zyc.tools.network.DefaultCommandFactory;

/**
 * @author zhangyancheng
 */
public class DaytimeCommandFactory extends DefaultCommandFactory {

	{
		register(Commands.DAYTIME, Daytime.class);
		register(Commands.DAYTIME_ACK, DaytimeAck.class);
	}
}
