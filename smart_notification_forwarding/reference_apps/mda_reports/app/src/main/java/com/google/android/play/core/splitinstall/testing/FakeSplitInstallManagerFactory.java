package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class FakeSplitInstallManagerFactory {
    public static FakeSplitInstallManager create(Context context, File file) {
        try {
            return new FakeSplitInstallManager(context, file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
