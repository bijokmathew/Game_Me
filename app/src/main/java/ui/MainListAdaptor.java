package ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class MainListAdaptor extends BaseAdapter {

    List<Integer> mImageIds;
    Context mContext;

    public MainListAdaptor(List<Integer> mImageIds, Context mContext) {
        this.mImageIds = mImageIds;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView mImageView;
        if(view == null){
            mImageView = new ImageView(mContext);
            mImageView.setAdjustViewBounds(true);
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setPadding(8,8,8,8);
        } else {
            mImageView = (ImageView) view;
        }
        mImageView.setImageResource(mImageIds.get(i));
        return mImageView;
    }
}
