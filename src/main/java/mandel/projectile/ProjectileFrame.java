package mandel.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame
{
    private JTextField velocityField;
    private JSlider angleSlider;
    private JTextField secondsField;
    private JLabel x;
    private JLabel y;
    private JLabel peakY;
    private JLabel interceptX;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        velocityField = new JTextField();
        add(velocityLabel);
        add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);
        angleSlider = new JSlider(0, 90);
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        secondsField = new JTextField();
        add(secondsLabel);
        add(secondsField);

        JLabel labelX = new JLabel("X");
        x = new JLabel();
        add(labelX);
        add(x);

        JLabel labelY = new JLabel("Y");
        y = new JLabel();
        add(labelY);
        add(y);

        JLabel peakLabelY = new JLabel("PeakY");
        peakY = new JLabel();
        add(peakLabelY);
        add(peakY);

        JLabel interceptLabelX = new JLabel("InterceptX");
        interceptX = new JLabel();
        add(interceptLabelX);
        add(interceptX);

        JButton calculateButton = new JButton("Calculate");
        add(new JLabel());
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculations();
            }
        });

        angleSlider.addChangeListener(new ChangeListener() {
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

        velocityField.getDocument().addDocumentListener(docListener);
        secondsField.getDocument().addDocumentListener(docListener);
    }

    public void calculations() {
        Projectile projectile = new Projectile(angleSlider.getValue(),
                Double.parseDouble(velocityField.getText()));
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));

        x.setText(Double.toString(projectile.getX()));
        y.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
    }
}