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
class ThreeSumSuite extends FunSuite {
 test("Empty List"){intercept[Exception] {ThreeSum.get3Sums(List())}}
 test("Not Enough Numbers"){intercept[Exception] {ThreeSum.get3Sums(List(1,2))}}
 test("From -5 to 5") {assert(ThreeSum.get3Sums((-5 to 5).toList)==List((-5,2,3), (-5,1,4), (-5,0,5), (-4,1,3), (-4,0,4), (-4,-1,5), (-3,1,2), (-3,0,3), (-3,-1,4), (-3,-2,5), (-2,0,2), (-2,-1,3), (-1,0,1)))}
 }