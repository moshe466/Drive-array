package sb;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.a0;
import okhttp3.c0;
import okhttp3.i;
import okhttp3.j;
import okhttp3.q;
import ub.g;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f14194a;

    public abstract void a(q.a aVar, String str);

    public abstract void b(q.a aVar, String str, String str2);

    public abstract void c(j jVar, SSLSocket sSLSocket, boolean z10);

    public abstract int d(a0.a aVar);

    public abstract boolean e(i iVar, ub.c cVar);

    public abstract Socket f(i iVar, okhttp3.a aVar, g gVar);

    public abstract boolean g(okhttp3.a aVar, okhttp3.a aVar2);

    public abstract ub.c h(i iVar, okhttp3.a aVar, g gVar, c0 c0Var);

    public abstract void i(i iVar, ub.c cVar);

    public abstract ub.d j(i iVar);

    public abstract IOException k(okhttp3.d dVar, IOException iOException);
}
