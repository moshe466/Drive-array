package P2;

import java.util.concurrent.CancellationException;
import w2.InterfaceC0763d;
import w2.InterfaceC0766g;

/* renamed from: P2.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0157i0 extends InterfaceC0766g {
    InterfaceC0166p attachChild(r rVar);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    M2.d getChildren();

    InterfaceC0157i0 getParent();

    Q invokeOnCompletion(F2.l lVar);

    Q invokeOnCompletion(boolean z3, boolean z4, F2.l lVar);

    boolean isActive();

    boolean isCancelled();

    Object join(InterfaceC0763d interfaceC0763d);

    boolean start();
}
