package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdResponseParcelCreator")
/* loaded from: classes.dex */
public final class zzapx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapx> CREATOR = new zzapw();

    @SafeParcelable.Field(id = 5)
    private final int errorCode;

    @SafeParcelable.Field(id = 12)
    private final int orientation;

    @SafeParcelable.Field(id = 1)
    private final int versionCode;

    @Nullable
    @SafeParcelable.Field(id = 37)
    private final zzapz zzbku;

    @SafeParcelable.Field(id = 49)
    private final boolean zzble;

    @SafeParcelable.Field(id = 53)
    private final boolean zzblf;

    @SafeParcelable.Field(id = 23)
    private final boolean zzbmc;

    @SafeParcelable.Field(id = 30)
    private final String zzbzo;

    @SafeParcelable.Field(id = 31)
    private final boolean zzccq;

    @SafeParcelable.Field(id = 32)
    private final boolean zzccr;

    @SafeParcelable.Field(id = 4)
    private final List<String> zzdbq;

    @SafeParcelable.Field(id = 6)
    private final List<String> zzdbr;

    @SafeParcelable.Field(id = 52)
    private final List<String> zzdbs;

    @SafeParcelable.Field(id = 40)
    private final List<String> zzdbu;

    @SafeParcelable.Field(id = 42)
    private final boolean zzdbv;

    @SafeParcelable.Field(id = 11)
    private final long zzdbx;

    @SafeParcelable.Field(id = 2)
    private final String zzdhr;

    @SafeParcelable.Field(id = 24)
    private final boolean zzdiv;

    @SafeParcelable.Field(id = 38)
    private final boolean zzdji;

    @Nullable
    @SafeParcelable.Field(id = 39)
    private String zzdjj;

    @SafeParcelable.Field(id = 47)
    private final boolean zzdjv;

    @SafeParcelable.Field(id = 3)
    private String zzdki;

    @SafeParcelable.Field(id = 7)
    private final long zzdkj;

    @SafeParcelable.Field(id = 8)
    private final boolean zzdkk;

    @SafeParcelable.Field(id = 9)
    private final long zzdkl;

    @SafeParcelable.Field(id = 10)
    private final List<String> zzdkm;

    @SafeParcelable.Field(id = 13)
    private final String zzdkn;

    @SafeParcelable.Field(id = 14)
    private final long zzdko;

    @SafeParcelable.Field(id = 15)
    private final String zzdkp;

    @SafeParcelable.Field(id = 18)
    private final boolean zzdkq;

    @SafeParcelable.Field(id = 19)
    private final String zzdkr;

    @SafeParcelable.Field(id = 21)
    private final String zzdks;

    @SafeParcelable.Field(id = 22)
    private final boolean zzdkt;

    @SafeParcelable.Field(id = 25)
    private final boolean zzdku;

    @SafeParcelable.Field(id = 26)
    private final boolean zzdkv;

    @SafeParcelable.Field(id = 28)
    private zzaqj zzdkw;

    @SafeParcelable.Field(id = 29)
    private String zzdkx;

    @Nullable
    @SafeParcelable.Field(id = 33)
    private final zzasd zzdky;

    @Nullable
    @SafeParcelable.Field(id = 34)
    private final List<String> zzdkz;

    @Nullable
    @SafeParcelable.Field(id = 35)
    private final List<String> zzdla;

    @SafeParcelable.Field(id = 36)
    private final boolean zzdlb;

    @Nullable
    @SafeParcelable.Field(id = 43)
    private final String zzdlc;

    @Nullable
    @SafeParcelable.Field(id = 44)
    private final zzatn zzdld;

    @Nullable
    @SafeParcelable.Field(id = 45)
    private final String zzdle;

    @SafeParcelable.Field(id = 46)
    private final boolean zzdlf;

    @SafeParcelable.Field(id = 48)
    private Bundle zzdlg;

    @SafeParcelable.Field(id = 50)
    private final int zzdlh;

    @SafeParcelable.Field(id = 51)
    private final boolean zzdli;

    @Nullable
    @SafeParcelable.Field(id = 54)
    private final String zzdlj;

    @Nullable
    @SafeParcelable.Field(id = 55)
    private String zzdlk;

    @SafeParcelable.Field(id = 56)
    private boolean zzdll;

    @SafeParcelable.Field(id = 57)
    private boolean zzdlm;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzapx(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<String> list, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) List<String> list2, @SafeParcelable.Param(id = 7) long j, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) List<String> list3, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) long j4, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 18) boolean z2, @SafeParcelable.Param(id = 19) String str5, @SafeParcelable.Param(id = 21) String str6, @SafeParcelable.Param(id = 22) boolean z3, @SafeParcelable.Param(id = 23) boolean z4, @SafeParcelable.Param(id = 24) boolean z5, @SafeParcelable.Param(id = 25) boolean z6, @SafeParcelable.Param(id = 26) boolean z7, @SafeParcelable.Param(id = 28) zzaqj zzaqjVar, @SafeParcelable.Param(id = 29) String str7, @SafeParcelable.Param(id = 30) String str8, @SafeParcelable.Param(id = 31) boolean z8, @SafeParcelable.Param(id = 32) boolean z9, @SafeParcelable.Param(id = 33) zzasd zzasdVar, @SafeParcelable.Param(id = 34) List<String> list4, @SafeParcelable.Param(id = 35) List<String> list5, @SafeParcelable.Param(id = 36) boolean z10, @SafeParcelable.Param(id = 37) zzapz zzapzVar, @SafeParcelable.Param(id = 38) boolean z11, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 40) List<String> list6, @SafeParcelable.Param(id = 42) boolean z12, @SafeParcelable.Param(id = 43) String str10, @SafeParcelable.Param(id = 44) zzatn zzatnVar, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) boolean z13, @SafeParcelable.Param(id = 47) boolean z14, @SafeParcelable.Param(id = 48) Bundle bundle, @SafeParcelable.Param(id = 49) boolean z15, @SafeParcelable.Param(id = 50) int i4, @SafeParcelable.Param(id = 51) boolean z16, @SafeParcelable.Param(id = 52) List<String> list7, @SafeParcelable.Param(id = 53) boolean z17, @SafeParcelable.Param(id = 54) String str12, @Nullable @SafeParcelable.Param(id = 55) String str13, @SafeParcelable.Param(id = 56) boolean z18, @SafeParcelable.Param(id = 57) boolean z19) {
        zzaqj zzaqjVar2;
        zzaqm zzaqmVar;
        this.versionCode = i;
        this.zzdhr = str;
        this.zzdki = str2;
        this.zzdbq = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdbr = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdkj = j;
        this.zzdkk = z;
        this.zzdkl = j2;
        this.zzdkm = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdbx = j3;
        this.orientation = i3;
        this.zzdkn = str3;
        this.zzdko = j4;
        this.zzdkp = str4;
        this.zzdkq = z2;
        this.zzdkr = str5;
        this.zzdks = str6;
        this.zzdkt = z3;
        this.zzbmc = z4;
        this.zzdiv = z5;
        this.zzdku = z6;
        this.zzdlf = z13;
        this.zzdkv = z7;
        this.zzdkw = zzaqjVar;
        this.zzdkx = str7;
        this.zzbzo = str8;
        if (this.zzdki == null && (zzaqjVar2 = this.zzdkw) != null && (zzaqmVar = (zzaqm) zzaqjVar2.zza(zzaqm.CREATOR)) != null && !TextUtils.isEmpty(zzaqmVar.a)) {
            this.zzdki = zzaqmVar.a;
        }
        this.zzccq = z8;
        this.zzccr = z9;
        this.zzdky = zzasdVar;
        this.zzdkz = list4;
        this.zzdla = list5;
        this.zzdlb = z10;
        this.zzbku = zzapzVar;
        this.zzdji = z11;
        this.zzdjj = str9;
        this.zzdbu = list6;
        this.zzdbv = z12;
        this.zzdlc = str10;
        this.zzdld = zzatnVar;
        this.zzdle = str11;
        this.zzdjv = z14;
        this.zzdlg = bundle;
        this.zzble = z15;
        this.zzdlh = i4;
        this.zzdli = z16;
        this.zzdbs = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.zzblf = z17;
        this.zzdlj = str12;
        this.zzdlk = str13;
        this.zzdll = z18;
        this.zzdlm = z19;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzdhr, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdki, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzdbq, false);
        SafeParcelWriter.writeInt(parcel, 5, this.errorCode);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdbr, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzdkj);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdkk);
        SafeParcelWriter.writeLong(parcel, 9, this.zzdkl);
        SafeParcelWriter.writeStringList(parcel, 10, this.zzdkm, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzdbx);
        SafeParcelWriter.writeInt(parcel, 12, this.orientation);
        SafeParcelWriter.writeString(parcel, 13, this.zzdkn, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdko);
        SafeParcelWriter.writeString(parcel, 15, this.zzdkp, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdkq);
        SafeParcelWriter.writeString(parcel, 19, this.zzdkr, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzdks, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzdkt);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzbmc);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzdiv);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzdku);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzdkv);
        SafeParcelWriter.writeParcelable(parcel, 28, this.zzdkw, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.zzdkx, false);
        SafeParcelWriter.writeString(parcel, 30, this.zzbzo, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzccq);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzccr);
        SafeParcelWriter.writeParcelable(parcel, 33, this.zzdky, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.zzdkz, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.zzdla, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzdlb);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzbku, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdji);
        SafeParcelWriter.writeString(parcel, 39, this.zzdjj, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.zzdbu, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdbv);
        SafeParcelWriter.writeString(parcel, 43, this.zzdlc, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.zzdld, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdle, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.zzdlf);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdjv);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdlg, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.zzble);
        SafeParcelWriter.writeInt(parcel, 50, this.zzdlh);
        SafeParcelWriter.writeBoolean(parcel, 51, this.zzdli);
        SafeParcelWriter.writeStringList(parcel, 52, this.zzdbs, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.zzblf);
        SafeParcelWriter.writeString(parcel, 54, this.zzdlj, false);
        SafeParcelWriter.writeString(parcel, 55, this.zzdlk, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.zzdll);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdlm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
