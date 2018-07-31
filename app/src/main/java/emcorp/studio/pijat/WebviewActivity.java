package emcorp.studio.pijat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class WebviewActivity extends AppCompatActivity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webview = (WebView)findViewById(R.id.webview);
        getSupportActionBar().hide();
        String type = "";
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            type = extras.getString("type");
        }
        if(type.equals("1")){
            //Sejarah
            webview.loadUrl("file:///android_asset/sejarah.html");
        }else if(type.equals("2")){
            //Anatomi
            webview.loadUrl("file:///android_asset/anatomi.html");
        }else{
            //Indikasi
            webview.loadUrl("file:///android_asset/indikasi.html");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(WebviewActivity.this);
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(WebviewActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(WebviewActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
