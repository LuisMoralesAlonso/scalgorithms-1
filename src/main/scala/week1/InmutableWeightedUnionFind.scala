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

    def compareRoots(p: Int,q: Int) = (comp(siteRoot(p)) size) < (comp(siteRoot(q)) size)

    def connected(p: Int, q: Int): Boolean = siteRoot(p) == siteRoot(q)

    def comps: Int = (comp map (site => site index)).distinct.size

    def weightedUnion(p: Int, q: Int): Components = if (connected(p, q)) comp else (comp.indices map {
      case index if index == siteRoot(p) => if (comp compareRoots(p,q)) (siteRoot(q), (find(p).size)) else (siteRoot(p), find(p).sumSizes(find(q)))
      case index if index == siteRoot(q) => if (comp compareRoots(p,q)) (siteRoot(q), find(p).sumSizes(find(q))) else (siteRoot(p), (find(q).size))
      case index               => comp(index)
    }).toList
  }
}
