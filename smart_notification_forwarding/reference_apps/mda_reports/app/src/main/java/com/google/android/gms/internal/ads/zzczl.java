package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzczl {
    public final String zzaez;
    public final boolean zzblf;
    public final List<String> zzdbq;
    public final List<String> zzdbr;
    public final String zzdbw;
    public final boolean zzdcd;
    public final boolean zzdce;
    public final boolean zzdcf;
    public final String zzdcm;
    public final String zzdcx;
    public final String zzdcy;
    public final String zzdem;
    public final List<String> zzdkm;
    public final String zzdkp;
    public final String zzdks;

    @Nullable
    public final zzasd zzdky;
    public final List<String> zzdkz;
    public final List<String> zzdla;
    public final boolean zzdli;
    public final boolean zzdll;
    public final boolean zzdlm;
    public final boolean zzdmf;
    public final boolean zzega;
    public final String zzeif;
    public final int zzfdp;
    public final String zzfhk;
    public final int zzfjj;
    public final List<String> zzgli;
    public final int zzglj;
    public final List<String> zzglk;
    public final List<String> zzgll;
    public final List<String> zzglm;
    public final List<zzczk> zzgln;

    @Nullable
    public final zzczp zzglo;
    public final List<String> zzglp;
    public final List<zzczk> zzglq;
    public final JSONObject zzglr;
    public final zzatn zzgls;
    public final JSONObject zzglt;
    public final JSONObject zzglu;
    public final boolean zzglv;
    public final int zzglw;
    public final int zzglx;
    public final JSONObject zzgly;
    public final int zzglz;
    public final boolean zzgma;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x03b2. Please report as an issue. */
    public zzczl(JsonReader jsonReader) {
        List<String> list;
        char c;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<zzczk> emptyList10 = Collections.emptyList();
        List<String> emptyList11 = Collections.emptyList();
        List<zzczk> emptyList12 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jsonReader.beginObject();
        List<String> list2 = emptyList11;
        List<zzczk> list3 = emptyList12;
        JSONObject jSONObject5 = jSONObject;
        JSONObject jSONObject6 = jSONObject2;
        JSONObject jSONObject7 = jSONObject3;
        JSONObject jSONObject8 = jSONObject4;
        zzasd zzasdVar = null;
        zzczp zzczpVar = null;
        zzatn zzatnVar = null;
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i = -1;
        int i2 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int i3 = 0;
        boolean z10 = false;
        int i4 = -1;
        boolean z11 = false;
        List<String> list4 = emptyList8;
        List<String> list5 = emptyList9;
        List<zzczk> list6 = emptyList10;
        String str10 = str9;
        List<String> list7 = emptyList6;
        List<String> list8 = emptyList7;
        int i5 = 0;
        List<String> list9 = emptyList5;
        List<String> list10 = emptyList4;
        List<String> list11 = emptyList3;
        List<String> list12 = emptyList2;
        int i6 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str11 = nextName == null ? "" : nextName;
            List<zzczk> list13 = list6;
            switch (str11.hashCode()) {
                case -1980587809:
                    list = list5;
                    if (str11.equals("debug_signals")) {
                        c = 26;
                        break;
                    }
                    break;
                case -1965512151:
                    list = list5;
                    if (str11.equals("omid_settings")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case -1620470467:
                    list = list5;
                    if (str11.equals("backend_query_id")) {
                        c = '-';
                        break;
                    }
                    break;
                case -1440104884:
                    list = list5;
                    if (str11.equals("is_custom_close_blocked")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1439500848:
                    list = list5;
                    if (str11.equals("orientation")) {
                        c = Typography.quote;
                        break;
                    }
                    break;
                case -1428969291:
                    list = list5;
                    if (str11.equals("enable_omid")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case -1403779768:
                    list = list5;
                    if (str11.equals("showable_impression_type")) {
                        c = ')';
                        break;
                    }
                    break;
                case -1360811658:
                    list = list5;
                    if (str11.equals("ad_sizes")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1306015996:
                    list = list5;
                    if (str11.equals("adapters")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1289032093:
                    list = list5;
                    if (str11.equals("extras")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1234181075:
                    list = list5;
                    if (str11.equals("allow_pub_rendered_attribution")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1181000426:
                    list = list5;
                    if (str11.equals("is_augmented_reality_ad")) {
                        c = '*';
                        break;
                    }
                    break;
                case -1152230954:
                    list = list5;
                    if (str11.equals("ad_type")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1146534047:
                    list = list5;
                    if (str11.equals("is_scroll_aware")) {
                        c = '(';
                        break;
                    }
                    break;
                case -1115838944:
                    list = list5;
                    if (str11.equals("fill_urls")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -1081936678:
                    list = list5;
                    if (str11.equals("allocation_id")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1078050970:
                    list = list5;
                    if (str11.equals("video_complete_urls")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1051269058:
                    list = list5;
                    if (str11.equals("active_view")) {
                        c = 23;
                        break;
                    }
                    break;
                case -982608540:
                    list = list5;
                    if (str11.equals("valid_from_timestamp")) {
                        c = 11;
                        break;
                    }
                    break;
                case -776859333:
                    list = list5;
                    if (str11.equals("click_urls")) {
                        c = 2;
                        break;
                    }
                    break;
                case -544216775:
                    list = list5;
                    if (str11.equals("safe_browsing")) {
                        c = 24;
                        break;
                    }
                    break;
                case -437057161:
                    list = list5;
                    if (str11.equals("imp_urls")) {
                        c = 3;
                        break;
                    }
                    break;
                case -404326515:
                    list = list5;
                    if (str11.equals("render_timeout_ms")) {
                        c = '#';
                        break;
                    }
                    break;
                case -397704715:
                    list = list5;
                    if (str11.equals("ad_close_time_ms")) {
                        c = '+';
                        break;
                    }
                    break;
                case -213424028:
                    list = list5;
                    if (str11.equals("watermark")) {
                        c = ',';
                        break;
                    }
                    break;
                case -29338502:
                    list = list5;
                    if (str11.equals("allow_custom_click_gesture")) {
                        c = 30;
                        break;
                    }
                    break;
                case 3107:
                    list = list5;
                    if (str11.equals("ad")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3355:
                    list = list5;
                    if (str11.equals("id")) {
                        c = 21;
                        break;
                    }
                    break;
                case 3076010:
                    list = list5;
                    if (str11.equals("data")) {
                        c = 20;
                        break;
                    }
                    break;
                case 63195984:
                    list = list5;
                    if (str11.equals("render_test_label")) {
                        c = 31;
                        break;
                    }
                    break;
                case 107433883:
                    list = list5;
                    if (str11.equals("qdata")) {
                        c = 22;
                        break;
                    }
                    break;
                case 230323073:
                    list = list5;
                    if (str11.equals("ad_load_urls")) {
                        c = 4;
                        break;
                    }
                    break;
                case 418392395:
                    list = list5;
                    if (str11.equals("is_closable_area_disabled")) {
                        c = '!';
                        break;
                    }
                    break;
                case 597473788:
                    list = list5;
                    if (str11.equals("debug_dialog_string")) {
                        c = 25;
                        break;
                    }
                    break;
                case 673261304:
                    list = list5;
                    if (str11.equals("reward_granted_urls")) {
                        c = 7;
                        break;
                    }
                    break;
                case 754887508:
                    list = list5;
                    if (str11.equals("container_sizes")) {
                        c = 15;
                        break;
                    }
                    break;
                case 791122864:
                    list = list5;
                    if (str11.equals("impression_type")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1010584092:
                    list = list5;
                    if (str11.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1100650276:
                    list = list5;
                    if (str11.equals("rewards")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1321720943:
                    list = list5;
                    if (str11.equals("allow_pub_owned_ad_view")) {
                        c = 29;
                        break;
                    }
                    break;
                case 1637553475:
                    list = list5;
                    if (str11.equals("bid_response")) {
                        c = '%';
                        break;
                    }
                    break;
                case 1638957285:
                    list = list5;
                    if (str11.equals("video_start_urls")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1688341040:
                    list = list5;
                    if (str11.equals("video_reward_urls")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1799285870:
                    list = list5;
                    if (str11.equals("use_third_party_container_height")) {
                        c = '.';
                        break;
                    }
                    break;
                case 1839650832:
                    list = list5;
                    if (str11.equals("renderers")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1875425491:
                    list = list5;
                    if (str11.equals("is_analytics_logging_enabled")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 2072888499:
                    list = list5;
                    if (str11.equals("manual_tracking_urls")) {
                        c = 14;
                        break;
                    }
                    break;
                default:
                    list = list5;
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    emptyList = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 1:
                    String nextString = jsonReader.nextString();
                    i6 = "banner".equals(nextString) ? 1 : "interstitial".equals(nextString) ? 2 : "native_express".equals(nextString) ? 3 : "native".equals(nextString) ? 4 : "rewarded".equals(nextString) ? 5 : 0;
                    list6 = list13;
                    list5 = list;
                    break;
                case 2:
                    list12 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 3:
                    list11 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 4:
                    list10 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 5:
                    i5 = jsonReader.nextInt();
                    if (i5 != 0 && i5 != 1) {
                        i5 = 0;
                    }
                    list6 = list13;
                    list5 = list;
                    break;
                case 6:
                    list9 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 7:
                    zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case '\b':
                    list7 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case '\t':
                    list8 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case '\n':
                    str10 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case 11:
                    str = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case '\f':
                    zzasdVar = zzasd.zza(zzaxs.zzd(jsonReader));
                    list6 = list13;
                    list5 = list;
                    break;
                case '\r':
                    list4 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 14:
                    list5 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    break;
                case 15:
                    list6 = zzczk.a(jsonReader);
                    list5 = list;
                    break;
                case 16:
                    zzczpVar = new zzczp(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 17:
                    list3 = zzczk.a(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 18:
                    list2 = zzaxs.zza(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 19:
                    str2 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case 20:
                    jSONObject5 = zzaxs.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 21:
                    str3 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case 22:
                    str4 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case 23:
                    str5 = zzaxs.zzc(jsonReader).toString();
                    list6 = list13;
                    list5 = list;
                    break;
                case 24:
                    zzatnVar = zzatn.zzg(zzaxs.zzc(jsonReader));
                    list6 = list13;
                    list5 = list;
                    break;
                case 25:
                    str6 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case 26:
                    jSONObject6 = zzaxs.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 27:
                    jSONObject7 = zzaxs.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case 28:
                    z = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case 29:
                    z2 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case 30:
                    z3 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case 31:
                    z4 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case ' ':
                    z5 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case '!':
                    z6 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case '\"':
                    String nextString2 = jsonReader.nextString();
                    if ("landscape".equalsIgnoreCase(nextString2)) {
                        com.google.android.gms.ads.internal.zzq.zzks();
                        i = 6;
                    } else if ("portrait".equalsIgnoreCase(nextString2)) {
                        com.google.android.gms.ads.internal.zzq.zzks();
                        i = 7;
                    } else {
                        i = -1;
                    }
                    list6 = list13;
                    list5 = list;
                    break;
                case '#':
                    i2 = jsonReader.nextInt();
                    list6 = list13;
                    list5 = list;
                    break;
                case '$':
                    z7 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case '%':
                    str7 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case '&':
                    jSONObject8 = zzaxs.zzc(jsonReader);
                    list6 = list13;
                    list5 = list;
                    break;
                case '\'':
                    z8 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case '(':
                    z9 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case ')':
                    i3 = jsonReader.nextInt();
                    list6 = list13;
                    list5 = list;
                    break;
                case '*':
                    z10 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                case '+':
                    i4 = jsonReader.nextInt();
                    list6 = list13;
                    list5 = list;
                    break;
                case ',':
                    str8 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case '-':
                    str9 = jsonReader.nextString();
                    list6 = list13;
                    list5 = list;
                    break;
                case '.':
                    z11 = jsonReader.nextBoolean();
                    list6 = list13;
                    list5 = list;
                    break;
                default:
                    jsonReader.skipValue();
                    list6 = list13;
                    list5 = list;
                    break;
            }
        }
        jsonReader.endObject();
        this.zzgli = emptyList;
        this.zzfjj = i6;
        this.zzdbq = list12;
        this.zzdbr = list11;
        this.zzglk = list10;
        this.zzglj = i5;
        this.zzdkz = list9;
        this.zzdla = list7;
        this.zzgll = list8;
        this.zzdcx = str10;
        this.zzdcy = str;
        this.zzdky = zzasdVar;
        this.zzglm = list4;
        this.zzdkm = list5;
        this.zzgln = list6;
        this.zzglo = zzczpVar;
        this.zzglp = list2;
        this.zzglq = list3;
        this.zzdcm = str2;
        this.zzglr = jSONObject5;
        this.zzaez = str3;
        this.zzdbw = str4;
        this.zzdks = str5;
        this.zzgls = zzatnVar;
        this.zzdkp = str6;
        this.zzglt = jSONObject6;
        this.zzglu = jSONObject7;
        this.zzdcd = z;
        this.zzdce = z2;
        this.zzdcf = z3;
        this.zzdmf = z4;
        this.zzglv = z5;
        this.zzblf = z6;
        this.zzglw = i;
        this.zzglx = i2;
        this.zzdli = z7;
        this.zzeif = str7;
        this.zzgly = jSONObject8;
        this.zzdll = z8;
        this.zzdlm = z9;
        this.zzglz = i3;
        this.zzega = z10;
        this.zzdem = str8;
        this.zzfdp = i4;
        this.zzfhk = str9;
        this.zzgma = z11;
    }
}
