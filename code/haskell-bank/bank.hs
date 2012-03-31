{-# LANGUAGE TemplateHaskell, TypeOperators #-}
module StateExample where

import Control.Monad.State hiding (modify)
import Data.Label (mkLabels)
import Data.Label.Pure ((:->))
import Data.Label.PureM

data AccountState = AccountState { _number :: Int , _value :: Int } deriving Show
$(mkLabels [''AccountState])

newAccountState:: AccountState
newAccountState = AccountState { _number = 100, _value = 0 }

deposit :: (AccountState :-> Int) -> Int -> State AccountState ()
deposit f v = modify f (+v)

withdrawl :: (AccountState :-> Int) -> Int -> State AccountState ()
withdrawl f v = modify f (\x -> x - v )

main :: IO ()
main = do
    let acc1 = flip execState newAccountState $ do
        deposit value 100
	deposit value 500
	withdrawl value 50
	withdrawl value 50	 
    print acc1		
    let acc2 = flip execState newAccountState $ do
   	deposit value 1000
   	withdrawl value 100 	
    print acc2	
