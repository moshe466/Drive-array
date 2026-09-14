package w6;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.core.app.k;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.Kv;
import com.groboot.mdaemergency.models.KvTable;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import il.org.mda.health.R;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import w6.l0;

/* loaded from: classes.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    static Context f15188a;

    /* renamed from: b, reason: collision with root package name */
    public static SimpleDateFormat f15189b;

    /* renamed from: c, reason: collision with root package name */
    public static SimpleDateFormat f15190c;

    /* renamed from: d, reason: collision with root package name */
    public static SimpleDateFormat f15191d;

    /* renamed from: e, reason: collision with root package name */
    public static SimpleDateFormat f15192e;

    /* renamed from: f, reason: collision with root package name */
    public static SimpleDateFormat f15193f;

    /* renamed from: g, reason: collision with root package name */
    public static SimpleDateFormat f15194g;

    /* renamed from: h, reason: collision with root package name */
    public static SimpleDateFormat f15195h;

    /* renamed from: i, reason: collision with root package name */
    public static SimpleDateFormat f15196i;

    /* renamed from: j, reason: collision with root package name */
    public static SimpleDateFormat f15197j;

    /* renamed from: k, reason: collision with root package name */
    public static SimpleDateFormat f15198k;

    /* renamed from: l, reason: collision with root package name */
    public static SimpleDateFormat f15199l;

    /* renamed from: m, reason: collision with root package name */
    public static SimpleDateFormat f15200m;

    /* renamed from: n, reason: collision with root package name */
    public static SimpleDateFormat f15201n;

    /* renamed from: o, reason: collision with root package name */
    public static SimpleDateFormat f15202o;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f15203f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Uri f15204g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ f f15205h;

        a(Context context, Uri uri, f fVar) {
            this.f15203f = context;
            this.f15204g = uri;
            this.f15205h = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f15205h.a(Base64.encodeToString(l0.s(l0.v0(l0.q(l0.t(this.f15203f, this.f15204g, 1024)), l0.S(this.f15204g)), 0), 0));
            } catch (Exception e10) {
                this.f15205h.b(e10.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f15206f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayAdapter f15207g;

        b(i iVar, ArrayAdapter arrayAdapter) {
            this.f15206f = iVar;
            this.f15207g = arrayAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            i iVar = this.f15206f;
            if (iVar != null) {
                iVar.c((String) this.f15207g.getItem(i10), i10);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f15208f;

        c(i iVar) {
            this.f15208f = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            i iVar = this.f15208f;
            if (iVar != null) {
                iVar.b();
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements DialogInterface.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f15209f;

        d(i iVar) {
            this.f15209f = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            i iVar = this.f15209f;
            if (iVar != null) {
                iVar.a();
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15210a;

        static {
            int[] iArr = new int[h.values().length];
            f15210a = iArr;
            try {
                iArr[h.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15210a[h.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15210a[h.Type1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15210a[h.Type2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str);

        void b(String str);
    }

    /* loaded from: classes.dex */
    public interface g {
        void run();
    }

    /* loaded from: classes.dex */
    public enum h {
        SHORT,
        LONG,
        Type1,
        Type2
    }

    /* loaded from: classes.dex */
    public interface i {
        void a();

        void b();

        void c(String str, int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        Context f15211f;

        /* renamed from: g, reason: collision with root package name */
        String f15212g;

        /* renamed from: h, reason: collision with root package name */
        boolean f15213h;

        public j(Context context, String str, boolean z10) {
            this.f15211f = context;
            this.f15212g = str;
            this.f15213h = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.f15211f, this.f15212g, this.f15213h ? 1 : 0).show();
        }
    }

    static {
        Locale locale = Locale.ENGLISH;
        new SimpleDateFormat("ddMMyyyy_HHmmss", locale);
        f15189b = new SimpleDateFormat("HH", locale);
        f15190c = new SimpleDateFormat("mm", locale);
        f15191d = new SimpleDateFormat("HH:mm", locale);
        f15192e = new SimpleDateFormat("HH:mm:ss", locale);
        f15193f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", locale);
        f15194g = new SimpleDateFormat("dd/MM/yyyy HH:mm", locale);
        f15195h = new SimpleDateFormat("dd/MM/yyyy", locale);
        f15196i = new SimpleDateFormat("ddMMyy", locale);
        f15197j = new SimpleDateFormat("MM/dd/yyyy", locale);
        new SimpleDateFormat("dd/MM", locale);
        f15198k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f15199l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f15200m = new SimpleDateFormat("yyyy-MM-dd", locale);
        f15201n = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale);
        f15202o = new SimpleDateFormat("dd/MM HH:mm", locale);
        new SimpleDateFormat("ddMMyy", locale);
        new SimpleDateFormat("yyyy", locale);
        new SimpleDateFormat("MM", locale);
        new SimpleDateFormat("dd", locale);
    }

    public static Date A(String str) {
        if (l0(str)) {
            return null;
        }
        SimpleDateFormat[] simpleDateFormatArr = {f15193f, f15194g, f15195h, f15198k, f15199l, f15200m};
        for (int i10 = 0; i10 < 6; i10++) {
            try {
                return simpleDateFormatArr[i10].parse(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void A0(String str, String str2, boolean z10, int i10) {
        B0(str, str2, z10, i10, null);
    }

    public static Date B(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void B0(String str, String str2, boolean z10, int i10, String str3) {
        Intent intent = str3 != null ? new Intent(str3) : new Intent(f15188a, (Class<?>) SplashActivity.class);
        int i11 = Build.VERSION.SDK_INT;
        k.e x10 = new k.e(f15188a).w(m.j()).k(str).j(str2).f(z10).i(PendingIntent.getActivity(f15188a, i10, intent, i11 >= 23 ? 1140850688 : 1073741824)).x(RingtoneManager.getDefaultUri(2));
        if (i11 >= 16) {
            x10.y(new k.c().h(str2));
        }
        ((NotificationManager) f15188a.getSystemService("notification")).notify(i10, x10.b());
    }

    public static Date C(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void C0(Activity activity) {
        AppUser k10;
        if (m.m() == com.groboot.mdaemergency.enums.a.PHILIPINE && (k10 = m.k()) != null && k10.getIsVehicle()) {
            activity.setRequestedOrientation(0);
        }
    }

    public static int D(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static void D0(Context context) {
        if (f15188a != null) {
            return;
        }
        f15188a = context;
        context.getResources();
    }

    public static int E(int i10) {
        if (i10 == 3) {
            return 180;
        }
        if (i10 != 6) {
            return i10 != 8 ? 0 : 270;
        }
        return 90;
    }

    public static void E0(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(activity.getResources().getColor(R.color.status_bar_color));
        }
    }

    public static DisplayMetrics F(Activity activity) {
        if (activity == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static void F0(Context context, int i10, int i11, int i12, int i13, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(i10));
        builder.setMessage("\n" + context.getString(i11) + "\n");
        builder.setPositiveButton(context.getString(i12), onClickListener);
        builder.setNegativeButton(context.getString(i13), onClickListener2);
        builder.create().show();
    }

    public static Drawable G(Context context, String str) {
        try {
            Resources resources = context.getResources();
            return resources.getDrawable(resources.getIdentifier(str, "drawable", context.getPackageName()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void G0(Context context, int i10, int i11, int i12, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        I0(context, "", context.getString(i10), i11, i12, onClickListener, onClickListener2);
    }

    public static float H(String str) {
        return T0(str, Float.valueOf(0.0f)).floatValue();
    }

    public static void H0(Context context, int i10, int i11, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        F0(context, i10, i11, R.string.yes, R.string.no, onClickListener, onClickListener2);
    }

    public static String I(Date date) {
        return date == null ? "" : f15192e.format(date);
    }

    public static void I0(Context context, String str, String str2, int i10, int i11, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        J0(context, str, str2, context.getString(i10), context.getString(i11), onClickListener, onClickListener2);
    }

    public static String J(Date date) {
        if (date == null) {
            return "";
        }
        return (l(x(w()), x(date)) ? f15192e : f15202o).format(date);
    }

    public static void J0(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage("\n" + str2 + "\n");
        if (!l0(str3) && onClickListener != null) {
            builder.setPositiveButton(str3, onClickListener);
        }
        if (!l0(str4) && onClickListener2 != null) {
            builder.setNegativeButton(str4, onClickListener2);
        }
        builder.setCancelable(false);
        builder.create().show();
    }

    public static String K() {
        return "<BR>";
    }

    public static void K0(Context context, String str, String str2, String str3, String[] strArr, i iVar) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.select_dialog_singlechoice, strArr);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setAdapter(arrayAdapter, new b(iVar, arrayAdapter));
        if (!l0(str2)) {
            builder.setPositiveButton(str2, new c(iVar));
        }
        if (!l0(str3)) {
            builder.setNegativeButton(str3, new d(iVar));
        }
        builder.create().show();
    }

    public static String L(String str) {
        return "<font color=\"black\">" + str + "</font>";
    }

    public static void L0(Context context, String str, boolean z10) {
        try {
            new Handler(Looper.getMainLooper()).post(new j(context, str, z10));
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public static String M(String str) {
        return "<font color=\"blue\">" + str + "</font>";
    }

    public static void M0(String str) {
        L0(f15188a, str, true);
    }

    public static String N(String str) {
        return "<B>" + str + "</B>";
    }

    public static void N0(String str, boolean z10) {
        L0(f15188a, str, z10);
    }

    public static String O(String str) {
        return "<font color=\"red\">" + str + "</font>";
    }

    public static void O0(int i10) {
        d0.a(i10);
    }

    public static String P(String str, String str2) {
        int indexOf;
        if (str == null) {
            return "";
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return str;
        }
        return L(n(str, indexOf)) + N(O(str2)) + L(o(str, (str.length() - indexOf) - str2.length()));
    }

    public static void P0(Context context, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lat: ");
        sb2.append(str);
        sb2.append(", lon: ");
        sb2.append(str2);
        if (h("com.waze", context)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://waze.com/ul?ll=" + str + "," + str2 + "&navigate=yes"));
                intent.setFlags(268435456);
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e10) {
                e10.getMessage();
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.waze"));
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return;
            }
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + str + "," + str2 + "?q=" + str + "," + str2 + "(" + context.getResources().getString(R.string.event) + ")"));
        intent3.setFlags(268435456);
        context.startActivity(intent3);
    }

    public static String Q(String str) {
        return str.replace("http://", "").replace("http:// www.", "").replace("www.", "");
    }

    public static void Q0(Context context, Class<?> cls) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(new Intent(context, cls));
        } else {
            context.startService(new Intent(context, cls));
        }
    }

    public static int R(Date date) {
        if (date == null) {
            return 0;
        }
        return U0(f15189b.format(date), 0);
    }

    public static boolean R0(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (str2 != null && str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int S(Uri uri) {
        try {
            return new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String S0(String str, int i10, int i11) {
        if (l0(str) || str.length() <= i10) {
            return "";
        }
        if (str.length() < i11) {
            i11 = str.length() - 1;
        }
        return str.substring(i10, i11);
    }

    public static int T(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static Float T0(String str, Float f10) {
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (Exception unused) {
            return f10;
        }
    }

    public static int U(String str) {
        return U0(str, 0);
    }

    public static int U0(String str, Integer num) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return num.intValue();
        }
    }

    public static int V(String str) {
        long X = X(str);
        while (X > 2147483647L) {
            X /= 10;
        }
        return (int) X;
    }

    public static long V0(String str, Long l10) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return l10.longValue();
        }
    }

    public static long W(String str) {
        return V0(str, 0L);
    }

    public static int W0(Context context, int i10) {
        return (int) TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static long X(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (char c10 : str.toCharArray()) {
            if (c10 >= '0' && c10 <= '9') {
                sb2.append(c10);
            }
        }
        return W(sb2.toString());
    }

    public static void X0(Context context, int i10) {
        if (context == null) {
            return;
        }
        try {
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(i10);
            }
        } catch (Exception unused) {
        }
    }

    public static int Y(Date date) {
        if (date == null) {
            return 0;
        }
        return U0(f15190c.format(date), 0);
    }

    public static void Y0(final Context context, final int i10, final int i11, final int i12) {
        new Thread(new Runnable() { // from class: w6.i0
            @Override // java.lang.Runnable
            public final void run() {
                l0.r0(i11, i12, context, i10);
            }
        }).start();
    }

    public static String Z(int i10) {
        return f15188a.getResources().getString(i10);
    }

    public static void Z0(Context context, h hVar) {
        long j10;
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        int i10 = e.f15210a[hVar.ordinal()];
        if (i10 == 1) {
            j10 = 200;
        } else {
            if (i10 != 2) {
                if (i10 == 3) {
                    vibrator.vibrate(100L);
                    vibrator.vibrate(400L);
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    vibrator.vibrate(100L);
                    vibrator.vibrate(100L);
                }
                vibrator.vibrate(100L);
                return;
            }
            j10 = 900;
        }
        vibrator.vibrate(j10);
    }

    public static String a0(String str) {
        return str == null ? "" : str;
    }

    public static String b0(Date date) {
        return f15198k.format(date);
    }

    public static String c0(Date date, SimpleDateFormat simpleDateFormat) {
        return date == null ? "" : simpleDateFormat.format(date);
    }

    public static Date d(Date date, int i10) {
        return e(date, i10 * 24);
    }

    public static String d0(Date date) {
        if (date == null) {
            return "";
        }
        return (l(x(w()), x(date)) ? f15191d : f15202o).format(date);
    }

    public static Date e(Date date, int i10) {
        return f(date, i10 * 60);
    }

    public static Date e0() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(6, -1);
        return calendar.getTime();
    }

    public static Date f(Date date, int i10) {
        return g(date, i10 * 60);
    }

    public static KvTable f0(Hashtable<Integer, String> hashtable) {
        KvTable kvTable = new KvTable();
        Iterator<Integer> it = hashtable.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            kvTable.add((KvTable) new Kv(intValue, hashtable.get(Integer.valueOf(intValue))));
        }
        return kvTable;
    }

    public static Date g(Date date, int i10) {
        return new Date(date.getTime() + (i10 * 1000));
    }

    public static void g0() {
    }

    public static boolean h(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void h0(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void i(Context context, int i10) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i10);
    }

    public static boolean i0(Boolean bool) {
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static void j(Activity activity) {
        activity.getWindow().setSoftInputMode(3);
    }

    public static boolean j0(Class<?> cls, Context context) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (cls.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static void k(Activity activity) {
        activity.getWindow().setSoftInputMode(5);
    }

    public static boolean k0(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean l(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str2.equals(str);
    }

    public static boolean l0(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean m(UUID uuid, UUID uuid2) {
        if (uuid == null || uuid2 == null) {
            return false;
        }
        return uuid.equals(uuid2);
    }

    public static boolean m0(Activity activity) {
        DisplayMetrics F = F(activity);
        return F.widthPixels < 480 || F.heightPixels < 600;
    }

    public static String n(String str, int i10) {
        return l0(str) ? "" : str.length() < i10 ? str : str.substring(0, i10);
    }

    public static boolean n0(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static String o(String str, int i10) {
        return l0(str) ? "" : str.length() < i10 ? str : str.substring(str.length() - i10);
    }

    public static final boolean o0(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public static void p(Uri uri, Context context, f fVar) {
        new Thread(new a(context, uri, fVar)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(int i10, g gVar) {
        O0(i10);
        y0(gVar, 0);
    }

    public static Bitmap q(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    private static byte[] r(Uri uri, int i10) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inDither = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(new File(uri.getPath()).getAbsolutePath(), options);
            byte[] s10 = s(decodeFile, i10);
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            return s10;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(int i10, int i11, Context context, int i12) {
        for (int i13 = 0; i13 < i10; i13++) {
            if (i13 > 0) {
                d0.a(i11);
            }
            X0(context, i12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] s(android.graphics.Bitmap r6, int r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L6
            byte[] r6 = new byte[r0]
            return r6
        L6:
            r1 = 0
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            java.lang.String r2 = "/"
            if (r7 <= 0) goto L5c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            r3.<init>()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            java.lang.String r4 = "resize image. original:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            int r4 = r6.getWidth()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            r3.append(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            r3.append(r2)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            int r4 = r6.getHeight()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            r3.append(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            int r3 = r6.getWidth()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            float r3 = (float) r3     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            float r4 = (float) r7     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            int r5 = r6.getHeight()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            float r5 = (float) r5     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            float r4 = r4 / r5
            float r3 = r3 * r4
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createScaledBitmap(r6, r3, r7, r0)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> La2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            r0.<init>()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            java.lang.String r3 = "resize image. after:"
            r0.append(r3)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            int r3 = r6.getWidth()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            r0.append(r3)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            r0.append(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            int r6 = r6.getHeight()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            r0.append(r6)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> La3
            r6 = r7
            goto L5c
        L59:
            r6 = move-exception
            r1 = r7
            goto L9c
        L5c:
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            r7.<init>()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            r3 = 100
            r6.compress(r0, r3, r7)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            byte[] r0 = r7.toByteArray()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            if (r0 == 0) goto L91
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            r0.<init>()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            java.lang.String r3 = "getByteArrayFromURI size:"
            r0.append(r3)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            int r3 = r6.getWidth()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            r0.append(r3)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            r0.append(r2)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            int r2 = r6.getHeight()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            r0.append(r2)     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Throwable -> L95 java.lang.Exception -> L99
            r6.recycle()
            return r7
        L91:
            r6.recycle()
            goto La8
        L95:
            r7 = move-exception
            r1 = r6
            r6 = r7
            goto L9c
        L99:
            r7 = r6
            goto La3
        L9b:
            r6 = move-exception
        L9c:
            if (r1 == 0) goto La1
            r1.recycle()
        La1:
            throw r6
        La2:
            r7 = r1
        La3:
            if (r7 == 0) goto La8
            r7.recycle()
        La8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.l0.s(android.graphics.Bitmap, int):byte[]");
    }

    public static String s0(String str, String str2) {
        while (str.length() >= str2.length() && l(str.substring(0, str2.length()), str2)) {
            str = str.substring(str2.length());
        }
        return str;
    }

    public static byte[] t(Context context, Uri uri, int i10) {
        return r(uri, i10);
    }

    public static String t0(String str, int i10) {
        return (!l0(str) && str.length() > i10) ? str.substring(0, str.length() - i10) : "";
    }

    public static int u(Context context, int i10) {
        return Build.VERSION.SDK_INT >= 23 ? context.getResources().getColor(i10, context.getTheme()) : context.getResources().getColor(i10);
    }

    public static String u0(String str, String str2) {
        while (str.length() >= str2.length() && l(str.substring(str.length() - str2.length()), str2)) {
            str = str.substring(0, str.length() - str2.length());
        }
        return str;
    }

    public static Context v() {
        return f15188a;
    }

    public static Bitmap v0(Bitmap bitmap, int i10) {
        int E = E(i10);
        if (E == 0) {
            return bitmap;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rotateImage ");
        sb2.append(E);
        return w0(bitmap, E);
    }

    public static Date w() {
        return new Date();
    }

    public static Bitmap w0(Bitmap bitmap, float f10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static String x(Date date) {
        return date == null ? "" : f15195h.format(date);
    }

    public static void x0(g gVar) {
        y0(gVar, 0);
    }

    public static Date y(int i10, int i11, int i12) {
        return A(String.format("%02d", Integer.valueOf(i12)) + "/" + String.format("%02d", Integer.valueOf(i11)) + "/" + String.format("%04d", Integer.valueOf(i10)));
    }

    public static void y0(final g gVar, final int i10) {
        if (i10 > 0) {
            new Thread(new Runnable() { // from class: w6.j0
                @Override // java.lang.Runnable
                public final void run() {
                    l0.p0(i10, gVar);
                }
            });
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: w6.k0
                @Override // java.lang.Runnable
                public final void run() {
                    l0.g.this.run();
                }
            });
        }
    }

    public static Date z(long j10) {
        return new Date(j10);
    }

    public static boolean z0(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
