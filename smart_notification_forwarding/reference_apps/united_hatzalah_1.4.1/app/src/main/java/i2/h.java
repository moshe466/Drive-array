package i2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class h {
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0124 A[Catch: IOException -> 0x011f, TryCatch #8 {IOException -> 0x011f, blocks: (B:88:0x0115, B:90:0x011b, B:77:0x0124, B:79:0x0129), top: B:87:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0129 A[Catch: IOException -> 0x011f, TRY_LEAVE, TryCatch #8 {IOException -> 0x011f, blocks: (B:88:0x0115, B:90:0x011b, B:77:0x0124, B:79:0x0129), top: B:87:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(android.app.Activity r12, android.net.Uri r13, boolean r14, java.util.ArrayList r15) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.h.a(android.app.Activity, android.net.Uri, boolean, java.util.ArrayList):void");
    }

    public static final Uri b(Activity activity, Uri uri, int i) {
        if (i > 0) {
            Context applicationContext = activity.getApplicationContext();
            j.d(applicationContext, "getApplicationContext(...)");
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(applicationContext.getContentResolver().getType(uri));
            if (extensionFromMimeType != null && (extensionFromMimeType.contentEquals("jpg") || extensionFromMimeType.contentEquals("jpeg") || extensionFromMimeType.contentEquals("png") || extensionFromMimeType.contentEquals("webp") || extensionFromMimeType.contentEquals("heic") || extensionFromMimeType.contentEquals("heif"))) {
                Context applicationContext2 = activity.getApplicationContext();
                j.d(applicationContext2, "getApplicationContext(...)");
                try {
                    InputStream openInputStream = applicationContext2.getContentResolver().openInputStream(uri);
                    try {
                        Bitmap.CompressFormat d2 = d(applicationContext2, uri);
                        File c4 = c(applicationContext2, d2);
                        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream);
                        FileOutputStream fileOutputStream = new FileOutputStream(c4);
                        decodeStream.compress(d2, i, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Uri fromFile = Uri.fromFile(c4);
                        j.d(fromFile, "fromFile(...)");
                        p3.h.h(openInputStream, null);
                        return fromFile;
                    } finally {
                    }
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            }
        }
        return uri;
    }

    public static File c(Context context, Bitmap.CompressFormat compressFormat) {
        String str;
        String e4 = e0.a.e("IMAGE_", new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()), "_");
        File cacheDir = context.getCacheDir();
        int i = f.f4998a[compressFormat.ordinal()];
        if (i != 1) {
            if (i != 2) {
                str = "jpeg";
            } else {
                str = "webp";
            }
        } else {
            str = "png";
        }
        File createTempFile = File.createTempFile(e4, ".".concat(str), cacheDir);
        j.d(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    public static Bitmap.CompressFormat d(Context context, Uri uri) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        j.b(extensionFromMimeType);
        Locale locale = Locale.getDefault();
        j.d(locale, "getDefault(...)");
        String upperCase = extensionFromMimeType.toUpperCase(locale);
        j.d(upperCase, "toUpperCase(...)");
        if (upperCase.equals("PNG")) {
            return Bitmap.CompressFormat.PNG;
        }
        if (upperCase.equals("WEBP")) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static final String e(Context context, Uri uri) {
        Exception exc;
        Uri uri2;
        String str;
        j.e(uri, "uri");
        String str2 = null;
        try {
            if (j.a(uri.getScheme(), "content")) {
                uri2 = uri;
                Cursor query = context.getContentResolver().query(uri2, new String[]{"_display_name"}, null, null, null);
                try {
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                str = query.getString(query.getColumnIndexOrThrow("_display_name"));
                                p3.h.h(query, null);
                            }
                        } finally {
                        }
                    }
                    p3.h.h(query, null);
                } catch (Exception e4) {
                    exc = e4;
                    str2 = str;
                    Log.e("FilePickerUtils", "Failed to handle file name: " + exc);
                    return str2;
                }
                str = null;
            } else {
                uri2 = uri;
                str = null;
            }
            if (str == null) {
                String path = uri2.getPath();
                if (path == null) {
                    return null;
                }
                return N2.f.d0(path, '/', path);
            }
            return str;
        } catch (Exception e5) {
            exc = e5;
        }
    }

    public static ArrayList f(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension((String) arrayList.get(i));
                if (mimeTypeFromExtension == null) {
                    Objects.toString(arrayList.get(i));
                    return new ArrayList(T.b.B("*/*"));
                }
                arrayList2.add(mimeTypeFromExtension);
                if (j.a(arrayList.get(i), "csv")) {
                    arrayList2.add("text/csv");
                }
            }
            Objects.toString(arrayList);
            arrayList2.toString();
            return arrayList2;
        }
        return new ArrayList(T.b.B("*/*"));
    }

    public static void g(File file) {
        if (file != null && file.exists()) {
            if (file.listFiles() != null && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    listFiles = new File[0];
                }
                for (File file2 : listFiles) {
                    g(file2);
                }
            }
            file.delete();
        }
    }

    public static void h(C0451b c0451b, String str, Boolean bool, Boolean bool2, ArrayList arrayList, Integer num, i iVar) {
        Intent intent;
        String str2 = null;
        if (c0451b != null) {
            if (c0451b.f4980b == null) {
                c0451b.f4980b = iVar;
            } else {
                int i = C0451b.f4977m;
                iVar.error("already_active", "File picker is already active", null);
                return;
            }
        }
        if (c0451b != null) {
            c0451b.f4983e = str;
        }
        if (bool != null && c0451b != null) {
            c0451b.f4981c = bool.booleanValue();
        }
        if (bool2 != null && c0451b != null) {
            c0451b.f4982d = bool2.booleanValue();
        }
        if (c0451b != null) {
            c0451b.f4985j = arrayList;
        }
        if (num != null && c0451b != null) {
            c0451b.f4984f = num.intValue();
        }
        if (c0451b != null) {
            Activity activity = c0451b.f4979a;
            String str3 = c0451b.f4983e;
            if (str3 != null) {
                if (str3.equals("dir")) {
                    intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                } else if (j.a(c0451b.f4983e, "image/*")) {
                    intent = new Intent("android.intent.action.PICK");
                    intent.setDataAndType(Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator), c0451b.f4983e);
                    intent.setType(c0451b.f4983e);
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", c0451b.f4981c);
                    intent.putExtra("multi-pick", c0451b.f4981c);
                    String str4 = c0451b.f4983e;
                    if (str4 != null) {
                        if (N2.f.N(str4, ",", false)) {
                            str2 = str4;
                        }
                        if (str2 != null) {
                            List b02 = N2.f.b0(str2, new String[]{","}, 6);
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj : b02) {
                                if (((String) obj).length() > 0) {
                                    arrayList2.add(obj);
                                }
                            }
                            c0451b.f4985j = new ArrayList(arrayList2);
                        }
                    }
                    ArrayList arrayList3 = c0451b.f4985j;
                    if (arrayList3 != null) {
                        intent.putExtra("android.intent.extra.MIME_TYPES", arrayList3);
                    }
                } else {
                    intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType(c0451b.f4983e);
                    ArrayList arrayList4 = c0451b.f4985j;
                    if (arrayList4 != null && !arrayList4.isEmpty()) {
                        ArrayList arrayList5 = c0451b.f4985j;
                        j.b(arrayList5);
                        intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) arrayList5.toArray(new String[0]));
                    } else {
                        intent.putExtra("android.intent.extra.MIME_TYPES", intent.getType());
                    }
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", c0451b.f4981c);
                    intent.putExtra("multi-pick", c0451b.f4981c);
                }
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    activity.startActivityForResult(intent, C0451b.f4977m);
                } else {
                    Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
                    c0451b.b("invalid_format_type", "Can't handle the provided file type.");
                }
            }
        }
    }
}
