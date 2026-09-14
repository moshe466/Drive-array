package io.flutter.plugin.editing;

import A.e;
import J.K;
import J.S;
import J.p0;
import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.crashlytics.internal.common.i;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ImeSyncDeferringInsetsCallback {
    private boolean animating;
    private AnimationCallback animationCallback;
    private final int deferredInsetTypes;
    private ImeVisibilityListener imeVisibilityListener;
    private InsetsListener insetsListener;
    private WindowInsets lastWindowInsets;
    private boolean needsSave;
    private View view;

    /* loaded from: classes.dex */
    public class AnimationCallback extends WindowInsetsAnimation$Callback {
        public AnimationCallback() {
            super(1);
        }

        public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
            int typeMask;
            if (ImeSyncDeferringInsetsCallback.this.animating) {
                typeMask = windowInsetsAnimation.getTypeMask();
                if ((typeMask & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                    ImeSyncDeferringInsetsCallback.this.animating = false;
                    if (ImeSyncDeferringInsetsCallback.this.lastWindowInsets != null && ImeSyncDeferringInsetsCallback.this.view != null) {
                        ImeSyncDeferringInsetsCallback.this.view.dispatchApplyWindowInsets(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                    }
                }
            }
            View view = ImeSyncDeferringInsetsCallback.this.view;
            WeakHashMap weakHashMap = S.f954a;
            p0 a2 = K.a(view);
            if (a2 != null && ImeSyncDeferringInsetsCallback.this.imeVisibilityListener != null) {
                ImeSyncDeferringInsetsCallback.this.imeVisibilityListener.onImeVisibilityChanged(a2.f1022a.n(8));
            }
        }

        public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
            int typeMask;
            ImeSyncDeferringInsetsCallback.this.needsSave = true;
            typeMask = windowInsetsAnimation.getTypeMask();
            if ((typeMask & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                ImeSyncDeferringInsetsCallback.this.animating = true;
            }
        }

        public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
            int i;
            Insets insets;
            int i3;
            Insets of;
            WindowInsets build;
            int navigationBars;
            Insets insets2;
            int typeMask;
            if (ImeSyncDeferringInsetsCallback.this.animating && !ImeSyncDeferringInsetsCallback.this.needsSave) {
                Iterator<WindowInsetsAnimation> it = list.iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    typeMask = i.g(it.next()).getTypeMask();
                    if ((typeMask & ImeSyncDeferringInsetsCallback.this.deferredInsetTypes) != 0) {
                        z3 = true;
                    }
                }
                if (z3) {
                    int windowSystemUiVisibility = ImeSyncDeferringInsetsCallback.this.view.getWindowSystemUiVisibility();
                    if ((windowSystemUiVisibility & UserVerificationMethods.USER_VERIFY_NONE) == 0 && (windowSystemUiVisibility & 2) == 0) {
                        navigationBars = WindowInsets.Type.navigationBars();
                        insets2 = windowInsets.getInsets(navigationBars);
                        i = insets2.bottom;
                    } else {
                        i = 0;
                    }
                    com.lt.plugin.lt_plugin.a.l();
                    WindowInsets.Builder j2 = e.j(ImeSyncDeferringInsetsCallback.this.lastWindowInsets);
                    insets = windowInsets.getInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes);
                    i3 = insets.bottom;
                    of = Insets.of(0, 0, 0, Math.max(i3 - i, 0));
                    j2.setInsets(ImeSyncDeferringInsetsCallback.this.deferredInsetTypes, of);
                    View view = ImeSyncDeferringInsetsCallback.this.view;
                    build = j2.build();
                    view.onApplyWindowInsets(build);
                }
            }
            return windowInsets;
        }
    }

    /* loaded from: classes.dex */
    public interface ImeVisibilityListener {
        void onImeVisibilityChanged(boolean z3);
    }

    /* loaded from: classes.dex */
    public class InsetsListener implements View.OnApplyWindowInsetsListener {
        private InsetsListener() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            WindowInsets windowInsets2;
            ImeSyncDeferringInsetsCallback.this.view = view;
            if (ImeSyncDeferringInsetsCallback.this.needsSave) {
                ImeSyncDeferringInsetsCallback.this.lastWindowInsets = windowInsets;
                ImeSyncDeferringInsetsCallback.this.needsSave = false;
            }
            if (ImeSyncDeferringInsetsCallback.this.animating) {
                windowInsets2 = WindowInsets.CONSUMED;
                return windowInsets2;
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    public ImeSyncDeferringInsetsCallback(View view) {
        int ime;
        ime = WindowInsets.Type.ime();
        this.deferredInsetTypes = ime;
        this.animating = false;
        this.needsSave = false;
        this.view = view;
        this.animationCallback = new AnimationCallback();
        this.insetsListener = new InsetsListener();
    }

    public WindowInsetsAnimation$Callback getAnimationCallback() {
        return this.animationCallback;
    }

    public ImeVisibilityListener getImeVisibilityListener() {
        return this.imeVisibilityListener;
    }

    public View.OnApplyWindowInsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    public void install() {
        this.view.setWindowInsetsAnimationCallback(this.animationCallback);
        this.view.setOnApplyWindowInsetsListener(this.insetsListener);
    }

    public void remove() {
        this.view.setWindowInsetsAnimationCallback(null);
        this.view.setOnApplyWindowInsetsListener(null);
    }

    public void setImeVisibilityListener(ImeVisibilityListener imeVisibilityListener) {
        this.imeVisibilityListener = imeVisibilityListener;
    }
}
