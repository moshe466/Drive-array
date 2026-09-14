package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ac implements com.google.android.play.core.splitinstall.a {
    private final Context a;
    private final com.google.android.play.core.splitcompat.c b;
    private final ba c;
    private final Executor d;
    private final com.google.android.play.core.splitinstall.j e;

    public ac(Context context, Executor executor, ba baVar, com.google.android.play.core.splitcompat.c cVar, com.google.android.play.core.splitinstall.j jVar) {
        this.a = context;
        this.b = cVar;
        this.c = baVar;
        this.d = executor;
        this.e = jVar;
    }

    @SplitInstallErrorCode
    private final Integer a(List<Intent> list) {
        FileLock fileLock;
        try {
            FileChannel channel = new RandomAccessFile(this.b.b(), "rw").getChannel();
            Integer num = null;
            try {
                try {
                    fileLock = channel.tryLock();
                } catch (OverlappingFileLockException unused) {
                    fileLock = null;
                }
                if (fileLock != null) {
                    num = Integer.valueOf(b(list));
                    fileLock.release();
                }
                if (channel != null) {
                    channel.close();
                }
                return num;
            } finally {
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error locking files.", e);
            return -13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.google.android.play.core.splitinstall.d dVar) {
        try {
            if (this.e.a(ag.a(this.a))) {
                Log.i("SplitCompat", "Splits installed.");
                dVar.a();
            } else {
                Log.e("SplitCompat", "Emulating splits failed.");
                dVar.a(-12);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error emulating splits.", e);
            dVar.a(-12);
        }
    }

    @SplitInstallErrorCode
    private final int b(List<Intent> list) {
        try {
            Log.i("SplitCompat", "Copying splits.");
            for (Intent intent : list) {
                String stringExtra = intent.getStringExtra("split_id");
                AssetFileDescriptor openAssetFileDescriptor = this.a.getContentResolver().openAssetFileDescriptor(intent.getData(), "r");
                File a = this.b.a(stringExtra);
                if ((a.exists() && a.length() != openAssetFileDescriptor.getLength()) || !a.exists()) {
                    if (this.b.b(stringExtra).exists()) {
                        continue;
                    } else {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(a);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                bufferedInputStream.close();
                            } finally {
                            }
                        } finally {
                        }
                    }
                }
            }
            Log.i("SplitCompat", "Splits copied.");
            try {
                if (this.c.a()) {
                    Log.i("SplitCompat", "Splits verified.");
                    return 0;
                }
                Log.e("SplitCompat", "Split verification failed.");
                return -11;
            } catch (Exception e) {
                Log.e("SplitCompat", "Error verifying splits.", e);
                return -11;
            }
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error copying splits.", e2);
            return -13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(List<Intent> list, com.google.android.play.core.splitinstall.d dVar) {
        Integer a = a(list);
        if (a == null) {
            return;
        }
        if (a.intValue() == 0) {
            dVar.b();
        } else {
            dVar.a(a.intValue());
        }
    }

    @Override // com.google.android.play.core.splitinstall.a
    public final void a(List<Intent> list, com.google.android.play.core.splitinstall.d dVar) {
        b(list, dVar);
    }

    public final void b(List<Intent> list, com.google.android.play.core.splitinstall.d dVar) {
        if (!this.e.a()) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.d.execute(new ae(this, list, dVar));
    }
}
