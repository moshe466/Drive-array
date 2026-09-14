package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
/* loaded from: classes.dex */
public final class zzys extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzys> CREATOR = new zzyr();

    @SafeParcelable.Field(id = 15)
    public final String zzblv;

    public zzys(SearchAdRequest searchAdRequest) {
        this.zzblv = searchAdRequest.getQuery();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzys(@SafeParcelable.Param(id = 15) String str) {
        this.zzblv = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzblv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
