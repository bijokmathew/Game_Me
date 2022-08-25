package ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bkm.game_me.R;

import java.util.ArrayList;
import java.util.List;

import data.GameMeImageAssets;

public class BodyPartFragment extends Fragment {

    private static final String TAG = "Bodypart Fragment";
    private List<Integer> mImageResourceId;
    private int mIndex;
    public static final String IMAGE_ID = "image id";
    public static final String IMAGE_LIST = "image list";

    //private onClick
    public BodyPartFragment() {
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(IMAGE_ID, mIndex);
        outState.putIntegerArrayList(IMAGE_LIST, (ArrayList<Integer>) mImageResourceId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = rootView.findViewById(R.id.body_part_image_view);
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(IMAGE_ID);
            mImageResourceId = savedInstanceState.getIntegerArrayList(IMAGE_LIST);
        }
        if (mImageResourceId != null) {
            imageView.setImageResource(mImageResourceId.get(mIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mIndex < mImageResourceId.size() - 1) {
                        mIndex++;
                    } else {
                        mIndex = 0;
                    }
                    imageView.setImageResource(mImageResourceId.get(mIndex));
                }
            });
        } else {
            Log.v(TAG, "This fragment has null list of image");
        }
        return rootView;
    }

    public void setmImageResourceId(List<Integer> mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    public void setmIndex(int mIndex) {
        this.mIndex = mIndex;
    }
}
