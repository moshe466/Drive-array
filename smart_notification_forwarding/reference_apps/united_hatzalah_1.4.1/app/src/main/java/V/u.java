package V;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class u implements TextWatcher, SpanWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2433a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f2434b = new AtomicInteger(0);

    public u(Object obj) {
        this.f2433a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f2433a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        ((TextWatcher) this.f2433a).beforeTextChanged(charSequence, i, i3, i4);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i3) {
        if (this.f2434b.get() > 0 && (obj instanceof w)) {
            return;
        }
        ((SpanWatcher) this.f2433a).onSpanAdded(spannable, obj, i, i3);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (this.f2434b.get() > 0 && (obj instanceof w)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (i > i3) {
                i = 0;
            }
            if (i4 > i5) {
                i6 = i;
                i7 = 0;
                ((SpanWatcher) this.f2433a).onSpanChanged(spannable, obj, i6, i3, i7, i5);
            }
        }
        i6 = i;
        i7 = i4;
        ((SpanWatcher) this.f2433a).onSpanChanged(spannable, obj, i6, i3, i7, i5);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i3) {
        if (this.f2434b.get() > 0 && (obj instanceof w)) {
            return;
        }
        ((SpanWatcher) this.f2433a).onSpanRemoved(spannable, obj, i, i3);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        ((TextWatcher) this.f2433a).onTextChanged(charSequence, i, i3, i4);
    }
}
