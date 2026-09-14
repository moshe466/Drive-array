package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzqi extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzboj;
    private final int zzbol;
    private final boolean zzbom;
    private boolean zzbpj;
    private boolean zzbpk;
    private final zzqf zzbpl;
    private final int zzbpm;
    private final int zzbpn;
    private final int zzbpo;
    private final int zzbpp;
    private final int zzbpq;
    private final int zzbpr;
    private final String zzbps;
    private final boolean zzbpt;
    private final boolean zzbpu;

    public zzqi() {
        this(new zzqf());
    }

    @VisibleForTesting
    private zzqi(zzqf zzqfVar) {
        this.started = false;
        this.zzbpj = false;
        this.zzbpk = false;
        this.zzbpl = zzqfVar;
        this.lock = new Object();
        this.zzboj = zzaaw.zzcta.get().intValue();
        this.zzbpn = zzaaw.zzcsx.get().intValue();
        this.zzbol = zzaaw.zzctb.get().intValue();
        this.zzbpo = zzaaw.zzcsz.get().intValue();
        this.zzbpp = ((Integer) zzve.zzoy().zzd(zzzn.zzchr)).intValue();
        this.zzbpq = ((Integer) zzve.zzoy().zzd(zzzn.zzchs)).intValue();
        this.zzbpr = ((Integer) zzve.zzoy().zzd(zzzn.zzcht)).intValue();
        this.zzbpm = zzaaw.zzctc.get().intValue();
        this.zzbps = (String) zzve.zzoy().zzd(zzzn.zzchv);
        this.zzbpt = ((Boolean) zzve.zzoy().zzd(zzzn.zzchw)).booleanValue();
        this.zzbom = ((Boolean) zzve.zzoy().zzd(zzzn.zzchx)).booleanValue();
        this.zzbpu = ((Boolean) zzve.zzoy().zzd(zzzn.zzchy)).booleanValue();
        setName("ContentFetchTask");
    }

    @VisibleForTesting
    private final zzqm zza(@Nullable View view, zzqc zzqcVar) {
        boolean z;
        if (view == null) {
            return new zzqm(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzqm(this, 0, 0);
            }
            zzqcVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzqm(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzbdi)) {
            WebView webView = (WebView) view;
            if (PlatformVersion.isAtLeastKitKat()) {
                zzqcVar.zzlx();
                webView.post(new zzqk(this, zzqcVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            return z ? new zzqm(this, 0, 1) : new zzqm(this, 0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzqm(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zzqm zza = zza(viewGroup.getChildAt(i3), zzqcVar);
            i += zza.a;
            i2 += zza.b;
        }
        return new zzqm(this, i, i2);
    }

    @VisibleForTesting
    private static boolean zzmc() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context context = com.google.android.gms.ads.internal.zzq.zzkt().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzme() {
        synchronized (this.lock) {
            this.zzbpj = true;
            boolean z = this.zzbpj;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzayu.zzea(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(View view) {
        try {
            zzqc zzqcVar = new zzqc(this.zzboj, this.zzbpn, this.zzbol, this.zzbpo, this.zzbpp, this.zzbpq, this.zzbpr, this.zzbom);
            Context context = com.google.android.gms.ads.internal.zzq.zzkt().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbps)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzve.zzoy().zzd(zzzn.zzchu), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbps)) {
                    return;
                }
            }
            zzqm zza = zza(view, zzqcVar);
            zzqcVar.zzlz();
            if (zza.a == 0 && zza.b == 0) {
                return;
            }
            if (zza.b == 0 && zzqcVar.a() == 0) {
                return;
            }
            if (zza.b == 0 && this.zzbpl.zza(zzqcVar)) {
                return;
            }
            this.zzbpl.zzc(zzqcVar);
        } catch (Exception e) {
            zzayu.zzc("Exception in fetchContentOnUIThread", e);
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(zzqc zzqcVar, WebView webView, String str, boolean z) {
        zzqcVar.zzlw();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzbpt || TextUtils.isEmpty(webView.getTitle())) {
                    zzqcVar.zza(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzqcVar.zza(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzqcVar.zzlr()) {
                this.zzbpl.zzb(zzqcVar);
            }
        } catch (JSONException unused) {
            zzayu.zzea("Json string may be malformed.");
        } catch (Throwable th) {
            zzayu.zzb("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0082 A[EXC_TOP_SPLITTER, LOOP:1: B:11:0x0082->B:18:0x0082, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
        L0:
            boolean r0 = zzmc()     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            if (r0 == 0) goto L5a
            com.google.android.gms.internal.ads.zzqe r0 = com.google.android.gms.ads.internal.zzq.zzkt()     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            android.app.Activity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            if (r0 != 0) goto L19
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzayu.zzea(r0)     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
        L15:
            r4.zzme()     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            goto L60
        L19:
            if (r0 == 0) goto L60
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch: java.lang.Exception -> L3d
            if (r2 == 0) goto L4c
            android.view.Window r2 = r0.getWindow()     // Catch: java.lang.Exception -> L3d
            android.view.View r2 = r2.getDecorView()     // Catch: java.lang.Exception -> L3d
            if (r2 == 0) goto L4c
            android.view.Window r0 = r0.getWindow()     // Catch: java.lang.Exception -> L3d
            android.view.View r0 = r0.getDecorView()     // Catch: java.lang.Exception -> L3d
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch: java.lang.Exception -> L3d
            r1 = r0
            goto L4c
        L3d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzave r2 = com.google.android.gms.ads.internal.zzq.zzku()     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzayu.zzea(r0)     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
        L4c:
            if (r1 == 0) goto L60
            if (r1 != 0) goto L51
            goto L60
        L51:
            com.google.android.gms.internal.ads.zzql r0 = new com.google.android.gms.internal.ads.zzql     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            r0.<init>(r4, r1)     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            r1.post(r0)     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            goto L60
        L5a:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzayu.zzea(r0)     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            goto L15
        L60:
            int r0 = r4.zzbpm     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L69 java.lang.InterruptedException -> L79
            goto L7f
        L69:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzayu.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzave r1 = com.google.android.gms.ads.internal.zzq.zzku()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L7f
        L79:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzayu.zzc(r1, r0)
        L7f:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
        L82:
            boolean r1 = r4.zzbpj     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L91
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzayu.zzea(r1)     // Catch: java.lang.InterruptedException -> L82 java.lang.Throwable -> L94
            java.lang.Object r1 = r4.lock     // Catch: java.lang.InterruptedException -> L82 java.lang.Throwable -> L94
            r1.wait()     // Catch: java.lang.InterruptedException -> L82 java.lang.Throwable -> L94
            goto L82
        L91:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
            goto L0
        L94:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
            goto L98
        L97:
            throw r1
        L98:
            goto L97
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqi.run():void");
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbpj = false;
            this.lock.notifyAll();
            zzayu.zzea("ContentFetchThread: wakeup");
        }
    }

    public final void zzmb() {
        synchronized (this.lock) {
            if (this.started) {
                zzayu.zzea("Content hash thread already started, quiting...");
            } else {
                this.started = true;
                start();
            }
        }
    }

    public final zzqc zzmd() {
        return this.zzbpl.zzo(this.zzbpu);
    }

    public final boolean zzmf() {
        return this.zzbpj;
    }
}
