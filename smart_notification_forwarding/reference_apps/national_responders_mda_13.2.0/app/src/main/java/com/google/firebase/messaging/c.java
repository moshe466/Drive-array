package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.k;
import com.google.firebase.messaging.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f7415a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f7416b;

    /* renamed from: c, reason: collision with root package name */
    private final v f7417c;

    public c(Context context, v vVar, Executor executor) {
        this.f7415a = executor;
        this.f7416b = context;
        this.f7417c = vVar;
    }

    private boolean b() {
        if (((KeyguardManager) this.f7416b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!g2.l.f()) {
            SystemClock.sleep(10L);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f7416b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    if (next.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void c(a.C0093a c0093a) {
        ((NotificationManager) this.f7416b.getSystemService("notification")).notify(c0093a.f7402b, c0093a.f7403c, c0093a.f7401a.b());
    }

    private s d() {
        s f10 = s.f(this.f7417c.p("gcm.n.image"));
        if (f10 != null) {
            f10.j(this.f7415a);
        }
        return f10;
    }

    private void e(k.e eVar, s sVar) {
        if (sVar == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) z2.o.b(sVar.g(), 5L, TimeUnit.SECONDS);
            eVar.o(bitmap);
            eVar.y(new k.b().i(bitmap).h(null));
        } catch (InterruptedException unused) {
            sVar.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e10) {
            String valueOf = String.valueOf(e10.getCause());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 26);
            sb2.append("Failed to download image: ");
            sb2.append(valueOf);
        } catch (TimeoutException unused2) {
            sVar.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.f7417c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        s d10 = d();
        a.C0093a d11 = a.d(this.f7416b, this.f7417c);
        e(d11.f7401a, d10);
        c(d11);
        return true;
    }
}
