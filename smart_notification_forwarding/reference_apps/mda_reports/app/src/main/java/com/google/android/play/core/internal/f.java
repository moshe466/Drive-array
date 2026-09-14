package com.google.android.play.core.internal;

import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
final class f extends e {
    private byte[] a;

    public f(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.a = bArr;
    }

    @Override // com.google.android.play.core.internal.e, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.a;
    }
}
