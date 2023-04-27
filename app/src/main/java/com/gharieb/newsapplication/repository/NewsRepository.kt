package com.gharieb.newsapplication.repository

import com.gharieb.newsapplication.api.RetrofitInstance
import com.gharieb.newsapplication.database.ArticleDatabase
import com.gharieb.newsapplication.models.Article

class NewsRepository(
    val database :ArticleDatabase
    ) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) =
        database.getArticleDao().upsert(article)

    fun getSavedNews() = database.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) =
        database.getArticleDao().deleteArticle(article)
}