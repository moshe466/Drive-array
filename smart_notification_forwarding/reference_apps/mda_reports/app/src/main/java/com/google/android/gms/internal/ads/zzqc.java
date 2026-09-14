package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzqc {
    private int score;
    private final int zzboj;
    private final int zzbok;
    private final int zzbol;
    private final boolean zzbom;
    private final zzqr zzbon;
    private final zzqy zzboo;
    private final Object lock = new Object();
    private ArrayList<String> zzbop = new ArrayList<>();
    private ArrayList<String> zzboq = new ArrayList<>();
    private ArrayList<zzqp> zzbor = new ArrayList<>();
    private int zzbos = 0;
    private int zzbot = 0;
    private int zzbou = 0;
    private String zzbov = "";
    private String zzbow = "";
    private String zzbox = "";

    public zzqc(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zzboj = i;
        this.zzbok = i2;
        this.zzbol = i3;
        this.zzbom = z;
        this.zzbon = new zzqr(i4);
        this.zzboo = new zzqy(i5, i6, i7);
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        return sb2.length() < 100 ? sb2 : sb2.substring(0, 100);
    }

    private final void zzc(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str == null || str.length() < this.zzbol) {
            return;
        }
        synchronized (this.lock) {
            this.zzbop.add(str);
            this.zzbos += str.length();
            if (z) {
                this.zzboq.add(str);
                this.zzbor.add(new zzqp(f, f2, f3, f4, this.zzboq.size() - 1));
            }
        }
    }

    @VisibleForTesting
    private final int zzh(int i, int i2) {
        return this.zzbom ? this.zzbok : (i * this.zzboj) + (i2 * this.zzbok);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final int a() {
        return this.zzbos;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqc)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzqc) obj).zzbov;
        return str != null && str.equals(this.zzbov);
    }

    public final int getScore() {
        return this.score;
    }

    public final int hashCode() {
        return this.zzbov.hashCode();
    }

    public final String toString() {
        int i = this.zzbot;
        int i2 = this.score;
        int i3 = this.zzbos;
        String zza = zza(this.zzbop, 100);
        String zza2 = zza(this.zzboq, 100);
        String str = this.zzbov;
        String str2 = this.zzbow;
        String str3 = this.zzbox;
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        sb.append("\n viewableText");
        sb.append(zza2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.lock) {
            if (this.zzbou < 0) {
                zzayu.zzea("ActivityContent: negative number of WebViews.");
            }
            zzlz();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    public final void zzbp(int i) {
        this.zzbot = i;
    }

    public final boolean zzlr() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbou == 0;
        }
        return z;
    }

    public final String zzls() {
        return this.zzbov;
    }

    public final String zzlt() {
        return this.zzbow;
    }

    public final String zzlu() {
        return this.zzbox;
    }

    public final void zzlv() {
        synchronized (this.lock) {
            this.score -= 100;
        }
    }

    public final void zzlw() {
        synchronized (this.lock) {
            this.zzbou--;
        }
    }

    public final void zzlx() {
        synchronized (this.lock) {
            this.zzbou++;
        }
    }

    public final void zzly() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbos, this.zzbot);
            if (zzh > this.score) {
                this.score = zzh;
            }
        }
    }

    public final void zzlz() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbos, this.zzbot);
            if (zzh > this.score) {
                this.score = zzh;
                if (!com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvu()) {
                    this.zzbov = this.zzbon.zza(this.zzbop);
                    this.zzbow = this.zzbon.zza(this.zzboq);
                }
                if (!com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvw()) {
                    this.zzbox = this.zzboo.zza(this.zzboq, this.zzbor);
                }
            }
        }
    }
}
