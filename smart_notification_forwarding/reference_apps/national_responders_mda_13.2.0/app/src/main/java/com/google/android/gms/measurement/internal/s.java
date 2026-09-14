package com.google.android.gms.measurement.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class s {
    public static l3<Long> A;
    public static l3<Boolean> A0;
    public static l3<Long> B;
    public static l3<Boolean> B0;
    public static l3<Integer> C;
    public static l3<Boolean> C0;
    public static l3<Long> D;
    public static l3<Boolean> D0;
    public static l3<Integer> E;
    public static l3<Long> E0;
    public static l3<Integer> F;
    public static l3<Boolean> F0;
    public static l3<Integer> G;
    public static l3<Boolean> G0;
    public static l3<Integer> H;
    public static l3<Boolean> H0;
    public static l3<Integer> I;
    public static l3<Boolean> I0;
    public static l3<Long> J;
    public static l3<Boolean> J0;
    public static l3<Boolean> K;
    public static l3<Integer> K0;
    public static l3<String> L;
    public static l3<Boolean> L0;
    public static l3<Long> M;
    public static l3<Boolean> M0;
    public static l3<Integer> N;
    public static l3<Boolean> N0;
    public static l3<Double> O;
    public static l3<Boolean> O0;
    public static l3<Integer> P;
    public static l3<Integer> Q;
    public static l3<Boolean> R;
    public static l3<Boolean> S;
    public static l3<Boolean> T;
    public static l3<Boolean> U;
    public static l3<Boolean> V;
    public static l3<Boolean> W;
    public static l3<Boolean> X;
    public static l3<Boolean> Y;
    public static l3<Boolean> Z;

    /* renamed from: a */
    private static List<l3<?>> f6392a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a0 */
    public static l3<Boolean> f6393a0;

    /* renamed from: b */
    public static l3<Long> f6394b;

    /* renamed from: b0 */
    public static l3<Boolean> f6395b0;

    /* renamed from: c */
    public static l3<Long> f6396c;

    /* renamed from: c0 */
    public static l3<Boolean> f6397c0;

    /* renamed from: d */
    public static l3<Long> f6398d;

    /* renamed from: d0 */
    public static l3<Boolean> f6399d0;

    /* renamed from: e */
    public static l3<String> f6400e;

    /* renamed from: e0 */
    public static l3<Boolean> f6401e0;

    /* renamed from: f */
    public static l3<String> f6402f;

    /* renamed from: f0 */
    public static l3<Boolean> f6403f0;

    /* renamed from: g */
    public static l3<Integer> f6404g;

    /* renamed from: g0 */
    public static l3<Boolean> f6405g0;

    /* renamed from: h */
    public static l3<Integer> f6406h;

    /* renamed from: h0 */
    public static l3<Boolean> f6407h0;

    /* renamed from: i */
    public static l3<Integer> f6408i;

    /* renamed from: i0 */
    public static l3<Boolean> f6409i0;

    /* renamed from: j */
    public static l3<Integer> f6410j;

    /* renamed from: j0 */
    public static l3<Boolean> f6411j0;

    /* renamed from: k */
    public static l3<Integer> f6412k;

    /* renamed from: k0 */
    public static l3<Boolean> f6413k0;

    /* renamed from: l */
    public static l3<Integer> f6414l;

    /* renamed from: l0 */
    public static l3<Boolean> f6415l0;

    /* renamed from: m */
    public static l3<Integer> f6416m;

    /* renamed from: m0 */
    public static l3<Boolean> f6417m0;

    /* renamed from: n */
    public static l3<Integer> f6418n;

    /* renamed from: n0 */
    public static l3<Boolean> f6419n0;

    /* renamed from: o */
    public static l3<Integer> f6420o;

    /* renamed from: o0 */
    public static l3<Boolean> f6421o0;

    /* renamed from: p */
    public static l3<Integer> f6422p;

    /* renamed from: p0 */
    public static l3<Boolean> f6423p0;

    /* renamed from: q */
    public static l3<String> f6424q;

    /* renamed from: q0 */
    public static l3<Boolean> f6425q0;

    /* renamed from: r */
    public static l3<Long> f6426r;

    /* renamed from: r0 */
    public static l3<Boolean> f6427r0;

    /* renamed from: s */
    public static l3<Long> f6428s;

    /* renamed from: s0 */
    public static l3<Boolean> f6429s0;

    /* renamed from: t */
    public static l3<Long> f6430t;

    /* renamed from: t0 */
    public static l3<Boolean> f6431t0;

    /* renamed from: u */
    public static l3<Long> f6432u;

    /* renamed from: u0 */
    public static l3<Boolean> f6433u0;

    /* renamed from: v */
    public static l3<Long> f6434v;

    /* renamed from: v0 */
    public static l3<Boolean> f6435v0;

    /* renamed from: w */
    public static l3<Long> f6436w;

    /* renamed from: w0 */
    public static l3<Boolean> f6437w0;

    /* renamed from: x */
    public static l3<Long> f6438x;

    /* renamed from: x0 */
    public static l3<Boolean> f6439x0;

    /* renamed from: y */
    public static l3<Long> f6440y;

    /* renamed from: y0 */
    public static l3<Boolean> f6441y0;

    /* renamed from: z */
    public static l3<Long> f6442z;

    /* renamed from: z0 */
    public static l3<Boolean> f6443z0;

    static {
        Collections.synchronizedSet(new HashSet());
        f6394b = a("measurement.ad_id_cache_time", 10000L, 10000L, u.f6511a);
        f6396c = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, t.f6459a);
        f6398d = a("measurement.config.cache_time", 86400000L, 3600000L, h0.f6079a);
        f6400e = a("measurement.config.url_scheme", "https", "https", q0.f6337a);
        f6402f = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", e1.f5953a);
        f6404g = a("measurement.upload.max_bundles", 100, 100, n1.f6244a);
        f6406h = a("measurement.upload.max_batch_size", 65536, 65536, a2.f5803a);
        f6408i = a("measurement.upload.max_bundle_size", 65536, 65536, k2.f6154a);
        f6410j = a("measurement.upload.max_events_per_bundle", 1000, 1000, x2.f6613a);
        f6412k = a("measurement.upload.max_events_per_day", 100000, 100000, i3.f6109a);
        f6414l = a("measurement.upload.max_error_events_per_day", 1000, 1000, w.f6581a);
        f6416m = a("measurement.upload.max_public_events_per_day", 50000, 50000, v.f6540a);
        f6418n = a("measurement.upload.max_conversions_per_day", 10000, 10000, y.f6628a);
        f6420o = a("measurement.upload.max_realtime_events_per_day", 10, 10, x.f6610a);
        f6422p = a("measurement.store.max_stored_events_per_app", 100000, 100000, b0.f5824a);
        f6424q = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", a0.f5799a);
        f6426r = a("measurement.upload.backoff_period", 43200000L, 43200000L, d0.f5919a);
        f6428s = a("measurement.upload.window_interval", 3600000L, 3600000L, c0.f5887a);
        f6430t = a("measurement.upload.interval", 3600000L, 3600000L, f0.f6041a);
        f6432u = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, e0.f5952a);
        f6434v = a("measurement.upload.debug_upload_interval", 1000L, 1000L, g0.f6061a);
        f6436w = a("measurement.upload.minimum_delay", 500L, 500L, j0.f6128a);
        f6438x = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, i0.f6106a);
        f6440y = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, l0.f6175a);
        f6442z = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, k0.f6152a);
        A = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, n0.f6243a);
        B = a("measurement.upload.retry_time", 1800000L, 1800000L, m0.f6218a);
        C = a("measurement.upload.retry_count", 6, 6, p0.f6303a);
        D = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, o0.f6267a);
        E = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, r0.f6362a);
        F = a("measurement.audience.filter_result_max_count", 200, 200, t0.f6460a);
        G = a("measurement.upload.max_public_user_properties", 25, 25, null);
        H = a("measurement.upload.max_event_name_cardinality", 500, 500, null);
        I = a("measurement.upload.max_public_event_params", 25, 25, null);
        J = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, s0.f6444a);
        Boolean bool = Boolean.FALSE;
        K = a("measurement.test.boolean_flag", bool, bool, v0.f6541a);
        L = a("measurement.test.string_flag", "---", "---", u0.f6512a);
        M = a("measurement.test.long_flag", -1L, -1L, x0.f6611a);
        N = a("measurement.test.int_flag", -2, -2, w0.f6582a);
        Double valueOf = Double.valueOf(-3.0d);
        O = a("measurement.test.double_flag", valueOf, valueOf, z0.f6650a);
        P = a("measurement.experiment.max_ids", 50, 50, y0.f6629a);
        Q = a("measurement.max_bundles_per_iteration", 100, 100, c1.f5888a);
        R = a("measurement.validation.internal_limits_internal_event_params", bool, bool, b1.f5825a);
        Boolean bool2 = Boolean.TRUE;
        S = a("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, d1.f5920a);
        T = a("measurement.collection.efficient_engagement_reporting_enabled_2", bool2, bool2, g1.f6062a);
        U = a("measurement.collection.redundant_engagement_removal_enabled", bool, bool, f1.f6042a);
        V = a("measurement.client.freeride_engagement_fix", bool2, bool2, i1.f6107a);
        W = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, h1.f6080a);
        X = a("measurement.quality.checksum", bool, bool, null);
        Y = a("measurement.sdk.dynamite.allow_remote_dynamite3", bool2, bool2, k1.f6153a);
        Z = a("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, j1.f6129a);
        f6393a0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, m1.f6219a);
        f6395b0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, l1.f6176a);
        f6397c0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, o1.f6268a);
        f6399d0 = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, q1.f6338a);
        f6401e0 = a("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, p1.f6304a);
        f6403f0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, s1.f6445a);
        f6405g0 = a("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, r1.f6363a);
        f6407h0 = a("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, u1.f6513a);
        f6409i0 = a("measurement.upload.file_lock_state_check", bool, bool, t1.f6461a);
        f6411j0 = a("measurement.ga.ga_app_id", bool, bool, w1.f6583a);
        f6413k0 = a("measurement.lifecycle.app_in_background_parameter", bool, bool, v1.f6542a);
        f6415l0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, y1.f6630a);
        f6417m0 = a("measurement.lifecycle.app_backgrounded_engagement", bool, bool, x1.f6612a);
        f6419n0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, z1.f6651a);
        f6421o0 = a("measurement.service.use_appinfo_modified", bool, bool, d2.f5921a);
        f6423p0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, c2.f5889a);
        f6425q0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, f2.f6043a);
        f6427r0 = a("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, e2.f5954a);
        f6429s0 = a("measurement.upload.file_truncate_fix", bool, bool, h2.f6081a);
        f6431t0 = a("measurement.sdk.referrer.delayed_install_referrer_api", bool, bool, g2.f6063a);
        f6433u0 = a("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, j2.f6130a);
        f6435v0 = a("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, i2.f6108a);
        a("measurement.collection.synthetic_data_mitigation", bool, bool, l2.f6177a);
        f6437w0 = a("measurement.service.configurable_service_limits", bool2, bool2, n2.f6245a);
        f6439x0 = a("measurement.client.configurable_service_limits", bool2, bool2, m2.f6220a);
        f6441y0 = a("measurement.androidId.delete_feature", bool2, bool2, p2.f6305a);
        f6443z0 = a("measurement.client.global_params", bool2, bool2, o2.f6269a);
        A0 = a("measurement.service.global_params", bool2, bool2, r2.f6364a);
        B0 = a("measurement.service.global_params_in_payload", bool2, bool2, q2.f6339a);
        C0 = a("measurement.client.string_reader", bool2, bool2, t2.f6462a);
        D0 = a("measurement.sdk.attribution.cache", bool2, bool2, s2.f6446a);
        E0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, v2.f6543a);
        F0 = a("measurement.service.database_return_empty_collection", bool2, bool2, u2.f6514a);
        G0 = a("measurement.service.ssaid_removal", bool2, bool2, w2.f6584a);
        H0 = a("measurement.client.consent_state_v1", bool2, bool2, z2.f6652a);
        I0 = a("measurement.client.3p_consent_state_v1", bool2, bool2, y2.f6631a);
        J0 = a("measurement.service.consent_state_v1_W36", bool, bool, b3.f5826a);
        K0 = a("measurement.service.storage_consent_support_version", 203590, 203590, a3.f5804a);
        L0 = a("measurement.client.ad_impression", bool2, bool2, e3.f5955a);
        M0 = a("measurement.service.ad_impression", bool2, bool2, d3.f5922a);
        N0 = a("measurement.service.separate_public_internal_event_blacklisting", bool2, bool2, g3.f6064a);
        O0 = a("measurement.service.directly_maybe_log_error_events", bool, bool, f3.f6044a);
    }

    private static <V> l3<V> a(String str, V v10, V v11, k3<V> k3Var) {
        l3<V> l3Var = new l3<>(str, v10, v11, k3Var);
        f6392a.add(l3Var);
        return l3Var;
    }

    public static Map<String, String> c(Context context) {
        com.google.android.gms.internal.measurement.e2 a10 = com.google.android.gms.internal.measurement.e2.a(context.getContentResolver(), com.google.android.gms.internal.measurement.q2.a("com.google.android.gms.measurement"));
        return a10 == null ? Collections.emptyMap() : a10.b();
    }
}
