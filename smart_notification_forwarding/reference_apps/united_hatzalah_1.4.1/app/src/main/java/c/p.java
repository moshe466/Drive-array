package c;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class p {
    private final CopyOnWriteArrayList<InterfaceC0326b> cancellables = new CopyOnWriteArrayList<>();
    private F2.a enabledChangedCallback;
    private boolean isEnabled;

    public p(boolean z3) {
        this.isEnabled = z3;
    }

    public final void addCancellable(InterfaceC0326b cancellable) {
        kotlin.jvm.internal.j.e(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final F2.a getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(C0325a backEvent) {
        kotlin.jvm.internal.j.e(backEvent, "backEvent");
    }

    public void handleOnBackStarted(C0325a backEvent) {
        kotlin.jvm.internal.j.e(backEvent, "backEvent");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((InterfaceC0326b) it.next()).cancel();
        }
    }

    public final void removeCancellable(InterfaceC0326b cancellable) {
        kotlin.jvm.internal.j.e(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    public final void setEnabled(boolean z3) {
        this.isEnabled = z3;
        F2.a aVar = this.enabledChangedCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(F2.a aVar) {
        this.enabledChangedCallback = aVar;
    }

    public void handleOnBackCancelled() {
    }
}
