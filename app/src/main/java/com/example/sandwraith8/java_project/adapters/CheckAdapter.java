package com.example.sandwraith8.java_project.adapters;

/**
 * Created by sandwraith8 on 21/04/2017.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sandwraith8.java_project.R;
import com.example.sandwraith8.java_project.databinding.ItemSearchResultBinding;
import com.example.sandwraith8.java_project.models.RuleResult;
import com.example.sandwraith8.java_project.utils.TextColorUtils;

import java.util.ArrayList;

public class CheckAdapter extends BaseAdapter {

    private ArrayList<RuleResult> results;

    private LayoutInflater mInflate;


    public CheckAdapter(Context mContext, ArrayList<RuleResult> results) {
        this.results = results;
        mInflate = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflate.inflate(R.layout.item_search_result, null);
            holder.mBinding =
                    DataBindingUtil.bind(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mBinding.titleTextView.setVisibility(View.GONE);
//        holder.mBinding.contentTextView.setText(results.get(position).getWord());
        holder.mBinding.contentTextView.setText(TextColorUtils.changeTextColor(results.get(position).getWord(), results.get(position).getContent()));
        return convertView;
    }

    private static class ViewHolder {
        private ItemSearchResultBinding mBinding;
    }
}
