package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import w3.v;

/* loaded from: classes.dex */
public class o {

    /* renamed from: e, reason: collision with root package name */
    private static final String f7221e = String.format(Locale.US, "Crashlytics Android SDK/%s", "17.3.0");

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Integer> f7222f;

    /* renamed from: a, reason: collision with root package name */
    private final Context f7223a;

    /* renamed from: b, reason: collision with root package name */
    private final x f7224b;

    /* renamed from: c, reason: collision with root package name */
    private final b f7225c;

    /* renamed from: d, reason: collision with root package name */
    private final i4.d f7226d;

    static {
        HashMap hashMap = new HashMap();
        f7222f = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public o(Context context, x xVar, b bVar, i4.d dVar) {
        this.f7223a = context;
        this.f7224b = xVar;
        this.f7225c = bVar;
        this.f7226d = dVar;
    }

    private v.a a() {
        return w3.v.b().h("17.3.0").d(this.f7225c.f7070a).e(this.f7224b.a()).b(this.f7225c.f7074e).c(this.f7225c.f7075f).g(4);
    }

    private static int d() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = f7222f.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    private v.d.AbstractC0312d.a.b.AbstractC0314a e() {
        return v.d.AbstractC0312d.a.b.AbstractC0314a.a().b(0L).d(0L).c(this.f7225c.f7073d).e(this.f7225c.f7071b).a();
    }

    private w3.w<v.d.AbstractC0312d.a.b.AbstractC0314a> f() {
        return w3.w.f(e());
    }

    private v.d.AbstractC0312d.a g(int i10, i4.e eVar, Thread thread, int i11, int i12, boolean z10) {
        Boolean bool;
        ActivityManager.RunningAppProcessInfo k10 = h.k(this.f7225c.f7073d, this.f7223a);
        if (k10 != null) {
            bool = Boolean.valueOf(k10.importance != 100);
        } else {
            bool = null;
        }
        return v.d.AbstractC0312d.a.a().b(bool).e(i10).d(k(eVar, thread, i11, i12, z10)).a();
    }

    private v.d.AbstractC0312d.c h(int i10) {
        e a10 = e.a(this.f7223a);
        Float b10 = a10.b();
        Double valueOf = b10 != null ? Double.valueOf(b10.doubleValue()) : null;
        int c10 = a10.c();
        boolean q10 = h.q(this.f7223a);
        return v.d.AbstractC0312d.c.a().b(valueOf).c(c10).f(q10).e(i10).g(h.v() - h.a(this.f7223a)).d(h.b(Environment.getDataDirectory().getPath())).a();
    }

    private v.d.AbstractC0312d.a.b.c i(i4.e eVar, int i10, int i11) {
        return j(eVar, i10, i11, 0);
    }

    private v.d.AbstractC0312d.a.b.c j(i4.e eVar, int i10, int i11, int i12) {
        String str = eVar.f10734b;
        String str2 = eVar.f10733a;
        StackTraceElement[] stackTraceElementArr = eVar.f10735c;
        int i13 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        i4.e eVar2 = eVar.f10736d;
        if (i12 >= i11) {
            i4.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f10736d;
                i13++;
            }
        }
        v.d.AbstractC0312d.a.b.c.AbstractC0317a d10 = v.d.AbstractC0312d.a.b.c.a().f(str).e(str2).c(w3.w.c(m(stackTraceElementArr, i10))).d(i13);
        if (eVar2 != null && i13 == 0) {
            d10.b(j(eVar2, i10, i11, i12 + 1));
        }
        return d10.a();
    }

    private v.d.AbstractC0312d.a.b k(i4.e eVar, Thread thread, int i10, int i11, boolean z10) {
        return v.d.AbstractC0312d.a.b.a().e(u(eVar, thread, i10, z10)).c(i(eVar, i10, i11)).d(r()).b(f()).a();
    }

    private v.d.AbstractC0312d.a.b.e.AbstractC0321b l(StackTraceElement stackTraceElement, v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a abstractC0322a) {
        long j10 = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j10 = stackTraceElement.getLineNumber();
        }
        return abstractC0322a.e(max).f(str).b(fileName).d(j10).a();
    }

    private w3.w<v.d.AbstractC0312d.a.b.e.AbstractC0321b> m(StackTraceElement[] stackTraceElementArr, int i10) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(l(stackTraceElement, v.d.AbstractC0312d.a.b.e.AbstractC0321b.a().c(i10)));
        }
        return w3.w.c(arrayList);
    }

    private v.d.a n() {
        v.d.a.AbstractC0311a f10 = v.d.a.a().e(this.f7224b.d()).g(this.f7225c.f7074e).d(this.f7225c.f7075f).f(this.f7224b.a());
        String a10 = this.f7225c.f7076g.a();
        if (a10 != null) {
            f10.b("Unity").c(a10);
        }
        return f10.a();
    }

    private v.d o(String str, long j10) {
        return v.d.a().l(j10).i(str).g(f7221e).b(n()).k(q()).d(p()).h(3).a();
    }

    private v.d.c p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int d10 = d();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long v10 = h.v();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean A = h.A(this.f7223a);
        int n10 = h.n(this.f7223a);
        return v.d.c.a().b(d10).f(Build.MODEL).c(availableProcessors).h(v10).d(blockCount).i(A).j(n10).e(Build.MANUFACTURER).g(Build.PRODUCT).a();
    }

    private v.d.e q() {
        return v.d.e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(h.C(this.f7223a)).a();
    }

    private v.d.AbstractC0312d.a.b.AbstractC0318d r() {
        return v.d.AbstractC0312d.a.b.AbstractC0318d.a().d("0").c("0").b(0L).a();
    }

    private v.d.AbstractC0312d.a.b.e s(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return t(thread, stackTraceElementArr, 0);
    }

    private v.d.AbstractC0312d.a.b.e t(Thread thread, StackTraceElement[] stackTraceElementArr, int i10) {
        return v.d.AbstractC0312d.a.b.e.a().d(thread.getName()).c(i10).b(w3.w.c(m(stackTraceElementArr, i10))).a();
    }

    private w3.w<v.d.AbstractC0312d.a.b.e> u(i4.e eVar, Thread thread, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(thread, eVar.f10735c, i10));
        if (z10) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(s(key, this.f7226d.a(entry.getValue())));
                }
            }
        }
        return w3.w.c(arrayList);
    }

    public v.d.AbstractC0312d b(Throwable th, Thread thread, String str, long j10, int i10, int i11, boolean z10) {
        int i12 = this.f7223a.getResources().getConfiguration().orientation;
        return v.d.AbstractC0312d.a().f(str).e(j10).b(g(i12, new i4.e(th, this.f7226d), thread, i10, i11, z10)).c(h(i12)).a();
    }

    public w3.v c(String str, long j10) {
        return a().i(o(str, j10)).a();
    }
}
