package com.android.apksig.internal.pkcs7;

import S0.g;
import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import java.util.List;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class Attribute {

    @Asn1Field(index = 0, type = j.f2102d)
    public String attrType;

    @Asn1Field(index = 1, type = j.f2106k)
    public List<g> attrValues;
}
