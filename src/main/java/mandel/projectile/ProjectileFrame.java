package mandel.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;

public class ProjectileFrame extends JFrame
{
    private JSlider velocitySlider;
    private JSlider angleSlider;
    private JTextField secondsField;
    private JLabel lx;
    private JLabel ly;
    private JLabel peakY;
    private JLabel interceptX;
    private JLabel angleNumber;
    private JLabel velocityNumber;

    private ProjectileGraph graph;

    public ProjectileFrame() {
        setSize(1000, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(9, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        velocitySlider = new JSlider(0, 100);
        velocitySlider.setMajorTickSpacing(10);
        velocitySlider.setMinorTickSpacing(5);
        velocitySlider.setPaintTicks(true);
        velocitySlider.setPaintLabels(true);
        west.add(velocitySlider);
        JLabel vs = new JLabel();
        velocityNumber = new JLabel(String.valueOf(velocitySlider.getValue()));
        west.add(vs);
        west.add(velocityNumber);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        angleSlider = new JSlider(0, 90);
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        west.add(angleSlider);
        JLabel as = new JLabel();
        angleNumber = new JLabel(String.valueOf(angleSlider.getValue()));
        west.add(as);
        west.add(angleNumber);

        JLabel secondsLabel = new JLabel("Seconds");
        secondsField = new JTextField();
        west.add(secondsLabel);
        west.add(secondsField);

        JLabel labelX = new JLabel("X");
        lx = new JLabel();
        west.add(labelX);
        west.add(lx);

        JLabel labelY = new JLabel("Y");
        ly = new JLabel();
        west.add(labelY);
        west.add(ly);

        JLabel peakLabelY = new JLabel("PeakY");
        peakY = new JLabel();
        west.add(peakLabelY);
        west.add(peakY);

        JLabel interceptLabelX = new JLabel("InterceptX");
        interceptX = new JLabel();
        west.add(interceptLabelX);
        west.add(interceptX);


        angleSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                calculations();
            }
        });

        velocitySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                calculations();
            }
        });

        SimpleDocumentListener docListener = new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                calculations();
            }
        };

        secondsField.getDocument().addDocumentListener(docListener);

        graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);
    }

    public void calculations() {
        Projectile projectile = new Projectile(angleSlider.getValue(), velocitySlider.getValue());
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));

        lx.setText(Double.toString(projectile.getX()));
        ly.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
        angleNumber.setText(Double.toString((int)angleSlider.getValue()));
        velocityNumber.setText(Double.toString(velocitySlider.getValue()));
        graph.setProjectile(projectile);
    }
}