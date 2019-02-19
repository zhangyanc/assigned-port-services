package pers.zyc.aps.echo;

import io.netty.buffer.ByteBuf;
import pers.zyc.aps.Commands;
import pers.zyc.tools.network.Header;
import pers.zyc.tools.network.Response;

/**
 * @author zhangyancheng
 */
public class EchoAck extends Response {
	private String msg;

	public EchoAck(int requestId, String msg) {
		super(Commands.ECHO_ACK, requestId);
		this.msg = msg;
	}

	public EchoAck(Header header) {
		super(header);
	}

	@Override
	public void validate() throws Exception {
		if (msg == null) {
			throw new NullPointerException();
		}
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
