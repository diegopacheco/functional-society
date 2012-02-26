--
-- First implementation: using IF + List Comprehensions
--
fizzbuzz :: Int -> Int -> [String]
fizzbuzz from to = [ 
 if rem i 15 == 0 
   then "fizzbuzz" 
   else if rem i 5 == 0
          then "buzz" 
          else if rem i 3 == 0
                  then "fizz"
                  else (show i) | i <- [from..to]]

--
-- Second: Using Pattern Matcher + List Comprehensions
--
fb :: Int -> String
fb i 
   | i `mod` 15 == 0 = "fizzbuzz"
   | i `mod`  5 == 0 = "buzz"  
   | i `mod`  3 == 0 = "fiz" 
   | otherwise       = (show i)

fizzbuzz2 :: Int -> Int -> [String]
fizzbuzz2 from to = [fb i | i<- [from..to] ]

fizzbuzz3 :: Int -> Int -> [String]
fizzbuzz3 from to = map fb [from..to]

