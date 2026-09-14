package com.pichillilorenzo.flutter_inappwebview_android;

import android.os.Build;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class PlatformUtil extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "PlatformUtil";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_platformutil";
    public InAppWebViewFlutterPlugin plugin;

    public PlatformUtil(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public static String formatDate(long j2, String str, Locale locale, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date(j2));
    }

    public static Locale getLocaleFromString(String str) {
        String str2;
        if (str == null) {
            return Locale.US;
        }
        String[] split = str.split("_");
        String str3 = split[0];
        String str4 = "";
        if (split.length <= 1) {
            str2 = "";
        } else {
            str2 = split[1];
        }
        if (split.length > 2) {
            str4 = split[2];
        }
        return new Locale(str3, str2, str4);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        if (!str.equals("formatDate")) {
            if (!str.equals("getSystemVersion")) {
                result.notImplemented();
                return;
            } else {
                result.success(String.valueOf(Build.VERSION.SDK_INT));
                return;
            }
        }
        long longValue = ((Long) methodCall.argument("date")).longValue();
        String str2 = (String) methodCall.argument("format");
        Locale localeFromString = getLocaleFromString((String) methodCall.argument("locale"));
        String str3 = (String) methodCall.argument("timezone");
        if (str3 == null) {
            str3 = "UTC";
        }
        result.success(formatDate(longValue, str2, localeFromString, TimeZone.getTimeZone(str3)));
    }
}
