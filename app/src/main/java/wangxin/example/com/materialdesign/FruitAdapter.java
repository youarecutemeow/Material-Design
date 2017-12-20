package wangxin.example.com.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by wangxin on 17-12-7.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    private Context mContext;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView mCardView;
        ImageView mImageView;
        TextView mTextView;
        public ViewHolder(View view) {
            super(view);
            mCardView = (CardView)view;
            mImageView = (ImageView)view.findViewById(R.id.fruit_image);
            mTextView = (TextView)view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> list){
        mFruitList = list;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.mTextView.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.mImageView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_ietm,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitList.get(pos);
                Intent intent = new Intent(mContext,FruitActivity.class);
                intent.putExtra(FruitActivity.FRUITE_NAME,fruit.getName());
                intent.putExtra(FruitActivity.FRUITE_IMAGE_ID,fruit.getImageId());
                mContext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
