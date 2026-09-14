package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzais {
    private final Object lock;
    private int status;
    private final zzazb zzbll;
    private final String zzczl;
    private zzaxh<zzaif> zzczm;
    private zzaxh<zzaif> zzczn;

    @Nullable
    private zzajj zzczo;
    private final Context zzup;

    public zzais(Context context, zzazb zzazbVar, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzczl = str;
        this.zzup = context.getApplicationContext();
        this.zzbll = zzazbVar;
        this.zzczm = new zzajg();
        this.zzczn = new zzajg();
    }

    public zzais(Context context, zzazb zzazbVar, String str, zzaxh<zzaif> zzaxhVar, zzaxh<zzaif> zzaxhVar2) {
        this(context, zzazbVar, str);
        this.zzczm = zzaxhVar;
        this.zzczn = zzaxhVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzajj a(@Nullable final zzdq zzdqVar) {
        final zzajj zzajjVar = new zzajj(this.zzczn);
        zzazd.zzdwi.execute(new Runnable(this, zzdqVar, zzajjVar) { // from class: com.google.android.gms.internal.ads.zzair
            private final zzais zzczi;
            private final zzdq zzczj;
            private final zzajj zzczk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzczi = this;
                this.zzczj = zzdqVar;
                this.zzczk = zzajjVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzczi.a(this.zzczj, this.zzczk);
            }
        });
        zzajjVar.zza(new zzajb(this, zzajjVar), new zzaje(this, zzajjVar));
        return zzajjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzaif zzaifVar) {
        if (zzaifVar.isDestroyed()) {
            this.status = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzajj zzajjVar, zzaif zzaifVar) {
        synchronized (this.lock) {
            if (zzajjVar.getStatus() != -1 && zzajjVar.getStatus() != 1) {
                zzajjVar.reject();
                zzdhd zzdhdVar = zzazd.zzdwi;
                zzaifVar.getClass();
                zzdhdVar.execute(zzaiy.a(zzaifVar));
                zzavs.zzed("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdq zzdqVar, final zzajj zzajjVar) {
        try {
            Context context = this.zzup;
            zzazb zzazbVar = this.zzbll;
            final zzaif zzahrVar = zzabl.zzcuw.get().booleanValue() ? new zzahr(context, zzazbVar) : new zzaih(context, zzazbVar, zzdqVar, null);
            zzahrVar.zza(new zzaii(this, zzajjVar, zzahrVar) { // from class: com.google.android.gms.internal.ads.zzaiw
                private final zzais zzczi;
                private final zzajj zzczq;
                private final zzaif zzczr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzczi = this;
                    this.zzczq = zzajjVar;
                    this.zzczr = zzahrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzaii
                public final void zzsa() {
                    zzawb.zzdsr.postDelayed(new Runnable(this.zzczi, this.zzczq, this.zzczr) { // from class: com.google.android.gms.internal.ads.zzaiv
                        private final zzais zzczi;
                        private final zzajj zzczq;
                        private final zzaif zzczr;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzczi = r1;
                            this.zzczq = r2;
                            this.zzczr = r3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzczi.a(this.zzczq, this.zzczr);
                        }
                    }, zzajd.b);
                }
            });
            zzahrVar.zza("/jsLoaded", new zzaix(this, zzajjVar, zzahrVar));
            zzayd zzaydVar = new zzayd();
            zzaja zzajaVar = new zzaja(this, zzdqVar, zzahrVar, zzaydVar);
            zzaydVar.set(zzajaVar);
            zzahrVar.zza("/requestReload", zzajaVar);
            if (this.zzczl.endsWith(".js")) {
                zzahrVar.zzcv(this.zzczl);
            } else if (this.zzczl.startsWith("<html>")) {
                zzahrVar.zzcw(this.zzczl);
            } else {
                zzahrVar.zzcx(this.zzczl);
            }
            zzawb.zzdsr.postDelayed(new zzaiz(this, zzajjVar, zzahrVar), zzajd.a);
        } catch (Throwable th) {
            zzayu.zzc("Error creating webview.", th);
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzajjVar.reject();
        }
    }

    public final zzajf zzb(@Nullable zzdq zzdqVar) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzczo != null && this.status == 0) {
                    this.zzczo.zza(new zzazp(this) { // from class: com.google.android.gms.internal.ads.zzaiu
                        private final zzais zzczi;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzczi = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzazp
                        public final void zzh(Object obj) {
                            this.zzczi.a((zzaif) obj);
                        }
                    }, zzait.a);
                }
            }
            if (this.zzczo != null && this.zzczo.getStatus() != -1) {
                if (this.status == 0) {
                    return this.zzczo.zzsc();
                }
                if (this.status == 1) {
                    this.status = 2;
                    a((zzdq) null);
                    return this.zzczo.zzsc();
                }
                if (this.status == 2) {
                    return this.zzczo.zzsc();
                }
                return this.zzczo.zzsc();
            }
            this.status = 2;
            this.zzczo = a((zzdq) null);
            return this.zzczo.zzsc();
        }
    }
}
