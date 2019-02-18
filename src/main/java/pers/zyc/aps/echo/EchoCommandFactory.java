package pers.zyc.aps.echo;

import pers.zyc.aps.Commands;
import pers.zyc.tools.network.DefaultCommandFactory;

/**
 * @author zhangyancheng
 */
public class EchoCommandFactory extends DefaultCommandFactory {

	{
		register(Commands.ECHO, Echo.class);
		register(Commands.ECHO_ACK, EchoAck.class);
	}
}
