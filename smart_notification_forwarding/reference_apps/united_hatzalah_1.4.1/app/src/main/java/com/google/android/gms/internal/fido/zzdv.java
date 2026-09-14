package com.google.android.gms.internal.fido;

import F0.AbstractC0008a;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdv {
    private final Deque zza = new ArrayDeque(16);

    private zzdv(boolean z3) {
    }

    public static zzdv zza() {
        return new zzdv(false);
    }

    private final long zzh() {
        if (this.zza.isEmpty()) {
            return 0L;
        }
        return ((Long) this.zza.peek()).longValue();
    }

    private final void zzi(long j2) {
        this.zza.pop();
        this.zza.push(Long.valueOf(j2));
    }

    public final void zzb() {
        if (this.zza.isEmpty()) {
            return;
        }
        throw new IOException("data item not completed, stackSize: " + this.zza.size() + " scope: " + zzh());
    }

    public final void zzc() {
        long zzh = zzh();
        if (zzh < 0) {
            if (zzh != -5) {
                this.zza.pop();
                return;
            }
            throw new IOException("expected a value for dangling key in indefinite-length map");
        }
        throw new IOException(AbstractC0008a.l("expected indefinite length scope but found ", zzh));
    }

    public final void zzd() {
        long zzh = zzh();
        if (zzh != -1) {
            if (zzh != -2) {
                return;
            } else {
                zzh = -2;
            }
        }
        throw new IOException(AbstractC0008a.l("expected non-string scope but found ", zzh));
    }

    public final void zze(long j2) {
        long zzh = zzh();
        if (zzh != j2) {
            if (zzh != -1) {
                if (zzh == -2) {
                    zzh = -2;
                } else {
                    return;
                }
            }
            StringBuilder x3 = AbstractC0008a.x("expected non-string scope or scope ", " but found ", j2);
            x3.append(zzh);
            throw new IOException(x3.toString());
        }
    }

    public final void zzf() {
        long zzh = zzh();
        if (zzh == 1) {
            this.zza.pop();
            return;
        }
        if (zzh > 1) {
            zzi(zzh - 1);
        } else if (zzh == -4) {
            zzi(-5L);
        } else if (zzh == -5) {
            zzi(-4L);
        }
    }

    public final void zzg(long j2) {
        this.zza.push(Long.valueOf(j2));
    }
}
