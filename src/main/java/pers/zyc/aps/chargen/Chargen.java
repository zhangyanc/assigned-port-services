package pers.zyc.aps.chargen;

import io.netty.buffer.ByteBuf;
import pers.zyc.aps.Commands;
import pers.zyc.tools.network.Header;
import pers.zyc.tools.network.Request;

import java.util.Objects;

/**
 * @author zhangyancheng
 */
public class Chargen extends Request {
	private String chars;

	public Chargen(String chars) {
		super(Commands.ChARGEN, false);
		this.chars = Objects.requireNonNull(chars);
	}

	public Chargen(Header header) {
		super(header);
	}

	@Override
	public int getEstimatedSize() {
		return chars.length();
	}

	@Override
	protected void encodeBody(ByteBuf byteBuf) throws Exception {
		byte[] charBytes = chars.getBytes(UTF_8);
		byteBuf.writeInt(charBytes.length);
		byteBuf.writeBytes(charBytes);
	}

	@Override
	protected void decodeBody(ByteBuf byteBuf) throws Exception {
		byte[] charBytes = new byte[byteBuf.readInt()];
		byteBuf.readBytes(charBytes);
		chars = new String(charBytes, UTF_8);
	}

	public String getChars() {
		return chars;
	}
}
