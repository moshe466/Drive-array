package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.eventbus.EventBus;
import java.util.concurrent.Executor;

@Beta
/* loaded from: classes2.dex */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String str, Executor executor) {
        super(str, executor, Dispatcher.a(), EventBus.LoggingHandler.a);
    }

    public AsyncEventBus(Executor executor) {
        super("default", executor, Dispatcher.a(), EventBus.LoggingHandler.a);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super("default", executor, Dispatcher.a(), subscriberExceptionHandler);
    }
}
