package com.techeventscare.application.handler;

import com.techeventscare.application.bus.Query;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}