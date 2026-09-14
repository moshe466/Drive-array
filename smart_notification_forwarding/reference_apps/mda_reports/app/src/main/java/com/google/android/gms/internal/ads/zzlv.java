package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;

/* loaded from: classes.dex */
final class zzlv {
    private final zzjf zzapm;
    private final zzjd[] zzbaw;
    private zzjd zzbax;

    public zzlv(zzjd[] zzjdVarArr, zzjf zzjfVar) {
        this.zzbaw = zzjdVarArr;
        this.zzapm = zzjfVar;
    }

    public final void release() {
        zzjd zzjdVar = this.zzbax;
        if (zzjdVar != null) {
            zzjdVar.release();
            this.zzbax = null;
        }
    }

    public final zzjd zza(zzjg zzjgVar, Uri uri) {
        zzjd zzjdVar = this.zzbax;
        if (zzjdVar != null) {
            return zzjdVar;
        }
        zzjd[] zzjdVarArr = this.zzbaw;
        int length = zzjdVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjd zzjdVar2 = zzjdVarArr[i];
            try {
            } catch (EOFException unused) {
            } catch (Throwable th) {
                zzjgVar.zzgi();
                throw th;
            }
            if (zzjdVar2.zza(zzjgVar)) {
                this.zzbax = zzjdVar2;
                zzjgVar.zzgi();
                break;
            }
            continue;
            zzjgVar.zzgi();
            i++;
        }
        zzjd zzjdVar3 = this.zzbax;
        if (zzjdVar3 != null) {
            zzjdVar3.zza(this.zzapm);
            return this.zzbax;
        }
        String zza = zzoq.zza(this.zzbaw);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zzmu(sb.toString(), uri);
    }
}
