package com.techeventscare.application.handler;

import com.techeventscare.application.bus.Command;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}