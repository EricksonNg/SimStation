package plague;

import mvc.AppFactory;
import sim_station.WorldPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlaguePanel extends WorldPanel implements ChangeListener {

    private JSlider initialInfectedSlider;
    private JSlider infectionProbabilitySlider;
    private JSlider populationSizeSlider;
    private JSlider recoveryTimeSlider;
    private JButton fatalityToggle;

    public PlaguePanel(AppFactory factory) {
        super(factory);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(5, 1, 5, 5));

        JPanel infectedPanel = new JPanel(new BorderLayout());
        infectedPanel.add(new JLabel("Initial % Infected:"), BorderLayout.NORTH);
        initialInfectedSlider = new JSlider(0, 100, PlagueSim.INITIAL_INFECTED);
        initialInfectedSlider.setMajorTickSpacing(10);
        initialInfectedSlider.setPaintTicks(true);
        initialInfectedSlider.setPaintLabels(true);
        initialInfectedSlider.addChangeListener(this);
        infectedPanel.add(initialInfectedSlider, BorderLayout.CENTER);
        sliderPanel.add(infectedPanel);

        JPanel probabilityPanel = new JPanel(new BorderLayout());
        probabilityPanel.add(new JLabel("Infection Probability:"), BorderLayout.NORTH);
        infectionProbabilitySlider = new JSlider(0, 100, PlagueSim.VIRULENCE);
        infectionProbabilitySlider.setMajorTickSpacing(10);
        infectionProbabilitySlider.setPaintTicks(true);
        infectionProbabilitySlider.setPaintLabels(true);
        infectionProbabilitySlider.addChangeListener(this);
        probabilityPanel.add(infectionProbabilitySlider, BorderLayout.CENTER);
        sliderPanel.add(probabilityPanel);

        JPanel populationPanel = new JPanel(new BorderLayout());
        populationPanel.add(new JLabel("Initial Population Size:"), BorderLayout.NORTH);
        populationSizeSlider = new JSlider(0, 200, PlagueSim.POPULATION_SIZE);
        populationSizeSlider.setMajorTickSpacing(20);
        populationSizeSlider.setPaintTicks(true);
        populationSizeSlider.setPaintLabels(true);
        populationSizeSlider.addChangeListener(this);
        populationPanel.add(populationSizeSlider, BorderLayout.CENTER);
        sliderPanel.add(populationPanel);

        JPanel recoveryPanel = new JPanel(new BorderLayout());
        recoveryPanel.add(new JLabel("Fatality/Recovery Time:"), BorderLayout.NORTH);
        recoveryTimeSlider = new JSlider(0, 500, PlagueSim.RECOVERY_TIME);
        recoveryTimeSlider.setMajorTickSpacing(50);
        recoveryTimeSlider.setPaintTicks(true);
        recoveryTimeSlider.setPaintLabels(true);
        recoveryTimeSlider.addChangeListener(this);
        recoveryPanel.add(recoveryTimeSlider, BorderLayout.CENTER);
        sliderPanel.add(recoveryPanel);

        JPanel togglePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fatalityToggle = new JButton("Make Infection Fatal");

        fatalityToggle.addActionListener(e -> {
            PlagueSim sim = (PlagueSim) model;
            sim.setFatal(!sim.isFatal());
            fatalityToggle.setText(sim.isFatal() ? "Make Infection Not Fatal" : "Make Infection Fatal");
        });
        togglePanel.add(fatalityToggle);
        sliderPanel.add(togglePanel);

        controlPanel.add(sliderPanel, BorderLayout.CENTER);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        PlagueSim sim = (PlagueSim) model;

        if (e.getSource() == initialInfectedSlider) {
            sim.setVirulence(initialInfectedSlider.getValue());
        } else if (e.getSource() == infectionProbabilitySlider) {
            sim.setInitialInfected(infectionProbabilitySlider.getValue());
        } else if (e.getSource() == populationSizeSlider) {
            sim.setPopulationSize(populationSizeSlider.getValue());
        } else if (e.getSource() == recoveryTimeSlider) {
            sim.setRecoveryTime(recoveryTimeSlider.getValue());
        }
    }
}