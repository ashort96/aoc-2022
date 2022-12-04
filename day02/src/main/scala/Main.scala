import scala.io.Source

// Rock  - A, X
// Paper - B, Y
// Scissors - C, Z
object Main extends App {
  val filename = "input.txt"
  val lines: List[List[String]] = Source.fromResource(filename)
    .getLines()
    .map(_.split(" "))
    .map(arr => List(arr(0), arr(1)))
    .toList

  var sum = 0;

  for (line: List[String] <- lines) {
    val result = line match {
      case "A" :: _ => evaluateRockPart1(line.last)
      case "B" :: _ => evaluatePaperPart1(line.last)
      case "C" :: _ => evaluateScissorsPart1(line.last)
    }
    sum += result
  }

  println(s"Part 1: $sum")

  sum = 0

  for (line: List[String] <- lines) {
    val result = line match {
      case "A" :: _ => evaluateRockPart2(line.last)
      case "B" :: _ => evaluatePaperPart2(line.last)
      case "C" :: _ => evaluateScissorsPart2(line.last)
    }
    sum += result
  }

  println(s"Part 2: $sum")


  def evaluateRockPart1(me: String): Int = {
    me match {
      case "X" =>
        1 + 3
      case "Y" =>
        2 + 6
      case "Z" =>
        3 + 0
    }
  }

  def evaluatePaperPart1(me: String): Int = {
    me match {
      case "X" =>
        1 + 0
      case "Y" =>
        2 + 3
      case "Z" =>
        3 + 6
    }
  }

  def evaluateScissorsPart1(me: String): Int = {
    me match {
      case "X" =>
        1 + 6
      case "Y" =>
        2 + 0
      case "Z" =>
        3 + 3
    }
  }

  def evaluateRockPart2(me: String): Int = {
    me match {
      case "X" => 3 + 0
      case "Y" => 1 + 3
      case "Z" => 2 + 6
    }
  }
  
  def evaluatePaperPart2(me: String): Int = {
    me match {
      case "X" => 1 + 0
      case "Y" => 2 + 3
      case "Z" => 3 + 6
    }
  }

  def evaluateScissorsPart2(me: String): Int = {
    me match {
      case "X" => 2 + 0
      case "Y" => 3 + 3
      case "Z" => 1 + 6
    }
  }

}