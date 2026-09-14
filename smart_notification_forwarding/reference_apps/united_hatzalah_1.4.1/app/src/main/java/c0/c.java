package C0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* loaded from: classes.dex */
public final class c extends kotlin.jvm.internal.k implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public static final c f85a = new kotlin.jvm.internal.k(1);

    @Override // F2.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(SidecarDisplayFeature require) {
        kotlin.jvm.internal.j.e(require, "$this$require");
        boolean z3 = true;
        if (require.getType() != 1 && require.getType() != 2) {
            z3 = false;
        }
        return Boolean.valueOf(z3);
    }
}
