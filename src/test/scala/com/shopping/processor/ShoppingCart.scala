package com.shopping.processor

import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable.ListBuffer

class TestShoppingCart extends FunSuite with BeforeAndAfter {

  var shoppingCart: ShoppingCart = _
  var listofFruits: ListBuffer[String] = new ListBuffer[String]


  before {
    shoppingCart = new ShoppingCart()
    listofFruits = new ListBuffer[String]
  }

  private def addOranges(count: Int) {
    for (i <- 1 to count) {
      listofFruits += "Orange"
    }
  }

  private def addApples(count: Int) {
    for (i <- 1 to count) {
      listofFruits += "Apple"
    }
  }

  test("An empty List should have price 0") {
    assert(shoppingCart.checkout(listofFruits.toList) == 0)
  }

  test("An apple should cost 0.6") {
    addApples(1)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.6)
  }


  test("An case insenstive apple should cost 0.6") {
    listofFruits += "apPLe"
    assert(shoppingCart.checkout(listofFruits.toList) == 0.6)
  }

  test("An Orange should cost 0.25") {
    addOranges(1)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.25)
  }

   test("An case insenstive orange should cost 0.25") {
    listofFruits += "oRAnge"
    assert(shoppingCart.checkout(listofFruits.toList) == 0.25)
  }

  test("An Apple and an Orange should cost 0.85") {
    addOranges(1)
    addApples(1)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.85)
  }

  test("2 Apple and 2 Orange should cost 0.85") {
    addOranges(2)
    addApples(2)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.7)
  }

  //With Offers scenarios -Apple alone
  test("Two Apples  should cost 0.6 after applying offer of 2 for 1") {
    addApples(2)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.6)
  }


  test("Three Apples  should cost 1.2 after applying offer of 2 for 1") {
    addApples(3)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.2)
  }

  test("Four Apples  should cost 1.2 after applying offer of 2 for 1") {
    addApples(4)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.2)
  }

  //With Offers scenarios -Orange alone
  test("Two Oranges  should cost 0.5 after applying offer of 3 for 2") {
    addOranges(2)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.5)
  }

  test("3 Oranges  should cost 0.5 after applying offer of 3 for 2") {
    addOranges(3)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.5)
  }

  test("4 Oranges  should cost 0.75 after applying offer of 3 for 2") {
    addOranges(4)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.75)
  }

  test("6 Oranges  should cost 1.0 after applying offer of 3 for 2") {
    addOranges(6)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.0)
  }

  //With Offers scenarios -Apple and Oranges
  test("2 Apples and 2 Orange should cost 1.1") {
    addOranges(2)
    addApples(2)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.1)
  }

  test("2 Apples and 3 Orange should cost 1.1") {
    addOranges(3)
    addApples(2)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.1)
  }

  test("3 Apples and 3 Orange should cost 1.7") {
    addOranges(3)
    addApples(3)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.7)
  }

  test("3 Apples and 4 Orange should cost 1.95") {
    addOranges(4)
    addApples(3)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.95)
  }

  test("4 Apples and 4 Orange should cost 1.95") {
    addOranges(4)
    addApples(4)
    assert(shoppingCart.checkout(listofFruits.toList) == 1.95)
  }



}
