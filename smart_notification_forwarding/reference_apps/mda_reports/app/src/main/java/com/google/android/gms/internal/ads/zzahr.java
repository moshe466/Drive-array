package com.google.android.gms.internal.ads;

import android.content.Context;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzahr extends zzaie<zzajq> implements zzaia, zzaif {
    private final zzbfm zzcyo;
    private zzaii zzcyp;

    public zzahr(Context context, zzazb zzazbVar) {
        try {
            this.zzcyo = new zzbfm(context, new zzahx(this));
            this.zzcyo.setWillNotDraw(true);
            this.zzcyo.addJavascriptInterface(new zzahy(this), "GoogleJsInterface");
            com.google.android.gms.ads.internal.zzq.zzkq().zza(context, zzazbVar.zzbma, this.zzcyo.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbdv("Init failed.", th);
        }
    }

    public final /* synthetic */ void a(String str) {
        this.zzcyo.zzcy(str);
    }

    public final /* synthetic */ void b(String str) {
        this.zzcyo.loadUrl(str);
    }

    public final /* synthetic */ void c(String str) {
        this.zzcyo.loadData(str, "text/html", HttpRequest.CHARSET_UTF8);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void destroy() {
        this.zzcyo.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final boolean isDestroyed() {
        return this.zzcyo.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(zzaii zzaiiVar) {
        this.zzcyp = zzaiiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahs
    public final void zza(String str, Map map) {
        zzahz.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaip
    public final void zza(String str, JSONObject jSONObject) {
        zzahz.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzahs
    public final void zzb(String str, JSONObject jSONObject) {
        zzahz.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zzcv(String str) {
        zzcw(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zzcw(String str) {
        zzazd.zzdwi.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzahu
            private final zzahr zzcyq;
            private final String zzcyr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyq = this;
                this.zzcyr = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzcyq.c(this.zzcyr);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zzcx(String str) {
        zzazd.zzdwi.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzaht
            private final zzahr zzcyq;
            private final String zzcyr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyq = this;
                this.zzcyr = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzcyq.b(this.zzcyr);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaia, com.google.android.gms.internal.ads.zzaip
    public final void zzcy(String str) {
        zzazd.zzdwi.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzahw
            private final zzahr zzcyq;
            private final String zzcyr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcyq = this;
                this.zzcyr = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzcyq.a(this.zzcyr);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zzj(String str, String str2) {
        zzahz.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final zzajp zzrz() {
        return new zzajs(this);
    }
}
