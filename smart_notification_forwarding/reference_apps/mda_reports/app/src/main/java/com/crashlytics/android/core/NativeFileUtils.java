package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class NativeFileUtils {
    private NativeFileUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(File file) {
        File filter = filter(file, ".device_info");
        if (filter == null) {
            return null;
        }
        return c(filter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(File file, Context context) {
        File filter = filter(file, ".maps");
        if (filter != null) {
            return binaryImagesJsonFromMapsFile(filter, context);
        }
        File filter2 = filter(file, ".binary_libs");
        if (filter2 != null) {
            return binaryImagesJsonFromBinaryLibsFile(filter2, context);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(File file) {
        File filter = filter(file, ".dmp");
        return filter == null ? new byte[0] : minidumpFromFile(filter);
    }

    private static byte[] binaryImagesJsonFromBinaryLibsFile(File file, Context context) {
        byte[] c = c(file);
        if (c == null || c.length == 0) {
            return null;
        }
        return processBinaryImages(context, new String(c));
    }

    private static byte[] binaryImagesJsonFromMapsFile(File file, Context context) {
        BufferedReader bufferedReader;
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                byte[] a = new BinaryImagesConverter(context, new Sha1FileIdStrategy()).a(bufferedReader);
                CommonUtils.closeQuietly(bufferedReader);
                return a;
            } catch (Throwable th) {
                th = th;
                CommonUtils.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] readBytes = readBytes(fileInputStream);
                CommonUtils.closeQuietly(fileInputStream);
                return readBytes;
            } catch (FileNotFoundException unused) {
                CommonUtils.closeQuietly(fileInputStream);
                return null;
            } catch (IOException unused2) {
                CommonUtils.closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                CommonUtils.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            fileInputStream = null;
        } catch (IOException unused4) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static File filter(File file, String str) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    private static byte[] minidumpFromFile(File file) {
        return c(file);
    }

    private static byte[] processBinaryImages(Context context, String str) {
        return new BinaryImagesConverter(context, new Sha1FileIdStrategy()).a(str);
    }

    private static byte[] readBytes(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
