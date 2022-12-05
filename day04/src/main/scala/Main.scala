import scala.io.Source

object Main extends App {
  val filename = "input.txt"

  def findOverlap(lines: List[List[(Int, Int)]], callback: ((Int, Int), (Int, Int)) => Int) = {
    lines.map { line =>
      callback(line.head, line.last)
    }.sum
  }
  
  val lines: List[List[(Int, Int)]] = Source.fromResource(filename)
    .getLines()
    .toList
    .map{ line => 
      line
      .split(',')
      .toList
      .map { element => 
        element
        .split('-')
        .map(_.toInt)
        .toList match {
          case List(a, b) => (a, b)
        }
      }
    }
  
    val part1 = findOverlap(lines, (left: (Int, Int), right: (Int, Int)) => {
      if (left._1 <= right._1 && left._2 >= right._2) 1
      else if (right._1 <= left._1 && right._2 >= left._2) 1
      else 0 
    })

  println(s"Part 1: $part1")

  val part2 = findOverlap(lines, (left: (Int, Int), right: (Int, Int)) => {
    if ((left._2 >= right._1) && (left._1 <= right._2)) 1 else 0
  })

  println(s"Part 2: $part2")
}