package com.techeventscare.application.bus;

public interface CommandBus {
    <R> R dispatch(Command<R> command);
}
