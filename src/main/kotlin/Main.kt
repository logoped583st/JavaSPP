import java.awt.Dimension
import java.awt.Graphics
import javax.swing.BorderFactory
import javax.swing.JFrame
import javax.swing.JPanel


class Main : JFrame() {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            JFrame.setDefaultLookAndFeelDecorated(true)
            val frame = JFrame("Test frame")
            frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

            val panel = JPanel()
            val padding = BorderFactory.createEmptyBorder(30, 30, 30, 30)

            panel.border = padding
            frame.contentPane.add(panel)

            frame.preferredSize = Dimension(1200, 900)
            frame.pack()
            frame.isVisible = true
            frame.isResizable = false
            frame.setLocationRelativeTo(null)
            drawTriagle(Triagle(Point(20,20), Point(30, 0), Point(10, 20)), panel.graphics)
            print(pointInTriangle(Point(1, 1), Triagle(Point(0, 0), Point(0, 10), Point(10, 0))))
            drawPoint(Point(1, 1),panel.graphics)
        }

        fun drawTriagle(triagle: Triagle, graphics: Graphics) {
            graphics.drawLine(triagle.point1.x * 10, triagle.point1.y * 10, triagle.point2.x * 10, triagle.point2.y * 10)
            graphics.drawLine(triagle.point2.x * 10, triagle.point2.y * 10, triagle.point3.x * 10, triagle.point3.y * 10)
            graphics.drawLine(triagle.point3.x * 10, triagle.point3.y * 10, triagle.point1.x * 10, triagle.point1.y * 10)
        }

        fun drawPoint(point: Point, graphics: Graphics) {
            graphics.drawOval(point.x*10, point.y*10, 5, 5)
        }


        fun sign(p1: Point, p2: Point, p3: Point): Int {
            return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y)
        }

        fun pointInTriangle(pt: Point, triagle: Triagle): Boolean {
            val b1: Boolean = sign(pt, triagle.point1, triagle.point2) < 0.0f
            val b2: Boolean = sign(pt, triagle.point2, triagle.point3) < 0.0f
            val b3: Boolean = sign(pt, triagle.point3, triagle.point1) < 0.0f

            return (b1 == b2 && b2 == b3)
        }
    }


}