package com.samsung.android.sbrowser.ext;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ParcelFileDescriptorFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ExContentProvider extends ContentProvider {
    private final int a = 1;
    private String b = null;
    Handler c = new Handler(new a());

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (ExContentProvider.this.b == null) {
                    return false;
                }
                File file = new File(ExContentProvider.this.getContext().getFilesDir(), ExContentProvider.this.b);
                if (file.exists()) {
                    Log.v("ExContentProvider", "openFile clear file");
                    file.delete();
                }
                ExContentProvider.this.b = null;
            }
            return true;
        }
    }

    private void b() {
        Log.i("ExContentProvider", "removeClearMessage");
        if (this.c.hasMessages(1)) {
            this.c.removeMessages(1);
        }
    }

    private void c() {
        Log.i("ExContentProvider", "sendClearMessage");
        this.c.sendMessageDelayed(this.c.obtainMessage(1), 600000L);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.v("ExContentProvider", "insert");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.v("ExContentProvider", "onCreate");
        return false;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) {
        Log.v("ExContentProvider", "openAssetFile");
        return super.openAssetFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        String str2 = null;
        if (!ExtensionUtils.enabledCallerCheckWithName(getCallingPackage())) {
            return null;
        }
        Log.v("ExContentProvider", "openFile");
        b();
        if (this.b == null) {
            a();
        }
        File[] listFiles = new File(getContext().getFilesDir().getAbsolutePath()).listFiles();
        Log.d("ExContentProvider", "openFile Size: " + listFiles.length);
        for (File file : listFiles) {
            if (a(file.getName()).equals("crx")) {
                str2 = file.getName();
            }
        }
        if (str2 == null) {
            throw new FileNotFoundException();
        }
        this.b = str2;
        File file2 = new File(getContext().getFilesDir(), str2);
        c();
        return ParcelFileDescriptor.open(file2, ParcelFileDescriptorFactory.MODE_READ_ONLY);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Log.v("ExContentProvider", "query");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Log.v("ExContentProvider", "update");
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Log.v("ExContentProvider", "query");
        return super.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    private void a(InputStream inputStream, OutputStream outputStream) {
        Log.v("ExContentProvider", "copyFile");
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private void a() {
        String[] strArr;
        Log.v("ExContentProvider", "copySixAssets");
        AssetManager assets = getContext().getAssets();
        try {
            strArr = assets.list(JsonProperty.USE_DEFAULT_NAME);
        } catch (IOException e) {
            Log.e("ExContentProvider", "copySixAssets Failed to get asset file list.", e);
            strArr = null;
        }
        for (String str : strArr) {
            if (a(str).equals("crx")) {
                Log.v("ExContentProvider", "copySixAssets copy file!");
                try {
                    InputStream open = assets.open(str);
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(getContext().getFilesDir().getAbsolutePath(), str));
                    a(open, fileOutputStream);
                    open.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    Log.e("ExContentProvider", "copySixAssetsFailed to copy asset file: " + str, e2);
                }
            }
        }
    }

    public static String a(String str) {
        return MimeTypeMap.getFileExtensionFromUrl(str);
    }
}
