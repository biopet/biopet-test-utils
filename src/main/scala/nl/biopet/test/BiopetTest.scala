package nl.biopet.test

import java.io.File
import java.nio.file.Paths

import org.scalatest.Matchers
import org.scalatest.testng.TestNGSuite

trait BiopetTest extends TestNGSuite with Matchers {
  def resourcePath(p: String): String = {
    val resource = this.getClass.getResource(p)
    if (resource == null) throw new IllegalStateException(s"Resource '$p' not found")
    else Paths.get(this.getClass.getResource(p).toURI).toString
  }

  def resourceFile(p: String): File = new File(resourcePath(p))
}
