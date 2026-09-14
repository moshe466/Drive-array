package w0;

import F0.AbstractC0008a;
import F2.l;
import T.k;
import androidx.window.core.WindowStrictModeException;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import t2.AbstractC0705g;
import t2.C0716r;

/* renamed from: w0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0750f extends p3.h {

    /* renamed from: c, reason: collision with root package name */
    public final Object f6691c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6692d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6693e;

    /* renamed from: f, reason: collision with root package name */
    public final WindowStrictModeException f6694f;

    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Throwable, java.lang.Exception, androidx.window.core.WindowStrictModeException] */
    public C0750f(Object value, String str, C0745a c0745a, int i) {
        Collection collection;
        j.e(value, "value");
        e0.a.j(i, "verificationMode");
        this.f6691c = value;
        this.f6692d = str;
        this.f6693e = i;
        String message = p3.h.n(value, str);
        j.e(message, "message");
        ?? exc = new Exception(message);
        StackTraceElement[] stackTrace = exc.getStackTrace();
        j.d(stackTrace, "stackTrace");
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length >= 0) {
            if (length == 0) {
                collection = C0716r.f6476a;
            } else {
                int length2 = stackTrace.length;
                if (length >= length2) {
                    collection = AbstractC0705g.R(stackTrace);
                } else if (length == 1) {
                    collection = T.b.B(stackTrace[length2 - 1]);
                } else {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i3 = length2 - length; i3 < length2; i3++) {
                        arrayList.add(stackTrace[i3]);
                    }
                    collection = arrayList;
                }
            }
            exc.setStackTrace((StackTraceElement[]) collection.toArray(new StackTraceElement[0]));
            this.f6694f = exc;
            return;
        }
        throw new IllegalArgumentException(AbstractC0008a.j(length, "Requested element count ", " is less than zero.").toString());
    }

    @Override // p3.h
    public final Object i() {
        int b4 = k.b(this.f6693e);
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 == 2) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            String message = p3.h.n(this.f6691c, this.f6692d);
            j.e(message, "message");
            return null;
        }
        throw this.f6694f;
    }

    @Override // p3.h
    public final p3.h A(String str, l lVar) {
        return this;
    }
}
