package io.flutter.plugin.editing;

import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ AutofillValue c(Object obj) {
        return (AutofillValue) obj;
    }

    public static /* bridge */ /* synthetic */ Class h() {
        return AutofillManager.class;
    }

    public static /* synthetic */ Locale.LanguageRange n(String str) {
        return new Locale.LanguageRange(str);
    }

    public static /* synthetic */ void p() {
    }
}
