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
    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        JTextField velocityField = new JTextField();
        add(velocityLabel);
        add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        JSlider angleSlider = new JSlider(0, 90);
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);
        add(angleLabel);
        add(angleSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        JTextField secondsField = new JTextField();
        add(secondsLabel);
        add(secondsField);

        JLabel xLabel = new JLabel("X");
        JLabel x = new JLabel();
        add(xLabel);
        add(x);

        JLabel yLabel = new JLabel("Y");
        JLabel y = new JLabel();
        add(yLabel);
        add(y);

        JLabel peakYLabel = new JLabel("PeakY");
        JLabel peakY = new JLabel();
        add(peakYLabel);
        add(peakY);

        JLabel interceptXLabel = new JLabel("InterceptX");
        JLabel interceptX = new JLabel();
        add(interceptXLabel);
        add(interceptX);

        JButton calculateButton = new JButton("Calculate");
        add(new JLabel());
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projectile projectile = new Projectile(angleSlider.getValue(), Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                x.setText(Double.toString(projectile.getX()));
                y.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

        angleSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                Projectile projectile = new Projectile(angleSlider.getValue(), Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                x.setText(Double.toString(projectile.getX()));
                y.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

        SimpleDocumentListener docListener = new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                Projectile projectile = new Projectile(angleSlider.getValue(), Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                x.setText(Double.toString(projectile.getX()));
                y.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        };

        velocityField.getDocument().addDocumentListener(docListener);
        secondsField.getDocument().addDocumentListener(docListener);
    }
}