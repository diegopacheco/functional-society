
data CT = Candidates { presidents :: [Vote],
 		       governors  :: [Vote],
		       senators   :: [Vote]		
               	     } deriving (Show) 

data VT = Vote { name :: String, votes :: Int } deriving (Show)

vote [c] p g s = let a1 = ( filter (\n -> p == (name n)) v.presidents ).votes + 1  
                 let os = ( filter (\n -> not (p == (name n))) v.presidents
                 let v1 = (Vote p a1)
                 let result = [ os, v1 ]
                 result  
