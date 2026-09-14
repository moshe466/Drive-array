package com.android.apksig.internal.x509;

import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import java.math.BigInteger;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class RSAPublicKey {

    @Asn1Field(index = 0, type = j.f2101c)
    public BigInteger modulus;

    @Asn1Field(index = 1, type = j.f2101c)
    public BigInteger publicExponent;
}
