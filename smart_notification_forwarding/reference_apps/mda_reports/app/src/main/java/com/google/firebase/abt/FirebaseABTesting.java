package com.google.firebase.abt;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class FirebaseABTesting {
    private final AnalyticsConnector analyticsConnector;

    @Nullable
    private Integer maxUserProperties = null;
    private final String originService;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OriginService {
        public static final String REMOTE_CONFIG = "frc";
    }

    public FirebaseABTesting(Context context, AnalyticsConnector analyticsConnector, String str) {
        this.analyticsConnector = analyticsConnector;
        this.originService = str;
    }

    private void addExperimentToAnalytics(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        this.analyticsConnector.setConditionalUserProperty(conditionalUserProperty);
    }

    private void addExperiments(List<AbtExperimentInfo> list) {
        ArrayDeque arrayDeque = new ArrayDeque(getAllExperimentsInAnalytics());
        int maxUserPropertiesInAnalytics = getMaxUserPropertiesInAnalytics();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            while (arrayDeque.size() >= maxUserPropertiesInAnalytics) {
                a(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).name);
            }
            AnalyticsConnector.ConditionalUserProperty createConditionalUserProperty = createConditionalUserProperty(abtExperimentInfo);
            addExperimentToAnalytics(createConditionalUserProperty);
            arrayDeque.offer(createConditionalUserProperty);
        }
    }

    private static List<AbtExperimentInfo> convertMapsToExperimentInfos(List<Map<String, String>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, String>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(AbtExperimentInfo.a(it.next()));
        }
        return arrayList;
    }

    private AnalyticsConnector.ConditionalUserProperty createConditionalUserProperty(AbtExperimentInfo abtExperimentInfo) {
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = this.originService;
        conditionalUserProperty.creationTimestamp = abtExperimentInfo.b();
        conditionalUserProperty.name = abtExperimentInfo.a();
        conditionalUserProperty.value = abtExperimentInfo.f();
        conditionalUserProperty.triggerEventName = TextUtils.isEmpty(abtExperimentInfo.d()) ? null : abtExperimentInfo.d();
        conditionalUserProperty.triggerTimeout = abtExperimentInfo.e();
        conditionalUserProperty.timeToLive = abtExperimentInfo.c();
        return conditionalUserProperty;
    }

    @WorkerThread
    private List<AnalyticsConnector.ConditionalUserProperty> getAllExperimentsInAnalytics() {
        return this.analyticsConnector.getConditionalUserProperties(this.originService, "");
    }

    private ArrayList<AbtExperimentInfo> getExperimentsToAdd(List<AbtExperimentInfo> list, Set<String> set) {
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<>();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            if (!set.contains(abtExperimentInfo.a())) {
                arrayList.add(abtExperimentInfo);
            }
        }
        return arrayList;
    }

    private ArrayList<AnalyticsConnector.ConditionalUserProperty> getExperimentsToRemove(List<AnalyticsConnector.ConditionalUserProperty> list, Set<String> set) {
        ArrayList<AnalyticsConnector.ConditionalUserProperty> arrayList = new ArrayList<>();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : list) {
            if (!set.contains(conditionalUserProperty.name)) {
                arrayList.add(conditionalUserProperty);
            }
        }
        return arrayList;
    }

    @WorkerThread
    private int getMaxUserPropertiesInAnalytics() {
        if (this.maxUserProperties == null) {
            this.maxUserProperties = Integer.valueOf(this.analyticsConnector.getMaxUserProperties(this.originService));
        }
        return this.maxUserProperties.intValue();
    }

    private void removeExperiments(Collection<AnalyticsConnector.ConditionalUserProperty> collection) {
        Iterator<AnalyticsConnector.ConditionalUserProperty> it = collection.iterator();
        while (it.hasNext()) {
            a(it.next().name);
        }
    }

    private void replaceAllExperimentsWith(List<AbtExperimentInfo> list) {
        if (list.isEmpty()) {
            removeAllExperiments();
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<AbtExperimentInfo> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().a());
        }
        List<AnalyticsConnector.ConditionalUserProperty> allExperimentsInAnalytics = getAllExperimentsInAnalytics();
        HashSet hashSet2 = new HashSet();
        Iterator<AnalyticsConnector.ConditionalUserProperty> it2 = allExperimentsInAnalytics.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().name);
        }
        removeExperiments(getExperimentsToRemove(allExperimentsInAnalytics, hashSet));
        addExperiments(getExperimentsToAdd(list, hashSet2));
    }

    private void throwAbtExceptionIfAnalyticsIsNull() {
        if (this.analyticsConnector == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    @VisibleForTesting
    void a(String str) {
        this.analyticsConnector.clearConditionalUserProperty(str, null, null);
    }

    @WorkerThread
    public void removeAllExperiments() {
        throwAbtExceptionIfAnalyticsIsNull();
        removeExperiments(getAllExperimentsInAnalytics());
    }

    @WorkerThread
    public void replaceAllExperiments(List<Map<String, String>> list) {
        throwAbtExceptionIfAnalyticsIsNull();
        if (list == null) {
            throw new IllegalArgumentException("The replacementExperiments list is null.");
        }
        replaceAllExperimentsWith(convertMapsToExperimentInfos(list));
    }
}
