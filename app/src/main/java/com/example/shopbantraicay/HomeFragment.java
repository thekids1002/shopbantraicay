package com.example.shopbantraicay;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ProductAdapter.ProductClickListener {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        // Initialize and set up fake product data
        List<Product> productList = getFakeProductList();
        recyclerView.setAdapter(new ProductAdapter(productList, this));
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


    @Override
    public void onProductClick(Product product) {
        Intent intent = new Intent(requireContext(), DetailProduct.class);
        intent.putExtra("PRODUCT", product);
        startActivity(intent);
    }
}