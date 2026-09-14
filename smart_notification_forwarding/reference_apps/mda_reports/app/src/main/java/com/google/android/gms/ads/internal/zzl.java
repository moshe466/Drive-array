package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaak;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzaoy;
import com.google.android.gms.internal.ads.zzape;
import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzayk;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzazd;
import com.google.android.gms.internal.ads.zzdq;
import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzrg;
import com.google.android.gms.internal.ads.zzug;
import com.google.android.gms.internal.ads.zzuj;
import com.google.android.gms.internal.ads.zzuo;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzvg;
import com.google.android.gms.internal.ads.zzvh;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzvx;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxb;
import com.google.android.gms.internal.ads.zzxh;
import com.google.android.gms.internal.ads.zzyw;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzl extends zzvt {
    private final zzazb zzbll;
    private final zzuj zzblm;
    private final Future<zzdq> zzbln = zzazd.zzdwe.submit(new zzm(this));
    private final zzo zzblo;

    @Nullable
    private WebView zzblp;

    @Nullable
    private zzvh zzblq;

    @Nullable
    private zzdq zzblr;
    private AsyncTask<Void, Void, String> zzbls;
    private final Context zzup;

    public zzl(Context context, zzuj zzujVar, String str, zzazb zzazbVar) {
        this.zzup = context;
        this.zzbll = zzazbVar;
        this.zzblm = zzujVar;
        this.zzblp = new WebView(this.zzup);
        this.zzblo = new zzo(str);
        b(0);
        this.zzblp.setVerticalScrollBarEnabled(false);
        this.zzblp.getSettings().setJavaScriptEnabled(true);
        this.zzblp.setWebViewClient(new zzk(this));
        this.zzblp.setOnTouchListener(new zzn(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzbt(String str) {
        if (this.zzblr == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzblr.zza(parse, this.zzup, null, null);
        } catch (zzdt e) {
            zzayu.zzd("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbu(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.zzup.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final int a(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter(SettingsJsonConstants.ICON_HEIGHT_KEY);
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzve.zzou();
            return zzayk.zza(this.zzup, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void b(int i) {
        if (this.zzblp == null) {
            return;
        }
        this.zzblp.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String c() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzaar.zzcso.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzblo.getQuery());
        builder.appendQueryParameter("pubId", this.zzblo.zzkh());
        Map<String, String> zzki = this.zzblo.zzki();
        for (String str : zzki.keySet()) {
            builder.appendQueryParameter(str, zzki.get(str));
        }
        Uri build = builder.build();
        zzdq zzdqVar = this.zzblr;
        if (zzdqVar != null) {
            try {
                build = zzdqVar.zza(build, this.zzup);
            } catch (zzdt e) {
                zzayu.zzd("Unable to process ad data", e);
            }
        }
        String d = d();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(d).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(d);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String d() {
        String zzkg = this.zzblo.zzkg();
        if (TextUtils.isEmpty(zzkg)) {
            zzkg = "www.google.com";
        }
        String str = zzaar.zzcso.get();
        StringBuilder sb = new StringBuilder(String.valueOf(zzkg).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzkg);
        sb.append(str);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbls.cancel(true);
        this.zzbln.cancel(true);
        this.zzblp.destroy();
        this.zzblp = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    @Nullable
    public final String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    @Nullable
    public final zzxb getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean isLoading() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setUserId(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void showInterstitial() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaak zzaakVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaoy zzaoyVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzape zzapeVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaro zzaroVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzrg zzrgVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuj zzujVar) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuo zzuoVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvg zzvgVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvh zzvhVar) {
        this.zzblq = zzvhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvx zzvxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwc zzwcVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwi zzwiVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzxh zzxhVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzyw zzywVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean zza(zzug zzugVar) {
        Preconditions.checkNotNull(this.zzblp, "This Search Ad has already been torn down");
        this.zzblo.zza(zzugVar, this.zzbll);
        this.zzbls = new zzp(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzbr(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final IObjectWrapper zzjx() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzblp);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzjy() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzuj zzjz() {
        return this.zzblm;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    @Nullable
    public final String zzka() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    @Nullable
    public final zzxa zzkb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzwc zzkc() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzvh zzkd() {
        throw new IllegalStateException("getIAdListener not implemented");
    }
}
