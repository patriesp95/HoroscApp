package com.patriespert.horoscapp.data

import android.util.Log
import com.patriespert.horoscapp.data.network.HoroscopeApiService
import com.patriespert.horoscapp.domain.Repository
import com.patriespert.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository{
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("aris", "Ha ocurrido un error ${it.message}") }
        return null
    }
}