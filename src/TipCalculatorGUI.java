import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class TipCalculatorGUI extends JFrame implements KeyListener, ActionListener {
    private JTextField billForm;
    private JTextField tipForm;
    private JTextField peopleForm;
    private JButton addTipPercent;
    private JButton subtractTipPercent;
    private JButton addNumPeople;
    private JButton subtractNumPeople;
    private JTextField calculatedTipForm;
    private JTextField calculatedTotalForm;
    private JPanel mainPanel;
    private TipCalculator calculator;

    public TipCalculatorGUI() {
        setupFrame();
        setupInitialValues();
        addActionListeners();
        addKeyListener();
    }

    private void setupFrame() {
        setContentPane(mainPanel);
        setTitle("Tip Calc");
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setupInitialValues() {
        peopleForm.setText("0");
        billForm.setText("0");
        tipForm.setText("0");
        calculatedTipForm.setText("0");
        calculatedTotalForm.setText("0");
    }

    private void addActionListeners() {
        addTipPercent.addActionListener(this);
        addNumPeople.addActionListener(this);
        subtractTipPercent.addActionListener(this);
        subtractNumPeople.addActionListener(this);
    }

    private void addKeyListener() {
        billForm.addKeyListener(this);
        tipForm.addKeyListener(this);
        peopleForm.addKeyListener(this);
    }

    private void updateForms() {
        try {
            double bill = Double.parseDouble(billForm.getText());
            int tipPercent = Integer.parseInt(tipForm.getText());
            int numPeople = Integer.parseInt(peopleForm.getText());

            calculator = new TipCalculator(bill, tipPercent, numPeople);
            calculatedTipForm.setText(String.valueOf(calculator.calculateTip()));
            calculatedTotalForm.setText(String.valueOf(calculator.totalPerPerson()));
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse numbers");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch (button.getText()) {
            case "+%":
                int incrementedTip = Integer.parseInt(tipForm.getText()) + 1;
                tipForm.setText(String.valueOf(incrementedTip));
                updateForms();
                break;
            case "-%":
                int decrementedTip = Integer.parseInt(tipForm.getText()) > 0 ? Integer.parseInt(tipForm.getText()) - 1 : 0;
                tipForm.setText(String.valueOf(decrementedTip));
                updateForms();
                break;
            case "+":
                int incrementedPeople = Integer.parseInt(peopleForm.getText()) + 1;
                peopleForm.setText(String.valueOf(incrementedPeople));
                updateForms();
                break;
            case "-":
                int decrementedPeople = Integer.parseInt(peopleForm.getText()) > 0 ? Integer.parseInt(peopleForm.getText()) - 1: 0;
                peopleForm.setText(String.valueOf(decrementedPeople));
                updateForms();
                break;
            default:
                System.out.println("Shouldn't happen");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateForms();
    }
}
