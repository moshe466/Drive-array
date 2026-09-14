package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: classes.dex */
public final class zzcqh implements zzcub<zzcqe> {
    private final zzave zzbmm;
    private final zzczu zzfgl;
    private final zzcub<zzcue> zzget;
    private final Context zzup;

    public zzcqh(zzcrk<zzcue> zzcrkVar, zzczu zzczuVar, Context context, zzave zzaveVar) {
        this.zzget = zzcrkVar;
        this.zzfgl = zzczuVar;
        this.zzup = context;
        this.zzbmm = zzaveVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcqe a(zzcue zzcueVar) {
        String str;
        boolean z;
        String str2;
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        DisplayMetrics displayMetrics;
        zzuj zzujVar = this.zzfgl.zzblm;
        zzuj[] zzujVarArr = zzujVar.zzccp;
        if (zzujVarArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzuj zzujVar2 : zzujVarArr) {
                if (!zzujVar2.zzccq && !z2) {
                    str = zzujVar2.zzabg;
                    z2 = true;
                }
                if (zzujVar2.zzccq && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzujVar.zzabg;
            z = zzujVar.zzccq;
        }
        Resources resources = this.zzup.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i = 0;
            i2 = 0;
        } else {
            float f2 = displayMetrics.density;
            int i5 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            str2 = this.zzbmm.zzvf().zzwg();
            i = i5;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        zzuj[] zzujVarArr2 = zzujVar.zzccp;
        if (zzujVarArr2 != null) {
            boolean z4 = false;
            for (zzuj zzujVar3 : zzujVarArr2) {
                if (zzujVar3.zzccq) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append((zzujVar3.width != -1 || f == 0.0f) ? zzujVar3.width : (int) (zzujVar3.widthPixels / f));
                    sb.append("x");
                    if (zzujVar3.height == -2 && f != 0.0f) {
                        i4 = (int) (zzujVar3.heightPixels / f);
                        sb.append(i4);
                    }
                    i4 = zzujVar3.height;
                    sb.append(i4);
                }
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzcqe(zzujVar, str, z, sb.toString(), f, i, i2, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcqe> zzanc() {
        return zzdgs.zzb(this.zzget.zzanc(), new zzded(this) { // from class: com.google.android.gms.internal.ads.zzcqg
            private final zzcqh zzges;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzges = this;
            }

            @Override // com.google.android.gms.internal.ads.zzded
            public final Object apply(Object obj) {
                return this.zzges.a((zzcue) obj);
            }
        }, zzazd.zzdwj);
    }
}
