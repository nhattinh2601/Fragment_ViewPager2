package com.example.tablayout_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.tablayout_new.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPagerAdapter mAdapter;
    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;


    // Khai báo thêm để có thể click vào từng title nào thì có thể hiển thị được nội dung của phần title đó, còn trước đó thì chí có thể lướt qua lướt lại
    private int[] mTabTitle = new int[] {R.string.tab_clock_title,R.string.tab_login_title};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo bộ chuyển đổi (adapter)
        mAdapter = new ViewPagerAdapter(this);

        // tham chiếu đến các thành phần của file activity_main.xml
        mViewPager2 = findViewById(R.id.viewPager2);    // là ID của ViewPager2 đã thêm vào trong file giao diện activity_main
        mTabLayout = findViewById(R.id.tabLayout);      // là ID của TabLayout ...

        /*tạo 1 cái đường dẫn (sợi dây) để kết nối (và chuyển đổi) giữa cái object1 (cái thùng chứa mấy cái fragment) và
        * object2 (cái ViewPager2: cái dùng để lướt lướt qua lại)  */
        mViewPager2.setAdapter(mAdapter);


        //thay đổi nội dung khi click vào từng title
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(MainActivity.this.getResources().getString(mTabTitle[position]));
            } // trong cái mảng title thì thứ tự phần tử tương tự như thứ tự trong các Fragment cho nên dựa vào position đó để hiển thị cho đúng nội dung bên trong
        }).attach();
    }
}