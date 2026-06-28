package a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class lr implements ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lh f172a;
    public final int b;
    public HttpURLConnection c;
    public InputStream d;
    public volatile boolean e;

    public lr(lh lhVar, int i) {
        this.f172a = lhVar;
        this.b = i;
    }

    @Override // a.ew
    public final Class a() {
        return InputStream.class;
    }

    @Override // a.ew
    public final void b() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.c = null;
    }

    public final InputStream c(URL url, int i, URL url2, Map map) throws lp {
        int responseCode;
        int responseCode2 = -1;
        if (i >= 5) {
            throw new lp("Too many (> 5) redirects!", -1, null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new lp("In re-direct loop", -1, null);
                }
            } catch (URISyntaxException unused) {
            }
        }
        int i2 = this.b;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setConnectTimeout(i2);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.c = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.d = this.c.getInputStream();
                if (this.e) {
                    return null;
                }
                try {
                    responseCode = this.c.getResponseCode();
                } catch (IOException unused2) {
                    Log.isLoggable("HttpUrlFetcher", 3);
                    responseCode = -1;
                }
                int i3 = responseCode / 100;
                if (i3 == 2) {
                    HttpURLConnection httpURLConnection2 = this.c;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.d = new ea(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                httpURLConnection2.getContentEncoding();
                            }
                            this.d = httpURLConnection2.getInputStream();
                        }
                        return this.d;
                    } catch (IOException e) {
                        try {
                            responseCode2 = httpURLConnection2.getResponseCode();
                        } catch (IOException unused3) {
                            Log.isLoggable("HttpUrlFetcher", 3);
                        }
                        throw new lp("Failed to obtain InputStream", responseCode2, e);
                    }
                }
                if (i3 != 3) {
                    if (responseCode == -1) {
                        throw new lp("Http request failed", responseCode, null);
                    }
                    try {
                        throw new lp(this.c.getResponseMessage(), responseCode, null);
                    } catch (IOException e2) {
                        throw new lp("Failed to get a response message", responseCode, e2);
                    }
                }
                String headerField = this.c.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new lp("Received empty or null redirect url", responseCode, null);
                }
                try {
                    URL url3 = new URL(url, headerField);
                    b();
                    return c(url3, i + 1, url, map);
                } catch (MalformedURLException e3) {
                    throw new lp(pt.s("Bad redirect url: ", headerField), responseCode, e3);
                }
            } catch (IOException e4) {
                try {
                    responseCode2 = this.c.getResponseCode();
                } catch (IOException unused4) {
                    Log.isLoggable("HttpUrlFetcher", 3);
                }
                throw new lp("Failed to connect or obtain data", responseCode2, e4);
            }
        } catch (IOException e5) {
            throw new lp("URL.openConnection threw", 0, e5);
        }
    }

    @Override // a.ew
    public final void cancel() {
        this.e = true;
    }

    @Override // a.ew
    public final int e() {
        return 2;
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) {
        lh lhVar = this.f172a;
        int i = oj.f211a;
        SystemClock.elapsedRealtimeNanos();
        try {
            try {
                evVar.d(c(lhVar.d(), 0, null, lhVar.b.a()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                }
            } catch (IOException e) {
                Log.isLoggable("HttpUrlFetcher", 3);
                evVar.c(e);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
            throw th;
        }
    }
}
