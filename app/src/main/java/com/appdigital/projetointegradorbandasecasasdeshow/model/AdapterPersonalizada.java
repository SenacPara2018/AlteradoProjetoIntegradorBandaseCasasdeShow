package com.appdigital.projetointegradorbandasecasasdeshow.model;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.appdigital.projetointegradorbandasecasasdeshow.R;

import java.util.List;

public class AdapterPersonalizada extends BaseAdapter {
    private final List<Banda> bandas;
    private final Activity act;

    public AdapterPersonalizada(List<Banda> bandas, Activity act) {
        this.bandas = bandas;
        this.act = act;
    }

    @Override
    public int getCount() {
        return bandas.size();
    }

    @Override
    public Object getItem(int position) {
        return bandas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.modelo_list_adapter, parent, false);
        return null;
    }
}
