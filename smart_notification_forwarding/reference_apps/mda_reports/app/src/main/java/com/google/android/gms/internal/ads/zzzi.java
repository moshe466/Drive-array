package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzzi {
    private final Collection<zzzc<?>> zzcfx = new ArrayList();
    private final Collection<zzzc<String>> zzcfy = new ArrayList();
    private final Collection<zzzc<String>> zzcfz = new ArrayList();

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzzc<?> zzzcVar : this.zzcfx) {
            if (zzzcVar.getSource() == 1) {
                zzzcVar.zza(editor, zzzcVar.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzayu.zzex("Flag Json is null.");
        }
    }

    public final void zza(zzzc zzzcVar) {
        this.zzcfx.add(zzzcVar);
    }

    public final void zzb(zzzc<String> zzzcVar) {
        this.zzcfy.add(zzzcVar);
    }

    public final void zzc(zzzc<String> zzzcVar) {
        this.zzcfz.add(zzzcVar);
    }

    public final List<String> zzqg() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzzc<String>> it = this.zzcfy.iterator();
        while (it.hasNext()) {
            String str = (String) zzve.zzoy().zzd(it.next());
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzzs.a());
        return arrayList;
    }

    public final List<String> zzqh() {
        List<String> zzqg = zzqg();
        Iterator<zzzc<String>> it = this.zzcfz.iterator();
        while (it.hasNext()) {
            String str = (String) zzve.zzoy().zzd(it.next());
            if (!TextUtils.isEmpty(str)) {
                zzqg.add(str);
            }
        }
        zzqg.addAll(zzzs.b());
        return zzqg;
    }
}
