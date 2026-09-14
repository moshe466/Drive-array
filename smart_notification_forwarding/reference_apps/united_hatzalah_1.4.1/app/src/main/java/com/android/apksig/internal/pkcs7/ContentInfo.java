package com.android.apksig.internal.pkcs7;

import S0.g;
import S0.i;
import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class ContentInfo {

    @Asn1Field(index = 2, tagNumber = 0, tagging = i.f2096b, type = j.f2099a)
    public g content;

    @Asn1Field(index = 1, type = j.f2102d)
    public String contentType;
}
