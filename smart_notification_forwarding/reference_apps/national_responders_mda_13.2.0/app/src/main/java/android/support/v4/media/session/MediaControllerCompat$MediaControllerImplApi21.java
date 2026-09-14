package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21 {

    /* renamed from: a, reason: collision with root package name */
    final Object f409a;

    /* renamed from: b, reason: collision with root package name */
    private final List<c> f410b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<c, a> f411c;

    /* renamed from: d, reason: collision with root package name */
    final MediaSessionCompat.Token f412d;

    /* loaded from: classes.dex */
    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f413f;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i10, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f413f.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.f409a) {
                mediaControllerCompat$MediaControllerImplApi21.f412d.b(b.a.i(androidx.core.app.f.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.f412d.c(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                mediaControllerCompat$MediaControllerImplApi21.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends c.b {
        a(c cVar) {
            super(cVar);
        }

        @Override // android.support.v4.media.session.c.b, android.support.v4.media.session.a
        public void g(CharSequence charSequence) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.b, android.support.v4.media.session.a
        public void h() {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.b, android.support.v4.media.session.a
        public void j(Bundle bundle) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.b, android.support.v4.media.session.a
        public void l(List<MediaSessionCompat.QueueItem> list) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.b, android.support.v4.media.session.a
        public void w0(ParcelableVolumeInfo parcelableVolumeInfo) {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.b, android.support.v4.media.session.a
        public void y(MediaMetadataCompat mediaMetadataCompat) {
            throw new AssertionError();
        }
    }

    void a() {
        if (this.f412d.a() == null) {
            return;
        }
        for (c cVar : this.f410b) {
            a aVar = new a(cVar);
            this.f411c.put(cVar, aVar);
            cVar.f444b = aVar;
            try {
                this.f412d.a().w(aVar);
                cVar.i(13, null, null);
            } catch (RemoteException unused) {
            }
        }
        this.f410b.clear();
    }
}
