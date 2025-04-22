package com.techeventscare.application.bus;

public interface CommandBus {
    <R> R send(Command<R> command);
}
