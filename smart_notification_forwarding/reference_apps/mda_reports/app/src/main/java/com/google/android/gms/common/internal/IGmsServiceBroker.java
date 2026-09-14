package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes.dex */
public interface IGmsServiceBroker extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class zza implements IGmsServiceBroker {
            private final IBinder zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            public zza(IBinder iBinder) {
                this.zza = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.zza;
            }

            @Override // com.google.android.gms.common.internal.IGmsServiceBroker
            public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @KeepForSdk
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00e0, code lost:
        
            android.os.Bundle.CREATOR.createFromParcel(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00c7, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00ce, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00de, code lost:
        
            if (r5.readInt() != 0) goto L69;
         */
        @Override // android.os.Binder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.IGmsServiceBroker.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    @KeepForSdk
    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest);
}
