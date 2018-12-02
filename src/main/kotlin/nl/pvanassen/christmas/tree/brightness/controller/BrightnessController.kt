package nl.pvanassen.christmas.tree.brightness.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.tracing.annotation.ContinueSpan
import io.reactivex.Maybe
import nl.pvanassen.christmas.tree.brightness.service.BrightnessService

@Controller("/brightness")
open class BrightnessController(private val brightnessService: BrightnessService) {

    @Get
    @ContinueSpan
    open fun index(): Maybe<Float> {
        return brightnessService.getBrightness()
    }
}