package nl.pvanassen.christmas.tree.brightness

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("nl.pvanassen.christmas.tree.brightness.client",
                        "nl.pvanassen.christmas.tree.brightness.controller",
                        "nl.pvanassen.christmas.tree.brightness.service")
                .mainClass(Application.javaClass)
                .start()
    }
}