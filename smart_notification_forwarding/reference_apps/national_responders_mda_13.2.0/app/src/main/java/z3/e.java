package z3;

import java.io.File;
import java.util.Comparator;

/* loaded from: classes.dex */
final /* synthetic */ class e implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private static final e f16145a = new e();

    private e() {
    }

    public static Comparator a() {
        return f16145a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((File) obj2).getName().compareTo(((File) obj).getName());
        return compareTo;
    }
}
