package nl.pvanassen.christmas.tree.brightness.service

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.context.annotation.Property
import io.reactivex.Maybe
import io.reactivex.Observable
import nl.pvanassen.christmas.tree.brightness.client.GraphiteClient
import nl.pvanassen.christmas.tree.brightness.client.GraphiteResponse
import java.time.ZoneOffset
import javax.inject.Singleton

@Singleton
class LuminosityService(private val graphiteClient: GraphiteClient,
                        @Property(name = "app.graphite.luminosity.target") val target:String) {

    fun getLuminosity(): Maybe<Int> {
        val objectMapper = ObjectMapper()
        return graphiteClient.getLuminosity(target)
                .map {objectMapper.readValue(it, Array<GraphiteResponse>::class.java)}
                .map { response -> response[0].getGraphiteDatapoints() }
                .toObservable()
                .flatMap { list -> Observable.fromIterable(list) }
                .sorted { datapoint1, datapoint2 -> (datapoint2.getTime().toEpochSecond(ZoneOffset.UTC) - datapoint1.getTime().toEpochSecond(ZoneOffset.UTC)).toInt() }
                .map { datapoint -> datapoint.getValue() }
                .firstElement()
                .map { value -> value.toInt() }
    }

}