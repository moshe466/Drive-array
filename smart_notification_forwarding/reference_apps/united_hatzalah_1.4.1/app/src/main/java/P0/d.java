package P0;

import F0.C0035g2;
import N0.p;
import S0.g;
import W0.f;
import com.android.apksig.internal.apk.v1.V1SchemeVerifier$ObjectIdentifierChoice;
import com.android.apksig.internal.apk.v1.V1SchemeVerifier$OctetStringChoice;
import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.ber.BerDataValueFormatException;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import com.android.apksig.internal.pkcs7.Attribute;
import com.android.apksig.internal.pkcs7.SignedData;
import com.android.apksig.internal.pkcs7.SignerInfo;
import com.android.apksig.internal.x509.Certificate;
import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1567a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1568b;

    /* renamed from: c, reason: collision with root package name */
    public final X0.a f1569c;

    /* renamed from: d, reason: collision with root package name */
    public final X0.a f1570d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1571e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f1572f;

    /* renamed from: g, reason: collision with root package name */
    public HashSet f1573g;

    public d(String str, X0.a aVar, X0.a aVar2, c cVar) {
        this.f1567a = str;
        this.f1568b = cVar;
        this.f1570d = aVar;
        this.f1569c = aVar2;
    }

    public final X509Certificate a(SignedData signedData, List list, SignerInfo signerInfo, byte[] bArr, int i) {
        List<f> list2;
        String str;
        byte[] bArr2;
        boolean z3;
        String str2 = signerInfo.digestAlgorithm.algorithm;
        String str3 = signerInfo.signatureAlgorithm.algorithm;
        f fVar = new f(i, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        List list3 = (List) V0.b.f2443a.get(str2 + "with" + str3);
        if (list3 == null) {
            list3 = Collections.EMPTY_LIST;
        }
        if (list3.isEmpty()) {
            list2 = Collections.singletonList(fVar);
        } else {
            Iterator it = list3.iterator();
            int i3 = i;
            ArrayList arrayList = null;
            while (true) {
                if (it.hasNext()) {
                    f fVar2 = (f) it.next();
                    int i4 = fVar2.f2457b;
                    if (i3 <= i4) {
                        int i5 = fVar2.f2456a;
                        if (i3 < i5) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(new f(i3, i5 - 1));
                        }
                        if (i4 >= Integer.MAX_VALUE) {
                            if (arrayList != null) {
                                list2 = arrayList;
                            } else {
                                list2 = Collections.EMPTY_LIST;
                            }
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                } else {
                    if (i3 <= Integer.MAX_VALUE) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(1);
                        }
                        arrayList.add(new f(i3, Api.BaseClientBuilder.API_PRIORITY_OTHER));
                    }
                    list2 = arrayList;
                    if (list2 == null) {
                        list2 = Collections.EMPTY_LIST;
                    }
                }
            }
        }
        if (!list2.isEmpty()) {
            HashMap hashMap = V0.a.f2442a;
            String str4 = (String) hashMap.get(str2);
            if (str4 == null) {
                str4 = str2;
            }
            String str5 = (String) hashMap.get(str3);
            if (str5 == null) {
                str5 = str3;
            }
            StringBuilder sb = new StringBuilder();
            for (f fVar3 : list2) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                int i6 = fVar3.f2456a;
                int i7 = fVar3.f2457b;
                if (i6 == i7) {
                    sb.append(String.valueOf(i6));
                } else if (i7 == Integer.MAX_VALUE) {
                    sb.append(i6 + "+");
                } else {
                    sb.append(i6 + "-" + i7);
                }
            }
            c.a(this.f1568b, L0.e.JAR_SIG_UNSUPPORTED_SIG_ALG, new Object[]{this.f1570d.f2581g, str2, str3, sb.toString(), str4, str5});
            return null;
        }
        X509Certificate findCertificate = Certificate.findCertificate(list, signerInfo.sid);
        if (findCertificate != null) {
            if (!findCertificate.hasUnsupportedCriticalExtension()) {
                boolean[] keyUsage = findCertificate.getKeyUsage();
                if (keyUsage != null) {
                    boolean z4 = false;
                    if (keyUsage.length >= 1 && keyUsage[0]) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (keyUsage.length >= 2 && keyUsage[1]) {
                        z4 = true;
                    }
                    if (!z3 && !z4) {
                        throw new SignatureException("Signing certificate not authorized for use in digital signatures: keyUsage extension missing digitalSignature and nonRepudiation");
                    }
                }
                String jcaSignatureAlgorithm = AlgorithmIdentifier.getJcaSignatureAlgorithm(str2, str3);
                Signature signature = Signature.getInstance(jcaSignatureAlgorithm);
                PublicKey publicKey = findCertificate.getPublicKey();
                try {
                    signature.initVerify(publicKey);
                } catch (InvalidKeyException e4) {
                    try {
                        PublicKey generatePublic = KeyFactory.getInstance(publicKey.getAlgorithm()).generatePublic(new X509EncodedKeySpec(p.c(publicKey)));
                        Signature signature2 = Signature.getInstance(jcaSignatureAlgorithm);
                        signature2.initVerify(generatePublic);
                        signature = signature2;
                    } catch (InvalidKeySpecException unused) {
                        throw e4;
                    }
                }
                g gVar = signerInfo.signedAttrs;
                if (gVar != null) {
                    if (i >= 19) {
                        try {
                            try {
                                T0.a t3 = new C0035g2(gVar.f2090a.slice()).t();
                                if (t3 != null) {
                                    C0035g2 c0035g2 = new C0035g2(S0.c.j(t3, Attribute.class));
                                    g s3 = c0035g2.s("1.2.840.113549.1.9.3");
                                    if (s3 == null) {
                                        str = null;
                                    } else {
                                        try {
                                            str = ((V1SchemeVerifier$ObjectIdentifierChoice) S0.c.g(s3.f2090a.slice(), V1SchemeVerifier$ObjectIdentifierChoice.class)).value;
                                        } catch (Asn1DecodingException e5) {
                                            throw new Exception("Failed to decode OBJECT IDENTIFIER", e5);
                                        }
                                    }
                                    if (str != null) {
                                        if (str.equals(signedData.encapContentInfo.contentType)) {
                                            g s4 = c0035g2.s("1.2.840.113549.1.9.4");
                                            if (s4 == null) {
                                                bArr2 = null;
                                            } else {
                                                try {
                                                    bArr2 = ((V1SchemeVerifier$OctetStringChoice) S0.c.g(s4.f2090a.slice(), V1SchemeVerifier$OctetStringChoice.class)).value;
                                                } catch (Asn1DecodingException e6) {
                                                    throw new Exception("Failed to decode OBJECT IDENTIFIER", e6);
                                                }
                                            }
                                            if (bArr2 != null) {
                                                if (Arrays.equals(bArr2, MessageDigest.getInstance(AlgorithmIdentifier.getJcaDigestAlgorithm(str2)).digest(bArr))) {
                                                    ByteBuffer slice = signerInfo.signedAttrs.f2090a.slice();
                                                    signature.update((byte) 49);
                                                    slice.position(1);
                                                    signature.update(slice);
                                                }
                                            } else {
                                                throw new SignatureException("No content digest in signed attributes");
                                            }
                                        }
                                        return null;
                                    }
                                    throw new SignatureException("No Content Type in signed attributes");
                                }
                                throw new Exception("Empty input");
                            } catch (BerDataValueFormatException e7) {
                                throw new Exception("Failed to decode top-level data value", e7);
                            }
                        } catch (Asn1DecodingException e8) {
                            throw new SignatureException("Failed to parse signed attributes", e8);
                        }
                    }
                    throw new SignatureException("APKs with Signed Attributes broken on platforms with API Level < 19");
                }
                signature.update(bArr);
                ByteBuffer slice2 = signerInfo.signature.slice();
                byte[] bArr3 = new byte[slice2.remaining()];
                slice2.get(bArr3);
                if (!signature.verify(bArr3)) {
                    return null;
                }
                return findCertificate;
            }
            throw new SignatureException("Signing certificate has unsupported critical extensions");
        }
        throw new SignatureException("Signing certificate referenced in SignerInfo not found in SignedData");
    }
}
