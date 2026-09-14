package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.File;

/* loaded from: classes.dex */
class NativeCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    private static final String APP_META_FILE_MULTIPART_PARAM = "app_meta_file";
    private static final String BINARY_IMAGES_FILE_MULTIPART_PARAM = "binary_images_file";
    private static final String DEVICE_META_FILE_MULTIPART_PARAM = "device_meta_file";
    private static final String GZIP_FILE_CONTENT_TYPE = "application/octet-stream";
    private static final String KEYS_FILE_MULTIPART_PARAM = "keys_file";
    private static final String LOGS_FILE_MULTIPART_PARAM = "logs_file";
    private static final String METADATA_FILE_MULTIPART_PARAM = "crash_meta_file";
    private static final String MINIDUMP_FILE_MULTIPART_PARAM = "minidump_file";
    private static final String OS_META_FILE_MULTIPART_PARAM = "os_meta_file";
    private static final String REPORT_IDENTIFIER_PARAM = "report_id";
    private static final String SESSION_META_FILE_MULTIPART_PARAM = "session_meta_file";
    private static final String USER_META_FILE_MULTIPART_PARAM = "user_meta_file";

    public NativeCreateReportSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str) {
        httpRequest.header("User-Agent", AbstractSpiCall.CRASHLYTICS_USER_AGENT + this.a.getVersion()).header(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.a.getVersion()).header(AbstractSpiCall.HEADER_API_KEY, str);
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        String name;
        String str;
        httpRequest.part(REPORT_IDENTIFIER_PARAM, report.getIdentifier());
        for (File file : report.getFiles()) {
            if (file.getName().equals("minidump")) {
                name = file.getName();
                str = MINIDUMP_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("metadata")) {
                name = file.getName();
                str = METADATA_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("binaryImages")) {
                name = file.getName();
                str = BINARY_IMAGES_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals(SettingsJsonConstants.SESSION_KEY)) {
                name = file.getName();
                str = SESSION_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals(SettingsJsonConstants.APP_KEY)) {
                name = file.getName();
                str = APP_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("device")) {
                name = file.getName();
                str = DEVICE_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("os")) {
                name = file.getName();
                str = OS_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("user")) {
                name = file.getName();
                str = USER_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("logs")) {
                name = file.getName();
                str = LOGS_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("keys")) {
                name = file.getName();
                str = KEYS_FILE_MULTIPART_PARAM;
            }
            httpRequest.part(str, name, GZIP_FILE_CONTENT_TYPE, file);
        }
        return httpRequest;
    }

    @Override // com.crashlytics.android.core.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(a(), createReportRequest.apiKey), createReportRequest.report);
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Sending report to: " + b());
        int code = applyMultipartDataTo.code();
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Result was: " + code);
        return ResponseParser.parse(code) == 0;
    }
}
