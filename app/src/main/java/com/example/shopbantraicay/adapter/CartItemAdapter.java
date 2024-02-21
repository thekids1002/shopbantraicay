package com.example.shopbantraicay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopbantraicay.models.Product;
import com.example.shopbantraicay.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {

    private List<Product> cartItemList;

    public CartItemAdapter(List<Product> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product cartItem = cartItemList.get(position);
        holder.bind(cartItem);
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkCart;
        private ImageView imgCart;
        private TextView txtTitleCart;
        private TextView txtGiaCart;
        private Button btnPlusItem;
        private TextView txtSlCart;
        private Button btnSubItem;
        private Button btnRemoveItemCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkCart = itemView.findViewById(R.id.checkCart);
            imgCart = itemView.findViewById(R.id.imgCart);
            txtTitleCart = itemView.findViewById(R.id.txtTileCart);
            txtGiaCart = itemView.findViewById(R.id.txtGiaCart);
            btnPlusItem = itemView.findViewById(R.id.btnPlusItem);
            txtSlCart = itemView.findViewById(R.id.txtSlCart);
            btnSubItem = itemView.findViewById(R.id.btnSubItem);
            btnRemoveItemCart = itemView.findViewById(R.id.btnRemoveItemCart);
        }

        public void bind(Product cartItem) {
            Picasso.get().load(cartItem.getImage()).fit().into(imgCart) ;
            txtTitleCart.setText(cartItem.getName());
            txtGiaCart.setText("đ " + cartItem.getPrice());
           // txtSlCart.setText(String.valueOf(cartItem.getQuanity()));//
            txtSlCart.setText("99");
        }
    }
}
