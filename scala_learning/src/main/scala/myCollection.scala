object myCollection {
    // 列表不可变
    def main(args: Array[String])= {
        val site: List[String] = List("michael", "csdn","blog")
        val site1 = "michael" :: ("csdn" :: Nil)
        val empty: List[Nothing] = List()
        val empty1 = Nil
        val dim: List[List[Int]] = List(
            List(1, 0, 0),
            List(0, 1, 0),
            List(0, 0, 0, 1)
        )
        val dim1 = (1::(0::(0::Nil)))::
                    (0::(1::(0::Nil)))::
                    (0::(0::(0::(1::Nil))))::Nil
        println(site.head) // michael
        println(site.tail) // 除第一个元素之外的 List(csdn, blog)
        println(empty.isEmpty) // true
        println(dim.isEmpty) // false

        // 列表连接
        // 方法1 ::: 运算
        var site0 = site ::: site1
        println(site0) // List(michael, csdn, blog, michael, csdn)
        // 方法2 List.:::() 方法, 注意连接的顺序
        site0 = site.:::(site1)
        println(site0) // List(michael, csdn, michael, csdn, blog)
        println(site) // List(michael, csdn, blog)
        // 方法3 使用 concat 方法
        site0 = List.concat(site, site1)
        println(site0) // List(michael, csdn, blog, michael, csdn)

        // List.fill() 填入重复数量的元素
        val site3 = List.fill(3)("michael") // 重复3次
        println(site3) // List(michael, michael, michael)

        // List.tabulate() 通过给定函数创建列表
        val squares = List.tabulate(6)(n => n*n+1)
        println(squares) // List(1, 2, 5, 10, 17, 26)
        // 二维
        val mul = List.tabulate(4,5)(_ * _)
        println(mul)
        // List(List(0, 0, 0, 0, 0), List(0, 1, 2, 3, 4), List(0, 2, 4, 6, 8), List(0, 3, 6, 9, 12))

        // List.reverse 反转
        println(squares.reverse) // List(26, 17, 10, 5, 2, 1)

        // set没有重复，默认是不可变集合, 改变后，生成新的set
        val set = Set(1,2,3)
        println(set.getClass.getName) // scala.collection.immutable.Set$Set3
        println(set.exists(_%2 == 0)) // true
        println(set.drop(1)) // Set(2, 3)
        println(set) // Set(1, 2, 3)
        // 可变集合
        import scala.collection.mutable
        val mutableSet = mutable.Set(1,2,3)
        println(mutableSet.getClass.getName) // scala.collection.mutable.HashSet
        println(mutableSet.add(4)) // true
        println(mutableSet.remove(1)) // true
        mutableSet += 5
        mutableSet -= 2
        println(mutableSet) // Set(5, 3, 4)

        // .head  .tail  .isEmpty 跟 List 的含义一样

        // 连接集合 ++ or Set.++() ，会去重
        val s1 = Set("michael","ming")
        val s2 = Set("michael", "scala")
        var s0 = s1 ++ s2
        println(s0) // Set(michael, ming, scala)
        s0 = s1.++(s2)
        println(s0) // Set(michael, ming, scala)

        // 最值 Set.min, Set.max

    }
}
