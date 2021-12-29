package io.github.playground

object ViewExample extends App {

  // without views

  val startingAt = System.currentTimeMillis()

  val result = (1 to 1000000000).view.filter(_ % 2 == 0).take(10).toList

  println(result)

  val finishingAt = System.currentTimeMillis()

  println(s"Processing using views took: ${finishingAt - startingAt} ms")

  // using views

  val withViewsStartingAt = System.currentTimeMillis()

  val withViews = (1 to 1000000000).view.filter(_ % 2 == 0).take(10).toList

  println(withViews)

  val withViewsFinishingAt = System.currentTimeMillis()

  println(s"Processing using views took: ${withViewsFinishingAt - withViewsStartingAt} ms")

}
