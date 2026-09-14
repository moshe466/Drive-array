package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzawb {
    public static final zzddu zzdsr = new zzavv(Looper.getMainLooper());

    @GuardedBy("userAgentLock")
    private String zzbfb;
    private AtomicReference<Pattern> zzdsp = new AtomicReference<>(null);
    private AtomicReference<Pattern> zzdsq = new AtomicReference<>(null);
    private boolean zzxy = true;
    private final Object zzdss = new Object();
    private boolean zzdst = false;
    private boolean zzdsu = false;

    @VisibleForTesting
    public static String a(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return zzwj();
        }
    }

    private static int zza(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if (c < 'A' || c > 'F') {
            c2 = 'a';
            if (c < 'a' || c > 'f') {
                throw new IllegalArgumentException("Invalid Hex.");
            }
        }
        return (c - c2) + 10;
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String zza(InputStreamReader inputStreamReader) {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private final JSONArray zza(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zza(jSONArray, it.next());
        }
        return jSONArray;
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @TargetApi(18)
    public static void zza(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzb(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzayu.zzea(sb.toString());
        } catch (ActivityNotFoundException e) {
            zzayu.zzc("No browser is found.", e);
        }
    }

    public static void zza(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = zzabi.zzcuk.get().booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (z) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
        }
    }

    private final void zza(JSONArray jSONArray, Object obj) {
        Object zza;
        if (obj instanceof Bundle) {
            zza = zzd((Bundle) obj);
        } else if (obj instanceof Map) {
            zza = zzi((Map<String, ?>) obj);
        } else {
            if (!(obj instanceof Collection)) {
                if (!(obj instanceof Object[])) {
                    jSONArray.put(obj);
                    return;
                }
                JSONArray jSONArray2 = new JSONArray();
                for (Object obj2 : (Object[]) obj) {
                    zza(jSONArray2, obj2);
                }
                jSONArray.put(jSONArray2);
                return;
            }
            zza = zza((Collection<?>) obj);
        }
        jSONArray.put(zza);
    }

    private final void zza(JSONObject jSONObject, String str, Object obj) {
        Collection<?> asList;
        Object zza;
        if (obj instanceof Bundle) {
            zza = zzd((Bundle) obj);
        } else if (obj instanceof Map) {
            zza = zzi((Map<String, ?>) obj);
        } else {
            if (obj instanceof Collection) {
                if (str == null) {
                    str = "null";
                }
                asList = (Collection) obj;
            } else {
                if (!(obj instanceof Object[])) {
                    jSONObject.put(str, obj);
                    return;
                }
                asList = Arrays.asList((Object[]) obj);
            }
            zza = zza(asList);
        }
        jSONObject.put(str, zza);
    }

    private static boolean zza(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static AlertDialog.Builder zzar(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzyy zzas(Context context) {
        return new zzyy(context);
    }

    @SuppressLint({"NewApi"})
    public static String zzat(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean zzau(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return !(powerManager == null ? false : powerManager.isScreenOn());
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int zzav(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    @Nullable
    private static KeyguardManager zzaw(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    @TargetApi(16)
    public static boolean zzax(Context context) {
        KeyguardManager zzaw;
        return context != null && PlatformVersion.isAtLeastJellyBean() && (zzaw = zzaw(context)) != null && zzaw.isKeyguardLocked();
    }

    public static boolean zzay(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzayu.zzc("Error loading class.", th);
            com.google.android.gms.ads.internal.zzq.zzku().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static String zzaz(Context context) {
        return !((Boolean) zzve.zzoy().zzd(zzzn.zzcpw)).booleanValue() ? "" : context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }

    @TargetApi(18)
    public static void zzb(Context context, Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastJellyBeanMR2()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder(CustomTabsIntent.EXTRA_SESSION, null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void zzb(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            new zzayb(context, str, (String) obj).zzvr();
        }
    }

    public static Bundle zzba(Context context) {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcpx)).booleanValue()) {
            return null;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Bundle bundle = new Bundle();
        if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
            bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
        }
        String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (defaultSharedPreferences.contains(str)) {
                bundle.putString(str, defaultSharedPreferences.getString(str, null));
            }
        }
        return bundle;
    }

    public static boolean zzbb(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static void zzc(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes(HttpRequest.CHARSET_UTF8));
            openFileOutput.close();
        } catch (Exception e) {
            zzayu.zzc("Error writing to file in internal storage.", e);
        }
    }

    public static void zzc(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzazd.zzdwe.execute(runnable);
        }
    }

    @Nullable
    public static WebResourceResponse zzd(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzq.zzkq().zzr(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzaxk(context).zzc(str2, hashMap).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", HttpRequest.CHARSET_UTF8, new ByteArrayInputStream(str3.getBytes(HttpRequest.CHARSET_UTF8)));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzayu.zzd("Could not fetch MRAID JS.", e);
            return null;
        }
    }

    public static WebResourceResponse zzd(HttpURLConnection httpURLConnection) {
        com.google.android.gms.ads.internal.zzq.zzkq();
        String contentType = httpURLConnection.getContentType();
        String str = "";
        String trim = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        com.google.android.gms.ads.internal.zzq.zzkq();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    if (split[i].trim().startsWith(HttpRequest.PARAM_CHARSET)) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str = split2[1].trim();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        String str2 = str;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return com.google.android.gms.ads.internal.zzq.zzks().zza(trim, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static int[] zzd(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzwm() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static int zzei(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzayu.zzez(sb.toString());
            return 0;
        }
    }

    public static boolean zzej(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static boolean zzem(String str) {
        if (!zzayo.isEnabled()) {
            return false;
        }
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcny)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzve.zzoy().zzd(zzzn.zzcoa);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) zzve.zzoy().zzd(zzzn.zzcnz);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, String> zzi(Uri uri) {
        if (!zzaay.zzctg.get().booleanValue()) {
            if (uri == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            com.google.android.gms.ads.internal.zzq.zzks();
            for (String str : uri.getQueryParameterNames()) {
                hashMap.put(str, uri.getQueryParameter(str));
            }
            return hashMap;
        }
        if (uri == null) {
            return null;
        }
        HashMap hashMap2 = new HashMap(20);
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return hashMap2;
        }
        int length = encodedQuery.length();
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(length);
        StringBuilder sb3 = sb;
        int i = 0;
        while (i < length) {
            char charAt = encodedQuery.charAt(i);
            if (charAt == '%') {
                byte[] bArr = new byte[(length - i) / 3];
                int i2 = 0;
                while (i < length - 2 && charAt == '%') {
                    try {
                        bArr[i2] = (byte) ((zza(encodedQuery.charAt(i + 1)) << 4) + zza(encodedQuery.charAt(i + 2)));
                        i2++;
                    } catch (IllegalArgumentException unused) {
                    }
                    i += 3;
                    if (i < length) {
                        charAt = encodedQuery.charAt(i);
                    }
                }
                try {
                    sb3.append(new String(bArr, 0, i2, HttpRequest.CHARSET_UTF8));
                } catch (UnsupportedEncodingException unused2) {
                }
                if (charAt != '%') {
                }
            } else if (charAt != '&') {
                if (charAt == '+') {
                    charAt = ' ';
                } else if (charAt == '=' && sb3 != sb2) {
                    sb3 = sb2;
                }
                sb3.append(charAt);
            } else {
                if (sb.length() > 0 && sb3 != sb) {
                    hashMap2.put(sb.toString(), sb2.toString());
                    sb.setLength(0);
                    sb2.setLength(0);
                }
                sb3 = sb;
            }
            i++;
        }
        if (sb.length() > 0 && sb3 != sb) {
            hashMap2.put(sb.toString(), sb2.toString());
        }
        return hashMap2;
    }

    public static Bitmap zzk(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap zzl(View view) {
        if (view == null) {
            return null;
        }
        Bitmap zzn = zzn(view);
        return zzn == null ? zzm(view) : zzn;
    }

    private static Bitmap zzm(@NonNull View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return createBitmap;
            }
            zzayu.zzez("Width or height of view is zero");
            return null;
        } catch (RuntimeException e) {
            zzayu.zzc("Fail to capture the webview", e);
            return null;
        }
    }

    private static Bitmap zzn(@NonNull View view) {
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            r0 = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e) {
            zzayu.zzc("Fail to capture the web view", e);
        }
        return r0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzo(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L12
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L12
            android.app.Activity r2 = (android.app.Activity) r2
            goto L13
        L12:
            r2 = r0
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawb.zzo(android.view.View):boolean");
    }

    public static int zzp(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static boolean zzq(Context context, String str) {
        Context zzaa = zzarf.zzaa(context);
        return Wrappers.packageManager(zzaa).checkPermission(str, zzaa.getPackageName()) == 0;
    }

    public static String zzs(Context context, String str) {
        try {
            return new String(IOUtils.readInputStreamFully(context.openFileInput(str), true), HttpRequest.CHARSET_UTF8);
        } catch (IOException unused) {
            zzayu.zzea("Error reading from internal storage.");
            return "";
        }
    }

    private static String zzwj() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static String zzwk() {
        return UUID.randomUUID().toString();
    }

    public static String zzwl() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] zzwm() {
        return new int[]{0, 0};
    }

    public static String zzwn() {
        Resources resources = com.google.android.gms.ads.internal.zzq.zzku().getResources();
        return resources != null ? resources.getString(com.google.android.gms.ads.impl.R.string.s7) : "Test Ad";
    }

    public final JSONObject zza(@Nullable Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return zzd(bundle);
            } catch (JSONException e) {
                zzayu.zzc("Error converting Bundle to JSON", e);
            }
        }
        return null;
    }

    public final void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zzr(context, str));
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        com.google.android.gms.ads.internal.zzq.zzkq();
        bundle.putString("device", zzwl());
        bundle.putString("eids", TextUtils.join(",", zzzn.zzqg()));
        zzve.zzou();
        zzayk.zza(context, str, str2, bundle, true, new zzawc(this, context, str));
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zzr(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean zza(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zza(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzaw(context));
    }

    public final boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (!com.google.android.gms.ads.internal.zzq.zzkq().zzxy) {
            if ((keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) && !zzo(view)) {
                z = false;
                if (view.getVisibility() == 0 && view.isShown()) {
                    if ((powerManager != null || powerManager.isScreenOn()) && z) {
                        if (((Boolean) zzve.zzoy().zzd(zzzn.zzckg)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = true;
        if (view.getVisibility() == 0) {
            if (powerManager != null || powerManager.isScreenOn()) {
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzckg)).booleanValue()) {
                }
                return true;
            }
        }
        return false;
    }

    public final boolean zzao(Context context) {
        if (this.zzdst) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzawe(this, null), intentFilter);
        this.zzdst = true;
        return true;
    }

    public final boolean zzap(Context context) {
        if (this.zzdsu) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzawf(this, null), intentFilter);
        this.zzdsu = true;
        return true;
    }

    public final JSONObject zzd(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final int[] zze(Activity activity) {
        int[] zzd = zzd(activity);
        return new int[]{zzve.zzou().zzb(activity, zzd[0]), zzve.zzou().zzb(activity, zzd[1])};
    }

    public final boolean zzek(String str) {
        return zza(str, this.zzdsp, (String) zzve.zzoy().zzd(zzzn.zzcia));
    }

    public final boolean zzel(String str) {
        return zza(str, this.zzdsq, (String) zzve.zzoy().zzd(zzzn.zzcib));
    }

    public final int[] zzf(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        int[] zzwm = (window == null || (findViewById = window.findViewById(R.id.content)) == null) ? zzwm() : new int[]{findViewById.getTop(), findViewById.getBottom()};
        return new int[]{zzve.zzou().zzb(activity, zzwm[0]), zzve.zzou().zzb(activity, zzwm[1])};
    }

    public final JSONObject zzi(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final String zzr(Context context, String str) {
        synchronized (this.zzdss) {
            if (this.zzbfb != null) {
                return this.zzbfb;
            }
            if (str == null) {
                return zzwj();
            }
            try {
                this.zzbfb = com.google.android.gms.ads.internal.zzq.zzks().getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(this.zzbfb)) {
                zzve.zzou();
                if (zzayk.zzxe()) {
                    this.zzbfb = a(context);
                } else {
                    this.zzbfb = null;
                    zzdsr.post(new zzawd(this, context));
                    while (this.zzbfb == null) {
                        try {
                            this.zzdss.wait();
                        } catch (InterruptedException unused2) {
                            this.zzbfb = zzwj();
                            String valueOf = String.valueOf(this.zzbfb);
                            zzayu.zzez(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                        }
                    }
                }
            }
            String valueOf2 = String.valueOf(this.zzbfb);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length());
            sb.append(valueOf2);
            sb.append(" (Mobile; ");
            sb.append(str);
            this.zzbfb = sb.toString();
            try {
                if (Wrappers.packageManager(context).isCallerInstantApp()) {
                    this.zzbfb = String.valueOf(this.zzbfb).concat(";aia");
                }
            } catch (Exception e) {
                com.google.android.gms.ads.internal.zzq.zzku().zza(e, "AdUtil.getUserAgent");
            }
            this.zzbfb = String.valueOf(this.zzbfb).concat(")");
            return this.zzbfb;
        }
    }
}
