package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.emoji2.text.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements e.d {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f2743b = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f2744a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        TextPaint textPaint = new TextPaint();
        this.f2744a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f2743b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.d
    public boolean a(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = Build.VERSION.SDK_INT;
        if (i13 < 23 && i12 > i13) {
            return false;
        }
        StringBuilder b10 = b();
        b10.setLength(0);
        while (i10 < i11) {
            b10.append(charSequence.charAt(i10));
            i10++;
        }
        return androidx.core.graphics.c.a(this.f2744a, b10.toString());
    }
}
