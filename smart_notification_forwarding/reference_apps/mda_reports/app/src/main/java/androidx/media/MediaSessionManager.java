package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

/* loaded from: classes.dex */
public final class MediaSessionManager {
    static final boolean b = Log.isLoggable("MediaSessionManager", 3);
    private static final Object sLock = new Object();
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl a;

    /* loaded from: classes.dex */
    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl);
    }

    /* loaded from: classes.dex */
    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl a;

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }

        public RemoteUserInfo(@NonNull String str, int i, int i2) {
            this.a = Build.VERSION.SDK_INT >= 28 ? new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2) : new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.a.equals(((RemoteUserInfo) obj).a);
            }
            return false;
        }

        @NonNull
        public String getPackageName() {
            return this.a.getPackageName();
        }

        public int getPid() {
            return this.a.getPid();
        }

        public int getUid() {
            return this.a.getUid();
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    private MediaSessionManager(Context context) {
        int i = Build.VERSION.SDK_INT;
        this.a = i >= 28 ? new MediaSessionManagerImplApi28(context) : i >= 21 ? new MediaSessionManagerImplApi21(context) : new MediaSessionManagerImplBase(context);
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context context) {
        MediaSessionManager mediaSessionManager = sSessionManager;
        if (mediaSessionManager == null) {
            synchronized (sLock) {
                mediaSessionManager = sSessionManager;
                if (mediaSessionManager == null) {
                    sSessionManager = new MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = sSessionManager;
                }
            }
        }
        return mediaSessionManager;
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.a.isTrustedForMediaControl(remoteUserInfo.a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
