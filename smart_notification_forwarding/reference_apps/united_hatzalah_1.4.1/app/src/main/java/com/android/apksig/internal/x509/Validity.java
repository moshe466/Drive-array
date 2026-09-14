package com.android.apksig.internal.x509;

import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class Validity {

    @Asn1Field(index = 1, type = j.f2100b)
    public Time notAfter;

    @Asn1Field(index = 0, type = j.f2100b)
    public Time notBefore;
}
