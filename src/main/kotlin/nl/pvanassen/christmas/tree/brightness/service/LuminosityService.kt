package nl.pvanassen.christmas.tree.brightness.service

import io.micronaut.context.annotation.Property
import io.reactivex.Maybe
import io.reactivex.Observable
import nl.pvanassen.christmas.tree.brightness.client.GraphiteClient
import java.time.ZoneOffset
import javax.inject.Singleton

@Singleton
class LuminosityService(private val graphiteClient: GraphiteClient,
                        @Property(name = "app.graphite.luminosity.target") val target:String) {

    fun getLuminosity(): Maybe<Int> {
        return graphiteClient.getLuminosity(target)
                .map { response -> response.datapoints }
                .toObservable()
                .flatMap { list -> Observable.fromIterable(list) }
                .sorted { datapoint1, datapoint2 -> (datapoint2.getTime().toEpochSecond(ZoneOffset.UTC) - datapoint1.getTime().toEpochSecond(ZoneOffset.UTC)).toInt() }
                .map { datapoint -> datapoint.getValue() }
                .firstElement()
                .map { value -> value.toInt() }
    }

}