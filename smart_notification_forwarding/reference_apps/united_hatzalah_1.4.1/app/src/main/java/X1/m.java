package X1;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class m implements K1.j {

    /* renamed from: a, reason: collision with root package name */
    public final V1.a f2620a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2621b;

    public m(V1.a aVar, int i) {
        this.f2620a = aVar;
        this.f2621b = i;
        if (i >= 10) {
            aVar.d(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // K1.j
    public final void a(byte[] bArr, byte[] bArr2) {
        if (MessageDigest.isEqual(b(bArr2), bArr)) {
        } else {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // K1.j
    public final byte[] b(byte[] bArr) {
        return this.f2620a.d(bArr, this.f2621b);
    }
}
