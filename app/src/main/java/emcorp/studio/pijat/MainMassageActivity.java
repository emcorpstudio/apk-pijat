package emcorp.studio.pijat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

import emcorp.studio.pijat.Library.Constant;

public class MainMassageActivity extends AppCompatActivity {
    MaterialRippleLayout lo1, lo2, lo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_massage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("TEKNIK MASSAGE");
        lo1 = (MaterialRippleLayout)findViewById(R.id.lo1);
        lo2 = (MaterialRippleLayout)findViewById(R.id.lo2);
        lo3 = (MaterialRippleLayout)findViewById(R.id.lo3);

        lo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMassageActivity.this,DetailMassageActivity.class);
                i.putExtra("title", Constant.POSISI_PASIEN_DUDUK[0]);
                i.putExtra("image",Constant.POSISI_PASIEN_DUDUK[1]);
                i.putExtra("video",Constant.POSISI_PASIEN_DUDUK[2]);
                i.putExtra("menu",Constant.POSISI_PASIEN_DUDUK[3]);
                i.putExtra("content",Constant.POSISI_PASIEN_DUDUK[4]);
                startActivity(i);
                finish();
            }
        });

        lo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMassageActivity.this,TelungkupActivity.class);
                startActivity(i);
                finish();

            }
        });

        lo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMassageActivity.this,TerlentangActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainMassageActivity.this);
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(MainMassageActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MainMassageActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
