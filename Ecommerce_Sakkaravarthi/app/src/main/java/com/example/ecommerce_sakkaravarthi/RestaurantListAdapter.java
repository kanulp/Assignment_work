package com.example.ecommerce_sakkaravarthi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
    private ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    private Context mContext;

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> restaurants) {
        mContext = context;
        mRestaurants = restaurants;
    }

    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant_list, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(mRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ImageView mRestaurantImageView;
        TextView mNameTextView;
        TextView mCategoryTextView;
        TextView mRatingTextView;



        private Context mContext;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            mNameTextView = itemView.findViewById(R.id.restaurantName);
            mCategoryTextView = itemView.findViewById(R.id.categoryName);
            mRatingTextView = itemView.findViewById(R.id.ratingText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext,FoodMenuGridActivity.class);
                    mContext.startActivity(intent);
                }
            });

        }

        public void bindRestaurant(Restaurant restaurant) {
            mNameTextView.setText(restaurant.getName());
            mCategoryTextView.setText(restaurant.getCategories());
            mRatingTextView.setText("Rating: " + restaurant.getRatings() + "/5");
        }
    }
}
