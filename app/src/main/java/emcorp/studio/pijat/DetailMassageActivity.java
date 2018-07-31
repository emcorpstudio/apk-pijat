package emcorp.studio.pijat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import emcorp.studio.pijat.Library.Constant;

public class DetailMassageActivity extends AppCompatActivity {
    private View parent_view;
    TextView title,date, content;
    ImageView image;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private FloatingActionButton fab;
    String video = "", list_image = "", menu = "";
    CarouselView carouselView;
    Class backclass;
    WebView webview;
    int[] sampleImages;// = {R.drawable.img_0354, R.drawable.img_0361, R.drawable.img_0367 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_massage);
        parent_view = findViewById(android.R.id.content);
        title = (TextView) findViewById(R.id.title);
        date = (TextView) findViewById(R.id.date);
        content = (TextView) findViewById(R.id.content);
        image = (ImageView) findViewById(R.id.image);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        carouselView = findViewById(R.id.carouselView);
        webview = (WebView)findViewById(R.id.webview);
        getSupportActionBar().hide();


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title.setText(extras.getString("title"));
            getSupportActionBar().setTitle(extras.getString("title"));
            content.setText(extras.getString("content"));
            video = extras.getString("video");
            menu = extras.getString("menu");
            webview.loadUrl("file:///android_asset/"+extras.getString("content"));
            try {
                backclass = Class.forName(Constant.PACKAGE_NAME+"."+menu);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            list_image = extras.getString("image");
            String[] imglist = list_image.split(";");
            sampleImages = new int[imglist.length];
            for(int i=0;i<sampleImages.length;i++){
                int resId = getResources().getIdentifier(imglist[i], "drawable", getApplicationInfo().packageName);
                sampleImages[i] = resId;
            }
            carouselView.setPageCount(sampleImages.length);
            carouselView.setImageListener(imageListener);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailMassageActivity.this,VideoPlayerActivity.class);
                i.putExtra("video",video);
                startActivity(i);
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(DetailMassageActivity.this);
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(DetailMassageActivity.this,backclass);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(menu.equals("MainMassageActivity")||menu.equals("TerlentangActivity")){
            Intent i = new Intent(DetailMassageActivity.this,backclass);
            startActivity(i);
            finish();
        }else{
            super.onBackPressed();
        }
    }
}
