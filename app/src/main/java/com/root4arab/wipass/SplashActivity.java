package com.root4arab.wipass;

import a.aa;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f433a = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.systemBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new aa(13, this), 1000L);
    }
}
