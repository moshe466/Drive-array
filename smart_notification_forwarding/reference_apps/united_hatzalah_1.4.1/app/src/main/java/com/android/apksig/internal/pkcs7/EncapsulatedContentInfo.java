package com.android.apksig.internal.pkcs7;

import S0.i;
import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import io.flutter.BuildConfig;
import java.nio.ByteBuffer;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class EncapsulatedContentInfo {

    @Asn1Field(index = 1, optional = BuildConfig.RELEASE, tagNumber = 0, tagging = i.f2096b, type = j.f2103e)
    public ByteBuffer content;

    @Asn1Field(index = 0, type = j.f2102d)
    public String contentType;

    public EncapsulatedContentInfo() {
    }

    public EncapsulatedContentInfo(String str) {
        this.contentType = str;
    }
}
