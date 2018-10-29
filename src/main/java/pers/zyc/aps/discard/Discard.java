package pers.zyc.aps.discard;

import io.netty.buffer.ByteBuf;
import pers.zyc.aps.Commands;
import pers.zyc.tools.network.Header;
import pers.zyc.tools.network.Request;

/**
 * @author zhangyancheng
 */
public class Discard extends Request {
	private String msg;

	public Discard(String msg) {
		super(Commands.DISCARD, false);
		this.msg = msg;
	}

	public Discard(Header header) {
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
		byte[] msgBytes = msg.getBytes(UTF_8);
		byteBuf.writeInt(msgBytes.length);
		byteBuf.writeBytes(msgBytes);
	}

	@Override
	protected void decodeBody(ByteBuf byteBuf) throws Exception {
		byte[] msgBytes = new byte[byteBuf.readInt()];
		byteBuf.readBytes(msgBytes);
		msg = new String(msgBytes, UTF_8);
	}

	public String getMsg() {
		return msg;
	}
}
