package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.AbstractC0272g0;
import androidx.fragment.app.C0259a;
import androidx.fragment.app.G;
import androidx.fragment.app.L;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzd extends G implements LifecycleFragment {
    private static final WeakHashMap zza = new WeakHashMap();
    private final zzc zzb = new zzc();

    public static zzd zza(L l3) {
        zzd zzdVar;
        AbstractC0272g0 supportFragmentManager = l3.getSupportFragmentManager();
        WeakHashMap weakHashMap = zza;
        WeakReference weakReference = (WeakReference) weakHashMap.get(l3);
        if (weakReference != null && (zzdVar = (zzd) weakReference.get()) != null) {
            return zzdVar;
        }
        try {
            zzd zzdVar2 = (zzd) supportFragmentManager.D("SLifecycleFragmentImpl");
            if (zzdVar2 == null || zzdVar2.isRemoving()) {
                zzdVar2 = new zzd();
                C0259a c0259a = new C0259a(supportFragmentManager);
                c0259a.c(0, zzdVar2, "SLifecycleFragmentImpl");
                c0259a.f(true, true);
            }
            weakHashMap.put(l3, new WeakReference(zzdVar2));
            return zzdVar2;
        } catch (ClassCastException e4) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        this.zzb.zzb(str, lifecycleCallback);
    }

    @Override // androidx.fragment.app.G
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.zzb.zzl(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (T) this.zzb.zza(str, cls);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.zzb.zzd();
    }

    @Override // androidx.fragment.app.G
    public final void onActivityResult(int i, int i3, Intent intent) {
        super.onActivityResult(i, i3, intent);
        this.zzb.zzh(i, i3, intent);
    }

    @Override // androidx.fragment.app.G
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzb.zze(bundle);
    }

    @Override // androidx.fragment.app.G
    public final void onDestroy() {
        super.onDestroy();
        this.zzb.zzk();
    }

    @Override // androidx.fragment.app.G
    public final void onResume() {
        super.onResume();
        this.zzb.zzg();
    }

    @Override // androidx.fragment.app.G
    public final void onSaveInstanceState(Bundle bundle) {
        this.zzb.zzi(bundle);
    }

    @Override // androidx.fragment.app.G
    public final void onStart() {
        super.onStart();
        this.zzb.zzf();
    }

    @Override // androidx.fragment.app.G
    public final void onStop() {
        super.onStop();
        this.zzb.zzj();
    }
}
