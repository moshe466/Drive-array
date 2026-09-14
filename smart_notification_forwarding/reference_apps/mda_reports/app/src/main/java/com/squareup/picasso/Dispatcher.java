package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.NetworkRequestHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Dispatcher {
    private static final int AIRPLANE_MODE_OFF = 0;
    private static final int AIRPLANE_MODE_ON = 1;
    private static final int BATCH_DELAY = 200;
    private static final String DISPATCHER_THREAD_NAME = "Dispatcher";
    private static final int RETRY_DELAY = 500;
    final DispatcherThread a = new DispatcherThread();
    final Context b;
    final ExecutorService c;
    final Downloader d;
    final Map<String, BitmapHunter> e;
    final Map<Object, Action> f;
    final Map<Object, Action> g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final Cache k;
    final Stats l;
    final List<BitmapHunter> m;
    final NetworkBroadcastReceiver n;
    final boolean o;
    boolean p;

    /* loaded from: classes2.dex */
    private static class DispatcherHandler extends Handler {
        private final Dispatcher dispatcher;

        DispatcherHandler(Looper looper, Dispatcher dispatcher) {
            super(looper);
            this.dispatcher = dispatcher;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 1:
                    this.dispatcher.d((Action) message.obj);
                    return;
                case 2:
                    this.dispatcher.c((Action) message.obj);
                    return;
                case 3:
                case 8:
                default:
                    Picasso.l.post(new Runnable(this) { // from class: com.squareup.picasso.Dispatcher.DispatcherHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    return;
                case 4:
                    this.dispatcher.d((BitmapHunter) message.obj);
                    return;
                case 5:
                    this.dispatcher.e((BitmapHunter) message.obj);
                    return;
                case 6:
                    this.dispatcher.a((BitmapHunter) message.obj, false);
                    return;
                case 7:
                    this.dispatcher.a();
                    return;
                case 9:
                    this.dispatcher.b((NetworkInfo) message.obj);
                    return;
                case 10:
                    this.dispatcher.b(message.arg1 == 1);
                    return;
                case 11:
                    this.dispatcher.c(message.obj);
                    return;
                case 12:
                    this.dispatcher.d(message.obj);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class DispatcherThread extends HandlerThread {
        DispatcherThread() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* loaded from: classes2.dex */
    static class NetworkBroadcastReceiver extends BroadcastReceiver {
        private final Dispatcher dispatcher;

        NetworkBroadcastReceiver(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.dispatcher.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.dispatcher.b.registerReceiver(this, intentFilter);
        }

        void b() {
            this.dispatcher.b.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.dispatcher.a(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.dispatcher.a(((ConnectivityManager) Utils.a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dispatcher(Context context, ExecutorService executorService, Handler handler, Downloader downloader, Cache cache, Stats stats) {
        this.a.start();
        Utils.a(this.a.getLooper());
        this.b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new LinkedHashSet();
        this.i = new DispatcherHandler(this.a.getLooper(), this);
        this.d = downloader;
        this.j = handler;
        this.k = cache;
        this.l = stats;
        this.m = new ArrayList(4);
        this.p = Utils.c(this.b);
        this.o = Utils.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new NetworkBroadcastReceiver(this);
        this.n.a();
    }

    private void batch(BitmapHunter bitmapHunter) {
        if (bitmapHunter.m()) {
            return;
        }
        Bitmap bitmap = bitmapHunter.m;
        if (bitmap != null) {
            bitmap.prepareToDraw();
        }
        this.m.add(bitmapHunter);
        if (this.i.hasMessages(7)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(7, 200L);
    }

    private void flushFailedActions() {
        if (this.f.isEmpty()) {
            return;
        }
        Iterator<Action> it = this.f.values().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            it.remove();
            if (next.e().j) {
                Utils.a(DISPATCHER_THREAD_NAME, "replaying", next.g().c());
            }
            a(next, false);
        }
    }

    private void logBatch(List<BitmapHunter> list) {
        if (list == null || list.isEmpty() || !list.get(0).i().j) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (BitmapHunter bitmapHunter : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(Utils.a(bitmapHunter));
        }
        Utils.a(DISPATCHER_THREAD_NAME, "delivered", sb.toString());
    }

    private void markForReplay(Action action) {
        Object i = action.i();
        if (i != null) {
            action.k = true;
            this.f.put(i, action);
        }
    }

    private void markForReplay(BitmapHunter bitmapHunter) {
        Action b = bitmapHunter.b();
        if (b != null) {
            markForReplay(b);
        }
        List<Action> c = bitmapHunter.c();
        if (c != null) {
            int size = c.size();
            for (int i = 0; i < size; i++) {
                markForReplay(c.get(i));
            }
        }
    }

    void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        logBatch(arrayList);
    }

    void a(NetworkInfo networkInfo) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Action action) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(2, action));
    }

    void a(Action action, boolean z) {
        if (this.h.contains(action.h())) {
            this.g.put(action.i(), action);
            if (action.e().j) {
                Utils.a(DISPATCHER_THREAD_NAME, "paused", action.b.c(), "because tag '" + action.h() + "' is paused");
                return;
            }
            return;
        }
        BitmapHunter bitmapHunter = this.e.get(action.b());
        if (bitmapHunter != null) {
            bitmapHunter.a(action);
            return;
        }
        if (this.c.isShutdown()) {
            if (action.e().j) {
                Utils.a(DISPATCHER_THREAD_NAME, "ignored", action.b.c(), "because shut down");
                return;
            }
            return;
        }
        BitmapHunter a = BitmapHunter.a(action.e(), this, this.k, this.l, action);
        a.n = this.c.submit(a);
        this.e.put(action.b(), a);
        if (z) {
            this.f.remove(action.i());
        }
        if (action.e().j) {
            Utils.a(DISPATCHER_THREAD_NAME, "enqueued", action.b.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BitmapHunter bitmapHunter) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, bitmapHunter));
    }

    void a(BitmapHunter bitmapHunter, boolean z) {
        if (bitmapHunter.i().j) {
            String a = Utils.a(bitmapHunter);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            Utils.a(DISPATCHER_THREAD_NAME, "batched", a, sb.toString());
        }
        this.e.remove(bitmapHunter.f());
        batch(bitmapHunter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(11, obj));
    }

    void a(boolean z) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        ExecutorService executorService = this.c;
        if (executorService instanceof PicassoExecutorService) {
            executorService.shutdown();
        }
        this.d.shutdown();
        this.a.quit();
        Picasso.l.post(new Runnable() { // from class: com.squareup.picasso.Dispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                Dispatcher.this.n.b();
            }
        });
    }

    void b(NetworkInfo networkInfo) {
        ExecutorService executorService = this.c;
        if (executorService instanceof PicassoExecutorService) {
            ((PicassoExecutorService) executorService).a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        flushFailedActions();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Action action) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1, action));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(BitmapHunter bitmapHunter) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, bitmapHunter));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Object obj) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(12, obj));
    }

    void b(boolean z) {
        this.p = z;
    }

    void c(Action action) {
        String b = action.b();
        BitmapHunter bitmapHunter = this.e.get(b);
        if (bitmapHunter != null) {
            bitmapHunter.b(action);
            if (bitmapHunter.a()) {
                this.e.remove(b);
                if (action.e().j) {
                    Utils.a(DISPATCHER_THREAD_NAME, "canceled", action.g().c());
                }
            }
        }
        if (this.h.contains(action.h())) {
            this.g.remove(action.i());
            if (action.e().j) {
                Utils.a(DISPATCHER_THREAD_NAME, "canceled", action.g().c(), "because paused request got canceled");
            }
        }
        Action remove = this.f.remove(action.i());
        if (remove == null || !remove.e().j) {
            return;
        }
        Utils.a(DISPATCHER_THREAD_NAME, "canceled", remove.g().c(), "from replaying");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(BitmapHunter bitmapHunter) {
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(5, bitmapHunter), 500L);
    }

    void c(Object obj) {
        if (this.h.add(obj)) {
            Iterator<BitmapHunter> it = this.e.values().iterator();
            while (it.hasNext()) {
                BitmapHunter next = it.next();
                boolean z = next.i().j;
                Action b = next.b();
                List<Action> c = next.c();
                boolean z2 = (c == null || c.isEmpty()) ? false : true;
                if (b != null || z2) {
                    if (b != null && b.h().equals(obj)) {
                        next.b(b);
                        this.g.put(b.i(), b);
                        if (z) {
                            Utils.a(DISPATCHER_THREAD_NAME, "paused", b.b.c(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = c.size() - 1; size >= 0; size--) {
                            Action action = c.get(size);
                            if (action.h().equals(obj)) {
                                next.b(action);
                                this.g.put(action.i(), action);
                                if (z) {
                                    Utils.a(DISPATCHER_THREAD_NAME, "paused", action.b.c(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.a()) {
                        it.remove();
                        if (z) {
                            Utils.a(DISPATCHER_THREAD_NAME, "canceled", Utils.a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void d(Action action) {
        a(action, true);
    }

    void d(BitmapHunter bitmapHunter) {
        if (MemoryPolicy.b(bitmapHunter.h())) {
            this.k.set(bitmapHunter.f(), bitmapHunter.k());
        }
        this.e.remove(bitmapHunter.f());
        batch(bitmapHunter);
        if (bitmapHunter.i().j) {
            Utils.a(DISPATCHER_THREAD_NAME, "batched", Utils.a(bitmapHunter), "for completion");
        }
    }

    void d(Object obj) {
        if (this.h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<Action> it = this.g.values().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if (next.h().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    void e(BitmapHunter bitmapHunter) {
        if (bitmapHunter.m()) {
            return;
        }
        boolean z = false;
        if (this.c.isShutdown()) {
            a(bitmapHunter, false);
            return;
        }
        if (bitmapHunter.a(this.p, this.o ? ((ConnectivityManager) Utils.a(this.b, "connectivity")).getActiveNetworkInfo() : null)) {
            if (bitmapHunter.i().j) {
                Utils.a(DISPATCHER_THREAD_NAME, "retrying", Utils.a(bitmapHunter));
            }
            if (bitmapHunter.e() instanceof NetworkRequestHandler.ContentLengthException) {
                bitmapHunter.i |= NetworkPolicy.NO_CACHE.a;
            }
            bitmapHunter.n = this.c.submit(bitmapHunter);
            return;
        }
        if (this.o && bitmapHunter.n()) {
            z = true;
        }
        a(bitmapHunter, z);
        if (z) {
            markForReplay(bitmapHunter);
        }
    }
}
