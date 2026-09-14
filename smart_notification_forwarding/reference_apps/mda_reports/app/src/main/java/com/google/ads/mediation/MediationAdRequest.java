package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class MediationAdRequest {
    private final Date zzme;
    private final AdRequest.Gender zzmf;
    private final Set<String> zzmg;
    private final boolean zzmh;
    private final Location zzmi;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zzme = date;
        this.zzmf = gender;
        this.zzmg = set;
        this.zzmh = z;
        this.zzmi = location;
    }

    public Integer getAgeInYears() {
        if (this.zzme == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(this.zzme);
        Integer valueOf = Integer.valueOf(calendar2.get(1) - calendar.get(1));
        return (calendar2.get(2) < calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) < calendar.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzme;
    }

    public AdRequest.Gender getGender() {
        return this.zzmf;
    }

    public Set<String> getKeywords() {
        return this.zzmg;
    }

    public Location getLocation() {
        return this.zzmi;
    }

    public boolean isTesting() {
        return this.zzmh;
    }
}
