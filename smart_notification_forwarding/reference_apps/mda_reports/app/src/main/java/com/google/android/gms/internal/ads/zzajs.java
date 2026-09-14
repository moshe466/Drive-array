package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzajs implements zzaia, zzajp {
    private final zzajq zzdak;
    private final HashSet<AbstractMap.SimpleEntry<String, zzafn<? super zzajq>>> zzdal = new HashSet<>();

    public zzajs(zzajq zzajqVar) {
        this.zzdak = zzajqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void zza(String str, zzafn<? super zzajq> zzafnVar) {
        this.zzdak.zza(str, zzafnVar);
        this.zzdal.add(new AbstractMap.SimpleEntry<>(str, zzafnVar));
    }

    @Override // com.google.android.gms.internal.ads.zzahs
    public final void zza(String str, Map map) {
        zzahz.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zza(String str, JSONObject jSONObject) {
        zzahz.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void zzb(String str, zzafn<? super zzajq> zzafnVar) {
        this.zzdak.zzb(str, zzafnVar);
        this.zzdal.remove(new AbstractMap.SimpleEntry(str, zzafnVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzahs
    public final void zzb(String str, JSONObject jSONObject) {
        zzahz.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzaip
    public final void zzcy(String str) {
        this.zzdak.zzcy(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zzj(String str, String str2) {
        zzahz.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzajp
    public final void zzsg() {
        Iterator<AbstractMap.SimpleEntry<String, zzafn<? super zzajq>>> it = this.zzdal.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzafn<? super zzajq>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzavs.zzed(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdak.zzb(next.getKey(), next.getValue());
        }
        this.zzdal.clear();
    }
}
