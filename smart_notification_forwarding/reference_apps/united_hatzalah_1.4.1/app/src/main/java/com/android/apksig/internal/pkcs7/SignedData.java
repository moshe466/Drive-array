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
public class SignedData {

    @Asn1Field(index = 3, optional = BuildConfig.RELEASE, tagNumber = 0, tagging = i.f2097c, type = j.f2106k)
    public List<g> certificates;

    @Asn1Field(index = 4, optional = BuildConfig.RELEASE, tagNumber = 1, tagging = i.f2097c, type = j.f2106k)
    public List<ByteBuffer> crls;

    @Asn1Field(index = 1, type = j.f2106k)
    public List<AlgorithmIdentifier> digestAlgorithms;

    @Asn1Field(index = 2, type = j.f2104f)
    public EncapsulatedContentInfo encapContentInfo;

    @Asn1Field(index = 5, type = j.f2106k)
    public List<SignerInfo> signerInfos;

    @Asn1Field(index = 0, type = j.f2101c)
    public int version;
}
