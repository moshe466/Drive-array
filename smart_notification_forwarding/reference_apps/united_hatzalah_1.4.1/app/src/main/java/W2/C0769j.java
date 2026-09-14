package w2;

import F2.p;
import java.io.Serializable;

/* renamed from: w2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0769j implements InterfaceC0768i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final C0769j f6733a = new Object();

    @Override // w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h key) {
        kotlin.jvm.internal.j.e(key, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i minusKey(InterfaceC0767h key) {
        kotlin.jvm.internal.j.e(key, "key");
        return this;
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i plus(InterfaceC0768i context) {
        kotlin.jvm.internal.j.e(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, p pVar) {
        return obj;
    }
}
