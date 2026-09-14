package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
/* loaded from: classes.dex */
public final class zzapv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapv> CREATOR = new zzapu();

    @SafeParcelable.Field(id = 6)
    private final ApplicationInfo applicationInfo;

    @SafeParcelable.Field(id = 1)
    private final int versionCode;

    @SafeParcelable.Field(id = 11)
    private final zzazb zzbll;

    @SafeParcelable.Field(id = 4)
    private final zzuj zzblm;

    @SafeParcelable.Field(id = 20)
    private final float zzboh;

    @SafeParcelable.Field(id = 5)
    private final String zzbqz;

    @SafeParcelable.Field(id = 10)
    private final String zzcdu;

    @SafeParcelable.Field(id = 42)
    private final boolean zzdbv;

    @SafeParcelable.Field(id = 29)
    private final zzaby zzddz;

    @SafeParcelable.Field(id = 14)
    private final List<String> zzdea;

    @SafeParcelable.Field(id = 18)
    private final int zzdgf;

    @SafeParcelable.Field(id = 19)
    private final int zzdgg;

    @Nullable
    @SafeParcelable.Field(id = 2)
    private final Bundle zzdin;

    @SafeParcelable.Field(id = 3)
    private final zzug zzdio;

    @Nullable
    @SafeParcelable.Field(id = 7)
    private final PackageInfo zzdip;

    @SafeParcelable.Field(id = 8)
    private final String zzdiq;

    @SafeParcelable.Field(id = 9)
    private final String zzdir;

    @SafeParcelable.Field(id = 12)
    private final Bundle zzdis;

    @SafeParcelable.Field(id = 13)
    private final int zzdit;

    @SafeParcelable.Field(id = 15)
    private final Bundle zzdiu;

    @SafeParcelable.Field(id = 16)
    private final boolean zzdiv;

    @SafeParcelable.Field(id = 21)
    private final String zzdiw;

    @SafeParcelable.Field(id = 25)
    private final long zzdix;

    @SafeParcelable.Field(id = 26)
    private final String zzdiy;

    @Nullable
    @SafeParcelable.Field(id = 27)
    private final List<String> zzdiz;

    @SafeParcelable.Field(id = 28)
    private final String zzdja;

    @SafeParcelable.Field(id = 30)
    private final List<String> zzdjb;

    @SafeParcelable.Field(id = 31)
    private final long zzdjc;

    @SafeParcelable.Field(id = 33)
    private final String zzdjd;

    @SafeParcelable.Field(id = 34)
    private final float zzdje;

    @SafeParcelable.Field(id = 35)
    private final int zzdjf;

    @SafeParcelable.Field(id = 36)
    private final int zzdjg;

    @SafeParcelable.Field(id = 37)
    private final boolean zzdjh;

    @SafeParcelable.Field(id = 38)
    private final boolean zzdji;

    @SafeParcelable.Field(id = 39)
    private final String zzdjj;

    @SafeParcelable.Field(id = 40)
    private final boolean zzdjk;

    @SafeParcelable.Field(id = 41)
    private final String zzdjl;

    @SafeParcelable.Field(id = 43)
    private final int zzdjm;

    @SafeParcelable.Field(id = 44)
    private final Bundle zzdjn;

    @SafeParcelable.Field(id = 45)
    private final String zzdjo;

    @Nullable
    @SafeParcelable.Field(id = 46)
    private final zzxh zzdjp;

    @SafeParcelable.Field(id = 47)
    private final boolean zzdjq;

    @SafeParcelable.Field(id = 48)
    private final Bundle zzdjr;

    @Nullable
    @SafeParcelable.Field(id = 49)
    private final String zzdjs;

    @Nullable
    @SafeParcelable.Field(id = 50)
    private final String zzdjt;

    @Nullable
    @SafeParcelable.Field(id = 51)
    private final String zzdju;

    @SafeParcelable.Field(id = 52)
    private final boolean zzdjv;

    @SafeParcelable.Field(id = 53)
    private final List<Integer> zzdjw;

    @SafeParcelable.Field(id = 54)
    private final String zzdjx;

    @SafeParcelable.Field(id = 55)
    private final List<String> zzdjy;

    @SafeParcelable.Field(id = 56)
    private final int zzdjz;

    @SafeParcelable.Field(id = 57)
    private final boolean zzdka;

    @SafeParcelable.Field(id = 58)
    private final boolean zzdkb;

    @SafeParcelable.Field(id = 59)
    private final boolean zzdkc;

    @SafeParcelable.Field(id = 60)
    private final ArrayList<String> zzdkd;

    @SafeParcelable.Field(id = 61)
    private final String zzdke;

    @SafeParcelable.Field(id = 63)
    private final zzagz zzdkf;

    @Nullable
    @SafeParcelable.Field(id = 64)
    private final String zzdkg;

    @SafeParcelable.Field(id = 65)
    private final Bundle zzdkh;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzapv(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzug zzugVar, @SafeParcelable.Param(id = 4) zzuj zzujVar, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzazb zzazbVar, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i2, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) int i3, @SafeParcelable.Param(id = 19) int i4, @SafeParcelable.Param(id = 20) float f, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzaby zzabyVar, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j2, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f2, @SafeParcelable.Param(id = 40) boolean z2, @SafeParcelable.Param(id = 35) int i5, @SafeParcelable.Param(id = 36) int i6, @SafeParcelable.Param(id = 37) boolean z3, @SafeParcelable.Param(id = 38) boolean z4, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z5, @SafeParcelable.Param(id = 43) int i7, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzxh zzxhVar, @SafeParcelable.Param(id = 47) boolean z6, @SafeParcelable.Param(id = 48) Bundle bundle5, @Nullable @SafeParcelable.Param(id = 49) String str12, @Nullable @SafeParcelable.Param(id = 50) String str13, @Nullable @SafeParcelable.Param(id = 51) String str14, @SafeParcelable.Param(id = 52) boolean z7, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i8, @SafeParcelable.Param(id = 57) boolean z8, @SafeParcelable.Param(id = 58) boolean z9, @SafeParcelable.Param(id = 59) boolean z10, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzagz zzagzVar, @Nullable @SafeParcelable.Param(id = 64) String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        this.versionCode = i;
        this.zzdin = bundle;
        this.zzdio = zzugVar;
        this.zzblm = zzujVar;
        this.zzbqz = str;
        this.applicationInfo = applicationInfo;
        this.zzdip = packageInfo;
        this.zzdiq = str2;
        this.zzdir = str3;
        this.zzcdu = str4;
        this.zzbll = zzazbVar;
        this.zzdis = bundle2;
        this.zzdit = i2;
        this.zzdea = list;
        this.zzdjb = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzdiu = bundle3;
        this.zzdiv = z;
        this.zzdgf = i3;
        this.zzdgg = i4;
        this.zzboh = f;
        this.zzdiw = str5;
        this.zzdix = j;
        this.zzdiy = str6;
        this.zzdiz = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzdja = str7;
        this.zzddz = zzabyVar;
        this.zzdjc = j2;
        this.zzdjd = str8;
        this.zzdje = f2;
        this.zzdjk = z2;
        this.zzdjf = i5;
        this.zzdjg = i6;
        this.zzdjh = z3;
        this.zzdji = z4;
        this.zzdjj = str9;
        this.zzdjl = str10;
        this.zzdbv = z5;
        this.zzdjm = i7;
        this.zzdjn = bundle4;
        this.zzdjo = str11;
        this.zzdjp = zzxhVar;
        this.zzdjq = z6;
        this.zzdjr = bundle5;
        this.zzdjs = str12;
        this.zzdjt = str13;
        this.zzdju = str14;
        this.zzdjv = z7;
        this.zzdjw = list4;
        this.zzdjx = str15;
        this.zzdjy = list5;
        this.zzdjz = i8;
        this.zzdka = z8;
        this.zzdkb = z9;
        this.zzdkc = z10;
        this.zzdkd = arrayList;
        this.zzdke = str16;
        this.zzdkf = zzagzVar;
        this.zzdkg = str17;
        this.zzdkh = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdin, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdio, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzblm, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbqz, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdip, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdiq, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdir, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzcdu, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbll, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdis, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdit);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzdea, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdiu, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdiv);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdgf);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdgg);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzboh);
        SafeParcelWriter.writeString(parcel, 21, this.zzdiw, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdix);
        SafeParcelWriter.writeString(parcel, 26, this.zzdiy, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdiz, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzdja, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzddz, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdjb, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdjc);
        SafeParcelWriter.writeString(parcel, 33, this.zzdjd, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdje);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdjf);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdjg);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdjh);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdji);
        SafeParcelWriter.writeString(parcel, 39, this.zzdjj, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdjk);
        SafeParcelWriter.writeString(parcel, 41, this.zzdjl, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdbv);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdjm);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdjn, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdjo, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzdjp, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdjq);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdjr, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdjs, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdjt, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdju, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdjv);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzdjw, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdjx, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdjy, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzdjz);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdka);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdkb);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzdkc);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdkd, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzdke, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzdkf, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzdkg, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzdkh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
