package e0;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final c f4443a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4444b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f4445c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f4446d;

    public static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                a.k(autoCloseable);
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
    }
}
