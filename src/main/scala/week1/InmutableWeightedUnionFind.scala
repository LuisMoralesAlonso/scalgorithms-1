package week1

/**
 * @author luis
 */
object InmutableWeightedUnionFind {


  type Site = (Int, Int)
  type Components = List[Site]

  implicit class ToComponents(lista: List[Int]) {
    def toComponents: Components = lista zip List.fill(lista.size)(1)
  }

  implicit class SiteMethods(site: Site) {
    def index: Int = site._1
    def size: Int = site._2
    def sumSizes(site2: Site): Int = site.size + site2.size
  }

  implicit class ComponentsMethods(comp: Components) {
    def find(p: Int): Site = p match {
      case index if index == (comp(p) index) => comp(p)
      case index                             => find(comp(p) index)
    }

    def siteRoot(p: Int): Int = find(p) index

    def compareSizes(p: Int,q: Int) = (comp(p) size) < (comp(q) size)

    def connected(p: Int, q: Int): Boolean = siteRoot(p) == siteRoot(q)

    def comps: Int = (comp map (site => site index)).distinct.size

    def weightedUnion(p: Int, q: Int): Components = if (connected(p, q)) comp else (comp.indices map {
      case index if index == p => if (comp compareSizes(p,q)) (siteRoot(q), (comp(p).size)) else (siteRoot(p), comp(p).sumSizes(comp(q)))
      case index if index == q => if (comp compareSizes(p,q)) (siteRoot(q), comp(p).sumSizes(comp(q))) else (siteRoot(p), (comp(q).size))
      case index               => comp(index)
    }).toList
  }
}
