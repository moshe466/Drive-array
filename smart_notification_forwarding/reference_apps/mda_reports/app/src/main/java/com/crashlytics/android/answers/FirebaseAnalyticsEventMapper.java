package com.crashlytics.android.answers;

import android.os.Bundle;
import com.crashlytics.android.answers.SessionEvent;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class FirebaseAnalyticsEventMapper {
    private static final Set<String> EVENT_NAMES = new HashSet(Arrays.asList("app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"));
    private static final String FIREBASE_LEVEL_NAME = "level_name";
    private static final String FIREBASE_METHOD = "method";
    private static final String FIREBASE_RATING = "rating";
    private static final String FIREBASE_SUCCESS = "success";

    private String mapAttribute(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_parameter";
        }
        String replaceAll = str.replaceAll("[^\\p{Alnum}_]+", EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        if (replaceAll.startsWith("ga_") || replaceAll.startsWith("google_") || replaceAll.startsWith("firebase_") || !Character.isLetter(replaceAll.charAt(0))) {
            replaceAll = "fabric_" + replaceAll;
        }
        return replaceAll.length() > 40 ? replaceAll.substring(0, 40) : replaceAll;
    }

    private Integer mapBooleanValue(String str) {
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str.equals("true") ? 1 : 0);
    }

    private void mapCustomEventAttributes(Bundle bundle, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String mapAttribute = mapAttribute(entry.getKey());
            if (value instanceof String) {
                bundle.putString(mapAttribute, entry.getValue().toString());
            } else if (value instanceof Double) {
                bundle.putDouble(mapAttribute, ((Double) entry.getValue()).doubleValue());
            } else if (value instanceof Long) {
                bundle.putLong(mapAttribute, ((Long) entry.getValue()).longValue());
            } else if (value instanceof Integer) {
                bundle.putInt(mapAttribute, ((Integer) entry.getValue()).intValue());
            }
        }
    }

    private String mapCustomEventName(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_event";
        }
        if (EVENT_NAMES.contains(str)) {
            return "fabric_" + str;
        }
        String replaceAll = str.replaceAll("[^\\p{Alnum}_]+", EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        if (replaceAll.startsWith("ga_") || replaceAll.startsWith("google_") || replaceAll.startsWith("firebase_") || !Character.isLetter(replaceAll.charAt(0))) {
            replaceAll = "fabric_" + replaceAll;
        }
        return replaceAll.length() > 40 ? replaceAll.substring(0, 40) : replaceAll;
    }

    private Double mapDouble(Object obj) {
        String valueOf = String.valueOf(obj);
        if (valueOf == null) {
            return null;
        }
        return Double.valueOf(valueOf);
    }

    private Bundle mapPredefinedEvent(SessionEvent sessionEvent) {
        String str;
        String str2;
        Object obj;
        Bundle bundle = new Bundle();
        if (!"purchase".equals(sessionEvent.predefinedType)) {
            if ("addToCart".equals(sessionEvent.predefinedType)) {
                putString(bundle, FirebaseAnalytics.Param.ITEM_ID, (String) sessionEvent.predefinedAttributes.get("itemId"));
                putString(bundle, FirebaseAnalytics.Param.ITEM_NAME, (String) sessionEvent.predefinedAttributes.get("itemName"));
                putString(bundle, FirebaseAnalytics.Param.ITEM_CATEGORY, (String) sessionEvent.predefinedAttributes.get("itemType"));
                putDouble(bundle, FirebaseAnalytics.Param.PRICE, mapPriceValue(sessionEvent.predefinedAttributes.get("itemPrice")));
                putDouble(bundle, "value", mapPriceValue(sessionEvent.predefinedAttributes.get("itemPrice")));
                putString(bundle, FirebaseAnalytics.Param.CURRENCY, (String) sessionEvent.predefinedAttributes.get(FirebaseAnalytics.Param.CURRENCY));
                bundle.putLong(FirebaseAnalytics.Param.QUANTITY, 1L);
            } else if ("startCheckout".equals(sessionEvent.predefinedType)) {
                putLong(bundle, FirebaseAnalytics.Param.QUANTITY, Long.valueOf(((Integer) sessionEvent.predefinedAttributes.get("itemCount")).intValue()));
                obj = sessionEvent.predefinedAttributes.get("totalPrice");
            } else {
                if (!"contentView".equals(sessionEvent.predefinedType)) {
                    if (FirebaseAnalytics.Event.SEARCH.equals(sessionEvent.predefinedType)) {
                        str = (String) sessionEvent.predefinedAttributes.get(SearchIntents.EXTRA_QUERY);
                        str2 = FirebaseAnalytics.Param.SEARCH_TERM;
                    } else if (FirebaseAnalytics.Event.SHARE.equals(sessionEvent.predefinedType)) {
                        putString(bundle, "method", (String) sessionEvent.predefinedAttributes.get("method"));
                    } else if (FIREBASE_RATING.equals(sessionEvent.predefinedType)) {
                        putString(bundle, FIREBASE_RATING, String.valueOf(sessionEvent.predefinedAttributes.get(FIREBASE_RATING)));
                    } else if ("signUp".equals(sessionEvent.predefinedType) || FirebaseAnalytics.Event.LOGIN.equals(sessionEvent.predefinedType) || "invite".equals(sessionEvent.predefinedType)) {
                        putString(bundle, "method", (String) sessionEvent.predefinedAttributes.get("method"));
                    } else if ("levelStart".equals(sessionEvent.predefinedType)) {
                        str = (String) sessionEvent.predefinedAttributes.get("levelName");
                        str2 = "level_name";
                    } else if ("levelEnd".equals(sessionEvent.predefinedType)) {
                        putDouble(bundle, FirebaseAnalytics.Param.SCORE, mapDouble(sessionEvent.predefinedAttributes.get(FirebaseAnalytics.Param.SCORE)));
                        putString(bundle, "level_name", (String) sessionEvent.predefinedAttributes.get("levelName"));
                        putInt(bundle, "success", mapBooleanValue((String) sessionEvent.predefinedAttributes.get("success")));
                    }
                    putString(bundle, str2, str);
                }
                putString(bundle, FirebaseAnalytics.Param.CONTENT_TYPE, (String) sessionEvent.predefinedAttributes.get("contentType"));
                putString(bundle, FirebaseAnalytics.Param.ITEM_ID, (String) sessionEvent.predefinedAttributes.get("contentId"));
                putString(bundle, FirebaseAnalytics.Param.ITEM_NAME, (String) sessionEvent.predefinedAttributes.get("contentName"));
            }
            mapCustomEventAttributes(bundle, sessionEvent.customAttributes);
            return bundle;
        }
        putString(bundle, FirebaseAnalytics.Param.ITEM_ID, (String) sessionEvent.predefinedAttributes.get("itemId"));
        putString(bundle, FirebaseAnalytics.Param.ITEM_NAME, (String) sessionEvent.predefinedAttributes.get("itemName"));
        putString(bundle, FirebaseAnalytics.Param.ITEM_CATEGORY, (String) sessionEvent.predefinedAttributes.get("itemType"));
        obj = sessionEvent.predefinedAttributes.get("itemPrice");
        putDouble(bundle, "value", mapPriceValue(obj));
        putString(bundle, FirebaseAnalytics.Param.CURRENCY, (String) sessionEvent.predefinedAttributes.get(FirebaseAnalytics.Param.CURRENCY));
        mapCustomEventAttributes(bundle, sessionEvent.customAttributes);
        return bundle;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        if (r11.equals("purchase") != false) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String mapPredefinedEventName(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.FirebaseAnalyticsEventMapper.mapPredefinedEventName(java.lang.String, boolean):java.lang.String");
    }

    private Double mapPriceValue(Object obj) {
        Long l = (Long) obj;
        if (l == null) {
            return null;
        }
        return Double.valueOf(new BigDecimal(l.longValue()).divide(AddToCartEvent.d).doubleValue());
    }

    private void putDouble(Bundle bundle, String str, Double d) {
        Double mapDouble = mapDouble(d);
        if (mapDouble == null) {
            return;
        }
        bundle.putDouble(str, mapDouble.doubleValue());
    }

    private void putInt(Bundle bundle, String str, Integer num) {
        if (num == null) {
            return;
        }
        bundle.putInt(str, num.intValue());
    }

    private void putLong(Bundle bundle, String str, Long l) {
        if (l == null) {
            return;
        }
        bundle.putLong(str, l.longValue());
    }

    private void putString(Bundle bundle, String str, String str2) {
        if (str2 == null) {
            return;
        }
        bundle.putString(str, str2);
    }

    public FirebaseAnalyticsEvent mapEvent(SessionEvent sessionEvent) {
        Bundle bundle;
        String mapCustomEventName;
        boolean z = SessionEvent.Type.CUSTOM.equals(sessionEvent.type) && sessionEvent.customType != null;
        boolean z2 = SessionEvent.Type.PREDEFINED.equals(sessionEvent.type) && sessionEvent.predefinedType != null;
        if (!z && !z2) {
            return null;
        }
        if (z2) {
            bundle = mapPredefinedEvent(sessionEvent);
        } else {
            bundle = new Bundle();
            Map<String, Object> map = sessionEvent.customAttributes;
            if (map != null) {
                mapCustomEventAttributes(bundle, map);
            }
        }
        if (z2) {
            String str = (String) sessionEvent.predefinedAttributes.get("success");
            mapCustomEventName = mapPredefinedEventName(sessionEvent.predefinedType, (str == null || Boolean.parseBoolean(str)) ? false : true);
        } else {
            mapCustomEventName = mapCustomEventName(sessionEvent.customType);
        }
        Fabric.getLogger().d(Answers.TAG, "Logging event into firebase...");
        return new FirebaseAnalyticsEvent(mapCustomEventName, bundle);
    }
}
