package y2;

import w2.InterfaceC0763d;
import w2.InterfaceC0768i;

/* renamed from: y2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0786b implements InterfaceC0763d {

    /* renamed from: a, reason: collision with root package name */
    public static final C0786b f6761a = new Object();

    @Override // w2.InterfaceC0763d
    public final InterfaceC0768i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // w2.InterfaceC0763d
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
