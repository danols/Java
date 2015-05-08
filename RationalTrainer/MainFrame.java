import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class MainFrame extends JFrame  {
 
    public static final int widthFrame = 450;
    public static final int heightFrame = 200; 
 
    private JButton btnGenerateRational, btnSum, btnMultiply, btnDivision, btnSubtraction;
    private JLabel lblAnswer, lblEquals, lblSign, lblSeparator1 , lblSeparator2 , lblSeparator3;
    private JTextField txfNumerator1, txfNumerator2, txfDenominator1, txfDenominator2, txfNumerator, txfDenominator;
 
    public MainFrame() {
 
        setTitle("Operaciones Con Racionales");
        setSize(widthFrame,heightFrame);
        //ImageIcon img = new ImageIcon("mainicon.png");
        //setIconImage(img.getImage());
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        Container mainPanel = getContentPane();
        mainPanel.setLayout(new GridLayout(3,1,5,5));
         
        Panel panelInput = new Panel(10,5);
        Panel panelButtons = new Panel(10,10);
        Panel panelResult = new Panel(5,1);
 
        btnGenerateRational= new JButton(new ImageIcon("new.png"));
        btnSum = new JButton(new ImageIcon("sum.png"));
        btnSubtraction = new JButton(new ImageIcon("subtraction.png"));
        btnMultiply = new JButton(new ImageIcon("multiply.png"));
        btnDivision = new JButton(new ImageIcon("divide.png"));
 
        ButtonHandler btnHandler = new ButtonHandler();
 
        btnGenerateRational.addActionListener(btnHandler);
        btnSum.addActionListener(btnHandler);
        btnSubtraction.addActionListener(btnHandler);
        btnMultiply.addActionListener(btnHandler);
        btnDivision.addActionListener(btnHandler);
 
        txfNumerator1 = new JTextField(4);
        txfNumerator1.setEditable(false);
        txfNumerator1.setHorizontalAlignment(JTextField.CENTER);
        txfNumerator2 = new JTextField(4);
        txfNumerator2.setEditable(false);
        txfNumerator2.setHorizontalAlignment(JTextField.CENTER);
        txfDenominator1 = new JTextField(4);
        txfDenominator1.setEditable(false);
        txfDenominator1.setHorizontalAlignment(JTextField.CENTER);
        txfDenominator2 = new JTextField(4);
        txfDenominator2.setEditable(false);
        txfDenominator2.setHorizontalAlignment(JTextField.CENTER);
        txfNumerator = new JTextField(4);
        txfNumerator.setHorizontalAlignment(JTextField.CENTER);
        txfDenominator = new JTextField(4);
        txfDenominator.setHorizontalAlignment(JTextField.CENTER);
 
        lblSeparator1 = new JLabel(" / ");
        lblSeparator2 = new JLabel(" / ");
        lblSeparator3 = new JLabel(" / ");
        lblSign = new JLabel(new ImageIcon("new.png"));
        lblEquals = new JLabel(new ImageIcon("equals.png"));
        lblAnswer = new JLabel(" ");
 
        panelInput.add(txfNumerator1);
        panelInput.add(lblSeparator1);
        panelInput.add(txfDenominator1);
        panelInput.add(lblSign);
        panelInput.add(txfNumerator2);
        panelInput.add(lblSeparator2);
        panelInput.add(txfDenominator2);
        panelInput.add(lblEquals);
        panelInput.add(txfNumerator);
        panelInput.add(lblSeparator3);
        panelInput.add(txfDenominator);
 
        panelButtons.add(btnGenerateRational);
        panelButtons.add(btnSum);
        panelButtons.add(btnSubtraction);
        panelButtons.add(btnMultiply);
        panelButtons.add(btnDivision);
 
        panelResult.add(lblAnswer);
 
        mainPanel.add(panelInput);
        mainPanel.add(panelButtons);
        mainPanel.add(panelResult);
 
        paintComponents(getGraphics());
 
    }
 
    public class Panel extends JPanel {
        Panel(int v, int h) {
            FlowLayout Layout=new FlowLayout();
            Layout.setAlignment(FlowLayout.CENTER);
            Layout.setVgap(v);
            Layout.setHgap(h);
            setLayout(Layout);
        }
    }
 
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
    }
 
    private class ButtonHandler implements ActionListener {
 
        Rational a = new Rational(1,1);
        Rational b = new Rational(1,1);
        Rational c = new Rational(1,1);
        Rational d = new Rational(1,1);
 
        int n1,n2,d1,d2,rn,rd;
 
        public void actionPerformed(ActionEvent e) {
 
            if(e.getSource() == btnGenerateRational) {
                a.setRandom();
                b.setRandom();
                txfNumerator1.setText(Integer.toString(a.getNum()));
                txfNumerator2.setText(Integer.toString(b.getNum()));
                txfDenominator1.setText(Integer.toString(a.getDen()));
                txfDenominator2.setText(Integer.toString(b.getDen()));
                lblAnswer.setText("");
                txfNumerator.setText("");
                txfDenominator.setText("");
 
            }
            if(e.getSource() == btnSum) {
                if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("") || txfDenominator1.getText().equals("")) {
                    if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("")) lblAnswer.setText("Pon Tu Respuesta Primero!!!");
                    if(txfNumerator1.getText().equals("")) lblAnswer.setText("Genera Los Operandos Primero!!!");
                }else {
                    lblSign.setIcon(new ImageIcon("sum.png"));
                    n1 = Integer.parseInt(txfNumerator1.getText());
                    d1 = Integer.parseInt(txfDenominator1.getText());
                    a.set(n1,d1);
                    n2 = Integer.parseInt(txfNumerator2.getText());
                    d2 = Integer.parseInt(txfDenominator2.getText());
                    b.set(n2,d2);
                    c.add(a,b);
                    rn = Integer.parseInt(txfNumerator.getText());
                    rd = Integer.parseInt(txfDenominator.getText());
                    d.set(rn,rd);
                    if(c.equals(d)) lblAnswer.setText("Bien Hecho!!!");
                    else lblAnswer.setText("La Respuesta Correcta Es --> " + c.toString());
                }
            }
            if(e.getSource() == btnSubtraction) {
                if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("") || txfDenominator1.getText().equals("")) {
                    if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("")) lblAnswer.setText("Pon Tu Respuesta Primero!!!");
                    if(txfNumerator1.getText().equals("")) lblAnswer.setText("Genera Los Operandos Primero!!!");
                }else {
                    lblSign.setIcon(new ImageIcon("subtraction.png"));
                    n1 = Integer.parseInt(txfNumerator1.getText());
                    d1 = Integer.parseInt(txfDenominator1.getText());
                    a.set(n1,d1);
                    n2 = Integer.parseInt(txfNumerator2.getText());
                    d2 = Integer.parseInt(txfDenominator2.getText());
                    b.set(n2,d2);
                    c.deduct(a,b);
                    rn = Integer.parseInt(txfNumerator.getText());
                    rd = Integer.parseInt(txfDenominator.getText());
                    d.set(rn,rd);
                    if(c.equals(d)) lblAnswer.setText("Bien Hecho!!!");
                    else lblAnswer.setText("La Respuesta Correcta Es --> " + c.toString());
                }
            }
            if(e.getSource() == btnMultiply) {
                if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("") || txfDenominator1.getText().equals("")) {
                    if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("")) lblAnswer.setText("Pon Tu Respuesta Primero!!!");
                    if(txfNumerator1.getText().equals("")) lblAnswer.setText("Genera Los Operandos Primero!!!");
                }else {
                    lblSign.setIcon(new ImageIcon("multiply.png"));
                    n1 = Integer.parseInt(txfNumerator1.getText());
                    d1 = Integer.parseInt(txfDenominator1.getText());
                    a.set(n1,d1);
                    n2 = Integer.parseInt(txfNumerator2.getText());
                    d2 = Integer.parseInt(txfDenominator2.getText());
                    b.set(n2,d2);
                    c.multiply(a,b);
                    rn = Integer.parseInt(txfNumerator.getText());
                    rd = Integer.parseInt(txfDenominator.getText());
                    d.set(rn,rd);
                    if(c.equals(d)) lblAnswer.setText("Bien Hecho!!!");
                    else lblAnswer.setText("La Respuesta Correcta Es --> " + c.toString());
                }
            }
            if(e.getSource() == btnDivision) {
                if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("") || txfDenominator1.getText().equals("")) {
                    if(txfNumerator.getText().equals("") || txfDenominator.getText().equals("")) lblAnswer.setText("Pon Tu Respuesta Primero!!!");
                    if(txfNumerator1.getText().equals("")) lblAnswer.setText("Genera Los Operandos Primero!!!");
                }else {
                    lblSign.setIcon(new ImageIcon("divide.png"));
                    n1 = Integer.parseInt(txfNumerator1.getText());
                    d1 = Integer.parseInt(txfDenominator1.getText());
                    a.set(n1,d1);
                    n2 = Integer.parseInt(txfNumerator2.getText());
                    d2 = Integer.parseInt(txfDenominator2.getText());
                    b.set(n2,d2);
                    c.divide(a,b);
                    rn = Integer.parseInt(txfNumerator.getText());
                    rd = Integer.parseInt(txfDenominator.getText());
                    d.set(rn,rd);
                    if(c.equals(d)) lblAnswer.setText("Bien Hecho!!!");
                    else lblAnswer.setText("La Respuesta Correcta Es --> " + c.toString());
                }
            }
        }
    }
 
}
