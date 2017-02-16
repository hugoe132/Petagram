package com.hugoe.petagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout MiSFIrefresh;
    ListView miLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();
        MiSFIrefresh = (SwipeRefreshLayout) findViewById(R.id.MiSFIrefresh);
        miLista = (ListView) findViewById(R.id.miLista);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        miLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));

        MiSFIrefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }


    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        miLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        MiSFIrefresh.setRefreshing(false);
    }

    public void agregarFAB() {
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.miFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "se hizo un click");
                            }
                        }).setActionTextColor(getResources().getColor(R.color.blanco))
                        .show();
            }
        });

    }
}
