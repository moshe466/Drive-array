package com.android.apksig.internal.x509;

import S0.g;
import S0.j;
import W0.e;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import com.android.apksig.internal.pkcs7.IssuerAndSerialNumber;
import com.android.apksig.internal.pkcs7.SignerIdentifier;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class Certificate {

    @Asn1Field(index = 0, type = j.f2104f)
    public TBSCertificate certificate;

    @Asn1Field(index = 2, type = j.f2107l)
    public ByteBuffer signature;

    @Asn1Field(index = 1, type = j.f2104f)
    public AlgorithmIdentifier signatureAlgorithm;

    public static X509Certificate findCertificate(Collection<X509Certificate> collection, SignerIdentifier signerIdentifier) {
        for (X509Certificate x509Certificate : collection) {
            if (isMatchingCerticicate(x509Certificate, signerIdentifier)) {
                return x509Certificate;
            }
        }
        return null;
    }

    private static boolean isMatchingCerticicate(X509Certificate x509Certificate, SignerIdentifier signerIdentifier) {
        IssuerAndSerialNumber issuerAndSerialNumber = signerIdentifier.issuerAndSerialNumber;
        if (issuerAndSerialNumber != null) {
            ByteBuffer slice = issuerAndSerialNumber.issuer.f2090a.slice();
            byte[] bArr = new byte[slice.remaining()];
            slice.get(bArr);
            X500Principal x500Principal = new X500Principal(bArr);
            if (issuerAndSerialNumber.certificateSerialNumber.equals(x509Certificate.getSerialNumber()) && x500Principal.equals(x509Certificate.getIssuerX500Principal())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static List<X509Certificate> parseCertificates(List<g> list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ByteBuffer slice = list.get(i).f2090a.slice();
            byte[] bArr = new byte[slice.remaining()];
            slice.get(bArr);
            try {
                arrayList.add(new e(W0.j.a(bArr), bArr));
            } catch (CertificateException e4) {
                throw new CertificateException("Failed to parse certificate #" + (i + 1), e4);
            }
        }
        return arrayList;
    }
}
