package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzaie<ReferenceT> implements zzaib {

    @GuardedBy("this")
    private final Map<String, CopyOnWriteArrayList<zzafn<? super ReferenceT>>> zzcyx = new HashMap();
    private ReferenceT zzcyy;

    private final synchronized void zzb(final String str, final Map<String, String> map) {
        if (zzayu.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzavs.zzed(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzavs.zzed(sb.toString());
            }
        }
        CopyOnWriteArrayList<zzafn<? super ReferenceT>> copyOnWriteArrayList = this.zzcyx.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcre)).booleanValue() && com.google.android.gms.ads.internal.zzq.zzku().zzuz() != null) {
                zzazd.zzdwe.execute(new Runnable(str) { // from class: com.google.android.gms.internal.ads.zzaig
                    private final String zzcyz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzcyz = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.gms.ads.internal.zzq.zzku().zzuz().zzcr(this.zzcyz.substring(1));
                    }
                });
                return;
            }
            return;
        }
        Iterator<zzafn<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            final zzafn<? super ReferenceT> next = it.next();
            zzazd.zzdwi.execute(new Runnable(this, next, map) { // from class: com.google.android.gms.internal.ads.zzaid
                private final zzaie zzcyu;
                private final zzafn zzcyv;
                private final Map zzcyw;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcyu = this;
                    this.zzcyv = next;
                    this.zzcyw = map;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzcyu.a(this.zzcyv, this.zzcyw);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzafn zzafnVar, Map map) {
        zzafnVar.zza(this.zzcyy, map);
    }

    public final synchronized void reset() {
        this.zzcyx.clear();
    }

    public final synchronized void zza(String str, Predicate<zzafn<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<zzafn<? super ReferenceT>> copyOnWriteArrayList = this.zzcyx.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzafn<? super ReferenceT> zzafnVar = (zzafn) it.next();
            if (predicate.apply(zzafnVar)) {
                arrayList.add(zzafnVar);
            }
        }
        copyOnWriteArrayList.removeAll(arrayList);
    }

    public final synchronized void zza(String str, zzafn<? super ReferenceT> zzafnVar) {
        CopyOnWriteArrayList<zzafn<? super ReferenceT>> copyOnWriteArrayList = this.zzcyx.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.zzcyx.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzafnVar);
    }

    public final synchronized void zzb(String str, zzafn<? super ReferenceT> zzafnVar) {
        CopyOnWriteArrayList<zzafn<? super ReferenceT>> copyOnWriteArrayList = this.zzcyx.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(zzafnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaib
    public final boolean zzdc(@Nullable String str) {
        return str != null && zzg(Uri.parse(str));
    }

    public final void zzg(ReferenceT referencet) {
        this.zzcyy = referencet;
    }

    public final boolean zzg(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        zzh(uri);
        return true;
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        com.google.android.gms.ads.internal.zzq.zzkq();
        zzb(path, zzawb.zzi(uri));
    }
}
