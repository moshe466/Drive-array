package com.samsung.android.sbrowser.ext.clientservice.asr;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public class ASRFactory {
    static final String CRAFT_ASR = "CraftASR";
    static final String SAMSUNG_ASR = "SamsungASR";
    static final String TAG = "ASRFactory";

    public static ASR createASR(Context context, String str) {
        Log.d(TAG, "createASR " + str);
        if (str.equals(CRAFT_ASR)) {
            Log.d(TAG, "new CraftASR");
            return new CraftASREngine();
        }
        str.equals(SAMSUNG_ASR);
        return null;
    }
}
