package com.patriespert.horoscapp.domain

import com.patriespert.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}