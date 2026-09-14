package com.groboot.mdaemergency.models;

import com.groboot.mdaemergency.enums.b;
import w6.l0;

/* loaded from: classes.dex */
public class AppUser {
    public static final int TYPE_KONAN = 1;
    public static final int TYPE_NO_KONAN = 0;
    private String AccessToken;
    private String AppVersion;
    private String Code;
    private String DateOfBirth;
    private String DeviceID;
    private String DeviceName;
    private String ID;
    private String IP;
    private Location Location;
    private String OSVersion;
    private String Phone;
    private String PttPassword;
    private String PttUser;
    private String PushID;
    private String SMSCode;
    private String TempToken;
    private int Type;
    private Location differentLocation;
    private Location homeLocation;
    private boolean isBike;
    private boolean isGPS;
    private boolean isVehicle;
    private String registrationNumber;
    private String vehicleCode;
    private Location workLocation;

    /* loaded from: classes.dex */
    public static class Location {
        private int accuracy;
        private String address;
        private double lat;
        private double lon;
        private int status;
        private b statusAvailability;

        public Location() {
        }

        public Location(android.location.Location location) {
            this.lat = location.getLatitude();
            this.lon = location.getLongitude();
        }

        public int getAccuracy() {
            return this.accuracy;
        }

        public String getAddress() {
            String str = this.address;
            return str != null ? str : "";
        }

        public double getLat() {
            return this.lat;
        }

        public double getLon() {
            return this.lon;
        }

        public int getStatus() {
            return this.status;
        }

        public b getStatusAvailability() {
            if (this.statusAvailability == null) {
                setStatusAvailability(b.AVAILABLE);
            }
            return this.statusAvailability;
        }

        public boolean hasValue() {
            return !l0.l0(this.address);
        }

        public void setAccuracy(int i10) {
            this.accuracy = i10;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setLat(double d10) {
            this.lat = d10;
        }

        public void setLon(double d10) {
            this.lon = d10;
        }

        public void setStatus(int i10) {
            this.status = i10;
        }

        public void setStatusAvailability(b bVar) {
            this.statusAvailability = bVar;
        }

        public android.location.Location toAndroidLocation() {
            android.location.Location location = new android.location.Location("gps");
            location.setLatitude(getLat());
            location.setLongitude(getLon());
            location.setAccuracy(getAccuracy());
            return location;
        }
    }

    /* loaded from: classes.dex */
    public @interface Type {
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7716a;

        static {
            int[] iArr = new int[b.values().length];
            f7716a = iArr;
            try {
                iArr[b.DIFFERENT_ADDRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum eTrackingType {
        NONE,
        FULL,
        SLEEPY,
        SHABAT
    }

    public String getAccessToken() {
        return this.AccessToken;
    }

    public String getAppVersion() {
        return this.AppVersion;
    }

    public String getCode() {
        return this.Code;
    }

    public String getDateOfBirth() {
        return this.DateOfBirth;
    }

    public String getDeviceID() {
        return this.DeviceID;
    }

    public String getDeviceName() {
        return this.DeviceName;
    }

    public int getDeviceType() {
        return 1;
    }

    public Location getDifferentLocation() {
        return this.differentLocation;
    }

    public Location getHomeLocation() {
        return this.homeLocation;
    }

    public String getID() {
        return this.ID;
    }

    public String getIP() {
        return this.IP;
    }

    public boolean getIsBike() {
        return this.isBike;
    }

    public boolean getIsVehicle() {
        return this.isVehicle;
    }

    public Location getLocation() {
        if (this.Location == null) {
            this.Location = new Location();
        }
        return this.Location;
    }

    public Location getLocation(b bVar) {
        if (a.f7716a[bVar.ordinal()] != 1) {
            return null;
        }
        return getDifferentLocation();
    }

    public String getOSVersion() {
        return this.OSVersion;
    }

    public String getPhone() {
        return this.Phone;
    }

    public String getPttUser() {
        return this.PttUser;
    }

    public String getPushID() {
        return this.PushID;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getSMSCode() {
        return this.SMSCode;
    }

    public String getTempToken() {
        return this.TempToken;
    }

    @Type
    public int getType() {
        return this.Type;
    }

    public String getVehicleCode() {
        return this.vehicleCode;
    }

    public Location getWorkLocation() {
        return this.workLocation;
    }

    public boolean hasPushID() {
        String str = this.PushID;
        return str != null && str.length() > 0;
    }

    public boolean isGPS() {
        return this.isGPS;
    }

    public boolean isKonan() {
        String str = this.Code;
        return str != null && str.length() > 0;
    }

    public void setAccessToken(String str) {
        this.AccessToken = str;
    }

    public void setAppVersion(String str) {
        this.AppVersion = str;
    }

    public void setCode(String str) {
        this.Code = str;
    }

    public void setDateOfBirth(String str) {
        this.DateOfBirth = str;
    }

    public void setDeviceID(String str) {
        this.DeviceID = str;
    }

    public void setDeviceName(String str) {
        this.DeviceName = str;
    }

    public void setDifferentLocation(Location location) {
        this.differentLocation = location;
    }

    public void setHomeLocation(Location location) {
        this.homeLocation = location;
    }

    public void setID(String str) {
        this.ID = str;
    }

    public void setIP(String str) {
        this.IP = str;
    }

    public void setIsBike(boolean z10) {
        this.isBike = z10;
    }

    public void setIsGPS(boolean z10) {
        this.isGPS = z10;
    }

    public void setIsVehicle(boolean z10) {
        this.isVehicle = z10;
    }

    public void setLocation(b bVar, Location location) {
        if (a.f7716a[bVar.ordinal()] != 1) {
            return;
        }
        setDifferentLocation(location);
    }

    public void setLocation(Location location) {
        this.Location = location;
    }

    public void setOSVersion(String str) {
        this.OSVersion = str;
    }

    public void setPhone(String str) {
        this.Phone = str;
    }

    public void setPttPassword(String str) {
        this.PttPassword = str;
    }

    public void setPttUser(String str) {
        this.PttUser = str;
    }

    public void setPushID(String str) {
        this.PushID = str;
    }

    public void setRegistrationNumber(String str) {
        this.registrationNumber = str;
    }

    public void setSMSCode(String str) {
        this.SMSCode = str;
    }

    public void setTempToken(String str) {
        this.TempToken = str;
    }

    public void setType(@Type int i10) {
        this.Type = i10;
    }

    public void setVehicleCode(String str) {
        this.vehicleCode = str;
    }

    public void setWorkLocation(Location location) {
        this.workLocation = location;
    }
}
