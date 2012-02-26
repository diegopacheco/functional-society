{-# LANGUAGE ForeignFunctionInterface #-}
module Paths_haskell_calculator (
    version,
    getBinDir, getLibDir, getDataDir, getLibexecDir,
    getDataFileName
  ) where

import Foreign
import Foreign.C
import Data.Version (Version(..))
import System.Environment (getEnv)

version :: Version
version = Version {versionBranch = [0,1], versionTags = []}

prefix, bindirrel :: FilePath
prefix        = "C:\\Users\\Diego Pacheco\\AppData\\Roaming\\cabal"
bindirrel     = "bin"

getBinDir :: IO FilePath
getBinDir = getPrefixDirRel bindirrel

getLibDir :: IO FilePath
getLibDir = getPrefixDirRel "haskell-calculator-0.1\\ghc-7.0.3"

getDataDir :: IO FilePath
getDataDir =  catch (getEnv "haskell_calculator_datadir") (\_ -> getPrefixDirRel "haskell-calculator-0.1")

getLibexecDir :: IO FilePath
getLibexecDir = getPrefixDirRel "haskell-calculator-0.1"

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir `joinFileName` name)

getPrefixDirRel :: FilePath -> IO FilePath
getPrefixDirRel dirRel = do 
  let len = (2048::Int) -- plenty, PATH_MAX is 512 under Win32.
  buf <- mallocArray len
  ret <- getModuleFileName nullPtr buf len
  if ret == 0 
     then do free buf;
             return (prefix `joinFileName` dirRel)
     else do exePath <- peekCString buf
             free buf
             let (bindir,_) = splitFileName exePath
             return ((bindir `minusFileName` bindirrel) `joinFileName` dirRel)

foreign import stdcall unsafe "windows.h GetModuleFileNameA"
  getModuleFileName :: Ptr () -> CString -> Int -> IO Int32

minusFileName :: FilePath -> String -> FilePath
minusFileName dir ""     = dir
minusFileName dir "."    = dir
minusFileName dir suffix =
  minusFileName (fst (splitFileName dir)) (fst (splitFileName suffix))

joinFileName :: String -> String -> FilePath
joinFileName ""  fname = fname
joinFileName "." fname = fname
joinFileName dir ""    = dir
joinFileName dir fname
  | isPathSeparator (last dir) = dir++fname
  | otherwise                  = dir++pathSeparator:fname

splitFileName :: FilePath -> (String, String)
splitFileName p = (reverse (path2++drive), reverse fname)
  where
    (path,drive) = case p of
       (c:':':p') -> (reverse p',[':',c])
       _          -> (reverse p ,"")
    (fname,path1) = break isPathSeparator path
    path2 = case path1 of
      []                           -> "."
      [_]                          -> path1   -- don't remove the trailing slash if 
                                              -- there is only one character
      (c:path') | isPathSeparator c -> path'
      _                             -> path1

pathSeparator :: Char
pathSeparator = '\\'

isPathSeparator :: Char -> Bool
isPathSeparator c = c == '/' || c == '\\'
