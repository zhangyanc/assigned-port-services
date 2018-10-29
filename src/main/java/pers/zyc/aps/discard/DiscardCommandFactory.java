package pers.zyc.aps.discard;

import pers.zyc.tools.network.Command;
import pers.zyc.tools.network.CommandFactory;
import pers.zyc.tools.network.Header;

/**
 * @author zhangyancheng
 */
public class DiscardCommandFactory implements CommandFactory {

	@Override
	public Command createByType(Header header) {
		return new Discard(header);
	}
}
