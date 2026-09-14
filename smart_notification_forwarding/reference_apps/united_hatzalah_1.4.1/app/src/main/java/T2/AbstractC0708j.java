package t2;

import java.util.ArrayList;
import java.util.List;

/* renamed from: t2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0708j extends T.b {
    public static ArrayList V(Object... objArr) {
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new C0703e(objArr, true));
    }

    public static List W(Object... elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        if (elements.length > 0) {
            return AbstractC0705g.B(elements);
        }
        return C0716r.f6476a;
    }

    public static void X() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
