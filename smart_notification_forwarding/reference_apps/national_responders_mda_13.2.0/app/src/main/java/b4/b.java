package b4;

import com.google.firebase.crashlytics.internal.common.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: h, reason: collision with root package name */
    private static final short[] f4112h = {10, 20, 30, 60, 120, 300};

    /* renamed from: a, reason: collision with root package name */
    private final d4.b f4113a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4114b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4115c;

    /* renamed from: d, reason: collision with root package name */
    private final t f4116d;

    /* renamed from: e, reason: collision with root package name */
    private final b4.a f4117e;

    /* renamed from: f, reason: collision with root package name */
    private final a f4118f;

    /* renamed from: g, reason: collision with root package name */
    private Thread f4119g;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();
    }

    /* renamed from: b4.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0068b {
        b a(g4.b bVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        File[] a();

        File[] b();
    }

    /* loaded from: classes.dex */
    private class d extends com.google.firebase.crashlytics.internal.common.d {

        /* renamed from: f, reason: collision with root package name */
        private final List<c4.c> f4120f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f4121g;

        /* renamed from: h, reason: collision with root package name */
        private final float f4122h;

        d(List<c4.c> list, boolean z10, float f10) {
            this.f4120f = list;
            this.f4121g = z10;
            this.f4122h = f10;
        }

        private void b(List<c4.c> list, boolean z10) {
            s3.b.f().b("Starting report processing in " + this.f4122h + " second(s)...");
            if (this.f4122h > 0.0f) {
                try {
                    Thread.sleep(r0 * 1000.0f);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (b.this.f4118f.a()) {
                return;
            }
            int i10 = 0;
            while (list.size() > 0 && !b.this.f4118f.a()) {
                s3.b.f().b("Attempting to send " + list.size() + " report(s)");
                ArrayList arrayList = new ArrayList();
                for (c4.c cVar : list) {
                    if (!b.this.d(cVar, z10)) {
                        arrayList.add(cVar);
                    }
                }
                if (arrayList.size() > 0) {
                    int i11 = i10 + 1;
                    long j10 = b.f4112h[Math.min(i10, b.f4112h.length - 1)];
                    s3.b.f().b("Report submission: scheduling delayed retry in " + j10 + " seconds");
                    Thread.sleep(j10 * 1000);
                    i10 = i11;
                }
                list = arrayList;
            }
        }

        @Override // com.google.firebase.crashlytics.internal.common.d
        public void a() {
            try {
                b(this.f4120f, this.f4121g);
            } catch (Exception e10) {
                s3.b.f().e("An unexpected error occurred while attempting to upload crash reports.", e10);
            }
            b.this.f4119g = null;
        }
    }

    public b(String str, String str2, t tVar, b4.a aVar, d4.b bVar, a aVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f4113a = bVar;
        this.f4114b = str;
        this.f4115c = str2;
        this.f4116d = tVar;
        this.f4117e = aVar;
        this.f4118f = aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005c A[Catch: Exception -> 0x0063, TRY_LEAVE, TryCatch #0 {Exception -> 0x0063, blocks: (B:3:0x0001, B:6:0x0013, B:7:0x0017, B:10:0x005c, B:15:0x001b, B:17:0x001f, B:19:0x0027, B:20:0x002e, B:23:0x0049), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(c4.c r7, boolean r8) {
        /*
            r6 = this;
            r0 = 0
            c4.a r1 = new c4.a     // Catch: java.lang.Exception -> L63
            java.lang.String r2 = r6.f4114b     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = r6.f4115c     // Catch: java.lang.Exception -> L63
            r1.<init>(r2, r3, r7)     // Catch: java.lang.Exception -> L63
            com.google.firebase.crashlytics.internal.common.t r2 = r6.f4116d     // Catch: java.lang.Exception -> L63
            com.google.firebase.crashlytics.internal.common.t r3 = com.google.firebase.crashlytics.internal.common.t.ALL     // Catch: java.lang.Exception -> L63
            java.lang.String r4 = "Report configured to be sent via DataTransport."
            r5 = 1
            if (r2 != r3) goto L1b
            s3.b r8 = s3.b.f()     // Catch: java.lang.Exception -> L63
        L17:
            r8.b(r4)     // Catch: java.lang.Exception -> L63
            goto L2c
        L1b:
            com.google.firebase.crashlytics.internal.common.t r3 = com.google.firebase.crashlytics.internal.common.t.JAVA_ONLY     // Catch: java.lang.Exception -> L63
            if (r2 != r3) goto L2e
            c4.c$a r2 = r7.b()     // Catch: java.lang.Exception -> L63
            c4.c$a r3 = c4.c.a.JAVA     // Catch: java.lang.Exception -> L63
            if (r2 != r3) goto L2e
            s3.b r8 = s3.b.f()     // Catch: java.lang.Exception -> L63
            goto L17
        L2c:
            r8 = 1
            goto L5a
        L2e:
            d4.b r2 = r6.f4113a     // Catch: java.lang.Exception -> L63
            boolean r8 = r2.b(r1, r8)     // Catch: java.lang.Exception -> L63
            s3.b r1 = s3.b.f()     // Catch: java.lang.Exception -> L63
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L63
            r2.<init>()     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = "Crashlytics Reports Endpoint upload "
            r2.append(r3)     // Catch: java.lang.Exception -> L63
            if (r8 == 0) goto L47
            java.lang.String r3 = "complete: "
            goto L49
        L47:
            java.lang.String r3 = "FAILED: "
        L49:
            r2.append(r3)     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = r7.e()     // Catch: java.lang.Exception -> L63
            r2.append(r3)     // Catch: java.lang.Exception -> L63
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L63
            r1.g(r2)     // Catch: java.lang.Exception -> L63
        L5a:
            if (r8 == 0) goto L7c
            b4.a r8 = r6.f4117e     // Catch: java.lang.Exception -> L63
            r8.b(r7)     // Catch: java.lang.Exception -> L63
            r0 = 1
            goto L7c
        L63:
            r8 = move-exception
            s3.b r1 = s3.b.f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error occurred sending report "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.e(r7, r8)
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.b.d(c4.c, boolean):boolean");
    }

    public synchronized void e(List<c4.c> list, boolean z10, float f10) {
        if (this.f4119g != null) {
            s3.b.f().b("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new d(list, z10, f10), "Crashlytics Report Uploader");
        this.f4119g = thread;
        thread.start();
    }
}
