package com.android.example.podomarket.ui.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivitySearchBinding
import com.android.example.podomarket.ui.search.SearchPageConst.AFTER_SEARCH
import com.android.example.podomarket.ui.search.SearchPageConst.BEFORE_SEARCH


class SearchActivity : AppCompatActivity() {

    private val binding: ActivitySearchBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_search
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
            }
            pager.setCurrentItem(BEFORE_SEARCH, false)
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    pager.setCurrentItem(AFTER_SEARCH, false)
                    // (미완) ViewModel의 LiveData를 이용해서 AfterSearchFragment에 현재 선택된 Fragment Position과 검색어 넘기기
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    // (미완) 추천 검색어 기능 : RelatedSearchFragment
                    return true
                }
            })
            searchView.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && (searchView.query.isBlank()||searchView.query.isEmpty()) ) {
                    // (미완) 최근 검색 기록 기능 : RecentSearchFragment
                }
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, SearchActivity::class.java)
    }
}