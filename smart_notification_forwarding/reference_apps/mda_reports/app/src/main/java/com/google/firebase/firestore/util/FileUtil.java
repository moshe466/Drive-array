package com.google.firebase.firestore.util;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* loaded from: classes2.dex */
public class FileUtil {

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    /* loaded from: classes2.dex */
    public static class DefaultFileDeleter {
        private DefaultFileDeleter() {
        }

        public static void delete(File file) {
            try {
                Files.deleteIfExists(file.toPath());
            } catch (IOException e) {
                throw new IOException("Failed to delete file " + file + ": " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LegacyFileDeleter {
        private LegacyFileDeleter() {
        }

        public static void delete(File file) {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("Failed to delete file " + file);
        }
    }

    public static void delete(File file) {
        if (Build.VERSION.SDK_INT >= 26) {
            DefaultFileDeleter.delete(file);
        } else {
            LegacyFileDeleter.delete(file);
        }
    }
}
