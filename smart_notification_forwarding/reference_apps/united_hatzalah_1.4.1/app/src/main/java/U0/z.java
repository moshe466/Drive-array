package u0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* loaded from: classes.dex */
public final class z implements WebMessageBoundaryInterface {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f6583b = {"WEB_MESSAGE_ARRAY_BUFFER"};

    /* renamed from: a, reason: collision with root package name */
    public final t0.n f6584a;

    public z(t0.n nVar) {
        this.f6584a = nVar;
    }

    public static t0.n a(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        InvocationHandler[] ports = webMessageBoundaryInterface.getPorts();
        t0.p[] pVarArr = new t0.p[ports.length];
        for (int i = 0; i < ports.length; i++) {
            pVarArr[i] = new C0721B(ports[i]);
        }
        if (F.f6543u.b()) {
            WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) m3.b.d(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
            int type = webMessagePayloadBoundaryInterface.getType();
            if (type != 0) {
                if (type != 1) {
                    return null;
                }
                return new t0.n(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), pVarArr);
            }
            return new t0.n(webMessagePayloadBoundaryInterface.getAsString(), pVarArr);
        }
        return new t0.n(webMessageBoundaryInterface.getData(), pVarArr);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final String getData() {
        t0.n nVar = this.f6584a;
        nVar.a(0);
        return nVar.f6379b;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final InvocationHandler getMessagePayload() {
        C0720A c0720a;
        t0.n nVar = this.f6584a;
        int i = nVar.f6381d;
        if (i != 0) {
            if (i == 1) {
                nVar.a(1);
                byte[] bArr = nVar.f6380c;
                Objects.requireNonNull(bArr);
                c0720a = new C0720A(bArr);
            } else {
                throw new IllegalStateException("Unknown web message payload type: " + i);
            }
        } else {
            nVar.a(0);
            c0720a = new C0720A(nVar.f6379b);
        }
        return new m3.a(c0720a);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final InvocationHandler[] getPorts() {
        t0.p[] pVarArr = this.f6584a.f6378a;
        if (pVarArr == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[pVarArr.length];
        for (int i = 0; i < pVarArr.length; i++) {
            invocationHandlerArr[i] = Proxy.getInvocationHandler(((C0721B) pVarArr[i]).b());
        }
        return invocationHandlerArr;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return f6583b;
    }
}
