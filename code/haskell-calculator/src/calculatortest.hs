module Calculatortest() where
import Calculator
import Test.HUnit

-- To run this test on GHCI 
-- 1) $ :load Calculatortest
-- 2) $ runTestTT test1
test1 = TestCase (assertEqual "test csum" (4::Int) (csum(1,3)))