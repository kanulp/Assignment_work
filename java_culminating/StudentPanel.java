package java_culminating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentPanel extends JPanel{
	private JLabel lblMarksProgram, lblStudentMark;
	private JTextField txtFirstName, txtLastName, txtEmail, txtPhone;
    private JButton butSave, butCancel;
    private JTextArea marksArea;

    public StudentPanel(){
        initialize();
    }
    
	private void initialize() {
		
		
		this.setLayout (new GridLayout(5, 2));
		this.add(lblFirstName);
		this.add(txtFirstName);
		this.add(lblLastName);
		this.add(txtLastName);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblPhone);
		this.add(txtPhone);
		this.add(butSave);
        this.add(butCancel);
        
        butSave.addActionListener(new SaveButtonHandler());
        butCancel.addActionListener(new CancelButtonHandler());
    }


    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Data saved", "Save Person", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private class SaveButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();

            String result = "Name: " + firstName + " " + lastName + "\n" + "phone: " + phone + "\n" + "Email:" + email;
            JOptionPane.showMessageDialog(null, result,"Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class CancelButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Operation is cancelled", "Save Person", JOptionPane.WARNING_MESSAGE);
        }
    }
}