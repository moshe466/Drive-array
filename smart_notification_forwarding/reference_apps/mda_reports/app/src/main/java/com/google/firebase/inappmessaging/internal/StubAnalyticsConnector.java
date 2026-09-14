package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class StubAnalyticsConnector implements AnalyticsConnector {
    public static final StubAnalyticsConnector instance = new StubAnalyticsConnector();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class AnalyticsConnectorHandle implements AnalyticsConnector.AnalyticsConnectorHandle {
        static final AnalyticsConnectorHandle a = new AnalyticsConnectorHandle();

        private AnalyticsConnectorHandle() {
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void registerEventNames(Set<String> set) {
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregister() {
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregisterEventNames() {
        }
    }

    private StubAnalyticsConnector() {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable String str2) {
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(@NonNull String str) {
        return 0;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map<String, Object> getUserProperties(boolean z) {
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        return AnalyticsConnectorHandle.a;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(@NonNull String str, @NonNull String str2, Object obj) {
    }
}
