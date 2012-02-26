module Calculator where

sum :: (Int,Int) -> Int
sum (a,b) = (+) a b

sub :: (Int,Int) -> Int
sub (a,b) = (-) a b

mul :: (Int,Int) -> Int
mul (a,b) = (*) a b

div :: (Double,Double) -> Double
div (a,b) = (/) a b

main::IO()
main = undefined