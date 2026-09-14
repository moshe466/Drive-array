package com.pichillilorenzo.flutter_inappwebview_android.types;

import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes.dex */
public interface ICallbackResult<T> extends MethodChannel.Result {
    T decodeResult(Object obj);

    void defaultBehaviour(T t3);

    boolean nonNullSuccess(T t3);

    boolean nullSuccess();
}
