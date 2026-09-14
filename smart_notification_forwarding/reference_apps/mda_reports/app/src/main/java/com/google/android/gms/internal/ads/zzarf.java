package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import androidx.annotation.GuardedBy;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzarf extends ContextWrapper {

    @GuardedBy("this")
    private Context zzdnq;

    @GuardedBy("this")
    private WeakReference<Activity> zzdnr;

    private zzarf(Context context) {
        super(context);
        this.zzdnr = new WeakReference<>(null);
    }

    public static Context zzaa(Context context) {
        return context instanceof zzarf ? ((zzarf) context).getBaseContext() : zzl(context);
    }

    private final synchronized Intent zzd(Intent intent) {
        if (this.zzdnq != null && intent.getComponent() != null && intent.getComponent().getPackageName().equals(this.zzdnq.getPackageName())) {
            Intent intent2 = (Intent) intent.clone();
            intent2.setClassName(super.getPackageName(), intent.getComponent().getClassName());
            return intent2;
        }
        return intent;
    }

    private final synchronized void zze(Intent intent) {
        Activity activity = this.zzdnr.get();
        if (activity == null) {
            intent.addFlags(268435456);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & (-268435457));
            activity.startActivity(intent2);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "");
            intent.addFlags(268435456);
            super.startActivity(intent);
        }
    }

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public static zzarf zzz(Context context) {
        return new zzarf(zzl(context));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized ApplicationInfo getApplicationInfo() {
        if (this.zzdnq != null) {
            return this.zzdnq.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageName() {
        if (this.zzdnq != null) {
            return this.zzdnq.getPackageName();
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageResourcePath() {
        if (this.zzdnq != null) {
            return this.zzdnq.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    public final synchronized void setAppPackageName(String str) {
        this.zzdnq = super.createPackageContext(str, 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized void startActivity(Intent intent) {
        zze(zzd(intent));
    }
}
