package com.techeventscare.common.application.handler;

import com.techeventscare.common.application.bus.Command;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}