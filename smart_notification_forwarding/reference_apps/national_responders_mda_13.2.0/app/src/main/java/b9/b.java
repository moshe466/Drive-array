package b9;

import java.util.Random;
import y8.k;

/* loaded from: classes.dex */
public final class b extends b9.a {

    /* renamed from: h, reason: collision with root package name */
    private final a f4150h = new a();

    /* loaded from: classes.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // b9.a
    public Random c() {
        Random random = this.f4150h.get();
        k.d(random, "implStorage.get()");
        return random;
    }
}
