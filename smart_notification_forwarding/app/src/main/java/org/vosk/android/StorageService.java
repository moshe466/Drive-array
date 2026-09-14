package org.vosk.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.vosk.Model;
import org.vosk.android.StorageService;

/* loaded from: classes2.dex */
public class StorageService {
    protected static final String TAG = "StorageService";

    /* loaded from: classes2.dex */
    public interface Callback<R> {
        void onComplete(R result);
    }

    public static void unpack(final Context context, final String sourcePath, final String targetPath, final Callback<Model> completeCallback, final Callback<IOException> errorCallback) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        final Handler handler = new Handler(Looper.getMainLooper());
        newSingleThreadExecutor.execute(new Runnable() { // from class: org.vosk.android.StorageService$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                StorageService.lambda$unpack$2(context, sourcePath, targetPath, handler, completeCallback, errorCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$unpack$2(final Context context, final String sourcePath, final String targetPath, final Handler handler, final Callback completeCallback, final Callback errorCallback) {
        try {
            final Model model = new Model(sync(context, sourcePath, targetPath));
            handler.post(new Runnable() { // from class: org.vosk.android.StorageService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    StorageService.Callback.this.onComplete(model);
                }
            });
        } catch (IOException e) {
            handler.post(new Runnable() { // from class: org.vosk.android.StorageService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    StorageService.Callback.this.onComplete(e);
                }
            });
        }
    }

    public static String sync(Context context, String sourcePath, String targetPath) throws IOException {
        AssetManager assets = context.getAssets();
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            throw new IOException("cannot get external files dir, external storage state is " + Environment.getExternalStorageState());
        }
        File file = new File(externalFilesDir, targetPath);
        String absolutePath = new File(file, sourcePath).getAbsolutePath();
        try {
            if (readLine(new FileInputStream(new File(file, sourcePath + "/uuid"))).equals(readLine(assets.open(sourcePath + "/uuid")))) {
                return absolutePath;
            }
        } catch (FileNotFoundException unused) {
        }
        deleteContents(file);
        copyAssets(assets, sourcePath, file);
        copyFile(assets, sourcePath + "/uuid", file);
        return absolutePath;
    }

    private static String readLine(InputStream is) throws IOException {
        return new BufferedReader(new InputStreamReader(is)).readLine();
    }

    private static boolean deleteContents(File dir) {
        File[] listFiles = dir.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    z &= deleteContents(file);
                }
                if (!file.delete()) {
                    z = false;
                }
            }
        }
        return z;
    }

    private static void copyAssets(AssetManager assetManager, String path, File outPath) throws IOException {
        String[] list = assetManager.list(path);
        if (list == null) {
            return;
        }
        if (list.length == 0) {
            if (path.endsWith("uuid")) {
                return;
            }
            copyFile(assetManager, path, outPath);
            return;
        }
        File file = new File(outPath, path);
        if (!file.exists()) {
            String str = TAG;
            Log.v(str, "Making directory " + file.getAbsolutePath());
            if (!file.mkdirs()) {
                Log.v(str, "Failed to create directory " + file.getAbsolutePath());
            }
        }
        for (String str2 : list) {
            copyAssets(assetManager, path + "/" + str2, outPath);
        }
    }

    private static void copyFile(AssetManager assetManager, String fileName, File outPath) throws IOException {
        Log.v(TAG, "Copy " + fileName + " to " + outPath);
        InputStream open = assetManager.open(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(outPath + "/" + fileName);
        byte[] bArr = new byte[4000];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                fileOutputStream.close();
                return;
            }
        }
    }
}
