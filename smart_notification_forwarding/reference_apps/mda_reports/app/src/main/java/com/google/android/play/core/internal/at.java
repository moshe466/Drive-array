package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

/* loaded from: classes.dex */
final class at implements ak {
    @Override // com.google.android.play.core.internal.ak
    public final boolean a(Object obj, File file, File file2) {
        try {
            return !((Boolean) ba.a(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, (Class<String>) String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
