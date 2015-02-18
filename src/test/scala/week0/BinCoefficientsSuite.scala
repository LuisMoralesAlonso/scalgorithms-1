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
class BinCoefficientsSuite extends FunSuite {
 test("Wrong Coeffcient"){intercept[Exception] {BinCoefficients.binomial(0,1)}}
 test("Another Wrong Coeffcient"){intercept[Exception] {BinCoefficients.binomial(1,0)}}
 test("First element") {assert(BinCoefficients.binomial(2,1)==1)}
 test("Last element") {assert(BinCoefficients.binomial(3,3)==1)}
 test("Regular element") {assert(BinCoefficients.binomial(5,3)==6)}
 test("Long element") {assert(BinCoefficients.binomial(10,8)==36)}
}