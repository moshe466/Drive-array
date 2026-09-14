package com.android.apksig.internal.pkcs7;

import S0.g;
import S0.i;
import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import io.flutter.BuildConfig;
import java.nio.ByteBuffer;
import java.util.List;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class SignerInfo {

    @Asn1Field(index = 2, type = j.f2104f)
    public AlgorithmIdentifier digestAlgorithm;

    @Asn1Field(index = 1, type = j.f2100b)
    public SignerIdentifier sid;

    @Asn1Field(index = 5, type = j.f2103e)
    public ByteBuffer signature;

    @Asn1Field(index = 4, type = j.f2104f)
    public AlgorithmIdentifier signatureAlgorithm;

    @Asn1Field(index = 3, optional = BuildConfig.RELEASE, tagNumber = 0, tagging = i.f2097c, type = j.f2106k)
    public g signedAttrs;

    @Asn1Field(index = 6, optional = BuildConfig.RELEASE, tagNumber = 1, tagging = i.f2097c, type = j.f2106k)
    public List<Attribute> unsignedAttrs;

    @Asn1Field(index = 0, type = j.f2101c)
    public int version;
}
