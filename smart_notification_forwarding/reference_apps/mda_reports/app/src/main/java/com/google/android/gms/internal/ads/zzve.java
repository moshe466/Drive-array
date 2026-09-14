package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryData;
import java.util.Random;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzve {
    private static zzve zzcdr = new zzve();
    private final zzayk zzcds;
    private final zzup zzcdt;
    private final String zzcdu;
    private final zzzi zzcdv;
    private final zzzk zzcdw;
    private final zzzj zzcdx;
    private final zzazb zzcdy;
    private final Random zzcdz;
    private final WeakHashMap<QueryData, String> zzcea;

    protected zzve() {
        this(new zzayk(), new zzup(new zzue(), new zzub(), new zzya(), new zzaej(), new zzars(), new zzasw(), new zzaor(), new zzaem()), new zzzi(), new zzzk(), new zzzj(), zzayk.zzxf(), new zzazb(0, 19649000, true), new Random(), new WeakHashMap());
    }

    private zzve(zzayk zzaykVar, zzup zzupVar, zzzi zzziVar, zzzk zzzkVar, zzzj zzzjVar, String str, zzazb zzazbVar, Random random, WeakHashMap<QueryData, String> weakHashMap) {
        this.zzcds = zzaykVar;
        this.zzcdt = zzupVar;
        this.zzcdv = zzziVar;
        this.zzcdw = zzzkVar;
        this.zzcdx = zzzjVar;
        this.zzcdu = str;
        this.zzcdy = zzazbVar;
        this.zzcdz = random;
        this.zzcea = weakHashMap;
    }

    public static zzayk zzou() {
        return zzcdr.zzcds;
    }

    public static zzup zzov() {
        return zzcdr.zzcdt;
    }

    public static zzzk zzow() {
        return zzcdr.zzcdw;
    }

    public static zzzi zzox() {
        return zzcdr.zzcdv;
    }

    public static zzzj zzoy() {
        return zzcdr.zzcdx;
    }

    public static String zzoz() {
        return zzcdr.zzcdu;
    }

    public static zzazb zzpa() {
        return zzcdr.zzcdy;
    }

    public static Random zzpb() {
        return zzcdr.zzcdz;
    }

    public static WeakHashMap<QueryData, String> zzpc() {
        return zzcdr.zzcea;
    }
}
