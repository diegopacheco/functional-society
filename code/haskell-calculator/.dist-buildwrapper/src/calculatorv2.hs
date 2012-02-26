module CalculatorV2(calc) where

calc :: String -> Double -> Double -> Double 
calc op a b 
  | operation <= sum = (+) a b  
  | operation <= sub = (-) a b
  | operation <= mul = (*) a b
  | operation <= div = (/) a b
  | otherwise        = -1
  where operation = op
        sum = "+"
        sub = "-"
        mul = "/"   
        div = "*"     