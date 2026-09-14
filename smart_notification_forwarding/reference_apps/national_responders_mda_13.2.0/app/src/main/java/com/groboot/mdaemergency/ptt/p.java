package com.groboot.mdaemergency.ptt;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import androidx.core.app.k;
import com.groboot.mdaemergency.alwaysOn_Old.services.AlwaysOnOldMainService;
import com.groboot.mdaemergency.async.CallReceiver;
import com.groboot.mdaemergency.async.FloatViewService;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.PlayMessage;
import com.groboot.mdaemergency.ptt.d;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ptt.s;
import com.groboot.mdaemergency.services.PttFloatDialogViewService;
import com.groboot.mdaemergency.ui.main.MainActivity;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import g5.e;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l8.w;
import w6.d0;
import w6.f0;
import w6.g;
import w6.g0;
import w6.l0;
import w6.m0;

/* loaded from: classes.dex */
public class p {
    private static int A = 50;
    public static String[] B = {"android.intent.action.SOS_PRESS", "com.android.intent.sos.down", "android.intent.action.SOS.down", "com.motorolasolutions.intent.action.ACTION_SOS_BUTTON_DOWN", "android.intent.action.PTT_PRESS", "com.android.intent.ptt.down", "android.intent.action.PTT.down", "com.motorolasolutions.intent.action.ACTION_PTT_BUTTON_DOWN"};
    public static String[] C = {"android.intent.action.SOS_RELEASE", "com.android.intent.sos.up", "android.intent.action.SOS.up", "com.motorolasolutions.intent.action.ACTION_SOS_BUTTON_UP", "android.intent.action.PTT_RELEASE", "com.android.intent.ptt.up", "android.intent.action.PTT.up", "com.motorolasolutions.intent.action.ACTION_PTT_BUTTON_UP"};
    public static int D = 12123;
    private static String E = "http://147.234.41.148:24000/apis.dis.server-1/APIS";
    private static String F = "http://10.10.1.50:8080/apis.dis.server-1/APIS";

    /* renamed from: v, reason: collision with root package name */
    public static String f7896v = "DA";

    /* renamed from: w, reason: collision with root package name */
    public static String f7897w = "TY";

    /* renamed from: x, reason: collision with root package name */
    public static String f7898x = "1";

    /* renamed from: y, reason: collision with root package name */
    public static String f7899y = "4";

    /* renamed from: z, reason: collision with root package name */
    private static int f7900z = 20;

    /* renamed from: a, reason: collision with root package name */
    private Hashtable<s.a, com.groboot.mdaemergency.ptt.s> f7901a;

    /* renamed from: b, reason: collision with root package name */
    Context f7902b;

    /* renamed from: c, reason: collision with root package name */
    public com.groboot.mdaemergency.ptt.d f7903c;

    /* renamed from: d, reason: collision with root package name */
    HashMap<String, Date> f7904d;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<PlayMessage> f7906f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7907g;

    /* renamed from: h, reason: collision with root package name */
    boolean f7908h;

    /* renamed from: i, reason: collision with root package name */
    com.groboot.mdaemergency.ptt.a f7909i;

    /* renamed from: j, reason: collision with root package name */
    a0 f7910j;

    /* renamed from: l, reason: collision with root package name */
    private y f7912l;

    /* renamed from: m, reason: collision with root package name */
    public String f7913m;

    /* renamed from: n, reason: collision with root package name */
    public String f7914n;

    /* renamed from: o, reason: collision with root package name */
    private String f7915o;

    /* renamed from: q, reason: collision with root package name */
    String f7917q;

    /* renamed from: r, reason: collision with root package name */
    v f7918r;

    /* renamed from: s, reason: collision with root package name */
    boolean f7919s;

    /* renamed from: t, reason: collision with root package name */
    String f7920t;

    /* renamed from: e, reason: collision with root package name */
    private int f7905e = 0;

    /* renamed from: k, reason: collision with root package name */
    Date f7911k = new Date();

    /* renamed from: p, reason: collision with root package name */
    boolean f7916p = false;

    /* renamed from: u, reason: collision with root package name */
    Object f7921u = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends u7.k {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            d0.a(500L);
            p pVar = p.this;
            pVar.h1(pVar.f7909i.a());
        }

        @Override // u7.k
        public void c(String str, String str2, v7.c cVar, String str3, String str4, long j10, long j11, String str5) {
            if (!l0.l0(str4) && str4.startsWith("<R>")) {
                String u02 = l0.u0(l0.s0(str4, "<R>"), "</R>");
                p.this.H("receive messageId " + u02);
                if (p.this.f7903c.x(cVar.o(), u02)) {
                    new Thread(new Runnable() { // from class: com.groboot.mdaemergency.ptt.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            p.a.this.e();
                        }
                    }).start();
                    return;
                }
                return;
            }
            p.this.H("Received questionMessge: " + str4 + " from: user - " + cVar.s() + " name - " + cVar.r() + " description - " + cVar.n());
        }
    }

    /* loaded from: classes.dex */
    public enum a0 {
        notReady,
        login,
        ready,
        openChanel,
        readyToPtt,
        requestPttSession,
        ptt,
        ending,
        logout;

        public boolean isBusy() {
            int i10 = n.f7950a[ordinal()];
            return i10 == 1 || i10 == 2 || i10 == 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        
            if (r6 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
        
            r5.f7923a.X0(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
        
            if (r6 != null) goto L15;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(android.content.Context r6, android.content.Intent r7) {
            /*
                r5 = this;
                com.groboot.mdaemergency.ptt.p r6 = com.groboot.mdaemergency.ptt.p.this
                boolean r6 = r6.f7916p
                r0 = 0
                if (r6 == 0) goto L1c
                java.lang.String[] r6 = com.groboot.mdaemergency.ptt.p.C
                java.lang.String r1 = r7.getAction()
                boolean r6 = w6.l0.R0(r6, r1)
                if (r6 == 0) goto L1c
            L13:
                com.groboot.mdaemergency.ptt.p r6 = com.groboot.mdaemergency.ptt.p.this
                r6.f7916p = r0
                r6.C0()
                goto La1
            L1c:
                com.groboot.mdaemergency.ptt.p r6 = com.groboot.mdaemergency.ptt.p.this
                boolean r6 = r6.f7916p
                java.lang.String r1 = "אורן בלוש"
                r2 = 1
                if (r6 != 0) goto L4c
                java.lang.String[] r6 = com.groboot.mdaemergency.ptt.p.B
                java.lang.String r3 = r7.getAction()
                boolean r6 = w6.l0.R0(r6, r3)
                if (r6 == 0) goto L4c
                com.groboot.mdaemergency.ptt.p r6 = com.groboot.mdaemergency.ptt.p.this
                r6.f7916p = r2
                com.groboot.mdaemergency.ptt.a r7 = r6.f7909i
                if (r7 != 0) goto L46
                com.groboot.mdaemergency.ptt.d r6 = r6.f7903c
                w6.p r6 = r6.h(r1)
                if (r6 == 0) goto L46
            L41:
                com.groboot.mdaemergency.ptt.p r7 = com.groboot.mdaemergency.ptt.p.this
                r7.X0(r6)
            L46:
                com.groboot.mdaemergency.ptt.p r6 = com.groboot.mdaemergency.ptt.p.this
                r6.B0()
                goto La1
            L4c:
                java.lang.String r6 = com.groboot.mdaemergency.ptt.p.x.f7961a
                java.lang.String r3 = r7.getAction()
                boolean r6 = r6.equals(r3)
                if (r6 == 0) goto La1
                java.lang.String r6 = com.groboot.mdaemergency.ptt.p.x.f7963c
                boolean r6 = r7.getBooleanExtra(r6, r0)
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
                boolean r3 = r6.booleanValue()
                com.groboot.mdaemergency.ptt.p r4 = com.groboot.mdaemergency.ptt.p.this
                boolean r4 = r4.f7916p
                if (r3 == r4) goto L83
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L13
                com.groboot.mdaemergency.ptt.p r6 = com.groboot.mdaemergency.ptt.p.this
                r6.f7916p = r2
                com.groboot.mdaemergency.ptt.a r7 = r6.f7909i
                if (r7 != 0) goto L46
                com.groboot.mdaemergency.ptt.d r6 = r6.f7903c
                w6.p r6 = r6.h(r1)
                if (r6 == 0) goto L46
                goto L41
            L83:
                java.lang.String r6 = com.groboot.mdaemergency.ptt.p.x.f7962b
                java.lang.String r0 = r7.getAction()
                boolean r6 = r6.equals(r0)
                if (r6 == 0) goto L90
                goto La1
            L90:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "PTT BUTTON Action:"
                r6.append(r0)
                java.lang.String r7 = r7.getAction()
                r6.append(r7)
            La1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.groboot.mdaemergency.ptt.p.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* loaded from: classes.dex */
    public interface b0 {
        void a();

        void b(p pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements o7.j {
        c() {
        }

        @Override // o7.j
        public void a(com.google.gson.n nVar) {
            p.this.H("Invite on complete\n" + nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends u7.h {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f7925e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(u7.k kVar, o7.a aVar, o7.j jVar, boolean z10) {
            super(kVar, aVar, jVar);
            this.f7925e = z10;
        }

        @Override // u7.a
        public void a(int i10, String str) {
            if (i10 == 100) {
                i();
                return;
            }
            p.this.H("login failed. counter:" + p.this.f7905e + " handleFailure. code:" + i10 + " " + str);
            p pVar = p.this;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("login PTT failed ");
            sb2.append(str);
            pVar.S(sb2.toString());
            p.this.w0();
            if (this.f7925e) {
                p.this.I("recoveryPTT", "login failed code:" + i10 + "\n" + str);
            }
            if (i10 == 44) {
                p.this.H("login failed. reRegister");
                p.this.K0();
            }
        }

        @Override // u7.a
        public void c() {
            p.this.H("login failed. Timeout");
            p.this.S("login PTT failed - Timeout");
            p.this.w0();
            if (this.f7925e) {
                p.this.I("recoveryPTT", "login failed. Timeout");
            }
        }

        @Override // u7.h
        public void i() {
            p.this.H("login success");
            p.this.Y0(a0.ready);
            p.this.f7903c.q();
            p.this.b0();
            if (this.f7925e) {
                p.this.I("recoveryPTT", "login success");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends u7.m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u7.m f7927a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a0 f7928b;

        e(u7.m mVar, a0 a0Var) {
            this.f7927a = mVar;
            this.f7928b = a0Var;
        }

        @Override // u7.a
        public void a(int i10, String str) {
            p.this.H("logout Failure " + i10 + " " + str + " set lastStatus:" + this.f7928b);
            p.this.Y0(this.f7928b);
            u7.m mVar = this.f7927a;
            if (mVar != null) {
                mVar.a(i10, str);
            }
        }

        @Override // u7.a
        public void c() {
            p.this.H("logout timeout. set lastStatus:" + this.f7928b);
            p.this.Y0(this.f7928b);
            u7.m mVar = this.f7927a;
            if (mVar != null) {
                mVar.c();
            }
        }

        @Override // u7.m
        public void d() {
            p.this.H("logout success");
            p.this.Y0(a0.notReady);
            p.this.R0();
            p.this.S0();
            u7.m mVar = this.f7927a;
            if (mVar != null) {
                mVar.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends u7.j {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f7930b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f7931c;

        f(w wVar, boolean z10) {
            this.f7930b = wVar;
            this.f7931c = z10;
        }

        @Override // u7.a
        public void a(int i10, String str) {
            if (i10 == 1) {
                return;
            }
            p.this.H("open channel handleFailure. code:" + i10 + " " + str);
            p.this.Y0(a0.ready);
            p.this.S(p.this.f7902b.getString(R.string.open_ptt_failed) + str);
        }

        @Override // u7.a
        public void c() {
            p.this.H("open channel failed. Timeout");
            p.this.Y0(a0.ready);
            p.this.f7912l.N();
            p.this.S(p.this.f7902b.getString(R.string.open_ptt_failed) + "Timeout");
        }

        @Override // u7.j
        public void d(String str) {
            p.this.H("channel opened: " + str);
            p pVar = p.this;
            if (pVar.f7910j != a0.openChanel) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Channel Opened in not relevant- status:");
                sb2.append(p.this.f7910j.name());
                return;
            }
            pVar.Y0(a0.readyToPtt);
            this.f7930b.a(str);
            com.groboot.mdaemergency.ptt.a aVar = p.this.f7909i;
            aVar.f7787a = str;
            aVar.g();
            if (this.f7931c) {
                p.this.N();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends u7.n {
        g() {
        }

        @Override // u7.n, u7.a
        public void a(int i10, String str) {
            p.this.H("sendMessage failed - code:" + i10 + " " + str);
        }

        @Override // u7.n, u7.a
        public void c() {
            p.this.H("sendMessage failed - timeout");
        }

        @Override // u7.n
        public void d(String str, long j10, long j11) {
            p.this.H("sendMessage success");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends u7.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.ptt.a f7934a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7935b;

        /* loaded from: classes.dex */
        class a implements MediaPlayer.OnCompletionListener {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f7937f;

            a(String str) {
                this.f7937f = str;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                p.this.f7912l.m(this.f7937f);
                v vVar = p.this.f7918r;
                if (vVar != null && vVar.f7959b) {
                    vVar.d();
                }
                p pVar = p.this;
                pVar.f7918r = new v(this.f7937f);
                p.this.f7918r.c();
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d0.a(2000L);
                if (p.this.i0() != a0.requestPttSession) {
                    return;
                }
                p.this.Y0(a0.readyToPtt);
                h hVar = h.this;
                p.this.O(hVar.f7935b + 1);
            }
        }

        h(com.groboot.mdaemergency.ptt.a aVar, int i10) {
            this.f7934a = aVar;
            this.f7935b = i10;
        }

        @Override // u7.t
        public void a(int i10) {
            p.this.H("requestPttSession handleFailure. code:" + i10);
            if (i10 == 2) {
                new m0(p.this.f7902b, R.raw.ptt_error).f();
                p.this.R(R.string.try_again);
                l0.Z0(p.this.f7902b, l0.h.LONG);
                p.this.e1();
                return;
            }
            if (i10 == 3) {
                new m0(p.this.f7902b, R.raw.ptt_error).f();
                p.this.R(R.string.busy);
                l0.Z0(p.this.f7902b, l0.h.LONG);
                return;
            }
            if (i10 == 6) {
                new m0(p.this.f7902b, R.raw.ptt_error).f();
                p.this.R(R.string.not_ready);
                l0.Z0(p.this.f7902b, l0.h.LONG);
                return;
            }
            if (p.this.i0() != a0.requestPttSession) {
                p.this.H("requestPttSession handleFailure but status is: " + p.this.i0());
                return;
            }
            w6.p a10 = p.this.f7909i.a();
            if (a10 != null) {
                if (p.this.f7904d.containsKey(a10.f15235a) && g0.a(p.this.f7904d.get(a10.f15235a)).f15161e > 30.0d) {
                    p.this.f7904d.remove(a10.f15235a);
                }
                if (this.f7935b < 2) {
                    p.this.f7904d.put(a10.f15235a, new Date());
                    new Thread(new b()).start();
                } else {
                    p.this.f1();
                    l0.Z0(p.this.f7902b, l0.h.LONG);
                    a6.h.j(l0.v(), "נסה שנית", false, null);
                    p.this.Y0(a0.ready);
                }
            }
        }

        @Override // u7.l
        public void c(int i10, String str) {
            p pVar;
            Context context;
            int i11;
            try {
                if (i10 != 0) {
                    p.this.H("requestPttSession failed. returnCode:" + i10);
                    p.this.Y0(a0.ready);
                    p pVar2 = p.this;
                    pVar2.S(pVar2.f7902b.getString(R.string.data_transmission_problem));
                    return;
                }
                p.this.H("requestPttSession success for lastReqId = " + str);
                p pVar3 = p.this;
                a0 a0Var = pVar3.f7910j;
                if (a0Var == a0.ending) {
                    pVar3.H("requestPttSession finish when ending");
                    return;
                }
                if (a0Var != a0.requestPttSession) {
                    pVar3.H("requestPttSession finish but status change to:" + p.this.f7910j);
                    return;
                }
                pVar3.H("begin ptt session, chanel: " + this.f7934a.f7787a + ", session id:" + str);
                p pVar4 = p.this;
                com.groboot.mdaemergency.ptt.a aVar = this.f7934a;
                pVar4.O0(aVar, aVar.a().f15235a);
                p.this.Y0(a0.ptt);
                m0.d(p.this.f7902b, m0.d.ptt_out, new a(str));
            } catch (Exception e10) {
                p.this.Y0(a0.ready);
                p.this.F("beginPtt", e10);
                pVar = p.this;
                context = pVar.f7902b;
                i11 = R.string.open_channel_ptt_failed_1;
                pVar.S(context.getString(i11));
            } catch (Throwable th) {
                p.this.Y0(a0.ready);
                p.this.H("requestPttSession Throwable error");
                th.printStackTrace();
                pVar = p.this;
                context = pVar.f7902b;
                i11 = R.string.open_channel_ptt_failed_2;
                pVar.S(context.getString(i11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                p.this.H("endPttSession");
                p.this.f7912l.q();
                p pVar = p.this;
                if (pVar.f7910j == a0.ending) {
                    str = "stop ptt finish";
                } else {
                    str = "stop ptt finish but status change to:" + p.this.f7910j;
                }
                pVar.H(str);
            } catch (Exception e10) {
                p.this.F("stop ptt failed", e10);
                p pVar2 = p.this;
                pVar2.S(pVar2.f7902b.getString(R.string.operation_failed));
            }
            p.this.Y0(a0.ready);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends o7.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends e5.a<List<w6.p>> {
            a(j jVar) {
            }
        }

        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str, com.groboot.mdaemergency.ptt.a aVar, String str2, g.d dVar, b.a aVar2) {
            if (aVar2 != null && aVar2.f7614b) {
                for (w6.p pVar : (List) new com.google.gson.e().j(aVar2.d("PttContacts").toString(), new a(this).e())) {
                    p.this.H("contact update to (" + pVar.f15238d + ") from server");
                    if (pVar.f15235a.equals(str)) {
                        aVar.f7788b = pVar;
                    } else if (pVar.f15235a.equals(str2)) {
                        aVar.f7789c = pVar;
                    }
                }
            }
            p.this.a1(aVar, dVar);
        }

        @Override // o7.a
        public void a(String str, final String str2, String str3, final String str4, String str5, String str6, String str7, long j10) {
            p.this.H("received ptt (" + str6 + ")  channelId:" + str + " ,userID = " + str4);
            p.this.H("set lastPlayPttResult false");
            p pVar = p.this;
            pVar.f7919s = false;
            try {
                final g.d h02 = pVar.h0();
                p.this.f7920t = str2;
                if (l0.l0(str2) || str2.startsWith("000000")) {
                    p.this.f7920t = str4;
                }
                if (p.n0()) {
                    p pVar2 = p.this;
                    if (pVar2.k0(pVar2.f7920t) || p.this.i0().isBusy() || p.this.Q()) {
                        return;
                    }
                    p.this.H("set lastPlayPttResult true");
                    p pVar3 = p.this;
                    pVar3.f7919s = true;
                    pVar3.Z0();
                    if (w6.m.E()) {
                        if (h02 == g.d.Silence) {
                            l0.Y0(p.this.f7902b, 100, 5, 100);
                        } else {
                            l0.Y0(p.this.f7902b, 100, 3, 300);
                        }
                    }
                    if (h02 != g.d.Silence) {
                        new m0(p.this.f7902b, R.raw.ptt4).f();
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    final com.groboot.mdaemergency.ptt.a aVar = new com.groboot.mdaemergency.ptt.a();
                    aVar.f7787a = str;
                    aVar.g();
                    aVar.h(j7.a.ONLINE);
                    w6.p t10 = p.this.f7903c.f7826c.t(str4);
                    aVar.f7788b = t10;
                    if (t10 != null) {
                        p.this.H("user contact found (" + aVar.f7788b.f15238d + ")");
                    } else {
                        aVar.f7788b = new w6.p().b(new v7.c(str4, str5, "", str6, -1));
                        arrayList.add(str4);
                    }
                    if (!l0.l0(str2) && !str2.startsWith("0000000000")) {
                        w6.p t11 = p.this.f7903c.f7826c.t(str2);
                        aVar.f7789c = t11;
                        if (t11 != null) {
                            p.this.H("group found (" + aVar.f7789c.f15238d + ")");
                        } else {
                            aVar.f7789c = new w6.p().b(new v7.c(str2, "", "", str3, -1));
                            arrayList.add(str2);
                        }
                    }
                    p.this.W0(aVar);
                    p.this.Y0(a0.ready);
                    if (arrayList.isEmpty()) {
                        p.this.a1(aVar, h02);
                    } else {
                        p.this.H("get contact from server(" + str6 + ")");
                        com.groboot.mdaemergency.async.d.v().I(arrayList, new b.InterfaceC0098b() { // from class: com.groboot.mdaemergency.ptt.q
                            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                            public final void a(b.a aVar2) {
                                p.j.this.e(str4, aVar, str2, h02, aVar2);
                            }
                        });
                    }
                    p.this.f7907g = true;
                    p.this.N0(aVar, aVar.a().f15235a);
                }
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("received ptt error=");
                sb2.append(e10);
            }
        }

        @Override // o7.a
        public boolean c(String str) {
            return f();
        }

        public boolean f() {
            if (p.this.Q() || !p.n0()) {
                return false;
            }
            p pVar = p.this;
            if (pVar.k0(pVar.f7920t) || p.this.i0().isBusy()) {
                return false;
            }
            return p.this.f7919s;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements u7.e {
        k() {
        }

        @Override // u7.e
        public void a(String str, Throwable th) {
            p.this.J("[PTT][SDK]", l0.M(str) + " " + th.getMessage(), true);
        }

        @Override // u7.e
        public void b(String str, String str2) {
            if (str.startsWith("AUDPV")) {
                return;
            }
            p.this.I("[PTT][SDK]", l0.M(str) + " " + str2);
        }

        @Override // u7.e
        public void c(String str, String str2) {
            p.this.J("[PTT][SDK]", l0.M(str) + " " + str2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends u7.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.ptt.a f7943b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7944c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f7945d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Long f7946e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ z f7947f;

        /* loaded from: classes.dex */
        class a implements b.InterfaceC0098b {
            a(l lVar) {
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
            }
        }

        l(com.groboot.mdaemergency.ptt.a aVar, String str, String str2, Long l10, z zVar) {
            this.f7943b = aVar;
            this.f7944c = str;
            this.f7945d = str2;
            this.f7946e = l10;
            this.f7947f = zVar;
        }

        @Override // u7.d
        public void b(v7.n nVar) {
            if (nVar == null) {
                return;
            }
            p.this.H("registerLastVoiceHistory " + nVar.k());
            x5.m mVar = new x5.m(nVar.k(), this.f7943b.b(), nVar.l(), this.f7944c, this.f7945d, System.currentTimeMillis() - this.f7946e.longValue());
            z zVar = this.f7947f;
            if (zVar == z.send) {
                p.this.f7903c.w(this.f7943b.a(), nVar.k(), new Date());
                p.this.h1(this.f7943b.a());
                com.groboot.mdaemergency.async.d.v().l0(mVar, new a(this));
            } else if (zVar == z.receive) {
                p.this.f7907g = false;
                p.this.V0(mVar, this.f7943b.a().f15239e != 2);
            }
            p.this.L(mVar, true);
            this.f7943b.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends u7.n {
        m() {
        }

        @Override // u7.n
        public void d(String str, long j10, long j11) {
            p.this.H("sendTextMsg Complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class n {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7950a;

        static {
            int[] iArr = new int[a0.values().length];
            f7950a = iArr;
            try {
                iArr[a0.requestPttSession.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7950a[a0.ptt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7950a[a0.ending.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    class o extends u7.f {
        o() {
        }

        @Override // u7.a
        public void a(int i10, String str) {
            p.this.H("wakeUpIfRequired  failed. handleFailure. code:" + i10 + " " + str);
            if (i10 == 5 || i10 == 13 || i10 == 24 || i10 == 99) {
                p.this.J0();
            } else {
                p.this.Y0(a0.notReady);
            }
        }

        @Override // u7.a
        public void c() {
            p.this.H("wakeUpIfRequired failed. Timeout");
            p.this.K0();
            p.this.Y0(a0.notReady);
        }

        @Override // u7.f
        public void d(List<v7.d> list) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        if (list.size() > 1) {
                            p.this.H("wakeUpIfRequired return " + list.size() + " statuses");
                            return;
                        }
                        j7.a a10 = list.get(0).a();
                        p.this.H("wakeUpIfRequired status:" + a10);
                        if (a10 != j7.a.ONLINE) {
                            p.this.Y0(a0.notReady);
                            return;
                        }
                        return;
                    }
                } catch (Exception e10) {
                    p.this.F("wakeUpIfRequired failed. error:", e10);
                    return;
                }
            }
            p.this.H("wakeUpIfRequired no answer");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.groboot.mdaemergency.ptt.p$p, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0114p extends u7.a {
        C0114p() {
        }

        @Override // u7.a
        public void a(int i10, String str) {
            p.this.K("register - handleFailure - " + i10 + ":" + str, true);
            if (i10 == 5 || i10 == 13 || i10 == 24 || i10 == 99) {
                p.this.J0();
            }
        }

        @Override // u7.a
        public void b(com.google.gson.n nVar) {
            p.this.H("register - onResponseTemplate");
        }

        @Override // u7.a
        public void c() {
            p.this.K("register - onTimeout", true);
            p.this.Y0(a0.notReady);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q extends u7.m {
        q() {
        }

        @Override // u7.a
        public void a(int i10, String str) {
            p.this.I("recoveryPTT", "logout Failure " + i10 + " " + str);
            p.this.Y0(a0.notReady);
            p.this.x0();
        }

        @Override // u7.a
        public void c() {
            p.this.I("recoveryPTT", "logout timeout");
            p.this.Y0(a0.notReady);
            p.this.x0();
        }

        @Override // u7.m
        public void d() {
            p.this.I("recoveryPTT", "logout success");
            p.this.Y0(a0.notReady);
            p.this.x0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r extends u7.a {
        r() {
        }

        @Override // u7.a
        public void a(int i10, String str) {
            p.this.I("recoveryPTT", "reRegister handleFailure " + i10 + " " + str);
            if (i10 == 5 || i10 == 13 || i10 == 24 || i10 == 99) {
                p.this.J0();
            }
        }

        @Override // u7.a
        public void b(com.google.gson.n nVar) {
            String replace = nVar.B("dssSvr").toString().replace("\"", "");
            p.this.I("recoveryPTT", "dssSvr:" + replace);
            if (l0.l0(replace) || l0.l(p.this.f7912l.x(), replace)) {
                return;
            }
            try {
                p.this.I("recoveryPTT", "setDssSvr");
                p.this.f7912l.W(replace);
            } catch (Exception e10) {
                p.this.G("recoveryPTT", "setDssSvr failed", e10);
            }
            p.this.I("recoveryPTT", "reRegister success data" + nVar.toString());
            p.this.L0();
        }

        @Override // u7.a
        public void c() {
            p.this.I("recoveryPTT", "reRegister onTimeout");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b0 f7955f;

        s(b0 b0Var) {
            this.f7955f = b0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i10 = 0; p.c0() == null && i10 < 30; i10++) {
                d0.a(100L);
            }
            if (p.c0() != null) {
                this.f7955f.b(p.c0());
            } else {
                this.f7955f.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t implements d.InterfaceC0112d {
        t() {
        }

        @Override // com.groboot.mdaemergency.ptt.d.InterfaceC0112d
        public void a(String str) {
            p.this.S(str);
        }

        @Override // com.groboot.mdaemergency.ptt.d.InterfaceC0112d
        public void b(w6.p pVar) {
            Iterator it = p.this.f7901a.values().iterator();
            while (it.hasNext()) {
                try {
                    ((com.groboot.mdaemergency.ptt.s) it.next()).g(p.this.f7903c.f7826c);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u extends u7.i {
        u() {
        }

        @Override // u7.b
        public void a() {
            p.this.H("NetworkStatusChanged_onFailure");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class v {

        /* renamed from: a, reason: collision with root package name */
        String f7958a;

        /* renamed from: b, reason: collision with root package name */
        boolean f7959b;

        v(String str) {
            p.this.f7917q = str;
            this.f7958a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ l8.w b() {
            if (!this.f7959b) {
                return null;
            }
            this.f7959b = false;
            if (!l0.l(p.this.f7917q, this.f7958a)) {
                return null;
            }
            p.this.H("stop ptt after one minute");
            p.this.e1();
            return null;
        }

        void c() {
            this.f7959b = true;
            f0.a(1L, new x8.a() { // from class: com.groboot.mdaemergency.ptt.r
                @Override // x8.a
                public final Object b() {
                    w b10;
                    b10 = p.v.this.b();
                    return b10;
                }
            });
        }

        void d() {
            this.f7959b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface w {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class x {

        /* renamed from: a, reason: collision with root package name */
        public static String f7961a = "cn.ruggear.customkey.MyAction";

        /* renamed from: b, reason: collision with root package name */
        public static String f7962b = "cn.ruggear.customkey.CUSTOMKEY_LONGPRESS";

        /* renamed from: c, reason: collision with root package name */
        public static String f7963c = "CUSTOMKEYE_KEYCODE_IS_Down";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class y extends x7.a {
        public y(Context context, String str, l7.a... aVarArr) {
            super(context, str, aVarArr);
            v7.b.e(p.this.Z());
        }

        @Override // u7.s
        public void c0() {
            super.c0();
            if (p.this.i0() == a0.ptt || p.this.f7907g) {
                return;
            }
            p.this.K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum z {
        send,
        receive
    }

    public p(Context context) {
        this.f7902b = context;
        if (n0()) {
            y yVar = new y(context, w6.m.m().getInternalApp() ? F : E, new l7.a[0]);
            this.f7912l = yVar;
            this.f7903c = new com.groboot.mdaemergency.ptt.d(context, yVar, f0());
            this.f7912l.Y(D0());
            this.f7901a = new Hashtable<>();
            H("PTTManager init");
            S0();
            Z0();
            Y0(a0.notReady);
            P0();
        }
    }

    private u7.i D0() {
        return new u();
    }

    private void E0(boolean z10) {
        final com.groboot.mdaemergency.ptt.a e02 = e0();
        if (e02 == null || e02.a() == null) {
            return;
        }
        if (e02.f()) {
            Y0(a0.ready);
            H("required Open Chanel");
            F0(z10, e02.a().f15235a, new w() { // from class: com.groboot.mdaemergency.ptt.n
                @Override // com.groboot.mdaemergency.ptt.p.w
                public final void a(String str) {
                    p.s0(a.this, str);
                }
            });
        } else {
            Y0(a0.readyToPtt);
            N();
            H("not required Open Chanel - call beginPtt()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, Exception exc) {
        G("[MDA][PTT]", str, exc);
    }

    private void F0(boolean z10, String str, w wVar) {
        String str2;
        H("open channel");
        a0 a0Var = this.f7910j;
        if (a0Var == a0.notReady || a0Var == a0.login || a0Var == a0.requestPttSession || a0Var == a0.ptt || a0Var == a0.ending) {
            S(this.f7902b.getString(R.string.ptt_not_available_try_again_after));
            str2 = "open chanel is not relevant - no login success";
        } else {
            if (this.f7912l != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                try {
                    this.f7903c.e(e0().a(), w6.q.f15243p);
                    h1(e0().a());
                    Y0(a0.openChanel);
                    this.f7912l.J(arrayList, new f(wVar, z10));
                    return;
                } catch (Exception e10) {
                    F("open channel Exception", e10);
                    Y0(a0.ready);
                    S(this.f7902b.getString(R.string.open_ptt_failed) + e10.getMessage());
                    return;
                }
            }
            str2 = "androidSDKManager is null. cannot start status " + this.f7910j;
        }
        H(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, String str2, Exception exc) {
        e.a aVar = new e.a(str, str2 + "\n" + exc, l0.I(new Date()), true);
        Iterator<com.groboot.mdaemergency.ptt.s> it = this.f7901a.values().iterator();
        while (it.hasNext()) {
            it.next().h(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str) {
        I("[MDA][PTT]", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, String str2) {
        J(str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, String str2, boolean z10) {
        e.a aVar = new e.a(str, str2, l0.I(new Date()), false);
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable = this.f7901a;
        if (hashtable == null) {
            return;
        }
        Iterator<com.groboot.mdaemergency.ptt.s> it = hashtable.values().iterator();
        while (it.hasNext()) {
            it.next().h(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, boolean z10) {
        J("[MDA][PTT]", str, z10);
    }

    private void M0(com.groboot.mdaemergency.ptt.a aVar, String str, String str2, z zVar) {
        this.f7912l.P(aVar.b(), new l(aVar, str, str2, Long.valueOf(System.currentTimeMillis()), zVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(com.groboot.mdaemergency.ptt.a aVar, String str) {
        M0(aVar, str, b0(), z.receive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(com.groboot.mdaemergency.ptt.a aVar, String str) {
        M0(aVar, b0(), str, z.send);
    }

    private void P0() {
        IntentFilter intentFilter = new IntentFilter();
        for (String str : C) {
            intentFilter.addAction(str);
        }
        for (String str2 : B) {
            intentFilter.addAction(str2);
        }
        intentFilter.addAction(x.f7961a);
        intentFilter.addAction(x.f7962b);
        this.f7902b.registerReceiver(new b(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        return CallReceiver.f7590e && !w6.m.R().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i10) {
        S(this.f7902b.getResources().getString(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        Iterator<com.groboot.mdaemergency.ptt.s> it = this.f7901a.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().a(str);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.f7904d = new HashMap<>();
        this.f7906f = new ArrayList<>();
    }

    private void T(a0 a0Var, a0 a0Var2) {
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable = this.f7901a;
        if (hashtable == null) {
            return;
        }
        Iterator<com.groboot.mdaemergency.ptt.s> it = hashtable.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().d(a0Var, a0Var2);
            } catch (Exception unused) {
            }
        }
    }

    private boolean V(w6.p pVar) {
        w6.q j10;
        Date b10;
        if (pVar.f15239e == 2) {
            return pVar.f15237c.toLowerCase().startsWith("inc_") || pVar.f15237c.toLowerCase().startsWith("team_") || !pVar.f15237c.toLowerCase().startsWith("rg_");
        }
        String str = this.f7915o;
        if (str == null || !str.equals(pVar.f15235a)) {
            return this.f7903c.g(pVar.f15235a) != null || (j10 = this.f7903c.j(pVar)) == null || (b10 = ec.a.b(j10.f15245i, f7900z)) != null || g0.c(b10);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(x5.m mVar, boolean z10) {
        com.groboot.mdaemergency.async.d.v().U(mVar, null);
        if (z10) {
            try {
                H("sendTextMsg to:" + mVar.a() + " message:<R>" + mVar.b() + "</R>");
                this.f7912l.T(mVar.a(), "<R>" + mVar.b() + "</R>", "", new m());
            } catch (Exception e10) {
                H("sendTextMsg failed " + e10.getMessage());
                e10.printStackTrace();
            }
        }
    }

    private void W() {
        ArrayList arrayList = new ArrayList();
        long time = new Date().getTime();
        Iterator<PlayMessage> it = this.f7906f.iterator();
        while (it.hasNext()) {
            PlayMessage next = it.next();
            long time2 = time - next.date.getTime();
            if (time2 > TimeUnit.MINUTES.toMillis(2L)) {
                arrayList.add(next);
                H("removePTTMessage " + time2 + " minutes pass");
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.f7906f.remove((PlayMessage) it2.next());
        }
    }

    private o7.a X() {
        return new j();
    }

    private u7.k Y() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u7.e Z() {
        return new k();
    }

    private void a0() {
        final String str = e0().f7788b.f15235a;
        new Thread(new Runnable() { // from class: x5.i
            @Override // java.lang.Runnable
            public final void run() {
                p.this.p0(str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(com.groboot.mdaemergency.ptt.a aVar, g.d dVar) {
        b1(aVar);
        if (!MainActivity.f8236c0) {
            if (w6.m.C().equals("2")) {
                PttFloatDialogViewService.k(this.f7902b);
            } else if (w6.m.C().equals("1")) {
                FloatViewService.k(this.f7902b, com.groboot.mdaemergency.enums.d.PTT);
            }
        }
        boolean z10 = false;
        if (w6.m.K()) {
            AlwaysOnOldMainService.w(this.f7902b);
            Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable = this.f7901a;
            s.a aVar2 = s.a.service;
            if (hashtable.containsKey(aVar2)) {
                z10 = this.f7901a.get(aVar2).b(aVar);
            }
        }
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable2 = this.f7901a;
        s.a aVar3 = s.a.lockScreenView;
        if (hashtable2.containsKey(aVar3)) {
            z10 = this.f7901a.get(aVar3).b(aVar);
        }
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable3 = this.f7901a;
        s.a aVar4 = s.a.floatView;
        if (hashtable3.containsKey(aVar4)) {
            z10 = this.f7901a.get(aVar4).b(aVar);
        }
        if (!z10) {
            Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable4 = this.f7901a;
            s.a aVar5 = s.a.main;
            if (hashtable4.containsKey(aVar5)) {
                this.f7901a.get(aVar5).b(aVar);
            }
        }
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable5 = this.f7901a;
        s.a aVar6 = s.a.dialog;
        if (hashtable5.containsKey(aVar6)) {
            this.f7901a.get(aVar6).b(aVar);
        }
        h1(aVar.a());
        this.f7903c.e(aVar.a(), w6.q.f15242o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b0() {
        String str = this.f7915o;
        if (str != null) {
            return str;
        }
        new Thread(new Runnable() { // from class: x5.h
            @Override // java.lang.Runnable
            public final void run() {
                p.this.r0();
            }
        }).start();
        return null;
    }

    public static p c0() {
        return PTTService.c();
    }

    public static void d0(Context context, b0 b0Var) {
        if (c0() != null) {
            b0Var.b(c0());
        } else if (n0()) {
            PTTService.j(context);
            new Thread(new s(b0Var)).start();
        }
    }

    private d.InterfaceC0112d f0() {
        return new t();
    }

    private PlayMessage g0(String str) {
        Iterator<PlayMessage> it = this.f7906f.iterator();
        while (it.hasNext()) {
            PlayMessage next = it.next();
            if (l0.l(next.message.b(), str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(w6.p pVar) {
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable = this.f7901a;
        s.a aVar = s.a.fragment;
        if (hashtable.containsKey(aVar)) {
            this.f7901a.get(aVar).e(pVar);
        }
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable2 = this.f7901a;
        s.a aVar2 = s.a.view;
        if (hashtable2.containsKey(aVar2)) {
            this.f7901a.get(aVar2).e(pVar);
        }
    }

    private a0 j0() {
        return (e0() == null || e0().f()) ? a0.ready : a0.readyToPtt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k0(String str) {
        String str2 = this.f7915o;
        return (str2 != null && str2.equals(str)) || this.f7903c.n(str);
    }

    public static boolean n0() {
        return w6.m.r() && w6.m.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(String str, b.a aVar) {
        if (aVar.f7614b) {
            try {
                int c10 = aVar.c("Status");
                com.groboot.mdaemergency.ptt.t valueOf = com.groboot.mdaemergency.ptt.t.valueOf(c10);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getUserStatus status:");
                sb2.append(c10);
                sb2.append(", ");
                sb2.append(valueOf.name());
                if (valueOf != com.groboot.mdaemergency.ptt.t.available && e0().a().f15235a.equals(str)) {
                    if (i0() == a0.openChanel || i0() == a0.readyToPtt || i0() == a0.requestPttSession || i0() == a0.ptt) {
                        R(valueOf.getName());
                        l0.Z0(this.f7902b, l0.h.LONG);
                        e1();
                    }
                }
            } catch (Exception e10) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getUserStatus error: ");
                sb3.append(e10.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(final String str) {
        com.groboot.mdaemergency.async.d.v().M(str, new b.InterfaceC0098b() { // from class: x5.g
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                p.this.o0(str, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(b.a aVar) {
        String e10;
        if (aVar == null) {
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getDipioID = ");
            sb2.append(aVar.e("DipioId"));
            if (aVar.f7614b && (e10 = aVar.e("DipioId")) != null) {
                this.f7915o = e10;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("dipioid= ");
            sb3.append(this.f7915o);
        } catch (Exception e11) {
            e11.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        com.groboot.mdaemergency.async.d.v().t(new b.InterfaceC0098b() { // from class: x5.f
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                p.this.q0(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0(com.groboot.mdaemergency.ptt.a aVar, String str) {
        if (l0.l0(str)) {
            return;
        }
        aVar.f7787a = str;
    }

    private u7.h t0(boolean z10) {
        return new d(Y(), X(), new c(), z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("login failed status ");
        sb2.append(this.f7910j);
        a0 a0Var = this.f7910j;
        if (a0Var == a0.login || a0Var == a0.notReady) {
            Y0(a0.notReady);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        I("recoveryPTT", "login");
        synchronized (this.f7910j) {
            Y0(a0.login);
        }
        try {
            I("recoveryPTT", "login userName:" + this.f7913m + " pass:" + this.f7914n);
            this.f7908h = true;
            this.f7912l.e0(this.f7913m, this.f7914n, true, t0(true));
            this.f7908h = false;
        } catch (Exception e10) {
            Y0(a0.notReady);
            G("recoveryPTT", "login failed", e10);
        }
    }

    public boolean A0(Context context, int i10, int i11) {
        return false;
    }

    public void B0() {
        a0 a0Var = this.f7910j;
        if (a0Var == a0.ptt || a0Var == a0.notReady || a0Var == a0.login) {
            return;
        }
        if (!V(e0().a())) {
            new m0(this.f7902b, R.raw.buzzer).f();
            a6.h.j(l0.v(), "אין הרשאה", false, null);
        } else if (this.f7909i != null) {
            a0();
            E0(true);
        }
    }

    public void C0() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onButtonUp status:");
        sb2.append(i0().name());
        e1();
    }

    public void E(s.a aVar, com.groboot.mdaemergency.ptt.s sVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addCallBack:");
        sb2.append(aVar);
        if (this.f7901a == null) {
            this.f7901a = new Hashtable<>();
        }
        if (this.f7901a.containsKey(aVar)) {
            this.f7901a.remove(aVar);
        }
        this.f7901a.put(aVar, sVar);
    }

    public void G0(PlayMessage playMessage) {
        H0(playMessage.message.a(), playMessage.message.b());
    }

    public void H0(String str, String str2) {
        H("play PTT message channelId:" + str + " messageId:" + str2);
        this.f7912l.K(str, str2);
    }

    public void I0() {
        H("playUnplaingPTTMessage()");
        if (this.f7907g) {
            H("playUnplaing isPlaying");
            return;
        }
        if (i0() != a0.ready) {
            H("playUnplaing status is " + i0());
            return;
        }
        if (this.f7906f.size() == 0) {
            return;
        }
        Iterator<PlayMessage> it = this.f7906f.iterator();
        while (it.hasNext()) {
            PlayMessage next = it.next();
            if (!next.isPlayed) {
                H("playUnplaing play message");
                G0(next);
                next.isPlayed = true;
                H("addPTTMessage " + next.message.b() + " set isPlayed");
                V0(next.message, true);
                return;
            }
        }
    }

    public void J0() {
        I("recoveryPTT", "logout");
        this.f7908h = true;
        this.f7912l.H(new q());
    }

    public void K0() {
        I("recoveryPTT", "reRegister");
        this.f7912l.L(new r());
    }

    public void L(x5.m mVar, boolean z10) {
        String str;
        H("addPTTMessage " + mVar.b() + " played: " + z10 + " duration: " + mVar.c());
        if (i0() == a0.logout) {
            H("addPTTMessage " + mVar.b() + " canceled. status is logout");
            return;
        }
        synchronized (this.f7921u) {
            PlayMessage g02 = g0(mVar.b());
            if (g02 == null) {
                PlayMessage playMessage = new PlayMessage();
                playMessage.message = mVar;
                playMessage.date = new Date();
                playMessage.isPlayed = z10;
                this.f7906f.add(playMessage);
                H("addPTTMessage " + mVar.b() + " add to list");
                W();
                return;
            }
            if (!z10 || g02.isPlayed) {
                str = "addPTTMessage " + mVar.b() + " already exist";
            } else {
                g02.isPlayed = true;
                str = "addPTTMessage " + mVar.b() + " set isPlayed";
            }
            H(str);
        }
    }

    public void L0() {
        H("register");
        this.f7912l.O(new C0114p());
    }

    public void M(x5.m mVar) {
        H("addPTTMessage called by server. id:" + mVar.b());
        L(mVar, false);
        I0();
    }

    public boolean N() {
        return O(0);
    }

    public boolean O(int i10) {
        com.groboot.mdaemergency.ptt.a e02 = e0();
        if (e02 == null) {
            return false;
        }
        return P(e02, i10);
    }

    public boolean P(com.groboot.mdaemergency.ptt.a aVar, int i10) {
        try {
            H("requestPttSession retry:" + i10);
            if (this.f7910j != a0.readyToPtt) {
                H("begin ptt is not relevant - status:" + this.f7910j);
                return false;
            }
            if (this.f7912l != null) {
                Y0(a0.requestPttSession);
                this.f7912l.S(aVar.f7787a, new h(aVar, i10));
                return true;
            }
            H("androidSDKManager is null. cannot start status " + this.f7910j);
            return false;
        } catch (Exception e10) {
            F("requestPttSession Exception", e10);
            Y0(a0.ready);
            S(this.f7902b.getString(R.string.open_channel_ptt_failed));
            return false;
        } catch (Throwable th) {
            H("requestPttSession Exception 2 " + th.getMessage());
            Y0(a0.ready);
            th.printStackTrace();
            S(this.f7902b.getString(R.string.open_channel_ptt_failed));
            return false;
        }
    }

    public void Q0(s.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("removeCallBack:");
        sb2.append(aVar);
        Hashtable<s.a, com.groboot.mdaemergency.ptt.s> hashtable = this.f7901a;
        if (hashtable == null || !hashtable.containsKey(aVar)) {
            return;
        }
        this.f7901a.remove(aVar);
    }

    public void R0() {
        ((NotificationManager) this.f7902b.getSystemService("notification")).cancel(D);
    }

    public boolean T0(String str) {
        com.groboot.mdaemergency.ptt.a e02 = e0();
        if (e02 == null) {
            return false;
        }
        return U0(e02.f7787a, str);
    }

    public void U() {
        float f10;
        g.d byInt = g.d.getByInt(l0.U(w6.m.G()));
        g.d dVar = g.d.Silence;
        if (byInt == dVar) {
            w6.m.y0(g.d.NONE.getLevelValue() + "");
            f10 = 5.0f;
        } else {
            w6.m.y0(dVar.getLevelValue() + "");
            f10 = 0.0f;
        }
        w6.m.x0(f10);
        Z0();
        this.f7912l.y0();
    }

    public boolean U0(String str, String str2) {
        String str3;
        StringBuilder sb2;
        String str4;
        if (this.f7910j != a0.ready) {
            sb2 = new StringBuilder();
            str4 = "sendMessage is not relevant - status:";
        } else if (this.f7912l == null) {
            sb2 = new StringBuilder();
            str4 = "androidSDKManager is null. cannot start status ";
        } else {
            try {
                H("sendMessage:" + str2);
                this.f7912l.T(str, str2, "", new g());
                return true;
            } catch (Exception e10) {
                str3 = "sendMessage failed - error:" + e10.getMessage();
            }
        }
        sb2.append(str4);
        sb2.append(this.f7910j);
        str3 = sb2.toString();
        H(str3);
        return false;
    }

    public void W0(com.groboot.mdaemergency.ptt.a aVar) {
        this.f7909i = aVar;
    }

    public com.groboot.mdaemergency.ptt.a X0(w6.p pVar) {
        com.groboot.mdaemergency.ptt.a aVar = new com.groboot.mdaemergency.ptt.a();
        this.f7909i = aVar;
        aVar.f7788b = pVar;
        return aVar;
    }

    public void Y0(a0 a0Var) {
        a0 a0Var2;
        a0 a0Var3 = this.f7910j;
        this.f7910j = a0Var;
        this.f7911k = new Date();
        a0 a0Var4 = a0.login;
        if (a0Var == a0Var4 || a0Var == (a0Var2 = a0.notReady) || a0Var3 == a0Var4 || a0Var3 == a0Var2) {
            v5.a.b(this.f7902b);
        }
        H("set status from " + a0Var3 + " to " + a0Var);
        T(a0Var, a0Var3);
    }

    public void Z0() {
        boolean z10 = h0() == g.d.Silence;
        float F2 = w6.m.F();
        x7.k kVar = new x7.k();
        kVar.f15538e = z10;
        kVar.f15537d = false;
        kVar.f15536c = F2;
        kVar.f15534a = F2;
        kVar.f15535b = F2;
        this.f7912l.z0(kVar);
    }

    public void b1(com.groboot.mdaemergency.ptt.a aVar) {
        g.d h02 = h0();
        Intent intent = new Intent(this.f7902b, (Class<?>) SplashActivity.class);
        if (aVar != null) {
            intent.putExtra(f7896v, new com.google.gson.e().r(aVar));
            intent.putExtra(f7897w, f7898x);
            intent.addFlags(67108864);
            int V = l0.V(aVar.a().f15235a);
            int i10 = Build.VERSION.SDK_INT;
            PendingIntent activity = PendingIntent.getActivity(this.f7902b, V, intent, i10 >= 23 ? 1140850688 : 1073741824);
            String str = aVar.a().f15238d;
            if (aVar.f7789c != null) {
                str = str + "\n" + aVar.f7788b.f15238d;
            }
            k.e i11 = new k.e(this.f7902b).w(R.drawable.icon_14).z(this.f7902b.getString(R.string.call_ptt)).k(this.f7902b.getString(R.string.call_ptt)).j(str).f(true).C(System.currentTimeMillis()).i(activity);
            if (h02 == g.d.Silence) {
                i11.w(R.drawable.icon_14_gray);
                i11.j(str + "\nמנסה ליצור איתך קשר");
            }
            if (i10 >= 16) {
                i11.y(new k.c().h(str));
            }
            ((NotificationManager) this.f7902b.getSystemService("notification")).notify(D, i11.b());
        }
    }

    public void c1(com.groboot.mdaemergency.ptt.a aVar) {
        if (!n0()) {
            String str = "PTT לא זמין";
            if (w6.m.r() && !w6.m.s()) {
                str = "PTT לא זמין. ניתן לשנות במסך הגדרות";
            }
            a6.h.j(l0.v(), str, true, null);
            return;
        }
        W0(aVar);
        if (aVar.f()) {
            E0(false);
        }
        try {
            if (w6.m.K()) {
                AlwaysOnOldMainService.w(this.f7902b);
                return;
            }
            Iterator<com.groboot.mdaemergency.ptt.s> it = this.f7901a.values().iterator();
            while (it.hasNext()) {
                try {
                    it.next().f(aVar);
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    public void d1(w6.p pVar) {
        c1(X0(pVar));
    }

    public com.groboot.mdaemergency.ptt.a e0() {
        return this.f7909i;
    }

    public boolean e1() {
        StringBuilder sb2;
        String str;
        a0 a0Var;
        String str2;
        a0 a0Var2 = this.f7910j;
        if (a0Var2 == a0.notReady || a0Var2 == a0.login || a0Var2 == a0.ready || a0Var2 == (a0Var = a0.ending) || a0Var2 == a0.logout) {
            try {
                H("endPttSession silence");
                this.f7912l.q();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            sb2 = new StringBuilder();
            str = "stop ptt is not relevant - status:";
        } else {
            if (this.f7912l != null) {
                H("stop ptt");
                Y0(a0Var);
                try {
                    H("m_AndroidSDKManager.endPttSession()");
                    this.f7912l.q();
                    if (this.f7910j == a0Var) {
                        str2 = "stop ptt finish";
                    } else {
                        str2 = "stop ptt finish but status change to:" + this.f7910j;
                    }
                    H(str2);
                } catch (Exception e11) {
                    F("stop ptt failed", e11);
                    S(this.f7902b.getString(R.string.operation_failed));
                }
                Y0(j0());
                return true;
            }
            sb2 = new StringBuilder();
            str = "androidSDKManager is null. cannot start status ";
        }
        sb2.append(str);
        sb2.append(this.f7910j);
        H(sb2.toString());
        return false;
    }

    public void f1() {
        a0 a0Var = this.f7910j;
        if ((a0Var == a0.ptt || a0Var == a0.requestPttSession) && this.f7912l != null) {
            H("stop ptt Silence");
            Y0(a0.ending);
            new Thread(new i()).start();
        }
    }

    public void g1() {
        this.f7902b.sendBroadcast(new Intent("il.org.mda.ptt.sdk.KA_TEST"));
    }

    public g.d h0() {
        return g.d.getByInt(l0.U(w6.m.G()));
    }

    public a0 i0() {
        return this.f7910j;
    }

    public void i1() {
        List<String> singletonList;
        a0 a0Var = this.f7910j;
        if (a0Var == a0.notReady || a0Var == a0.login || b0() == null) {
            return;
        }
        H("wakeUpIfRequired");
        if (this.f7912l == null || (singletonList = Collections.singletonList(b0())) == null || singletonList.size() == 0 || singletonList.get(0) == null) {
            return;
        }
        this.f7912l.u(singletonList, new o());
    }

    public void l0() {
        m0(this.f7909i);
    }

    public void m0(com.groboot.mdaemergency.ptt.a aVar) {
        String str;
        if (this.f7912l == null) {
            str = "androidSDKManager is null. cannot check is active";
        } else {
            if (aVar != null) {
                aVar.h(j7.a.ONLINE);
                Iterator<com.groboot.mdaemergency.ptt.s> it = this.f7901a.values().iterator();
                while (it.hasNext()) {
                    it.next().c(aVar);
                }
                return;
            }
            str = "chanelData is null." + this.f7910j;
        }
        H(str);
    }

    public boolean u0() {
        return false;
    }

    public boolean v0() {
        if (this.f7905e <= A) {
            return false;
        }
        if (this.f7910j != a0.notReady) {
            H("not relevant function(loginRestart) - status:" + this.f7910j);
            return false;
        }
        Date b10 = ec.a.b(this.f7911k, 30);
        if (b10 != null && g0.c(b10)) {
            return false;
        }
        this.f7905e = 0;
        return u0();
    }

    public void y0() {
        z0(null);
    }

    public void z0(u7.m mVar) {
        String str;
        a0 a0Var = this.f7910j;
        if (a0Var == a0.notReady) {
            return;
        }
        if (a0Var == a0.login) {
            str = "logout is not relevant. status islogin";
        } else {
            if (this.f7912l != null) {
                a0 i02 = i0();
                H("logout");
                Y0(a0.logout);
                try {
                    this.f7912l.H(new e(mVar, i02));
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            str = "m_AndroidSDKManager is null";
        }
        H(str);
    }
}
