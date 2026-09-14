package androidx.lifecycle;

import F0.C0018c1;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.google.firebase.remoteconfig.internal.Code;
import com.uh.sf.R;
import h.InterfaceC0432b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.tika.fork.ForkServer;
import t.C0691g;
import t.C0694j;

/* loaded from: classes.dex */
public final class N implements InterfaceC0432b, i0.d, l.y, n3.a {

    /* renamed from: b, reason: collision with root package name */
    public static N f3571b;

    /* renamed from: c, reason: collision with root package name */
    public static N f3572c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3573a;

    public /* synthetic */ N(int i) {
        this.f3573a = i;
    }

    public static final String c(String str) {
        switch (str.hashCode()) {
            case -1349088399:
                if (!str.equals("custom")) {
                    return null;
                }
                return "*/*";
            case 96748:
                if (!str.equals("any")) {
                    return null;
                }
                return "*/*";
            case 99469:
                if (str.equals("dir")) {
                    return "dir";
                }
                return null;
            case 93166550:
                if (str.equals("audio")) {
                    return "audio/*";
                }
                return null;
            case 100313435:
                if (str.equals("image")) {
                    return "image/*";
                }
                return null;
            case 103772132:
                if (str.equals("media")) {
                    return "image/*,video/*";
                }
                return null;
            case 112202875:
                if (str.equals("video")) {
                    return "video/*";
                }
                return null;
            default:
                return null;
        }
    }

    public static long e(long[] jArr) {
        return ((jArr[2] - jArr[3]) + (jArr[1] - jArr[0])) / 2;
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [F0.c1, java.lang.Object] */
    public static C0018c1 h(Context context, String[] strArr, String str, K1.m mVar) {
        String[] n4 = n(context);
        int length = n4.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str2 = n4[i];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c4 = File.separatorChar;
                            sb.append(c4);
                            sb.append(str3);
                            sb.append(c4);
                            sb.append(str);
                            String sb2 = sb.toString();
                            mVar.k("Looking for %s in APK %s...", sb2, str2);
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                ?? obj = new Object();
                                obj.f476a = zipFile;
                                obj.f477b = entry;
                                return obj;
                            }
                        }
                        i5 = i6;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
    }

    public static String[] i(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c4 = File.separatorChar;
        sb.append(c4);
        sb.append("([^\\");
        sb.append(c4);
        sb.append("]*)");
        sb.append(c4);
        sb.append(str);
        Pattern compile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : n(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static long l(byte[] bArr, int i) {
        return ((bArr[i] & ForkServer.ERROR) << 24) + ((bArr[i + 1] & ForkServer.ERROR) << 16) + ((bArr[i + 2] & ForkServer.ERROR) << 8) + (bArr[i + 3] & ForkServer.ERROR);
    }

    public static long m(byte[] bArr, int i) {
        long l3 = l(bArr, i);
        return ((l(bArr, i + 4) * 1000) / 4294967296L) + ((l3 - 2208988800L) * 1000);
    }

    public static String[] n(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null && strArr.length != 0) {
            String[] strArr2 = new String[strArr.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
            return strArr2;
        }
        return new String[]{applicationInfo.sourceDir};
    }

    public static void o(byte[] bArr, long j2) {
        long j3 = j2 / 1000;
        long j4 = j2 - (j3 * 1000);
        bArr[40] = (byte) (r2 >> 24);
        bArr[41] = (byte) (r2 >> 16);
        bArr[42] = (byte) (r2 >> 8);
        bArr[43] = (byte) (j3 + 2208988800L);
        long j5 = (j4 * 4294967296L) / 1000;
        bArr[44] = (byte) (j5 >> 24);
        bArr[45] = (byte) (j5 >> 16);
        bArr[46] = (byte) (j5 >> 8);
        bArr[47] = (byte) (Math.random() * 255.0d);
    }

    @Override // n3.a
    public n3.b a(String str) {
        return p3.b.f5973a;
    }

    @Override // l.y
    public boolean d(l.m mVar) {
        return false;
    }

    @Override // i0.d
    public void g(int i, Object obj) {
        String str;
        switch (this.f3573a) {
            case Code.UNIMPLEMENTED /* 12 */:
                return;
            default:
                switch (i) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i == 6 || i == 7 || i == 8) {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    return;
                }
                return;
        }
    }

    public CharSequence k(Preference preference) {
        switch (this.f3573a) {
            case 10:
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                if (!TextUtils.isEmpty(null)) {
                    return null;
                }
                return editTextPreference.f3652a.getString(R.string.not_set);
            default:
                ListPreference listPreference = (ListPreference) preference;
                if (!TextUtils.isEmpty(null)) {
                    return null;
                }
                return listPreference.f3652a.getString(R.string.not_set);
        }
    }

    public /* synthetic */ N(Object obj, int i) {
        this.f3573a = i;
    }

    public N() {
        this.f3573a = 23;
        new C0694j(0);
        new C0691g();
    }

    private final void j(int i, Object obj) {
    }

    @Override // l.y
    public void b(l.m mVar, boolean z3) {
    }
}
