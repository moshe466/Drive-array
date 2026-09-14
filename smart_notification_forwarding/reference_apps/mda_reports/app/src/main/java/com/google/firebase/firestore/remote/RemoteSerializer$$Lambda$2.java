package com.google.firebase.firestore.remote;

import com.google.common.base.Function;
import com.google.firestore.v1.Value;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class RemoteSerializer$$Lambda$2 implements Function {
    private final RemoteSerializer arg$1;

    private RemoteSerializer$$Lambda$2(RemoteSerializer remoteSerializer) {
        this.arg$1 = remoteSerializer;
    }

    public static Function lambdaFactory$(RemoteSerializer remoteSerializer) {
        return new RemoteSerializer$$Lambda$2(remoteSerializer);
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return this.arg$1.decodeValue((Value) obj);
    }
}
