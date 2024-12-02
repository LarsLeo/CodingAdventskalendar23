package org.example.solution

import org.example.riddle.Riddle01
import org.example.riddle.Riddle01Data

class Solver01(private val riddle: Riddle01) : Solver(riddle) {
  override fun getDay(): String = "01"

  /**
   * [ { "value" : 120, "currentFormat" : "DAY", "targetFormat" : "MINUTE" }, { "value" : 2073600,
   * "currentFormat" : "SECOND", "targetFormat" : "DAY" }, { "value" : 12, "currentFormat" : "HOUR",
   * "targetFormat" : "SECOND" }, { "value" : 121440, "currentFormat" : "MINUTE", "targetFormat" :
   * "HOUR" } ]
   */
  override suspend fun solve(): String {
    val solution =
      riddle
        .getRiddleData()
        .map(::convertRiddleData)
        .joinToString(separator = ", ", prefix = "[", postfix = "]")

    // Uncomment to post the solution to the API ;)
    //  return postSolution(solution)
    return solution
  }

  private fun convertRiddleData(riddleData: Riddle01Data): Int {
    val currentFormatFactor = getConversionFactor(riddleData.currentFormat)
    val targetFormatFactor = getConversionFactor(riddleData.targetFormat)

    return (riddleData.value * currentFormatFactor) / targetFormatFactor
  }

  private fun getConversionFactor(format: String): Int {
    return when (format) {
      "SECOND" -> 1
      "MINUTE" -> 60
      "HOUR" -> 3600
      "DAY" -> 86400
      else -> throw IllegalArgumentException("Invalid currentFormat: $format")
    }
  }
}
