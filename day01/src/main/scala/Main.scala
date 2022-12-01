import scala.io.Source
import scala.collection.mutable.ListBuffer

object Main extends App {
  val filename = "input.txt"
  val lines = Source.fromResource(filename).getLines().toList
  
  var sum = 0;
  var max = 0;
  val elves_calories: ListBuffer[Int] = ListBuffer()
  for(line <- lines) {
    if ("".equals(line)) {
      elves_calories += sum;
      sum = 0;
    }
    else {
      sum += line.toInt
    }
  }

  val top1Calories = elves_calories.sortWith((_ > _)).take(1).sum
  val top3Calories = elves_calories.sortWith((_ > _)).take(3).sum

  println(s"Most Calories a single elf is carrying: ${top1Calories}")
  println(s"Calories top three elves are carrying: ${top3Calories}")
}