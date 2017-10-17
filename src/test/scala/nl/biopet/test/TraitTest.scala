package nl.biopet.test

import java.io.File

import org.scalatest.Matchers
import org.scalatest.testng.TestNGSuite
import org.testng.annotations.Test

import scala.io.Source

class TraitTest extends BiopetTest {
  @Test
  def testClass(): Unit = {
    assert(this.isInstanceOf[TestNGSuite])
    assert(this.isInstanceOf[Matchers])
  }

  @Test
  def testResourcePath(): Unit = {
    val path = resourcePath("/test.txt")
    Source.fromFile(new File(path)).mkString shouldBe "test"

    intercept[IllegalStateException] {
      resourcePath("/does_not_exist.file")
    }.getMessage shouldBe "Resource '/does_not_exist.file' not found"
  }

  @Test
  def testResourceFile(): Unit = {
    Source.fromFile(resourceFile("/test.txt")).mkString shouldBe "test"

    intercept[IllegalStateException] {
      resourceFile("/does_not_exist.file")
    }.getMessage shouldBe "Resource '/does_not_exist.file' not found"
  }
}
