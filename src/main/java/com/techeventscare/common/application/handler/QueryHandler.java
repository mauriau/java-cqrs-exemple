package com.techeventscare.common.application.handler;

import com.techeventscare.common.application.bus.Query;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}