package com.google.android.play.core.internal;

import java.io.File;

/* loaded from: classes.dex */
final class ah implements ak {
    @Override // com.google.android.play.core.internal.ak
    public final boolean a(Object obj, File file, File file2) {
        return new File((String) ba.a(obj.getClass(), "optimizedPathFor", String.class, File.class, file, File.class, file2)).exists();
    }
}
