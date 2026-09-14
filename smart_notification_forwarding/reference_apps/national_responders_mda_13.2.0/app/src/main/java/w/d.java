package w;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final c f14882a;

    /* loaded from: classes.dex */
    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final InputContentInfo f14883a;

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f14883a = new InputContentInfo(uri, clipDescription, uri2);
        }

        a(Object obj) {
            this.f14883a = (InputContentInfo) obj;
        }

        @Override // w.d.c
        public ClipDescription a() {
            return this.f14883a.getDescription();
        }

        @Override // w.d.c
        public Object b() {
            return this.f14883a;
        }

        @Override // w.d.c
        public Uri c() {
            return this.f14883a.getContentUri();
        }

        @Override // w.d.c
        public void d() {
            this.f14883a.requestPermission();
        }

        @Override // w.d.c
        public Uri e() {
            return this.f14883a.getLinkUri();
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f14884a;

        /* renamed from: b, reason: collision with root package name */
        private final ClipDescription f14885b;

        /* renamed from: c, reason: collision with root package name */
        private final Uri f14886c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f14884a = uri;
            this.f14885b = clipDescription;
            this.f14886c = uri2;
        }

        @Override // w.d.c
        public ClipDescription a() {
            return this.f14885b;
        }

        @Override // w.d.c
        public Object b() {
            return null;
        }

        @Override // w.d.c
        public Uri c() {
            return this.f14884a;
        }

        @Override // w.d.c
        public void d() {
        }

        @Override // w.d.c
        public Uri e() {
            return this.f14886c;
        }
    }

    /* loaded from: classes.dex */
    private interface c {
        ClipDescription a();

        Object b();

        Uri c();

        void d();

        Uri e();
    }

    public d(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f14882a = Build.VERSION.SDK_INT >= 25 ? new a(uri, clipDescription, uri2) : new b(uri, clipDescription, uri2);
    }

    private d(c cVar) {
        this.f14882a = cVar;
    }

    public static d f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new d(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f14882a.c();
    }

    public ClipDescription b() {
        return this.f14882a.a();
    }

    public Uri c() {
        return this.f14882a.e();
    }

    public void d() {
        this.f14882a.d();
    }

    public Object e() {
        return this.f14882a.b();
    }
}
