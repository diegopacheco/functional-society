module Main where

data CA = Contact { name  :: String, 
		    email :: String,
		    phone :: Int } deriving (Show) 

add :: ([CA], String, String, Int) -> [CA]
add (contacts,n,e,t) = (Contact n e t) : contacts  

list :: Show a => [a] -> IO [()]
list xs = mapM ( \c ->  putStrLn (show c)) xs

search :: [CA] -> String -> [CA]
search cs n = filter ( \c -> (name c) == n) cs 

remove :: [CA] -> String -> [CA]
remove cs n = filter ( \c -> not ((name c) == n) ) cs 

main = do 
	putStrLn "Adding Contacts... "
	let x = add([],"Diego","diego.pacheco@ilegra.com",123456)
	let y = add(x,"Poletto","alexandre.poletto@ilegra.com",654321)
	let z = add(y,"Shooter","andre.mayer@ilegra.com",098765)
	let contacts = z
	list contacts
	
	putStrLn "Search for contacts... "
	let diego = search contacts "Diego"
	putStrLn (show diego)
	
	putStrLn "Removing Contacts... "
	let newList = remove contacts "Diego"
	list newList

