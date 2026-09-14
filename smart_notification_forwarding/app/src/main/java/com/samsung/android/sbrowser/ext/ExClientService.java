package com.samsung.android.sbrowser.ext;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.samsung.android.sbrowser.ext.utils.ContextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ExClientService extends Service {
    static final int MSG_CLEAR_METHOD = 1605;
    static final int MSG_NEW_OBJECT = 1602;
    static final int MSG_REGISTER_CLIENT = 1600;
    static final int MSG_REMOVE_OBJECT = 1604;
    static final int MSG_RUN_METHOD = 1603;
    static final int MSG_UNREGISTER_CLIENT = 1601;
    private static final String RUN_FAIL = "Run-Fail";
    private static final String TAG = "ExClientService";
    Messenger mMessenger;
    HashMap<String, Messenger> mClients = new HashMap<>();
    int mValue = 0;
    HashMap<String, b> mExtObjectMap = new HashMap<>();
    HashMap<String, Bundle> mExtMsgObjectMap = new HashMap<>();

    /* loaded from: classes.dex */
    class a extends Handler {
        private final Context a;
        private int b = -1;

        a(Context context) {
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            ContextUtils.initApplicationContext(applicationContext);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!ExtensionUtils.enabledCallerCheck(ExClientService.this.getApplicationContext().getPackageManager(), message.sendingUid) || message.sendingUid != this.b) {
                Log.d(ExClientService.TAG, "This is unauthorized access.");
                return;
            }
            Object obj = message.what;
            try {
                switch (obj) {
                    case ExClientService.MSG_REGISTER_CLIENT /* 1600 */:
                        ExClientService.this.mClients.put(((Bundle) message.obj).getString("id"), message.replyTo);
                        return;
                    case ExClientService.MSG_UNREGISTER_CLIENT /* 1601 */:
                        ExClientService.this.mClients.clear();
                        ExClientService.this.mExtMsgObjectMap.clear();
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        return;
                    case ExClientService.MSG_NEW_OBJECT /* 1602 */:
                        Log.i(ExClientService.TAG, "handleMessage:MSG_NEW_OBJECT:");
                        ExClientService.this.mValue = message.arg1;
                        Bundle bundle = (Bundle) message.obj;
                        String string = bundle.getString("id");
                        String string2 = bundle.getString("object");
                        String string3 = bundle.getString("objectName");
                        ExClientService.this.mExtMsgObjectMap.put(string, bundle);
                        ExClientService exClientService = ExClientService.this;
                        exClientService.mExtObjectMap.put(string3, exClientService.addJSInterface(string2));
                        ExClientService.this.mClients.get(string).send(Message.obtain(null, ExClientService.MSG_NEW_OBJECT, ExClientService.this.mValue, 0, bundle));
                        ExClientService.this.mClients.remove(string);
                        ExClientService.this.mExtMsgObjectMap.remove(string);
                        obj = string;
                        break;
                    case ExClientService.MSG_RUN_METHOD /* 1603 */:
                        try {
                            ExClientService.this.mValue = message.arg1;
                            Bundle bundle2 = (Bundle) message.obj;
                            String string4 = bundle2.getString("id");
                            bundle2.getString("object");
                            String string5 = bundle2.getString("objectName");
                            String string6 = bundle2.getString("methoadName");
                            ArrayList<String> stringArrayList = bundle2.getStringArrayList("paramList");
                            ArrayList<String> stringArrayList2 = bundle2.getStringArrayList("pTypeList");
                            ExClientService.this.mExtMsgObjectMap.put(string4, bundle2);
                            if (stringArrayList != null) {
                                ExClientService exClientService2 = ExClientService.this;
                                exClientService2.runJSInterfaceWithParam(exClientService2.mExtObjectMap.get(string5), string6, stringArrayList, stringArrayList2, bundle2);
                            } else {
                                ExClientService exClientService3 = ExClientService.this;
                                exClientService3.runJSInterface(exClientService3.mExtObjectMap.get(string5), string6, bundle2);
                            }
                            return;
                        } catch (Throwable th) {
                            Log.e(ExClientService.TAG, Log.getStackTraceString(th));
                            return;
                        }
                    case ExClientService.MSG_REMOVE_OBJECT /* 1604 */:
                        Log.i(ExClientService.TAG, "handleMessage:MSG_REMOVE_OBJECT");
                        ExClientService.this.mValue = message.arg1;
                        Bundle bundle3 = (Bundle) message.obj;
                        String string7 = bundle3.getString("id");
                        bundle3.getString("object");
                        ExClientService.this.mExtMsgObjectMap.put(string7, bundle3);
                        ExClientService.this.mClients.get(string7).send(Message.obtain(null, ExClientService.MSG_REMOVE_OBJECT, ExClientService.this.mValue, 0, bundle3));
                        ExClientService.this.mClients.remove(string7);
                        ExClientService.this.mExtMsgObjectMap.remove(bundle3);
                        obj = string7;
                        break;
                    case ExClientService.MSG_CLEAR_METHOD /* 1605 */:
                        Log.i(ExClientService.TAG, "handleMessage:MSG_CLEAR_METHOD");
                        ExClientService.this.mValue = message.arg1;
                        Bundle bundle4 = (Bundle) message.obj;
                        String string8 = bundle4.getString("id");
                        bundle4.getString("object");
                        ExClientService.this.mExtMsgObjectMap.clear();
                        ExClientService.this.mExtMsgObjectMap.put(string8, bundle4);
                        ExClientService.this.mClients.get(string8).send(Message.obtain(null, ExClientService.MSG_CLEAR_METHOD, ExClientService.this.mValue, 0, bundle4));
                        ExClientService.this.mClients.remove(string8);
                        ExClientService.this.mExtMsgObjectMap.remove(string8);
                        obj = string8;
                        break;
                    default:
                        super.handleMessage(message);
                        return;
                }
            } catch (Throwable th2) {
                Log.e(ExClientService.TAG, Log.getStackTraceString(th2));
                ExClientService.this.mClients.remove(obj);
                ExClientService.this.mExtMsgObjectMap.remove(obj);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            this.b = Binder.getCallingUid();
            return super.sendMessageAtTime(message, j);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        private final Class a;
        private final Constructor b;
        private final Object c;

        public b(Class cls, Constructor constructor, Object obj) {
            this.a = cls;
            this.b = constructor;
            this.c = obj;
        }

        public Class a() {
            return this.a;
        }

        public Constructor b() {
            return this.b;
        }

        public Object c() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Class] */
    public b addJSInterface(String str) {
        Object obj;
        Constructor constructor;
        ?? r8;
        int i;
        Object obj2 = null;
        try {
            r8 = Class.forName("com.samsung.android.sbrowser.ext.clientservice." + str);
            try {
                constructor = r8.getConstructor(Context.class, ExClientService.class);
            } catch (Throwable th) {
                th = th;
                constructor = null;
                obj2 = r8;
                obj = null;
            }
        } catch (Throwable th2) {
            th = th2;
            obj = null;
            constructor = null;
        }
        try {
            obj2 = constructor.newInstance(getApplicationContext(), this);
            Class[] clsArr = new Class[3];
            for (i = 0; i < 3; i++) {
                clsArr[i] = String.class;
            }
        } catch (Throwable th3) {
            th = th3;
            Object obj3 = obj2;
            obj2 = r8;
            obj = obj3;
            Log.e(TAG, Log.getStackTraceString(th));
            Object obj4 = obj2;
            obj2 = obj;
            r8 = obj4;
            return new b(r8, constructor, obj2);
        }
        return new b(r8, constructor, obj2);
    }

    public void RunMessage(String str, ArrayList<String> arrayList) {
        Bundle bundle = this.mExtMsgObjectMap.get(str);
        if (bundle != null) {
            try {
                bundle.putStringArrayList("returnList", arrayList);
                this.mClients.get(str).send(Message.obtain(null, MSG_RUN_METHOD, this.mValue, 0, bundle));
            } catch (Throwable th) {
                Log.e(TAG, Log.getStackTraceString(th));
                this.mExtMsgObjectMap.remove(str);
                this.mClients.remove(str);
                return;
            }
        }
        this.mExtMsgObjectMap.remove(str);
        this.mClients.remove(str);
    }

    public void callbackClient(String str, Bundle bundle) {
        try {
            this.mClients.get(str).send(Message.obtain(null, MSG_RUN_METHOD, this.mValue, 0, bundle));
        } catch (Throwable th) {
            Log.e(TAG, Log.getStackTraceString(th));
            this.mClients.remove(str);
        }
    }

    public HashMap<String, Messenger> getClients() {
        return this.mClients;
    }

    public HashMap<String, Bundle> getExtMsgObjects() {
        return this.mExtMsgObjectMap;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        Messenger messenger = new Messenger(new a(this));
        this.mMessenger = messenger;
        return messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d(TAG, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return true;
    }

    public void runJSInterface(b bVar, String str, Bundle bundle) {
        try {
            Class a2 = bVar.a();
            bVar.b();
            Object c = bVar.c();
            Object[] objArr = {bundle.getString("id")};
            Method method = a2.getMethod(str, String.class);
            method.setAccessible(true);
            method.invoke(c, objArr);
        } catch (Throwable th) {
            Log.e(TAG, Log.getStackTraceString(th));
            String string = bundle.getString("id");
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(RUN_FAIL);
            arrayList.add("runJSInterface " + str);
            arrayList.add(th.toString());
            RunMessage(string, arrayList);
        }
    }

    public void runJSInterfaceWithParam(b bVar, String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, Bundle bundle) {
        try {
            Class a2 = bVar.a();
            bVar.b();
            Object c = bVar.c();
            Class<?>[] clsArr = new Class[arrayList2.size() + 1];
            clsArr[0] = String.class;
            for (int i = 1; i < arrayList2.size() + 1; i++) {
                int i2 = i - 1;
                if (arrayList2.get(i2).indexOf("int") != -1) {
                    clsArr[i] = Integer.class;
                } else if (arrayList2.get(i2).indexOf("string") != -1) {
                    clsArr[i] = String.class;
                }
            }
            String string = bundle.getString("id");
            Object[] objArr = new Object[arrayList.size() + 1];
            objArr[0] = string;
            for (int i3 = 1; i3 < arrayList.size() + 1; i3++) {
                objArr[i3] = arrayList.get(i3 - 1);
            }
            Method method = a2.getMethod(str, clsArr);
            method.setAccessible(true);
            method.invoke(c, objArr);
        } catch (Throwable th) {
            Log.e(TAG, Log.getStackTraceString(th));
            String string2 = bundle.getString("id");
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.add(RUN_FAIL);
            arrayList3.add("runJSInterfaceWithParam " + str);
            arrayList3.add(th.toString());
            RunMessage(string2, arrayList3);
        }
    }
}
