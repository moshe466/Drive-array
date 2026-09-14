package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Stats {
    private static final int BITMAP_DECODE_FINISHED = 2;
    private static final int BITMAP_TRANSFORMED_FINISHED = 3;
    private static final int CACHE_HIT = 0;
    private static final int CACHE_MISS = 1;
    private static final int DOWNLOAD_FINISHED = 4;
    private static final String STATS_THREAD_NAME = "Picasso-Stats";
    final HandlerThread a = new HandlerThread(STATS_THREAD_NAME, 10);
    final Cache b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    /* loaded from: classes2.dex */
    private static class StatsHandler extends Handler {
        private final Stats stats;

        StatsHandler(Looper looper, Stats stats) {
            super(looper);
            this.stats = stats;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            int i = message.what;
            if (i == 0) {
                this.stats.d();
                return;
            }
            if (i == 1) {
                this.stats.e();
                return;
            }
            if (i == 2) {
                this.stats.b(message.arg1);
                return;
            }
            if (i == 3) {
                this.stats.c(message.arg1);
            } else if (i != 4) {
                Picasso.l.post(new Runnable(this) { // from class: com.squareup.picasso.Stats.StatsHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new AssertionError("Unhandled stats message." + message.what);
                    }
                });
            } else {
                this.stats.a((Long) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Stats(Cache cache) {
        this.b = cache;
        this.a.start();
        Utils.a(this.a.getLooper());
        this.c = new StatsHandler(this.a.getLooper(), this);
    }

    private static long getAverage(int i, long j) {
        return j / i;
    }

    private void processBitmap(Bitmap bitmap, int i) {
        int a = Utils.a(bitmap);
        Handler handler = this.c;
        handler.sendMessage(handler.obtainMessage(i, a, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StatsSnapshot a() {
        return new StatsSnapshot(this.b.maxSize(), this.b.size(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        Handler handler = this.c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bitmap bitmap) {
        processBitmap(bitmap, 2);
    }

    void a(Long l) {
        this.l++;
        this.f += l.longValue();
        this.i = getAverage(this.l, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.c.sendEmptyMessage(0);
    }

    void b(long j) {
        this.m++;
        this.g += j;
        this.j = getAverage(this.m, this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Bitmap bitmap) {
        processBitmap(bitmap, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.c.sendEmptyMessage(1);
    }

    void c(long j) {
        this.n++;
        this.h += j;
        this.k = getAverage(this.m, this.h);
    }

    void d() {
        this.d++;
    }

    void e() {
        this.e++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.a.quit();
    }
}
