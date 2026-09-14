package com.groboot.mdaemergency.ui.activities;

import a6.h;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.groboot.mdaemergency.a;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import il.org.mda.health.R;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class OpenCameraActivity extends Activity {

    /* renamed from: f, reason: collision with root package name */
    static Uri f8098f = null;

    /* renamed from: g, reason: collision with root package name */
    static String f8099g = "MADA_IMAGES";

    /* renamed from: h, reason: collision with root package name */
    static a f8100h;

    /* renamed from: i, reason: collision with root package name */
    static int f8101i;

    /* loaded from: classes.dex */
    public interface a {
        void a(Uri uri);

        void cancel();
    }

    public static Uri a(Context context, Intent intent) {
        boolean z10;
        Uri uri;
        if (intent == null || intent.getData() == null) {
            z10 = true;
        } else {
            String action = intent.getAction();
            z10 = action == null ? false : action.equals("android.media.action.IMAGE_CAPTURE");
        }
        if (z10) {
            uri = f8098f;
        } else {
            Uri data = intent == null ? null : intent.getData();
            if (data != null) {
                String d10 = d(context, data);
                data = Uri.fromFile(new File(d10));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Chosen path = ");
                sb2.append(d10);
            }
            uri = data;
        }
        if (uri == null || new File(uri.getPath()).exists()) {
            return uri;
        }
        return null;
    }

    public static String b(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        query.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Uri c() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), f8099g);
        if (!file.exists()) {
            file.mkdirs();
        }
        return Uri.fromFile(new File(file + File.separator + "IMG_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));
    }

    public static String d(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        try {
            if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
                if (f(uri)) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + split[1];
                    }
                } else {
                    if (e(uri)) {
                        return b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (g(uri)) {
                        String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = split2[0];
                        return b(context, "image".equals(str) ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : "video".equals(str) ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : "audio".equals(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null, "_id=?", new String[]{split2[1]});
                    }
                }
            } else {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return b(context, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean e(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean f(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean g(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static void h(Activity activity, int i10, a aVar) {
        com.groboot.mdaemergency.a.y(activity, null);
        com.groboot.mdaemergency.a.E(activity, null);
        a.d j10 = com.groboot.mdaemergency.a.j(activity);
        if (j10 != a.d.hasPermission) {
            if (j10 == a.d.noPermission) {
                h.l(activity, R.string.no_permition_storage);
            }
        } else {
            new Throwable();
            f8100h = aVar;
            f8101i = i10;
            activity.startActivity(new Intent(activity, (Class<?>) OpenCameraActivity.class));
        }
    }

    public static void i(Activity activity, int i10) {
        try {
            f8098f = c();
            ArrayList arrayList = new ArrayList();
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            for (ResolveInfo resolveInfo : activity.getPackageManager().queryIntentActivities(intent, 0)) {
                String str = resolveInfo.activityInfo.packageName;
                Intent intent2 = new Intent(intent);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                intent2.setPackage(str);
                intent2.putExtra("output", f8098f);
                arrayList.add(intent2);
            }
            Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
            intent3.addCategory("android.intent.category.OPENABLE");
            intent3.setType("image/*");
            if (arrayList.size() == 0) {
                activity.startActivityForResult(Intent.createChooser(intent3, activity.getString(R.string.chooseImage)), i10);
                return;
            }
            Intent createChooser = Intent.createChooser(intent3, activity.getString(R.string.chooseImage));
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Intent[]) arrayList.toArray(new Intent[0]));
            activity.startActivityForResult(createChooser, i10);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        Uri a10;
        LockPatternActivity.B();
        if (i11 != -1) {
            a aVar = f8100h;
            if (aVar != null) {
                aVar.cancel();
            }
        } else if (f8100h != null && (a10 = a(getApplicationContext(), intent)) != null) {
            f8100h.a(a10);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_open_camera);
        i(this, f8101i);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }
}
