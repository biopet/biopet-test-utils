/*
 * Copyright (c) 2014 Biopet
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
