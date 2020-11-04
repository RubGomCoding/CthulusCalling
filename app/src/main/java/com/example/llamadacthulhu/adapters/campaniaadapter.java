package com.example.llamadacthulhu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.llamadacthulhu.R;
import com.example.llamadacthulhu.api.InterfaceApi;
import com.example.llamadacthulhu.api.RetrofitClientInstance;
import com.example.llamadacthulhu.model.Campania;
import com.example.llamadacthulhu.model.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;

public class campaniaadapter extends ArrayAdapter<Campania> {

    private ArrayList<Campania> dataSet;
    Context mContext;
    private int lastPosition = -1;

    public static class ViewHolder {
        TextView txtNombre;
        TextView txtUsu;
        TextView txtDesc;

    }

    public campaniaadapter(ArrayList<Campania> data, Context context){
        super(context, R.layout.itemlistaaventura, data);
        this.dataSet = data;
        this.mContext = context;
    }

    public View getView(int position, View ConvertView, ViewGroup parent){

        Campania camp = getItem(lastPosition);
        ViewHolder viewHolder;

        final View result;

        if(ConvertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            ConvertView = inflater.inflate(R.layout.itemlistaaventura,parent, false);


            result=ConvertView;

            ConvertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) ConvertView.getTag();
            result=ConvertView;
        }
        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        return ConvertView;
    }

}
