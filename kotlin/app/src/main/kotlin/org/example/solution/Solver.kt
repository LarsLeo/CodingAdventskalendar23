package org.example.solution

import org.example.riddle.Riddle
import org.example.web.RiddleService

abstract class Solver(riddle: Riddle) {
  public abstract suspend fun solve(): String

  protected abstract fun getDay(): String

  protected suspend fun postSolution(solution: String): String =
    RiddleService.postSolution(getDay(), solution)
}
