package io.flutter.view;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {
    @Override // io.flutter.util.Predicate
    public final boolean test(Object obj) {
        boolean lambda$shouldSetCollectionInfo$1;
        lambda$shouldSetCollectionInfo$1 = AccessibilityBridge.lambda$shouldSetCollectionInfo$1((AccessibilityBridge.SemanticsNode) obj);
        return lambda$shouldSetCollectionInfo$1;
    }
}
