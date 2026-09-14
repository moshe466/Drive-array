package L1;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d implements K1.a {

    /* renamed from: a, reason: collision with root package name */
    public final K1.m f1284a;

    /* renamed from: b, reason: collision with root package name */
    public final A.n f1285b;

    /* renamed from: c, reason: collision with root package name */
    public final A.n f1286c;

    public d(K1.m mVar) {
        this.f1284a = mVar;
        boolean isEmpty = ((U1.a) mVar.f1105d).f2332a.isEmpty();
        A.n nVar = R1.o.f2008a;
        if (!isEmpty) {
            R1.e eVar = (R1.e) R1.f.f1987b.f1989a.get();
            eVar = eVar == null ? R1.f.f1988c : eVar;
            R1.o.a(mVar);
            eVar.getClass();
            this.f1285b = nVar;
            this.f1286c = nVar;
            return;
        }
        this.f1285b = nVar;
        this.f1286c = nVar;
    }

    @Override // K1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] copyOf;
        A.n nVar = this.f1285b;
        K1.m mVar = this.f1284a;
        try {
            byte[] bArr3 = ((K1.k) mVar.f1104c).f1095c;
            if (bArr3 == null) {
                copyOf = null;
            } else {
                copyOf = Arrays.copyOf(bArr3, bArr3.length);
            }
            byte[] e4 = T.b.e(copyOf, ((K1.a) ((K1.k) mVar.f1104c).f1094b).a(bArr, bArr2));
            int i = ((K1.k) mVar.f1104c).f1098f;
            int length = bArr.length;
            nVar.getClass();
            return e4;
        } catch (GeneralSecurityException e5) {
            nVar.getClass();
            throw e5;
        }
    }

    @Override // K1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        K1.m mVar = this.f1284a;
        A.n nVar = this.f1286c;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = mVar.i(copyOf).iterator();
            while (it.hasNext()) {
                try {
                    byte[] b4 = ((K1.a) ((K1.k) it.next()).f1094b).b(copyOfRange, bArr2);
                    nVar.getClass();
                    return b4;
                } catch (GeneralSecurityException e4) {
                    e.f1287a.info("ciphertext prefix matches a key, but cannot decrypt: " + e4);
                }
            }
        }
        Iterator it2 = mVar.i(K1.b.f1081a).iterator();
        while (it2.hasNext()) {
            try {
                byte[] b5 = ((K1.a) ((K1.k) it2.next()).f1094b).b(bArr, bArr2);
                nVar.getClass();
                return b5;
            } catch (GeneralSecurityException unused) {
            }
        }
        nVar.getClass();
        throw new GeneralSecurityException("decryption failed");
    }
}
