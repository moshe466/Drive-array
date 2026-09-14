package x7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private AudioManager f15516b;

    /* renamed from: c, reason: collision with root package name */
    private Context f15517c;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f15520f;

    /* renamed from: a, reason: collision with root package name */
    private ic.b f15515a = ic.c.i(e.class.getSimpleName());

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f15518d = new b();

    /* renamed from: e, reason: collision with root package name */
    private final Object f15519e = new Object();

    /* renamed from: g, reason: collision with root package name */
    private boolean f15521g = false;

    /* loaded from: classes.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            e.this.f15515a.e("Audio SCO state: " + intExtra);
            if (intExtra != 1) {
                return;
            }
            e.this.f(context);
        }
    }

    /* loaded from: classes.dex */
    private class c extends TimerTask {
        private c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.g(eVar.f15517c, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, AtomicInteger atomicInteger) {
        this.f15517c = context;
        this.f15516b = (AudioManager) context.getSystemService("audio");
        this.f15520f = atomicInteger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        g(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, boolean z10) {
        synchronized (this.f15519e) {
            if (this.f15521g) {
                if (context != null) {
                    try {
                        context.unregisterReceiver(this.f15518d);
                    } catch (Exception unused) {
                    }
                }
                if (z10) {
                    e();
                }
                this.f15521g = false;
                this.f15519e.notify();
            }
        }
    }

    private void i() {
        synchronized (this.f15519e) {
            this.f15521g = true;
            try {
                this.f15519e.wait();
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f15520f.get() <= 0 || this.f15520f.decrementAndGet() != 0) {
            return;
        }
        this.f15516b.stopBluetoothSco();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Context context = this.f15517c;
        if (context == null) {
            return;
        }
        context.registerReceiver(this.f15518d, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        if (!this.f15516b.isBluetoothScoOn() && this.f15520f.getAndIncrement() == 0) {
            try {
                this.f15516b.startBluetoothSco();
            } catch (Exception unused) {
                this.f15520f.decrementAndGet();
            }
        }
        new Timer().schedule(new c(), 2000L);
        i();
    }
}
