package io.fabric.sdk.android.services.settings;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    public DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        this(kit, str, str2, httpRequestFactory, HttpMethod.GET);
    }

    DefaultSettingsSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        super(kit, str, str2, httpRequestFactory, httpMethod);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_API_KEY, settingsRequest.apiKey);
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE);
        applyNonNullHeader(httpRequest, AbstractSpiCall.HEADER_CLIENT_VERSION, this.a.getVersion());
        applyNonNullHeader(httpRequest, "Accept", "application/json");
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.deviceModel);
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.osBuildVersion);
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.osDisplayVersion);
        applyNonNullHeader(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.installationId);
        return httpRequest;
    }

    private void applyNonNullHeader(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.header(str, str2);
        }
    }

    private JSONObject getJsonObjectFrom(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Fabric.getLogger().d(Fabric.TAG, "Failed to parse settings JSON from " + b(), e);
            Fabric.getLogger().d(Fabric.TAG, "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> getQueryParamsFor(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.buildVersion);
        hashMap.put("display_version", settingsRequest.displayVersion);
        hashMap.put(FirebaseAnalytics.Param.SOURCE, Integer.toString(settingsRequest.source));
        String str = settingsRequest.iconHash;
        if (str != null) {
            hashMap.put("icon_hash", str);
        }
        String str2 = settingsRequest.instanceId;
        if (!CommonUtils.isNullOrEmpty(str2)) {
            hashMap.put("instance", str2);
        }
        return hashMap;
    }

    JSONObject a(HttpRequest httpRequest) {
        int code = httpRequest.code();
        Fabric.getLogger().d(Fabric.TAG, "Settings result was: " + code);
        if (a(code)) {
            return getJsonObjectFrom(httpRequest.body());
        }
        Fabric.getLogger().e(Fabric.TAG, "Failed to retrieve settings from " + b());
        return null;
    }

    boolean a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    @Override // io.fabric.sdk.android.services.settings.SettingsSpiCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject invoke(io.fabric.sdk.android.services.settings.SettingsRequest r10) {
        /*
            r9 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r9.getQueryParamsFor(r10)     // Catch: java.lang.Throwable -> L70 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L75
            io.fabric.sdk.android.services.network.HttpRequest r5 = r9.a(r4)     // Catch: java.lang.Throwable -> L70 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L75
            io.fabric.sdk.android.services.network.HttpRequest r10 = r9.applyHeadersTo(r5, r10)     // Catch: java.lang.Throwable -> L6a io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d
            io.fabric.sdk.android.Logger r5 = io.fabric.sdk.android.Fabric.getLogger()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            java.lang.String r7 = r9.b()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            java.lang.String r6 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            r5.d(r2, r6)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            io.fabric.sdk.android.Logger r5 = io.fabric.sdk.android.Fabric.getLogger()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            r6.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            r6.append(r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            java.lang.String r4 = r6.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            r5.d(r2, r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            org.json.JSONObject r3 = r9.a(r10)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L68 java.lang.Throwable -> L8d
            if (r10 == 0) goto L8c
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L56:
            r5.append(r1)
            java.lang.String r10 = r10.header(r0)
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r4.d(r2, r10)
            goto L8c
        L68:
            r4 = move-exception
            goto L77
        L6a:
            r3 = move-exception
            r10 = r5
            goto L8e
        L6d:
            r4 = move-exception
            r10 = r5
            goto L77
        L70:
            r10 = move-exception
            r8 = r3
            r3 = r10
            r10 = r8
            goto L8e
        L75:
            r4 = move-exception
            r10 = r3
        L77:
            io.fabric.sdk.android.Logger r5 = io.fabric.sdk.android.Fabric.getLogger()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "Settings request failed."
            r5.e(r2, r6, r4)     // Catch: java.lang.Throwable -> L8d
            if (r10 == 0) goto L8c
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L56
        L8c:
            return r3
        L8d:
            r3 = move-exception
        L8e:
            if (r10 == 0) goto Laa
            io.fabric.sdk.android.Logger r4 = io.fabric.sdk.android.Fabric.getLogger()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r10 = r10.header(r0)
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r4.d(r2, r10)
        Laa:
            goto Lac
        Lab:
            throw r3
        Lac:
            goto Lab
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.DefaultSettingsSpiCall.invoke(io.fabric.sdk.android.services.settings.SettingsRequest):org.json.JSONObject");
    }
}
