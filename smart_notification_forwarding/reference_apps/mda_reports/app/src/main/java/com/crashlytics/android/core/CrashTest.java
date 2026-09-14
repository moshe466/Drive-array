package com.crashlytics.android.core;

import android.os.AsyncTask;
import androidx.exifinterface.media.ExifInterface;
import io.fabric.sdk.android.Fabric;

/* loaded from: classes.dex */
public class CrashTest {
    private void privateMethodThatThrowsException(String str) {
        throw new RuntimeException(str);
    }

    public void crashAsyncTask(final long j) {
        new AsyncTask<Void, Void, Void>() { // from class: com.crashlytics.android.core.CrashTest.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused) {
                }
                CrashTest.this.throwRuntimeException("Background thread crash");
                return null;
            }
        }.execute(null);
    }

    public void indexOutOfBounds() {
        int i = new int[2][10];
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Out of bounds value: " + i);
    }

    public int stackOverflow() {
        return stackOverflow() + ((int) Math.random());
    }

    public void throwFiveChainedExceptions() {
        try {
            privateMethodThatThrowsException("1");
        } catch (Exception e) {
            try {
                throw new RuntimeException(ExifInterface.GPS_MEASUREMENT_2D, e);
            } catch (Exception e2) {
                try {
                    throw new RuntimeException(ExifInterface.GPS_MEASUREMENT_3D, e2);
                } catch (Exception e3) {
                    try {
                        throw new RuntimeException("4", e3);
                    } catch (Exception e4) {
                        throw new RuntimeException("5", e4);
                    }
                }
            }
        }
    }

    public void throwRuntimeException(String str) {
        throw new RuntimeException(str);
    }
}
