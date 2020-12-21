package com.getbux.assignment

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter




fun main(args: Array<String>): Unit = io.ktor.server.cio.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/amsterdam") {
            call.respondHtml {
                head {
                    title { +"What time is it?" }
                }
                body {
                    h1 { +"It's ${currentTime("Europe/Amsterdam")} in Amsterdam"}
                }
            }
        }

        get("/london") {
            call.respondHtml {
                head {
                    title { +"What time is it?" }
                }
                body {
                    h1 { +"It's ${currentTime("Europe/London")} in London"}
                }
            }
        }
    }
}

fun currentTime(where: String): String {
    return Instant.now()
        .atZone(ZoneId.of(where))
        .format(DateTimeFormatter.ofPattern("HH:mm:ss"))
}
