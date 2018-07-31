package emcorp.studio.pijat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

import emcorp.studio.pijat.Library.Constant;

public class TelungkupActivity extends AppCompatActivity {
    MaterialRippleLayout lo1, lo2, lo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telungkup);
        getSupportActionBar().setTitle("PASIEN TELUNGKUP");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        lo1 = (MaterialRippleLayout)findViewById(R.id.lo1);
        lo2 = (MaterialRippleLayout)findViewById(R.id.lo2);
        lo3 = (MaterialRippleLayout)findViewById(R.id.lo3);
        lo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelungkupActivity.this,TeknikActivity.class);
                i.putExtra("menu", Constant.LIST_MENU_TELUNGKUP[0]);
                startActivity(i);
                finish();

            }
        });
        lo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelungkupActivity.this,TeknikActivity.class);
                i.putExtra("menu", Constant.LIST_MENU_TELUNGKUP[1]);
                startActivity(i);
                finish();

            }
        });
        lo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelungkupActivity.this,TeknikActivity.class);
                i.putExtra("menu", Constant.LIST_MENU_TELUNGKUP[2]);
                startActivity(i);
                finish();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(TelungkupActivity.this);
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(TelungkupActivity.this,MainMassageActivity.class);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(TelungkupActivity.this,MainMassageActivity.class);
        startActivity(i);
        finish();
    }
}
