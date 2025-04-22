package com.techeventscare.common.application.bus;

import com.techeventscare.common.application.handler.QueryHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class SimpleQueryBus implements QueryBus {
    private final ApplicationContext applicationContext;

    public SimpleQueryBus(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <R> R handle(Query<R> query) {
        String queryName = query.getClass().getSimpleName();
        String handlerBeanName = queryName.concat("Handler");
        handlerBeanName = Character.toLowerCase(handlerBeanName.charAt(0)) + handlerBeanName.substring(1);

        QueryHandler queryHandler = (QueryHandler) applicationContext.getBean(handlerBeanName);
        return (R) queryHandler.handle(query);
    }
}
