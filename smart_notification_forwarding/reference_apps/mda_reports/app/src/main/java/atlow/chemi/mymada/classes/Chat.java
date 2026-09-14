package atlow.chemi.mymada.classes;

/* loaded from: classes.dex */
public class Chat {
    private boolean WhatsApp;
    private String msg;
    private String sender;
    private String time;

    public Chat(String str, String str2, String str3, boolean z) {
        this.sender = str;
        this.msg = str2;
        this.time = str3;
        this.WhatsApp = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getSender() {
        return this.sender;
    }

    public String getTime() {
        return this.time;
    }

    public boolean isWhatsApp() {
        return this.WhatsApp;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setWhatsApp(boolean z) {
        this.WhatsApp = z;
    }
}
