package z3;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private static final d f16144a = new d();

    private d() {
    }

    public static Comparator a() {
        return f16144a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int z10;
        z10 = g.z((File) obj, (File) obj2);
        return z10;
    }
}
