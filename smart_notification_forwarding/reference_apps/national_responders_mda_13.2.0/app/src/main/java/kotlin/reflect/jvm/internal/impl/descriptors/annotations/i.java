package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* loaded from: classes.dex */
public final class i {
    public static final g a(g gVar, g gVar2) {
        y8.k.e(gVar, "first");
        y8.k.e(gVar2, "second");
        return gVar.isEmpty() ? gVar2 : gVar2.isEmpty() ? gVar : new k(gVar, gVar2);
    }
}
