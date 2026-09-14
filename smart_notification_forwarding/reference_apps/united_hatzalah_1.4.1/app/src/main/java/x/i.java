package X;

import V.k;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class i implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f2571a;

    /* renamed from: b, reason: collision with root package name */
    public h f2572b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2573c = true;

    public i(EditText editText) {
        this.f2571a = editText;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            k a2 = k.a();
            if (editableText == null) {
                length = 0;
            } else {
                a2.getClass();
                length = editableText.length();
            }
            a2.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i4) {
        EditText editText = this.f2571a;
        if (!editText.isInEditMode() && this.f2573c && k.f2396j != null && i3 <= i4 && (charSequence instanceof Spannable)) {
            int b4 = k.a().b();
            if (b4 != 0) {
                if (b4 != 1) {
                    if (b4 != 3) {
                        return;
                    }
                } else {
                    k.a().e((Spannable) charSequence, i, i4 + i);
                    return;
                }
            }
            k a2 = k.a();
            if (this.f2572b == null) {
                this.f2572b = new h(editText);
            }
            a2.f(this.f2572b);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i4) {
    }
}
