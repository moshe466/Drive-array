package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.AdRequest;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FabricKitsFinder implements Callable<Map<String, KitInfo>> {
    private static final String FABRIC_BUILD_TYPE_KEY = "fabric-build-type";
    private static final String FABRIC_IDENTIFIER_KEY = "fabric-identifier";
    private static final String FABRIC_VERSION_KEY = "fabric-version";
    final String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FabricKitsFinder(String str) {
        this.a = str;
    }

    private Map<String, KitInfo> findImplicitKits() {
        HashMap hashMap = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            KitInfo kitInfo = new KitInfo("com.google.firebase.firebase-ads", AdRequest.VERSION, "binary");
            hashMap.put(kitInfo.getIdentifier(), kitInfo);
            Fabric.getLogger().v(Fabric.TAG, "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private Map<String, KitInfo> findRegisteredKits() {
        KitInfo loadKitInfo;
        HashMap hashMap = new HashMap();
        ZipFile a = a();
        Enumeration<? extends ZipEntry> entries = a.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().startsWith("fabric/") && nextElement.getName().length() > 7 && (loadKitInfo = loadKitInfo(nextElement, a)) != null) {
                hashMap.put(loadKitInfo.getIdentifier(), loadKitInfo);
                Fabric.getLogger().v(Fabric.TAG, String.format("Found kit:[%s] version:[%s]", loadKitInfo.getIdentifier(), loadKitInfo.getVersion()));
            }
        }
        if (a != null) {
            try {
                a.close();
            } catch (IOException unused) {
            }
        }
        return hashMap;
    }

    private KitInfo loadKitInfo(ZipEntry zipEntry, ZipFile zipFile) {
        InputStream inputStream;
        try {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    String property = properties.getProperty(FABRIC_IDENTIFIER_KEY);
                    String property2 = properties.getProperty(FABRIC_VERSION_KEY);
                    String property3 = properties.getProperty(FABRIC_BUILD_TYPE_KEY);
                    if (!TextUtils.isEmpty(property) && !TextUtils.isEmpty(property2)) {
                        KitInfo kitInfo = new KitInfo(property, property2, property3);
                        CommonUtils.closeQuietly(inputStream);
                        return kitInfo;
                    }
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                } catch (IOException e) {
                    e = e;
                    Fabric.getLogger().e(Fabric.TAG, "Error when parsing fabric properties " + zipEntry.getName(), e);
                    CommonUtils.closeQuietly(inputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.closeQuietly(zipFile);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
            CommonUtils.closeQuietly(zipFile);
            throw th;
        }
    }

    protected ZipFile a() {
        return new ZipFile(this.a);
    }

    @Override // java.util.concurrent.Callable
    public Map<String, KitInfo> call() {
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.putAll(findImplicitKits());
        hashMap.putAll(findRegisteredKits());
        Fabric.getLogger().v(Fabric.TAG, "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return hashMap;
    }
}
