package com.google.firebase.firestore.remote;

import com.google.common.base.Function;
import com.google.firestore.v1.Value;

/* loaded from: classes2.dex */
final /* synthetic */ class RemoteSerializer$$Lambda$1 implements Function {
    private final RemoteSerializer arg$1;

    private RemoteSerializer$$Lambda$1(RemoteSerializer remoteSerializer) {
        this.arg$1 = remoteSerializer;
    }

    public static Function lambdaFactory$(RemoteSerializer remoteSerializer) {
        return new RemoteSerializer$$Lambda$1(remoteSerializer);
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return this.arg$1.decodeValue((Value) obj);
    }
}
