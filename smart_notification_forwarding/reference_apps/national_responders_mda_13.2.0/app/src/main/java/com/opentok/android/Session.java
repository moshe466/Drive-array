package com.opentok.android;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.opentok.android.BaseAudioDevice;
import com.opentok.android.h;
import com.opentok.android.i;
import com.opentok.android.j;
import com.opentok.otc.otc_session_callbacks;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;

/* loaded from: classes.dex */
public class Session extends Observable {

    /* renamed from: a, reason: collision with root package name */
    protected c f8519a;

    /* renamed from: b, reason: collision with root package name */
    protected String f8520b;

    /* renamed from: c, reason: collision with root package name */
    protected String f8521c;

    /* renamed from: d, reason: collision with root package name */
    protected URL f8522d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f8523e;

    /* renamed from: f, reason: collision with root package name */
    private com.opentok.otc.b f8524f;

    /* renamed from: g, reason: collision with root package name */
    private f f8525g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8526h = true;

    /* renamed from: i, reason: collision with root package name */
    private final j.a f8527i = new j.a(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f8528f;

        a(i iVar) {
            this.f8528f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                Session session = Session.this;
                c cVar = session.f8519a;
                if (cVar != null) {
                    cVar.a(session, this.f8528f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        Context f8530a;

        /* renamed from: b, reason: collision with root package name */
        String f8531b;

        /* renamed from: c, reason: collision with root package name */
        String f8532c;

        /* renamed from: d, reason: collision with root package name */
        URL f8533d;

        /* renamed from: e, reason: collision with root package name */
        boolean f8534e = false;

        /* renamed from: f, reason: collision with root package name */
        d f8535f = new a(this);

        /* renamed from: g, reason: collision with root package name */
        d f8536g = d.All;

        /* renamed from: h, reason: collision with root package name */
        C0136b[] f8537h = new C0136b[0];

        /* renamed from: i, reason: collision with root package name */
        c f8538i = c.All;

        /* renamed from: j, reason: collision with root package name */
        boolean f8539j = false;

        /* renamed from: k, reason: collision with root package name */
        String f8540k;

        /* loaded from: classes.dex */
        class a extends d {
            a(b bVar) {
            }
        }

        /* renamed from: com.opentok.android.Session$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0136b {
        }

        /* loaded from: classes.dex */
        public enum c {
            All(0),
            Custom(1);

            private int val;

            c(int i10) {
                this.val = i10;
            }
        }

        /* loaded from: classes.dex */
        public enum d {
            All(0),
            Relay(1);

            private int val;

            d(int i10) {
                this.val = i10;
            }
        }

        public b(Context context, String str, String str2) {
            this.f8530a = context;
            this.f8531b = str;
            this.f8532c = str2;
        }

        public Session a() {
            return new Session(this.f8530a, this.f8531b, this.f8532c, this.f8534e, this.f8535f, this.f8536g, this.f8538i, this.f8537h, this.f8533d, this.f8539j, this.f8540k);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Session session, i iVar);
    }

    /* loaded from: classes.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, Boolean> f8541a = new a(this);

        /* loaded from: classes.dex */
        class a extends HashMap<String, Boolean> {
            a(d dVar) {
                Boolean bool = Boolean.TRUE;
                put("nexus 4", bool);
                put("nexus 5", bool);
                put("nexus 5x", bool);
                put("nexus 6", bool);
                put("nexus 6p", bool);
                put("nexus 7", bool);
                put("nexus 10", bool);
                put("pixel", bool);
                put("gt-i9300", bool);
                put("samsung-sm-g925a", bool);
                put("samsung-sm-g935a", bool);
                put("samsung-sm-t817a", bool);
                put("sm-g900h", bool);
                put("sm-j106h", bool);
                put("lgus991", bool);
                put("lg-h810", bool);
                put("lg-k430", bool);
                put("xt1058", bool);
                put("aquaris e5", bool);
                put("c6602", bool);
            }
        }

        public boolean a() {
            return this.f8541a.containsKey(Build.MODEL.toLowerCase(Locale.ROOT));
        }

        public boolean b() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        boolean f8542a;

        e(boolean z10) {
            this.f8542a = z10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f8542a;
        }
    }

    /* loaded from: classes.dex */
    static class f extends otc_session_callbacks {
        public f(long j10) {
            super(j10, true);
        }

        public long c() {
            return otc_session_callbacks.b(this);
        }
    }

    static {
        g.a();
    }

    protected Session(Context context, String str, String str2, boolean z10, d dVar, b.d dVar2, b.c cVar, b.C0136b[] c0136bArr, URL url, boolean z11, String str3) {
        URL url2;
        if (com.opentok.android.a.a() == null) {
            com.opentok.android.d dVar3 = new com.opentok.android.d(context);
            dVar3.e(new BaseAudioDevice.AudioBus(dVar3));
            com.opentok.android.a.b(dVar3);
        }
        Utils.b(context, com.opentok.android.a.a(), h.b(), h.c(), h.e(), h.a());
        if (h.d() != h.a.NOT_SET) {
            set_prefer_h264(h.d() == h.a.ENABLE);
        }
        com.opentok.otc.c l10 = com.opentok.otc.d.l();
        com.opentok.otc.d.f(l10, str3);
        com.opentok.otc.d.d(l10, z10 ? 1 : 0);
        com.opentok.otc.d.j(l10, z11 ? 1 : 0);
        if (c0136bArr.length > 0) {
            String[] strArr = new String[c0136bArr.length];
            String[] strArr2 = new String[c0136bArr.length];
            String[] strArr3 = new String[c0136bArr.length];
            if (c0136bArr.length > 0) {
                b.C0136b c0136b = c0136bArr[0];
                new StringBuilder().append("Using custom ICE server ");
                throw null;
            }
            com.opentok.otc.d.e(l10, c0136bArr.length, strArr, strArr2, strArr3, dVar2.val, cVar.val);
        }
        f fVar = new f(build_native_session_cb());
        this.f8525g = fVar;
        this.f8524f = com.opentok.otc.d.g(str, str2, fVar, l10);
        com.opentok.otc.d.c(l10);
        this.f8523e = new Handler(Looper.myLooper());
        n.a(Build.VERSION.SDK_INT >= 21 && dVar.a());
        o.a(dVar.b());
        this.f8520b = str;
        this.f8521c = str2;
        if (url != null) {
            url2 = url;
        } else {
            try {
                url2 = new URL("https://api.opentok.com");
            } catch (MalformedURLException unused) {
                return;
            }
        }
        this.f8522d = url2;
    }

    public void a(String str) {
        this.f8527i.b("Connect(...) called", new Object[0]);
        String str2 = this.f8520b;
        if (str2 == null || str2.isEmpty()) {
            h(new y6.a(i.a.SessionErrorDomain, i.b.AuthorizationFailure.getErrorCode()));
            return;
        }
        String str3 = this.f8521c;
        if (str3 == null || str3.isEmpty()) {
            h(new y6.a(i.a.SessionErrorDomain, i.b.InvalidSessionId.getErrorCode()));
            return;
        }
        int b10 = com.opentok.otc.d.b(this.f8524f, this.f8522d.getHost(), this.f8522d.getPath(), this.f8522d.getPort() == -1 ? this.f8522d.getDefaultPort() : this.f8522d.getPort(), Utils.a(this.f8522d.getProtocol().equals("https")), str);
        if (b10 != z6.a.f16234c.a()) {
            h(new y6.a(i.a.SessionErrorDomain, b10));
        } else {
            if (com.opentok.android.a.a() instanceof com.opentok.android.d) {
                return;
            }
            f(1);
        }
    }

    public void b() {
        this.f8527i.b("Disconnect(...) called", new Object[0]);
        int i10 = com.opentok.otc.d.i(this.f8524f);
        if (i10 == z6.a.f16234c.a()) {
            deleteObservers();
        } else {
            h(new y6.a(i.a.SessionErrorDomain, i10));
        }
    }

    native long build_native_session_cb();

    public String c() {
        return com.opentok.otc.d.n(this.f8524f);
    }

    public void d() {
        this.f8527i.b("onPause() called", new Object[0]);
        BaseAudioDevice a10 = com.opentok.android.a.a();
        if (a10 != null) {
            a10.b();
        }
        setChanged();
        notifyObservers(new e(true));
        clearChanged();
    }

    native void destroy_native_session_cb(long j10);

    public void e() {
        this.f8527i.b("onResume() called", new Object[0]);
        BaseAudioDevice a10 = com.opentok.android.a.a();
        if (a10 != null) {
            a10.c();
        }
        setChanged();
        notifyObservers(new e(false));
        clearChanged();
    }

    void f(int i10) {
        com.opentok.otc.d.h(this.f8524f, z6.b.b(i10));
    }

    protected void finalize() {
        this.f8527i.b("finalize()", new Object[0]);
        com.opentok.otc.b bVar = this.f8524f;
        if (bVar != null && this.f8526h) {
            com.opentok.otc.d.a(bVar);
            this.f8524f = null;
            f fVar = this.f8525g;
            if (fVar != null) {
                destroy_native_session_cb(fVar.c());
            }
        }
        super.finalize();
    }

    public void g(c cVar) {
        this.f8519a = cVar;
    }

    void h(i iVar) {
        if (this.f8519a != null) {
            this.f8523e.post(new a(iVar));
        }
    }

    native void set_prefer_h264(boolean z10);
}
