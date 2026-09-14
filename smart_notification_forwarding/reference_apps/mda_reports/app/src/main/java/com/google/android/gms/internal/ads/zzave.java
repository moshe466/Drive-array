package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzave {
    private zzazb zzbll;
    private zzpp zzdqh;

    @GuardedBy("grantedPermissionLock")
    private zzdhe<ArrayList<String>> zzdqo;
    private Context zzup;
    private final Object lock = new Object();
    private final zzavx zzdqi = new zzavx();
    private final zzavp zzdpz = new zzavp(zzve.zzoz(), this.zzdqi);
    private boolean zzxx = false;

    @Nullable
    private zzzu zzdqj = null;

    @Nullable
    private Boolean zzdqk = null;
    private final AtomicInteger zzdql = new AtomicInteger(0);
    private final zzavj zzdqm = new zzavj(null);
    private final Object zzdqn = new Object();

    @TargetApi(16)
    private static ArrayList<String> zzal(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList a() {
        return zzal(zzarf.zzaa(this.zzup));
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.zzup;
    }

    @Nullable
    public final Resources getResources() {
        if (this.zzbll.zzdwb) {
            return this.zzup.getResources();
        }
        try {
            zzayx.zzbp(this.zzup).getResources();
            return null;
        } catch (zzayz e) {
            zzayu.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzdqk = bool;
        }
    }

    public final void zza(Throwable th, String str) {
        zzapn.zzc(this.zzup, this.zzbll).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzapn.zzc(this.zzup, this.zzbll).zza(th, str, zzabi.zzcup.get().floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context, zzazb zzazbVar) {
        synchronized (this.lock) {
            if (!this.zzxx) {
                this.zzup = context.getApplicationContext();
                this.zzbll = zzazbVar;
                com.google.android.gms.ads.internal.zzq.zzkt().zza(this.zzdpz);
                zzzu zzzuVar = null;
                this.zzdqi.zza(this.zzup, (String) null, true);
                zzapn.zzc(this.zzup, this.zzbll);
                this.zzdqh = new zzpp(context.getApplicationContext(), this.zzbll);
                com.google.android.gms.ads.internal.zzq.zzkz();
                if (zzaav.zzcsw.get().booleanValue()) {
                    zzzuVar = new zzzu();
                } else {
                    zzavs.zzed("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                }
                this.zzdqj = zzzuVar;
                if (this.zzdqj != null) {
                    zzazh.zza(new zzavg(this).zzvr(), "AppState.registerCsiReporter");
                }
                this.zzxx = true;
                zzvg();
            }
        }
        com.google.android.gms.ads.internal.zzq.zzkq().zzr(context, zzazbVar.zzbma);
    }

    @Nullable
    public final zzzu zzuz() {
        zzzu zzzuVar;
        synchronized (this.lock) {
            zzzuVar = this.zzdqj;
        }
        return zzzuVar;
    }

    public final Boolean zzva() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzdqk;
        }
        return bool;
    }

    public final void zzvb() {
        this.zzdqm.zzvb();
    }

    public final void zzvc() {
        this.zzdql.incrementAndGet();
    }

    public final void zzvd() {
        this.zzdql.decrementAndGet();
    }

    public final int zzve() {
        return this.zzdql.get();
    }

    public final zzavu zzvf() {
        zzavx zzavxVar;
        synchronized (this.lock) {
            zzavxVar = this.zzdqi;
        }
        return zzavxVar;
    }

    public final zzdhe<ArrayList<String>> zzvg() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zzup != null) {
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzclf)).booleanValue()) {
                synchronized (this.zzdqn) {
                    if (this.zzdqo != null) {
                        return this.zzdqo;
                    }
                    zzdhe<ArrayList<String>> submit = zzazd.zzdwe.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzavh
                        private final zzave zzdqx;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdqx = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzdqx.a();
                        }
                    });
                    this.zzdqo = submit;
                    return submit;
                }
            }
        }
        return zzdgs.zzaj(new ArrayList());
    }

    public final zzavp zzvh() {
        return this.zzdpz;
    }
}
