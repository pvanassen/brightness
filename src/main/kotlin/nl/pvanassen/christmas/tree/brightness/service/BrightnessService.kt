package nl.pvanassen.christmas.tree.brightness.service

import io.reactivex.Maybe
import javax.inject.Singleton

@Singleton
class BrightnessService(private val luminosityService: LuminosityService) {
    companion object {
        private const val MIN_BRIGHTNESS = 0.3f
        private const val MID_BRIGHTNESS = 0.55f
        private const val MAX_BRIGHTNESS = 0.8f
    }

    fun getBrightness(): Maybe<Float> =
        luminosityService.getLuminosity()
                .map { mapLuminosityToBrightness(it) }


    private fun mapLuminosityToBrightness(luminosity: Int) =
        when {
            luminosity < 3 -> MIN_BRIGHTNESS
            luminosity < 8 -> MID_BRIGHTNESS
            else -> MAX_BRIGHTNESS
        }
}