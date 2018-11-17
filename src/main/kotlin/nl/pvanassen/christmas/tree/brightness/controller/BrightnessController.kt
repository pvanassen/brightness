package nl.pvanassen.christmas.tree.brightness.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Maybe
import nl.pvanassen.christmas.tree.brightness.service.BrightnessService

@Controller("/brightness")
class BrightnessController(private val brightnessService: BrightnessService) {

    @Get("/")
    fun index(): Maybe<Float> {
        return brightnessService.getBrightness()
    }
}