module Calculatortest() where
import Calculator
import Test.HUnit

-- To run this test on GHCI: runTestTT test1
test1 = TestCase $ assertEqual 4 csum(2,2) 