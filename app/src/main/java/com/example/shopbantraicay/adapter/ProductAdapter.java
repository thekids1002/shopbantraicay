package com.example.shopbantraicay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopbantraicay.models.Product;
import com.example.shopbantraicay.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    public ProductAdapter(List<Product> productList, ProductClickListener listener) {
        this.productList = productList;
        this.productClickListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    public interface ProductClickListener {
        void onProductClick(Product product);
    }
    private ProductClickListener productClickListener;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        // Bind product data to ViewHolder
        holder.bind(product);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productClickListener != null) {
                    productClickListener.onProductClick(product);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Declare your views for a product item (e.g., ImageView, TextViews)
        private ImageView productImageView;
        private TextView productNameTextView;
        private TextView productPriceTextView;
        private TextView productDecriptitn;
        private Button btnAddCart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImageView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            btnAddCart = itemView.findViewById(R.id.addProductToCard);

            btnAddCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(btnAddCart.getContext(), "Thêm thành công vào giỏ hàng", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(Product product) {

            Picasso.get().load(product.getImage()).fit().into(productImageView);
            productNameTextView.setText(product.getName());
            productPriceTextView.setText("$" + String.valueOf(product.getPrice()));
        }
    }
}