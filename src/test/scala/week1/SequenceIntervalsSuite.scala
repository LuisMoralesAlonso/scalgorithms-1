package week1

/**
 * @author luis
 */
import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class QuicFindSuite extends FunSuite {
  test("QuickUnion. Sample from Book") { assert(new QuickUnion((0 to 9).toVector).union(4, 3).union(3, 8).union(6, 5).union(9, 4).union(2, 1).union(5, 0).union(7, 2).union(6, 1).union(1, 0).union(6, 7).toString == "Vector(1, 1, 1, 8, 3, 0, 5, 1, 8, 8)") }
  test("QuickFind. Sample from Book") { assert(new QuickFind((0 to 9).toVector).union(4, 3).union(3, 8).union(6, 5).union(9, 4).union(2, 1).union(5, 0).union(7, 2).union(6, 1).union(1, 0).union(6, 7).toString == "Vector(1, 1, 1, 8, 8, 1, 1, 1, 8, 8)") }
}