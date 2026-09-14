package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.datatransport.Transformer;

/* loaded from: classes2.dex */
final /* synthetic */ class TransportClientModule$$Lambda$1 implements Transformer {
    private static final TransportClientModule$$Lambda$1 instance = new TransportClientModule$$Lambda$1();

    private TransportClientModule$$Lambda$1() {
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        byte[] bArr = (byte[]) obj;
        TransportClientModule.a(bArr);
        return bArr;
    }
}
