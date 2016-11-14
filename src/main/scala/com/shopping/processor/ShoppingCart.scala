package com.shopping.processor

class ShoppingCart {

  var APPLES = new FruitType("APPLE",0.6)
  var ORANGES =new FruitType("ORANGE",0.25)

  /**
    * This method will counts the number of fruits applies price and adds them up.
    *
    * @param fruits
    * @return
    */
  def checkout(fruits: List[String]): Double = {

    val applesPrice = count(fruits, APPLES.name) * APPLES.price
    val orangesPrice = count(fruits,ORANGES.name)* ORANGES.price

    applesPrice + orangesPrice
  }

  /**This method will count the fruits of certain type
    *
    * @param fruits
    * @param fruit
    * @return
    */
  private def count(fruits: List[String], fruit: String): Int = {
    fruits.filter(_.equalsIgnoreCase(fruit)).length
  }


  case class FruitType(name: String, price:Double)


}
