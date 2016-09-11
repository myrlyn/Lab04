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




public class Calculator
{
    private JFrame calcFrame;
    private JTextField leftOperand;
    private JTextField rightOperand;

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
        frm.add(calcCenter(), BorderLayout.CENTER);
        frm.add(results(), BorderLayout.PAGE_END);
    }

    private JPanel calcNorth()
    {
        JTextField leftOperand = new JTextField(10);
        JTextField rightOperand = new JTextField(10);
        
        JPanel calcNorth = new JPanel();
        calcNorth.add(leftOperand);
        calcNorth.add(rightOperand);
        //added return
        return calcNorth;
    }
    private JPanel calcCenter()
    {
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton multButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton calcTotal = new JButton("=");
        
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

}
