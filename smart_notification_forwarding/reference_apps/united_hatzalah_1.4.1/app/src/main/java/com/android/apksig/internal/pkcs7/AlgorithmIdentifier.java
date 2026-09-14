package com.android.apksig.internal.pkcs7;

import F0.AbstractC0008a;
import S0.f;
import S0.g;
import S0.j;
import V0.b;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import e0.a;
import io.flutter.BuildConfig;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.SignatureException;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class AlgorithmIdentifier {

    @Asn1Field(index = 0, type = j.f2102d)
    public String algorithm;

    @Asn1Field(index = 1, optional = BuildConfig.RELEASE, type = j.f2099a)
    public g parameters;

    public AlgorithmIdentifier() {
    }

    public static String getJcaDigestAlgorithm(String str) {
        String str2 = (String) b.f2444b.get(str);
        if (str2 != null) {
            return str2;
        }
        throw new SignatureException(a.d("Unsupported digest algorithm: ", str));
    }

    public static String getJcaSignatureAlgorithm(String str, String str2) {
        String str3;
        String str4 = (String) b.f2445c.get(str2);
        if (str4 != null) {
            return str4;
        }
        if ("1.2.840.113549.1.1.1".equals(str2)) {
            str3 = "RSA";
        } else if ("1.2.840.10040.4.1".equals(str2)) {
            str3 = "DSA";
        } else if ("1.2.840.10045.2.1".equals(str2)) {
            str3 = "ECDSA";
        } else {
            throw new SignatureException(a.f("Unsupported JCA Signature algorithm . Digest algorithm: ", str, ", signature algorithm: ", str2));
        }
        String jcaDigestAlgorithm = getJcaDigestAlgorithm(str);
        if (jcaDigestAlgorithm.startsWith("SHA-")) {
            jcaDigestAlgorithm = "SHA" + jcaDigestAlgorithm.substring(4);
        }
        return AbstractC0008a.o(jcaDigestAlgorithm, "with", str3);
    }

    public static AlgorithmIdentifier getSignerInfoDigestAlgorithmOid(P0.a aVar) {
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return new AlgorithmIdentifier("2.16.840.1.101.3.4.2.1", f.f2089a);
            }
            throw new IllegalArgumentException("Unsupported digest algorithm: " + aVar);
        }
        return new AlgorithmIdentifier("1.3.14.3.2.26", f.f2089a);
    }

    public static W0.g getSignerInfoSignatureAlgorithm(PublicKey publicKey, P0.a aVar, boolean z3) {
        String str;
        AlgorithmIdentifier algorithmIdentifier;
        String str2;
        String algorithm = publicKey.getAlgorithm();
        int ordinal = aVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                str = "SHA256";
            } else {
                throw new IllegalArgumentException("Unexpected digest algorithm: " + aVar);
            }
        } else {
            str = "SHA1";
        }
        if (!"RSA".equalsIgnoreCase(algorithm) && !"1.2.840.113549.1.1.1".equals(algorithm)) {
            if ("DSA".equalsIgnoreCase(algorithm)) {
                int ordinal2 = aVar.ordinal();
                if (ordinal2 != 0) {
                    if (ordinal2 == 1) {
                        algorithmIdentifier = new AlgorithmIdentifier("2.16.840.1.101.3.4.3.2", f.f2089a);
                    } else {
                        throw new IllegalArgumentException("Unexpected digest algorithm: " + aVar);
                    }
                } else {
                    algorithmIdentifier = new AlgorithmIdentifier("1.2.840.10040.4.1", f.f2089a);
                }
                if (z3) {
                    str2 = "withDetDSA";
                } else {
                    str2 = "withDSA";
                }
                return new W0.g(str.concat(str2), algorithmIdentifier);
            }
            if ("EC".equalsIgnoreCase(algorithm)) {
                return new W0.g(str.concat("withECDSA"), new AlgorithmIdentifier("1.2.840.10045.2.1", f.f2089a));
            }
            throw new InvalidKeyException(a.d("Unsupported key algorithm: ", algorithm));
        }
        return new W0.g(str.concat("withRSA"), new AlgorithmIdentifier("1.2.840.113549.1.1.1", f.f2089a));
    }

    public AlgorithmIdentifier(String str, g gVar) {
        this.algorithm = str;
        this.parameters = gVar;
    }
}
