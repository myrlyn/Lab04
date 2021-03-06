//added package
package solution;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//added import for JPanel
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
//more imports
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Calculator
{
    private JFrame calcFrame;
    private JTextField leftOperand;
    private JTextField rightOperand;
    private JLabel resultLabel;
    private JPanel resultPanel;
    //should be 'getFrame'
   /* public JFrame getcalcFrame()
    {
        return calcFrame;
    }*/
    //added main for testing
    public static void main(String args[]){
        Calculator c = new Calculator();
    }
    public JFrame getFrame()
    {
        return calcFrame;
    }
    public Calculator()
    {
        JFrame   calculatorFrame;
        calculatorFrame = new JFrame();
        calculatorFrame.setLocation(100,100);
        calculatorFrame.setSize(200,400);
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setTitle("Basic Calculator");
        //setframe right before initializeComponents, as the value from getFrame is used there.
        setFrame(calculatorFrame);
        initializeComponents();  //Create and add all components
        //since calculatorFrame points at he same object as getFrame(), this still works fine.
        calculatorFrame.setVisible(true);
        
    }
    //added setFrame
    public void setFrame(JFrame calcFrame){
        this.calcFrame = calcFrame;
    }
    //removed extraneous ';'
    public void initializeComponents()
    {   //add the components to the JFrame, not from a static method
        /*Calculator.add(calcNorth(), BorderLayout.PAGE_START);
        Calculator.add(calcCenter(), BorderLayout.CENTER);
        Calculator.add(results(),BorderLayout.PAGE_END);*/
        JFrame frm = this.getFrame();
        frm.add(calcNorth(),BorderLayout.PAGE_START);
        //use layout location the tests want
        frm.add(calcCenter(), BorderLayout.SOUTH);
        //use layout location the tests want
        frm.add(results(), BorderLayout.AFTER_LINE_ENDS);
    }

    private JPanel calcNorth()
    {
        //use global variables, not local here
        //JTextField leftOperand = new JTextField(10);
        //JTextField rightOperand = new JTextField(10);
        
        leftOperand = new JTextField(10);
        rightOperand = new JTextField(10);
        //set names
        leftOperand.setName("leftOperand");
        rightOperand.setName("rightOperand");
        JPanel calcNorth = new JPanel();
        calcNorth.add(leftOperand);
        calcNorth.add(rightOperand);
        //added return
        return calcNorth;
    }
    private JPanel calcCenter()
    {//prompt wants different labels
        /*JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton multButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton calcTotal = new JButton("=");*/
        JButton addButton = new JButton("ADD");
        JButton subButton = new JButton("SUB");
        JButton multButton = new JButton("MULT");
        JButton divButton = new JButton("DIV");
        JButton calcTotal = new JButton("=");
        
        //set Button Names
        addButton.setName("addButton");
        subButton.setName("subButton");
        multButton.setName("multButton");
        divButton.setName("divButton");
        calcTotal.setName("calcTotal");
        addButton.addActionListener(this.addAction());
        subButton.addActionListener(this.subAction());
        multButton.addActionListener(this.multAction());
        divButton.addActionListener(this.divAction());
        JPanel calcCenter = new JPanel();
        calcCenter.add(addButton);
        calcCenter.add(subButton);
        calcCenter.add(multButton);
        calcCenter.add(divButton);
        calcCenter.add(calcTotal);
        //added return
        return calcCenter;
    }
    //added a results method
    private JPanel results(){
        JPanel res = new JPanel();
        this.resultPanel = res;
        //result panel and label with correct name
        resultLabel = new JLabel();
        resultLabel.setName("resultLabel");
        resultLabel.setText("0");
        //add explicit layout
        res.add(this.resultLabel,BorderLayout.CENTER);
        return res;
    }
    
    public void updateClicked()
    {
        //Get the user text from the text field
        String t = leftOperand.getText();

        //Check to see if it is blank
        if (!t.trim().equals(""))
        {
            //If it is not blank set the test on the label
            rightOperand.setText(t);
        }
        
    }
    public ActionListener addAction(){
        //create an instance of an anonymous class that inherits from ActionListener...
        Calculator calc = this;
        ActionListener a = new ActionListener(){
            public void actionPerformed(ActionEvent E){
                try
                {
                    String lefty = calc.leftOperand.getText();
                    String righty = calc.rightOperand.getText();
                    double lft = Double.parseDouble(lefty);
                    double rt  = Double.parseDouble(righty); 
                    double rs = lft+rt;
                    calc.resultLabel.setText(""+rs);
                }
                catch (NumberFormatException e)
                {
                    //handle non-number input
                    calc.resultLabel.setText("error");
                }
            }
        };
        return a;
    }
    public ActionListener subAction(){
        //create an instance of an anonymous class that inherits from ActionListener...
        Calculator calc = this;
        ActionListener a = new ActionListener(){
            public void actionPerformed(ActionEvent E){
                try
                {
                    String lefty = calc.leftOperand.getText();
                    String righty = calc.rightOperand.getText();
                    double lft = Double.parseDouble(lefty);
                    double rt  = Double.parseDouble(righty); 
                    double rs = lft-rt;
                    calc.resultLabel.setText(""+rs);
                }
                catch (NumberFormatException e)
                {
                  //handle non-number input
                    calc.resultLabel.setText("error");
                }
            }
        };
        return a;
    }
    public ActionListener multAction(){
        //create an instance of an anonymous class that inherits from ActionListener...
        Calculator calc = this;
        ActionListener a = new ActionListener(){
            public void actionPerformed(ActionEvent E){
                try
                {
                    String lefty = calc.leftOperand.getText();
                    String righty = calc.rightOperand.getText();
                    double lft = Double.parseDouble(lefty);
                    double rt  = Double.parseDouble(righty); 
                    double rs = lft*rt;
                    calc.resultLabel.setText(""+rs);
                }
                catch (NumberFormatException e)
                {
                  //handle non-number input
                    calc.resultLabel.setText("error");
                }
            }
        };
        return a;
    }
    public ActionListener divAction(){
        //create an instance of an anonymous class that inherits from ActionListener...
        Calculator calc = this;
        ActionListener a = new ActionListener(){
            public void actionPerformed(ActionEvent E){
                try
                {
                    String lefty = calc.leftOperand.getText();
                    String righty = calc.rightOperand.getText();
                    double lft = Double.parseDouble(lefty);
                    double rt  = Double.parseDouble(righty);
                    //handle divide by 0
                    if (rt != 0){
                        double rs = lft/rt;
                        calc.resultLabel.setText(""+rs);
                    }else{
                        calc.resultLabel.setText("error");
                    }
                }
                catch (NumberFormatException e)
                {
                  //handle non-number input
                    calc.resultLabel.setText("error");
                }
                
            }
        };
        return a;
    }
}
