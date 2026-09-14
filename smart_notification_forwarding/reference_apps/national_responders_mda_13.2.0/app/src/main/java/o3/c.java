package o3;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import b2.o;
import b2.p;
import com.google.android.gms.common.api.internal.c;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import g2.l;
import g2.m;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import r3.g;
import r3.n;
import r3.w;

/* loaded from: classes.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    private static final Object f12469i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static final Executor f12470j = new d();

    /* renamed from: k, reason: collision with root package name */
    static final Map<String, c> f12471k = new l.a();

    /* renamed from: a, reason: collision with root package name */
    private final Context f12472a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12473b;

    /* renamed from: c, reason: collision with root package name */
    private final o3.e f12474c;

    /* renamed from: d, reason: collision with root package name */
    private final n f12475d;

    /* renamed from: g, reason: collision with root package name */
    private final w<w4.a> f12478g;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f12476e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f12477f = new AtomicBoolean();

    /* renamed from: h, reason: collision with root package name */
    private final List<b> f12479h = new CopyOnWriteArrayList();

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    /* renamed from: o3.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0262c implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private static AtomicReference<C0262c> f12480a = new AtomicReference<>();

        private C0262c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (l.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f12480a.get() == null) {
                    C0262c c0262c = new C0262c();
                    if (f12480a.compareAndSet(null, c0262c)) {
                        com.google.android.gms.common.api.internal.c.c(application);
                        com.google.android.gms.common.api.internal.c.b().a(c0262c);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z10) {
            synchronized (c.f12469i) {
                Iterator it = new ArrayList(c.f12471k.values()).iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f12476e.get()) {
                        cVar.t(z10);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements Executor {

        /* renamed from: f, reason: collision with root package name */
        private static final Handler f12481f = new Handler(Looper.getMainLooper());

        private d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            f12481f.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes.dex */
    public static class e extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        private static AtomicReference<e> f12482b = new AtomicReference<>();

        /* renamed from: a, reason: collision with root package name */
        private final Context f12483a;

        public e(Context context) {
            this.f12483a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f12482b.get() == null) {
                e eVar = new e(context);
                if (f12482b.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f12483a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (c.f12469i) {
                Iterator<c> it = c.f12471k.values().iterator();
                while (it.hasNext()) {
                    it.next().l();
                }
            }
            c();
        }
    }

    protected c(Context context, String str, o3.e eVar) {
        new CopyOnWriteArrayList();
        this.f12472a = (Context) p.k(context);
        this.f12473b = p.g(str);
        this.f12474c = (o3.e) p.k(eVar);
        this.f12475d = n.e(f12470j).c(g.b(context, ComponentDiscoveryService.class).a()).b(new FirebaseCommonRegistrar()).a(r3.d.n(context, Context.class, new Class[0])).a(r3.d.n(this, c.class, new Class[0])).a(r3.d.n(eVar, o3.e.class, new Class[0])).d();
        this.f12478g = new w<>(o3.b.a(this, context));
    }

    private void e() {
        p.o(!this.f12477f.get(), "FirebaseApp was deleted");
    }

    public static c h() {
        c cVar;
        synchronized (f12469i) {
            cVar = f12471k.get("[DEFAULT]");
            if (cVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + m.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!androidx.core.os.l.a(this.f12472a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            sb2.append(i());
            e.b(this.f12472a);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Device unlocked: initializing all Firebase APIs for app ");
        sb3.append(i());
        this.f12475d.h(q());
    }

    public static c m(Context context) {
        synchronized (f12469i) {
            if (f12471k.containsKey("[DEFAULT]")) {
                return h();
            }
            o3.e a10 = o3.e.a(context);
            if (a10 == null) {
                return null;
            }
            return n(context, a10);
        }
    }

    public static c n(Context context, o3.e eVar) {
        return o(context, eVar, "[DEFAULT]");
    }

    public static c o(Context context, o3.e eVar, String str) {
        c cVar;
        C0262c.c(context);
        String s10 = s(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f12469i) {
            Map<String, c> map = f12471k;
            p.o(!map.containsKey(s10), "FirebaseApp name " + s10 + " already exists!");
            p.l(context, "Application context cannot be null.");
            cVar = new c(context, s10, eVar);
            map.put(s10, cVar);
        }
        cVar.l();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ w4.a r(c cVar, Context context) {
        return new w4.a(context, cVar.k(), (o4.c) cVar.f12475d.a(o4.c.class));
    }

    private static String s(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z10) {
        Iterator<b> it = this.f12479h.iterator();
        while (it.hasNext()) {
            it.next().a(z10);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f12473b.equals(((c) obj).i());
        }
        return false;
    }

    public <T> T f(Class<T> cls) {
        e();
        return (T) this.f12475d.a(cls);
    }

    public Context g() {
        e();
        return this.f12472a;
    }

    public int hashCode() {
        return this.f12473b.hashCode();
    }

    public String i() {
        e();
        return this.f12473b;
    }

    public o3.e j() {
        e();
        return this.f12474c;
    }

    public String k() {
        return g2.c.a(i().getBytes(Charset.defaultCharset())) + "+" + g2.c.a(j().c().getBytes(Charset.defaultCharset()));
    }

    public boolean p() {
        e();
        return this.f12478g.get().b();
    }

    public boolean q() {
        return "[DEFAULT]".equals(i());
    }

    public String toString() {
        return o.c(this).a("name", this.f12473b).a("options", this.f12474c).toString();
    }
}
