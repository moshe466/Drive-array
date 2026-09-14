package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import b2.p;
import com.google.android.gms.internal.measurement.f;
import com.google.android.gms.measurement.internal.t4;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v2.g;
import v2.m;

@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {

    /* renamed from: d, reason: collision with root package name */
    private static volatile AppMeasurement f5783d;

    /* renamed from: a, reason: collision with root package name */
    private final t4 f5784a;

    /* renamed from: b, reason: collision with root package name */
    private final m f5785b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f5786c;

    /* loaded from: classes.dex */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(Bundle bundle) {
            p.k(bundle);
            this.mAppId = (String) g.a(bundle, "app_id", String.class, null);
            this.mOrigin = (String) g.a(bundle, "origin", String.class, null);
            this.mName = (String) g.a(bundle, "name", String.class, null);
            this.mValue = g.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) g.a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) g.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) g.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) g.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) g.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) g.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) g.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) g.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) g.a(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) g.a(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) g.a(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) g.a(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }

        final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                g.b(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }
    }

    private AppMeasurement(t4 t4Var) {
        p.k(t4Var);
        this.f5784a = t4Var;
        this.f5785b = null;
        this.f5786c = false;
    }

    private AppMeasurement(m mVar) {
        p.k(mVar);
        this.f5785b = mVar;
        this.f5784a = null;
        this.f5786c = true;
    }

    private static AppMeasurement a(Context context, String str, String str2) {
        if (f5783d == null) {
            synchronized (AppMeasurement.class) {
                if (f5783d == null) {
                    m b10 = b(context, null);
                    if (b10 != null) {
                        f5783d = new AppMeasurement(b10);
                    } else {
                        f5783d = new AppMeasurement(t4.b(context, new f(0L, 0L, true, null, null, null, null), null));
                    }
                }
            }
        }
        return f5783d;
    }

    private static m b(Context context, Bundle bundle) {
        return (m) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return a(context, null, null);
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        if (this.f5786c) {
            this.f5785b.e(str);
        } else {
            this.f5784a.S().z(str, this.f5784a.f().b());
        }
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.f5786c) {
            this.f5785b.k(str, str2, bundle);
        } else {
            this.f5784a.F().u0(str, str2, bundle);
        }
    }

    @Keep
    public void endAdUnitExposure(String str) {
        if (this.f5786c) {
            this.f5785b.i(str);
        } else {
            this.f5784a.S().D(str, this.f5784a.f().b());
        }
    }

    @Keep
    public long generateEventId() {
        return this.f5786c ? this.f5785b.d() : this.f5784a.G().E0();
    }

    @Keep
    public String getAppInstanceId() {
        return this.f5786c ? this.f5785b.b() : this.f5784a.F().i0();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> g10 = this.f5786c ? this.f5785b.g(str, str2) : this.f5784a.F().B(str, str2);
        ArrayList arrayList = new ArrayList(g10 == null ? 0 : g10.size());
        Iterator<Bundle> it = g10.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.f5786c ? this.f5785b.a() : this.f5784a.F().l0();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.f5786c ? this.f5785b.zza() : this.f5784a.F().k0();
    }

    @Keep
    public String getGmpAppId() {
        return this.f5786c ? this.f5785b.c() : this.f5784a.F().m0();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        if (this.f5786c) {
            return this.f5785b.h(str);
        }
        this.f5784a.F();
        p.g(str);
        return 25;
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z10) {
        return this.f5786c ? this.f5785b.j(str, str2, z10) : this.f5784a.F().C(str, str2, z10);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f5786c) {
            this.f5785b.l(str, str2, bundle);
        } else {
            this.f5784a.F().R(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        p.k(conditionalUserProperty);
        if (this.f5786c) {
            this.f5785b.f(conditionalUserProperty.a());
        } else {
            this.f5784a.F().E(conditionalUserProperty.a());
        }
    }
}
