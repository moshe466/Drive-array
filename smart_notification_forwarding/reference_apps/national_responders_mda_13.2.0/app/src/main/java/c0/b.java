package c0;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.n;

/* loaded from: classes.dex */
final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f4349a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f4350b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f4351c;

    @SuppressLint({"PrivateApi"})
    private b() {
        try {
            f4351c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f4350b == null) {
            synchronized (f4349a) {
                if (f4350b == null) {
                    f4350b = new b();
                }
            }
        }
        return f4350b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f4351c;
        return cls != null ? n.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
