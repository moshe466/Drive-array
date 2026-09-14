package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzceq {
    private final Executor executor;
    private final zzazb zzbli;
    private final Context zzcgd;
    private final Executor zzfci;
    private final ScheduledExecutorService zzfdi;
    private final WeakReference<Context> zzftp;
    private final zzcka zzftq;
    private final zzcea zzftr;
    private boolean zzftl = false;

    @GuardedBy("this")
    private boolean zzftm = false;
    private final zzazl<Boolean> zzfto = new zzazl<>();
    private Map<String, zzagn> zzfts = new ConcurrentHashMap();
    private final long zzftn = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();

    public zzceq(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzcka zzckaVar, ScheduledExecutorService scheduledExecutorService, zzcea zzceaVar, zzazb zzazbVar) {
        this.zzftq = zzckaVar;
        this.zzcgd = context;
        this.zzftp = weakReference;
        this.executor = executor2;
        this.zzfdi = scheduledExecutorService;
        this.zzfci = executor;
        this.zzftr = zzceaVar;
        this.zzbli = zzazbVar;
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzceq zzceqVar, boolean z) {
        zzceqVar.zzftm = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzfts.put(str, new zzagn(str, z, i, str2));
    }

    private final synchronized zzdhe<String> zzaln() {
        String zzvl = com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzwa().zzvl();
        if (!TextUtils.isEmpty(zzvl)) {
            return zzdgs.zzaj(zzvl);
        }
        final zzazl zzazlVar = new zzazl();
        com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzb(new Runnable(this, zzazlVar) { // from class: com.google.android.gms.internal.ads.zzcer
            private final zzceq zzftj;
            private final zzazl zzftt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzftj = this;
                this.zzftt = zzazlVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzftj.a(this.zzftt);
            }
        });
        return zzazlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzgf(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                final String next = keys.next();
                final Object obj = new Object();
                final zzazl zzazlVar = new zzazl();
                zzdhe zza = zzdgs.zza(zzazlVar, ((Long) zzve.zzoy().zzd(zzzn.zzcks)).longValue(), TimeUnit.SECONDS, this.zzfdi);
                this.zzftr.zzgd(next);
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
                Iterator<String> it = keys;
                zza.addListener(new Runnable(this, obj, zzazlVar, next, elapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzcet
                    private final Object zzdbh;
                    private final String zzfru;
                    private final zzceq zzftj;
                    private final zzazl zzftu;
                    private final long zzftv;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzftj = this;
                        this.zzdbh = obj;
                        this.zzftu = zzazlVar;
                        this.zzfru = next;
                        this.zzftv = elapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzftj.a(this.zzdbh, this.zzftu, this.zzfru, this.zzftv);
                    }
                }, this.executor);
                arrayList.add(zza);
                final zzcez zzcezVar = new zzcez(this, obj, next, elapsedRealtime, zzazlVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzagx(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    try {
                        final zzdac zze = this.zzftq.zze(next, new JSONObject());
                        this.zzfci.execute(new Runnable(this, zze, zzcezVar, arrayList2, next) { // from class: com.google.android.gms.internal.ads.zzcev
                            private final String zzefb;
                            private final zzceq zzftj;
                            private final zzdac zzftw;
                            private final zzagp zzftx;
                            private final List zzfty;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzftj = this;
                                this.zzftw = zze;
                                this.zzftx = zzcezVar;
                                this.zzfty = arrayList2;
                                this.zzefb = next;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzftj.a(this.zzftw, this.zzftx, this.zzfty, this.zzefb);
                            }
                        });
                    } catch (zzdab unused2) {
                        zzcezVar.onInitializationFailed("Failed to create Adapter.");
                    }
                } catch (RemoteException e) {
                    zzayu.zzc("", e);
                }
                keys = it;
            }
            zzdgs.zzh(arrayList).zza(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcew
                private final zzceq zzftj;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzftj = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzftj.a();
                }
            }, this.executor);
        } catch (JSONException e2) {
            zzavs.zza("Malformed CLD response", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object a() {
        this.zzfto.set(true);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzagu zzaguVar) {
        try {
            zzaguVar.zzc(zzalm());
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(final zzazl zzazlVar) {
        this.executor.execute(new Runnable(this, zzazlVar) { // from class: com.google.android.gms.internal.ads.zzcey
            private final zzceq zzftj;
            private final zzazl zzftt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzftj = this;
                this.zzftt = zzazlVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzazl zzazlVar2 = this.zzftt;
                String zzvl = com.google.android.gms.ads.internal.zzq.zzku().zzvf().zzwa().zzvl();
                if (TextUtils.isEmpty(zzvl)) {
                    zzazlVar2.setException(new Exception());
                } else {
                    zzazlVar2.set(zzvl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdac zzdacVar, zzagp zzagpVar, List list, String str) {
        try {
            try {
                Context context = this.zzftp.get();
                if (context == null) {
                    context = this.zzcgd;
                }
                zzdacVar.zza(context, zzagpVar, (List<zzagx>) list);
            } catch (zzdab unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
                sb.append("Failed to initialize adapter. ");
                sb.append(str);
                sb.append(" does not implement the initialize() method.");
                zzagpVar.onInitializationFailed(sb.toString());
            }
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, zzazl zzazlVar, String str, long j) {
        synchronized (obj) {
            if (!zzazlVar.isDone()) {
                zza(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - j));
                this.zzftr.zzq(str, "timeout");
                zzazlVar.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        synchronized (this) {
            if (this.zzftm) {
                return;
            }
            zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - this.zzftn));
            this.zzfto.setException(new Exception());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.zzftr.zzalj();
    }

    public final void zzall() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzckq)).booleanValue() && !zzabe.zzctz.get().booleanValue()) {
            if (this.zzbli.zzdwa >= ((Integer) zzve.zzoy().zzd(zzzn.zzckr)).intValue()) {
                if (this.zzftl) {
                    return;
                }
                synchronized (this) {
                    if (this.zzftl) {
                        return;
                    }
                    this.zzftr.zzali();
                    this.zzfto.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzces
                        private final zzceq zzftj;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzftj = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzftj.c();
                        }
                    }, this.executor);
                    this.zzftl = true;
                    zzdhe<String> zzaln = zzaln();
                    this.zzfdi.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzceu
                        private final zzceq zzftj;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzftj = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzftj.b();
                        }
                    }, ((Long) zzve.zzoy().zzd(zzzn.zzckt)).longValue(), TimeUnit.SECONDS);
                    zzdgs.zza(zzaln, new zzcex(this), this.executor);
                    return;
                }
            }
        }
        zza("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zzfto.set(false);
    }

    public final List<zzagn> zzalm() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzfts.keySet()) {
            zzagn zzagnVar = this.zzfts.get(str);
            arrayList.add(new zzagn(str, zzagnVar.zzcyd, zzagnVar.zzcye, zzagnVar.description));
        }
        return arrayList;
    }

    public final void zzb(final zzagu zzaguVar) {
        this.zzfto.addListener(new Runnable(this, zzaguVar) { // from class: com.google.android.gms.internal.ads.zzcep
            private final zzceq zzftj;
            private final zzagu zzftk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzftj = this;
                this.zzftk = zzaguVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzftj.a(this.zzftk);
            }
        }, this.zzfci);
    }
}
