package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11606a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f11606a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
