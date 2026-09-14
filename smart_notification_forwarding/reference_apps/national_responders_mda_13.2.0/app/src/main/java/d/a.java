package d;

import android.content.Context;
import android.content.Intent;
import y8.k;

/* loaded from: classes.dex */
public abstract class a<I, O> {

    /* renamed from: d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0139a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f8620a;

        public C0139a(T t10) {
            this.f8620a = t10;
        }

        public final T a() {
            return this.f8620a;
        }
    }

    public abstract Intent a(Context context, I i10);

    public C0139a<O> b(Context context, I i10) {
        k.e(context, "context");
        return null;
    }

    public abstract O c(int i10, Intent intent);
}
