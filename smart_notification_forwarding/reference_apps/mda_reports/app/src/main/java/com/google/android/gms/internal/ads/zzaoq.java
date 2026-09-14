package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzaoq {
    private static final Object lock = new Object();

    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean zzdgk = false;

    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean zzxx = false;

    @VisibleForTesting
    private zzddf zzdgl;

    @VisibleForTesting
    private final void zzq(Context context) {
        synchronized (lock) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue() && !zzdgk) {
                try {
                    zzdgk = true;
                    this.zzdgl = (zzddf) zzayx.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzaop.a);
                } catch (zzayz e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Nullable
    public final String getVersion(Context context) {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue()) {
            return null;
        }
        try {
            zzq(context);
            String valueOf = String.valueOf(this.zzdgl.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                try {
                    if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue() && zzxx) {
                        try {
                            return this.zzdgl.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzayu.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue() && zzxx) {
                try {
                    this.zzdgl.zzb(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue() && zzxx) {
                try {
                    this.zzdgl.zzab(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue() && zzxx) {
                try {
                    this.zzdgl.zzac(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue() && zzxx) {
                try {
                    this.zzdgl.zzc(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzp(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcoc)).booleanValue()) {
                return false;
            }
            if (zzxx) {
                return true;
            }
            try {
                zzq(context);
                boolean zzas = this.zzdgl.zzas(ObjectWrapper.wrap(context));
                zzxx = zzas;
                return zzas;
            } catch (RemoteException e) {
                e = e;
                zzayu.zze("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzayu.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }
}
