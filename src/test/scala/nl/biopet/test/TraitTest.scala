package nl.biopet.test

import org.scalatest.Matchers
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

class TraitTest extends BiopetTest {
  @Test
  def testClass(): Unit = {
    assert(this.isInstanceOf[TestNGSuite])
    assert(this.isInstanceOf[Matchers])
  }
}
