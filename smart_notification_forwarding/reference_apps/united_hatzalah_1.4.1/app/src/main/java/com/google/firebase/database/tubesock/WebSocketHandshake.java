package com.google.firebase.database.tubesock;

import F0.AbstractC0008a;
import android.util.Base64;
import e0.a;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.tika.metadata.TikaCoreProperties;

/* loaded from: classes.dex */
class WebSocketHandshake {
    private static final String WEBSOCKET_VERSION = "13";
    private Map<String, String> extraHeaders;
    private String nonce;
    private String protocol;
    private URI url;

    public WebSocketHandshake(URI uri, String str, Map<String, String> map) {
        this.nonce = null;
        this.url = uri;
        this.protocol = str;
        this.extraHeaders = map;
        this.nonce = createNonce();
    }

    private String createNonce() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) rand(0, 255);
        }
        return Base64.encodeToString(bArr, 2);
    }

    private String generateHeader(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        for (String str2 : linkedHashMap.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(": ");
            str = AbstractC0008a.u(sb, linkedHashMap.get(str2), "\r\n");
        }
        return str;
    }

    private int rand(int i, int i3) {
        return (int) ((Math.random() * i3) + i);
    }

    public byte[] getHandshake() {
        String concat;
        String path = this.url.getPath();
        String query = this.url.getQuery();
        StringBuilder h2 = a.h(path);
        if (query == null) {
            concat = "";
        } else {
            concat = "?".concat(query);
        }
        h2.append(concat);
        String sb = h2.toString();
        String host = this.url.getHost();
        if (this.url.getPort() != -1) {
            StringBuilder i = a.i(host, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
            i.append(this.url.getPort());
            host = i.toString();
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", WEBSOCKET_VERSION);
        linkedHashMap.put("Sec-WebSocket-Key", this.nonce);
        String str = this.protocol;
        if (str != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", str);
        }
        Map<String, String> map = this.extraHeaders;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!linkedHashMap.containsKey(str2)) {
                    linkedHashMap.put(str2, this.extraHeaders.get(str2));
                }
            }
        }
        StringBuilder h3 = a.h(a.e("GET ", sb, " HTTP/1.1\r\n"));
        h3.append(generateHeader(linkedHashMap));
        byte[] bytes = AbstractC0008a.n(h3.toString(), "\r\n").getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public void verifyServerHandshakeHeaders(HashMap<String, String> hashMap) {
        if ("websocket".equals(hashMap.get("upgrade"))) {
            if ("upgrade".equals(hashMap.get("connection"))) {
                return;
            } else {
                throw new WebSocketException("connection failed: missing header field in server handshake: Connection");
            }
        }
        throw new WebSocketException("connection failed: missing header field in server handshake: Upgrade");
    }

    public void verifyServerStatusLine(String str) {
        int parseInt = Integer.parseInt(str.substring(9, 12));
        if (parseInt != 407) {
            if (parseInt != 404) {
                if (parseInt == 101) {
                    return;
                } else {
                    throw new WebSocketException(a.c(parseInt, "connection failed: unknown status code "));
                }
            }
            throw new WebSocketException("connection failed: 404 not found");
        }
        throw new WebSocketException("connection failed: proxy authentication not supported");
    }
}
