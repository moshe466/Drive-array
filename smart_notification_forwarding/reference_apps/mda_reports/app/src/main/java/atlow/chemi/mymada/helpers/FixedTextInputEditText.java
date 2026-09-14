package atlow.chemi.mymada.helpers;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class FixedTextInputEditText extends TextInputEditText {
    public FixedTextInputEditText(Context context) {
        super(context);
    }

    public FixedTextInputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedTextInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private CharSequence getSuperHintHack() {
        Field declaredField = TextView.class.getDeclaredField("mHint");
        declaredField.setAccessible(true);
        return (CharSequence) declaredField.get(this);
    }

    @Override // com.google.android.material.textfield.TextInputEditText, android.widget.TextView
    public CharSequence getHint() {
        if (!Build.MANUFACTURER.toUpperCase().contains("MEIZU") || Build.VERSION.SDK_INT >= 28) {
            return super.getHint();
        }
        try {
            return getSuperHintHack();
        } catch (Exception unused) {
            return super.getHint();
        }
    }
}
