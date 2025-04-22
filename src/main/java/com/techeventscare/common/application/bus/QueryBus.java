package com.techeventscare.common.application.bus;

public interface QueryBus {
    <R> R handle(Query<R> query);
}