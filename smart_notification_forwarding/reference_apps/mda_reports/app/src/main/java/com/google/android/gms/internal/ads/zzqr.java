package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class zzqr {
    private final int zzbqh;
    private final zzqo zzbqj = new zzqv();
    private final int zzbqg = 6;
    private final int zzbqi = 0;

    public zzqr(int i) {
        this.zzbqh = i;
    }

    @VisibleForTesting
    private final String zzbw(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzqt zzqtVar = new zzqt();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbqh, new zzqq(this));
        for (String str2 : split) {
            String[] zzd = zzqs.zzd(str2, false);
            if (zzd.length != 0) {
                zzqx.zza(zzd, this.zzbqh, this.zzbqg, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzqtVar.write(this.zzbqj.zzbv(((zzqw) it.next()).b));
            } catch (IOException e) {
                zzayu.zzc("Error while writing hash to byteStream", e);
            }
        }
        return zzqtVar.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            String str = arrayList.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return zzbw(sb.toString());
    }
}
