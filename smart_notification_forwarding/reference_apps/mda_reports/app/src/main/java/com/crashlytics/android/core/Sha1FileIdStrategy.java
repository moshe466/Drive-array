package com.crashlytics.android.core;

import com.crashlytics.android.core.BinaryImagesConverter;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes.dex */
class Sha1FileIdStrategy implements BinaryImagesConverter.FileIdStrategy {
    private static String getFileSHA(String str) {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                String sha1 = CommonUtils.sha1(bufferedInputStream2);
                CommonUtils.closeQuietly(bufferedInputStream2);
                return sha1;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                CommonUtils.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.crashlytics.android.core.BinaryImagesConverter.FileIdStrategy
    public String createId(File file) {
        return getFileSHA(file.getPath());
    }
}
