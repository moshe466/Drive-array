package com.groboot.mdaemergency.ui.lockpattern.widget;

import com.andrognito.patternlockview.PatternLockView;
import com.groboot.mdaemergency.ui.lockpattern.widget.LockPatternView;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {
    public static String a(List<PatternLockView.f> list) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(b(list).getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            return String.format(null, "%0" + (digest.length * 2) + "x", new BigInteger(1, digest)).toLowerCase();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String b(List<PatternLockView.f> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                if (list.size() > i10) {
                    PatternLockView.f fVar = list.get(i10);
                    bArr[i10] = (byte) ((fVar.e() * 3) + fVar.d());
                }
            }
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static List<LockPatternView.b> c(String str) {
        ArrayList a10 = s6.a.a();
        try {
            for (byte b10 : str.getBytes("UTF-8")) {
                a10.add(LockPatternView.b.d(b10 / 3, b10 % 3));
            }
        } catch (UnsupportedEncodingException unused) {
        }
        return a10;
    }
}
