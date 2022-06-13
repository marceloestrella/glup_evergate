package mx.heineken.glup.Adapter;

import android.content.Context;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import mx.heineken.glup.Models.ProductModel;
import mx.heineken.glup.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    public interface AdapterCallback{
        void onItemClicked(ProductModel model);
    }

    private final List<ProductModel> items;
    private AdapterCallback callback;

    public ProductAdapter(List<ProductModel> items, AdapterCallback callback) {
        this.items = items;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_product, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        ProductModel item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public ProductViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_product_name);
            tvName.setOnClickListener(v -> {
                if(callback != null) {
                    int position = getAdapterPosition();
                    tvName.setTextColor(Color.parseColor("#FF0000"));
                    callback.onItemClicked(items.get(position));
                }
            });
        }

        public void bind(ProductModel itm) {
            tvName.setText(itm.getName());
        }
    }
}