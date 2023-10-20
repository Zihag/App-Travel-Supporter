package com.example.travelsupport.module.screen.homescreen.explorebuilding

import android.graphics.Bitmap
import com.example.travelsupport.module.screen.homescreen.explorebuilding.Classification

interface LandmarkClassifier {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}