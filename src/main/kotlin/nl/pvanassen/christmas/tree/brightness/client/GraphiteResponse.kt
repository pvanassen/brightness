package nl.pvanassen.christmas.tree.brightness.client

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class GraphiteResponse @JsonCreator internal constructor(@JsonProperty("target") val target: String,
                                                         @JsonProperty("datapoints") val datapoints: Array<Array<String>>) {

    fun getGraphiteDatapoints() = datapoints.map {GraphiteDatapoint(it)}
}
