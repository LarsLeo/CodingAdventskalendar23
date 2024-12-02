package org.example.web

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.example.config.ApplicationConfig

object RiddleService {
  private val defaultHeaders = mapOf("User-Token" to ApplicationConfig.USER_TOKEN)
  private val client =
    HttpClient(CIO) {
      install(DefaultRequest) {
        headers { defaultHeaders.forEach { (key, value) -> append(key, value) } }
      }
    }

  suspend fun getRiddle(day: String): String {
    val response: HttpResponse =
      client.get("${ApplicationConfig.BASE_URI}/riddle/$day") { headers { defaultHeaders } }

    return handleResponse(response)
  }

  suspend fun postSolution(day: String, solution: String): String {
    val response: HttpResponse =
      client.post("${ApplicationConfig.BASE_URI}/solution/$day") {
        contentType(ContentType.Application.Json)
        setBody(solution)
      }

    return handleResponse(response)
  }

  private suspend fun handleResponse(response: HttpResponse): String {
    return if (response.status.isSuccess()) {
      response.body<String>()
    } else {
      "Request failed: $response"
    }
  }
}
