package greed;

import mvc.AppFactory;
import sim_station.WorldPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GreedPanel extends WorldPanel implements ChangeListener {
    private JSlider greedSlider;
    private JSlider growBackRateSlider;
    private JSlider moveEnergySlider;

    public GreedPanel(AppFactory factory) {
        super(factory);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1, 5, 5));

        JPanel greedPanel = new JPanel(new BorderLayout());
        greedPanel.add(new JLabel("Greed:"), BorderLayout.NORTH);
        greedSlider = new JSlider(0, 100, ((Meadow)model).getGreediness());
        greedSlider.setMajorTickSpacing(10);
        greedSlider.setPaintTicks(true);
        greedSlider.setPaintLabels(true);
        greedSlider.addChangeListener(this);
        greedPanel.add(greedSlider, BorderLayout.CENTER);
        sliderPanel.add(greedPanel);

        JPanel growBackPanel = new JPanel(new BorderLayout());
        growBackPanel.add(new JLabel("Grow back rate:"), BorderLayout.NORTH);
        growBackRateSlider = new JSlider(0, 10, 1);
        growBackRateSlider.setMajorTickSpacing(1);
        growBackRateSlider.setPaintTicks(true);
        growBackRateSlider.setPaintLabels(true);
        growBackRateSlider.addChangeListener(this);
        growBackPanel.add(growBackRateSlider, BorderLayout.CENTER);
        sliderPanel.add(growBackPanel);

        JPanel moveEnergyPanel = new JPanel(new BorderLayout());
        moveEnergyPanel.add(new JLabel("Move Energy:"), BorderLayout.NORTH);
        moveEnergySlider = new JSlider(0, 50, ((Meadow)model).getMoveEnergy());
        moveEnergySlider.setMajorTickSpacing(10);
        moveEnergySlider.setPaintTicks(true);
        moveEnergySlider.setPaintLabels(true);
        moveEnergySlider.addChangeListener(this);
        moveEnergyPanel.add(moveEnergySlider, BorderLayout.CENTER);
        sliderPanel.add(moveEnergyPanel);

        controlPanel.add(sliderPanel, BorderLayout.CENTER);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Meadow meadow = (Meadow) model;

        if (e.getSource() == greedSlider) {
            meadow.setGreediness(greedSlider.getValue());
        } else if (e.getSource() == growBackRateSlider) {
            meadow.setGrowBackRate(growBackRateSlider.getValue());
        } else if (e.getSource() == moveEnergySlider) {
            meadow.setMoveEnergy(moveEnergySlider.getValue());
        }
    }
}