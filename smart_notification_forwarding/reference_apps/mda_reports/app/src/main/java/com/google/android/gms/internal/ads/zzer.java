package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzer implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zzyu = new Handler(Looper.getMainLooper());
    private final zzei zzuv;
    private Application zzxa;
    private final Context zzyv;

    @Nullable
    private final PowerManager zzyw;

    @Nullable
    private final KeyguardManager zzyx;
    private BroadcastReceiver zzyy;
    private WeakReference<ViewTreeObserver> zzyz;
    private WeakReference<View> zzza;
    private zzdx zzzb;
    private byte zzzc = -1;
    private int zzzd = -1;
    private long zzze = -3;

    public zzer(zzei zzeiVar, View view) {
        this.zzuv = zzeiVar;
        this.zzyv = zzeiVar.a;
        this.zzyw = (PowerManager) this.zzyv.getSystemService("power");
        this.zzyx = (KeyguardManager) this.zzyv.getSystemService("keyguard");
        Context context = this.zzyv;
        if (context instanceof Application) {
            this.zzxa = (Application) context;
            this.zzzb = new zzdx((Application) context, this);
        }
        a(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzza == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.zzza.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.zzzd = i;
    }

    private final void zzck() {
        zzyu.post(new zzeu(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
    
        if (r7 == false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzcm() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzza
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L15
            r9.zzze = r2
            r9.zzzc = r1
            return
        L15:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L1f
            r4 = 1
            goto L20
        L1f:
            r4 = 0
        L20:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L29
            r4 = r4 | 2
            byte r4 = (byte) r4
        L29:
            android.os.PowerManager r7 = r9.zzyw
            if (r7 == 0) goto L36
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L36
            r4 = r4 | 4
            byte r4 = (byte) r4
        L36:
            com.google.android.gms.internal.ads.zzei r7 = r9.zzuv
            boolean r7 = r7.zzce()
            if (r7 != 0) goto L6a
            android.app.KeyguardManager r7 = r9.zzyx
            if (r7 == 0) goto L69
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L69
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzep.zzc(r0)
            if (r7 == 0) goto L65
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L56
            r7 = 0
            goto L5a
        L56:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L5a:
            if (r7 == 0) goto L65
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L65
            r7 = 1
            goto L66
        L65:
            r7 = 0
        L66:
            if (r7 == 0) goto L69
            goto L6a
        L69:
            r5 = 0
        L6a:
            if (r5 != 0) goto L6f
            r4 = r4 | 8
            byte r4 = (byte) r4
        L6f:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L7d
            r4 = r4 | 16
            byte r4 = (byte) r4
        L7d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L8b
            r4 = r4 | 32
            byte r4 = (byte) r4
        L8b:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.zzzd
            if (r5 == r1) goto L94
            r0 = r5
        L94:
            if (r0 == 0) goto L99
            r0 = r4 | 64
            byte r4 = (byte) r0
        L99:
            byte r0 = r9.zzzc
            if (r0 == r4) goto Lad
            r9.zzzc = r4
            byte r0 = r9.zzzc
            if (r0 != 0) goto La8
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto Lab
        La8:
            long r0 = (long) r0
            long r0 = r2 - r0
        Lab:
            r9.zzze = r0
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzer.zzcm():void");
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzyz = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzyy == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzyy = new zzet(this);
            this.zzyv.registerReceiver(this.zzyy, intentFilter);
        }
        Application application = this.zzxa;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzzb);
            } catch (Exception unused) {
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
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.zzyy;
        if (broadcastReceiver != null) {
            try {
                this.zzyv.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.zzyy = null;
        }
        Application application = this.zzxa;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzzb);
            } catch (Exception unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view) {
        long j;
        WeakReference<View> weakReference = this.zzza;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzza = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.zzze = j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzcm();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzcm();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzcm();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzcm();
        zzck();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcm();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzcm();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzcm();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzcm();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzcm();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzzd = -1;
        zze(view);
        zzcm();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzzd = -1;
        zzcm();
        zzck();
        zzf(view);
    }

    public final long zzcl() {
        if (this.zzze <= -2 && this.zzza.get() == null) {
            this.zzze = -3L;
        }
        return this.zzze;
    }
}
