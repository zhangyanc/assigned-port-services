package pers.zyc.aps.discard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.zyc.aps.SyncExecutor;
import pers.zyc.tools.network.Request;
import pers.zyc.tools.network.RequestHandler;
import pers.zyc.tools.network.RequestHandlerFactory;
import pers.zyc.tools.network.Response;

import java.util.concurrent.Executor;

/**
 * @author zhangyancheng
 */
public class DiscardRequestHandlerFactory implements RequestHandlerFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiscardRequestHandlerFactory.class);

	private static final RequestHandler DISCARD_REQUEST_HANDLER = new RequestHandler() {

		@Override
		public Executor getExecutor() {
			return SyncExecutor.INSTANCE;
		}

		@Override
		public Response handle(Request request) {
			LOGGER.info("Receive {}", ((Discard) request).getMsg());
			return null;
		}
	};

	@Override
	public RequestHandler getHandler(int requestType) {
		return DISCARD_REQUEST_HANDLER;
	}
}
