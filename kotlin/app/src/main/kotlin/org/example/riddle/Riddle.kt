package org.example.riddle

import com.google.gson.Gson
import org.example.web.RiddleService

abstract class Riddle(val gson: Gson = Gson()) {
  abstract fun getLink(): String

  protected abstract fun getDay(): String

  protected suspend fun getRiddle(): String = RiddleService.getRiddle(getDay())
}
