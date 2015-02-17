package week0

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
class BinarySearchSuite extends FunSuite {
 test("Emtpy List"){intercept[Exception] {BinarySearch.binsearch(3,List())}}
 test("Element not in List"){intercept[NoSuchElementException] {BinarySearch.binsearch(3,List(1,2,4))}}
 test("Exactly this element") {assert(BinarySearch.binsearch(1,List(1))==0)}
 test("Odd list, less") {assert(BinarySearch.binsearch(2,List(1,2,3,4,5))==1)}
 test("Even list,greater") {assert(BinarySearch.binsearch(3,List(1,2,3,4))==2)}
 test("Upper bound") {assert(BinarySearch.binsearch(4,List(1,2,3,4))==3)}
 test("Lower bound") {assert(BinarySearch.binsearch(1,List(1,2,3,4))==0)}
}