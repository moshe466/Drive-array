package D0;

import android.content.pm.SigningInfo;
import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ SigningInfo e(Parcelable parcelable) {
        return (SigningInfo) parcelable;
    }

    public static /* bridge */ /* synthetic */ SigningInfo f(Object obj) {
        return (SigningInfo) obj;
    }

    public static /* synthetic */ PrecomputedText.Params.Builder i(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }
}
