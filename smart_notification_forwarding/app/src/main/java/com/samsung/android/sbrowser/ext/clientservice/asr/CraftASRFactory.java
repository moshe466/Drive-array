package com.samsung.android.sbrowser.ext.clientservice.asr;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.vosk.android.StorageService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CraftASRFactory {
    private static final String PACKAGE_NAME_PREFIX = "com.samsung.android.six.livecaption.langpack.";
    public static String SINGLE_INTERNAL_LANGPACK = "en";
    private static final String TAG = "CraftASRFactory";
    static CraftASRFactory mInstance;
    static Map<String, Pair> mMap = new HashMap();

    CraftASRFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CraftASRFactory get() {
        if (mInstance == null) {
            mInstance = new CraftASRFactory();
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isApkInstalled(Context context, String str) {
        try {
            String str2 = SINGLE_INTERNAL_LANGPACK;
            if (str2 != null) {
                return str.equals(str2);
            }
            context.createPackageContext(PACKAGE_NAME_PREFIX + str, 2);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private CraftModel createModel(Context context, String str) throws Exception {
        try {
            Log.d(TAG, "createModel is called");
            String str2 = "model-" + str;
            CraftModel craftModel = new CraftModel(StorageService.sync(SINGLE_INTERNAL_LANGPACK == null ? context.createPackageContext(PACKAGE_NAME_PREFIX + str, 2) : context, str2, str2), str);
            Log.i(TAG, "new model is created for " + context);
            return craftModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void deleteModel(Context context, String str, CraftModel craftModel) {
        Log.i(TAG, craftModel + "model is deleted from " + context);
        craftModel.delete();
    }

    private String hashKey(Context context, String str) {
        return (Integer.toString(System.identityHashCode(context)) + "_") + str;
    }

    Pair createModelIfRequired(Context context, String str) throws Exception {
        String hashKey = hashKey(context, str);
        if (mMap.containsKey(hashKey)) {
            return mMap.get(hashKey);
        }
        Pair pair = new Pair(createModel(context, str));
        mMap.put(hashKey, pair);
        Log.i(TAG, "context is added to map " + context);
        return pair;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CraftASR createASR(Context context, String str) throws Exception {
        Pair createModelIfRequired = createModelIfRequired(context, str);
        CraftASR craftASR = new CraftASR(createModelIfRequired.mModel);
        createModelIfRequired.ref(craftASR);
        return craftASR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteASR(Context context, String str, CraftASR craftASR, boolean z) {
        if (craftASR == null) {
            return;
        }
        craftASR.delete();
        String hashKey = hashKey(context, str);
        Pair pair = mMap.get(hashKey);
        if (pair != null && pair.unref(craftASR) == 0 && z) {
            deleteModel(context, str, pair.mModel);
            mMap.remove(hashKey);
            Log.i(TAG, "context is deleted from map " + context);
            if (mMap.size() == 0) {
                Log.i(TAG, "CraftASRFactory is deleted " + mInstance);
                mInstance = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Pair {
        CraftModel mModel;
        HashSet<CraftASR> mSet = new HashSet<>();

        Pair(CraftModel craftModel) {
            this.mModel = craftModel;
        }

        void ref(CraftASR craftASR) {
            this.mSet.add(craftASR);
        }

        int unref(CraftASR craftASR) {
            this.mSet.remove(craftASR);
            return this.mSet.size();
        }
    }
}
