package nl.pvanassen.christmas.tree.brightness

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("nl.pvanassen.christmas.tree.brightness")
                .mainClass(Application.javaClass)
                .start()
    }
}