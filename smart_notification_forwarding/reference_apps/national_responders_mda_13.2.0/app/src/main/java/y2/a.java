package y2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import b2.p;
import g2.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class a {

    /* renamed from: l, reason: collision with root package name */
    private static ScheduledExecutorService f15891l;

    /* renamed from: a, reason: collision with root package name */
    private final Object f15892a;

    /* renamed from: b, reason: collision with root package name */
    private final PowerManager.WakeLock f15893b;

    /* renamed from: c, reason: collision with root package name */
    private WorkSource f15894c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15895d;

    /* renamed from: e, reason: collision with root package name */
    private final String f15896e;

    /* renamed from: f, reason: collision with root package name */
    private final String f15897f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f15898g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f15899h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Integer[]> f15900i;

    /* renamed from: j, reason: collision with root package name */
    private int f15901j;

    /* renamed from: k, reason: collision with root package name */
    private AtomicInteger f15902k;

    static {
        new b();
    }

    public a(Context context, int i10, String str) {
        this(context, i10, str, null, context == null ? null : context.getPackageName());
    }

    private a(Context context, int i10, String str, String str2, String str3) {
        this(context, i10, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private a(Context context, int i10, String str, String str2, String str3, String str4) {
        this.f15892a = this;
        this.f15899h = true;
        this.f15900i = new HashMap();
        Collections.synchronizedSet(new HashSet());
        this.f15902k = new AtomicInteger(0);
        p.l(context, "WakeLock: context must not be null");
        p.h(str, "WakeLock: wakeLockName must not be empty");
        this.f15895d = i10;
        this.f15897f = null;
        Context applicationContext = context.getApplicationContext();
        this.f15898g = applicationContext;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f15896e = str;
        } else {
            String valueOf = String.valueOf(str);
            this.f15896e = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i10, str);
        this.f15893b = newWakeLock;
        if (g2.p.e(context)) {
            WorkSource b10 = g2.p.b(context, n.a(str3) ? context.getPackageName() : str3);
            this.f15894c = b10;
            if (b10 != null && g2.p.e(applicationContext)) {
                WorkSource workSource = this.f15894c;
                if (workSource != null) {
                    workSource.add(b10);
                } else {
                    this.f15894c = b10;
                }
                try {
                    newWakeLock.setWorkSource(this.f15894c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e10) {
                    Log.wtf("WakeLock", e10.toString());
                }
            }
        }
        if (f15891l == null) {
            f15891l = e2.a.a().a();
        }
    }

    private final String d(String str) {
        return (!this.f15899h || TextUtils.isEmpty(str)) ? this.f15897f : str;
    }

    private final List<String> e() {
        return g2.p.d(this.f15894c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i10) {
        if (this.f15893b.isHeld()) {
            try {
                this.f15893b.release();
            } catch (RuntimeException e10) {
                if (!e10.getClass().equals(RuntimeException.class)) {
                    throw e10;
                }
                String.valueOf(this.f15896e).concat(" was already released!");
            }
            this.f15893b.isHeld();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        f2.c.a().c(r13.f15898g, f2.b.a(r13.f15893b, r6), 7, r13.f15896e, r6, null, r13.f15895d, e(), r14);
        r13.f15901j++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r13.f15901j == 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.f15902k
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.d(r0)
            java.lang.Object r0 = r13.f15892a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f15900i     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.f15901j     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.f15893b     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f15900i     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.f15901j = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.f15899h     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f15900i     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f15900i     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = 1
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.f15899h     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.f15901j     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            f2.c r1 = f2.c.a()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.f15898g     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.f15893b     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = f2.b.a(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.f15896e     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.f15895d     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.e()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.f15901j     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.f15901j = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.f15893b
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = y2.a.f15891l
            y2.c r1 = new y2.c
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.a.a(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
    
        if (r1 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        f2.c.a().b(r12.f15898g, f2.b.a(r12.f15893b, r6), 8, r12.f15896e, r6, null, r12.f15895d, e());
        r12.f15901j--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        if (r12.f15901j == 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f15902k
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L13
            java.lang.String r0 = r12.f15896e
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = " release without a matched acquire!"
            r0.concat(r1)
        L13:
            r0 = 0
            java.lang.String r6 = r12.d(r0)
            java.lang.Object r0 = r12.f15892a
            monitor-enter(r0)
            boolean r1 = r12.f15899h     // Catch: java.lang.Throwable -> L78
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L4c
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f15900i     // Catch: java.lang.Throwable -> L78
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L78
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L78
            if (r1 != 0) goto L2d
        L2b:
            r1 = 0
            goto L4a
        L2d:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L78
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L78
            if (r2 != r10) goto L3c
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f15900i     // Catch: java.lang.Throwable -> L78
            r1.remove(r6)     // Catch: java.lang.Throwable -> L78
            r1 = 1
            goto L4a
        L3c:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L78
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L78
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L78
            r1[r11] = r2     // Catch: java.lang.Throwable -> L78
            goto L2b
        L4a:
            if (r1 != 0) goto L54
        L4c:
            boolean r1 = r12.f15899h     // Catch: java.lang.Throwable -> L78
            if (r1 != 0) goto L73
            int r1 = r12.f15901j     // Catch: java.lang.Throwable -> L78
            if (r1 != r10) goto L73
        L54:
            f2.c r1 = f2.c.a()     // Catch: java.lang.Throwable -> L78
            android.content.Context r2 = r12.f15898g     // Catch: java.lang.Throwable -> L78
            android.os.PowerManager$WakeLock r3 = r12.f15893b     // Catch: java.lang.Throwable -> L78
            java.lang.String r3 = f2.b.a(r3, r6)     // Catch: java.lang.Throwable -> L78
            r4 = 8
            java.lang.String r5 = r12.f15896e     // Catch: java.lang.Throwable -> L78
            r7 = 0
            int r8 = r12.f15895d     // Catch: java.lang.Throwable -> L78
            java.util.List r9 = r12.e()     // Catch: java.lang.Throwable -> L78
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L78
            int r1 = r12.f15901j     // Catch: java.lang.Throwable -> L78
            int r1 = r1 - r10
            r12.f15901j = r1     // Catch: java.lang.Throwable -> L78
        L73:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L78
            r12.f(r11)
            return
        L78:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L78
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.a.b():void");
    }

    public void c(boolean z10) {
        this.f15893b.setReferenceCounted(z10);
        this.f15899h = z10;
    }
}
