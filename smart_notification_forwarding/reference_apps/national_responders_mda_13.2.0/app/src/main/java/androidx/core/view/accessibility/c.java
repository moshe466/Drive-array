package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public final class c {

    /* loaded from: classes.dex */
    static class a {
        static boolean a(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0039c(bVar));
        }

        static boolean b(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0039c(bVar));
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onTouchExplorationStateChanged(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.view.accessibility.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class AccessibilityManagerTouchExplorationStateChangeListenerC0039c implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final b f2531a;

        AccessibilityManagerTouchExplorationStateChangeListenerC0039c(b bVar) {
            this.f2531a = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AccessibilityManagerTouchExplorationStateChangeListenerC0039c) {
                return this.f2531a.equals(((AccessibilityManagerTouchExplorationStateChangeListenerC0039c) obj).f2531a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2531a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z10) {
            this.f2531a.onTouchExplorationStateChanged(z10);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, b bVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.a(accessibilityManager, bVar);
        }
        return false;
    }

    public static boolean b(AccessibilityManager accessibilityManager, b bVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.b(accessibilityManager, bVar);
        }
        return false;
    }
}
