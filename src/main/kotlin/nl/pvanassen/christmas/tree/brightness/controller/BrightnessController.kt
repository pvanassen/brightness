package nl.pvanassen.christmas.tree.brightness.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Maybe
import nl.pvanassen.christmas.tree.brightness.service.LuminosityService

@Controller("/brightness")
class BrightnessController(private val luminosityService: LuminosityService) {

    @Get("/")
    fun index(): Maybe<Int> {
        return luminosityService.getLuminosity()
    }
}