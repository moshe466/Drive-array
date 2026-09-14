package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.firebase.sessions.settings.RemoteSettings;
import e0.a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.tika.metadata.OfficeOpenXMLExtended;
import org.apache.tika.mime.MimeTypes;
import org.xmlpull.v1.XmlPullParserException;
import x.C0775f;
import x.InterfaceC0774e;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private String mAuthority;
    private InterfaceC0774e mLocalPathStrategy;
    private final Object mLock = new Object();
    private final int mResourceId = 0;
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File(RemoteSettings.FORWARD_SLASH_STRING);
    private static final HashMap<String, InterfaceC0774e> sCache = new HashMap<>();

    public static String access$000(String str) {
        if (str.length() > 0 && str.charAt(str.length() - 1) == '/') {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static InterfaceC0774e b(Context context, int i, String str) {
        InterfaceC0774e interfaceC0774e;
        HashMap<String, InterfaceC0774e> hashMap = sCache;
        synchronized (hashMap) {
            try {
                interfaceC0774e = hashMap.get(str);
                if (interfaceC0774e == null) {
                    try {
                        try {
                            interfaceC0774e = c(context, i, str);
                            hashMap.put(str, interfaceC0774e);
                        } catch (IOException e4) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e4);
                        }
                    } catch (XmlPullParserException e5) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e5);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0774e;
    }

    public static C0775f c(Context context, int i, String str) {
        C0775f c0775f = new C0775f(str);
        XmlResourceParser fileProviderPathsMetaData = getFileProviderPathsMetaData(context, str, context.getPackageManager().resolveContentProvider(str, 128), i);
        while (true) {
            int next = fileProviderPathsMetaData.next();
            if (next != 1) {
                if (next == 2) {
                    String name = fileProviderPathsMetaData.getName();
                    File file = null;
                    String attributeValue = fileProviderPathsMetaData.getAttributeValue(null, ATTR_NAME);
                    String attributeValue2 = fileProviderPathsMetaData.getAttributeValue(null, ATTR_PATH);
                    if (TAG_ROOT_PATH.equals(name)) {
                        file = DEVICE_ROOT;
                    } else if (TAG_FILES_PATH.equals(name)) {
                        file = context.getFilesDir();
                    } else if (TAG_CACHE_PATH.equals(name)) {
                        file = context.getCacheDir();
                    } else if (TAG_EXTERNAL.equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if (TAG_EXTERNAL_FILES.equals(name)) {
                        File[] externalFilesDirs = context.getExternalFilesDirs(null);
                        if (externalFilesDirs.length > 0) {
                            file = externalFilesDirs[0];
                        }
                    } else if (TAG_EXTERNAL_CACHE.equals(name)) {
                        File[] externalCacheDirs = context.getExternalCacheDirs();
                        if (externalCacheDirs.length > 0) {
                            file = externalCacheDirs[0];
                        }
                    } else if (TAG_EXTERNAL_MEDIA.equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            file = externalMediaDirs[0];
                        }
                    }
                    if (file == null) {
                        continue;
                    } else {
                        String str2 = new String[]{attributeValue2}[0];
                        if (str2 != null) {
                            file = new File(file, str2);
                        }
                        if (!TextUtils.isEmpty(attributeValue)) {
                            try {
                                c0775f.f6736b.put(attributeValue, file.getCanonicalFile());
                            } catch (IOException e4) {
                                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e4);
                            }
                        } else {
                            throw new IllegalArgumentException("Name must not be empty");
                        }
                    }
                }
            } else {
                return c0775f;
            }
        }
    }

    public static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, ProviderInfo providerInfo, int i) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && i != 0) {
                Bundle bundle = new Bundle(1);
                providerInfo.metaData = bundle;
                bundle.putInt(META_DATA_FILE_PROVIDER_PATHS, i);
            }
            XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
            if (loadXmlMetaData != null) {
                return loadXmlMetaData;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException(a.d("Couldn't find meta-data for provider with authority ", str));
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        String substring;
        C0775f c0775f = (C0775f) b(context, 0, str);
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : c0775f.f6736b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (access$000(canonicalPath).startsWith(access$000(path) + '/') && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry != null) {
                String path2 = ((File) entry.getValue()).getPath();
                if (path2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    substring = canonicalPath.substring(path2.length());
                } else {
                    substring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme("content").authority(c0775f.f6735a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(substring, RemoteSettings.FORWARD_SLASH_STRING)).build();
            }
            throw new IllegalArgumentException(a.d("Failed to find configured root that contains ", canonicalPath));
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }

    public final InterfaceC0774e a() {
        InterfaceC0774e interfaceC0774e;
        synchronized (this.mLock) {
            try {
                if (this.mAuthority != null) {
                    if (this.mLocalPathStrategy == null) {
                        this.mLocalPathStrategy = b(getContext(), this.mResourceId, this.mAuthority);
                    }
                    interfaceC0774e = this.mLocalPathStrategy;
                } else {
                    throw new NullPointerException("mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0774e;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                String str = providerInfo.authority;
                if (str != null && !str.trim().isEmpty()) {
                    String str2 = providerInfo.authority.split(";")[0];
                    synchronized (this.mLock) {
                        this.mAuthority = str2;
                    }
                    HashMap<String, InterfaceC0774e> hashMap = sCache;
                    synchronized (hashMap) {
                        hashMap.remove(str2);
                    }
                    return;
                }
                throw new SecurityException("Provider must have a non-empty authority");
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return ((C0775f) a()).a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File a2 = ((C0775f) a()).a(uri);
        int lastIndexOf = a2.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a2.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
            return MimeTypes.OCTET_STREAM;
        }
        return MimeTypes.OCTET_STREAM;
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return MimeTypes.OCTET_STREAM;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        int i;
        File a2 = ((C0775f) a()).a(uri);
        if ("r".equals(str)) {
            i = 268435456;
        } else if (!OfficeOpenXMLExtended.WORD_PROCESSING_PREFIX.equals(str) && !"wt".equals(str)) {
            if ("wa".equals(str)) {
                i = 704643072;
            } else if ("rw".equals(str)) {
                i = 939524096;
            } else if ("rwt".equals(str)) {
                i = 1006632960;
            } else {
                throw new IllegalArgumentException(a.d("Invalid mode: ", str));
            }
        } else {
            i = 738197504;
        }
        return ParcelFileDescriptor.open(a2, i);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        String str3;
        File a2 = ((C0775f) a()).a(uri);
        String queryParameter = uri.getQueryParameter(DISPLAYNAME_FIELD);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str4 : strArr) {
            if ("_display_name".equals(str4)) {
                strArr3[i3] = "_display_name";
                i = i3 + 1;
                if (queryParameter == null) {
                    str3 = a2.getName();
                } else {
                    str3 = queryParameter;
                }
                objArr[i3] = str3;
            } else if ("_size".equals(str4)) {
                strArr3[i3] = "_size";
                i = i3 + 1;
                objArr[i3] = Long.valueOf(a2.length());
            }
            i3 = i;
        }
        String[] strArr4 = new String[i3];
        System.arraycopy(strArr3, 0, strArr4, 0, i3);
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, 0, objArr2, 0, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, str2).build();
    }
}
