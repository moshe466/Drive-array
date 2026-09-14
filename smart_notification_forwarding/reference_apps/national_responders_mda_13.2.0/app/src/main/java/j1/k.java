package j1;

import com.google.auto.value.AutoValue;
import j1.e;

@AutoValue
/* loaded from: classes.dex */
public abstract class k {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract k a();

        public abstract a b(j1.a aVar);

        public abstract a c(b bVar);
    }

    /* loaded from: classes.dex */
    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        b(int i10) {
            this.value = i10;
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract j1.a b();

    public abstract b c();
}
