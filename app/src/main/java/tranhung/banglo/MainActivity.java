package tranhung.banglo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import tranhung.banglo.tranhung.view.adapter.TabsAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  AlertDialog.Builder alert = null;
    private Spinner kieulo, kieude;
    private ListView list_lo, list_de;
    private ArrayList<String> arrlist_lo, arrlist_de;
    private ArrayAdapter<String> adapter_listlo,adapter_listde;
    private Button add_lo, add_de;
    private EditText edt_getlo, edt_getde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        createView();
        Log.d("BangLo","new app");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                displayAlertDialog();
            }
        });
    }

    private void createView() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("User"));
        tabLayout.addTab(tabLayout.newTab().setText("Lo"));
        tabLayout.addTab(tabLayout.newTab().setText("De"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager =(ViewPager)findViewById(R.id.view_pager);
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.d("BangLo","so: "+tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void displayAlertDialog(){


        LayoutInflater inflater = this.getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.addlo_de, null);

        initViewDialog(alertLayout);
        initViewList(alertLayout);
        alert = new AlertDialog.Builder(this);
        alert.setTitle("Thêm Lô đề");
        alert.setView(alertLayout);
        alert.setCancelable(false);



        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void initViewList(View view) {
        list_lo = (ListView)view.findViewById(R.id.listlo);
        arrlist_lo = new ArrayList<>();
        adapter_listlo =  new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,arrlist_lo);
        list_lo.setAdapter(adapter_listlo);

        list_de = (ListView)view.findViewById(R.id.listde);
        arrlist_de = new ArrayList<>();
        adapter_listde =  new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,arrlist_de);
        list_de.setAdapter(adapter_listde);

        add_de = (Button) view.findViewById(R.id.add_de);
        add_de.setOnClickListener(this);
        add_lo = (Button)view.findViewById(R.id.add_lo);
        add_lo.setOnClickListener(this);

        edt_getlo = (EditText)view.findViewById(R.id.edt_solo);
        edt_getde = (EditText)view.findViewById(R.id.edt_sode);
    }

    public void initViewDialog(View view){
        kieulo = (Spinner)view.findViewById(R.id.kieulo);
        ArrayList<String> listlo = new ArrayList<String>();
        listlo.add("lo");
        listlo.add("lo xien");

        ArrayAdapter<String> loadapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listlo);
        kieulo.setAdapter(loadapter);

        kieude = (Spinner)view.findViewById(R.id.kieude);
        ArrayList<String> listde = new ArrayList<String>();
        listde.add("de");
        listde.add("de 3 cang");
        ArrayAdapter<String> deadapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,listde);
        kieude.setAdapter(deadapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_de:
                adapter_listde.add(edt_getde.getText().toString());
                adapter_listde.notifyDataSetChanged();
            break;
            case R.id.add_lo:
                adapter_listlo.add(edt_getlo.getText().toString());
                adapter_listlo.notifyDataSetChanged();
            break;

        }
    }
}
