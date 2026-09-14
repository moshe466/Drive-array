package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzcpu implements zzcub<zzcpv> {
    private final zzczu zzfgl;
    private final zzdhd zzgej;
    private final View zzgek;
    private final Context zzup;

    public zzcpu(zzdhd zzdhdVar, Context context, zzczu zzczuVar, @Nullable ViewGroup viewGroup) {
        this.zzgej = zzdhdVar;
        this.zzup = context;
        this.zzfgl = zzczuVar;
        this.zzgek = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcpv a() {
        Context context = this.zzup;
        zzuj zzujVar = this.zzfgl.zzblm;
        ArrayList arrayList = new ArrayList();
        View view = this.zzgek;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcpv(context, zzujVar, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcpv> zzanc() {
        return this.zzgej.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcpx
            private final zzcpu zzgen;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgen = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgen.a();
            }
        });
    }
}
