package nl.pvanassen.christmas.tree.brightness.service

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import io.reactivex.Single
import nl.pvanassen.christmas.tree.brightness.client.GraphiteClient
import nl.pvanassen.christmas.tree.brightness.client.GraphiteDatapoint
import nl.pvanassen.christmas.tree.brightness.client.GraphiteResponse
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object LuminosityServiceSpec: Spek({
   describe("Graphite service test") {
       val graphiteClient = object : GraphiteClient {
           override fun getLuminosity(target: String): Single<GraphiteResponse> {
               val datapoint1 = GraphiteDatapoint(arrayOf("12", "12345"))
               val datapoint2 = GraphiteDatapoint(arrayOf("14", "12347"))
               val datapoint3 = GraphiteDatapoint(arrayOf("-1", "12340"))
               return Single.just(GraphiteResponse("target", listOf(datapoint1, datapoint2, datapoint3)))
           }
       }
       val graphiteService = LuminosityService(graphiteClient, "target")

       it("Expect 12347 as result") {
           val result = graphiteService.getLuminosity()
           assert(result.blockingGet()).isNotNull()
           assert(result.blockingGet()).isEqualTo(14)
       }
   }
})