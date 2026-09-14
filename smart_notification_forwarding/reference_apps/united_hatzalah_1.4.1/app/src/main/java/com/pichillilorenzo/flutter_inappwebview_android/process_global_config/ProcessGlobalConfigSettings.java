package com.pichillilorenzo.flutter_inappwebview_android.process_global_config;

import android.content.Context;
import androidx.webkit.ProcessGlobalConfig;
import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import e0.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import t0.d;
import u0.F;

/* loaded from: classes.dex */
public class ProcessGlobalConfigSettings implements ISettings<ProcessGlobalConfig> {
    public static final String LOG_TAG = "ProcessGlobalConfigSettings";
    public String dataDirectorySuffix;
    public DirectoryBasePaths directoryBasePaths;

    /* loaded from: classes.dex */
    public static class DirectoryBasePaths implements ISettings<Object> {
        public static final String LOG_TAG = "ProcessGlobalConfigSettings";
        public String cacheDirectoryBasePath;
        public String dataDirectoryBasePath;

        @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
        public Map<String, Object> getRealSettings(Object obj) {
            return toMap();
        }

        @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
        public /* bridge */ /* synthetic */ ISettings<Object> parse(Map map) {
            return parse2((Map<String, Object>) map);
        }

        @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("cacheDirectoryBasePath", this.cacheDirectoryBasePath);
            hashMap.put("dataDirectoryBasePath", this.dataDirectoryBasePath);
            return hashMap;
        }

        @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
        /* renamed from: parse, reason: avoid collision after fix types in other method */
        public ISettings<Object> parse2(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    key.getClass();
                    if (key.equals("dataDirectoryBasePath")) {
                        this.dataDirectoryBasePath = (String) value;
                    } else if (key.equals("cacheDirectoryBasePath")) {
                        this.cacheDirectoryBasePath = (String) value;
                    }
                }
            }
            return this;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<ProcessGlobalConfig> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("dataDirectorySuffix", this.dataDirectorySuffix);
        return hashMap;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.webkit.ProcessGlobalConfig] */
    public ProcessGlobalConfig toProcessGlobalConfig(Context context) {
        ?? obj = new Object();
        if (this.dataDirectorySuffix != null && d.b(context, "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX")) {
            String str = this.dataDirectorySuffix;
            if (F.f6510A.a(context)) {
                if (!str.equals("")) {
                    if (str.indexOf(File.separatorChar) < 0) {
                        obj.f3785a = str;
                    } else {
                        throw new IllegalArgumentException(a.e("Suffix ", str, " contains a path separator"));
                    }
                } else {
                    throw new IllegalArgumentException("Suffix cannot be an empty string");
                }
            } else {
                throw F.a();
            }
        }
        if (this.directoryBasePaths != null && d.b(context, "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS")) {
            File file = new File(this.directoryBasePaths.dataDirectoryBasePath);
            File file2 = new File(this.directoryBasePaths.cacheDirectoryBasePath);
            if (F.f6511B.a(context)) {
                if (file.isAbsolute()) {
                    if (file2.isAbsolute()) {
                        obj.f3786b = file.getAbsolutePath();
                        obj.f3787c = file2.getAbsolutePath();
                        return obj;
                    }
                    throw new IllegalArgumentException("cacheDirectoryBasePath must be a non-empty absolute path");
                }
                throw new IllegalArgumentException("dataDirectoryBasePath must be a non-empty absolute path");
            }
            throw F.a();
        }
        return obj;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(ProcessGlobalConfig processGlobalConfig) {
        return toMap();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.pichillilorenzo.flutter_inappwebview_android.process_global_config.ProcessGlobalConfigSettings$DirectoryBasePaths] */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<ProcessGlobalConfig> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                if (key.equals("dataDirectorySuffix")) {
                    this.dataDirectorySuffix = (String) value;
                } else if (key.equals("directoryBasePaths")) {
                    this.directoryBasePaths = new DirectoryBasePaths().parse2((Map<String, Object>) value);
                }
            }
        }
        return this;
    }
}
