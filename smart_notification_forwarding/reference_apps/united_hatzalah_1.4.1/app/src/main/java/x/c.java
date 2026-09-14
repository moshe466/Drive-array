package X;

import V.k;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class c extends V.h {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2559a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f2560b;

    public c(TextView textView, d dVar) {
        this.f2559a = new WeakReference(textView);
        this.f2560b = new WeakReference(dVar);
    }

    @Override // V.h
    public final void b() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f2559a.get();
        InputFilter inputFilter = (InputFilter) this.f2560b.get();
        if (inputFilter != null && textView != null && (filters = textView.getFilters()) != null) {
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    if (textView.isAttachedToWindow()) {
                        CharSequence text = textView.getText();
                        k a2 = k.a();
                        if (text == null) {
                            length = 0;
                        } else {
                            a2.getClass();
                            length = text.length();
                        }
                        CharSequence e4 = a2.e(text, 0, length);
                        if (text != e4) {
                            int selectionStart = Selection.getSelectionStart(e4);
                            int selectionEnd = Selection.getSelectionEnd(e4);
                            textView.setText(e4);
                            if (e4 instanceof Spannable) {
                                Spannable spannable = (Spannable) e4;
                                if (selectionStart >= 0 && selectionEnd >= 0) {
                                    Selection.setSelection(spannable, selectionStart, selectionEnd);
                                    return;
                                } else if (selectionStart >= 0) {
                                    Selection.setSelection(spannable, selectionStart);
                                    return;
                                } else {
                                    if (selectionEnd >= 0) {
                                        Selection.setSelection(spannable, selectionEnd);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }
}
