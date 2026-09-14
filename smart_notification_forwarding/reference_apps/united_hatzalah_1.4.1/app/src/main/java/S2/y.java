package S2;

import F0.G1;
import P2.C0163m;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s2.C0684i;
import w2.InterfaceC0763d;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class y extends T2.a implements w, d, T2.h {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2243e = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    public int f2244d;

    public y(Object obj) {
        this._state$volatile = obj;
    }

    @Override // T2.h
    public final d a(InterfaceC0768i interfaceC0768i, int i, R2.a aVar) {
        if ((((i >= 0 && i < 2) || i == -2) && aVar == R2.a.f2019b) || ((i == 0 || i == -3) && aVar == R2.a.f2018a)) {
            return this;
        }
        return new T2.f(this, interfaceC0768i, i, aVar);
    }

    public final boolean b(Object obj, Object obj2) {
        int i;
        A[] aArr;
        G1 g12;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2243e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.j.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.j.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i3 = this.f2244d;
            if ((i3 & 1) == 0) {
                int i4 = i3 + 1;
                this.f2244d = i4;
                A[] aArr2 = this.f2271a;
                while (true) {
                    if (aArr2 != null) {
                        for (A a2 : aArr2) {
                            if (a2 != null) {
                                AtomicReference atomicReference = a2.f2155a;
                                while (true) {
                                    Object obj4 = atomicReference.get();
                                    if (obj4 != null && obj4 != (g12 = z.f2246b)) {
                                        G1 g13 = z.f2245a;
                                        if (obj4 == g13) {
                                            while (!atomicReference.compareAndSet(obj4, g12)) {
                                                if (atomicReference.get() != obj4) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            while (!atomicReference.compareAndSet(obj4, g13)) {
                                                if (atomicReference.get() != obj4) {
                                                    break;
                                                }
                                            }
                                            ((C0163m) obj4).resumeWith(C0684i.f6340a);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        i = this.f2244d;
                        if (i == i4) {
                            this.f2244d = i4 + 1;
                            return true;
                        }
                        aArr = this.f2271a;
                    }
                    aArr2 = aArr;
                    i4 = i;
                }
            } else {
                this.f2244d = i3 + 2;
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e0, code lost:
    
        if (r0.equals(r4) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0142, code lost:
    
        if (r5 == r3) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0145, code lost:
    
        if (r4 != r3) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ce A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00ce, B:21:0x00d5, B:22:0x00d9, B:26:0x00dc, B:28:0x00fd, B:31:0x010d, B:32:0x0129, B:39:0x0139, B:34:0x0130, B:38:0x0136, B:47:0x00e2, B:50:0x00e9, B:58:0x0054, B:60:0x005f, B:61:0x00b7), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:13:0x0039, B:16:0x00c6, B:18:0x00ce, B:21:0x00d5, B:22:0x00d9, B:26:0x00dc, B:28:0x00fd, B:31:0x010d, B:32:0x0129, B:39:0x0139, B:34:0x0130, B:38:0x0136, B:47:0x00e2, B:50:0x00e9, B:58:0x0054, B:60:0x005f, B:61:0x00b7), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x010c -> B:16:0x00c6). Please report as a decompilation issue!!! */
    @Override // S2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(S2.e r18, w2.InterfaceC0763d r19) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.y.collect(S2.e, w2.d):java.lang.Object");
    }

    @Override // S2.e
    public final Object emit(Object obj, InterfaceC0763d interfaceC0763d) {
        if (obj == null) {
            obj = T2.j.f2291a;
        }
        b(null, obj);
        return C0684i.f6340a;
    }
}
