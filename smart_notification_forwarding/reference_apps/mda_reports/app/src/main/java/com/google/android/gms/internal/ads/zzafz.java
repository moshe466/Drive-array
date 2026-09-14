package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
/* loaded from: classes.dex */
public final class zzafz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzafz> CREATOR = new zzagc();

    @SafeParcelable.Field(id = 1)
    private final String url;

    @SafeParcelable.Field(id = 2)
    private final String[] zzcxv;

    @SafeParcelable.Field(id = 3)
    private final String[] zzcxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzafz(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) String[] strArr2) {
        this.url = str;
        this.zzcxv = strArr;
        this.zzcxw = strArr2;
    }

    public static zzafz zzh(zzq<?> zzqVar) {
        Map<String, String> headers = zzqVar.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzafz(zzqVar.getUrl(), strArr, strArr2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzcxv, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzcxw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
