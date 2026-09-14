package L0;

import F0.AbstractC0008a;
import N0.q;
import N0.t;
import com.android.apksig.apk.ApkFormatException;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f1278a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1279b;

    public n(int i, ArrayList arrayList) {
        this.f1278a = i;
        this.f1279b = arrayList;
    }

    public static n a(ArrayList arrayList) {
        n nVar;
        n nVar2;
        if (arrayList.isEmpty()) {
            return null;
        }
        n nVar3 = (n) arrayList.get(0);
        int i = 1;
        while (i < arrayList.size()) {
            n nVar4 = (n) arrayList.get(i);
            W0.e eVar = ((R0.b) nVar3.f1279b.get(0)).f1974a;
            ArrayList arrayList2 = nVar4.f1279b;
            int i3 = 0;
            while (true) {
                if (i3 < arrayList2.size()) {
                    if (((R0.b) arrayList2.get(i3)).f1974a.equals(eVar)) {
                        nVar2 = nVar3;
                        nVar = nVar4;
                        break;
                    }
                    i3++;
                } else {
                    nVar = nVar3;
                    nVar2 = nVar4;
                    break;
                }
            }
            ArrayList arrayList3 = nVar.f1279b;
            ArrayList arrayList4 = nVar2.f1279b;
            R0.b bVar = (R0.b) arrayList4.get(0);
            ArrayList arrayList5 = new ArrayList();
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList3.size()) {
                    break;
                }
                int i5 = i4 + 1;
                R0.b bVar2 = (R0.b) arrayList3.get(i4);
                if (bVar2.f1974a.equals(bVar.f1974a)) {
                    i4 = i5;
                    break;
                }
                arrayList5.add(bVar2);
                i4 = i5;
            }
            if (i4 != arrayList5.size()) {
                arrayList5.add(bVar);
                int i6 = 1;
                while (i4 < arrayList3.size() && i6 < arrayList4.size()) {
                    int i7 = i4 + 1;
                    R0.b bVar3 = (R0.b) arrayList3.get(i4);
                    int i8 = i6 + 1;
                    R0.b bVar4 = (R0.b) arrayList4.get(i6);
                    if (bVar3.f1974a.equals(bVar4.f1974a)) {
                        arrayList5.add(bVar4);
                        i4 = i7;
                        i6 = i8;
                    } else {
                        throw new IllegalArgumentException("The provided lineage diverges from this lineage");
                    }
                }
                while (i4 < arrayList3.size()) {
                    arrayList5.add((R0.b) arrayList3.get(i4));
                    i4++;
                }
                while (i6 < arrayList4.size()) {
                    arrayList5.add((R0.b) arrayList4.get(i6));
                    i6++;
                }
                i++;
                nVar3 = new n(Math.min(nVar3.f1278a, nVar4.f1278a), arrayList5);
            } else {
                throw new IllegalArgumentException("The provided lineage is not a descendant or an ancestor of this lineage");
            }
        }
        return nVar3;
    }

    public static n c(byte[] bArr) {
        int i;
        int i3;
        int i4;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteBuffer order = wrap.order(byteOrder);
        ArrayList arrayList = new ArrayList();
        W0.e eVar = null;
        if (order != null && order.hasRemaining()) {
            char[] cArr = q.f1482a;
            if (order.order() == byteOrder) {
                try {
                    try {
                        if (order.getInt() == 1) {
                            HashSet hashSet = new HashSet();
                            int i5 = 0;
                            int i6 = 0;
                            while (order.hasRemaining()) {
                                try {
                                    i5++;
                                    ByteBuffer c4 = q.c(order);
                                    ByteBuffer c5 = q.c(c4);
                                    int i7 = c4.getInt();
                                    int i8 = c4.getInt();
                                    t a2 = t.a(i6);
                                    byte[] e4 = q.e(c4);
                                    if (eVar != null) {
                                        W0.g gVar = a2.f1497d;
                                        String str = (String) gVar.f2458a;
                                        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) gVar.f2459b;
                                        try {
                                            PublicKey publicKey = eVar.f2453a.getPublicKey();
                                            Signature signature = Signature.getInstance(str);
                                            signature.initVerify(publicKey);
                                            if (algorithmParameterSpec != null) {
                                                signature.setParameter(algorithmParameterSpec);
                                            }
                                            signature.update(c5);
                                            if (!signature.verify(e4)) {
                                                throw new SecurityException("Unable to verify signature of certificate #" + i5 + " using " + str + " when verifying V3SigningCertificateLineage object");
                                            }
                                        } catch (BufferUnderflowException e5) {
                                            e = e5;
                                            throw new IOException("Failed to parse V3SigningCertificateLineage object", e);
                                        }
                                    }
                                    c5.rewind();
                                    byte[] e6 = q.e(c5);
                                    int i9 = c5.getInt();
                                    if (eVar != null && i6 != i9) {
                                        throw new SecurityException("Signing algorithm ID mismatch for certificate #" + c4 + " when verifying V3SigningCertificateLineage object");
                                    }
                                    W0.e eVar2 = new W0.e(W0.j.a(e6), e6);
                                    if (!hashSet.contains(eVar2)) {
                                        hashSet.add(eVar2);
                                        arrayList.add(new R0.b(eVar2, t.a(i9), t.a(i8), e4, i7));
                                        eVar = eVar2;
                                        i6 = i8;
                                    } else {
                                        throw new SecurityException("Encountered duplicate entries in SigningCertificateLineage at certificate #" + i5 + ".  All signing certificates should be unique");
                                    }
                                } catch (InvalidAlgorithmParameterException e7) {
                                    e = e7;
                                    i4 = i5;
                                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                                } catch (InvalidKeyException e8) {
                                    e = e8;
                                    i4 = i5;
                                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                                } catch (NoSuchAlgorithmException e9) {
                                    e = e9;
                                    i4 = i5;
                                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                                } catch (SignatureException e10) {
                                    e = e10;
                                    i4 = i5;
                                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                                } catch (CertificateException e11) {
                                    e = e11;
                                    i3 = i5;
                                    throw new SecurityException(AbstractC0008a.j(i3, "Failed to decode certificate #", " when parsing V3SigningCertificateLineage object"), e);
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Encoded SigningCertificateLineage has a version different than any of which we are aware");
                        }
                    } catch (ApkFormatException | BufferUnderflowException e12) {
                        e = e12;
                    }
                } catch (InvalidAlgorithmParameterException e13) {
                    e = e13;
                    i4 = 0;
                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                } catch (InvalidKeyException e14) {
                    e = e14;
                    i4 = 0;
                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                } catch (NoSuchAlgorithmException e15) {
                    e = e15;
                    i4 = 0;
                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                } catch (SignatureException e16) {
                    e = e16;
                    i4 = 0;
                    throw new SecurityException(AbstractC0008a.j(i4, "Failed to verify signature over signed data for certificate #", " when parsing V3SigningCertificateLineage object"), e);
                } catch (CertificateException e17) {
                    e = e17;
                    i3 = 0;
                }
            } else {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 28;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                t tVar = ((R0.b) obj).f1976c;
                if (tVar != null && (i = tVar.f1498e) > i10) {
                    i10 = i;
                }
            }
            return new n(i10, arrayList);
        }
        throw new IllegalArgumentException("Can't calculate minimum SDK version of null nodes");
    }

    public final n b(X509Certificate x509Certificate) {
        if (x509Certificate != null) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.f1279b;
                if (i < arrayList.size()) {
                    if (((R0.b) arrayList.get(i)).f1974a.equals(x509Certificate)) {
                        return new n(this.f1278a, new ArrayList(arrayList.subList(0, i + 1)));
                    }
                    i++;
                } else {
                    throw new IllegalArgumentException("Certificate not found in SigningCertificateLineage");
                }
            }
        } else {
            throw new NullPointerException("x509Certificate == null");
        }
    }
}
