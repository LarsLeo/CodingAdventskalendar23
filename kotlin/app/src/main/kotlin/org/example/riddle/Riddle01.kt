package org.example.riddle

class Riddle01 : Riddle() {
  override fun getLink(): String =
    "https://codingchallengestorage.z6.web.core.windows.net/01_50HMS.png"

  override fun getDay(): String = "01"

  suspend fun getRiddleData(): List<Riddle01Data> =
    gson.fromJson(getRiddle(), Array<Riddle01Data>::class.java).toList()
}

data class Riddle01Data(val value: Int, val currentFormat: String, val targetFormat: String)
