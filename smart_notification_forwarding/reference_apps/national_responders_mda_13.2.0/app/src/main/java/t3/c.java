package t3;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c implements b, a {

    /* renamed from: a, reason: collision with root package name */
    private final e f14262a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14263b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeUnit f14264c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f14265d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private CountDownLatch f14266e;

    public c(e eVar, int i10, TimeUnit timeUnit) {
        this.f14262a = eVar;
        this.f14263b = i10;
        this.f14264c = timeUnit;
    }

    @Override // t3.a
    public void a(String str, Bundle bundle) {
        s3.b f10;
        String str2;
        synchronized (this.f14265d) {
            s3.b.f().b("Logging Crashlytics event to Firebase");
            this.f14266e = new CountDownLatch(1);
            this.f14262a.a(str, bundle);
            s3.b.f().b("Awaiting app exception callback from FA...");
            try {
                if (this.f14266e.await(this.f14263b, this.f14264c)) {
                    f10 = s3.b.f();
                    str2 = "App exception callback received from FA listener.";
                } else {
                    f10 = s3.b.f();
                    str2 = "Timeout exceeded while awaiting app exception callback from FA listener.";
                }
                f10.b(str2);
            } catch (InterruptedException unused) {
                s3.b.f().b("Interrupted while awaiting app exception callback from FA listener.");
            }
            this.f14266e = null;
        }
    }

    @Override // t3.b
    public void o(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f14266e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
