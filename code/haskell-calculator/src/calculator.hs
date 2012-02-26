module Calculator(csum, csub, cmul, cdiv) where

csum :: (Int,Int) -> Int
csum (a,b) = (+) a b

csub :: (Int,Int) -> Int
csub (a,b) = (-) a b

cmul :: (Int,Int) -> Int
cmul (a,b) = (*) a b

cdiv :: (Double,Double) -> Double
cdiv (a,b) = (/) a b