package com.root4arab.wipass;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class AboutActivity extends AppCompatActivity {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f431a;
    public AlertDialog b;
    public AlertDialog c;

    public final void h(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "لا يمكن فتح الرابط", 0).show();
        }
    }

    @Override
    public final void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_about);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("حول التطبيق");
        }

        android.view.View youtubeCard = findViewById(R.id.card_youtube);
        if (youtubeCard != null) {
            youtubeCard.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    h("https://www.youtube.com/@root4arab");
                }
            });
        }

        android.view.View facebookCard = findViewById(R.id.card_facebook);
        if (facebookCard != null) {
            facebookCard.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    h("https://t.me/root4arab");
                }
            });
        }

        android.view.View emailCard = findViewById(R.id.card_email);
        if (emailCard != null) {
            emailCard.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:root4arab@proton.me"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "WiPass App");
                    try {
                        startActivity(Intent.createChooser(intent, "ارسل بريد الكتروني"));
                    } catch (Exception e) {
                        Toast.makeText(AboutActivity.this, "لا يوجد تطبيق بريد الكتروني", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        android.view.View privacyCard = findViewById(R.id.card_privacy);
        if (privacyCard != null) {
            privacyCard.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    h("https://gitlab.com/root4arab/wipass");
                }
            });
        }

        android.view.View updateCard = findViewById(R.id.card_check_update);
        if (updateCard != null) {
            updateCard.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Toast.makeText(AboutActivity.this, "أنت تستخدم أحدث إصدار بالفعل", Toast.LENGTH_SHORT).show();
                }
            });
        }

        android.view.View shareCard = findViewById(R.id.card_share);
        if (shareCard != null) {
            shareCard.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "قم بتحميل تطبيق WiPass لكشف نقاط ضعف الواي فاي! https://gitlab.com/root4arab/wipass");
                    sendIntent.setType("text/plain");
                    startActivity(Intent.createChooser(sendIntent, "مشاركة التطبيق"));
                }
            });
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        ExecutorService executorService = this.f431a;
        if (executorService != null) {
            executorService.shutdown();
        }
        try {
            AlertDialog alertDialog = this.b;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.b.dismiss();
            }
            AlertDialog alertDialog2 = this.c;
            if (alertDialog2 == null || !alertDialog2.isShowing()) {
                return;
            }
            this.c.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
