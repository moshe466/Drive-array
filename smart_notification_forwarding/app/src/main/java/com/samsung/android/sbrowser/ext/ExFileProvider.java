package com.samsung.android.sbrowser.ext;

import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.FileProvider;

/* loaded from: classes.dex */
public class ExFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.v("ExFileProvider", "insert");
        return null;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        Log.v("ExFileProvider", "onCreate");
        return false;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) {
        Log.v("ExFileProvider", "openAssetFile");
        return super.openAssetFile(uri, str);
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Log.v("ExFileProvider", "query");
        return null;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Log.v("ExFileProvider", "update");
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Log.v("ExFileProvider", "query");
        return super.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }
}
