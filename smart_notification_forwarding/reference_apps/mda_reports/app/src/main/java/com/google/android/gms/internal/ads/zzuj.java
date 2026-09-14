package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzuj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuj> CREATOR = new zzum();

    @SafeParcelable.Field(id = 3)
    public final int height;

    @SafeParcelable.Field(id = 4)
    public final int heightPixels;

    @SafeParcelable.Field(id = 6)
    public final int width;

    @SafeParcelable.Field(id = 7)
    public final int widthPixels;

    @SafeParcelable.Field(id = 2)
    public final String zzabg;

    @SafeParcelable.Field(id = 9)
    public final boolean zzbmc;

    @SafeParcelable.Field(id = 5)
    public final boolean zzcco;

    @SafeParcelable.Field(id = 8)
    public final zzuj[] zzccp;

    @SafeParcelable.Field(id = 10)
    public final boolean zzccq;

    @SafeParcelable.Field(id = 11)
    public boolean zzccr;

    @SafeParcelable.Field(id = 12)
    public boolean zzccs;

    @SafeParcelable.Field(id = 13)
    private boolean zzcct;

    @SafeParcelable.Field(id = 14)
    public boolean zzccu;

    @SafeParcelable.Field(id = 15)
    public boolean zzccv;

    public zzuj() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public zzuj(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzuj(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuj.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzuj(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) zzuj[] zzujVarArr, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4, @SafeParcelable.Param(id = 12) boolean z5, @SafeParcelable.Param(id = 13) boolean z6, @SafeParcelable.Param(id = 14) boolean z7, @SafeParcelable.Param(id = 15) boolean z8) {
        this.zzabg = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzcco = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzccp = zzujVarArr;
        this.zzbmc = z2;
        this.zzccq = z3;
        this.zzccr = z4;
        this.zzccs = z5;
        this.zzcct = z6;
        this.zzccu = z7;
        this.zzccv = z8;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (zzd(displayMetrics) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzuj zzg(Context context) {
        return new zzuj("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false);
    }

    public static zzuj zzol() {
        return new zzuj("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false);
    }

    public static zzuj zzom() {
        return new zzuj("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false);
    }

    public static zzuj zzon() {
        return new zzuj("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzabg, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcco);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzccp, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbmc);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzccq);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzccr);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzccs);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzcct);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzccu);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzccv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdSize zzoo() {
        return com.google.android.gms.ads.zzb.zza(this.width, this.height, this.zzabg);
    }
}
