package u0;

import android.webkit.WebMessagePort;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* renamed from: u0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0721B extends t0.p {

    /* renamed from: a, reason: collision with root package name */
    public WebMessagePort f6505a;

    /* renamed from: b, reason: collision with root package name */
    public WebMessagePortBoundaryInterface f6506b;

    public C0721B(WebMessagePort webMessagePort) {
        this.f6505a = webMessagePort;
    }

    @Override // t0.p
    public final void a(t0.n nVar) {
        C0724b c0724b = F.f6541s;
        c0724b.getClass();
        int i = nVar.f6381d;
        if (i == 0) {
            AbstractC0728f.h(c(), AbstractC0728f.b(nVar));
        } else {
            if (c0724b.b() && (i == 0 || (i == 1 && F.f6543u.b()))) {
                b().postMessage(new m3.a(new z(nVar)));
                return;
            }
            throw F.a();
        }
    }

    public final WebMessagePortBoundaryInterface b() {
        if (this.f6506b == null) {
            J j2 = G.f6548a;
            this.f6506b = (WebMessagePortBoundaryInterface) m3.b.d(WebMessagePortBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) j2.f6552b).convertWebMessagePort(this.f6505a));
        }
        return this.f6506b;
    }

    public final WebMessagePort c() {
        if (this.f6505a == null) {
            J j2 = G.f6548a;
            this.f6505a = (WebMessagePort) ((WebkitToCompatConverterBoundaryInterface) j2.f6552b).convertWebMessagePort(Proxy.getInvocationHandler(this.f6506b));
        }
        return this.f6505a;
    }

    public C0721B(InvocationHandler invocationHandler) {
        this.f6506b = (WebMessagePortBoundaryInterface) m3.b.d(WebMessagePortBoundaryInterface.class, invocationHandler);
    }
}
