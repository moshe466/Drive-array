package com.android.apksig.internal.pkcs7;

import S0.g;
import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import java.math.BigInteger;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class IssuerAndSerialNumber {

    @Asn1Field(index = 1, type = j.f2101c)
    public BigInteger certificateSerialNumber;

    @Asn1Field(index = 0, type = j.f2099a)
    public g issuer;

    public IssuerAndSerialNumber() {
    }

    public IssuerAndSerialNumber(g gVar, BigInteger bigInteger) {
        this.issuer = gVar;
        this.certificateSerialNumber = bigInteger;
    }
}
