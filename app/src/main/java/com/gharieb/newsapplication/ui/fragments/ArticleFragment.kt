package com.gharieb.newsapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gharieb.newsapplication.ui.NewsActivity
import com.gharieb.newsapplication.ui.NewsViewModel
import com.gharieb.newsapplication.R
import com.gharieb.newsapplication.databinding.FragmentArticleBinding
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    private lateinit var binding: FragmentArticleBinding
    lateinit var viewModel: NewsViewModel
    lateinit var webView: View
    val args:ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentArticleBinding.bind(view)
        val article = args.article

        viewModel = (activity as NewsActivity).viewModel
        binding.apply {
            webView.apply {
                webViewClient = WebViewClient()
                article.url?.let { loadUrl(it) }
            }

            fab.setOnClickListener {
                viewModel.savedArticle(article)
                Snackbar.make(view,"Article saved successfully",Snackbar.LENGTH_SHORT).show()
            }
        }


    }
}