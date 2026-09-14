package com.android.apksig.internal.x509;

import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.pkcs7.AlgorithmIdentifier;
import java.nio.ByteBuffer;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class SubjectPublicKeyInfo {

    @Asn1Field(index = 0, type = j.f2104f)
    public AlgorithmIdentifier algorithmIdentifier;

    @Asn1Field(index = 1, type = j.f2107l)
    public ByteBuffer subjectPublicKey;
}
