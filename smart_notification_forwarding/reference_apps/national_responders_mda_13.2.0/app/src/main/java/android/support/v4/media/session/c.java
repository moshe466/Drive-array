package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.e;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    final Object f443a;

    /* renamed from: b, reason: collision with root package name */
    android.support.v4.media.session.a f444b;

    /* loaded from: classes.dex */
    private static class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f445a;

        a(c cVar) {
            this.f445a = new WeakReference<>(cVar);
        }

        @Override // android.support.v4.media.session.e.a
        public void a(Object obj) {
            c cVar = this.f445a.get();
            if (cVar != null) {
                cVar.c(MediaMetadataCompat.a(obj));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void b(int i10, int i11, int i12, int i13, int i14) {
            c cVar = this.f445a.get();
            if (cVar != null) {
                cVar.a(new d(i10, i11, i12, i13, i14));
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void c(Object obj) {
            c cVar = this.f445a.get();
            if (cVar == null || cVar.f444b != null) {
                return;
            }
            cVar.d(PlaybackStateCompat.a(obj));
        }

        @Override // android.support.v4.media.session.e.a
        public void d(String str, Bundle bundle) {
            c cVar = this.f445a.get();
            if (cVar != null) {
                if (cVar.f444b == null || Build.VERSION.SDK_INT >= 23) {
                    cVar.h(str, bundle);
                }
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void g(CharSequence charSequence) {
            c cVar = this.f445a.get();
            if (cVar != null) {
                cVar.f(charSequence);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void h() {
            c cVar = this.f445a.get();
            if (cVar != null) {
                cVar.g();
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void j(Bundle bundle) {
            c cVar = this.f445a.get();
            if (cVar != null) {
                cVar.b(bundle);
            }
        }

        @Override // android.support.v4.media.session.e.a
        public void l(List<?> list) {
            c cVar = this.f445a.get();
            if (cVar != null) {
                cVar.e(MediaSessionCompat.QueueItem.b(list));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends a.AbstractBinderC0014a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f446a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(c cVar) {
            this.f446a = new WeakReference<>(cVar);
        }

        @Override // android.support.v4.media.session.a
        public void D(int i10) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(9, Integer.valueOf(i10), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void N(int i10) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(12, Integer.valueOf(i10), null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void O() {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(13, null, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void f0(boolean z10) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(11, Boolean.valueOf(z10), null);
            }
        }

        public void g(CharSequence charSequence) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(6, charSequence, null);
            }
        }

        public void h() {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(8, null, null);
            }
        }

        public void j(Bundle bundle) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(7, bundle, null);
            }
        }

        public void l(List<MediaSessionCompat.QueueItem> list) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(5, list, null);
            }
        }

        @Override // android.support.v4.media.session.a
        public void o(String str, Bundle bundle) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(1, str, bundle);
            }
        }

        @Override // android.support.v4.media.session.a
        public void q(boolean z10) {
        }

        @Override // android.support.v4.media.session.a
        public void q0(PlaybackStateCompat playbackStateCompat) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(2, playbackStateCompat, null);
            }
        }

        public void w0(ParcelableVolumeInfo parcelableVolumeInfo) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(4, parcelableVolumeInfo != null ? new d(parcelableVolumeInfo.f420f, parcelableVolumeInfo.f421g, parcelableVolumeInfo.f422h, parcelableVolumeInfo.f423i, parcelableVolumeInfo.f424j) : null, null);
            }
        }

        public void y(MediaMetadataCompat mediaMetadataCompat) {
            c cVar = this.f446a.get();
            if (cVar != null) {
                cVar.i(3, mediaMetadataCompat, null);
            }
        }
    }

    public c() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f443a = e.a(new a(this));
        } else {
            this.f444b = new b(this);
        }
    }

    public void a(d dVar) {
    }

    public void b(Bundle bundle) {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        i(8, null, null);
    }

    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void d(PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<MediaSessionCompat.QueueItem> list) {
    }

    public void f(CharSequence charSequence) {
    }

    public void g() {
    }

    public void h(String str, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i10, Object obj, Bundle bundle) {
    }
}
