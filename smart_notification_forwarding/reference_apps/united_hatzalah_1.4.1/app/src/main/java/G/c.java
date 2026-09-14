package G;

import F0.C0019c2;
import F0.C0092v0;
import a.AbstractC0228a;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.Trace;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import t.C0693i;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final C0693i f769a = new C0693i(2);

    /* renamed from: b, reason: collision with root package name */
    public static final C0019c2 f770b = new C0019c2(1);

    public static C0092v0 a(Context context, List list) {
        String str;
        Typeface c4;
        Trace.beginSection(AbstractC0228a.D("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                d dVar = (d) list.get(i);
                if (Build.VERSION.SDK_INT >= 31 && (c4 = A.g.c((str = dVar.f775e))) != null && A.g.d(c4) != null) {
                    arrayList.add(new i[]{new i(str, dVar.f776f)});
                } else {
                    ProviderInfo b4 = b(context.getPackageManager(), dVar, context.getResources());
                    if (b4 == null) {
                        return new C0092v0();
                    }
                    arrayList.add(c(context, dVar, b4.authority));
                }
            }
            return new C0092v0(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, G.b] */
    public static ProviderInfo b(PackageManager packageManager, d dVar, Resources resources) {
        C0019c2 c0019c2 = f770b;
        C0693i c0693i = f769a;
        Trace.beginSection(AbstractC0228a.D("FontProvider.getProvider"));
        try {
            List list = dVar.f774d;
            String str = dVar.f771a;
            String str2 = dVar.f772b;
            if (list == null) {
                list = z.b.e(resources, 0);
            }
            ?? obj = new Object();
            obj.f766a = str;
            obj.f767b = str2;
            obj.f768c = list;
            ProviderInfo providerInfo = (ProviderInfo) c0693i.get(obj);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider != null) {
                if (resolveContentProvider.packageName.equals(str2)) {
                    Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
                    ArrayList arrayList = new ArrayList();
                    for (Signature signature : signatureArr) {
                        arrayList.add(signature.toByteArray());
                    }
                    Collections.sort(arrayList, c0019c2);
                    for (int i = 0; i < list.size(); i++) {
                        ArrayList arrayList2 = new ArrayList((Collection) list.get(i));
                        Collections.sort(arrayList2, c0019c2);
                        if (arrayList.size() == arrayList2.size()) {
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                if (!Arrays.equals((byte[]) arrayList.get(i3), (byte[]) arrayList2.get(i3))) {
                                    break;
                                }
                            }
                            c0693i.put(obj, resolveContentProvider);
                            return resolveContentProvider;
                        }
                    }
                    Trace.endSection();
                    return null;
                }
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
        } finally {
            Trace.endSection();
        }
    }

    public static i[] c(Context context, d dVar, String str) {
        ContentProviderClient contentProviderClient;
        ContentProviderClient contentProviderClient2;
        int i;
        int i3;
        ContentProviderClient contentProviderClient3;
        Uri withAppendedId;
        int i4;
        boolean z3;
        Trace.beginSection(AbstractC0228a.D("FontProvider.query"));
        try {
            ArrayList arrayList = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath(Constants.FILE).build();
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(build);
            Cursor cursor = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection(AbstractC0228a.D("ContentQueryWrapper.query"));
                try {
                    try {
                        String[] strArr2 = {dVar.f773c};
                        if (acquireUnstableContentProviderClient != null) {
                            try {
                                cursor = acquireUnstableContentProviderClient.query(build, strArr, "query = ?", strArr2, null, null);
                            } catch (RemoteException unused) {
                            }
                        }
                        if (cursor != null && cursor.getCount() > 0) {
                            int columnIndex = cursor.getColumnIndex("result_code");
                            ArrayList arrayList2 = new ArrayList();
                            int columnIndex2 = cursor.getColumnIndex("_id");
                            int columnIndex3 = cursor.getColumnIndex("file_id");
                            int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                            int columnIndex5 = cursor.getColumnIndex("font_weight");
                            int columnIndex6 = cursor.getColumnIndex("font_italic");
                            while (cursor.moveToNext()) {
                                if (columnIndex != -1) {
                                    i = cursor.getInt(columnIndex);
                                } else {
                                    i = 0;
                                }
                                if (columnIndex4 != -1) {
                                    i3 = cursor.getInt(columnIndex4);
                                } else {
                                    i3 = 0;
                                }
                                if (columnIndex3 == -1) {
                                    contentProviderClient3 = acquireUnstableContentProviderClient;
                                    withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                                } else {
                                    contentProviderClient3 = acquireUnstableContentProviderClient;
                                    withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                                }
                                Uri uri = withAppendedId;
                                if (columnIndex5 != -1) {
                                    i4 = cursor.getInt(columnIndex5);
                                } else {
                                    i4 = 400;
                                }
                                int i5 = i4;
                                if (columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                arrayList2.add(new i(uri, i3, i5, z3, i));
                                acquireUnstableContentProviderClient = contentProviderClient3;
                            }
                            contentProviderClient2 = acquireUnstableContentProviderClient;
                            arrayList = arrayList2;
                        } else {
                            contentProviderClient2 = acquireUnstableContentProviderClient;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (contentProviderClient2 != null) {
                            contentProviderClient2.close();
                        }
                        return (i[]) arrayList.toArray(new i[0]);
                    } finally {
                    }
                } catch (Throwable th) {
                    th = th;
                    contentProviderClient = context;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (contentProviderClient != null) {
                        contentProviderClient.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                contentProviderClient = acquireUnstableContentProviderClient;
            }
        } finally {
            Trace.endSection();
        }
    }
}
