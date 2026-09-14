package com.samsung.android.sbrowser.ext.clientservice.translator;

import android.content.Context;

/* loaded from: classes.dex */
public class TranslatorFactory {
    static final String TAG = "TranslatorFactory";

    public static Translator createTranslator(Context context) {
        return new SrTranslator();
    }
}
