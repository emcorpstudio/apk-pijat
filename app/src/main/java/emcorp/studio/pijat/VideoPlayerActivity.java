package emcorp.studio.pijat;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {
    private VideoView vv;
    private MediaController mediacontroller;
    String video = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        vv = (VideoView) findViewById(R.id.vv);
        mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(vv);
        getSupportActionBar().hide();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            video = extras.getString("video");
            int resId = getResources().getIdentifier(video, "raw", getApplicationInfo().packageName);
            String path = "android.resource://" + getPackageName() + "/" + resId;
//            String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
            vv.setMediaController(mediacontroller);
            vv.setVideoURI(Uri.parse(path));
            vv.start();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
