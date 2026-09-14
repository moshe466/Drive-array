package com.android.apksig.internal.pkcs7;

import S0.i;
import S0.j;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1Field;
import java.nio.ByteBuffer;

@Asn1Class(type = j.f2100b)
/* loaded from: classes.dex */
public class SignerIdentifier {

    @Asn1Field(type = j.f2104f)
    public IssuerAndSerialNumber issuerAndSerialNumber;

    @Asn1Field(tagNumber = 0, tagging = i.f2097c, type = j.f2103e)
    public ByteBuffer subjectKeyIdentifier;

    public SignerIdentifier() {
    }

    public SignerIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.issuerAndSerialNumber = issuerAndSerialNumber;
    }
}
