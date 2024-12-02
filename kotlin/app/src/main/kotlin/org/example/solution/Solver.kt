package org.example.solution

import com.google.gson.Gson
import org.example.web.RiddleService

abstract class Solver(val gson: Gson = Gson()) {
  public abstract suspend fun solve(): String

  protected abstract fun getDay(): String

  protected suspend fun postSolution(solution: String): String =
    RiddleService.postSolution(getDay(), solution)
}
