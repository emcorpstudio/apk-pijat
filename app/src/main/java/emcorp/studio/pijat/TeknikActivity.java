package emcorp.studio.pijat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import emcorp.studio.pijat.Adapter.AlbumAdapter;
import emcorp.studio.pijat.Library.Constant;
import emcorp.studio.pijat.Library.Image;

public class TeknikActivity extends AppCompatActivity {
    private ArrayList<Image> images;
    private ProgressDialog pDialog;
    private AlbumAdapter mAdapter;
    private RecyclerView recyclerView;
    private String[][] list_array;
    Class backclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teknik);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        pDialog = new ProgressDialog(this);
        images = new ArrayList<>();
        mAdapter = new AlbumAdapter(getApplicationContext(), images);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String menu = extras.getString("menu");
            list_array = get_array(menu);
            for(int i=0;i<list_array.length;i++){
                Image image = new Image();
                image.setName(list_array[i][0]);
                String[] list_foto = list_array[i][1].split(";");
                int resId;
                if(list_foto.length==0){
                    resId = 0;
                }else{
                    resId = getResources().getIdentifier(list_foto[list_foto.length-1], "drawable", getApplicationInfo().packageName);
                }
                image.setFoto(resId);
                image.setRecid(String.valueOf(i));
                images.add(image);
            }
            mAdapter.notifyDataSetChanged();
            getSupportActionBar().setTitle(menu);
        }

        recyclerView.addOnItemTouchListener(new AlbumAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new AlbumAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(TeknikActivity.this,DetailMassageActivity.class);
                i.putExtra("title", list_array[position][0]);
                i.putExtra("image",list_array[position][1]);
                i.putExtra("video",list_array[position][2]);
                i.putExtra("menu",list_array[position][3]);
                i.putExtra("content",list_array[position][4]);
                startActivity(i);
//                finish();
//                Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("images", images);
//                bundle.putInt("position", position);
//
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
//                newFragment.setArguments(bundle);
//                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public String[][] get_array(String menu){
        String[][] array_use = new String[][]{};
        switch (menu){
            case "TELUNGKUP PANTAT" :
                array_use = Constant.TELUNGKUP_PANTAT;
                backclass = TelungkupActivity.class;
                break;
            case "TELUNGKUP PUNGGUNG" :
                array_use = Constant.TELUNGKUP_PUNGGUNG;
                backclass = TelungkupActivity.class;
                break;
            case "TELUNGKUP TUNGKAI" :
                array_use = Constant.TELUNGKUP_TUNGKAI;
                backclass = TelungkupActivity.class;
                break;
            case "TERLENTANG LENGAN" :
                array_use = Constant.TERLENTANG_LENGAN;
                backclass = TerlentangActivity.class;
                break;
            case "TERLENTANG TUNGKAI" :
                array_use = Constant.TERLENTANG_TUNGKAI;
                backclass = TerlentangActivity.class;
                break;
        }
        return array_use;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(TeknikActivity.this);
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(TeknikActivity.this,backclass);
                startActivity(i);
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(TeknikActivity.this,backclass);
        startActivity(i);
        finish();
    }
}
