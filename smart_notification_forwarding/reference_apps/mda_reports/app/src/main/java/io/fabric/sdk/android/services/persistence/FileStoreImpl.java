package io.fabric.sdk.android.services.persistence;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.File;

/* loaded from: classes2.dex */
public class FileStoreImpl implements FileStore {
    private final String contentPath;
    private final Context context;
    private final String legacySupport;

    public FileStoreImpl(Kit kit) {
        if (kit.getContext() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.context = kit.getContext();
        this.contentPath = kit.getPath();
        this.legacySupport = "Android/" + this.context.getPackageName();
    }

    File a(File file) {
        if (file == null) {
            Fabric.getLogger().d(Fabric.TAG, "Null File");
            return null;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Fabric.getLogger().w(Fabric.TAG, "Couldn't create file");
        return null;
    }

    boolean a() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        Fabric.getLogger().w(Fabric.TAG, "External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
        return false;
    }

    @Override // io.fabric.sdk.android.services.persistence.FileStore
    public File getCacheDir() {
        return a(this.context.getCacheDir());
    }

    @Override // io.fabric.sdk.android.services.persistence.FileStore
    public File getExternalCacheDir() {
        File file;
        if (!a()) {
            file = null;
        } else if (Build.VERSION.SDK_INT >= 8) {
            file = this.context.getExternalCacheDir();
        } else {
            file = new File(Environment.getExternalStorageDirectory(), this.legacySupport + "/cache/" + this.contentPath);
        }
        return a(file);
    }

    @Override // io.fabric.sdk.android.services.persistence.FileStore
    @TargetApi(8)
    public File getExternalFilesDir() {
        File file = null;
        if (a()) {
            if (Build.VERSION.SDK_INT >= 8) {
                file = this.context.getExternalFilesDir(null);
            } else {
                file = new File(Environment.getExternalStorageDirectory(), this.legacySupport + "/files/" + this.contentPath);
            }
        }
        return a(file);
    }

    @Override // io.fabric.sdk.android.services.persistence.FileStore
    public File getFilesDir() {
        return a(this.context.getFilesDir());
    }
}
