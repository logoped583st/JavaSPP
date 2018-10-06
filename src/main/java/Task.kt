import java.io.IOException
import java.io.File

open class Task {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                val builder = ProcessBuilder("cat", args[1], args[2])
                if (args.size >2 ) {
                    val combinedFile = File(args[3])
                    builder.redirectOutput(combinedFile)
                    builder.redirectError(combinedFile)
                    builder.start()
                } else {
                    print(File(args[1]).readText() + File(args[2]).readText())
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}