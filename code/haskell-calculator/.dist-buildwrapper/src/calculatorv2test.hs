module Calculatortest() where
import Calculatorv2
import Test.HUnit

-- To run this test on GHCI 
-- 1) $ :load Calculatortest
-- 2) $ runTestTT test1
test1 = TestCase (assertEqual "test csum" (4::Int)  (csum "+" 1 3)))
test2 = TestCase (assertEqual "test csub" (2::Int)  (csub "+" 5 3)))
test3 = TestCase (assertEqual "test cdiv" (2::Int)  (csum "/" 10 5)))
test4 = TestCase (assertEqual "test cmul" (25::Int) (csum "*" 5 5)))
