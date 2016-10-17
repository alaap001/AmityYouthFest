package com.example.alaap.amityyouthfest.Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.alaap.amityyouthfest.Dialog_activity;
import com.example.alaap.amityyouthfest.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Photos extends android.app.Fragment implements AdapterView.OnItemClickListener {


    public Photos() {
        // Required empty public constructor
    }

    GridView mygrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_photos, container, false);
        mygrid = (GridView) root.findViewById(R.id.gridphotos);
        mygrid.setAdapter(new adapter(getActivity()));
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mygrid.setOnItemClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter.ViewHolderimage image = (adapter.ViewHolderimage) view.getTag();
        singleitem temp = (singleitem) image.image.getTag();
        Intent intent = new Intent(getActivity(), Dialog_activity.class);
        intent.putExtra("CountryImage", temp.image);
        intent.putExtra("countryname", temp.countryname);
        getActivity().startActivity(intent);
    }

    class singleitem {
        String countryname;
        int image;

        singleitem(int image, String countryname) {

            this.image = image;
            this.countryname = countryname;

        }
    }

    class adapter extends BaseAdapter {
        ArrayList<singleitem> country;
        Context c;

        adapter(Context c) {
            this.c = c;
            country = new ArrayList<>();
            Resources res = c.getResources();
            String[] countrynames = res.getStringArray(R.array.photos);
            int[] images = {R.drawable.amitylogo,
                    R.drawable.ayflogo,
                    R.drawable.aamirkhan, R.drawable.pop, R.drawable.ashok_chauhan,
                    R.drawable.atul_chauhan
                    , R.drawable.amitylogo, R.drawable.amity, R.drawable.ayflogo,
                    R.drawable.aamirkhan, R.drawable.pop, R.drawable.ashok_chauhan
                    , R.drawable.atul_chauhan, R.drawable.fashion, R.drawable.images_one
                    , R.drawable.freshers_grp, R.drawable.sangathan};

            for (int i = 0; i < countrynames.length; i++) {
                singleitem item = new singleitem(images[i], countrynames[i]);
                country.add(item);
            }
        }

        @Override
        public int getCount() {
            return country.size();
        }

        @Override
        public Object getItem(int position) {
            return country.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class ViewHolderimage {
            ImageView image;

            ViewHolderimage(View v) {
                image = (ImageView) v.findViewById(R.id.imageview);
            }

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolderimage holder = null;
            if (row == null) {
                LayoutInflater ll = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = ll.inflate(R.layout.singlegridview, parent, false);
                holder = new ViewHolderimage(row);
                row.setTag(holder);
            } else {
                holder = (ViewHolderimage) row.getTag();
            }

            singleitem singlecountry = country.get(position);
            holder.image.setImageResource(singlecountry.image);
            holder.image.setTag(singlecountry);
            return row;
        }
    }

}
