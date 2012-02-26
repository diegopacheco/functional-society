taxi :: Double -> String -> Int-> Double -> Double
taxi k b n p = calc_bandeira b k + calc_bag n + calc_pass p
			
calc_bandeira :: String -> Double -> Double
calc_bandeira b k 
		| b == "bandeira1" = k * 3.70
		| b == "bandeira2" = (2 * k) * 3.70
		| b == "bandeira3" = (3 * k) * 3.70
		| b == "bandeira4" = (4 * k) * 3.70
		| otherwise = 0
		
calc_bag :: Int -> Double
calc_bag n = if (n > 3) then 2 else 0

calc_pass :: Double -> Double
calc_pass p 
		| p == 1.0 = 0.0
		| otherwise = p * 2.0
		
mult_cidade :: [Double] -> Double
mult_cidade cs = foldl (\x y -> x + y) 0 (map (\x -> taxi x "bandeira1" 0 1.0) cs)
   