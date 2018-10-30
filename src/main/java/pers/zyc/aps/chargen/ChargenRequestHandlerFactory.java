package pers.zyc.aps.chargen;

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
public class ChargenRequestHandlerFactory implements RequestHandlerFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChargenRequestHandlerFactory.class);

	private final RequestHandler CHARGEN_REQUESTER_HANDLER = new RequestHandler() {

		@Override
		public Executor getExecutor() {
			return SyncExecutor.INSTANCE;
		}

		@Override
		public Response handle(Request request) {
			LOGGER.info(((Chargen) request).getChars());
			return null;
		}
	};

	@Override
	public RequestHandler getHandler(int requestType) {
		return CHARGEN_REQUESTER_HANDLER;
	}
}
