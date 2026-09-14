package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.os.Build;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class BitmapHunter implements Runnable {
    final int a = SEQUENCE_GENERATOR.incrementAndGet();
    final Picasso b;
    final Dispatcher c;
    final Cache d;
    final Stats e;
    final String f;
    final Request g;
    final int h;
    int i;
    final RequestHandler j;
    Action k;
    List<Action> l;
    Bitmap m;
    Future<?> n;
    Picasso.LoadedFrom o;
    Exception p;
    int q;
    int r;
    Picasso.Priority s;
    private static final Object DECODE_LOCK = new Object();
    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() { // from class: com.squareup.picasso.BitmapHunter.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    private static final RequestHandler ERRORING_HANDLER = new RequestHandler() { // from class: com.squareup.picasso.BitmapHunter.2
        @Override // com.squareup.picasso.RequestHandler
        public boolean canHandleRequest(Request request) {
            return true;
        }

        @Override // com.squareup.picasso.RequestHandler
        public RequestHandler.Result load(Request request, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + request);
        }
    };

    BitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, RequestHandler requestHandler) {
        this.b = picasso;
        this.c = dispatcher;
        this.d = cache;
        this.e = stats;
        this.k = action;
        this.f = action.b();
        this.g = action.g();
        this.s = action.f();
        this.h = action.c();
        this.i = action.d();
        this.j = requestHandler;
        this.r = requestHandler.a();
    }

    static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x029e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static android.graphics.Bitmap a(com.squareup.picasso.Request r26, android.graphics.Bitmap r27, int r28) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.a(com.squareup.picasso.Request, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    static Bitmap a(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final Transformation transformation = list.get(i);
            try {
                Bitmap transform = transformation.transform(bitmap);
                if (transform == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(transformation.key());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<Transformation> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().key());
                        sb.append('\n');
                    }
                    Picasso.l.post(new Runnable() { // from class: com.squareup.picasso.BitmapHunter.4
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                }
                if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.l.post(new Runnable() { // from class: com.squareup.picasso.BitmapHunter.5
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + Transformation.this.key() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                }
                if (transform != bitmap && !bitmap.isRecycled()) {
                    Picasso.l.post(new Runnable() { // from class: com.squareup.picasso.BitmapHunter.6
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + Transformation.this.key() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
                i++;
                bitmap = transform;
            } catch (RuntimeException e) {
                Picasso.l.post(new Runnable() { // from class: com.squareup.picasso.BitmapHunter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException("Transformation " + Transformation.this.key() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    static Bitmap a(Source source, Request request) {
        BufferedSource buffer = Okio.buffer(source);
        boolean a = Utils.a(buffer);
        boolean z = request.purgeable && Build.VERSION.SDK_INT < 21;
        BitmapFactory.Options a2 = RequestHandler.a(request);
        boolean a3 = RequestHandler.a(a2);
        if (a || z) {
            byte[] readByteArray = buffer.readByteArray();
            if (a3) {
                BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, a2);
                RequestHandler.a(request.targetWidth, request.targetHeight, a2, request);
            }
            return BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, a2);
        }
        InputStream inputStream = buffer.inputStream();
        if (a3) {
            MarkableInputStream markableInputStream = new MarkableInputStream(inputStream);
            markableInputStream.allowMarksToExpire(false);
            long savePosition = markableInputStream.savePosition(1024);
            BitmapFactory.decodeStream(markableInputStream, null, a2);
            RequestHandler.a(request.targetWidth, request.targetHeight, a2, request);
            markableInputStream.reset(savePosition);
            markableInputStream.allowMarksToExpire(true);
            inputStream = markableInputStream;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, a2);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitmapHunter a(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        Request g = action.g();
        List<RequestHandler> a = picasso.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            RequestHandler requestHandler = a.get(i);
            if (requestHandler.canHandleRequest(g)) {
                return new BitmapHunter(picasso, dispatcher, cache, stats, action, requestHandler);
            }
        }
        return new BitmapHunter(picasso, dispatcher, cache, stats, action, ERRORING_HANDLER);
    }

    static void a(Request request) {
        String a = request.a();
        StringBuilder sb = NAME_BUILDER.get();
        sb.ensureCapacity(a.length() + 8);
        sb.replace(8, sb.length(), a);
        Thread.currentThread().setName(sb.toString());
    }

    static int b(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    private Picasso.Priority computeNewPriority() {
        Picasso.Priority priority = Picasso.Priority.LOW;
        List<Action> list = this.l;
        boolean z = true;
        boolean z2 = (list == null || list.isEmpty()) ? false : true;
        if (this.k == null && !z2) {
            z = false;
        }
        if (!z) {
            return priority;
        }
        Action action = this.k;
        if (action != null) {
            priority = action.f();
        }
        if (z2) {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                Picasso.Priority f = this.l.get(i).f();
                if (f.ordinal() > priority.ordinal()) {
                    priority = f;
                }
            }
        }
        return priority;
    }

    private static boolean shouldResize(boolean z, int i, int i2, int i3, int i4) {
        return !z || (i3 != 0 && i > i3) || (i4 != 0 && i2 > i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Action action) {
        String c;
        String str;
        boolean z = this.b.j;
        Request request = action.b;
        if (this.k != null) {
            if (this.l == null) {
                this.l = new ArrayList(3);
            }
            this.l.add(action);
            if (z) {
                Utils.a("Hunter", "joined", request.c(), Utils.a(this, "to "));
            }
            Picasso.Priority f = action.f();
            if (f.ordinal() > this.s.ordinal()) {
                this.s = f;
                return;
            }
            return;
        }
        this.k = action;
        if (z) {
            List<Action> list = this.l;
            if (list == null || list.isEmpty()) {
                c = request.c();
                str = "to empty hunter";
            } else {
                c = request.c();
                str = Utils.a(this, "to ");
            }
            Utils.a("Hunter", "joined", c, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        Future<?> future;
        if (this.k != null) {
            return false;
        }
        List<Action> list = this.l;
        return (list == null || list.isEmpty()) && (future = this.n) != null && future.cancel(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(boolean z, NetworkInfo networkInfo) {
        if (!(this.r > 0)) {
            return false;
        }
        this.r--;
        return this.j.a(z, networkInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Action b() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Action action) {
        boolean remove;
        if (this.k == action) {
            this.k = null;
            remove = true;
        } else {
            List<Action> list = this.l;
            remove = list != null ? list.remove(action) : false;
        }
        if (remove && action.f() == this.s) {
            this.s = computeNewPriority();
        }
        if (this.b.j) {
            Utils.a("Hunter", "removed", action.b.c(), Utils.a(this, "from "));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Action> c() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception e() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso.LoadedFrom g() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso i() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Picasso.Priority j() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap k() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap l() {
        Bitmap bitmap;
        if (MemoryPolicy.a(this.h)) {
            bitmap = this.d.get(this.f);
            if (bitmap != null) {
                this.e.b();
                this.o = Picasso.LoadedFrom.MEMORY;
                if (this.b.j) {
                    Utils.a("Hunter", "decoded", this.g.c(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        this.i = this.r == 0 ? NetworkPolicy.OFFLINE.a : this.i;
        RequestHandler.Result load = this.j.load(this.g, this.i);
        if (load != null) {
            this.o = load.getLoadedFrom();
            this.q = load.a();
            bitmap = load.getBitmap();
            if (bitmap == null) {
                Source source = load.getSource();
                try {
                    bitmap = a(source, this.g);
                } finally {
                    try {
                        source.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.b.j) {
                Utils.a("Hunter", "decoded", this.g.c());
            }
            this.e.a(bitmap);
            if (this.g.e() || this.q != 0) {
                synchronized (DECODE_LOCK) {
                    if (this.g.d() || this.q != 0) {
                        bitmap = a(this.g, bitmap, this.q);
                        if (this.b.j) {
                            Utils.a("Hunter", "transformed", this.g.c());
                        }
                    }
                    if (this.g.b()) {
                        bitmap = a(this.g.transformations, bitmap);
                        if (this.b.j) {
                            Utils.a("Hunter", "transformed", this.g.c(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.e.b(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        Future<?> future = this.n;
        return future != null && future.isCancelled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.j.b();
    }

    @Override // java.lang.Runnable
    public void run() {
        Dispatcher dispatcher;
        try {
            try {
                try {
                    a(this.g);
                    if (this.b.j) {
                        Utils.a("Hunter", "executing", Utils.a(this));
                    }
                    this.m = l();
                    if (this.m == null) {
                        this.c.b(this);
                    } else {
                        this.c.a(this);
                    }
                } catch (NetworkRequestHandler.ResponseException e) {
                    if (!NetworkPolicy.isOfflineOnly(e.b) || e.a != 504) {
                        this.p = e;
                    }
                    dispatcher = this.c;
                    dispatcher.b(this);
                } catch (Exception e2) {
                    this.p = e2;
                    dispatcher = this.c;
                    dispatcher.b(this);
                }
            } catch (IOException e3) {
                this.p = e3;
                this.c.c(this);
            } catch (OutOfMemoryError e4) {
                StringWriter stringWriter = new StringWriter();
                this.e.a().dump(new PrintWriter(stringWriter));
                this.p = new RuntimeException(stringWriter.toString(), e4);
                dispatcher = this.c;
                dispatcher.b(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }
}
