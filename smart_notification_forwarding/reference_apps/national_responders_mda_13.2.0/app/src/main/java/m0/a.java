package m0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f11992f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static a f11993g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f11994a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f11995b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f11996c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<b> f11997d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f11998e;

    /* renamed from: m0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0248a extends Handler {
        HandlerC0248a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Intent f12000a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<c> f12001b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f12000a = intent;
            this.f12001b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f12002a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f12003b;

        /* renamed from: c, reason: collision with root package name */
        boolean f12004c;

        /* renamed from: d, reason: collision with root package name */
        boolean f12005d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f12002a = intentFilter;
            this.f12003b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f12003b);
            sb2.append(" filter=");
            sb2.append(this.f12002a);
            if (this.f12005d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    private a(Context context) {
        this.f11994a = context;
        this.f11998e = new HandlerC0248a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f11992f) {
            if (f11993g == null) {
                f11993g = new a(context.getApplicationContext());
            }
            aVar = f11993g;
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f11995b) {
                size = this.f11997d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f11997d.toArray(bVarArr);
                this.f11997d.clear();
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f12001b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f12001b.get(i11);
                    if (!cVar.f12005d) {
                        cVar.f12003b.onReceive(this.f11994a, bVar.f12000a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f11995b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f11995b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f11995b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList<c> arrayList2 = this.f11996c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f11996c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f11995b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f11994a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Resolving type ");
                sb2.append(resolveTypeIfNeeded);
                sb2.append(" scheme ");
                sb2.append(scheme);
                sb2.append(" of intent ");
                sb2.append(intent);
            }
            ArrayList<c> arrayList3 = this.f11996c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Action list: ");
                    sb3.append(arrayList3);
                }
                ArrayList arrayList4 = null;
                int i11 = 0;
                while (i11 < arrayList3.size()) {
                    c cVar = arrayList3.get(i11);
                    if (z10) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Matching against filter ");
                        sb4.append(cVar.f12002a);
                    }
                    if (cVar.f12004c) {
                        i10 = i11;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i10 = i11;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.f12002a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z10) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("  Filter matched!  match=0x");
                                sb5.append(Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f12004c = true;
                            i11 = i10 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z10) {
                            String str3 = match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category";
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("  Filter did not match: ");
                            sb6.append(str3);
                        }
                    }
                    arrayList4 = arrayList;
                    i11 = i10 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                        ((c) arrayList5.get(i12)).f12004c = false;
                    }
                    this.f11997d.add(new b(intent, arrayList5));
                    if (!this.f11998e.hasMessages(1)) {
                        this.f11998e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
