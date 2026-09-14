package com.android.apksig.internal.x509;

import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import java.util.List;

@Asn1Class(type = j.f2100b)
/* loaded from: classes.dex */
public class Name {

    @Asn1Field(index = 0, type = j.f2105j)
    public List<RelativeDistinguishedName> relativeDistinguishedNames;
}
