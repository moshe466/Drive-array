package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.squareup.picasso.Action;
import com.squareup.picasso.RemoteViewsAction;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class Picasso {
    static final Handler l = new Handler(Looper.getMainLooper()) { // from class: com.squareup.picasso.Picasso.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                Action action = (Action) message.obj;
                if (action.e().j) {
                    Utils.a("Main", "canceled", action.b.c(), "target got garbage collected");
                }
                action.a.a(action.i());
                return;
            }
            int i2 = 0;
            if (i == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i2 < size) {
                    BitmapHunter bitmapHunter = (BitmapHunter) list.get(i2);
                    bitmapHunter.b.a(bitmapHunter);
                    i2++;
                }
                return;
            }
            if (i != 13) {
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
            List list2 = (List) message.obj;
            int size2 = list2.size();
            while (i2 < size2) {
                Action action2 = (Action) list2.get(i2);
                action2.a.b(action2);
                i2++;
            }
        }
    };

    @SuppressLint({"StaticFieldLeak"})
    static volatile Picasso m = null;
    final Context a;
    final Dispatcher b;
    final Cache c;
    private final CleanupThread cleanupThread;
    final Stats d;
    final Map<Object, Action> e;
    final Map<ImageView, DeferredRequestCreator> f;
    final ReferenceQueue<Object> g;
    final Bitmap.Config h;
    boolean i;
    volatile boolean j;
    boolean k;
    private final Listener listener;
    private final List<RequestHandler> requestHandlers;
    private final RequestTransformer requestTransformer;

    /* loaded from: classes2.dex */
    public static class Builder {
        private Cache cache;
        private final Context context;
        private Bitmap.Config defaultBitmapConfig;
        private Downloader downloader;
        private boolean indicatorsEnabled;
        private Listener listener;
        private boolean loggingEnabled;
        private List<RequestHandler> requestHandlers;
        private ExecutorService service;
        private RequestTransformer transformer;

        public Builder(@NonNull Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context.getApplicationContext();
        }

        public Builder addRequestHandler(@NonNull RequestHandler requestHandler) {
            if (requestHandler == null) {
                throw new IllegalArgumentException("RequestHandler must not be null.");
            }
            if (this.requestHandlers == null) {
                this.requestHandlers = new ArrayList();
            }
            if (this.requestHandlers.contains(requestHandler)) {
                throw new IllegalStateException("RequestHandler already registered.");
            }
            this.requestHandlers.add(requestHandler);
            return this;
        }

        public Picasso build() {
            Context context = this.context;
            if (this.downloader == null) {
                this.downloader = new OkHttp3Downloader(context);
            }
            if (this.cache == null) {
                this.cache = new LruCache(context);
            }
            if (this.service == null) {
                this.service = new PicassoExecutorService();
            }
            if (this.transformer == null) {
                this.transformer = RequestTransformer.IDENTITY;
            }
            Stats stats = new Stats(this.cache);
            return new Picasso(context, new Dispatcher(context, this.service, Picasso.l, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, this.requestHandlers, stats, this.defaultBitmapConfig, this.indicatorsEnabled, this.loggingEnabled);
        }

        public Builder defaultBitmapConfig(@NonNull Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("Bitmap config must not be null.");
            }
            this.defaultBitmapConfig = config;
            return this;
        }

        public Builder downloader(@NonNull Downloader downloader) {
            if (downloader == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            }
            if (this.downloader != null) {
                throw new IllegalStateException("Downloader already set.");
            }
            this.downloader = downloader;
            return this;
        }

        public Builder executor(@NonNull ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            }
            if (this.service != null) {
                throw new IllegalStateException("Executor service already set.");
            }
            this.service = executorService;
            return this;
        }

        public Builder indicatorsEnabled(boolean z) {
            this.indicatorsEnabled = z;
            return this;
        }

        public Builder listener(@NonNull Listener listener) {
            if (listener == null) {
                throw new IllegalArgumentException("Listener must not be null.");
            }
            if (this.listener != null) {
                throw new IllegalStateException("Listener already set.");
            }
            this.listener = listener;
            return this;
        }

        public Builder loggingEnabled(boolean z) {
            this.loggingEnabled = z;
            return this;
        }

        public Builder memoryCache(@NonNull Cache cache) {
            if (cache == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            }
            if (this.cache != null) {
                throw new IllegalStateException("Memory cache already set.");
            }
            this.cache = cache;
            return this;
        }

        public Builder requestTransformer(@NonNull RequestTransformer requestTransformer) {
            if (requestTransformer == null) {
                throw new IllegalArgumentException("Transformer must not be null.");
            }
            if (this.transformer != null) {
                throw new IllegalStateException("Transformer already set.");
            }
            this.transformer = requestTransformer;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static class CleanupThread extends Thread {
        private final Handler handler;
        private final ReferenceQueue<Object> referenceQueue;

        CleanupThread(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.referenceQueue = referenceQueue;
            this.handler = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        void a() {
            interrupt();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    Action.RequestWeakReference requestWeakReference = (Action.RequestWeakReference) this.referenceQueue.remove(1000L);
                    Message obtainMessage = this.handler.obtainMessage();
                    if (requestWeakReference != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = requestWeakReference.a;
                        this.handler.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.handler.post(new Runnable(this) { // from class: com.squareup.picasso.Picasso.CleanupThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface Listener {
        void onImageLoadFailed(Picasso picasso, Uri uri, Exception exc);
    }

    /* loaded from: classes2.dex */
    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);

        final int a;

        LoadedFrom(int i) {
            this.a = i;
        }
    }

    /* loaded from: classes2.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    /* loaded from: classes2.dex */
    public interface RequestTransformer {
        public static final RequestTransformer IDENTITY = new RequestTransformer() { // from class: com.squareup.picasso.Picasso.RequestTransformer.1
            @Override // com.squareup.picasso.Picasso.RequestTransformer
            public Request transformRequest(Request request) {
                return request;
            }
        };

        Request transformRequest(Request request);
    }

    Picasso(Context context, Dispatcher dispatcher, Cache cache, Listener listener, RequestTransformer requestTransformer, List<RequestHandler> list, Stats stats, Bitmap.Config config, boolean z, boolean z2) {
        this.a = context;
        this.b = dispatcher;
        this.c = cache;
        this.listener = listener;
        this.requestTransformer = requestTransformer;
        this.h = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ResourceRequestHandler(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new ContactsPhotoRequestHandler(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new ContentStreamRequestHandler(context));
        arrayList.add(new AssetRequestHandler(context));
        arrayList.add(new FileRequestHandler(context));
        arrayList.add(new NetworkRequestHandler(dispatcher.d, stats));
        this.requestHandlers = Collections.unmodifiableList(arrayList);
        this.d = stats;
        this.e = new WeakHashMap();
        this.f = new WeakHashMap();
        this.i = z;
        this.j = z2;
        this.g = new ReferenceQueue<>();
        this.cleanupThread = new CleanupThread(this.g, l);
        this.cleanupThread.start();
    }

    private void deliverAction(Bitmap bitmap, LoadedFrom loadedFrom, Action action, Exception exc) {
        String c;
        String message;
        String str;
        if (action.j()) {
            return;
        }
        if (!action.k()) {
            this.e.remove(action.i());
        }
        if (bitmap == null) {
            action.error(exc);
            if (!this.j) {
                return;
            }
            c = action.b.c();
            message = exc.getMessage();
            str = "errored";
        } else {
            if (loadedFrom == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
            action.complete(bitmap, loadedFrom);
            if (!this.j) {
                return;
            }
            c = action.b.c();
            message = "from " + loadedFrom;
            str = "completed";
        }
        Utils.a("Main", str, c, message);
    }

    public static Picasso get() {
        if (m == null) {
            synchronized (Picasso.class) {
                if (m == null) {
                    if (PicassoProvider.a == null) {
                        throw new IllegalStateException("context == null");
                    }
                    m = new Builder(PicassoProvider.a).build();
                }
            }
        }
        return m;
    }

    public static void setSingletonInstance(@NonNull Picasso picasso) {
        if (picasso == null) {
            throw new IllegalArgumentException("Picasso must not be null.");
        }
        synchronized (Picasso.class) {
            if (m != null) {
                throw new IllegalStateException("Singleton instance already exists.");
            }
            m = picasso;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap a(String str) {
        Bitmap bitmap = this.c.get(str);
        Stats stats = this.d;
        if (bitmap != null) {
            stats.b();
        } else {
            stats.c();
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request a(Request request) {
        Request transformRequest = this.requestTransformer.transformRequest(request);
        if (transformRequest != null) {
            return transformRequest;
        }
        throw new IllegalStateException("Request transformer " + this.requestTransformer.getClass().getCanonicalName() + " returned null for " + request);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<RequestHandler> a() {
        return this.requestHandlers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImageView imageView, DeferredRequestCreator deferredRequestCreator) {
        if (this.f.containsKey(imageView)) {
            a(imageView);
        }
        this.f.put(imageView, deferredRequestCreator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Action action) {
        Object i = action.i();
        if (i != null && this.e.get(i) != action) {
            a(i);
            this.e.put(i, action);
        }
        c(action);
    }

    void a(BitmapHunter bitmapHunter) {
        Action b = bitmapHunter.b();
        List<Action> c = bitmapHunter.c();
        boolean z = true;
        boolean z2 = (c == null || c.isEmpty()) ? false : true;
        if (b == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = bitmapHunter.d().uri;
            Exception e = bitmapHunter.e();
            Bitmap k = bitmapHunter.k();
            LoadedFrom g = bitmapHunter.g();
            if (b != null) {
                deliverAction(k, g, b, e);
            }
            if (z2) {
                int size = c.size();
                for (int i = 0; i < size; i++) {
                    deliverAction(k, g, c.get(i), e);
                }
            }
            Listener listener = this.listener;
            if (listener == null || e == null) {
                return;
            }
            listener.onImageLoadFailed(this, uri, e);
        }
    }

    void a(Object obj) {
        Utils.a();
        Action remove = this.e.remove(obj);
        if (remove != null) {
            remove.a();
            this.b.a(remove);
        }
        if (obj instanceof ImageView) {
            DeferredRequestCreator remove2 = this.f.remove((ImageView) obj);
            if (remove2 != null) {
                remove2.a();
            }
        }
    }

    public boolean areIndicatorsEnabled() {
        return this.i;
    }

    void b(Action action) {
        Bitmap a = MemoryPolicy.a(action.e) ? a(action.b()) : null;
        if (a == null) {
            a(action);
            if (this.j) {
                Utils.a("Main", "resumed", action.b.c());
                return;
            }
            return;
        }
        deliverAction(a, LoadedFrom.MEMORY, action, null);
        if (this.j) {
            Utils.a("Main", "completed", action.b.c(), "from " + LoadedFrom.MEMORY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Action action) {
        this.b.b(action);
    }

    public void cancelRequest(@NonNull ImageView imageView) {
        if (imageView == null) {
            throw new IllegalArgumentException("view cannot be null.");
        }
        a(imageView);
    }

    public void cancelRequest(@NonNull RemoteViews remoteViews, @IdRes int i) {
        if (remoteViews == null) {
            throw new IllegalArgumentException("remoteViews cannot be null.");
        }
        a(new RemoteViewsAction.RemoteViewsTarget(remoteViews, i));
    }

    public void cancelRequest(@NonNull Target target) {
        if (target == null) {
            throw new IllegalArgumentException("target cannot be null.");
        }
        a(target);
    }

    public void cancelTag(@NonNull Object obj) {
        Utils.a();
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancel requests with null tag.");
        }
        ArrayList arrayList = new ArrayList(this.e.values());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Action action = (Action) arrayList.get(i);
            if (obj.equals(action.h())) {
                a(action.i());
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f.values());
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) arrayList2.get(i2);
            if (obj.equals(deferredRequestCreator.b())) {
                deferredRequestCreator.a();
            }
        }
    }

    public StatsSnapshot getSnapshot() {
        return this.d.a();
    }

    public void invalidate(@Nullable Uri uri) {
        if (uri != null) {
            this.c.clearKeyUri(uri.toString());
        }
    }

    public void invalidate(@NonNull File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        invalidate(Uri.fromFile(file));
    }

    public void invalidate(@Nullable String str) {
        if (str != null) {
            invalidate(Uri.parse(str));
        }
    }

    public boolean isLoggingEnabled() {
        return this.j;
    }

    public RequestCreator load(@DrawableRes int i) {
        if (i != 0) {
            return new RequestCreator(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public RequestCreator load(@Nullable Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    public RequestCreator load(@NonNull File file) {
        return file == null ? new RequestCreator(this, null, 0) : load(Uri.fromFile(file));
    }

    public RequestCreator load(@Nullable String str) {
        if (str == null) {
            return new RequestCreator(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return load(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public void pauseTag(@NonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("tag == null");
        }
        this.b.a(obj);
    }

    public void resumeTag(@NonNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("tag == null");
        }
        this.b.b(obj);
    }

    public void setIndicatorsEnabled(boolean z) {
        this.i = z;
    }

    public void setLoggingEnabled(boolean z) {
        this.j = z;
    }

    public void shutdown() {
        if (this == m) {
            throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
        }
        if (this.k) {
            return;
        }
        this.c.clear();
        this.cleanupThread.a();
        this.d.f();
        this.b.b();
        Iterator<DeferredRequestCreator> it = this.f.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f.clear();
        this.k = true;
    }
}
