package com.shopping.processor

class ShoppingCart {

  var APPLE = new FruitType("APPLE", 0.6)
  var ORANGE = new FruitType("ORANGE", 0.25)

  /**
    * This method will counts the number of fruits applies price and adds them up.
    *
    * @param fruits
    * @return
    */
  def checkout(fruits: List[String]): Double = {

    val applesPrice = calculatePrice(fruits, APPLE.name, APPLE.price)(offer2for1);
    val orangesPrice = calculatePrice(fruits, ORANGE.name,ORANGE.price)(offer3for2);
    applesPrice + orangesPrice
  }

  /**
    * This methods counts the number of fruits of particular type and then apply the associated offer
    * Note: Offer has been passed as a function
    * @param listOfFruits
    * @param fruit
    * @param price
    * @param applyOffer
    * @return
    */
  private def calculatePrice(listOfFruits: List[String], fruit: String, price: Double)(applyOffer: Int => Int): Double = {
    applyOffer(count(listOfFruits, fruit)) * price
  }

  private def count(fruits: List[String], fruit: String): Int = {
    fruits.filter(_.equalsIgnoreCase(fruit)).length
  }

  private def offer3for2(count: Int): Int = {
    if (count % 3 == 0) count * 2 / 3 else (count % 3) + (count - count % 3) * 2 / 3
  }

  private def offer2for1(count: Int): Int = {
    if (count % 2 == 0) count / 2 else (count / 2) + 1
  }

}


case class FruitType(name: String, price: Double)