package br.com.scala.school
import junit.framework.TestCase
import junit.framework.Assert._
import br.com.scala.school.Telefone._

class TelefoneTeste extends TestCase {
	def test_2_ABC = assertEquals("ABC", resolve(2))
	def test_3_DEF = assertEquals("DEF", resolve(3))
	def test_4_GHI = assertEquals("GHI", resolve(4))
	def test_5_JKL = assertEquals("JKL", resolve(5))
	def test_6_MNO = assertEquals("MNO", resolve(6))
	def test_7_PQRS = assertEquals("PQRS", resolve(7))
	def test_8_TUV = assertEquals("TUV", resolve(8))
	def test_9_WXYZ = assertEquals("WXYZ", resolve(9))
}