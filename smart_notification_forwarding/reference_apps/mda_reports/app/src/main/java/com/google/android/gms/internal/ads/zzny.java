package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.gass.AdShield2Logger;
import com.google.android.gms.internal.ads.zznx;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public final class zzny<T extends zznx> extends zzddu implements Runnable {
    private volatile boolean zzaek;
    private final T zzbfs;
    private final zznv<T> zzbft;
    public final int zzbfu;
    private final long zzbfv;
    private IOException zzbfw;
    private int zzbfx;
    private volatile Thread zzbfy;
    private final /* synthetic */ zznw zzbfz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzny(zznw zznwVar, Looper looper, T t, zznv<T> zznvVar, int i, long j) {
        super(looper);
        this.zzbfz = zznwVar;
        this.zzbfs = t;
        this.zzbft = zznvVar;
        this.zzbfu = i;
        this.zzbfv = j;
    }

    private final void execute() {
        ExecutorService executorService;
        zzny zznyVar;
        this.zzbfw = null;
        executorService = this.zzbfz.zzbfp;
        zznyVar = this.zzbfz.zzbfq;
        executorService.execute(zznyVar);
    }

    private final void finish() {
        this.zzbfz.zzbfq = null;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzaek) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            execute();
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        finish();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.zzbfv;
        if (this.zzbfs.zzhp()) {
            this.zzbft.zza((zznv<T>) this.zzbfs, elapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            this.zzbft.zza((zznv<T>) this.zzbfs, elapsedRealtime, j, false);
            return;
        }
        if (i2 == 2) {
            this.zzbft.zza(this.zzbfs, elapsedRealtime, j);
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.zzbfw = (IOException) message.obj;
        int zza = this.zzbft.zza((zznv<T>) this.zzbfs, elapsedRealtime, j, this.zzbfw);
        if (zza == 3) {
            this.zzbfz.zzbfr = this.zzbfw;
        } else if (zza != 2) {
            this.zzbfx = zza == 1 ? 1 : this.zzbfx + 1;
            zzek(Math.min((this.zzbfx - 1) * 1000, AdShield2Logger.EVENTID_CLICK_SIGNALS));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzbfy = Thread.currentThread();
            if (!this.zzbfs.zzhp()) {
                String valueOf = String.valueOf(this.zzbfs.getClass().getSimpleName());
                zzon.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.zzbfs.zzhq();
                    zzon.endSection();
                } catch (Throwable th) {
                    zzon.endSection();
                    throw th;
                }
            }
            if (this.zzaek) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.zzaek) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (this.zzaek) {
                return;
            }
            obtainMessage(3, new zzoa(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (this.zzaek) {
                return;
            }
            obtainMessage(3, new zzoa(e3)).sendToTarget();
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzaek) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (InterruptedException unused) {
            zzoc.checkState(this.zzbfs.zzhp());
            if (this.zzaek) {
                return;
            }
            sendEmptyMessage(2);
        }
    }

    public final void zzbc(int i) {
        IOException iOException = this.zzbfw;
        if (iOException != null && this.zzbfx > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzny zznyVar;
        zznyVar = this.zzbfz.zzbfq;
        zzoc.checkState(zznyVar == null);
        this.zzbfz.zzbfq = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzl(boolean z) {
        this.zzaek = z;
        this.zzbfw = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbfs.cancelLoad();
            if (this.zzbfy != null) {
                this.zzbfy.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbft.zza((zznv<T>) this.zzbfs, elapsedRealtime, elapsedRealtime - this.zzbfv, true);
        }
    }
}
