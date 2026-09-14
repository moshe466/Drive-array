package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzbwz {
    public static final zzbwz zzfmx = new zzbxb().zzajw();

    @Nullable
    private final zzadj zzfmq;

    @Nullable
    private final zzadi zzfmr;

    @Nullable
    private final zzadv zzfms;

    @Nullable
    private final zzadu zzfmt;

    @Nullable
    private final zzahh zzfmu;
    private final SimpleArrayMap<String, zzadp> zzfmv;
    private final SimpleArrayMap<String, zzado> zzfmw;

    private zzbwz(zzbxb zzbxbVar) {
        this.zzfmq = zzbxbVar.a;
        this.zzfmr = zzbxbVar.b;
        this.zzfms = zzbxbVar.c;
        this.zzfmv = new SimpleArrayMap<>(zzbxbVar.f);
        this.zzfmw = new SimpleArrayMap<>(zzbxbVar.g);
        this.zzfmt = zzbxbVar.d;
        this.zzfmu = zzbxbVar.e;
    }

    @Nullable
    public final zzadj zzajp() {
        return this.zzfmq;
    }

    @Nullable
    public final zzadi zzajq() {
        return this.zzfmr;
    }

    @Nullable
    public final zzadv zzajr() {
        return this.zzfms;
    }

    @Nullable
    public final zzadu zzajs() {
        return this.zzfmt;
    }

    @Nullable
    public final zzahh zzajt() {
        return this.zzfmu;
    }

    public final ArrayList<String> zzaju() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzfms != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzfmq != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzfmr != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzfmv.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzfmu != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzajv() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzfmv.size());
        for (int i = 0; i < this.zzfmv.size(); i++) {
            arrayList.add(this.zzfmv.keyAt(i));
        }
        return arrayList;
    }

    @Nullable
    public final zzadp zzfz(String str) {
        return this.zzfmv.get(str);
    }

    @Nullable
    public final zzado zzga(String str) {
        return this.zzfmw.get(str);
    }
}
