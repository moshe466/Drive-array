package m;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.google.android.gms.common.api.Api;

/* renamed from: m.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0543f0 {
    public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i, int i3, TextView textView, TextPaint textPaint, AbstractC0549i0 abstractC0549i0) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            abstractC0549i0.a(obtain, textView);
        } catch (ClassCastException unused) {
        }
        return obtain.build();
    }
}
