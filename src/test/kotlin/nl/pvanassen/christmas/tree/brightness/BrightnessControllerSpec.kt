package nl.pvanassen.christmas.tree.brightness

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals


object BrightnessControllerSpec:Spek({
    describe("BrightnessController Suite") {
        val embeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        val client = HttpClient.create(embeddedServer.url)

        it("test /brightness responds Hello World") {
            val rsp = client.toBlocking().retrieve("/brightness")
            assertEquals(rsp, "Hello World")
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})