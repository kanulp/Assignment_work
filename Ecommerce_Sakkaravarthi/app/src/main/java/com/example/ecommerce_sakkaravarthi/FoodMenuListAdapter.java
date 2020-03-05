package com.example.ecommerce_sakkaravarthi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FoodMenuListAdapter extends RecyclerView.Adapter<FoodMenuListAdapter.FoodViewHolder> {
    private ArrayList<FoodMenu> foodMenuArrayList = new ArrayList<>();
    private Context mContext;

    public FoodMenuListAdapter(Context context, ArrayList<FoodMenu> restaurants) {
        mContext = context;
        foodMenuArrayList = restaurants;
    }

    @Override
    public FoodMenuListAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_list, parent, false);
        FoodViewHolder viewHolder = new FoodViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodMenuListAdapter.FoodViewHolder holder, int position) {
        holder.bindRestaurant(foodMenuArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return foodMenuArrayList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView foodName;
        TextView foodPrice;

        private Context mContext;

        public FoodViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            foodName = itemView.findViewById(R.id.food_name);
            foodPrice = itemView.findViewById(R.id.food_price);

        }

        public void bindRestaurant(FoodMenu foodMenu) {
            foodName.setText(foodMenu.getName());
            foodPrice.setText("$ "+foodMenu.getPrice());
        }
    }
}
