package src

class main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // task1(args[1].toInt())
//            task2(arrayOf(args[0].toDouble(), args[1].toDouble(), args[2].toDouble(), args[3].toDouble(), args[4].toDouble())
//                    , args[0].toInt(), args[1].toInt())!!.forEach {
//                System.out.print(it.toString()+" ")
//            }
            System.out.print(task3("aabb", 1))
        }

        fun task1(count: Int) {
            val a = Array<Int>(count) {
                return@Array ((Math.random() * 100).toInt())
            }

            a.forEach { it ->
                System.out.print("$it\n")

            }
            var flag: Boolean = true;
            for (i in 1..a.size) {
                if (a[i] == a[0]) {
                    flag = false
                    break
                }
            }

            if (flag) {
                System.out.print("RAVNY")
            } else {
                System.out.print("NE RAVNY")

            }
        }

        fun task2(arrayStart: Array<Double>, start: Int, end: Int): Array<Double>? {
            return if (start < arrayStart.size && end < arrayStart.size) {
                Array(end - start + 1) {
                    arrayStart[it + start - 1]
                }
            } else {
                System.out.print("ERROR OUT OF BOUND EXCEPTION")
                null
            }
        }

        fun task3(string: String?, shift: Int): String {
            var temp: String? = ""
            if (!string.isNullOrEmpty()) {
                for (i in 0..string!!.lastIndex) {
                    temp += ((string.codePointAt(i) + shift).toChar())
                }
            } else {
                temp = null
            }
            return temp.toString()
        }
    }


}