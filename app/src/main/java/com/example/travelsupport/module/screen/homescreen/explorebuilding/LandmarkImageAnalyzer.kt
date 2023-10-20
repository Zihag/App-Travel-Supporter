package com.example.travelsupport.module.screen.homescreen.explorebuilding

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.travelsupport.module.screen.homescreen.explorebuilding.centerCrop
import com.example.travelsupport.module.screen.homescreen.explorebuilding.Classification
import com.example.travelsupport.module.screen.homescreen.explorebuilding.LandmarkClassifier

class LandmarkImageAnalyzer(
    private val classifier: LandmarkClassifier,
    private val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % 60 == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(321, 321)

            val results = classifier.classify(bitmap, rotationDegrees)
            onResults(results)
        }
        frameSkipCounter++

        image.close()
    }
}