package com.android.apksig.internal.x509;

import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import io.flutter.BuildConfig;
import java.nio.ByteBuffer;

@Asn1Class(type = j.f2104f)
/* loaded from: classes.dex */
public class Extension {

    @Asn1Field(index = 0, type = j.f2102d)
    public String extensionID;

    @Asn1Field(index = 2, type = j.f2103e)
    public ByteBuffer extensionValue;

    @Asn1Field(index = 1, optional = BuildConfig.RELEASE, type = j.f2110o)
    public boolean isCritial = false;
}
