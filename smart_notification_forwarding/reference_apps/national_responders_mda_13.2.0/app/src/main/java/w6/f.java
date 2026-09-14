package w6;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.http.conn.util.InetAddressUtils;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    static String f15142a;

    public static String a(Context context) {
        try {
            return androidx.core.content.a.a(context, "android.permission.READ_PHONE_STATE") != 0 ? "" : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        if (l0.l0(f15142a)) {
            f15142a = c(true);
        }
        if (l0.l0(f15142a)) {
            f15142a = d();
        }
        return f15142a;
    }

    public static String c(boolean z10) {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String upperCase = inetAddress.getHostAddress().toUpperCase();
                        boolean isIPv4Address = InetAddressUtils.isIPv4Address(upperCase);
                        if (z10) {
                            if (isIPv4Address) {
                                return upperCase;
                            }
                        } else if (!isIPv4Address) {
                            int indexOf = upperCase.indexOf(37);
                            return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                        }
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        String formatIpAddress = Formatter.formatIpAddress(nextElement.hashCode());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("***** IP=");
                        sb2.append(formatIpAddress);
                        return formatIpAddress;
                    }
                }
            }
            return null;
        } catch (SocketException e10) {
            e10.toString();
            return null;
        }
    }
}
