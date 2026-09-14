package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.fabric.sdk.android.Fabric;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class BinaryImagesConverter {
    private static final String DATA_DIR = "/data";
    private final Context context;
    private final FileIdStrategy fileIdStrategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface FileIdStrategy {
        String createId(File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinaryImagesConverter(Context context, FileIdStrategy fileIdStrategy) {
        this.context = context;
        this.fileIdStrategy = fileIdStrategy;
    }

    private File correctDataPath(File file) {
        if (Build.VERSION.SDK_INT < 9 || !file.getAbsolutePath().startsWith(DATA_DIR)) {
            return file;
        }
        try {
            return new File(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).nativeLibraryDir, file.getName());
        } catch (PackageManager.NameNotFoundException e) {
            Fabric.getLogger().e(CrashlyticsCore.TAG, "Error getting ApplicationInfo", e);
            return file;
        }
    }

    private static JSONObject createBinaryImageJson(String str, ProcMapEntry procMapEntry) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", procMapEntry.address);
        jSONObject.put("size", procMapEntry.size);
        jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, procMapEntry.path);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    private static byte[] generateBinaryImagesJsonString(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes();
        } catch (JSONException e) {
            Fabric.getLogger().w(CrashlyticsCore.TAG, "Binary images string is null", e);
            return new byte[0];
        }
    }

    private File getLibraryFile(String str) {
        File file = new File(str);
        return !file.exists() ? correctDataPath(file) : file;
    }

    private static boolean isRelevant(ProcMapEntry procMapEntry) {
        return (procMapEntry.perms.indexOf(120) == -1 || procMapEntry.path.indexOf(47) == -1) ? false : true;
    }

    private static String joinMapsEntries(JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            sb.append(jSONArray.getString(i));
        }
        return sb.toString();
    }

    private JSONObject jsonFromMapEntryString(String str) {
        ProcMapEntry parse = ProcMapEntryParser.parse(str);
        if (parse != null && isRelevant(parse)) {
            try {
                try {
                    return createBinaryImageJson(this.fileIdStrategy.createId(getLibraryFile(parse.path)), parse);
                } catch (JSONException e) {
                    Fabric.getLogger().d(CrashlyticsCore.TAG, "Could not create a binary image json string", e);
                    return null;
                }
            } catch (IOException e2) {
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Could not generate ID for file " + parse.path, e2);
            }
        }
        return null;
    }

    private JSONArray parseProcMapsJsonFromStream(BufferedReader bufferedReader) {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return jSONArray;
            }
            JSONObject jsonFromMapEntryString = jsonFromMapEntryString(readLine);
            if (jsonFromMapEntryString != null) {
                jSONArray.put(jsonFromMapEntryString);
            }
        }
    }

    private JSONArray parseProcMapsJsonFromString(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str2 : joinMapsEntries(new JSONObject(str).getJSONArray("maps")).split("\\|")) {
                JSONObject jsonFromMapEntryString = jsonFromMapEntryString(str2);
                if (jsonFromMapEntryString != null) {
                    jSONArray.put(jsonFromMapEntryString);
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            Fabric.getLogger().w(CrashlyticsCore.TAG, "Unable to parse proc maps string", e);
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(BufferedReader bufferedReader) {
        return generateBinaryImagesJsonString(parseProcMapsJsonFromStream(bufferedReader));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a(String str) {
        return generateBinaryImagesJsonString(parseProcMapsJsonFromString(str));
    }
}
