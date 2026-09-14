package P1;

import A.n;
import K1.k;
import K1.m;
import R1.o;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f implements K1.c {

    /* renamed from: a, reason: collision with root package name */
    public final m f1588a;

    /* renamed from: b, reason: collision with root package name */
    public final n f1589b;

    /* renamed from: c, reason: collision with root package name */
    public final n f1590c;

    public f(m mVar) {
        this.f1588a = mVar;
        boolean isEmpty = ((U1.a) mVar.f1105d).f2332a.isEmpty();
        n nVar = o.f2008a;
        if (!isEmpty) {
            R1.e eVar = (R1.e) R1.f.f1987b.f1989a.get();
            eVar = eVar == null ? R1.f.f1988c : eVar;
            o.a(mVar);
            eVar.getClass();
            this.f1589b = nVar;
            this.f1590c = nVar;
            return;
        }
        this.f1589b = nVar;
        this.f1590c = nVar;
    }

    @Override // K1.c
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] copyOf;
        n nVar = this.f1589b;
        m mVar = this.f1588a;
        try {
            byte[] bArr3 = ((k) mVar.f1104c).f1095c;
            if (bArr3 == null) {
                copyOf = null;
            } else {
                copyOf = Arrays.copyOf(bArr3, bArr3.length);
            }
            byte[] e4 = T.b.e(copyOf, ((K1.c) ((k) mVar.f1104c).f1094b).a(bArr, bArr2));
            int i = ((k) mVar.f1104c).f1098f;
            nVar.getClass();
            return e4;
        } catch (GeneralSecurityException e5) {
            nVar.getClass();
            throw e5;
        }
    }

    @Override // K1.c
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        m mVar = this.f1588a;
        n nVar = this.f1590c;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = mVar.i(copyOf).iterator();
            while (it.hasNext()) {
                try {
                    byte[] b4 = ((K1.c) ((k) it.next()).f1094b).b(copyOfRange, bArr2);
                    nVar.getClass();
                    return b4;
                } catch (GeneralSecurityException e4) {
                    g.f1591a.info("ciphertext prefix matches a key, but cannot decrypt: " + e4);
                }
            }
        }
        Iterator it2 = mVar.i(K1.b.f1081a).iterator();
        while (it2.hasNext()) {
            try {
                byte[] b5 = ((K1.c) ((k) it2.next()).f1094b).b(bArr, bArr2);
                nVar.getClass();
                return b5;
            } catch (GeneralSecurityException unused) {
            }
        }
        nVar.getClass();
        throw new GeneralSecurityException("decryption failed");
    }
}
