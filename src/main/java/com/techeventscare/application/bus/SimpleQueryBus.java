package com.techeventscare.application.bus;

import com.techeventscare.application.handler.QueryHandler;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleQueryBus implements QueryBus {

    private final Map<Class<? extends Query<?>>, QueryHandler<?, ?>> handlers = new HashMap<>();

    public <Q extends Query<R>, R> void registerHandler(Class<Q> type, QueryHandler<Q, R> handler) {
        handlers.put(type, handler);
    }
    @SuppressWarnings("unchecked")
    @Override
    public <R> R handle(Query<R> query) {
        QueryHandler<Query<R>, R> handler = (QueryHandler<Query<R>, R>) handlers.get(query.getClass());
        if (handler == null) {
            throw new IllegalStateException("No handler registered for " + query.getClass());
        }
        return handler.handle(query);
    }
}
