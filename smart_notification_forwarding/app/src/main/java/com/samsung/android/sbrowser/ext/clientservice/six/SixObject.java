package com.samsung.android.sbrowser.ext.clientservice.six;

import android.util.Log;
import com.samsung.android.sbrowser.ext.ExClientService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SixObject {
    private static final String FAIL = "Run-Fail";
    private static final String PARAM_DILIM = ":>:<";
    private static final String SUCCESS = "Success";
    private static final String TAG = "SixObject";
    private static HashMap<String, SixObject> mObjectMap;
    private ExClientService mClientService;
    private final HashMap<String, SixEventQueue> mEventMap = new HashMap<>();

    public SixObject(ExClientService exClientService) {
        this.mClientService = exClientService;
    }

    public static void registerObject(String str, SixObject sixObject) {
        if (mObjectMap == null) {
            mObjectMap = new HashMap<>();
        }
        if (mObjectMap.get(str) != null) {
            Log.e(TAG, "registerObject already exist " + str);
        } else {
            mObjectMap.put(str, sixObject);
        }
    }

    public static void removeObject(String str) {
        HashMap<String, SixObject> hashMap = mObjectMap;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    public static SixObject findObject(String str) {
        HashMap<String, SixObject> hashMap = mObjectMap;
        if (hashMap == null) {
            Log.e(TAG, "findObject : no map");
            return null;
        }
        SixObject sixObject = hashMap.get(str);
        if (sixObject != null) {
            return sixObject;
        }
        Log.e(TAG, "findObject : can't find object " + str);
        return null;
    }

    public static String[] tokenizeParam(String str) {
        return str.split("(:>:<)");
    }

    public static ArrayList<String> toMsg(boolean z, String... strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (z) {
            arrayList.add(SUCCESS);
        } else {
            arrayList.add(FAIL);
        }
        for (String str : strArr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static ArrayList<String> toMsg(boolean z, ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (z) {
            arrayList2.add(SUCCESS);
        } else {
            arrayList2.add(FAIL);
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next());
        }
        return arrayList2;
    }

    public void addEventListener(String str, String str2) {
        try {
            SixEventQueue sixEventQueue = this.mEventMap.get(str2);
            if (sixEventQueue == null) {
                sixEventQueue = new SixEventQueue(this.mClientService);
                this.mEventMap.put(str2, sixEventQueue);
            }
            sixEventQueue.addEventListener(str);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void removeEventListener(String str, String str2) {
        try {
            if (this.mEventMap.get(str2) == null) {
                throw new RuntimeException("eventName does not exist " + str2);
            }
            this.mEventMap.remove(str2);
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fireEvent(SixEvent sixEvent) {
        SixEventQueue sixEventQueue = this.mEventMap.get(sixEvent.getName());
        if (sixEventQueue == null) {
            Log.i(TAG, sixEvent.getName() + " listener is not yet registered yet from JS, let's queue the event");
            sixEventQueue = new SixEventQueue(this.mClientService);
            this.mEventMap.put(sixEvent.getName(), sixEventQueue);
        }
        sixEventQueue.fireEvent(sixEvent);
    }

    public void sendSuccess(String str, ArrayList<String> arrayList) {
        this.mClientService.RunMessage(str, toMsg(true, arrayList));
    }

    public void sendSuccess(String str, String... strArr) {
        this.mClientService.RunMessage(str, toMsg(true, strArr));
    }

    public void sendFail(String str, String str2) {
        Log.e(TAG, "sendFail : " + str2);
        this.mClientService.RunMessage(str, toMsg(false, str2));
    }

    public void sendFail(String str, Exception exc) {
        String exc2 = exc.toString();
        Log.e(TAG, "sendFail : " + exc2);
        exc.printStackTrace();
        this.mClientService.RunMessage(str, toMsg(false, exc2));
    }
}
