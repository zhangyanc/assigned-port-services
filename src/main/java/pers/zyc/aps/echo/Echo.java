package pers.zyc.aps.echo;

import io.netty.buffer.ByteBuf;
import pers.zyc.aps.Commands;
import pers.zyc.tools.network.Header;
import pers.zyc.tools.network.Request;

/**
 * @author zhangyancheng
 */
public class Echo extends Request {
	private String msg;

	public Echo(String msg) {
		super(Commands.ECHO);
		this.msg = msg;
	}

	public Echo(Header header) {
		super(header);
	}

	@Override
	public void validate() throws Exception {
		if (msg == null) {
			throw new NullPointerException();
		}
	}

	@Override
	public int getEstimatedSize() {
		return msg.length();
	}

	@Override
	protected void encodeBody(ByteBuf byteBuf) throws Exception {
		byteBuf.writeBytes(msg.getBytes(UTF_8));
	}

	@Override
	public void decodeBody(ByteBuf byteBuf) throws Exception {
		byte[] msgBytes = new byte[byteBuf.readableBytes()];
		byteBuf.readBytes(msgBytes);
		this.msg = new String(msgBytes, UTF_8);
	}

	public String getMsg() {
		return msg;
	}
}
