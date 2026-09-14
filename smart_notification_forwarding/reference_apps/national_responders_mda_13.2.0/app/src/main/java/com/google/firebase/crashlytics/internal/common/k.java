package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import b4.b;
import c4.c;
import com.google.firebase.crashlytics.internal.common.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v3.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7110a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.common.s f7111b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.common.n f7112c;

    /* renamed from: d, reason: collision with root package name */
    private final i0 f7113d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.common.i f7114e;

    /* renamed from: f, reason: collision with root package name */
    private final y3.c f7115f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.common.x f7116g;

    /* renamed from: h, reason: collision with root package name */
    private final z3.h f7117h;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.firebase.crashlytics.internal.common.b f7118i;

    /* renamed from: j, reason: collision with root package name */
    private final b.InterfaceC0068b f7119j;

    /* renamed from: k, reason: collision with root package name */
    private final z f7120k;

    /* renamed from: l, reason: collision with root package name */
    private final v3.b f7121l;

    /* renamed from: m, reason: collision with root package name */
    private final b4.a f7122m;

    /* renamed from: n, reason: collision with root package name */
    private final b.a f7123n;

    /* renamed from: o, reason: collision with root package name */
    private final s3.a f7124o;

    /* renamed from: p, reason: collision with root package name */
    private final i4.d f7125p;

    /* renamed from: q, reason: collision with root package name */
    private final String f7126q;

    /* renamed from: r, reason: collision with root package name */
    private final t3.a f7127r;

    /* renamed from: s, reason: collision with root package name */
    private final g0 f7128s;

    /* renamed from: t, reason: collision with root package name */
    private com.google.firebase.crashlytics.internal.common.q f7129t;

    /* renamed from: u, reason: collision with root package name */
    z2.m<Boolean> f7130u;

    /* renamed from: v, reason: collision with root package name */
    z2.m<Boolean> f7131v;

    /* renamed from: w, reason: collision with root package name */
    z2.m<Void> f7132w;

    /* renamed from: x, reason: collision with root package name */
    static final FilenameFilter f7107x = new i("BeginSession");

    /* renamed from: y, reason: collision with root package name */
    static final FilenameFilter f7108y = com.google.firebase.crashlytics.internal.common.j.a();

    /* renamed from: z, reason: collision with root package name */
    static final FilenameFilter f7109z = new n();
    static final Comparator<File> A = new o();
    static final Comparator<File> B = new p();
    private static final Pattern C = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> D = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] E = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f7133a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7134b;

        a(long j10, String str) {
            this.f7133a = j10;
            this.f7134b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            if (k.this.h0()) {
                return null;
            }
            k.this.f7121l.i(this.f7133a, this.f7134b);
            return null;
        }
    }

    /* loaded from: classes.dex */
    private final class a0 implements b.c {
        private a0() {
        }

        /* synthetic */ a0(k kVar, i iVar) {
            this();
        }

        @Override // b4.b.c
        public File[] a() {
            return k.this.n0();
        }

        @Override // b4.b.c
        public File[] b() {
            return k.this.k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i0 f7137a;

        b(i0 i0Var) {
            this.f7137a = i0Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            String V = k.this.V();
            if (V == null) {
                s3.b.f().b("Tried to cache user data while no session was open.");
                return null;
            }
            k.this.f7128s.k(k.t0(V));
            new com.google.firebase.crashlytics.internal.common.a0(k.this.Y()).g(V, this.f7137a);
            return null;
        }
    }

    /* loaded from: classes.dex */
    private final class b0 implements b.a {
        private b0() {
        }

        /* synthetic */ b0(k kVar, i iVar) {
            this();
        }

        @Override // b4.b.a
        public boolean a() {
            return k.this.h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Callable<Void> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            k.this.L();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c0 implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final Context f7141f;

        /* renamed from: g, reason: collision with root package name */
        private final c4.c f7142g;

        /* renamed from: h, reason: collision with root package name */
        private final b4.b f7143h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f7144i;

        public c0(Context context, c4.c cVar, b4.b bVar, boolean z10) {
            this.f7141f = context;
            this.f7142g = cVar;
            this.f7143h = bVar;
            this.f7144i = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.google.firebase.crashlytics.internal.common.h.c(this.f7141f)) {
                s3.b.f().b("Attempting to send crash report at time of crash...");
                this.f7143h.d(this.f7142g, this.f7144i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            kVar.I(kVar.m0(new y()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d0 implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        private final String f7146a;

        public d0(String str) {
            this.f7146a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f7146a);
            sb2.append(".cls");
            return (str.equals(sb2.toString()) || !str.contains(this.f7146a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f7147a;

        e(k kVar, Set set) {
            this.f7147a = set;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (str.length() < 35) {
                return false;
            }
            return this.f7147a.contains(str.substring(0, 35));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7148a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7149b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f7150c;

        f(k kVar, String str, String str2, long j10) {
            this.f7148a = str;
            this.f7149b = str2;
            this.f7150c = j10;
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.w
        public void a(a4.c cVar) {
            a4.d.p(cVar, this.f7148a, this.f7149b, this.f7150c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7151a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7152b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7153c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f7154d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f7155e;

        g(String str, String str2, String str3, String str4, int i10) {
            this.f7151a = str;
            this.f7152b = str2;
            this.f7153c = str3;
            this.f7154d = str4;
            this.f7155e = i10;
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.w
        public void a(a4.c cVar) {
            a4.d.r(cVar, this.f7151a, this.f7152b, this.f7153c, this.f7154d, this.f7155e, k.this.f7126q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7157a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7158b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f7159c;

        h(k kVar, String str, String str2, boolean z10) {
            this.f7157a = str;
            this.f7158b = str2;
            this.f7159c = z10;
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.w
        public void a(a4.c cVar) {
            a4.d.B(cVar, this.f7157a, this.f7158b, this.f7159c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends x {
        i(String str) {
            super(str);
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.x, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7160a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7161b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7162c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f7163d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f7164e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f7165f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7166g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f7167h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f7168i;

        j(k kVar, int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
            this.f7160a = i10;
            this.f7161b = str;
            this.f7162c = i11;
            this.f7163d = j10;
            this.f7164e = j11;
            this.f7165f = z10;
            this.f7166g = i12;
            this.f7167h = str2;
            this.f7168i = str3;
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.w
        public void a(a4.c cVar) {
            a4.d.t(cVar, this.f7160a, this.f7161b, this.f7162c, this.f7163d, this.f7164e, this.f7165f, this.f7166g, this.f7167h, this.f7168i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.crashlytics.internal.common.k$k, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0089k implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i0 f7169a;

        C0089k(k kVar, i0 i0Var) {
            this.f7169a = i0Var;
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.w
        public void a(a4.c cVar) {
            a4.d.C(cVar, this.f7169a.b(), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7170a;

        l(String str) {
            this.f7170a = str;
        }

        @Override // com.google.firebase.crashlytics.internal.common.k.w
        public void a(a4.c cVar) {
            a4.d.s(cVar, this.f7170a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f7171a;

        m(long j10) {
            this.f7171a = j10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", this.f7171a);
            k.this.f7127r.a("_ae", bundle);
            return null;
        }
    }

    /* loaded from: classes.dex */
    class n implements FilenameFilter {
        n() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* loaded from: classes.dex */
    class o implements Comparator<File> {
        o() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* loaded from: classes.dex */
    class p implements Comparator<File> {
        p() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements q.a {
        q() {
        }

        @Override // com.google.firebase.crashlytics.internal.common.q.a
        public void a(f4.e eVar, Thread thread, Throwable th) {
            k.this.g0(eVar, thread, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r implements Callable<z2.l<Void>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Date f7174a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable f7175b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Thread f7176c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f4.e f7177d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements z2.k<g4.b, Void> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Executor f7179a;

            a(Executor executor) {
                this.f7179a = executor;
            }

            @Override // z2.k
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public z2.l<Void> a(g4.b bVar) {
                if (bVar == null) {
                    s3.b.f().i("Received null app settings, cannot send reports at crash time.");
                    return z2.o.e(null);
                }
                k.this.w0(bVar, true);
                return z2.o.g(k.this.s0(), k.this.f7128s.m(this.f7179a, com.google.firebase.crashlytics.internal.common.t.getState(bVar)));
            }
        }

        r(Date date, Throwable th, Thread thread, f4.e eVar) {
            this.f7174a = date;
            this.f7175b = th;
            this.f7176c = thread;
            this.f7177d = eVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z2.l<Void> call() {
            long d02 = k.d0(this.f7174a);
            String V = k.this.V();
            if (V == null) {
                s3.b.f().d("Tried to write a fatal exception while no session was open.");
                return z2.o.e(null);
            }
            k.this.f7112c.a();
            k.this.f7128s.j(this.f7175b, this.f7176c, k.t0(V), d02);
            k.this.N(this.f7176c, this.f7175b, V, d02);
            k.this.M(this.f7174a.getTime());
            g4.e b10 = this.f7177d.b();
            int i10 = b10.a().f9785a;
            int i11 = b10.a().f9786b;
            k.this.J(i10);
            k.this.L();
            k.this.C0(i11);
            if (!k.this.f7111b.d()) {
                return z2.o.e(null);
            }
            Executor c10 = k.this.f7114e.c();
            return this.f7177d.a().q(c10, new a(c10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s implements z2.k<Void, Boolean> {
        s(k kVar) {
        }

        @Override // z2.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public z2.l<Boolean> a(Void r12) {
            return z2.o.e(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t implements z2.k<Boolean, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z2.l f7181a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f7182b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Callable<z2.l<Void>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Boolean f7184a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.google.firebase.crashlytics.internal.common.k$t$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0090a implements z2.k<g4.b, Void> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ List f7186a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ boolean f7187b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ Executor f7188c;

                C0090a(List list, boolean z10, Executor executor) {
                    this.f7186a = list;
                    this.f7187b = z10;
                    this.f7188c = executor;
                }

                @Override // z2.k
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public z2.l<Void> a(g4.b bVar) {
                    if (bVar == null) {
                        s3.b.f().i("Received null app settings, cannot send reports during app startup.");
                    } else {
                        for (c4.c cVar : this.f7186a) {
                            if (cVar.b() == c.a.JAVA) {
                                k.y(bVar.f9780e, cVar.f());
                            }
                        }
                        k.this.s0();
                        k.this.f7119j.a(bVar).e(this.f7186a, this.f7187b, t.this.f7182b);
                        k.this.f7128s.m(this.f7188c, com.google.firebase.crashlytics.internal.common.t.getState(bVar));
                        k.this.f7132w.e(null);
                    }
                    return z2.o.e(null);
                }
            }

            a(Boolean bool) {
                this.f7184a = bool;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public z2.l<Void> call() {
                List<c4.c> d10 = k.this.f7122m.d();
                if (this.f7184a.booleanValue()) {
                    s3.b.f().b("Reports are being sent.");
                    boolean booleanValue = this.f7184a.booleanValue();
                    k.this.f7111b.c(booleanValue);
                    Executor c10 = k.this.f7114e.c();
                    return t.this.f7181a.q(c10, new C0090a(d10, booleanValue, c10));
                }
                s3.b.f().b("Reports are being deleted.");
                k.G(k.this.j0());
                k.this.f7122m.c(d10);
                k.this.f7128s.l();
                k.this.f7132w.e(null);
                return z2.o.e(null);
            }
        }

        t(z2.l lVar, float f10) {
            this.f7181a = lVar;
            this.f7182b = f10;
        }

        @Override // z2.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public z2.l<Void> a(Boolean bool) {
            return k.this.f7114e.i(new a(bool));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u implements b.InterfaceC0068b {
        u() {
        }

        @Override // b4.b.InterfaceC0068b
        public b4.b a(g4.b bVar) {
            String str = bVar.f9778c;
            String str2 = bVar.f9779d;
            return new b4.b(bVar.f9780e, k.this.f7118i.f7070a, com.google.firebase.crashlytics.internal.common.t.getState(bVar), k.this.f7122m, k.this.U(str, str2), k.this.f7123n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class v implements FilenameFilter {
        private v() {
        }

        /* synthetic */ v(i iVar) {
            this();
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !k.f7109z.accept(file, str) && k.C.matcher(str).matches();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface w {
        void a(a4.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class x implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        private final String f7191a;

        public x(String str) {
            this.f7191a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f7191a) && !str.endsWith(".cls_temp");
        }
    }

    /* loaded from: classes.dex */
    static class y implements FilenameFilter {
        y() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return a4.b.f181i.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class z implements b.InterfaceC0301b {

        /* renamed from: a, reason: collision with root package name */
        private final z3.h f7192a;

        public z(z3.h hVar) {
            this.f7192a = hVar;
        }

        @Override // v3.b.InterfaceC0301b
        public File a() {
            File file = new File(this.f7192a.b(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, com.google.firebase.crashlytics.internal.common.i iVar, y3.c cVar, com.google.firebase.crashlytics.internal.common.x xVar, com.google.firebase.crashlytics.internal.common.s sVar, z3.h hVar, com.google.firebase.crashlytics.internal.common.n nVar, com.google.firebase.crashlytics.internal.common.b bVar, b4.a aVar, b.InterfaceC0068b interfaceC0068b, s3.a aVar2, t3.a aVar3, f4.e eVar) {
        b.InterfaceC0068b interfaceC0068b2 = interfaceC0068b;
        new AtomicInteger(0);
        this.f7130u = new z2.m<>();
        this.f7131v = new z2.m<>();
        this.f7132w = new z2.m<>();
        new AtomicBoolean(false);
        this.f7110a = context;
        this.f7114e = iVar;
        this.f7115f = cVar;
        this.f7116g = xVar;
        this.f7111b = sVar;
        this.f7117h = hVar;
        this.f7112c = nVar;
        this.f7118i = bVar;
        this.f7119j = interfaceC0068b2 == null ? F() : interfaceC0068b2;
        this.f7124o = aVar2;
        this.f7126q = bVar.f7076g.a();
        this.f7127r = aVar3;
        i0 i0Var = new i0();
        this.f7113d = i0Var;
        z zVar = new z(hVar);
        this.f7120k = zVar;
        v3.b bVar2 = new v3.b(context, zVar);
        this.f7121l = bVar2;
        i iVar2 = null;
        this.f7122m = aVar == null ? new b4.a(new a0(this, iVar2)) : aVar;
        this.f7123n = new b0(this, iVar2);
        i4.a aVar4 = new i4.a(1024, new i4.c(10));
        this.f7125p = aVar4;
        this.f7128s = g0.b(context, xVar, hVar, bVar, bVar2, i0Var, aVar4, eVar);
    }

    private void A(i0 i0Var) {
        this.f7114e.h(new b(i0Var));
    }

    private void A0(int i10) {
        HashSet hashSet = new HashSet();
        File[] q02 = q0();
        int min = Math.min(i10, q02.length);
        for (int i11 = 0; i11 < min; i11++) {
            hashSet.add(c0(q02[i11]));
        }
        this.f7121l.b(hashSet);
        v0(m0(new v(null)), hashSet);
    }

    private void B0(String str, int i10) {
        k0.d(Y(), new x(str + "SessionEvent"), i10, B);
    }

    private void C(File[] fileArr, int i10, int i11) {
        s3.b.f().b("Closing open sessions.");
        while (i10 < fileArr.length) {
            File file = fileArr[i10];
            String c02 = c0(file);
            s3.b.f().b("Closing session: " + c02);
            M0(file, c02, i11);
            i10++;
        }
    }

    private void D(a4.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            bVar.c();
        } catch (IOException e10) {
            s3.b.f().e("Error closing session file stream in the presence of an exception", e10);
        }
    }

    private z2.l<Boolean> D0() {
        if (this.f7111b.d()) {
            s3.b.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f7130u.e(Boolean.FALSE);
            return z2.o.e(Boolean.TRUE);
        }
        s3.b.f().b("Automatic data collection is disabled.");
        s3.b.f().b("Notifying that unsent reports are available.");
        this.f7130u.e(Boolean.TRUE);
        z2.l<TContinuationResult> r10 = this.f7111b.g().r(new s(this));
        s3.b.f().b("Waiting for send/deleteUnsentReports to be called.");
        return k0.h(r10, this.f7131v.a());
    }

    private static void E(InputStream inputStream, a4.c cVar, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int read = inputStream.read(bArr, i11, i10 - i11);
            if (read < 0) {
                break;
            } else {
                i11 += read;
            }
        }
        cVar.X(bArr);
    }

    private void E0(String str, long j10) {
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", com.google.firebase.crashlytics.internal.common.m.i());
        L0(str, "BeginSession", new f(this, str, format, j10));
        this.f7124o.e(str, format, j10);
    }

    private b.InterfaceC0068b F() {
        return new u();
    }

    private void F0(a4.c cVar, String str) {
        for (String str2 : E) {
            File[] m02 = m0(new x(str + str2 + ".cls"));
            if (m02.length == 0) {
                s3.b.f().b("Can't find " + str2 + " data for session ID " + str);
            } else {
                s3.b.f().b("Collecting " + str2 + " data for session ID " + str);
                O0(cVar, m02[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            file.delete();
        }
    }

    private static void G0(a4.c cVar, File[] fileArr, String str) {
        Arrays.sort(fileArr, com.google.firebase.crashlytics.internal.common.h.f7095c);
        for (File file : fileArr) {
            try {
                s3.b.f().b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                O0(cVar, file);
            } catch (Exception e10) {
                s3.b.f().e("Error writting non-fatal to session.", e10);
            }
        }
    }

    private void H0(String str) {
        String d10 = this.f7116g.d();
        com.google.firebase.crashlytics.internal.common.b bVar = this.f7118i;
        String str2 = bVar.f7074e;
        String str3 = bVar.f7075f;
        String a10 = this.f7116g.a();
        int id = com.google.firebase.crashlytics.internal.common.u.determineFrom(this.f7118i.f7072c).getId();
        L0(str, "SessionApp", new g(d10, str2, str3, a10, id));
        this.f7124o.d(str, d10, str2, str3, a10, id, this.f7126q);
    }

    private void I0(String str) {
        Context T = T();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int m10 = com.google.firebase.crashlytics.internal.common.h.m();
        String str2 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long v10 = com.google.firebase.crashlytics.internal.common.h.v();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean A2 = com.google.firebase.crashlytics.internal.common.h.A(T);
        int n10 = com.google.firebase.crashlytics.internal.common.h.n(T);
        String str3 = Build.MANUFACTURER;
        String str4 = Build.PRODUCT;
        L0(str, "SessionDevice", new j(this, m10, str2, availableProcessors, v10, blockCount, A2, n10, str3, str4));
        this.f7124o.c(str, m10, str2, availableProcessors, v10, blockCount, A2, n10, str3, str4);
    }

    private void J0(a4.c cVar, Thread thread, Throwable th, long j10, String str, boolean z10) {
        Thread[] threadArr;
        Map<String, String> a10;
        Map<String, String> treeMap;
        i4.e eVar = new i4.e(th, this.f7125p);
        Context T = T();
        com.google.firebase.crashlytics.internal.common.e a11 = com.google.firebase.crashlytics.internal.common.e.a(T);
        Float b10 = a11.b();
        int c10 = a11.c();
        boolean q10 = com.google.firebase.crashlytics.internal.common.h.q(T);
        int i10 = T.getResources().getConfiguration().orientation;
        long v10 = com.google.firebase.crashlytics.internal.common.h.v() - com.google.firebase.crashlytics.internal.common.h.a(T);
        long b11 = com.google.firebase.crashlytics.internal.common.h.b(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo k10 = com.google.firebase.crashlytics.internal.common.h.k(T.getPackageName(), T);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = eVar.f10735c;
        String str2 = this.f7118i.f7071b;
        String d10 = this.f7116g.d();
        int i11 = 0;
        if (z10) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i11] = entry.getKey();
                linkedList.add(this.f7125p.a(entry.getValue()));
                i11++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (com.google.firebase.crashlytics.internal.common.h.l(T, "com.crashlytics.CollectCustomKeys", true)) {
            a10 = this.f7113d.a();
            if (a10 != null && a10.size() > 1) {
                treeMap = new TreeMap(a10);
                a4.d.u(cVar, j10, str, eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.f7121l.c(), k10, i10, d10, str2, b10, c10, q10, v10, b11);
                this.f7121l.a();
            }
        } else {
            a10 = new TreeMap<>();
        }
        treeMap = a10;
        a4.d.u(cVar, j10, str, eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.f7121l.c(), k10, i10, d10, str2, b10, c10, q10, v10, b11);
        this.f7121l.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K(int i10, boolean z10) {
        A0((z10 ? 1 : 0) + 8);
        File[] q02 = q0();
        if (q02.length <= z10) {
            s3.b.f().b("No open sessions to be closed.");
            return;
        }
        String c02 = c0(q02[z10 ? 1 : 0]);
        N0(c02);
        if (this.f7124o.h(c02)) {
            Q(c02);
            if (!this.f7124o.a(c02)) {
                s3.b.f().b("Could not finalize native session: " + c02);
            }
        }
        C(q02, z10 ? 1 : 0, i10);
        this.f7128s.d(W(), z10 != 0 ? t0(c0(q02[0])) : null);
    }

    private void K0(String str) {
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.VERSION.CODENAME;
        boolean C2 = com.google.firebase.crashlytics.internal.common.h.C(T());
        L0(str, "SessionOS", new h(this, str2, str3, C2));
        this.f7124o.f(str, str2, str3, C2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        long W = W();
        String gVar = new com.google.firebase.crashlytics.internal.common.g(this.f7116g).toString();
        s3.b.f().b("Opening a new session with ID " + gVar);
        this.f7124o.g(gVar);
        E0(gVar, W);
        H0(gVar);
        K0(gVar);
        I0(gVar);
        this.f7121l.g(gVar);
        this.f7128s.g(t0(gVar), W);
    }

    private void L0(String str, String str2, w wVar) {
        a4.b bVar;
        a4.c cVar = null;
        try {
            bVar = new a4.b(Y(), str + str2);
            try {
                cVar = a4.c.D(bVar);
                wVar.a(cVar);
                com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to session " + str2 + " file.");
                com.google.firebase.crashlytics.internal.common.h.e(bVar, "Failed to close session " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to session " + str2 + " file.");
                com.google.firebase.crashlytics.internal.common.h.e(bVar, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(long j10) {
        try {
            new File(Y(), ".ae" + j10).createNewFile();
        } catch (IOException unused) {
            s3.b.f().b("Could not write app exception marker.");
        }
    }

    private void M0(File file, String str, int i10) {
        s3.b.f().b("Collecting session parts for ID " + str);
        File[] m02 = m0(new x(str + "SessionCrash"));
        boolean z10 = m02 != null && m02.length > 0;
        s3.b f10 = s3.b.f();
        Locale locale = Locale.US;
        f10.b(String.format(locale, "Session %s has fatal exception: %s", str, Boolean.valueOf(z10)));
        File[] m03 = m0(new x(str + "SessionEvent"));
        boolean z11 = m03 != null && m03.length > 0;
        s3.b.f().b(String.format(locale, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z11)));
        if (z10 || z11) {
            z0(file, str, e0(str, m03, i10), z10 ? m02[0] : null);
        } else {
            s3.b.f().b("No events present for session ID " + str);
        }
        s3.b.f().b("Removing session part files for ID " + str);
        G(p0(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Thread thread, Throwable th, String str, long j10) {
        a4.b bVar;
        a4.c cVar = null;
        try {
            try {
                bVar = new a4.b(Y(), str + "SessionCrash");
                try {
                    cVar = a4.c.D(bVar);
                    J0(cVar, thread, th, j10, "crash", true);
                } catch (Exception e10) {
                    e = e10;
                    s3.b.f().e("An error occurred in the fatal exception logger", e);
                    com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to session begin file.");
                    com.google.firebase.crashlytics.internal.common.h.e(bVar, "Failed to close fatal exception file output stream.");
                }
            } catch (Throwable th2) {
                th = th2;
                com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to session begin file.");
                com.google.firebase.crashlytics.internal.common.h.e(bVar, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            bVar = null;
        } catch (Throwable th3) {
            th = th3;
            bVar = null;
            com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to session begin file.");
            com.google.firebase.crashlytics.internal.common.h.e(bVar, "Failed to close fatal exception file output stream.");
            throw th;
        }
        com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to session begin file.");
        com.google.firebase.crashlytics.internal.common.h.e(bVar, "Failed to close fatal exception file output stream.");
    }

    private void N0(String str) {
        L0(str, "SessionUser", new C0089k(this, f0(str)));
    }

    private static void O0(a4.c cVar, File file) {
        if (!file.exists()) {
            s3.b.f().d("Tried to include a file that doesn't exist: " + file.getName());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                E(fileInputStream2, cVar, (int) file.length());
                com.google.firebase.crashlytics.internal.common.h.e(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                com.google.firebase.crashlytics.internal.common.h.e(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static File[] P(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void Q(String str) {
        s3.b.f().b("Finalizing native report for session " + str);
        s3.d b10 = this.f7124o.b(str);
        File d10 = b10.d();
        if (d10 == null || !d10.exists()) {
            s3.b.f().i("No minidump data found for session " + str);
            return;
        }
        long lastModified = d10.lastModified();
        v3.b bVar = new v3.b(this.f7110a, this.f7120k, str);
        File file = new File(a0(), str);
        if (!file.mkdirs()) {
            s3.b.f().b("Couldn't create native sessions directory");
            return;
        }
        M(lastModified);
        List<com.google.firebase.crashlytics.internal.common.b0> Z = Z(b10, str, T(), Y(), bVar.c());
        com.google.firebase.crashlytics.internal.common.c0.b(file, Z);
        this.f7128s.c(t0(str), Z);
        bVar.a();
    }

    private static boolean S() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private Context T() {
        return this.f7110a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d4.b U(String str, String str2) {
        String u10 = com.google.firebase.crashlytics.internal.common.h.u(T(), "com.crashlytics.ApiEndpoint");
        return new d4.a(new d4.c(u10, str, this.f7115f, com.google.firebase.crashlytics.internal.common.m.i()), new d4.d(u10, str2, this.f7115f, com.google.firebase.crashlytics.internal.common.m.i()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String V() {
        File[] q02 = q0();
        if (q02.length > 0) {
            return c0(q02[0]);
        }
        return null;
    }

    private static long W() {
        return d0(new Date());
    }

    static List<com.google.firebase.crashlytics.internal.common.b0> Z(s3.d dVar, String str, Context context, File file, byte[] bArr) {
        com.google.firebase.crashlytics.internal.common.a0 a0Var = new com.google.firebase.crashlytics.internal.common.a0(file);
        File b10 = a0Var.b(str);
        File a10 = a0Var.a(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.google.firebase.crashlytics.internal.common.f("logs_file", "logs", bArr));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("crash_meta_file", "metadata", dVar.f()));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("session_meta_file", "session", dVar.e()));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("app_meta_file", "app", dVar.a()));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("device_meta_file", "device", dVar.c()));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("os_meta_file", "os", dVar.b()));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("minidump_file", "minidump", dVar.d()));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("user_meta_file", "user", b10));
        arrayList.add(new com.google.firebase.crashlytics.internal.common.w("keys_file", "keys", a10));
        return arrayList;
    }

    static String c0(File file) {
        return file.getName().substring(0, 35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long d0(Date date) {
        return date.getTime() / 1000;
    }

    private File[] e0(String str, File[] fileArr, int i10) {
        if (fileArr.length <= i10) {
            return fileArr;
        }
        s3.b.f().b(String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i10)));
        B0(str, i10);
        return m0(new x(str + "SessionEvent"));
    }

    private i0 f0(String str) {
        return h0() ? this.f7113d : new com.google.firebase.crashlytics.internal.common.a0(Y()).d(str);
    }

    private static File[] l0(File file, FilenameFilter filenameFilter) {
        return P(file.listFiles(filenameFilter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] m0(FilenameFilter filenameFilter) {
        return l0(Y(), filenameFilter);
    }

    private File[] p0(String str) {
        return m0(new d0(str));
    }

    private File[] q0() {
        File[] o02 = o0();
        Arrays.sort(o02, A);
        return o02;
    }

    private z2.l<Void> r0(long j10) {
        if (!S()) {
            return z2.o.c(new ScheduledThreadPoolExecutor(1), new m(j10));
        }
        s3.b.f().b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
        return z2.o.e(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z2.l<Void> s0() {
        ArrayList arrayList = new ArrayList();
        for (File file : j0()) {
            try {
                arrayList.add(r0(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                s3.b.f().b("Could not parse timestamp from file " + file.getName());
            }
            file.delete();
        }
        return z2.o.f(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t0(String str) {
        return str.replaceAll("-", "");
    }

    private void v0(File[] fileArr, Set<String> set) {
        s3.b f10;
        StringBuilder sb2;
        String str;
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = C.matcher(name);
            if (!matcher.matches()) {
                f10 = s3.b.f();
                sb2 = new StringBuilder();
                str = "Deleting unknown file: ";
            } else if (!set.contains(matcher.group(1))) {
                f10 = s3.b.f();
                sb2 = new StringBuilder();
                str = "Trimming session file: ";
            }
            sb2.append(str);
            sb2.append(name);
            f10.b(sb2.toString());
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(g4.b bVar, boolean z10) {
        Context T = T();
        b4.b a10 = this.f7119j.a(bVar);
        for (File file : k0()) {
            y(bVar.f9780e, file);
            this.f7114e.g(new c0(T, new c4.d(file, D), a10, z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(String str, File file) {
        if (str == null) {
            return;
        }
        z(file, new l(str));
    }

    private static void z(File file, w wVar) {
        FileOutputStream fileOutputStream;
        a4.c cVar = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            cVar = a4.c.D(fileOutputStream);
            wVar.a(cVar);
            com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to append to " + file.getPath());
            com.google.firebase.crashlytics.internal.common.h.e(fileOutputStream, "Failed to close " + file.getPath());
        } catch (Throwable th2) {
            th = th2;
            com.google.firebase.crashlytics.internal.common.h.j(cVar, "Failed to flush to append to " + file.getPath());
            com.google.firebase.crashlytics.internal.common.h.e(fileOutputStream, "Failed to close " + file.getPath());
            throw th;
        }
    }

    private void z0(File file, String str, File[] fileArr, File file2) {
        a4.b bVar;
        boolean z10 = file2 != null;
        File X = z10 ? X() : b0();
        if (!X.exists()) {
            X.mkdirs();
        }
        a4.c cVar = null;
        try {
            try {
                bVar = new a4.b(X, str);
                try {
                    cVar = a4.c.D(bVar);
                    s3.b.f().b("Collecting SessionStart data for session ID " + str);
                    O0(cVar, file);
                    cVar.h0(4, W());
                    cVar.H(5, z10);
                    cVar.f0(11, 1);
                    cVar.M(12, 3);
                    F0(cVar, str);
                    G0(cVar, fileArr, str);
                    if (z10) {
                        O0(cVar, file2);
                    }
                    com.google.firebase.crashlytics.internal.common.h.j(cVar, "Error flushing session file stream");
                    com.google.firebase.crashlytics.internal.common.h.e(bVar, "Failed to close CLS file");
                } catch (Exception e10) {
                    e = e10;
                    s3.b.f().e("Failed to write session file for session ID: " + str, e);
                    com.google.firebase.crashlytics.internal.common.h.j(cVar, "Error flushing session file stream");
                    D(bVar);
                }
            } catch (Throwable th) {
                th = th;
                com.google.firebase.crashlytics.internal.common.h.j(null, "Error flushing session file stream");
                com.google.firebase.crashlytics.internal.common.h.e(null, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            bVar = null;
        } catch (Throwable th2) {
            th = th2;
            com.google.firebase.crashlytics.internal.common.h.j(null, "Error flushing session file stream");
            com.google.firebase.crashlytics.internal.common.h.e(null, "Failed to close CLS file");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.f7114e.g(new d());
    }

    void C0(int i10) {
        File a02 = a0();
        File X = X();
        Comparator<File> comparator = B;
        int f10 = i10 - k0.f(a02, X, i10, comparator);
        k0.d(Y(), f7109z, f10 - k0.c(b0(), f10, comparator), comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H() {
        if (!this.f7112c.c()) {
            String V = V();
            return V != null && this.f7124o.h(V);
        }
        s3.b.f().b("Found previous crash marker.");
        this.f7112c.d();
        return true;
    }

    void I(File[] fileArr) {
        HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            s3.b.f().b("Found invalid session part file: " + file);
            hashSet.add(c0(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (File file2 : m0(new e(this, hashSet))) {
            s3.b.f().b("Deleting invalid session file: " + file2);
            file2.delete();
        }
    }

    void J(int i10) {
        K(i10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, f4.e eVar) {
        u0();
        com.google.firebase.crashlytics.internal.common.q qVar = new com.google.firebase.crashlytics.internal.common.q(new q(), eVar, uncaughtExceptionHandler);
        this.f7129t = qVar;
        Thread.setDefaultUncaughtExceptionHandler(qVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0(long j10, String str) {
        this.f7114e.h(new a(j10, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R(int i10) {
        this.f7114e.b();
        if (h0()) {
            s3.b.f().b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        s3.b.f().b("Finalizing previously open sessions.");
        try {
            K(i10, true);
            s3.b.f().b("Closed all previously open sessions");
            return true;
        } catch (Exception e10) {
            s3.b.f().e("Unable to finalize previously open sessions.", e10);
            return false;
        }
    }

    File X() {
        return new File(Y(), "fatal-sessions");
    }

    File Y() {
        return this.f7117h.b();
    }

    File a0() {
        return new File(Y(), "native-sessions");
    }

    File b0() {
        return new File(Y(), "nonfatal-sessions");
    }

    synchronized void g0(f4.e eVar, Thread thread, Throwable th) {
        s3.b.f().b("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        try {
            k0.a(this.f7114e.i(new r(new Date(), th, thread, eVar)));
        } catch (Exception unused) {
        }
    }

    boolean h0() {
        com.google.firebase.crashlytics.internal.common.q qVar = this.f7129t;
        return qVar != null && qVar.a();
    }

    File[] j0() {
        return m0(f7108y);
    }

    File[] k0() {
        LinkedList linkedList = new LinkedList();
        File X = X();
        FilenameFilter filenameFilter = f7109z;
        Collections.addAll(linkedList, l0(X, filenameFilter));
        Collections.addAll(linkedList, l0(b0(), filenameFilter));
        Collections.addAll(linkedList, l0(Y(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] n0() {
        return P(a0().listFiles());
    }

    File[] o0() {
        return m0(f7107x);
    }

    void u0() {
        this.f7114e.h(new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0(String str) {
        this.f7113d.d(str);
        A(this.f7113d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z2.l<Void> y0(float f10, z2.l<g4.b> lVar) {
        if (this.f7122m.a()) {
            s3.b.f().b("Unsent reports are available.");
            return D0().r(new t(lVar, f10));
        }
        s3.b.f().b("No reports are available.");
        this.f7130u.e(Boolean.FALSE);
        return z2.o.e(null);
    }
}
