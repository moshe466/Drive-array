package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzqf {

    @VisibleForTesting
    private int zzbpb;
    private final Object lock = new Object();
    private List<zzqc> zzbpc = new LinkedList();

    public final boolean zza(zzqc zzqcVar) {
        synchronized (this.lock) {
            return this.zzbpc.contains(zzqcVar);
        }
    }

    public final boolean zzb(zzqc zzqcVar) {
        synchronized (this.lock) {
            Iterator<zzqc> it = this.zzbpc.iterator();
            while (it.hasNext()) {
                zzqc next = it.next();
                if (com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvu()) {
                    if (!com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzvw() && zzqcVar != next && next.zzlu().equals(zzqcVar.zzlu())) {
                        it.remove();
                        return true;
                    }
                } else if (zzqcVar != next && next.zzls().equals(zzqcVar.zzls())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzqc zzqcVar) {
        synchronized (this.lock) {
            if (this.zzbpc.size() >= 10) {
                int size = this.zzbpc.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                zzayu.zzea(sb.toString());
                this.zzbpc.remove(0);
            }
            int i = this.zzbpb;
            this.zzbpb = i + 1;
            zzqcVar.zzbp(i);
            zzqcVar.zzly();
            this.zzbpc.add(zzqcVar);
        }
    }

    @Nullable
    public final zzqc zzo(boolean z) {
        synchronized (this.lock) {
            zzqc zzqcVar = null;
            if (this.zzbpc.size() == 0) {
                zzayu.zzea("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzbpc.size() < 2) {
                zzqc zzqcVar2 = this.zzbpc.get(0);
                if (z) {
                    this.zzbpc.remove(0);
                } else {
                    zzqcVar2.zzlv();
                }
                return zzqcVar2;
            }
            int i2 = Integer.MIN_VALUE;
            int i3 = 0;
            for (zzqc zzqcVar3 : this.zzbpc) {
                int score = zzqcVar3.getScore();
                if (score > i2) {
                    i = i3;
                    zzqcVar = zzqcVar3;
                    i2 = score;
                }
                i3++;
            }
            this.zzbpc.remove(i);
            return zzqcVar;
        }
    }
}
