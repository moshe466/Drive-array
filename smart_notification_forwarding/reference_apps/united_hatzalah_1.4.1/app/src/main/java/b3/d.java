package b3;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.util.function.IntUnaryOperator;

/* loaded from: classes.dex */
public abstract class d extends b {
    static {
        OpenOption[] openOptionArr = c3.a.f3882a;
    }

    public d() {
        Charset.defaultCharset();
        Charset.defaultCharset();
        new IntUnaryOperator() { // from class: b3.c
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i) {
                d.this.getClass();
                if (i <= Integer.MAX_VALUE) {
                    return i;
                }
                throw new IllegalArgumentException(String.format("Request %,d exceeds maximum %,d", Integer.valueOf(i), Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER)));
            }
        };
    }
}
