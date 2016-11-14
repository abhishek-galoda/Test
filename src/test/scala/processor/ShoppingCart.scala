
import com.shopping.processor.ShoppingCart
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable.ListBuffer

class TestShoppingCart extends FunSuite with BeforeAndAfter {

  var shoppingCart: ShoppingCart = _
  var listofFruits: ListBuffer[String]=new ListBuffer[String]


  before {
    shoppingCart = new ShoppingCart()
    listofFruits = new ListBuffer[String]
  }

  private def addOranges(count: Int) {
    for ( i <- 1 to count) {
      listofFruits+="Orange"
    }

  }

  private def addApples(count: Int) {
    for ( i <- 1 to count) {
      listofFruits+="Apple"
    }
  }

  test("An empty List should have price 0") {
    assert(shoppingCart.checkout(listofFruits.toList) == 0)
  }

  test("An apple should cost 0.6") {
    addApples(1)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.6)
  }

  test("2 apple should cost 1.2") {
    addApples(1)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.6)
  }

  test("An case insenstive apple should cost 0.6") {
    listofFruits+="apPLe"
    assert(shoppingCart.checkout(listofFruits.toList) == 0.6)
  }

  test("An Orange should cost 0.25") {
    addOranges(1)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.25)
  }

  test("2 Oranges should cost 0.5") {
    addApples(1)
    assert(shoppingCart.checkout(listofFruits.toList) == 0.5)
  }

  test("An case insenstive orange should cost 0.25") {
    listofFruits+="oRAnge"
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

}
