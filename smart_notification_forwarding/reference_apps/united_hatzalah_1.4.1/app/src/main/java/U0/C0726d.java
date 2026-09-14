package u0;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;

/* renamed from: u0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0726d extends WebMessagePort.WebMessageCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6562a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0.o f6563b;

    public /* synthetic */ C0726d(t0.o oVar, int i) {
        this.f6562a = i;
        this.f6563b = oVar;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
        switch (this.f6562a) {
            case 0:
                this.f6563b.onMessage(new C0721B(webMessagePort), AbstractC0728f.d(webMessage));
                return;
            default:
                this.f6563b.onMessage(new C0721B(webMessagePort), AbstractC0728f.d(webMessage));
                return;
        }
    }
}
