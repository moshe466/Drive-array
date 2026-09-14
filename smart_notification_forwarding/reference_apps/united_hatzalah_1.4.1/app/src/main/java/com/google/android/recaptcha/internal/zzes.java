package com.google.android.recaptcha.internal;

import P2.E;
import P2.G;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Timer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import m3.b;
import p3.h;
import t2.C0715q;
import t2.x;

/* loaded from: classes.dex */
public final class zzes implements zzeo {
    private static Timer zza;
    private final Context zzb;
    private final zzet zzc;
    private final E zzd;
    private final zzei zze;

    public zzes(Context context, zzet zzetVar, E e4) {
        zzei zzeiVar;
        this.zzb = context;
        this.zzc = zzetVar;
        this.zzd = e4;
        zzei zzeiVar2 = null;
        try {
            zzeiVar = zzei.zzd;
            zzeiVar = zzeiVar == null ? new zzei(context, null) : zzeiVar;
            zzei.zzd = zzeiVar;
            zzeiVar2 = zzeiVar;
        } catch (Exception unused) {
        }
        this.zze = zzeiVar2;
        zzh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v4, types: [w2.d, java.lang.Object, M2.e] */
    public final void zzg() {
        C0715q c0715q;
        ArrayList arrayList;
        zzei zzeiVar;
        zztx zzk;
        int zzN;
        int i;
        int i3;
        zzei zzeiVar2 = this.zze;
        if (zzeiVar2 != null) {
            List zzd = zzeiVar2.zzd();
            j.e(zzd, "<this>");
            h.g(20, 20);
            int i4 = 0;
            if (zzd instanceof RandomAccess) {
                int size = zzd.size();
                int i5 = size / 20;
                if (size % 20 == 0) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                arrayList = new ArrayList(i5 + i3);
                for (int i6 = 0; i6 >= 0 && i6 < size; i6 += 20) {
                    int i7 = size - i6;
                    if (20 <= i7) {
                        i7 = 20;
                    }
                    ArrayList arrayList2 = new ArrayList(i7);
                    for (int i8 = 0; i8 < i7; i8++) {
                        arrayList2.add(zzd.get(i8 + i6));
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                ArrayList arrayList3 = new ArrayList();
                Iterator iterator = zzd.iterator();
                j.e(iterator, "iterator");
                if (!iterator.hasNext()) {
                    c0715q = C0715q.f6475a;
                } else {
                    x xVar = new x(20, 20, iterator, false, true, null);
                    ?? obj = new Object();
                    obj.f1415c = b.k(xVar, obj, obj);
                    c0715q = obj;
                }
                while (c0715q.hasNext()) {
                    arrayList3.add((List) c0715q.next());
                }
                arrayList = arrayList3;
            }
            int size2 = arrayList.size();
            while (i4 < size2) {
                Object obj2 = arrayList.get(i4);
                i4++;
                zzrd zzi = zzrf.zzi();
                ArrayList arrayList4 = new ArrayList();
                for (zzej zzejVar : (List) obj2) {
                    try {
                        zzk = zztx.zzk(zzkh.zzg().zzj(zzejVar.zzc()));
                        zzN = zzk.zzN();
                        i = zzN - 1;
                    } catch (Exception unused) {
                        zzei zzeiVar3 = this.zze;
                        if (zzeiVar3 != null) {
                            zzeiVar3.zzf(zzejVar);
                        }
                    }
                    if (zzN != 0) {
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                zzi.zzr(zzk.zzg());
                            }
                        } else {
                            zzi.zzq(zzk.zzf());
                        }
                        arrayList4.add(zzejVar);
                    } else {
                        throw null;
                    }
                }
                if (zzi.zzf() + zzi.zze() != 0) {
                    if (this.zzc.zza(((zzrf) zzi.zzk()).zzd()) && (zzeiVar = this.zze) != null) {
                        zzeiVar.zza(arrayList4);
                    }
                }
            }
        }
    }

    private final void zzh() {
        if (zza == null) {
            Timer timer = new Timer();
            zza = timer;
            timer.schedule(new zzep(this), 120000L, 120000L);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzeo
    public final void zza(zztx zztxVar) {
        G.r(this.zzd, null, new zzer(this, zztxVar, null), 3);
        zzh();
    }
}
