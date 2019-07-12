package com.v2share.too

import android.content.res.ColorStateList
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.TypedValue
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.transaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.v2share.too.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity() {
    internal lateinit var fragmentManager: FragmentManager
    internal lateinit var homeFragment: HomeFragment;
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    /**
     * 初始化底部导航栏
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun initNavigationView() {
        supportFragmentManager.transaction(allowStateLoss = true) {
            replace(R.id.content_view, homeFragment)
        }


//        fragmentManager = supportFragmentManager //获取 fragment 管理器
//        val fragmentTransaction = fragmentManager.beginTransaction() //获得 Fragment 事务处理器
//        homeFragment = HomeFragment() //把主页 new 出来
//        fragmentTransaction.replace(R.id.content_view, homeFragment) //加载fragment
//        fragmentTransaction.commit()//提交加载操作


        val states = arrayOf(intArrayOf(-android.R.attr.state_checked), intArrayOf(android.R.attr.state_checked))
        val colors = intArrayOf(resources.getColor(R.color.color_gray_d9d9d9,null), resources.getColor(R.color.colorPrimary,null))
        val csl = ColorStateList(states, colors)


        fragmentco
        bottomNavigationView.setItemTextColor(csl)
        bottomNavigationView.setItemIconTintList(null)
        //

        //   bottomNavigationView.setItemIconTintList(null);
        nav_view.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener() {
            fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                navToFragment(fragmentManager.beginTransaction(), item.itemId)
                return true
            }
        })

        val iconSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f, resources.displayMetrics).toInt()
        setImageSize(bottomNavigationView, iconSize, iconSize)

    }

}
