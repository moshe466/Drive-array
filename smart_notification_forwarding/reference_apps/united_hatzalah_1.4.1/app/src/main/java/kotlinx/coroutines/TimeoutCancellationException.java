package kotlinx.coroutines;

import P2.InterfaceC0157i0;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class TimeoutCancellationException extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient InterfaceC0157i0 f5315a;

    public TimeoutCancellationException(String str, InterfaceC0157i0 interfaceC0157i0) {
        super(str);
        this.f5315a = interfaceC0157i0;
    }
}
