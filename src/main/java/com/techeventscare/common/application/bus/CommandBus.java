package com.techeventscare.common.application.bus;

public interface CommandBus {
    <R> R send(Command<R> command);
}
