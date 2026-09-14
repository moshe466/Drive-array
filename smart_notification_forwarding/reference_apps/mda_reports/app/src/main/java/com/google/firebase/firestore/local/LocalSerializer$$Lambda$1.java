package com.google.firebase.firestore.local;

import com.google.common.base.Function;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firestore.v1.Value;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class LocalSerializer$$Lambda$1 implements Function {
    private final RemoteSerializer arg$1;

    private LocalSerializer$$Lambda$1(RemoteSerializer remoteSerializer) {
        this.arg$1 = remoteSerializer;
    }

    public static Function lambdaFactory$(RemoteSerializer remoteSerializer) {
        return new LocalSerializer$$Lambda$1(remoteSerializer);
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return this.arg$1.decodeValue((Value) obj);
    }
}
