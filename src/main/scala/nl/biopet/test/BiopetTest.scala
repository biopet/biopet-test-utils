package nl.biopet.test

import java.nio.file.Paths

import org.scalatest.Matchers
import org.scalatest.testng.TestNGSuite

trait BiopetTest extends TestNGSuite with Matchers {
  def resourcePath(p: String): String = {
    Paths.get(this.getClass.getResource(p).toURI).toString
  }
}
