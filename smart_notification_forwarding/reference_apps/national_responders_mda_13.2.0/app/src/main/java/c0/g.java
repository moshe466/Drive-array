package c0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class g implements TextWatcher {

    /* renamed from: f, reason: collision with root package name */
    private final EditText f4365f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f4366g;

    /* renamed from: h, reason: collision with root package name */
    private e.AbstractC0047e f4367h;

    /* renamed from: i, reason: collision with root package name */
    private int f4368i = Integer.MAX_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private int f4369j = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4370k = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends e.AbstractC0047e {

        /* renamed from: a, reason: collision with root package name */
        private final Reference<EditText> f4371a;

        a(EditText editText) {
            this.f4371a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.e.AbstractC0047e
        public void b() {
            super.b();
            g.b(this.f4371a.get(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditText editText, boolean z10) {
        this.f4365f = editText;
        this.f4366g = z10;
    }

    private e.AbstractC0047e a() {
        if (this.f4367h == null) {
            this.f4367h = new a(this.f4365f);
        }
        return this.f4367h;
    }

    static void b(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return (this.f4370k && (this.f4366g || androidx.emoji2.text.e.h())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void c(boolean z10) {
        if (this.f4370k != z10) {
            if (this.f4367h != null) {
                androidx.emoji2.text.e.b().t(this.f4367h);
            }
            this.f4370k = z10;
            if (z10) {
                b(this.f4365f, androidx.emoji2.text.e.b().d());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f4365f.isInEditMode() || d() || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int d10 = androidx.emoji2.text.e.b().d();
        if (d10 != 0) {
            if (d10 == 1) {
                androidx.emoji2.text.e.b().r((Spannable) charSequence, i10, i10 + i12, this.f4368i, this.f4369j);
                return;
            } else if (d10 != 3) {
                return;
            }
        }
        androidx.emoji2.text.e.b().s(a());
    }
}
