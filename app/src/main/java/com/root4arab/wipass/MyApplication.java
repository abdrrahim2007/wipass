package com.root4arab.wipass;

import android.app.Application;
import com.root4arab.wipass.security.SecurityManager;

/* JADX INFO: loaded from: classes.dex */
public class MyApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        new SecurityManager(this);
    }
}
