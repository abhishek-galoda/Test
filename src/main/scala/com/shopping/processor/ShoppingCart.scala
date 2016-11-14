package com.shopping.processor

class ShoppingCart {

  var APPLE = new FruitType("APPLE", 0.6)
  var ORANGE = new FruitType("ORANGE", 0.25)

  /**
    * This method will calculate the total price for Apple and Oranges in shopping cart, after applying offer.
    * @param fruits
    * @return Total price of Apples and Oranges after applied offer
    */
  def checkout(fruits: List[String]): Double = {
    val applesPrice = calculatePrice(fruits, APPLE.name, APPLE.price)(_);
    val orangesPrice = calculatePrice(fruits, ORANGE.name, ORANGE.price)(_);
    applesPrice(offer2for1) + orangesPrice(offer3for2)
  }

  /** This methods counts the number of fruits of particular type and then applies the associated offer
    * Note: Offer is a function which has been passed as a parameter
    * @param listOfFruits
    * @param fruit
    * @param price
    * @param applyOffer
    * @return Price of Fruit type passed after applying offer
    */
  private def calculatePrice(listOfFruits: List[String], fruit: String, price: Double)(applyOffer: Int => Int): Double = {
    val fruitCount = listOfFruits.filter(_.equalsIgnoreCase(fruit)).length
    applyOffer(fruitCount) * price
  }

  private def offer3for2(count: Int): Int = {
    if (count % 3 == 0) count * 2 / 3 else (count % 3) + (count - count % 3) * 2 / 3
  }

  private def offer2for1(count: Int): Int = {
    if (count % 2 == 0) count / 2 else (count / 2) + 1
  }

}


case class FruitType(name: String, price: Double)