package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final f f2550a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0042c f2551a;

        public a(ClipData clipData, int i10) {
            this.f2551a = Build.VERSION.SDK_INT >= 31 ? new b(clipData, i10) : new d(clipData, i10);
        }

        public c a() {
            return this.f2551a.c();
        }

        public a b(Bundle bundle) {
            this.f2551a.d(bundle);
            return this;
        }

        public a c(int i10) {
            this.f2551a.f(i10);
            return this;
        }

        public a d(Uri uri) {
            this.f2551a.e(uri);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements InterfaceC0042c {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f2552a;

        b(ClipData clipData, int i10) {
            this.f2552a = new ContentInfo.Builder(clipData, i10);
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public c c() {
            return new c(new e(this.f2552a.build()));
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public void d(Bundle bundle) {
            this.f2552a.setExtras(bundle);
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public void e(Uri uri) {
            this.f2552a.setLinkUri(uri);
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public void f(int i10) {
            this.f2552a.setFlags(i10);
        }
    }

    /* renamed from: androidx.core.view.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private interface InterfaceC0042c {
        c c();

        void d(Bundle bundle);

        void e(Uri uri);

        void f(int i10);
    }

    /* loaded from: classes.dex */
    private static final class d implements InterfaceC0042c {

        /* renamed from: a, reason: collision with root package name */
        ClipData f2553a;

        /* renamed from: b, reason: collision with root package name */
        int f2554b;

        /* renamed from: c, reason: collision with root package name */
        int f2555c;

        /* renamed from: d, reason: collision with root package name */
        Uri f2556d;

        /* renamed from: e, reason: collision with root package name */
        Bundle f2557e;

        d(ClipData clipData, int i10) {
            this.f2553a = clipData;
            this.f2554b = i10;
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public c c() {
            return new c(new g(this));
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public void d(Bundle bundle) {
            this.f2557e = bundle;
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public void e(Uri uri) {
            this.f2556d = uri;
        }

        @Override // androidx.core.view.c.InterfaceC0042c
        public void f(int i10) {
            this.f2555c = i10;
        }
    }

    /* loaded from: classes.dex */
    private static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo f2558a;

        e(ContentInfo contentInfo) {
            this.f2558a = (ContentInfo) androidx.core.util.h.f(contentInfo);
        }

        @Override // androidx.core.view.c.f
        public int k() {
            return this.f2558a.getSource();
        }

        @Override // androidx.core.view.c.f
        public ClipData l() {
            return this.f2558a.getClip();
        }

        @Override // androidx.core.view.c.f
        public int m() {
            return this.f2558a.getFlags();
        }

        @Override // androidx.core.view.c.f
        public ContentInfo n() {
            return this.f2558a;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f2558a + "}";
        }
    }

    /* loaded from: classes.dex */
    private interface f {
        int k();

        ClipData l();

        int m();

        ContentInfo n();
    }

    /* loaded from: classes.dex */
    private static final class g implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ClipData f2559a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2560b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2561c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f2562d;

        /* renamed from: e, reason: collision with root package name */
        private final Bundle f2563e;

        g(d dVar) {
            this.f2559a = (ClipData) androidx.core.util.h.f(dVar.f2553a);
            this.f2560b = androidx.core.util.h.b(dVar.f2554b, 0, 5, "source");
            this.f2561c = androidx.core.util.h.e(dVar.f2555c, 1);
            this.f2562d = dVar.f2556d;
            this.f2563e = dVar.f2557e;
        }

        @Override // androidx.core.view.c.f
        public int k() {
            return this.f2560b;
        }

        @Override // androidx.core.view.c.f
        public ClipData l() {
            return this.f2559a;
        }

        @Override // androidx.core.view.c.f
        public int m() {
            return this.f2561c;
        }

        @Override // androidx.core.view.c.f
        public ContentInfo n() {
            return null;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f2559a.getDescription());
            sb2.append(", source=");
            sb2.append(c.e(this.f2560b));
            sb2.append(", flags=");
            sb2.append(c.a(this.f2561c));
            if (this.f2562d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f2562d.toString().length() + ")";
            }
            sb2.append(str);
            sb2.append(this.f2563e != null ? ", hasExtras" : "");
            sb2.append("}");
            return sb2.toString();
        }
    }

    c(f fVar) {
        this.f2550a = fVar;
    }

    static String a(int i10) {
        return (i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10);
    }

    static String e(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static c g(ContentInfo contentInfo) {
        return new c(new e(contentInfo));
    }

    public ClipData b() {
        return this.f2550a.l();
    }

    public int c() {
        return this.f2550a.m();
    }

    public int d() {
        return this.f2550a.k();
    }

    public ContentInfo f() {
        ContentInfo n10 = this.f2550a.n();
        Objects.requireNonNull(n10);
        return n10;
    }

    public String toString() {
        return this.f2550a.toString();
    }
}
