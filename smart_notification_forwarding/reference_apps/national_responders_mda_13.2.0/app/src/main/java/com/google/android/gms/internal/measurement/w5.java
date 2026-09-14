package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.u5;
import com.google.android.gms.internal.measurement.w5;

/* loaded from: classes.dex */
public abstract class w5<MessageType extends u5<MessageType, BuilderType>, BuilderType extends w5<MessageType, BuilderType>> implements x8 {
    @Override // com.google.android.gms.internal.measurement.x8
    public final /* synthetic */ x8 H(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.x8
    public final /* synthetic */ x8 M(byte[] bArr, y6 y6Var) {
        return n(bArr, 0, bArr.length, y6Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.x8
    public final /* synthetic */ x8 N(y8 y8Var) {
        if (k().getClass().isInstance(y8Var)) {
            return l((u5) y8Var);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public abstract /* synthetic */ Object clone();

    protected abstract BuilderType l(MessageType messagetype);

    public abstract BuilderType m(byte[] bArr, int i10, int i11);

    public abstract BuilderType n(byte[] bArr, int i10, int i11, y6 y6Var);
}
