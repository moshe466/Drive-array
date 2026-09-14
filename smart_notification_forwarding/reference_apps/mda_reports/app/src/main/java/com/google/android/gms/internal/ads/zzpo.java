package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
/* loaded from: classes.dex */
public final class zzpo implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbnk = ((Long) zzve.zzoy().zzd(zzzn.zzckh)).longValue();
    private final WindowManager zzbnl;

    @Nullable
    @VisibleForTesting
    private BroadcastReceiver zzbnm;
    private WeakReference<View> zzbnn;
    private zzpv zzbno;
    private final Rect zzbns;
    private final DisplayMetrics zzwe;
    private Application zzxa;
    private final Context zzyv;
    private final PowerManager zzyw;
    private final KeyguardManager zzyx;
    private WeakReference<ViewTreeObserver> zzyz;
    private zzaya zzbnp = new zzaya(zzbnk);
    private boolean zzbnq = false;
    private int zzzd = -1;
    private final HashSet<zzps> zzbnr = new HashSet<>();

    public zzpo(Context context, View view) {
        this.zzyv = context.getApplicationContext();
        this.zzbnl = (WindowManager) context.getSystemService("window");
        this.zzyw = (PowerManager) this.zzyv.getSystemService("power");
        this.zzyx = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzyv;
        if (context2 instanceof Application) {
            this.zzxa = (Application) context2;
            this.zzbno = new zzpv((Application) context2, this);
        }
        this.zzwe = context.getResources().getDisplayMetrics();
        this.zzbns = new Rect();
        this.zzbns.right = this.zzbnl.getDefaultDisplay().getWidth();
        this.zzbns.bottom = this.zzbnl.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbnn;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzbnn = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.zzq.zzks().isAttachedToWindow(view)) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbo(rect.left), zzbo(rect.top), zzbo(rect.right), zzbo(rect.bottom));
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbnn == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzbnn.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzzd = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbn(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        if (this.zzbnr.size() == 0 || (weakReference = this.zzbnn) == null) {
            return;
        }
        View view = weakReference.get();
        boolean z3 = i == 1;
        boolean z4 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e) {
                zzayu.zzc("Failure getting view location.", e);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        List<Rect> emptyList = (!((Boolean) zzve.zzoy().zzd(zzzn.zzckk)).booleanValue() || view == null) ? Collections.emptyList() : zzh(view);
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i2 = this.zzzd;
        if (i2 != -1) {
            windowVisibility = i2;
        }
        boolean z5 = !z4 && com.google.android.gms.ads.internal.zzq.zzkq().zza(view, this.zzyw, this.zzyx) && z && z2 && windowVisibility == 0;
        if (z3 && !this.zzbnp.tryAcquire() && z5 == this.zzbnq) {
            return;
        }
        if (z5 || this.zzbnq || i != 1) {
            zzpt zzptVar = new zzpt(com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime(), this.zzyw.isScreenOn(), view != null && com.google.android.gms.ads.internal.zzq.zzks().isAttachedToWindow(view), view != null ? view.getWindowVisibility() : 8, zza(this.zzbns), zza(rect), zza(rect2), z, zza(rect3), z2, zza(rect4), this.zzwe.density, z5, emptyList);
            Iterator<zzps> it = this.zzbnr.iterator();
            while (it.hasNext()) {
                it.next().zza(zzptVar);
            }
            this.zzbnq = z5;
        }
    }

    private final int zzbo(int i) {
        return (int) (i / this.zzwe.density);
    }

    private final void zzck() {
        zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzpr
            private final zzpo zzbnx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbnx = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzbnx.a();
            }
        });
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzyz = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbnm == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbnm = new zzpq(this);
            com.google.android.gms.ads.internal.zzq.zzll().zza(this.zzyv, this.zzbnm, intentFilter);
        }
        Application application = this.zzxa;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbno);
            } catch (Exception e) {
                zzayu.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzf(View view) {
        try {
            if (this.zzyz != null) {
                ViewTreeObserver viewTreeObserver = this.zzyz.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzyz = null;
            }
        } catch (Exception e) {
            zzayu.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzayu.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzbnm != null) {
            try {
                com.google.android.gms.ads.internal.zzq.zzll().zza(this.zzyv, this.zzbnm);
            } catch (IllegalStateException e3) {
                zzayu.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                com.google.android.gms.ads.internal.zzq.zzku().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbnm = null;
        }
        Application application = this.zzxa;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbno);
            } catch (Exception e5) {
                zzayu.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    private final List<Rect> zzh(View view) {
        boolean z;
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (Build.VERSION.SDK_INT >= 16) {
                    z = view2.isScrollContainer();
                } else {
                    if (!(view2 instanceof ScrollView) && !(view2 instanceof ListView)) {
                        z = false;
                    }
                    z = true;
                }
                if (z && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        zzbn(3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbn(3);
        zzck();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzbn(3);
        zzck();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbn(3);
        zzck();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbn(3);
        zzck();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbn(3);
        zzck();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbn(3);
        zzck();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzbn(3);
        zzck();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzbn(2);
        zzck();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzbn(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzzd = -1;
        zze(view);
        zzbn(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzzd = -1;
        zzbn(3);
        zzck();
        zzf(view);
    }

    public final void zza(zzps zzpsVar) {
        this.zzbnr.add(zzpsVar);
        zzbn(3);
    }

    public final void zzb(zzps zzpsVar) {
        this.zzbnr.remove(zzpsVar);
    }

    public final void zzen(long j) {
        this.zzbnp.zzfb(j);
    }

    public final void zzlp() {
        this.zzbnp.zzfb(zzbnk);
    }
}
