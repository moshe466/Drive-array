package L0;

import N0.p;
import N0.q;
import N0.s;
import N0.t;
import com.android.apksig.zip.ZipFormatException;
import java.nio.ByteBuffer;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f1276b;

    /* renamed from: a, reason: collision with root package name */
    public final W0.d f1277a;

    static {
        new HashSet(Arrays.asList(e.V3_SIG_MALFORMED_LINEAGE, e.V3_INCONSISTENT_LINEAGES, e.V3_SIG_POR_DID_NOT_VERIFY, e.V3_SIG_POR_CERT_MISMATCH));
        HashMap hashMap = new HashMap(2);
        hashMap.put(2, "APK Signature Scheme v2");
        hashMap.put(3, "APK Signature Scheme v3");
        f1276b = hashMap;
    }

    public m(W0.d dVar) {
        this.f1277a = dVar;
    }

    public static void a(List list, List list2, l lVar) {
        try {
            if (!Arrays.equals(((X509Certificate) list2.get(0)).getEncoded(), ((X509Certificate) list.get(0)).getEncoded())) {
                lVar.c(e.V4_SIG_V2_V3_SIGNERS_MISMATCH, new Object[0]);
            }
        } catch (CertificateEncodingException e4) {
            throw new RuntimeException("Failed to encode APK signer cert", e4);
        }
    }

    public static void b(List list, List list2, byte[] bArr, l lVar) {
        if (list.size() != 1) {
            lVar.c(e.V4_SIG_MULTIPLE_SIGNERS, new Object[0]);
        }
        a(list2, ((j) list.get(0)).f1257a, lVar);
        byte[] f4 = f(((j) list.get(0)).f1259c);
        if (!Arrays.equals(bArr, f4)) {
            lVar.c(e.V4_SIG_V2_V3_DIGESTS_MISMATCH, 3, q.f(f4), q.f(bArr));
        }
    }

    public static void c(List list, HashMap hashMap) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            N0.k kVar = (N0.k) it.next();
            t a2 = t.a(kVar.f1467a);
            if (a2 != null) {
                hashMap.put(a2.f1496c, kVar.f1468b);
            }
        }
    }

    public static ByteBuffer d(W0.d dVar, M0.c cVar) {
        X0.a aVar;
        ArrayList c4 = P0.e.c(dVar, cVar);
        try {
            Y0.b e4 = dVar.e(0L, cVar.f1389a);
            int size = c4.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    Object obj = c4.get(i);
                    i++;
                    aVar = (X0.a) obj;
                    if ("AndroidManifest.xml".equals(aVar.f2581g)) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar != null) {
                return ByteBuffer.wrap(X0.c.a(e4, aVar, ((W0.d) e4).size()));
            }
            throw new Exception("Missing AndroidManifest.xml");
        } catch (ZipFormatException e5) {
            throw new Exception("Failed to read AndroidManifest.xml", e5);
        }
    }

    public static HashMap e(N0.n nVar) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = nVar.f1479g;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            c(((N0.m) obj).f1470g, hashMap);
        }
        return hashMap;
    }

    public static byte[] f(List list) {
        HashMap hashMap = new HashMap();
        c(list, hashMap);
        for (int i = 0; i < 3; i++) {
            s sVar = p.f1481a[i];
            if (hashMap.containsKey(sVar)) {
                return (byte[]) hashMap.get(sVar);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:268:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:335:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final L0.l g() {
        /*
            Method dump skipped, instructions count: 1633
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.m.g():L0.l");
    }
}
