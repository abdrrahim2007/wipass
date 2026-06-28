package com.root4arab.wipass;

import a.bq;
import a.ot;
import a.ow;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.button.MaterialButton;
import com.root4arab.wipass.MainActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    public static final /* synthetic */ int u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f432a;
    public b b;
    public WifiManager c;
    public SwipeRefreshLayout d;
    public ArrayList e;
    public CoordinatorLayout i;
    public Handler j;
    public AlertDialog k;
    public AlertDialog l;
    public View m;
    public ExecutorService p;
    public View q;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public long n = 0;
    public boolean o = false;
    public final ow r = new ow(this, 0);
    public final ow s = new ow(this, 1);
    public final ow t = new ow(this, 2);

    public final void h() {
        if (this.h) {
            WifiManager wifiManager = this.c;
            boolean zIsWifiEnabled = wifiManager == null ? false : wifiManager.isWifiEnabled();
            boolean zJ = j();
            try {
                if (!zIsWifiEnabled) {
                    k(true);
                    if (this.o) {
                        AlertDialog alertDialog = this.k;
                        if (alertDialog == null || !alertDialog.isShowing()) {
                            i();
                            View viewInflate = LayoutInflater.from(this).inflate(R.layout.popup_wifi_disabled, (ViewGroup) null);
                            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.btn_wifi_enable);
                            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setView(viewInflate).setCancelable(false).create();
                            this.k = alertDialogCreate;
                            if (alertDialogCreate.getWindow() != null) {
                                this.k.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                            }
                            final int i = 0;
                            materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: a.os
                                public final /* synthetic */ MainActivity b;

                                {
                                    this.b = this;
                                }

                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    int i2 = i;
                                    MainActivity mainActivity = this.b;
                                    switch (i2) {
                                        case 0:
                                            if (Build.VERSION.SDK_INT < 29) {
                                                mainActivity.c.setWifiEnabled(true);
                                            } else {
                                                int i3 = MainActivity.u;
                                                mainActivity.getClass();
                                                mainActivity.startActivity(new Intent("android.settings.panel.action.WIFI"));
                                            }
                                            break;
                                        default:
                                            int i4 = MainActivity.u;
                                            mainActivity.getClass();
                                            mainActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                                            break;
                                    }
                                }
                            });
                            this.k.show();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (zJ) {
                    k(false);
                    i();
                    if (this.o) {
                        l(false);
                        return;
                    }
                    return;
                }
                k(true);
                if (this.o) {
                    AlertDialog alertDialog2 = this.l;
                    if (alertDialog2 == null || !alertDialog2.isShowing()) {
                        i();
                        View viewInflate2 = LayoutInflater.from(this).inflate(R.layout.popup_location_disabled, (ViewGroup) null);
                        MaterialButton materialButton2 = (MaterialButton) viewInflate2.findViewById(R.id.btn_location_enable);
                        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this).setView(viewInflate2).setCancelable(false).create();
                        this.l = alertDialogCreate2;
                        if (alertDialogCreate2.getWindow() != null) {
                            this.l.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        }
                        final int i2 = 1;
                        materialButton2.setOnClickListener(new View.OnClickListener(this) { // from class: a.os
                            public final /* synthetic */ MainActivity b;

                            {
                                this.b = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                int i22 = i2;
                                MainActivity mainActivity = this.b;
                                switch (i22) {
                                    case 0:
                                        if (Build.VERSION.SDK_INT < 29) {
                                            mainActivity.c.setWifiEnabled(true);
                                        } else {
                                            int i3 = MainActivity.u;
                                            mainActivity.getClass();
                                            mainActivity.startActivity(new Intent("android.settings.panel.action.WIFI"));
                                        }
                                        break;
                                    default:
                                        int i4 = MainActivity.u;
                                        mainActivity.getClass();
                                        mainActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                                        break;
                                }
                            }
                        });
                        this.l.show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void i() {
        try {
            AlertDialog alertDialog = this.k;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.k.dismiss();
            }
            AlertDialog alertDialog2 = this.l;
            if (alertDialog2 == null || !alertDialog2.isShowing()) {
                return;
            }
            this.l.dismiss();
        } catch (Exception unused) {
        }
    }

    public final boolean j() {
        LocationManager locationManager = (LocationManager) getSystemService("location");
        if (locationManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return locationManager.isLocationEnabled();
        }
        try {
            return Settings.Secure.getInt(getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    public final void k(boolean z) {
        if (this.m == null) {
            this.m = findViewById(R.id.blockingOverlay);
        }
        View view = this.m;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            this.m.setClickable(z);
            this.m.setFocusable(z);
        }
        RecyclerView recyclerView = this.f432a;
        if (recyclerView != null) {
            recyclerView.setEnabled(!z);
        }
        SwipeRefreshLayout swipeRefreshLayout = this.d;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(!z);
        }
    }

    public final void l(boolean z) {
        if (!this.h || this.f) {
            return;
        }
        WifiManager wifiManager = this.c;
        if (!(wifiManager == null ? false : wifiManager.isWifiEnabled()) || !j()) {
            h();
            m();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z || jCurrentTimeMillis - this.n >= 3000) {
            this.f = true;
            this.n = jCurrentTimeMillis;
            SwipeRefreshLayout swipeRefreshLayout = this.d;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(true);
            }
            this.c.startScan();
            this.j.postDelayed(new ot(this, 0), 10000L);
        }
    }

    public final void m() {
        this.f = false;
        SwipeRefreshLayout swipeRefreshLayout = this.d;
        if (swipeRefreshLayout == null || !swipeRefreshLayout.isRefreshing()) {
            return;
        }
        this.d.setRefreshing(false);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.j = new Handler(Looper.getMainLooper());
        this.p = Executors.newSingleThreadExecutor();
        this.i = (CoordinatorLayout) findViewById(R.id.mainLayout);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.f432a = (RecyclerView) findViewById(R.id.recyclerView);
        this.d = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        this.q = findViewById(R.id.loadingLayout);
        this.c = (WifiManager) getApplicationContext().getSystemService("wifi");
        SwipeRefreshLayout swipeRefreshLayout = this.d;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        }
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        this.b = new b(this, arrayList);
        this.f432a.setLayoutManager(new LinearLayoutManager(this));
        this.f432a.setAdapter(this.b);
        SwipeRefreshLayout swipeRefreshLayout2 = this.d;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setOnRefreshListener(new bq(2, this));
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.h = true;
            h();
        } else {
            CoordinatorLayout coordinatorLayout = this.i;
            if (coordinatorLayout != null) {
                coordinatorLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ArrayList arrayList2 = new ArrayList();
            if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                arrayList2.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (!arrayList2.isEmpty()) {
                ActivityCompat.requestPermissions(this, (String[]) arrayList2.toArray(new String[0]), 100);
            }
        }
        registerReceiver(this.s, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        registerReceiver(this.t, new IntentFilter("android.location.MODE_CHANGED"));
        new Handler(Looper.getMainLooper()).postDelayed(new ot(this, 1), 800L);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
            try {
                Method declaredMethod = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(menu, Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        i();
        ExecutorService executorService = this.p;
        if (executorService != null) {
            executorService.shutdown();
        }
        if (this.g) {
            try {
                unregisterReceiver(this.r);
            } catch (Exception unused) {
            }
            this.g = false;
        }
        try {
            unregisterReceiver(this.s);
            unregisterReceiver(this.t);
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_about) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent(this, (Class<?>) AboutActivity.class));
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.o = false;
        this.j.removeCallbacksAndMessages(null);
        m();
        if (this.g) {
            try {
                unregisterReceiver(this.r);
            } catch (Exception unused) {
            }
            this.g = false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            boolean z = false;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2].equals("android.permission.ACCESS_FINE_LOCATION")) {
                    z = iArr[i2] == 0;
                }
            }
            if (!z) {
                Toast.makeText(this, "صلاحية الموقع مطلوبة", 1).show();
                finish();
                return;
            }
            CoordinatorLayout coordinatorLayout = this.i;
            if (coordinatorLayout != null) {
                coordinatorLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.h = true;
            h();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.o = true;
        if (!this.g) {
            IntentFilter intentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
            int i = Build.VERSION.SDK_INT;
            ow owVar = this.r;
            if (i >= 33) {
                registerReceiver(owVar, intentFilter, 2);
            } else {
                registerReceiver(owVar, intentFilter);
            }
            this.g = true;
        }
        if (this.h) {
            h();
        }
    }
}
