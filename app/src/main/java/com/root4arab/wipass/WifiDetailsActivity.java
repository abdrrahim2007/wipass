package com.root4arab.wipass;

import a.iz;
import a.kz;
import a.ow;
import a.pt;
import a.wu;
import a.wv;
import a.ww;
import a.wx;
import a.wy;
import a.xb;
import android.content.ClipData;
import android.net.Uri;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public class WifiDetailsActivity extends AppCompatActivity {
    public static final /* synthetic */ int ag = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f434a;
    public Handler aa;
    public xb ab;
    public ow ad;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public MaterialToolbar g;
    public MaterialButton h;
    public LinearLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public MaterialCardView l;
    public MaterialCardView m;
    public ImageView n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public WifiManager s;
    public ConnectivityManager t;
    public AlertDialog u;
    public AlertDialog v;
    public AlertDialog w;
    public String[] x;
    public Handler z;
    public int y = 0;
    public boolean ac = false;
    public boolean ae = false;
    public int af = 0;
    public List<String> importedPasswords = new ArrayList<>();
    public TextView txtImportStatus;
    public TextView progressMessageTextView;

    public static String j(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public final void h(final String str) {
        this.ac = false;
        n();
        try {
            AlertDialog alertDialog = this.u;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.u.dismiss();
            }
        } catch (Exception unused) {
        }
        String str2 = this.p;
        if (str2 != null) {
            try {
                if (!str2.isEmpty() && !str.isEmpty()) {
                    getSharedPreferences("wifi_passwords", 0).edit().putString("pw_" + str2.toLowerCase(), str).apply();
                }
            } catch (Exception unused2) {
            }
        }
        try {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.popup_success, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.passwordText);
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.btnCopyPassword);
            final LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.copySuccessIndicator);
            textView.setText(str);
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setView(viewInflate).setCancelable(false).create();
            if (alertDialogCreate.getWindow() != null) {
                alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: a.wz
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i = WifiDetailsActivity.ag;
                    final WifiDetailsActivity wifiDetailsActivity = this.f360a;
                    wifiDetailsActivity.i("كلمة المرور", str);
                    final LinearLayout linearLayout2 = linearLayout;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                    }
                    Handler handler = new Handler(Looper.getMainLooper());
                    final AlertDialog alertDialog2 = alertDialogCreate;
                    handler.postDelayed(new Runnable() { // from class: a.xa
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i2 = WifiDetailsActivity.ag;
                            WifiDetailsActivity wifiDetailsActivity2 = wifiDetailsActivity;
                            wifiDetailsActivity2.getClass();
                            LinearLayout linearLayout3 = linearLayout2;
                            if (linearLayout3 != null) {
                                linearLayout3.setVisibility(8);
                            }
                            alertDialog2.dismiss();
                            wifiDetailsActivity2.finish();
                        }
                    }, 2000L);
                }
            });
            alertDialogCreate.show();
        } catch (Exception unused3) {
            Toast.makeText(this, "حدث خطأ في عرض النتيجة", 0).show();
        }
    }

    public final void i(String str, String str2) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
            if (clipboardManager == null) {
                Toast.makeText(this, "فشل الوصول إلى الحافظة", 0).show();
            } else {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
                Toast.makeText(this, "تم النسخ", 0).show();
            }
        } catch (Exception unused) {
            Toast.makeText(this, "فشل النسخ إلى الحافظة", 0).show();
        }
    }

    public final boolean k(String str) {
        WifiInfo connectionInfo;
        String ssid;
        NetworkCapabilities networkCapabilities;
        try {
            WifiManager wifiManager = this.s;
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (ssid = connectionInfo.getSSID()) == null || !ssid.replace("\"", "").equals(str) || connectionInfo.getIpAddress() == 0) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasTransport(1)) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
        }
        return false;
    }

    public final void l() {
        int i;
        try {
            if (this.e != null && this.f != null) {
                if (!this.o) {
                    MaterialCardView materialCardView = this.l;
                    if (materialCardView != null) {
                        materialCardView.setVisibility(8);
                    }
                    MaterialCardView materialCardView2 = this.m;
                    if (materialCardView2 != null) {
                        materialCardView2.setVisibility(8);
                        return;
                    }
                    return;
                }
                MaterialCardView materialCardView3 = this.l;
                if (materialCardView3 != null) {
                    materialCardView3.setVisibility(0);
                }
                MaterialCardView materialCardView4 = this.m;
                if (materialCardView4 != null) {
                    materialCardView4.setVisibility(0);
                }
                WifiManager wifiManager = this.s;
                if (wifiManager == null) {
                    this.e.setText("غير متوفر");
                    this.f.setText("غير متوفر");
                    return;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo == null) {
                    this.e.setText("غير متوفر");
                    this.f.setText("غير متوفر");
                    return;
                }
                String ssid = connectionInfo.getSSID();
                if (ssid != null) {
                    ssid = ssid.replace("\"", "");
                }
                String str = this.p;
                if (str != null && str.equals(ssid)) {
                    int ipAddress = connectionInfo.getIpAddress();
                    if (ipAddress == 0) {
                        this.e.setText("غير متوفر");
                    } else {
                        this.e.setText(j(ipAddress));
                    }
                    DhcpInfo dhcpInfo = this.s.getDhcpInfo();
                    if (dhcpInfo == null || (i = dhcpInfo.gateway) == 0) {
                        this.f.setText("غير متوفر");
                        return;
                    } else {
                        this.f.setText(j(i));
                        return;
                    }
                }
                this.e.setText("غير متصل");
                this.f.setText("غير متصل");
            }
        } catch (Exception unused) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setText("غير متوفر");
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText("غير متوفر");
            }
        }
    }

    public final void m() {
        ConnectivityManager connectivityManager;
        try {
            Handler handler = this.z;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.aa;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            xb xbVar = this.ab;
            if (xbVar != null && (connectivityManager = this.t) != null) {
                try {
                    connectivityManager.unregisterNetworkCallback(xbVar);
                } catch (Exception unused) {
                }
                this.ab = null;
            }
        } catch (Exception unused2) {
        }
        if (this.ac) {
            int i = this.y;
            String[] strArr = this.x;
            if (i >= strArr.length) {
                n();
                try {
                    AlertDialog alertDialog = this.u;
                    if (alertDialog != null && alertDialog.isShowing()) {
                        this.u.dismiss();
                    }
                } catch (Exception unused3) {
                }
                this.ac = false;
                MaterialButton materialButton = this.h;
                if (materialButton != null) {
                    materialButton.setEnabled(true);
                }
                try {
                    View viewInflate = LayoutInflater.from(this).inflate(R.layout.popup_glitch, (ViewGroup) null);
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setView(viewInflate).setCancelable(true).create();
                    if (alertDialogCreate.getWindow() != null) {
                        alertDialogCreate.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    }
                    ((Button) viewInflate.findViewById(R.id.btn_warning_try)).setOnClickListener(new wv(alertDialogCreate, 1));
                    alertDialogCreate.show();
                    return;
                } catch (Exception unused4) {
                    return;
                }
            }
            String str = strArr[i];
            if (this.progressMessageTextView != null) {
                this.progressMessageTextView.setText("جاري تجربة كلمة المرور: " + str + " (" + (this.y + 1) + "/" + this.x.length + ")");
            }
            if (str == null || str.isEmpty()) {
                this.y++;
                m();
                return;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                if (i2 < 29) {
                    return;
                }
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier(wu.b().setSsid(this.p).setWpa2Passphrase(str).build()).build();
                xb xbVar2 = new xb(this, str);
                this.ab = xbVar2;
                this.t.requestNetwork(networkRequestBuild, xbVar2);
                this.af = 0;
                this.aa.postDelayed(new iz(2, this, str), 400L);
                this.z.postDelayed(new wx(this, 0), 8000L);
                return;
            }
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = pt.j(new StringBuilder("\""), this.p, "\"");
            wifiConfiguration.preSharedKey = pt.h("\"", str, "\"");
            int iAddNetwork = this.s.addNetwork(wifiConfiguration);
            this.s.disconnect();
            this.s.enableNetwork(iAddNetwork, true);
            this.s.reconnect();
            this.af = 0;
            this.aa.postDelayed(new iz(2, this, str), 400L);
            this.z.postDelayed(new ww(this, str, 0), 6000L);
        }
    }

    public final void n() {
        ow owVar;
        if (!this.ae || (owVar = this.ad) == null) {
            return;
        }
        try {
            unregisterReceiver(owVar);
            this.ae = false;
        } catch (Exception unused) {
        }
    }

    public final void o(boolean z) {
        try {
            MaterialButton materialButton = this.h;
            if (materialButton == null) {
                return;
            }
            if (z) {
                materialButton.setVisibility(8);
                return;
            }
            boolean zD = false;
            materialButton.setVisibility(0);
            this.h.setText("تجربة إتصال بهذه الشبكة");
            this.h.setIconResource(R.drawable.ic_wifi_connect);
            this.h.setEnabled(true);
            String str = this.p;
            if (str != null) {
                zD = kz.d(str);
            }
            if (zD) {
                this.h.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#059669")));
            } else {
                this.h.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.holo_red_dark));
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wifi_details);
        this.s = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.t = (ConnectivityManager) getSystemService("connectivity");
        this.z = new Handler(Looper.getMainLooper());
        this.aa = new Handler(Looper.getMainLooper());
        this.g = (MaterialToolbar) findViewById(R.id.toolbar);
        this.f434a = (TextView) findViewById(R.id.ssidValueHeader);
        this.b = (TextView) findViewById(R.id.bssidValue);
        this.i = (LinearLayout) findViewById(R.id.bssidContainer);
        this.c = (TextView) findViewById(R.id.securityValue);
        this.d = (TextView) findViewById(R.id.frequencyValue);
        this.e = (TextView) findViewById(R.id.deviceIpValue);
        this.f = (TextView) findViewById(R.id.routerIpValue);
        this.j = (LinearLayout) findViewById(R.id.deviceIpContainer);
        this.k = (LinearLayout) findViewById(R.id.routerIpContainer);
        this.l = (MaterialCardView) findViewById(R.id.deviceIpCard);
        this.m = (MaterialCardView) findViewById(R.id.routerIpCard);
        this.h = (MaterialButton) findViewById(R.id.btnSpeedTest);
        this.n = (ImageView) findViewById(R.id.iconWifi);
        setSupportActionBar(this.g);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new wy(this, 1));
        }
        LinearLayout linearLayout2 = this.j;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new wy(this, 2));
        }
        LinearLayout linearLayout3 = this.k;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(new wy(this, 3));
        }
        MaterialButton materialButton = this.h;
        if (materialButton != null) {
            materialButton.setOnClickListener(new wy(this, 4));
        }
        this.txtImportStatus = (TextView) findViewById(R.id.txtImportStatus);
        View btnImport = findViewById(R.id.btnImportPasswords);
        if (btnImport != null) {
            btnImport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    importPasswordFile();
                }
            });
        }
        try {
            Intent intent = getIntent();
            this.p = intent.getStringExtra("ssid");
            this.q = intent.getStringExtra("bssid");
            this.r = intent.getStringExtra("security");
            String stringExtra = intent.getStringExtra("frequency");
            this.o = intent.getBooleanExtra("isConnected", false);
            TextView textView = this.f434a;
            if (textView != null) {
                String str = this.p;
                if (str == null) {
                    str = "شبكة غير معروفة";
                }
                textView.setText(str);
            }
            TextView textView2 = this.b;
            if (textView2 != null) {
                String str2 = this.q;
                if (str2 == null) {
                    str2 = "غير متوفر";
                }
                textView2.setText(str2);
            }
            TextView textView3 = this.c;
            if (textView3 != null) {
                String str3 = this.r;
                if (str3 == null) {
                    str3 = "بدون حماية";
                }
                textView3.setText(str3);
            }
            TextView textView4 = this.d;
            if (textView4 != null) {
                if (stringExtra == null) {
                    stringExtra = "غير معروف";
                }
                textView4.setText(stringExtra);
            }
            l();
            String str4 = this.p;
            if (this.n != null) {
                if (str4 == null ? false : kz.d(str4)) {
                    this.n.setImageResource(R.drawable.wifi);
                } else {
                    this.n.setImageResource(R.drawable.wifi);
                }
            }
            o(this.o);
        } catch (Exception unused) {
            Toast.makeText(this, "حدث خطأ في تحميل البيانات", 0).show();
        }
        this.ad = new ow(this, 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        ConnectivityManager connectivityManager;
        super.onDestroy();
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.aa;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        n();
        xb xbVar = this.ab;
        if (xbVar != null && (connectivityManager = this.t) != null) {
            try {
                connectivityManager.unregisterNetworkCallback(xbVar);
                this.ab = null;
            } catch (Exception unused) {
            }
        }
        AlertDialog alertDialog = this.u;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.u.dismiss();
        }
        AlertDialog alertDialog2 = this.v;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.v.dismiss();
        }
        AlertDialog alertDialog3 = this.w;
        if (alertDialog3 == null || !alertDialog3.isShowing()) {
            return;
        }
        this.w.dismiss();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void importPasswordFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("text/plain");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "اختر ملف كلمات المرور"), 200);
        } catch (Exception e) {
            Toast.makeText(this, "لم يتم العثور على مدير ملفات مناسب", 0).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == -1 && data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                readPasswordsFromUri(uri);
            }
        }
    }

    private void readPasswordsFromUri(Uri uri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    list.add(trimmed);
                }
            }
            reader.close();
            inputStream.close();
            this.importedPasswords = list;
            if (this.txtImportStatus != null) {
                this.txtImportStatus.setText("تم تحميل " + list.size() + " كلمة مرور");
            }
            Toast.makeText(this, "تم استيراد الملف بنجاح", 0).show();
        } catch (Exception e) {
            Toast.makeText(this, "فشل قراءة الملف: " + e.getMessage(), 0).show();
        }
    }

    public void startWifiTest() {
        if (this.p == null || this.p.isEmpty()) {
            Toast.makeText(this, "إسم الشبكة غير صالح", 0).show();
            return;
        }

        HashSet<String> candidates = new HashSet<>();

        // 1. Add custom imported passwords
        if (this.importedPasswords != null) {
            candidates.addAll(this.importedPasswords);
        }

        // 2. Add common default passwords
        String[] commonDefaults = {
            "12345678", "1234567890", "00000000", "adminadmin", "password", 
            "123456789", "11223344", "iam@huawei", "inwi@huawei123", "inwi@zte123"
        };
        for (String pw : commonDefaults) {
            candidates.add(pw);
        }

        // 3. Add MAC-based defaults if BSSID is available
        if (this.q != null && !this.q.isEmpty()) {
            String cleanMacUpper = this.q.replace(":", "").replace("-", "").trim().toUpperCase();
            String cleanMacLower = cleanMacUpper.toLowerCase();
            
            candidates.add(cleanMacUpper);
            candidates.add(cleanMacLower);
            
            if (cleanMacUpper.length() >= 8) {
                candidates.add(cleanMacUpper.substring(cleanMacUpper.length() - 8));
                candidates.add(cleanMacLower.substring(cleanMacLower.length() - 8));
            }
            if (cleanMacUpper.length() >= 6) {
                candidates.add(cleanMacUpper.substring(cleanMacUpper.length() - 6));
                candidates.add(cleanMacLower.substring(cleanMacLower.length() - 6));
            }
            if (cleanMacUpper.length() >= 4) {
                candidates.add("inwi" + cleanMacLower.substring(cleanMacLower.length() - 4));
                candidates.add("orange" + cleanMacLower.substring(cleanMacLower.length() - 4));
                candidates.add("iam" + cleanMacLower.substring(cleanMacLower.length() - 4));
            }
        }

        // Convert candidates set to array
        this.x = candidates.toArray(new String[0]);
        this.y = 0;
        this.ac = true;

        if (this.h != null) {
            this.h.setEnabled(false);
        }

        try {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.popup_progress, null);
            this.progressMessageTextView = (TextView) viewInflate.findViewById(R.id.popup_progress_message);
            this.u = new AlertDialog.Builder(this).setView(viewInflate).setCancelable(false).create();
            if (this.u.getWindow() != null) {
                this.u.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }
            this.u.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        m();
    }
}
