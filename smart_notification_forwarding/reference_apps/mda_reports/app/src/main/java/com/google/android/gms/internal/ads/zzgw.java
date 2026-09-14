package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgw implements Parcelable {
    public static final Parcelable.Creator<zzgw> CREATOR = new zzgz();
    public final int height;
    public final int width;
    private final String zzaez;
    public final int zzafa;
    public final String zzafb;
    private final zzle zzafc;
    private final String zzafd;
    public final String zzafe;
    public final int zzaff;
    public final List<byte[]> zzafg;
    public final zziv zzafh;
    public final float zzafi;
    public final int zzafj;
    public final float zzafk;
    private final int zzafl;
    private final byte[] zzafm;
    private final zzor zzafn;
    public final int zzafo;
    public final int zzafp;
    public final int zzafq;
    private final int zzafr;
    private final int zzafs;
    public final long zzaft;
    public final int zzafu;
    public final String zzafv;
    private final int zzafw;
    private int zzafx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgw(Parcel parcel) {
        this.zzaez = parcel.readString();
        this.zzafd = parcel.readString();
        this.zzafe = parcel.readString();
        this.zzafb = parcel.readString();
        this.zzafa = parcel.readInt();
        this.zzaff = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzafi = parcel.readFloat();
        this.zzafj = parcel.readInt();
        this.zzafk = parcel.readFloat();
        this.zzafm = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzafl = parcel.readInt();
        this.zzafn = (zzor) parcel.readParcelable(zzor.class.getClassLoader());
        this.zzafo = parcel.readInt();
        this.zzafp = parcel.readInt();
        this.zzafq = parcel.readInt();
        this.zzafr = parcel.readInt();
        this.zzafs = parcel.readInt();
        this.zzafu = parcel.readInt();
        this.zzafv = parcel.readString();
        this.zzafw = parcel.readInt();
        this.zzaft = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzafg = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzafg.add(parcel.createByteArray());
        }
        this.zzafh = (zziv) parcel.readParcelable(zziv.class.getClassLoader());
        this.zzafc = (zzle) parcel.readParcelable(zzle.class.getClassLoader());
    }

    private zzgw(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzor zzorVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zziv zzivVar, zzle zzleVar) {
        this.zzaez = str;
        this.zzafd = str2;
        this.zzafe = str3;
        this.zzafb = str4;
        this.zzafa = i;
        this.zzaff = i2;
        this.width = i3;
        this.height = i4;
        this.zzafi = f;
        this.zzafj = i5;
        this.zzafk = f2;
        this.zzafm = bArr;
        this.zzafl = i6;
        this.zzafn = zzorVar;
        this.zzafo = i7;
        this.zzafp = i8;
        this.zzafq = i9;
        this.zzafr = i10;
        this.zzafs = i11;
        this.zzafu = i12;
        this.zzafv = str5;
        this.zzafw = i13;
        this.zzaft = j;
        this.zzafg = list == null ? Collections.emptyList() : list;
        this.zzafh = zzivVar;
        this.zzafc = zzleVar;
    }

    public static zzgw zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzor zzorVar, zziv zzivVar) {
        return new zzgw(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzorVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzivVar, null);
    }

    public static zzgw zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zziv zzivVar, int i6, String str4) {
        return new zzgw(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzivVar, null);
    }

    public static zzgw zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zziv zzivVar, int i5, String str4) {
        return zza(str, str2, null, -1, -1, i3, i4, -1, null, zzivVar, 0, str4);
    }

    public static zzgw zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zziv zzivVar, long j, List<byte[]> list) {
        return new zzgw(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzivVar, null);
    }

    public static zzgw zza(String str, String str2, String str3, int i, int i2, String str4, zziv zzivVar) {
        return zza(str, str2, null, -1, i2, str4, -1, zzivVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzgw zza(String str, String str2, String str3, int i, zziv zzivVar) {
        return new zzgw(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static zzgw zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zziv zzivVar) {
        return new zzgw(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzivVar, null);
    }

    @TargetApi(16)
    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzgw.class == obj.getClass()) {
            zzgw zzgwVar = (zzgw) obj;
            if (this.zzafa == zzgwVar.zzafa && this.zzaff == zzgwVar.zzaff && this.width == zzgwVar.width && this.height == zzgwVar.height && this.zzafi == zzgwVar.zzafi && this.zzafj == zzgwVar.zzafj && this.zzafk == zzgwVar.zzafk && this.zzafl == zzgwVar.zzafl && this.zzafo == zzgwVar.zzafo && this.zzafp == zzgwVar.zzafp && this.zzafq == zzgwVar.zzafq && this.zzafr == zzgwVar.zzafr && this.zzafs == zzgwVar.zzafs && this.zzaft == zzgwVar.zzaft && this.zzafu == zzgwVar.zzafu && zzoq.zza(this.zzaez, zzgwVar.zzaez) && zzoq.zza(this.zzafv, zzgwVar.zzafv) && this.zzafw == zzgwVar.zzafw && zzoq.zza(this.zzafd, zzgwVar.zzafd) && zzoq.zza(this.zzafe, zzgwVar.zzafe) && zzoq.zza(this.zzafb, zzgwVar.zzafb) && zzoq.zza(this.zzafh, zzgwVar.zzafh) && zzoq.zza(this.zzafc, zzgwVar.zzafc) && zzoq.zza(this.zzafn, zzgwVar.zzafn) && Arrays.equals(this.zzafm, zzgwVar.zzafm) && this.zzafg.size() == zzgwVar.zzafg.size()) {
                for (int i = 0; i < this.zzafg.size(); i++) {
                    if (!Arrays.equals(this.zzafg.get(i), zzgwVar.zzafg.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            String str = this.zzaez;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzafd;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzafe;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzafb;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzafa) * 31) + this.width) * 31) + this.height) * 31) + this.zzafo) * 31) + this.zzafp) * 31;
            String str5 = this.zzafv;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzafw) * 31;
            zziv zzivVar = this.zzafh;
            int hashCode6 = (hashCode5 + (zzivVar == null ? 0 : zzivVar.hashCode())) * 31;
            zzle zzleVar = this.zzafc;
            this.zzafx = hashCode6 + (zzleVar != null ? zzleVar.hashCode() : 0);
        }
        return this.zzafx;
    }

    public final String toString() {
        String str = this.zzaez;
        String str2 = this.zzafd;
        String str3 = this.zzafe;
        int i = this.zzafa;
        String str4 = this.zzafv;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzafi;
        int i4 = this.zzafo;
        int i5 = this.zzafp;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaez);
        parcel.writeString(this.zzafd);
        parcel.writeString(this.zzafe);
        parcel.writeString(this.zzafb);
        parcel.writeInt(this.zzafa);
        parcel.writeInt(this.zzaff);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzafi);
        parcel.writeInt(this.zzafj);
        parcel.writeFloat(this.zzafk);
        parcel.writeInt(this.zzafm != null ? 1 : 0);
        byte[] bArr = this.zzafm;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzafl);
        parcel.writeParcelable(this.zzafn, i);
        parcel.writeInt(this.zzafo);
        parcel.writeInt(this.zzafp);
        parcel.writeInt(this.zzafq);
        parcel.writeInt(this.zzafr);
        parcel.writeInt(this.zzafs);
        parcel.writeInt(this.zzafu);
        parcel.writeString(this.zzafv);
        parcel.writeInt(this.zzafw);
        parcel.writeLong(this.zzaft);
        int size = this.zzafg.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzafg.get(i2));
        }
        parcel.writeParcelable(this.zzafh, 0);
        parcel.writeParcelable(this.zzafc, 0);
    }

    public final zzgw zza(zzle zzleVar) {
        return new zzgw(this.zzaez, this.zzafd, this.zzafe, this.zzafb, this.zzafa, this.zzaff, this.width, this.height, this.zzafi, this.zzafj, this.zzafk, this.zzafm, this.zzafl, this.zzafn, this.zzafo, this.zzafp, this.zzafq, this.zzafr, this.zzafs, this.zzafu, this.zzafv, this.zzafw, this.zzaft, this.zzafg, this.zzafh, zzleVar);
    }

    public final zzgw zzb(int i, int i2) {
        return new zzgw(this.zzaez, this.zzafd, this.zzafe, this.zzafb, this.zzafa, this.zzaff, this.width, this.height, this.zzafi, this.zzafj, this.zzafk, this.zzafm, this.zzafl, this.zzafn, this.zzafo, this.zzafp, this.zzafq, i, i2, this.zzafu, this.zzafv, this.zzafw, this.zzaft, this.zzafg, this.zzafh, this.zzafc);
    }

    public final zzgw zzds(long j) {
        return new zzgw(this.zzaez, this.zzafd, this.zzafe, this.zzafb, this.zzafa, this.zzaff, this.width, this.height, this.zzafi, this.zzafj, this.zzafk, this.zzafm, this.zzafl, this.zzafn, this.zzafo, this.zzafp, this.zzafq, this.zzafr, this.zzafs, this.zzafu, this.zzafv, this.zzafw, j, this.zzafg, this.zzafh, this.zzafc);
    }

    public final int zzep() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzeq() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzafe);
        String str = this.zzafv;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        zza(mediaFormat, "max-input-size", this.zzaff);
        zza(mediaFormat, SettingsJsonConstants.ICON_WIDTH_KEY, this.width);
        zza(mediaFormat, SettingsJsonConstants.ICON_HEIGHT_KEY, this.height);
        float f = this.zzafi;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zza(mediaFormat, "rotation-degrees", this.zzafj);
        zza(mediaFormat, "channel-count", this.zzafo);
        zza(mediaFormat, "sample-rate", this.zzafp);
        zza(mediaFormat, "encoder-delay", this.zzafr);
        zza(mediaFormat, "encoder-padding", this.zzafs);
        for (int i = 0; i < this.zzafg.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzafg.get(i)));
        }
        zzor zzorVar = this.zzafn;
        if (zzorVar != null) {
            zza(mediaFormat, "color-transfer", zzorVar.zzaqa);
            zza(mediaFormat, "color-standard", zzorVar.zzapz);
            zza(mediaFormat, "color-range", zzorVar.zzaqb);
            byte[] bArr = zzorVar.zzbha;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final zzgw zzp(int i) {
        return new zzgw(this.zzaez, this.zzafd, this.zzafe, this.zzafb, this.zzafa, i, this.width, this.height, this.zzafi, this.zzafj, this.zzafk, this.zzafm, this.zzafl, this.zzafn, this.zzafo, this.zzafp, this.zzafq, this.zzafr, this.zzafs, this.zzafu, this.zzafv, this.zzafw, this.zzaft, this.zzafg, this.zzafh, this.zzafc);
    }
}
