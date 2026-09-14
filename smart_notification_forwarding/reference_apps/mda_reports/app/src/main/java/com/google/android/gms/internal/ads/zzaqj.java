package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@SafeParcelable.Class(creator = "LargeParcelTeleporterCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzaqj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqj> CREATOR = new zzaql();

    @SafeParcelable.Field(id = 2)
    private ParcelFileDescriptor zzdlr;
    private Parcelable zzdls = null;
    private boolean zzdlt = true;

    @SafeParcelable.Constructor
    public zzaqj(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzdlr = parcelFileDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(OutputStream outputStream, byte[] bArr) {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            try {
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
            IOUtils.closeQuietly(dataOutputStream);
        } catch (IOException e2) {
            e = e2;
            dataOutputStream2 = dataOutputStream;
            zzayu.zzc("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "LargeParcelTeleporter.pipeData.1");
            if (dataOutputStream2 == null) {
                IOUtils.closeQuietly(outputStream);
            } else {
                IOUtils.closeQuietly(dataOutputStream2);
            }
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 == null) {
                IOUtils.closeQuietly(outputStream);
            } else {
                IOUtils.closeQuietly(dataOutputStream2);
            }
            throw th;
        }
    }

    private static <T> ParcelFileDescriptor zzh(final byte[] bArr) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] createPipe;
        try {
            createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
        } catch (IOException e) {
            e = e;
            autoCloseOutputStream = null;
        }
        try {
            zzazd.zzdwe.execute(new Runnable(autoCloseOutputStream, bArr) { // from class: com.google.android.gms.internal.ads.zzaqi
                private final OutputStream zzdlp;
                private final byte[] zzdlq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdlp = autoCloseOutputStream;
                    this.zzdlq = bArr;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzaqj.a(this.zzdlp, this.zzdlq);
                }
            });
            return createPipe[0];
        } catch (IOException e2) {
            e = e2;
            zzayu.zzc("Error transporting the ad response", e);
            com.google.android.gms.ads.internal.zzq.zzku().zza(e, "LargeParcelTeleporter.pipeData.2");
            IOUtils.closeQuietly(autoCloseOutputStream);
            return null;
        }
    }

    private final ParcelFileDescriptor zzty() {
        if (this.zzdlr == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzdls.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzdlr = zzh(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.zzdlr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzty();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdlr, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzdlt) {
            ParcelFileDescriptor parcelFileDescriptor = this.zzdlr;
            if (parcelFileDescriptor == null) {
                zzayu.zzex("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    IOUtils.closeQuietly(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        this.zzdls = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.zzdlt = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e) {
                    zzayu.zzc("Could not read from parcel file descriptor", e);
                    IOUtils.closeQuietly(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.closeQuietly(dataInputStream);
                throw th2;
            }
        }
        return (T) this.zzdls;
    }
}
