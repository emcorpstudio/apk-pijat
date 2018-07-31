package emcorp.studio.pijat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

public class MainActivity extends AppCompatActivity {
    MaterialRippleLayout lo1, lo2, lo3, lo4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lo1 = (MaterialRippleLayout)findViewById(R.id.lo1);
        lo2 = (MaterialRippleLayout)findViewById(R.id.lo2);
        lo3 = (MaterialRippleLayout)findViewById(R.id.lo3);
        lo4 = (MaterialRippleLayout)findViewById(R.id.lo4);

        lo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,WebviewActivity.class);
                i.putExtra("type","2");
                startActivity(i);
                finish();
            }
        });
        lo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,WebviewActivity.class);
                i.putExtra("type","3");
                startActivity(i);
                finish();
            }
        });
        lo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainMassageActivity.class);
                startActivity(i);
                finish();
            }
        });
        lo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,WebviewActivity.class);
                i.putExtra("type","1");
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        ActivityCompat.finishAffinity(MainActivity.this);
        System.exit(0);
    }
}
