package com.techeventscare.common.application.bus;

import com.techeventscare.common.application.handler.CommandHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleCommandBus implements CommandBus {

    private final ApplicationContext applicationContext;

    @Autowired
    public SimpleCommandBus(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> R send(Command<R> command) {
        String commandName = command.getClass().getSimpleName();
        String handlerBeanName = commandName.replace("Command", "Handler");
        handlerBeanName = Character.toLowerCase(handlerBeanName.charAt(0)) + handlerBeanName.substring(1);

        CommandHandler commandHandler = (CommandHandler) applicationContext.getBean(handlerBeanName);
        return (R) commandHandler.handle(command);
    }
}
