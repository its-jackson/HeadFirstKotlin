package chapter04

class Song(val title: String, val artist: String) {
    fun play(): Unit = println("Playing the song $title by $artist")

    fun stop(): Unit = println("Stopped playing $title")
}