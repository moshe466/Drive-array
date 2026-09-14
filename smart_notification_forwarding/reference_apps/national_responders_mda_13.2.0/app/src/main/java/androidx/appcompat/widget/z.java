package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* loaded from: classes.dex */
final class z {

    /* renamed from: a, reason: collision with root package name */
    private TextView f1571a;

    /* renamed from: b, reason: collision with root package name */
    private TextClassifier f1572b;

    /* loaded from: classes.dex */
    private static final class a {
        static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextView textView) {
        this.f1571a = (TextView) androidx.core.util.h.f(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1572b;
        return textClassifier == null ? a.a(this.f1571a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f1572b = textClassifier;
    }
}
