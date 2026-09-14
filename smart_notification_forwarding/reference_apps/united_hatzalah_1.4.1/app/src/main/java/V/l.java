package V;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.InterfaceC0309t;

/* loaded from: classes.dex */
public final class l implements DefaultLifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0305o f2405a;

    public l(EmojiCompatInitializer emojiCompatInitializer, AbstractC0305o abstractC0305o) {
        this.f2405a = abstractC0305o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.lang.Runnable] */
    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(InterfaceC0309t interfaceC0309t) {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = b.a(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new Object(), 500L);
        this.f2405a.b(this);
    }
}
