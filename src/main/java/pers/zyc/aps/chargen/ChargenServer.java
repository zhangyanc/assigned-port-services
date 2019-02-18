package pers.zyc.aps.chargen;

import io.netty.util.AttributeKey;
import pers.zyc.tools.network.ChannelEvent;
import pers.zyc.tools.network.NetServer;
import pers.zyc.tools.utils.event.EventListener;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyancheng
 */
public class ChargenServer extends NetServer implements EventListener<ChannelEvent> {

	static final int PORT = 19;

	private static final AttributeKey<Future<?>> FUTURE_KEY = AttributeKey.valueOf("FUTURE_KEY");

	private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

	private final int length;
	private final int delay;

	public ChargenServer(int length, int delay) {
		this.length = length;
		this.delay = delay;
		setPort(PORT);
	}

	@Override
	protected void doStart() {
		addListener(this);
		super.doStart();
	}

	@Override
	protected void doStop() throws Exception {
		super.doStop();
		executor.shutdownNow();
	}

	@Override
	public void onEvent(final ChannelEvent event) {
		switch (event.eventType) {
			case CONNECT:
				logger.info("Create chargen task, Channel: {}", event.channel);
				synchronized (event.channel) {
					final CharGenerator generator = new CharGenerator(length);

					event.channel.attr(FUTURE_KEY).set(executor.scheduleWithFixedDelay(new Runnable() {

						@Override
						public void run() {
							try {
								event.channel.writeAndFlush(new Chargen(generator.next()));
							} catch (Throwable e) {
								e.printStackTrace();
							}
						}
					}, 0, delay, TimeUnit.MILLISECONDS));
				}
				break;
			case CLOSE:
				logger.info("Cancel chargen task, Channel: {}", event.channel);
				synchronized (event.channel) {
					Future<?> future = event.channel.attr(FUTURE_KEY).get();
					if (future != null) {
						future.cancel(true);
					}
				}
				break;
		}
	}

	public static void main(String[] args) {
		//每隔200毫秒发送72个字符到已连接的客户端
		ChargenServer chargenServer = new ChargenServer(72, 200);
		chargenServer.start();
	}
}
