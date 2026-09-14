package gc;

import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class e {
    public static boolean a(CountDownLatch countDownLatch, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z10 = false;
        long j11 = j10;
        boolean z11 = false;
        do {
            try {
                z10 = countDownLatch.await(j11, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException unused) {
                z11 = true;
                j11 = j10 - (SystemClock.elapsedRealtime() - elapsedRealtime);
            }
        } while (j11 > 0);
        if (z11) {
            Thread.currentThread().interrupt();
        }
        return z10;
    }
}
