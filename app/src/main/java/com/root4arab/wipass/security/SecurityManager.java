package com.root4arab.wipass.security;

import a.bs;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Debug;
import androidx.core.os.EnvironmentCompat;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class SecurityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f437a;

    public SecurityManager(Context context) {
        this.f437a = context.getApplicationContext();
    }

    private String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private boolean checkEmulatorBuild() {
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || str.contains("test-keys")) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        String str3 = Build.HARDWARE;
        if (str3.contains("goldfish") || str3.contains("ranchu") || str3.contains("vbox86")) {
            return true;
        }
        String str4 = Build.PRODUCT;
        return str4.contains("sdk_x86") || str4.contains("vbox86p") || str4.contains("emulator");
    }

    private boolean checkEmulatorFiles() {
        String[] strArr = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd"};
        for (int i = 0; i < 4; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkExternalStoragePaths() {
        String[] strArr = {"/data/local/tmp/xposed.prop", "/data/local/tmp/frida-server", "/data/local/xposed/bin/xposed.jar", "/system/framework/XposedBridge.jar", "/data/app/de.robv.android.xposed.installer", "/data/app/com.saurik.substrate"};
        for (int i = 0; i < 6; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRootMethod1() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/system/xbin/daemonsu", "/system/etc/init.d/99SuperSUDaemon", "/system/bin/.ext/.su", "/system/usr/we-need-root/su-backup", "/system/xbin/mu"};
        for (int i = 0; i < 15; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRootMethod2() {
        try {
            return new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"}).getInputStream())).readLine() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean checkRootMethod3() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private boolean checkRootMethod4() {
        String[] strArr = {"com.noshufou.android.su", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.topjohnwu.magisk", "com.kingroot.kinguser"};
        PackageManager packageManager = this.f437a.getPackageManager();
        for (int i = 0; i < 5; i++) {
            try {
                packageManager.getPackageInfo(strArr[i], 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    private boolean checkRootMethod5() {
        try {
            String line = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"su", "-c", "id"}).getInputStream())).readLine();
            if (line != null) {
                return line.toLowerCase().contains("uid=0");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean constantTimeCompare(String str, String str2) {
        if (str == null || str2 == null || str.length() != str2.length()) {
            (str != null ? Integer.valueOf(str.length()) : "null").toString();
            (str2 != null ? Integer.valueOf(str2.length()) : "null").toString();
            return false;
        }
        int iCharAt = 0;
        for (int i = 0; i < str.length(); i++) {
            iCharAt |= str.charAt(i) ^ str2.charAt(i);
        }
        return iCharAt == 0;
    }

    private String generateSignatureHash(Signature signature) {
        try {
            return bytesToHex(MessageDigest.getInstance("SHA-256").digest(signature.toByteArray())).toUpperCase();
        } catch (Exception unused) {
            return null;
        }
    }

    private String getExpectedSignature() {
        try {
            String str = (String) bs.class.getField("EXPECTED_SIGNATURE").get(null);
            if (str != null) {
                return str.replace(":", "").toUpperCase();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean checkSignature() {
        try {
            String currentSignature = getCurrentSignature();
            String expectedSignature = getExpectedSignature();
            if (currentSignature == null || expectedSignature == null) {
                return false;
            }
            return constantTimeCompare(currentSignature, expectedSignature);
        } catch (Exception unused) {
            return false;
        }
    }

    public String getCurrentSignature() {
        try {
            int i = Build.VERSION.SDK_INT;
            Context context = this.f437a;
            if (i >= 28) {
                Signature[] apkContentsSigners = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo.getApkContentsSigners();
                if (apkContentsSigners == null || apkContentsSigners.length <= 0) {
                    return null;
                }
                return generateSignatureHash(apkContentsSigners[0]);
            }
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return null;
            }
            return generateSignatureHash(signatureArr[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isDebuggable() {
        return (this.f437a.getApplicationInfo().flags & 2) != 0;
    }

    public boolean isDebuggerConnected() {
        return Debug.isDebuggerConnected();
    }

    public boolean isEmulator() {
        return checkEmulatorBuild() || checkEmulatorFiles();
    }

    public boolean isRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3() || checkRootMethod4() || checkRootMethod5();
    }

    public boolean isTampered() {
        return checkExternalStoragePaths();
    }

    public boolean performSecurityCheck() {
        return (!checkSignature() || isDebuggable() || isDebuggerConnected() || isRooted() || isEmulator() || isTampered()) ? false : true;
    }
}
