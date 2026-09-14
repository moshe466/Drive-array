package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzry extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzry> CREATOR = new zzsb();

    @Nullable
    @SafeParcelable.Field(id = 2)
    public final String url;

    @SafeParcelable.Field(id = 3)
    private final long zzbrj;

    @SafeParcelable.Field(id = 4)
    private final String zzbrk;

    @SafeParcelable.Field(id = 5)
    private final String zzbrl;

    @SafeParcelable.Field(id = 6)
    private final String zzbrm;

    @SafeParcelable.Field(id = 7)
    private final Bundle zzbrn;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbro;

    @SafeParcelable.Field(id = 9)
    public long zzbrp;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzry(@Nullable @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2) {
        this.url = str;
        this.zzbrj = j;
        this.zzbrk = str2 == null ? "" : str2;
        this.zzbrl = str3 == null ? "" : str3;
        this.zzbrm = str4 != null ? str4 : "";
        this.zzbrn = bundle == null ? new Bundle() : bundle;
        this.zzbro = z;
        this.zzbrp = j2;
    }

    @Nullable
    public static zzry zzby(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zzry zzd(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzayu.zzez(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            com.google.android.gms.ads.internal.zzq.zzks();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzry(queryParameter, parseLong, host, str, str2, bundle, equals, 0L);
        } catch (NullPointerException | NumberFormatException e) {
            zzayu.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbrj);
        SafeParcelWriter.writeString(parcel, 4, this.zzbrk, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbrl, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbrm, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbrn, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbro);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbrp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
