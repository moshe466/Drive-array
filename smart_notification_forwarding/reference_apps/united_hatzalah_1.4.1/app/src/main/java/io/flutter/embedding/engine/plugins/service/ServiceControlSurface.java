package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.AbstractC0305o;

/* loaded from: classes.dex */
public interface ServiceControlSurface {
    void attachToService(Service service, AbstractC0305o abstractC0305o, boolean z3);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
