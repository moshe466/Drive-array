package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzbcn implements Releasable {
    protected Context a;
    protected String b;
    protected WeakReference<zzbaz> c;

    public zzbcn(zzbaz zzbazVar) {
        this.a = zzbazVar.getContext();
        this.b = com.google.android.gms.ads.internal.zzq.zzkq().zzr(this.a, zzbazVar.zzyr().zzbma);
        this.c = new WeakReference<>(zzbazVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzbaz zzbazVar = this.c.get();
        if (zzbazVar != null) {
            zzbazVar.zza(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String zzfk(String str) {
        char c;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                return "internal";
            case 6:
            case 7:
                return "io";
            case '\b':
            case '\t':
                return "network";
            case '\n':
            case 11:
                return "policy";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        zzve.zzou();
        return zzayk.zzes(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, String str2, int i) {
        zzayk.zzyu.post(new zzbcr(this, str, str2, i));
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    @VisibleForTesting
    public final void zza(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzayk.zzyu.post(new zzbco(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        zzayk.zzyu.post(new zzbcp(this, str, str2, j, j2, z, i, i2));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        zzayk.zzyu.post(new zzbct(this, str, str2, str3, str4));
    }

    @VisibleForTesting
    public final void zzb(String str, String str2, long j) {
        zzayk.zzyu.post(new zzbcq(this, str, str2, j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzcv(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzcw(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzcx(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzcy(int i) {
    }

    public boolean zze(String str, String[] strArr) {
        return zzfi(str);
    }

    public abstract boolean zzfi(String str);
}
