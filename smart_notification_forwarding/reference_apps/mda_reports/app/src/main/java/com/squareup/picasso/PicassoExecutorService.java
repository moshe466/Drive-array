package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Utils;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class PicassoExecutorService extends ThreadPoolExecutor {
    private static final int DEFAULT_THREAD_COUNT = 3;

    /* loaded from: classes2.dex */
    private static final class PicassoFutureTask extends FutureTask<BitmapHunter> implements Comparable<PicassoFutureTask> {
        private final BitmapHunter hunter;

        PicassoFutureTask(BitmapHunter bitmapHunter) {
            super(bitmapHunter, null);
            this.hunter = bitmapHunter;
        }

        @Override // java.lang.Comparable
        public int compareTo(PicassoFutureTask picassoFutureTask) {
            Picasso.Priority j = this.hunter.j();
            Picasso.Priority j2 = picassoFutureTask.hunter.j();
            return j == j2 ? this.hunter.a - picassoFutureTask.hunter.a : j2.ordinal() - j.ordinal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PicassoExecutorService() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new Utils.PicassoThreadFactory());
    }

    private void setThreadCount(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0027. Please report as an issue. */
    public void a(NetworkInfo networkInfo) {
        int i;
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            setThreadCount(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            if (type == 1 || type == 6 || type == 9) {
                i = 4;
                setThreadCount(i);
                return;
            }
            setThreadCount(3);
            return;
        }
        int subtype = networkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
                setThreadCount(1);
                return;
            default:
                switch (subtype) {
                    case 12:
                        break;
                    case 13:
                    case 14:
                    case 15:
                    default:
                        setThreadCount(3);
                        return;
                }
                setThreadCount(i);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                i = 2;
                setThreadCount(i);
                return;
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        PicassoFutureTask picassoFutureTask = new PicassoFutureTask((BitmapHunter) runnable);
        execute(picassoFutureTask);
        return picassoFutureTask;
    }
}
