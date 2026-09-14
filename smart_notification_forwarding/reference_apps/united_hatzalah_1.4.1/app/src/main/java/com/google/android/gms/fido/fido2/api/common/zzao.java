package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzao implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        Double d2 = null;
        String str = null;
        ArrayList arrayList = null;
        Integer num = null;
        TokenBinding tokenBinding = null;
        String str2 = null;
        AuthenticationExtensions authenticationExtensions = null;
        Long l3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 3:
                    d2 = SafeParcelReader.readDoubleObject(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, PublicKeyCredentialDescriptor.CREATOR);
                    break;
                case 6:
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 7:
                    tokenBinding = (TokenBinding) SafeParcelReader.createParcelable(parcel, readHeader, TokenBinding.CREATOR);
                    break;
                case 8:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    authenticationExtensions = (AuthenticationExtensions) SafeParcelReader.createParcelable(parcel, readHeader, AuthenticationExtensions.CREATOR);
                    break;
                case 10:
                    l3 = SafeParcelReader.readLongObject(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PublicKeyCredentialRequestOptions(bArr, d2, str, arrayList, num, tokenBinding, str2, authenticationExtensions, l3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new PublicKeyCredentialRequestOptions[i];
    }
}
