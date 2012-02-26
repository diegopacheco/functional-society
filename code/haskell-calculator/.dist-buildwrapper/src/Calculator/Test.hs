module Testmport Test.HUnit
import Calculator as Calc

test1 = TestCase (assertEqual 2 (Calc.sum(1,1)))

main::IO()
main = undefined