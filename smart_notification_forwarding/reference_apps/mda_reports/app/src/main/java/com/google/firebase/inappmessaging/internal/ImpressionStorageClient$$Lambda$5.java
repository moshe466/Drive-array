package com.google.firebase.inappmessaging.internal;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/* loaded from: classes2.dex */
public final /* synthetic */ class ImpressionStorageClient$$Lambda$5 implements Function {
    private static final ImpressionStorageClient$$Lambda$5 instance = new ImpressionStorageClient$$Lambda$5();

    private ImpressionStorageClient$$Lambda$5() {
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return Observable.fromIterable((List) obj);
    }
}
