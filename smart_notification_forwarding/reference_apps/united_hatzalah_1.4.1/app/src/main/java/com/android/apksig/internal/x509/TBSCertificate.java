package com.android.apksig.internal.x509;

import S0.i;
import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import io.flutter.BuildConfig;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.List;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class TBSCertificate {

    @Asn1Field(index = 9, optional = BuildConfig.RELEASE, tagNumber = 3, tagging = i.f2096b, type = j.f2105j)
    public List<Extension> extensions;

    @Asn1Field(index = 3, type = j.f2100b)
    public Name issuer;

    @Asn1Field(index = 7, optional = BuildConfig.RELEASE, tagNumber = 1, tagging = i.f2097c, type = j.f2107l)
    public ByteBuffer issuerUniqueID;

    @Asn1Field(index = 1, type = j.f2101c)
    public BigInteger serialNumber;

    @Asn1Field(index = 2, type = j.f2104f)
    public AlgorithmIdentifier signatureAlgorithm;

    @Asn1Field(index = 5, type = j.f2100b)
    public Name subject;

    @Asn1Field(index = 6, type = j.f2104f)
    public SubjectPublicKeyInfo subjectPublicKeyInfo;

    @Asn1Field(index = 8, optional = BuildConfig.RELEASE, tagNumber = 2, tagging = i.f2097c, type = j.f2107l)
    public ByteBuffer subjectUniqueID;

    @Asn1Field(index = 4, type = j.f2104f)
    public Validity validity;

    @Asn1Field(index = 0, tagNumber = 0, tagging = i.f2096b, type = j.f2101c)
    public int version;
}
