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
        val num = Set(1,2,3,4,5,6,-1)
        println(num.min, num.max) // (-1, 6)

        // 交集 Set.&  or  Set.intersect
        val num1 = Set(1,2,3,11,12)
        println(num.&(num1)) // Set(1, 2, 3)
        println(num.intersect(num1)) // Set(1, 2, 3)


        // Map 默认不可变的 Map， 可变的要import scala.collection.mutable.Map
        val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF")
        println(colors("red")) // #FF0000
        println("all keys: " + colors.keys) // all keys: Set(red, azure)
        println("all values: " + colors.values) // all values: MapLike(#FF0000, #F0FFFF)
        println("isEmpty ? : " + colors.isEmpty) // isEmpty ? : false
        val num3 = Map()
        println(num3.isEmpty) // true

        // 合并 ++运算 or Map.++()
        val colors1 = Map("red" -> "#FF0000",
                        "azure" -> "#F0FFFF",
                        "peru" -> "#CD853F")
        println(colors ++ colors1) // Map(red -> #FF0000, azure -> #F0FFFF, peru -> #CD853F)
        println(colors.++(colors1)) // Map(red -> #FF0000, azure -> #F0FFFF, peru -> #CD853F)
        // 如果有 key 一样，value不一样，以后者的为准，请自行测试

        // 输出 keys, values
        colors.keys.foreach{
            i => print("key: " + i); println(" value: " + colors(i))
        } // key: red value: #FF0000
          // key: azure value: #F0FFFF

        // 指定key是否存在
        println(colors.contains("red")) // true
        println(colors.contains("blue")) // false

        // 元组
        val t = (1, 3.14, "michael")
        println(t._1) // 1， 下标从1开始 ._idx

        t.productIterator.foreach{ // 遍历
            i => println("value: " + i)
        }

        // 元组转字符串
        println(t.toString()) // (1,3.14,michael)

        // 交换元素
        val t1 = (1,2)
        println(t1.swap) // (2,1) 长度只能为 2

        // Option 表示一个值是可选的
        val myMap  = Map("k1" -> "v1")
        val v1 : Option[String] = myMap.get("k1")
        val v2 : Option[String] = myMap.get("k2")
        println(v1) // Some(v1)
        println(v2) // None

        def show(x : Option[String]) = x match {
            case Some(s) => s
            case None => "?"
        }
        println(show(myMap.get("k1"))) // v1
        println(show(myMap.get("k2"))) // ?

        // getOrElse() 获取存在的元素或者使用默认值
        val a : Option[Int] = Some(5)
        val b : Option[Int] = None
        println(a.getOrElse(0)) // 5
        println(b.getOrElse(10)) // 不存在，取默认值10
        println(a.isEmpty) // false
        println(b.isEmpty) // true

        // Iterator 访问集合的方法
        // it.next() 返回下一个元素，并更新迭代器
        // it.hasNext 是否还有元素
        val it = Iterator("baidu", "alibaba", "tencent")
        while(it.hasNext){
            println(it.next())
        }
        val it1 = Iterator(1,2,3,-1)
        val it2 = Iterator(1,2,3,-1)
        val it3 = Iterator(1,2,3,-1)

        println(it1.min) // -1
        println(it2.max) // 3, 需要分开写，不能写 it1.max

        println(it1.size) // 0， 迭代器走到头了，剩余长度0
        println(it3.length) // 4
    }
}

