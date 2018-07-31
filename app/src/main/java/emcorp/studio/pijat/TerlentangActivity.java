package emcorp.studio.pijat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

import emcorp.studio.pijat.Library.Constant;

public class TerlentangActivity extends AppCompatActivity {
    MaterialRippleLayout lo1, lo2, lo3, lo4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terlentang);
        getSupportActionBar().setTitle("PASIEN TERLENTANG");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        lo1 = (MaterialRippleLayout)findViewById(R.id.lo1);
        lo2 = (MaterialRippleLayout)findViewById(R.id.lo2);
        lo3 = (MaterialRippleLayout)findViewById(R.id.lo3);
        lo4 = (MaterialRippleLayout)findViewById(R.id.lo4);
        lo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TerlentangActivity.this,TeknikActivity.class);
                i.putExtra("menu", Constant.LIST_MENU_TERLENTANG[0]);
                startActivity(i);
                finish();

            }
        });
        lo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TerlentangActivity.this,DetailMassageActivity.class);
                i.putExtra("title", Constant.TERLENTANG_PERUT[0]);
                i.putExtra("image",Constant.TERLENTANG_PERUT[1]);
                i.putExtra("video",Constant.TERLENTANG_PERUT[2]);
                i.putExtra("menu",Constant.TERLENTANG_PERUT[3]);
                i.putExtra("content",Constant.TERLENTANG_PERUT[4]);
                startActivity(i);
                finish();

            }
        });
        lo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TerlentangActivity.this,TeknikActivity.class);
                i.putExtra("menu", Constant.LIST_MENU_TERLENTANG[2]);
                startActivity(i);
                finish();

            }
        });
        lo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TerlentangActivity.this,DetailMassageActivity.class);
                i.putExtra("title", Constant.TERLENTANG_WAJAH[0]);
                i.putExtra("image",Constant.TERLENTANG_WAJAH[1]);
                i.putExtra("video",Constant.TERLENTANG_WAJAH[2]);
                i.putExtra("menu",Constant.TERLENTANG_WAJAH[3]);
                i.putExtra("content",Constant.TERLENTANG_WAJAH[4]);
                startActivity(i);
                finish();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(TerlentangActivity.this);
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(TerlentangActivity.this,MainMassageActivity.class);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(TerlentangActivity.this,MainMassageActivity.class);
        startActivity(i);
        finish();
    }
}
