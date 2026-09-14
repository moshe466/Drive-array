package x7;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.n;
import com.google.gson.p;
import com.googlecode.androidilbc.Codec;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import o7.l;
import u7.m;

/* loaded from: classes.dex */
public class a extends w7.a {
    private static final AtomicInteger Q = new AtomicInteger(0);
    private byte[] A;
    private byte[] B;
    private int C;
    private int D;
    private int E;
    private byte[] F;
    private AudioRecord G;
    private x7.g H;
    private WeakReference<Context> I;
    private BroadcastReceiver J;
    private BroadcastReceiver K;
    private BroadcastReceiver L;
    private BroadcastReceiver M;
    private BroadcastReceiver N;
    private h O;
    private x7.b P;

    /* renamed from: w, reason: collision with root package name */
    String f15496w;

    /* renamed from: x, reason: collision with root package name */
    private ic.b f15497x;

    /* renamed from: y, reason: collision with root package name */
    private int f15498y;

    /* renamed from: z, reason: collision with root package name */
    private byte[] f15499z;

    /* renamed from: x7.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0330a extends BroadcastReceiver {
        C0330a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            v7.b.c(a.this.f15496w, "Fired fcmWakeReceiver - do sdk.reconnect()");
            a.this.M();
        }
    }

    /* loaded from: classes.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            v7.b.c(a.this.f15496w, "Fired fcmNewToken - do sdk.register()");
            a.this.N();
        }
    }

    /* loaded from: classes.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            v7.b.c(a.this.f15496w, "Fired kaAlarmFired - do sdk.sustainConnectivity()");
            a.this.c0();
        }
    }

    /* loaded from: classes.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            v7.b.c(a.this.f15496w, "Fired idleChannelsAlarmFired - do sdk.leaveIdleChannels()");
            a.this.F();
        }
    }

    /* loaded from: classes.dex */
    class e extends BroadcastReceiver {

        /* renamed from: x7.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0331a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ o7.j f15505f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ n f15506g;

            RunnableC0331a(e eVar, o7.j jVar, n nVar) {
                this.f15505f = jVar;
                this.f15506g = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f15505f.a(this.f15506g);
                } catch (Exception e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[DIPIO][PTT] ");
                    sb2.append(e10.getMessage());
                }
            }
        }

        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            n nVar = new n();
            for (String str : intent.getExtras().keySet()) {
                if (str.equals("members")) {
                    nVar.x(str, new p().a(intent.getStringExtra(str)).f());
                } else {
                    nVar.z(str, intent.getStringExtra(str));
                }
            }
            new Thread(new RunnableC0331a(this, a.this.w(), nVar)).start();
        }
    }

    /* loaded from: classes.dex */
    class f implements l {
        f() {
        }

        @Override // o7.l
        public o7.b a(String str, int i10, String str2, String str3) {
            try {
                a.this.P = new x7.b(str, i10, str2, str3, (AudioManager) ((Context) a.this.I.get()).getSystemService("audio"), a.this.O, a.Q);
                return a.this.P;
            } catch (Exception e10) {
                a.this.f15497x.a(e10.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends u7.h {

        /* renamed from: e, reason: collision with root package name */
        private u7.h f15508e;

        g(a aVar, u7.h hVar) {
            this(hVar.h(), hVar.g(), hVar.f());
            this.f15508e = hVar;
        }

        g(u7.k kVar, o7.a aVar, o7.j jVar) {
            super(kVar, aVar, jVar);
            j(a.this);
            this.f15508e = null;
        }

        @Override // u7.a
        public void a(int i10, String str) {
            u7.h hVar = this.f15508e;
            if (hVar != null) {
                hVar.a(i10, str);
            }
        }

        @Override // u7.a
        public void c() {
            u7.h hVar = this.f15508e;
            if (hVar != null) {
                hVar.c();
            }
        }

        @Override // u7.h
        public void i() {
            ((TelephonyManager) ((Context) a.this.I.get()).getSystemService("phone")).listen(a.this.O, 32);
            ((Context) a.this.I.get()).registerReceiver(a.this.N, new IntentFilter("net.dipio.sdk.INVITE_TO_CHANNEL"));
            ((Context) a.this.I.get()).registerReceiver(a.this.J, new IntentFilter("net.dipio.sdk.mada.android.KA"));
            ((Context) a.this.I.get()).registerReceiver(a.this.K, new IntentFilter("net.dipio.sdk.mada.android.NEW_FCM_TOKEN"));
            ((Context) a.this.I.get()).registerReceiver(a.this.L, new IntentFilter("net.dipio.sdk.KA_TEST"));
            a.this.x0();
            ((Context) a.this.I.get()).registerReceiver(a.this.M, new IntentFilter("net.dipio.sdk.IDLE_TEST"));
            a.this.w0();
            u7.h hVar = this.f15508e;
            if (hVar != null) {
                hVar.i();
            }
        }
    }

    public a(Context context, String str, l7.a... aVarArr) {
        super(str, aVarArr);
        this.f15496w = "AMadaSDKM";
        this.f15497x = ic.c.i(a.class.getSimpleName());
        this.J = new C0330a();
        this.K = new b();
        this.L = new c();
        this.M = new d();
        this.N = new e();
        this.O = new h();
        new HashMap();
        j.c(context);
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        audioManager.setSpeakerphoneOn(true);
        v7.b.d(this.f15496w, "C-tor(): is speaker on? {}", Boolean.valueOf(audioManager.isSpeakerphoneOn()));
        j.c(context);
        this.I = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        ((AlarmManager) this.I.get().getSystemService("alarm")).setInexactRepeating(0, System.currentTimeMillis() + 300000, 300000L, PendingIntent.getBroadcast(this.I.get(), 0, new Intent("net.dipio.sdk.IDLE_TEST"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        ((AlarmManager) this.I.get().getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + 720000, 720000L, PendingIntent.getBroadcast(this.I.get(), 0, new Intent("net.dipio.sdk.KA_TEST"), 0));
    }

    @Override // u7.s
    public void H(m mVar) {
        AlarmManager alarmManager = (AlarmManager) this.I.get().getSystemService("alarm");
        alarmManager.cancel(PendingIntent.getBroadcast(this.I.get(), 0, new Intent("net.dipio.sdk.KA_TEST"), 0));
        alarmManager.cancel(PendingIntent.getBroadcast(this.I.get(), 0, new Intent("net.dipio.sdk.IDLE_TEST"), 0));
        this.I.get().unregisterReceiver(this.M);
        this.I.get().unregisterReceiver(this.L);
        this.I.get().unregisterReceiver(this.K);
        this.I.get().unregisterReceiver(this.J);
        this.I.get().unregisterReceiver(this.N);
        ((TelephonyManager) this.I.get().getSystemService("phone")).listen(this.O, 0);
        super.H(mVar);
    }

    @Override // u7.s
    protected void Q() {
        x7.g gVar = this.H;
        if (gVar != null) {
            gVar.b();
        }
        v7.b.c("media", "MODE_NORMAL");
        ((AudioManager) this.I.get().getSystemService("audio")).setMode(0);
    }

    @Override // u7.s
    protected void d0(o7.b bVar) {
        int read = this.G.read(this.f15499z, 0, this.f15498y);
        this.C = read;
        int i10 = this.E;
        int i11 = read + i10;
        this.D = i11;
        int i12 = i11 % 480;
        int i13 = i11 - i12;
        this.D = i13;
        byte[] bArr = new byte[i13];
        this.F = bArr;
        if (i10 > 0) {
            System.arraycopy(this.B, 0, bArr, 0, i10);
        }
        if (i12 == 0) {
            System.arraycopy(this.f15499z, 0, this.F, this.E, this.C);
            this.E = 0;
        } else {
            int i14 = this.C - i12;
            int i15 = this.E;
            int i16 = i14 - i15;
            System.arraycopy(this.f15499z, 0, this.F, i15, i16);
            if (i12 > 0) {
                System.arraycopy(this.f15499z, i16, this.B, 0, i12);
                this.E = i12;
            }
        }
        Codec.a().encode(this.F, 0, this.D, this.A, 0);
        bVar.B(this.A);
    }

    @Override // w7.a
    public void e0(String str, String str2, boolean z10, u7.h hVar) {
        super.e0(str, str2, z10, new g(this, hVar));
    }

    @Override // u7.s
    protected String v() {
        try {
            return Base64.encodeToString(FirebaseInstanceId.i().n().getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // u7.s
    protected l y() {
        return new f();
    }

    public void y0() {
        try {
            x7.b bVar = this.P;
            if (bVar == null) {
                return;
            }
            bVar.G();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // u7.s
    protected void z() {
        this.f15498y = 960;
        this.f15499z = new byte[960];
        this.A = new byte[(960 / 480) * 50];
        this.B = new byte[480];
        this.C = 0;
        this.D = 0;
        this.E = 0;
        int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
        int a10 = j.b().a();
        if (minBufferSize % 960 != 0) {
            minBufferSize = ((minBufferSize / 960) + 1) * 960;
        }
        AudioRecord audioRecord = new AudioRecord(a10, 8000, 16, 2, Math.max(minBufferSize, 960));
        this.G = audioRecord;
        this.H = new x7.f(audioRecord);
        Context context = this.I.get();
        if (context != null) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (x7.d.b() && audioManager.isBluetoothScoAvailableOffCall()) {
                this.H = new x7.c(this.H, new x7.d(context, Q));
            }
            v7.b.c("media", "MODE_NORMAL");
            audioManager.setMode(0);
        }
        this.H.a();
    }

    public void z0(k kVar) {
        j.b().h(kVar);
    }
}
