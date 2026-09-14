package com.google.firebase.installations;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final FileChannel f7353a;

    /* renamed from: b, reason: collision with root package name */
    private final FileLock f7354b;

    private b(FileChannel fileChannel, FileLock fileLock) {
        this.f7353a = fileChannel;
        this.f7354b = fileLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Context context, String str) {
        FileChannel fileChannel;
        FileLock fileLock;
        try {
            fileChannel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLock = fileChannel.lock();
            } catch (IOException | Error | OverlappingFileLockException unused) {
                fileLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException unused2) {
            fileChannel = null;
            fileLock = null;
        }
        try {
            return new b(fileChannel, fileLock);
        } catch (IOException | Error | OverlappingFileLockException unused3) {
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused4) {
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused5) {
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        try {
            this.f7354b.release();
            this.f7353a.close();
        } catch (IOException unused) {
        }
    }
}
