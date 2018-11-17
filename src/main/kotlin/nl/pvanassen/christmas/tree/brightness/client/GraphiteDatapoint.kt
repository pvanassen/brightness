package nl.pvanassen.christmas.tree.brightness.client

import java.time.LocalDateTime
import java.time.ZoneOffset

class GraphiteDatapoint(private val values: Array<String>) {

    fun getValue(): Float = values[0].toFloat()

    fun getTime(): LocalDateTime = LocalDateTime.ofEpochSecond(values[1].toLong(), 0, ZoneOffset.UTC)
}
