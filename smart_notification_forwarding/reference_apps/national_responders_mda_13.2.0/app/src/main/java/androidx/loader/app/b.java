package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.e0;
import androidx.lifecycle.l;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import l.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f3248c;

    /* renamed from: a, reason: collision with root package name */
    private final l f3249a;

    /* renamed from: b, reason: collision with root package name */
    private final C0054b f3250b;

    /* loaded from: classes.dex */
    public static class a<D> extends q<D> {

        /* renamed from: k, reason: collision with root package name */
        private final int f3251k;

        /* renamed from: l, reason: collision with root package name */
        private final Bundle f3252l;

        /* renamed from: m, reason: collision with root package name */
        private final l0.a<D> f3253m;

        /* renamed from: n, reason: collision with root package name */
        private l f3254n;

        @Override // androidx.lifecycle.LiveData
        protected void g() {
            if (b.f3248c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Starting: ");
                sb2.append(this);
            }
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void h() {
            if (b.f3248c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Stopping: ");
                sb2.append(this);
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void i(r<? super D> rVar) {
            super.i(rVar);
            this.f3254n = null;
        }

        @Override // androidx.lifecycle.q, androidx.lifecycle.LiveData
        public void j(D d10) {
            super.j(d10);
        }

        l0.a<D> k(boolean z10) {
            if (b.f3248c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Destroying: ");
                sb2.append(this);
            }
            throw null;
        }

        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3251k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3252l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3253m);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ");
            throw null;
        }

        void m() {
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f3251k);
            sb2.append(" : ");
            androidx.core.util.b.a(this.f3253m, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0054b extends a0 {

        /* renamed from: d, reason: collision with root package name */
        private static final b0.b f3255d = new a();

        /* renamed from: c, reason: collision with root package name */
        private h<a> f3256c = new h<>();

        /* renamed from: androidx.loader.app.b$b$a */
        /* loaded from: classes.dex */
        static class a implements b0.b {
            a() {
            }

            @Override // androidx.lifecycle.b0.b
            public /* synthetic */ a0 a(Class cls, k0.a aVar) {
                return c0.b(this, cls, aVar);
            }

            @Override // androidx.lifecycle.b0.b
            public <T extends a0> T b(Class<T> cls) {
                return new C0054b();
            }
        }

        C0054b() {
        }

        static C0054b f(e0 e0Var) {
            return (C0054b) new b0(e0Var, f3255d).a(C0054b.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.a0
        public void d() {
            super.d();
            int m10 = this.f3256c.m();
            for (int i10 = 0; i10 < m10; i10++) {
                this.f3256c.n(i10).k(true);
            }
            this.f3256c.b();
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3256c.m() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f3256c.m(); i10++) {
                    a n10 = this.f3256c.n(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3256c.k(i10));
                    printWriter.print(": ");
                    printWriter.println(n10.toString());
                    n10.l(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void g() {
            int m10 = this.f3256c.m();
            for (int i10 = 0; i10 < m10; i10++) {
                this.f3256c.n(i10).m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(l lVar, e0 e0Var) {
        this.f3249a = lVar;
        this.f3250b = C0054b.f(e0Var);
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3250b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public void c() {
        this.f3250b.g();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        androidx.core.util.b.a(this.f3249a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
