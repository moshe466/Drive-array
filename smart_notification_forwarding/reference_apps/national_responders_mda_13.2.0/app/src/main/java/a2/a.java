package a2;

import a2.a.d;
import a2.f;
import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import b2.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class a<O extends d> {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0006a f50a;

    /* renamed from: b, reason: collision with root package name */
    private final g f51b;

    /* renamed from: c, reason: collision with root package name */
    private final String f52c;

    /* renamed from: a2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0006a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T c(Context context, Looper looper, b2.e eVar, O o10, f.b bVar, f.c cVar) {
            return d(context, looper, eVar, o10, bVar, cVar);
        }

        public T d(Context context, Looper looper, b2.e eVar, O o10, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.o oVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static class c<C extends b> {
    }

    /* loaded from: classes.dex */
    public interface d {

        /* renamed from: a, reason: collision with root package name */
        public static final c f53a = new c(null);

        /* renamed from: a2.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0007a extends d {
            Account a();
        }

        /* loaded from: classes.dex */
        public interface b extends d {
            GoogleSignInAccount b();
        }

        /* loaded from: classes.dex */
        public static final class c implements d {
            private c() {
            }

            /* synthetic */ c(p pVar) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<T extends b, O> {
        public List<Scope> a(O o10) {
            return Collections.emptyList();
        }

        public int b() {
            return Integer.MAX_VALUE;
        }
    }

    /* loaded from: classes.dex */
    public interface f extends b {
        boolean a();

        boolean b();

        Set<Scope> c();

        void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        void f(String str);

        boolean g();

        int h();

        boolean i();

        z1.c[] j();

        String k();

        String m();

        void n(b2.j jVar, Set<Scope> set);

        void o(c.e eVar);

        void p();

        Intent q();

        boolean r();

        void t(c.InterfaceC0067c interfaceC0067c);
    }

    /* loaded from: classes.dex */
    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> a(String str, AbstractC0006a<C, O> abstractC0006a, g<C> gVar) {
        b2.p.l(abstractC0006a, "Cannot construct an Api with a null ClientBuilder");
        b2.p.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f52c = str;
        this.f50a = abstractC0006a;
        this.f51b = gVar;
    }

    public final AbstractC0006a a() {
        return this.f50a;
    }

    public final c b() {
        return this.f51b;
    }

    public final e c() {
        return this.f50a;
    }

    public final String d() {
        return this.f52c;
    }
}
