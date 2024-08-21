import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class PieChart2D extends JPanel {

    // Data for the pie chart
    private double[] values = { 30, 20, 15, 25, 10 };
    private Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPieChart(g, getBounds(), values, colors);
    }

    private void drawPieChart(Graphics g, Rectangle area, double[] values, Color[] colors) {
        Graphics2D g2d = (Graphics2D) g;
        double total = 0.0;
        for (double value : values) {
            total += value;
        }

        double curValue = 0.0;
        int startAngle;

        for (int i = 0; i < values.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (values[i] * 360 / total);

            g2d.setColor(colors[i]);
            g2d.fill(new Arc2D.Double(area.x, area.y, area.width, area.height, startAngle, arcAngle, Arc2D.PIE));

            curValue += values[i];
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Pie Chart");
        PieChart2D pieChart = new PieChart2D();
        frame.add(pieChart);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
