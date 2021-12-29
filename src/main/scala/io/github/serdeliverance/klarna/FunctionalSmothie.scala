package io.github.serdeliverance.klarna

object FunctionalSmothie {

  def ingredients(
      item: String,
      ingredientsToOmit: List[String],
      menuIngredientsProvider: MenuIngredientsProvider
    ): String =
    menuIngredientsProvider
      .getIngredientsFor(item)
      .filter(ingredient => !ingredientsToOmit.contains(ingredient))
      .sorted
      .mkString(",")
}

trait MenuIngredientsProvider {
  def getIngredientsFor(menuItem: String): Seq[String]
}

object MenuIngredientsProvider {

  def apply(): MenuIngredientsProvider =
    new MenuIngredientsProvider {

      val menu = Map(
        "Classic"       -> List("strawberry", "banana", "pineapple", "mango", "peach", "honey", "ice", "yogurt"),
        "Forest Berry"  -> List("strawberry", "raspberry", "blueberry", "honey", "ice", "yogurt"),
        "Freezie"       -> List("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"),
        "Greenie"       -> List("green apple", "kiwi", "lime", "avocado", "spinach", "ice", "apple juice"),
        "Vegan Delite"  -> List("strawberry", "passion fruit", "pineapple", "mango", "peach", "ice", "soy milk"),
        "Just Desserts" -> List("banana", "ice cream", "chocolate", "peanut", "cherry")
      )

      override def getIngredientsFor(menuItem: String): Seq[String] = menu.getOrElse(menuItem, List.empty)
    }
}
