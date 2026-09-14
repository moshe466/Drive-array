package androidx.lifecycle;

import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements j {

    /* renamed from: a, reason: collision with root package name */
    private final e f3156a;

    /* renamed from: b, reason: collision with root package name */
    private final j f3157b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3158a;

        static {
            int[] iArr = new int[h.b.values().length];
            f3158a = iArr;
            try {
                iArr[h.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3158a[h.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3158a[h.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3158a[h.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3158a[h.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3158a[h.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3158a[h.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(e eVar, j jVar) {
        this.f3156a = eVar;
        this.f3157b = jVar;
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        switch (a.f3158a[bVar.ordinal()]) {
            case 1:
                this.f3156a.c(lVar);
                break;
            case 2:
                this.f3156a.f(lVar);
                break;
            case 3:
                this.f3156a.a(lVar);
                break;
            case 4:
                this.f3156a.e(lVar);
                break;
            case 5:
                this.f3156a.g(lVar);
                break;
            case 6:
                this.f3156a.b(lVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        j jVar = this.f3157b;
        if (jVar != null) {
            jVar.d(lVar, bVar);
        }
    }
}
