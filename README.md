# scalgorithms-1
##Algorithms in Scala.

Just for practicing porposes with Scala I'll try to rewrite all exercises from Algorithms courses in Coursera. I'll do some exercises from the original course at http://algs4.cs.princeton.edu/.

Main principles I'll try to follow:
* No side effects methods. No "traditional" loop.
* Functions always return something, and as first-class citizen they may be higher-order ones.
* Inmutability everywhere. 
* Functional objects. 

###Week0.
**BinarySearch.scala.**

It implements a classic algorithm known as binary search and tests it for an application known as whitelist filtering.

http://en.wikipedia.org/wiki/Binary_search_algorithm

**BinDistribution.scala.**
I'll do a function to obtain recursively the binomial coeffcients. It's in the Coursera course too.

I've supposed first element is (1,1).

http://en.wikipedia.org/wiki/Binomial_distribution

The first lines of Pascal's triangle:

http://commons.wikimedia.org/wiki/File:Pascals_triangle_30_lines.png

**Matrix library.** 

I've used scala files from:

https://github.com/eobrain/scalaclass

**Shuffle algorithms.** 
Let's do an exercise of different shuffle algorithms: algorithm p, "inside-out" algorithms and Sattolo's variant.

We'll use an implicit class to extend Scala Collections with these features.

Algorithm P.

http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Modern_method

Sattolo's.

Generates a unifomly distributed cycle of length N using Sattolo's algorithm.

http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Sattolo.27s_algorithm

