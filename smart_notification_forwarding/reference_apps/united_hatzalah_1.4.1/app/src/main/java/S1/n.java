package S1;

import W1.r0;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n implements K1.j {

    /* renamed from: a, reason: collision with root package name */
    public final K1.m f2149a;

    /* renamed from: b, reason: collision with root package name */
    public final A.n f2150b;

    /* renamed from: c, reason: collision with root package name */
    public final A.n f2151c;

    public n(K1.m mVar) {
        this.f2149a = mVar;
        boolean isEmpty = ((U1.a) mVar.f1105d).f2332a.isEmpty();
        A.n nVar = R1.o.f2008a;
        if (!isEmpty) {
            R1.e eVar = (R1.e) R1.f.f1987b.f1989a.get();
            eVar = eVar == null ? R1.f.f1988c : eVar;
            R1.o.a(mVar);
            eVar.getClass();
            this.f2150b = nVar;
            this.f2151c = nVar;
            return;
        }
        this.f2150b = nVar;
        this.f2151c = nVar;
    }

    @Override // K1.j
    public final void a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        int length = bArr.length;
        A.n nVar = this.f2151c;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            K1.m mVar = this.f2149a;
            for (K1.k kVar : mVar.i(copyOf)) {
                if (kVar.f1097e.equals(r0.LEGACY)) {
                    bArr3 = T.b.e(bArr2, o.f2153b);
                } else {
                    bArr3 = bArr2;
                }
                try {
                    ((K1.j) kVar.f1094b).a(copyOfRange, bArr3);
                    nVar.getClass();
                    return;
                } catch (GeneralSecurityException e4) {
                    o.f2152a.info("tag prefix matches a key, but cannot verify: " + e4);
                }
            }
            Iterator it = mVar.i(K1.b.f1081a).iterator();
            while (it.hasNext()) {
                try {
                    ((K1.j) ((K1.k) it.next()).f1094b).a(bArr, bArr2);
                    nVar.getClass();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            nVar.getClass();
            throw new GeneralSecurityException("invalid MAC");
        }
        nVar.getClass();
        throw new GeneralSecurityException("tag too short");
    }

    @Override // K1.j
    public final byte[] b(byte[] bArr) {
        byte[] copyOf;
        A.n nVar = this.f2150b;
        K1.m mVar = this.f2149a;
        if (((K1.k) mVar.f1104c).f1097e.equals(r0.LEGACY)) {
            bArr = T.b.e(bArr, o.f2153b);
        }
        try {
            byte[] bArr2 = ((K1.k) mVar.f1104c).f1095c;
            if (bArr2 == null) {
                copyOf = null;
            } else {
                copyOf = Arrays.copyOf(bArr2, bArr2.length);
            }
            byte[] e4 = T.b.e(copyOf, ((K1.j) ((K1.k) mVar.f1104c).f1094b).b(bArr));
            int i = ((K1.k) mVar.f1104c).f1098f;
            nVar.getClass();
            return e4;
        } catch (GeneralSecurityException e5) {
            nVar.getClass();
            throw e5;
        }
    }
}
