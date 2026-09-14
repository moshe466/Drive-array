package a4;

import android.app.ActivityManager;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final a f189a = a.c("0");

    /* renamed from: b, reason: collision with root package name */
    private static final a f190b = a.c("Unity");

    private static void A(c cVar, a aVar) {
        if (aVar != null) {
            cVar.e0(6, 2);
            cVar.a0(h(aVar));
            cVar.J(1, aVar);
        }
    }

    public static void B(c cVar, String str, String str2, boolean z10) {
        a c10 = a.c(str);
        a c11 = a.c(str2);
        cVar.e0(8, 2);
        cVar.a0(m(c10, c11, z10));
        cVar.M(1, 3);
        cVar.J(2, c10);
        cVar.J(3, c11);
        cVar.H(4, z10);
    }

    public static void C(c cVar, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        a c10 = a.c(str);
        a o10 = o(str2);
        a o11 = o(str3);
        int f10 = c.f(1, c10) + 0;
        if (str2 != null) {
            f10 += c.f(2, o10);
        }
        if (str3 != null) {
            f10 += c.f(3, o11);
        }
        cVar.e0(6, 2);
        cVar.a0(f10);
        cVar.J(1, c10);
        if (str2 != null) {
            cVar.J(2, o10);
        }
        if (str3 != null) {
            cVar.J(3, o11);
        }
    }

    private static void D(c cVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i10, boolean z10) {
        cVar.e0(1, 2);
        cVar.a0(n(thread, stackTraceElementArr, i10, z10));
        cVar.J(1, a.c(thread.getName()));
        cVar.f0(2, i10);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            q(cVar, 3, stackTraceElement, z10);
        }
    }

    private static int a(a aVar, a aVar2) {
        int z10 = c.z(1, 0L) + 0 + c.z(2, 0L) + c.f(3, aVar);
        return aVar2 != null ? z10 + c.f(4, aVar2) : z10;
    }

    private static int b(String str, String str2) {
        int f10 = c.f(1, a.c(str));
        if (str2 == null) {
            str2 = "";
        }
        return f10 + c.f(2, a.c(str2));
    }

    private static int c(i4.e eVar, int i10, int i11) {
        int i12 = 0;
        int f10 = c.f(1, a.c(eVar.f10734b)) + 0;
        String str = eVar.f10733a;
        if (str != null) {
            f10 += c.f(3, a.c(str));
        }
        for (StackTraceElement stackTraceElement : eVar.f10735c) {
            int i13 = i(stackTraceElement, true);
            f10 += c.w(4) + c.q(i13) + i13;
        }
        i4.e eVar2 = eVar.f10736d;
        if (eVar2 == null) {
            return f10;
        }
        if (i10 < i11) {
            int c10 = c(eVar2, i10 + 1, i11);
            return f10 + c.w(6) + c.q(c10) + c10;
        }
        while (eVar2 != null) {
            eVar2 = eVar2.f10736d;
            i12++;
        }
        return f10 + c.x(7, i12);
    }

    private static int d() {
        a aVar = f189a;
        return c.f(1, aVar) + 0 + c.f(2, aVar) + c.z(3, 0L);
    }

    private static int e(i4.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i10, a aVar, a aVar2) {
        int n10 = n(thread, stackTraceElementArr, 4, true);
        int w10 = c.w(1) + c.q(n10) + n10 + 0;
        int length = threadArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            int n11 = n(threadArr[i11], list.get(i11), 0, false);
            w10 += c.w(1) + c.q(n11) + n11;
        }
        int c10 = c(eVar, 1, i10);
        int w11 = w10 + c.w(2) + c.q(c10) + c10;
        int d10 = d();
        int w12 = w11 + c.w(3) + c.q(d10) + d10;
        int a10 = a(aVar, aVar2);
        return w12 + c.w(3) + c.q(a10) + a10;
    }

    private static int f(i4.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i10, a aVar, a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i11) {
        int e10 = e(eVar, thread, stackTraceElementArr, threadArr, list, i10, aVar, aVar2);
        int w10 = c.w(1) + c.q(e10) + e10 + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int b10 = b(entry.getKey(), entry.getValue());
                w10 += c.w(2) + c.q(b10) + b10;
            }
        }
        if (runningAppProcessInfo != null) {
            w10 += c.c(3, runningAppProcessInfo.importance != 100);
        }
        return w10 + c.x(4, i11);
    }

    private static int g(Float f10, int i10, boolean z10, int i11, long j10, long j11) {
        return (f10 != null ? 0 + c.k(1, f10.floatValue()) : 0) + c.u(2, i10) + c.c(3, z10) + c.x(4, i11) + c.z(5, j10) + c.z(6, j11);
    }

    private static int h(a aVar) {
        return c.f(1, aVar);
    }

    private static int i(StackTraceElement stackTraceElement, boolean z10) {
        int z11 = c.z(1, stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0) : 0L) + 0 + c.f(2, a.c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            z11 += c.f(3, a.c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            z11 += c.z(4, stackTraceElement.getLineNumber());
        }
        return z11 + c.x(5, z10 ? 2 : 0);
    }

    private static int j(a aVar, a aVar2, a aVar3, a aVar4, int i10, a aVar5) {
        int f10 = c.f(1, aVar) + 0 + c.f(2, aVar2) + c.f(3, aVar3) + c.f(6, aVar4);
        if (aVar5 != null) {
            f10 = f10 + c.f(8, f190b) + c.f(9, aVar5);
        }
        return f10 + c.i(10, i10);
    }

    private static int k(int i10, a aVar, int i11, long j10, long j11, boolean z10, int i12, a aVar2, a aVar3) {
        return c.i(3, i10) + 0 + (aVar == null ? 0 : c.f(4, aVar)) + c.x(5, i11) + c.z(6, j10) + c.z(7, j11) + c.c(10, z10) + c.x(12, i12) + (aVar2 == null ? 0 : c.f(13, aVar2)) + (aVar3 != null ? c.f(14, aVar3) : 0);
    }

    private static int l(long j10, String str, i4.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i10, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i11, a aVar, a aVar2, Float f10, int i12, boolean z10, long j11, long j12, a aVar3) {
        int z11 = c.z(1, j10) + 0 + c.f(2, a.c(str));
        int f11 = f(eVar, thread, stackTraceElementArr, threadArr, list, i10, aVar, aVar2, map, runningAppProcessInfo, i11);
        int w10 = z11 + c.w(3) + c.q(f11) + f11;
        int g10 = g(f10, i12, z10, i11, j11, j12);
        int w11 = w10 + c.w(5) + c.q(g10) + g10;
        if (aVar3 == null) {
            return w11;
        }
        int h10 = h(aVar3);
        return w11 + c.w(6) + c.q(h10) + h10;
    }

    private static int m(a aVar, a aVar2, boolean z10) {
        return c.i(1, 3) + 0 + c.f(2, aVar) + c.f(3, aVar2) + c.c(4, z10);
    }

    private static int n(Thread thread, StackTraceElement[] stackTraceElementArr, int i10, boolean z10) {
        int f10 = c.f(1, a.c(thread.getName())) + c.x(2, i10);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int i11 = i(stackTraceElement, z10);
            f10 += c.w(3) + c.q(i11) + i11;
        }
        return f10;
    }

    private static a o(String str) {
        if (str == null) {
            return null;
        }
        return a.c(str);
    }

    public static void p(c cVar, String str, String str2, long j10) {
        cVar.J(1, a.c(str2));
        cVar.J(2, a.c(str));
        cVar.h0(3, j10);
    }

    private static void q(c cVar, int i10, StackTraceElement stackTraceElement, boolean z10) {
        cVar.e0(i10, 2);
        cVar.a0(i(stackTraceElement, z10));
        cVar.h0(1, stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0) : 0L);
        cVar.J(2, a.c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            cVar.J(3, a.c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            cVar.h0(4, stackTraceElement.getLineNumber());
        }
        cVar.f0(5, z10 ? 4 : 0);
    }

    public static void r(c cVar, String str, String str2, String str3, String str4, int i10, String str5) {
        a c10 = a.c(str);
        a c11 = a.c(str2);
        a c12 = a.c(str3);
        a c13 = a.c(str4);
        a c14 = str5 != null ? a.c(str5) : null;
        cVar.e0(7, 2);
        cVar.a0(j(c10, c11, c12, c13, i10, c14));
        cVar.J(1, c10);
        cVar.J(2, c11);
        cVar.J(3, c12);
        cVar.J(6, c13);
        if (c14 != null) {
            cVar.J(8, f190b);
            cVar.J(9, c14);
        }
        cVar.M(10, i10);
    }

    public static void s(c cVar, String str) {
        a c10 = a.c(str);
        cVar.e0(7, 2);
        int f10 = c.f(2, c10);
        cVar.a0(c.w(5) + c.q(f10) + f10);
        cVar.e0(5, 2);
        cVar.a0(f10);
        cVar.J(2, c10);
    }

    public static void t(c cVar, int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        a o10 = o(str);
        a o11 = o(str3);
        a o12 = o(str2);
        cVar.e0(9, 2);
        cVar.a0(k(i10, o10, i11, j10, j11, z10, i12, o12, o11));
        cVar.M(3, i10);
        cVar.J(4, o10);
        cVar.f0(5, i11);
        cVar.h0(6, j10);
        cVar.h0(7, j11);
        cVar.H(10, z10);
        cVar.f0(12, i12);
        if (o12 != null) {
            cVar.J(13, o12);
        }
        if (o11 != null) {
            cVar.J(14, o11);
        }
    }

    public static void u(c cVar, long j10, String str, i4.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i10, Map<String, String> map, byte[] bArr, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i11, String str2, String str3, Float f10, int i12, boolean z10, long j11, long j12) {
        a c10 = a.c(str2);
        a aVar = null;
        a c11 = str3 == null ? null : a.c(str3.replace("-", ""));
        if (bArr != null) {
            aVar = a.a(bArr);
        } else {
            s3.b.f().b("No log data to include with this event.");
        }
        a aVar2 = aVar;
        cVar.e0(10, 2);
        cVar.a0(l(j10, str, eVar, thread, stackTraceElementArr, threadArr, list, i10, map, runningAppProcessInfo, i11, c10, c11, f10, i12, z10, j11, j12, aVar2));
        cVar.h0(1, j10);
        cVar.J(2, a.c(str));
        v(cVar, eVar, thread, stackTraceElementArr, threadArr, list, i10, c10, c11, map, runningAppProcessInfo, i11);
        z(cVar, f10, i12, z10, i11, j11, j12);
        A(cVar, aVar2);
    }

    private static void v(c cVar, i4.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i10, a aVar, a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i11) {
        cVar.e0(3, 2);
        cVar.a0(f(eVar, thread, stackTraceElementArr, threadArr, list, i10, aVar, aVar2, map, runningAppProcessInfo, i11));
        x(cVar, eVar, thread, stackTraceElementArr, threadArr, list, i10, aVar, aVar2);
        if (map != null && !map.isEmpty()) {
            w(cVar, map);
        }
        if (runningAppProcessInfo != null) {
            cVar.H(3, runningAppProcessInfo.importance != 100);
        }
        cVar.f0(4, i11);
    }

    private static void w(c cVar, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            cVar.e0(2, 2);
            cVar.a0(b(entry.getKey(), entry.getValue()));
            cVar.J(1, a.c(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            cVar.J(2, a.c(value));
        }
    }

    private static void x(c cVar, i4.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i10, a aVar, a aVar2) {
        cVar.e0(1, 2);
        cVar.a0(e(eVar, thread, stackTraceElementArr, threadArr, list, i10, aVar, aVar2));
        D(cVar, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            D(cVar, threadArr[i11], list.get(i11), 0, false);
        }
        y(cVar, eVar, 1, i10, 2);
        cVar.e0(3, 2);
        cVar.a0(d());
        a aVar3 = f189a;
        cVar.J(1, aVar3);
        cVar.J(2, aVar3);
        cVar.h0(3, 0L);
        cVar.e0(4, 2);
        cVar.a0(a(aVar, aVar2));
        cVar.h0(1, 0L);
        cVar.h0(2, 0L);
        cVar.J(3, aVar);
        if (aVar2 != null) {
            cVar.J(4, aVar2);
        }
    }

    private static void y(c cVar, i4.e eVar, int i10, int i11, int i12) {
        cVar.e0(i12, 2);
        cVar.a0(c(eVar, 1, i11));
        cVar.J(1, a.c(eVar.f10734b));
        String str = eVar.f10733a;
        if (str != null) {
            cVar.J(3, a.c(str));
        }
        int i13 = 0;
        for (StackTraceElement stackTraceElement : eVar.f10735c) {
            q(cVar, 4, stackTraceElement, true);
        }
        i4.e eVar2 = eVar.f10736d;
        if (eVar2 != null) {
            if (i10 < i11) {
                y(cVar, eVar2, i10 + 1, i11, 6);
                return;
            }
            while (eVar2 != null) {
                eVar2 = eVar2.f10736d;
                i13++;
            }
            cVar.f0(7, i13);
        }
    }

    private static void z(c cVar, Float f10, int i10, boolean z10, int i11, long j10, long j11) {
        cVar.e0(5, 2);
        cVar.a0(g(f10, i10, z10, i11, j10, j11));
        if (f10 != null) {
            cVar.O(1, f10.floatValue());
        }
        cVar.c0(2, i10);
        cVar.H(3, z10);
        cVar.f0(4, i11);
        cVar.h0(5, j10);
        cVar.h0(6, j11);
    }
}
