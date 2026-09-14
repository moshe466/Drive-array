package com.pichillilorenzo.flutter_inappwebview_android.types;

import F0.AbstractC0008a;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DownloadStartRequest {
    private String contentDisposition;
    private long contentLength;
    private String mimeType;
    private String suggestedFilename;
    private String textEncodingName;
    private String url;
    private String userAgent;

    public DownloadStartRequest(String str, String str2, String str3, String str4, long j2, String str5, String str6) {
        this.url = str;
        this.userAgent = str2;
        this.contentDisposition = str3;
        this.mimeType = str4;
        this.contentLength = j2;
        this.suggestedFilename = str5;
        this.textEncodingName = str6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DownloadStartRequest downloadStartRequest = (DownloadStartRequest) obj;
            if (this.contentLength != downloadStartRequest.contentLength || !this.url.equals(downloadStartRequest.url) || !this.userAgent.equals(downloadStartRequest.userAgent) || !this.contentDisposition.equals(downloadStartRequest.contentDisposition) || !this.mimeType.equals(downloadStartRequest.mimeType)) {
                return false;
            }
            String str = this.suggestedFilename;
            if (str == null ? downloadStartRequest.suggestedFilename != null : !str.equals(downloadStartRequest.suggestedFilename)) {
                return false;
            }
            String str2 = this.textEncodingName;
            String str3 = downloadStartRequest.textEncodingName;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getSuggestedFilename() {
        return this.suggestedFilename;
    }

    public String getTextEncodingName() {
        return this.textEncodingName;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public int hashCode() {
        int i;
        int g3 = AbstractC0008a.g(this.mimeType, AbstractC0008a.g(this.contentDisposition, AbstractC0008a.g(this.userAgent, this.url.hashCode() * 31, 31), 31), 31);
        long j2 = this.contentLength;
        int i3 = (g3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.suggestedFilename;
        int i4 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i5 = (i3 + i) * 31;
        String str2 = this.textEncodingName;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return i5 + i4;
    }

    public void setContentDisposition(String str) {
        this.contentDisposition = str;
    }

    public void setContentLength(long j2) {
        this.contentLength = j2;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSuggestedFilename(String str) {
        this.suggestedFilename = str;
    }

    public void setTextEncodingName(String str) {
        this.textEncodingName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(ImagesContract.URL, this.url);
        hashMap.put("userAgent", this.userAgent);
        hashMap.put("contentDisposition", this.contentDisposition);
        hashMap.put("mimeType", this.mimeType);
        hashMap.put("contentLength", Long.valueOf(this.contentLength));
        hashMap.put("suggestedFilename", this.suggestedFilename);
        hashMap.put("textEncodingName", this.textEncodingName);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DownloadStartRequest{url='");
        sb.append(this.url);
        sb.append("', userAgent='");
        sb.append(this.userAgent);
        sb.append("', contentDisposition='");
        sb.append(this.contentDisposition);
        sb.append("', mimeType='");
        sb.append(this.mimeType);
        sb.append("', contentLength=");
        sb.append(this.contentLength);
        sb.append(", suggestedFilename='");
        sb.append(this.suggestedFilename);
        sb.append("', textEncodingName='");
        return AbstractC0008a.u(sb, this.textEncodingName, "'}");
    }
}
