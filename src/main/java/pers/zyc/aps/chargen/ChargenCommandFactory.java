package pers.zyc.aps.chargen;

import pers.zyc.tools.network.Command;
import pers.zyc.tools.network.CommandFactory;
import pers.zyc.tools.network.Header;

/**
 * @author zhangyancheng
 */
public class ChargenCommandFactory implements CommandFactory {

	@Override
	public Command createByType(Header header) {
		return new Chargen(header);
	}
}
