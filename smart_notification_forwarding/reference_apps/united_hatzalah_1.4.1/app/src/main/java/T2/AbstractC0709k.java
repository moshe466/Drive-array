package t2;

import java.util.Collection;

/* renamed from: t2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0709k extends AbstractC0708j {
    public static int Y(Iterable iterable, int i) {
        kotlin.jvm.internal.j.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return i;
    }
}
