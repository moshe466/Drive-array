package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public abstract class RemoteCreator<T> {
    private final String zza;
    private Object zzb;

    /* loaded from: classes.dex */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    public RemoteCreator(String str) {
        this.zza = str;
    }

    public abstract T getRemoteCreator(IBinder iBinder);

    public final T getRemoteCreatorInstance(Context context) {
        if (this.zzb == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    this.zzb = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zza).newInstance());
                } catch (ClassNotFoundException e4) {
                    throw new RemoteCreatorException("Could not load creator class.", e4);
                } catch (IllegalAccessException e5) {
                    throw new RemoteCreatorException("Could not access creator.", e5);
                } catch (InstantiationException e6) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e6);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return (T) this.zzb;
    }
}
