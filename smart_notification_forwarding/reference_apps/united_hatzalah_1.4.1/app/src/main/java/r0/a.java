package R0;

import L0.e;
import M0.c;
import N0.k;
import N0.l;
import N0.m;
import N0.n;
import N0.o;
import N0.p;
import N0.q;
import N0.r;
import N0.t;
import W0.d;
import W0.g;
import W0.j;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.internal.apk.ApkSigningBlockUtils$NoSupportedSignaturesException;
import com.android.apksig.internal.apk.NoApkSupportedSignaturesException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f1966a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1967b;

    /* renamed from: c, reason: collision with root package name */
    public final n f1968c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f1969d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1970e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1971f;

    /* renamed from: g, reason: collision with root package name */
    public final OptionalInt f1972g;

    /* renamed from: h, reason: collision with root package name */
    public ByteBuffer f1973h;

    public a(d dVar, c cVar, HashSet hashSet, n nVar, int i, int i3, OptionalInt optionalInt) {
        int i4 = Y0.c.f2705h;
        this.f1966a = dVar;
        this.f1967b = cVar;
        this.f1969d = hashSet;
        this.f1968c = nVar;
        this.f1970e = i;
        this.f1971f = i3;
        this.f1972g = optionalInt;
    }

    public final void a(ByteBuffer byteBuffer, CertificateFactory certificateFactory, m mVar) {
        byte[] encoded;
        OptionalInt optionalInt;
        int i;
        L0.n c4;
        e eVar = e.V3_SIG_POR_CERT_MISMATCH;
        ByteBuffer c5 = q.c(byteBuffer);
        c5.get(new byte[c5.remaining()]);
        c5.flip();
        ArrayList arrayList = mVar.f1470g;
        ArrayList arrayList2 = mVar.f1446b;
        ArrayList arrayList3 = mVar.i;
        int i3 = byteBuffer.getInt();
        int i4 = byteBuffer.getInt();
        mVar.f1474l = i3;
        mVar.f1475m = i4;
        if (i3 < 0 || i3 > i4) {
            mVar.f(e.V3_SIG_INVALID_SDK_VERSIONS, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        ByteBuffer c6 = q.c(byteBuffer);
        byte[] e4 = q.e(byteBuffer);
        int i5 = 1;
        ArrayList arrayList4 = new ArrayList(1);
        int i6 = 0;
        while (c6.hasRemaining()) {
            i6 += i5;
            try {
                ByteBuffer c7 = q.c(c6);
                int i7 = i5;
                int i8 = c7.getInt();
                byte[] e5 = q.e(c7);
                arrayList3.add(new l(i8));
                t a2 = t.a(i8);
                if (a2 == null) {
                    mVar.g(e.V3_SIG_UNKNOWN_SIG_ALGORITHM, Integer.valueOf(i8));
                } else {
                    arrayList4.add(new r(a2, e5));
                }
                i5 = i7;
            } catch (ApkFormatException | BufferUnderflowException unused) {
                mVar.f(e.V3_SIG_MALFORMED_SIGNATURE, Integer.valueOf(i6));
                return;
            }
        }
        int i9 = i5;
        if (arrayList3.isEmpty()) {
            mVar.f(e.V3_SIG_NO_SIGNATURES, new Object[0]);
            return;
        }
        try {
            try {
                ArrayList d2 = q.d(arrayList4, mVar.f1474l, mVar.f1475m, false);
                int size = d2.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = d2.get(i10);
                    i10++;
                    o oVar = (o) obj;
                    t tVar = oVar.f1483a;
                    g gVar = tVar.f1497d;
                    int i11 = size;
                    String str = (String) gVar.f2458a;
                    AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) gVar.f2459b;
                    try {
                        ArrayList arrayList5 = d2;
                        PublicKey generatePublic = KeyFactory.getInstance(tVar.f1495b).generatePublic(new X509EncodedKeySpec(e4));
                        try {
                            Signature signature = Signature.getInstance(str);
                            signature.initVerify(generatePublic);
                            if (algorithmParameterSpec != null) {
                                signature.setParameter(algorithmParameterSpec);
                            }
                            c5.position(0);
                            signature.update(c5);
                            byte[] bArr = oVar.f1484b;
                            if (!signature.verify(bArr)) {
                                mVar.f(e.V3_SIG_DID_NOT_VERIFY, tVar);
                                return;
                            }
                            mVar.f1472j.put(tVar, bArr);
                            this.f1969d.add(tVar.f1496c);
                            size = i11;
                            d2 = arrayList5;
                        } catch (InvalidAlgorithmParameterException e6) {
                            e = e6;
                            mVar.f(e.V3_SIG_VERIFY_EXCEPTION, tVar, e);
                            return;
                        } catch (InvalidKeyException e7) {
                            e = e7;
                            mVar.f(e.V3_SIG_VERIFY_EXCEPTION, tVar, e);
                            return;
                        } catch (SignatureException e8) {
                            e = e8;
                            mVar.f(e.V3_SIG_VERIFY_EXCEPTION, tVar, e);
                            return;
                        }
                    } catch (Exception e9) {
                        mVar.f(e.V3_SIG_MALFORMED_PUBLIC_KEY, e9);
                        return;
                    }
                }
                c5.position(0);
                ByteBuffer c8 = q.c(c5);
                ByteBuffer c9 = q.c(c5);
                int i12 = c5.getInt();
                if (i12 != i3) {
                    mVar.f(e.V3_MIN_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD, Integer.valueOf(i3), Integer.valueOf(i12));
                }
                int i13 = c5.getInt();
                if (i13 != i4) {
                    mVar.f(e.V3_MAX_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD, Integer.valueOf(i4), Integer.valueOf(i13));
                }
                ByteBuffer c10 = q.c(c5);
                int i14 = -1;
                while (c9.hasRemaining()) {
                    int i15 = i14 + 1;
                    byte[] e10 = q.e(c9);
                    try {
                        arrayList2.add(new W0.e(j.b(e10, certificateFactory), e10));
                        i14 = i15;
                    } catch (CertificateException e11) {
                        mVar.f(e.V3_SIG_MALFORMED_CERTIFICATE, Integer.valueOf(i15), Integer.valueOf(i14 + 2), e11);
                        return;
                    }
                }
                if (arrayList2.isEmpty()) {
                    mVar.f(e.V3_SIG_NO_CERTIFICATES, new Object[0]);
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) arrayList2.get(0);
                try {
                    encoded = p.c(x509Certificate.getPublicKey());
                } catch (InvalidKeyException e12) {
                    System.out.println("Caught an exception encoding the public key: " + e12);
                    e12.printStackTrace();
                    encoded = x509Certificate.getPublicKey().getEncoded();
                }
                if (!Arrays.equals(e4, encoded)) {
                    mVar.f(e.V3_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, q.f(encoded), q.f(e4));
                    return;
                }
                int i16 = 0;
                while (c8.hasRemaining()) {
                    i16++;
                    try {
                        ByteBuffer c11 = q.c(c8);
                        arrayList.add(new k(q.e(c11), c11.getInt()));
                    } catch (ApkFormatException | BufferUnderflowException unused2) {
                        mVar.f(e.V3_SIG_MALFORMED_DIGEST, Integer.valueOf(i16));
                        return;
                    }
                }
                ArrayList arrayList6 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                int i17 = 0;
                while (i17 < size2) {
                    Object obj2 = arrayList3.get(i17);
                    i17++;
                    arrayList6.add(Integer.valueOf(((l) obj2).f1469a));
                }
                ArrayList arrayList7 = new ArrayList(arrayList.size());
                int size3 = arrayList.size();
                int i18 = 0;
                while (i18 < size3) {
                    Object obj3 = arrayList.get(i18);
                    i18++;
                    arrayList7.add(Integer.valueOf(((k) obj3).f1467a));
                }
                if (!arrayList6.equals(arrayList7)) {
                    mVar.f(e.V3_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, arrayList6, arrayList7);
                    return;
                }
                int i19 = 0;
                int i20 = 0;
                while (true) {
                    boolean hasRemaining = c10.hasRemaining();
                    optionalInt = this.f1972g;
                    if (!hasRemaining) {
                        break;
                    }
                    i19++;
                    try {
                        ByteBuffer c12 = q.c(c10);
                        int i21 = c12.getInt();
                        byte[] bArr2 = new byte[c12.remaining()];
                        c12.get(bArr2);
                        mVar.f1473k.add(new N0.j(bArr2, i21));
                        if (i21 == 1000370060) {
                            try {
                                try {
                                    c4 = L0.n.c(bArr2);
                                    mVar.f1476n = c4;
                                    i = 0;
                                } catch (IllegalArgumentException unused3) {
                                    i = 0;
                                }
                                try {
                                    if (mVar.f1476n.f1279b.size() != c4.b((X509Certificate) arrayList2.get(0)).f1279b.size()) {
                                        mVar.f(eVar, new Object[0]);
                                    }
                                } catch (IllegalArgumentException unused4) {
                                    mVar.f(eVar, new Object[i]);
                                }
                            } catch (SecurityException unused5) {
                                mVar.f(e.V3_SIG_POR_DID_NOT_VERIFY, new Object[0]);
                            } catch (Exception unused6) {
                                mVar.f(e.V3_SIG_MALFORMED_LINEAGE, new Object[0]);
                            }
                        } else if (i21 == 1436519170) {
                            int i22 = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).getInt();
                            if (optionalInt.isPresent()) {
                                int asInt = optionalInt.getAsInt();
                                if (i22 != asInt) {
                                    mVar.f(e.V31_ROTATION_MIN_SDK_MISMATCH, Integer.valueOf(i22), Integer.valueOf(asInt));
                                }
                            } else {
                                mVar.f(e.V31_BLOCK_MISSING, Integer.valueOf(i22));
                            }
                            i20 = i9;
                        } else if (i21 == -1029262406) {
                            if (this.f1971f != 462663009) {
                                mVar.g(e.V31_ROTATION_TARGETS_DEV_RELEASE_ATTR_ON_V3_SIGNER, new Object[0]);
                            }
                        } else {
                            mVar.g(e.V3_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i21));
                        }
                    } catch (ApkFormatException | BufferUnderflowException unused7) {
                        mVar.f(e.V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i19));
                        return;
                    }
                }
                if (optionalInt.isPresent() && i20 == 0) {
                    mVar.g(e.V31_ROTATION_MIN_SDK_ATTR_MISSING, Integer.valueOf(optionalInt.getAsInt()));
                }
            } catch (NoApkSupportedSignaturesException e13) {
                throw new Exception(e13.getMessage());
            }
        } catch (ApkSigningBlockUtils$NoSupportedSignaturesException unused8) {
            mVar.f(e.V3_SIG_NO_SUPPORTED_SIGNATURES, new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x013d, code lost:
    
        if (r4 < r0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0105, code lost:
    
        r2.d(L0.e.V3_INCONSISTENT_SDK_VERSIONS, new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N0.n b() {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R0.a.b():N0.n");
    }
}
