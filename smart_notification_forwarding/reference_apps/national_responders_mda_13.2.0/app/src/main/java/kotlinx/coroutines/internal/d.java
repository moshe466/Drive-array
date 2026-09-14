package kotlinx.coroutines.internal;

import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
/* loaded from: classes.dex */
final class d extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f11604a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final a f11605b = new a();

    /* loaded from: classes.dex */
    public static final class a extends ClassValue<x8.l<? super Throwable, ? extends Throwable>> {
        a() {
        }
    }

    private d() {
    }

    @Override // kotlinx.coroutines.internal.e
    public x8.l<Throwable, Throwable> a(Class<? extends Throwable> cls) {
        return (x8.l) f11605b.get(cls);
    }
}
