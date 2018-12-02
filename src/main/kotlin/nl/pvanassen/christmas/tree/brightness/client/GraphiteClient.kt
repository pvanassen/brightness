package nl.pvanassen.christmas.tree.brightness.client

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("\${app.graphite.server}")
interface GraphiteClient {

    @Get("/render?target=summarize({target},'5min','avg')&format=json&from=-5min")
    fun getLuminosity(target: String): Single<String>
}