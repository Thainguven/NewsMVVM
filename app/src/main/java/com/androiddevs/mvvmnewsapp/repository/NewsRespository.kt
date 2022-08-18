package com.androiddevs.mvvmnewsapp.repository

import androidx.room.Query
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.database.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

class NewsRespository(
    val database: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)


    suspend fun upsert(artile: Article) = database.getArticleDao().upsert(artile)

    fun getSaveNews() = database.getArticleDao().getAllArticle()

    suspend fun deleteArticle(article: Article) = database.getArticleDao().deleteArticle(article)
}