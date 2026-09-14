package M1;

import F0.AbstractC0008a;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1404c;

    public e(byte[] bArr, int i) {
        this.f1404c = i;
        if (AbstractC0008a.b(1)) {
            this.f1405a = j(bArr, 1);
            this.f1406b = j(bArr, 0);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    @Override // M1.f
    public final d j(byte[] bArr, int i) {
        switch (this.f1404c) {
            case 0:
                return new c(bArr, i, 0);
            default:
                return new c(bArr, i, 1);
        }
    }
}
