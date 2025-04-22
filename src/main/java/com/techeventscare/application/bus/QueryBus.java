package com.techeventscare.application.bus;

public interface QueryBus {
    <R> R handle(Query<R> query);
}