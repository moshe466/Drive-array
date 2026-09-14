package com.pichillilorenzo.flutter_inappwebview_android;

import F0.AbstractC0008a;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.google.android.gms.common.internal.ImagesContract;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import e0.a;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import m3.b;
import org.chromium.support_lib_boundary.WebViewCookieManagerBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import t0.d;
import u0.F;
import u0.G;

/* loaded from: classes.dex */
public class MyCookieManager extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "MyCookieManager";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_cookiemanager";
    public static CookieManager cookieManager;
    public InAppWebViewFlutterPlugin plugin;

    public MyCookieManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new MethodChannel(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public static String getCookieExpirationDate(Long l3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date(l3.longValue()));
    }

    private static CookieManager getCookieManager() {
        if (cookieManager == null) {
            try {
                cookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Exception e4) {
                if (e4.getMessage() != null && e4.getClass().getCanonicalName().equals("android.webkit.WebViewFactory.MissingWebViewPackageException")) {
                    return null;
                }
                throw e4;
            }
        }
        return cookieManager;
    }

    public static void init() {
        if (cookieManager == null) {
            cookieManager = getCookieManager();
        }
    }

    public void deleteAllCookies(final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 == null) {
            result.success(Boolean.FALSE);
        } else {
            cookieManager.removeAllCookies(new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.MyCookieManager.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Boolean bool) {
                    result.success(bool);
                }
            });
            cookieManager.flush();
        }
    }

    public void deleteCookie(String str, String str2, String str3, String str4, final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        String str5 = str2 + "=; Path=" + str4 + "; Max-Age=-1";
        if (str3 != null) {
            str5 = AbstractC0008a.o(str5, "; Domain=", str3);
        }
        cookieManager.setCookie(str, AbstractC0008a.n(str5, ";"), new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.MyCookieManager.2
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool) {
                result.success(bool);
            }
        });
        cookieManager.flush();
    }

    public void deleteCookies(String str, String str2, String str3, MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        String cookie = cookieManager2.getCookie(str);
        if (cookie != null) {
            for (String str4 : cookie.split(";")) {
                String str5 = str4.split("=", 2)[0].trim() + "=; Path=" + str3 + "; Max-Age=-1";
                if (str2 != null) {
                    str5 = AbstractC0008a.o(str5, "; Domain=", str2);
                }
                cookieManager.setCookie(str, AbstractC0008a.n(str5, ";"), null);
            }
            cookieManager.flush();
        }
        result.success(Boolean.TRUE);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    public List<Map<String, Object>> getCookies(String str) {
        String str2;
        String str3;
        String str4;
        ArrayList arrayList = new ArrayList();
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 != null) {
            List<String> arrayList2 = new ArrayList<>();
            String str5 = "GET_COOKIE_INFO";
            String str6 = ";";
            if (d.a("GET_COOKIE_INFO")) {
                CookieManager cookieManager3 = cookieManager;
                if (F.f6523N.b()) {
                    arrayList2 = ((WebViewCookieManagerBoundaryInterface) b.d(WebViewCookieManagerBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) G.f6548a.f6552b).convertCookieManager(cookieManager3))).getCookieInfo(str);
                } else {
                    throw F.a();
                }
            } else {
                String cookie = cookieManager.getCookie(str);
                if (cookie != null) {
                    arrayList2 = Arrays.asList(cookie.split(";"));
                }
            }
            Iterator<String> it = arrayList2.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(str6);
                if (split.length != 0) {
                    String[] split2 = split[0].split("=", 2);
                    String trim = split2[0].trim();
                    if (split2.length <= 1) {
                        str2 = "";
                    } else {
                        str2 = split2[1].trim();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", trim);
                    hashMap.put("value", str2);
                    hashMap.put("expiresDate", null);
                    hashMap.put("isSessionOnly", null);
                    hashMap.put("domain", null);
                    hashMap.put("sameSite", null);
                    hashMap.put("isSecure", null);
                    hashMap.put("isHttpOnly", null);
                    hashMap.put("path", null);
                    if (d.a(str5)) {
                        Boolean bool = Boolean.FALSE;
                        hashMap.put("isSecure", bool);
                        hashMap.put("isHttpOnly", bool);
                        int i = 1;
                        while (i < split.length) {
                            Iterator<String> it2 = it;
                            String[] split3 = split[i].split("=", 2);
                            String trim2 = split3[0].trim();
                            String str7 = str5;
                            String[] strArr = split;
                            if (split3.length <= 1) {
                                str3 = "";
                            } else {
                                str3 = split3[1].trim();
                            }
                            if (trim2.equalsIgnoreCase("Expires")) {
                                try {
                                    str4 = str6;
                                    try {
                                        Date parse = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.US).parse(str3);
                                        if (parse != null) {
                                            hashMap.put("expiresDate", Long.valueOf(parse.getTime()));
                                        }
                                    } catch (ParseException e4) {
                                        e = e4;
                                        Log.e(LOG_TAG, "", e);
                                        i++;
                                        str5 = str7;
                                        it = it2;
                                        split = strArr;
                                        str6 = str4;
                                    }
                                } catch (ParseException e5) {
                                    e = e5;
                                    str4 = str6;
                                }
                            } else {
                                str4 = str6;
                                if (trim2.equalsIgnoreCase("Max-Age")) {
                                    try {
                                        hashMap.put("expiresDate", Long.valueOf(System.currentTimeMillis() + Long.parseLong(str3)));
                                    } catch (NumberFormatException e6) {
                                        Log.e(LOG_TAG, "", e6);
                                    }
                                } else if (trim2.equalsIgnoreCase("Domain")) {
                                    hashMap.put("domain", str3);
                                } else if (trim2.equalsIgnoreCase("SameSite")) {
                                    hashMap.put("sameSite", str3);
                                } else if (trim2.equalsIgnoreCase("Secure")) {
                                    hashMap.put("isSecure", Boolean.TRUE);
                                } else if (trim2.equalsIgnoreCase("HttpOnly")) {
                                    hashMap.put("isHttpOnly", Boolean.TRUE);
                                } else if (trim2.equalsIgnoreCase("Path")) {
                                    hashMap.put("path", str3);
                                }
                            }
                            i++;
                            str5 = str7;
                            it = it2;
                            split = strArr;
                            str6 = str4;
                        }
                    }
                    arrayList.add(hashMap);
                    str5 = str5;
                    it = it;
                    str6 = str6;
                }
            }
        }
        return arrayList;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Long l3;
        init();
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1222815761:
                if (str.equals("deleteCookie")) {
                    c4 = 0;
                    break;
                }
                break;
            case -913968963:
                if (str.equals("removeSessionCookies")) {
                    c4 = 1;
                    break;
                }
                break;
            case 126640486:
                if (str.equals("setCookie")) {
                    c4 = 2;
                    break;
                }
                break;
            case 747417188:
                if (str.equals("deleteCookies")) {
                    c4 = 3;
                    break;
                }
                break;
            case 822411705:
                if (str.equals("deleteAllCookies")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1989049945:
                if (str.equals("getCookies")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                deleteCookie((String) methodCall.argument(ImagesContract.URL), (String) methodCall.argument("name"), (String) methodCall.argument("domain"), (String) methodCall.argument("path"), result);
                return;
            case 1:
                removeSessionCookies(result);
                return;
            case 2:
                String str2 = (String) methodCall.argument(ImagesContract.URL);
                String str3 = (String) methodCall.argument("name");
                String str4 = (String) methodCall.argument("value");
                String str5 = (String) methodCall.argument("domain");
                String str6 = (String) methodCall.argument("path");
                String str7 = (String) methodCall.argument("expiresDate");
                if (str7 != null) {
                    l3 = new Long(str7);
                } else {
                    l3 = null;
                }
                setCookie(str2, str3, str4, str5, str6, l3, (Integer) methodCall.argument("maxAge"), (Boolean) methodCall.argument("isSecure"), (Boolean) methodCall.argument("isHttpOnly"), (String) methodCall.argument("sameSite"), result);
                return;
            case 3:
                deleteCookies((String) methodCall.argument(ImagesContract.URL), (String) methodCall.argument("domain"), (String) methodCall.argument("path"), result);
                return;
            case 4:
                deleteAllCookies(result);
                return;
            case 5:
                result.success(getCookies((String) methodCall.argument(ImagesContract.URL)));
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public void removeSessionCookies(final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 == null) {
            result.success(Boolean.FALSE);
        } else {
            cookieManager.removeSessionCookies(new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.MyCookieManager.4
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Boolean bool) {
                    result.success(bool);
                }
            });
            cookieManager.flush();
        }
    }

    public void setCookie(String str, String str2, String str3, String str4, String str5, Long l3, Integer num, Boolean bool, Boolean bool2, String str6, final MethodChannel.Result result) {
        CookieManager cookieManager2 = getCookieManager();
        cookieManager = cookieManager2;
        if (cookieManager2 == null) {
            result.success(Boolean.FALSE);
            return;
        }
        String str7 = str2 + "=" + str3 + "; Path=" + str5;
        if (str4 != null) {
            str7 = AbstractC0008a.o(str7, "; Domain=", str4);
        }
        if (l3 != null) {
            StringBuilder i = a.i(str7, "; Expires=");
            i.append(getCookieExpirationDate(l3));
            str7 = i.toString();
        }
        if (num != null) {
            StringBuilder i3 = a.i(str7, "; Max-Age=");
            i3.append(num.toString());
            str7 = i3.toString();
        }
        if (bool != null && bool.booleanValue()) {
            str7 = AbstractC0008a.n(str7, "; Secure");
        }
        if (bool2 != null && bool2.booleanValue()) {
            str7 = AbstractC0008a.n(str7, "; HttpOnly");
        }
        if (str6 != null) {
            str7 = AbstractC0008a.o(str7, "; SameSite=", str6);
        }
        cookieManager.setCookie(str, AbstractC0008a.n(str7, ";"), new ValueCallback<Boolean>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.MyCookieManager.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Boolean bool3) {
                result.success(bool3);
            }
        });
        cookieManager.flush();
    }
}
