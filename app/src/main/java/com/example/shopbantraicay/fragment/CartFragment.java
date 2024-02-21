package com.example.shopbantraicay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopbantraicay.adapter.CartItemAdapter;
import com.example.shopbantraicay.models.Product;
import com.example.shopbantraicay.R;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private RecyclerView cartRecyclerView;
    private List<Product> cartItemList;
    private CartItemAdapter cartItemAdapter;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        // Initialize cartRecyclerView and cartItemList
        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);
        cartItemList = getFakeProductList();
        cartItemAdapter = new CartItemAdapter(cartItemList);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        cartRecyclerView.setAdapter(cartItemAdapter);

        // Example: Set up click listener for the checkout button
        Button checkoutButton = view.findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Thanh toán thành công", Toast.LENGTH_SHORT).show();
                
            }
        });

        return view;
    }

    private List<Product> getFakeProductList() {
        List<Product> fakeProducts = new ArrayList<>();

        fakeProducts.add(
                new Product(1,"https://www.vinmec.com/s3-images/20210419_031329_240031_qua-thanh-long.max-800x800.jpg",
                        "Trái thanh long",
                        19.99,
                        "Quả thanh long là loại quả mọng, hình bầu dục có nhiều tai lá xanh (do phiến hoa còn lại), đầu quả lõm sâu thành một hốc. Khi còn non vỏ quả màu xanh, khi chín chuyển màu đỏ hồng. Thịt quả phần lớn màu trắng, một số ít giống có ruột vàng hoặc đỏ. vỏ có thể bóc khá dễ dàng khỏi ruột."));
        fakeProducts.add(new Product(2,"https://vfa.gov.vn/storage/upload/qua-cam-1.jpg",
                "Trái cam",
                15.99,
                "Quả cam có rất nhiều múi, thường có từ mười đến mười hai múi to đều nhau. Bên trong mỗi múi cam chính là những tép cam tươi, mọng nước và có vị ngọt dịu nhẹ"));

        fakeProducts.add( new Product(3,"https://vtv1.mediacdn.vn/Uploaded/nguyetmai/2013_03_29/apples_00412559.jpg",
                "Trái táo",
                19.99,
                "Quả cam có rất nhiều múi, thường có từ mười đến mười hai múi to đều nhau. Bên trong mỗi múi cam chính là những tép cam tươi, mọng nước và có vị ngọt dịu nhẹ"));


        return fakeProducts;
    }
}
