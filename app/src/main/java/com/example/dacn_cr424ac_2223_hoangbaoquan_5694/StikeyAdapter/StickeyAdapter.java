package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.StikeyAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class StickeyAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private List<String> mlist ;

    public void setData(List<String> list){
        this.mlist = list ;
        notifyDataSetChanged();
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder headerViewHolder ;
        if (convertView == null){
            headerViewHolder = new HeaderViewHolder() ;
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.headersticky,parent,false) ;
            headerViewHolder.tv = convertView.findViewById(R.id.tvStikeyheader) ;
            convertView.setTag(headerViewHolder);
        }else{
            headerViewHolder = (HeaderViewHolder) convertView.getTag();
        }
        headerViewHolder.tv.setText(mlist.get(position).substring(0,27));
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {

        return mlist.get(position).subSequence(23,27).charAt(0);
    }

    @Override
    public int getCount() {
        if(mlist != null){
            return mlist.size() ;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder itemViewHolder ;
        if (convertView == null){
            itemViewHolder = new ItemViewHolder() ;
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.headersticky_item,parent,false) ;
            itemViewHolder.tv = convertView.findViewById(R.id.tvItemStichey ) ;
            convertView.setTag(itemViewHolder);
        }else{
            itemViewHolder = (ItemViewHolder) convertView.getTag();
        }
        String a = mlist.get(position).substring(0,27);
        if(a.equalsIgnoreCase("Mẹo B2 câu hỏi về sa hình  ")){
            itemViewHolder.tv.setText(mlist.get(position).replaceAll("Mẹo B2 câu hỏi về sa hình  ",""));
        }else if(a.equalsIgnoreCase("Mẹo B2 câu hỏi về Biển Báo ")){
            itemViewHolder.tv.setText(mlist.get(position).replaceAll("Mẹo B2 câu hỏi về Biển Báo ",""));
        }else if(a.equalsIgnoreCase("Mẹo B2 câu hỏi về lý thuyết")){
            itemViewHolder.tv.setText(mlist.get(position).replaceAll("Mẹo B2 câu hỏi về Lý Thuyết",""));
        }


        return convertView;
    }

    public class ItemViewHolder{
        private TextView tv ;

    }
    public class HeaderViewHolder{
        private TextView tv ;

    }
}
