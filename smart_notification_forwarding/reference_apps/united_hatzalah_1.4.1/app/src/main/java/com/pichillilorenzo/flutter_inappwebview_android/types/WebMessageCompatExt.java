package com.pichillilorenzo.flutter_inappwebview_android.types;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import t0.d;
import t0.n;

/* loaded from: classes.dex */
public class WebMessageCompatExt {
    private Object data;
    private List<WebMessagePortCompatExt> ports;
    private int type;

    public WebMessageCompatExt(Object obj, int i, List<WebMessagePortCompatExt> list) {
        this.data = obj;
        this.type = i;
        this.ports = list;
    }

    public static WebMessageCompatExt fromMap(Map<String, Object> map) {
        ArrayList arrayList = null;
        if (map == null) {
            return null;
        }
        Object obj = map.get(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        Integer num = (Integer) map.get("type");
        List list = (List) map.get("ports");
        if (list != null && !list.isEmpty()) {
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(WebMessagePortCompatExt.fromMap((Map) it.next()));
            }
        }
        return new WebMessageCompatExt(obj, num.intValue(), arrayList);
    }

    public static WebMessageCompatExt fromMapWebMessageCompat(n nVar) {
        Object obj;
        if (d.a("WEB_MESSAGE_ARRAY_BUFFER") && nVar.f6381d == 1) {
            nVar.a(1);
            obj = nVar.f6380c;
            Objects.requireNonNull(obj);
        } else {
            nVar.a(0);
            obj = nVar.f6379b;
        }
        return new WebMessageCompatExt(obj, nVar.f6381d, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WebMessageCompatExt webMessageCompatExt = (WebMessageCompatExt) obj;
        if (this.type != webMessageCompatExt.type || !Objects.equals(this.data, webMessageCompatExt.data)) {
            return false;
        }
        return Objects.equals(this.ports, webMessageCompatExt.ports);
    }

    public Object getData() {
        return this.data;
    }

    public List<WebMessagePortCompatExt> getPorts() {
        return this.ports;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i;
        Object obj = this.data;
        int i3 = 0;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        int i4 = ((i * 31) + this.type) * 31;
        List<WebMessagePortCompatExt> list = this.ports;
        if (list != null) {
            i3 = list.hashCode();
        }
        return i4 + i3;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setPorts(List<WebMessagePortCompatExt> list) {
        this.ports = list;
    }

    public void setType(int i) {
        this.type = i;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, this.data);
        hashMap.put("type", Integer.valueOf(this.type));
        return hashMap;
    }

    public String toString() {
        return "WebMessageCompatExt{data=" + this.data + ", type=" + this.type + ", ports=" + this.ports + '}';
    }
}
