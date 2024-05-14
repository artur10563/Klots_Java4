import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testForm extends JFrame {

    private MyLinkedList<String> linkedList;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JTextField textField;
    private JButton addButton;

    public testForm() {
        linkedList = new MyLinkedList<>();
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        textField = new JTextField(20);
        addButton = new JButton("Add");

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = textField.getText();

                if(value.isEmpty())  JOptionPane.showMessageDialog(testForm.this, "Please enter a value.");

                MyLinkedList.MyNode<String> selectedNode = list.getSelectedValue() != null ? linkedList.nodeAt(list.getSelectedIndex()) : null;

                if(selectedNode == null)  JOptionPane.showMessageDialog(testForm.this, "Please select a node.");

                MyLinkedList.MyNode<String> newNode = MyLinkedList.MyNode.createNode(value);

                if (selectedNode == null) {
                    linkedList.addLast(newNode);
                    listModel.addElement(value);
                } else {
                    linkedList.addBefore(selectedNode, newNode);
                    listModel.insertElementAt(value, list.getSelectedIndex());
                }
                textField.setText("");
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter value:"));
        inputPanel.add(textField);
        inputPanel.add(addButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(list), BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        setTitle("Linked List Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(mainPanel);
    }
}
