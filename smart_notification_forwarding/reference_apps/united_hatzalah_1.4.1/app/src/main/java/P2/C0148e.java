package P2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: P2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0148e {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f1650b = AtomicIntegerFieldUpdater.newUpdater(C0148e.class, "notCompletedCount$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final J[] f1651a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    public C0148e(J[] jArr) {
        this.f1651a = jArr;
        this.notCompletedCount$volatile = jArr.length;
    }
}
