package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;

/* loaded from: classes.dex */
class Worker {
    private static final String TAG = "Worker";
    private final SixObject mClient;
    private final Handler mClientHandler;
    private final Context mContext;
    private Handler mHandler;
    private final HandlerThread mThread;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Worker(Context context, String str, SixObject sixObject) {
        Log.i(TAG, "Worker ctor " + str);
        this.mContext = context;
        this.mThread = new HandlerThread(str);
        this.mClientHandler = new Handler(Looper.myLooper());
        this.mClient = sixObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postToWorker(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null) {
            Log.e(TAG, "postToWorker : handler is not ready");
        } else {
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postDelayedToWorker(Runnable runnable, long j) {
        Handler handler = this.mHandler;
        if (handler == null) {
            Log.e(TAG, "postToWorker : handler is not ready");
        } else {
            handler.postDelayed(runnable, j);
        }
    }

    protected void postToClient(Runnable runnable) {
        Handler handler = this.mClientHandler;
        if (handler == null) {
            Log.e(TAG, "postToClient : handler is not ready");
        } else {
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initThread() throws Exception {
        Log.d(TAG, "init called with ");
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deleteThread() throws Exception {
        Handler handler;
        Log.i(TAG, "delete");
        if (this.mThread == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.Worker.1
            @Override // java.lang.Runnable
            public void run() {
                Worker.this.onDeleteOnWorker();
            }
        });
        this.mThread.quitSafely();
        Log.i(TAG, "delete : wait until worker finish");
        this.mThread.join();
        Log.i(TAG, "delete : done");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendSuccessToClient(final String str, final String... strArr) {
        postToClient(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.Worker.2
            @Override // java.lang.Runnable
            public void run() {
                Worker.this.mClient.sendSuccess(str, strArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFailToClient(final String str, final Exception exc) {
        postToClient(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.Worker.3
            @Override // java.lang.Runnable
            public void run() {
                Worker.this.mClient.sendFail(str, exc);
            }
        });
    }

    protected void onDeleteOnWorker() {
        Log.i(TAG, "onDeleteOnWorker called");
    }
}
