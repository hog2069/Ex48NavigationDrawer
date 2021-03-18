package com.hog2020.ex48navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.layout_drawer);

        navigationView=findViewById(R.id.nav);
        //item icon 색조를 적용하지 않음, 설정안하면 기본 회색계열 틴튼
        navigationView.setItemIconTintList(null);

        //네이비게이션 뷰의 아이템을 선택했을때 반응하는 리스너
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_gallery:
                        Toast.makeText(MainActivity.this, "gallery", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_far:
                        Toast.makeText(MainActivity.this, "far", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_simple:
                        Toast.makeText(MainActivity.this, "simple", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_2:
                        Toast.makeText(MainActivity.this, "menu2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_3:
                        Toast.makeText(MainActivity.this, "menu3", Toast.LENGTH_SHORT).show();
                        break;
                }

                //Drawer 닫기
                drawerLayout.closeDrawer(navigationView);

                return false;
            }
        });

        //드로우어 조절용 토글버튼 생성
        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.appbar_scrolling_view_behavior);
        //액션바의 홈 업 버튼의 위치에 아이콘이 보이게끔
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //삼선아이콘 모양으로 보이도록 토글버튼의 동기 맞추기
        drawerToggle.syncState();

        //삼선아이콘과 화살표아이콘이 자동으로 변환되도록
        drawerLayout.addDrawerListener(drawerToggle);

    }

    //액션바의메뉴를 클릭하는 이벤트를 듣는 메소드
    //클릭 상황을 토글버튼에게 인지하도록 전달달
   @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        drawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}