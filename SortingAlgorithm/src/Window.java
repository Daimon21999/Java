import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Window extends JFrame{

    public class SetJRadiobutton extends JRadioButton {
        SetJRadiobutton(String text,String actionCommand,boolean selected){
            this.setText(text);
            this.setSelected(selected);
            this.setActionCommand(actionCommand);
        }

        public void setFont(int count,JRadioButton [] radioButtons){
            for(int i = 0; i < count;i++){
                radioButtons[i].setFont(new Font("Monospaced Bold",Font.ITALIC,20));
            }
        }

        public void addGroup(int count, JRadioButton [] radioButtons,ButtonGroup group){
            for(int i = 0; i < count;i++){
                group.add(radioButtons[i]);
            }
        }

    }


    public Window(){
        super("Sorting algorithms");
        setLayout(new FlowLayout());
        setBounds(400,100,300,400);

        ButtonGroup group = new ButtonGroup();
        /*JRadioButton radioButton1 = new JRadioButton("Bubble sort",true);
        radioButton1.setActionCommand("b");*/

        SetJRadiobutton radioButton1 = new SetJRadiobutton("Bubble sort","b",true);SetJRadiobutton radioButton2 = new SetJRadiobutton("Insertion sort","i",false);SetJRadiobutton radioButton3 = new SetJRadiobutton("Selection sort","s",false);SetJRadiobutton radioButton4 = new SetJRadiobutton("Shaker sort","sh",false);SetJRadiobutton radioButton5 = new SetJRadiobutton("Quick sort","q",false);SetJRadiobutton radioButton6 = new SetJRadiobutton("Heap sort","h",false);
        JLabel result = new JLabel("Result");
        JButton sort = new JButton("Sort");
        sort.setActionCommand("sort");
        JButton test = new JButton("Test");
        test.setActionCommand("test");
        SetJRadiobutton []arr = {radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6};
        radioButton1.setFont(6,arr);
        result.setFont(new Font("Monospaced Bold",Font.ITALIC,20));

        radioButton2.addGroup(6,arr,group);

        add(radioButton1);add(radioButton2);add(radioButton3);add(radioButton4);add(radioButton5);add(radioButton6);add(result);add(sort);add(test);

        class Listener implements ActionListener{
            public String chooseRadio = "null";
            @Override
            public void actionPerformed(ActionEvent e){
                if (e.getActionCommand().equals("sort") && (group.getSelection().getActionCommand()!= null)) {
                    Sorting sorting = new Sorting();
                    int []arr;
                    String string="";
                    switch (group.getSelection().getActionCommand()){
                        case "b":
                            arr = sorting.randCreate(10);
                            BubbleSort bubbleSort = new BubbleSort();
                            bubbleSort.sort(arr);
                            string = sorting.toString(arr);
                            result.setText(string);
                            break;
                        case "i":
                            arr = sorting.randCreate(10);
                            InsertionSort insertionSort = new InsertionSort();
                            insertionSort.sort(arr);
                            string = sorting.toString(arr);
                            result.setText(string);
                            break;
                        case "s":
                            arr = sorting.randCreate(10);
                            SelectionSort selectionSort = new SelectionSort();
                            selectionSort.sort(arr);
                            string = sorting.toString(arr);
                            result.setText(string);
                            break;
                        case "sh":
                            arr = sorting.randCreate(10);
                            ShakerSort shakerSort = new ShakerSort();
                            shakerSort.sort(arr);
                            string = sorting.toString(arr);
                            result.setText(string);
                            break;
                        case "q":
                            arr = sorting.randCreate(10);
                            QuickSort quickSort = new QuickSort();
                            quickSort.sort(arr,0,arr.length-1);
                            string = sorting.toString(arr);
                            result.setText(string);
                            break;
                        case "h":
                            arr = sorting.randCreate(10);
                            HeapSort heapSort = new HeapSort();
                            heapSort.sort(arr);
                            string = sorting.toString(arr);
                            result.setText(string);
                            break;
                        default: return;

                    }
                }

                else if (e.getActionCommand().equals("test")){
                    String s = JOptionPane.showInputDialog(null,"Enter number of elements");
                    int count = Integer.parseInt(s);
                    if(count == 0) return;
                    int []arr;
                    Sorting sorting = new Sorting();
                    arr = sorting.randCreate(count);

                    switch (group.getSelection().getActionCommand()) {
                        case "b":
                            BubbleSort bubbleSort = new BubbleSort();
                            String message = bubbleSort.test(arr);
                            result.setText(message);
                            break;
                        case "i":
                            InsertionSort insertionSort = new InsertionSort();
                            message = insertionSort.test(arr);
                            result.setText(message);
                            break;
                        case "s":
                            SelectionSort selectionSort = new SelectionSort();
                            message = selectionSort.test(arr);
                            result.setText(message);
                            break;
                        case "sh":
                            ShakerSort shakerSort = new ShakerSort();
                            message = shakerSort.test(arr);
                            result.setText(message);
                            break;
                        case "q":
                            QuickSort quickSort = new QuickSort();
                            message = quickSort.test(arr);
                            result.setText(message);
                            break;
                        case "h":
                            HeapSort heapSort = new HeapSort();
                            message = heapSort.test(arr);
                            result.setText(message);
                            break;
                        default: return;
                    }

                }
            }
        }
        ActionListener actionListener = new Listener();
        sort.addActionListener(actionListener);
        test.addActionListener(actionListener);

        radioButton1.addActionListener(actionListener);
        radioButton2.addActionListener(actionListener);
        radioButton3.addActionListener(actionListener);
        radioButton4.addActionListener(actionListener);
        radioButton5.addActionListener(actionListener);
        radioButton6.addActionListener(actionListener);
        setVisible(true);

    }




    public static void main(String []args){
        Window window = new Window();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.getContentPane().setBackground(Color.cyan);
    }
}