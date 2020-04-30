package com.Practice.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Practice.User.User;
import com.Practice.UserServiceImpl.UserServiceImpl;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserSignUp {

	private JFrame frame;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textContact;
	private JPasswordField passwordField;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSignUp window = new UserSignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	UserServiceImpl services;

	/**
	 * Create the application.
	 */
	public UserSignUp() {
		initialize();
		services=new UserServiceImpl();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 276);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 304, 238);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(70, 44, 46, 14);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textName.setBounds(139, 41, 86, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(70, 69, 46, 14);
		panel.add(lblAge);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(70, 101, 46, 14);
		panel.add(lblContact);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 129, 46, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(0, 0, 6, 20);
		panel.add(passwordField);
		
		textAge = new JTextField();
		textAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textAge.setBounds(140, 69, 86, 20);
		panel.add(textAge);
		textAge.setColumns(10);
		
		textContact = new JTextField();
		textContact.setBounds(140, 97, 86, 20);
		panel.add(textContact);
		textContact.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(140, 126, 86, 20);
		panel.add(txtPassword);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(89, 172, 89, 23);
		panel.add(btnSave);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=new User();
				user.setName(textName.getText());
				user.setAge(Integer.parseInt(textAge.getText()));
				user.setContact(textContact.getText());
				user.setPassword(txtPassword.getText());
				int res = 0;
				
			    try {
			    	res = services.saveUser(user);
				} catch (SQLException e1) {
						// TODO Auto-generated catch block
				    JOptionPane.showMessageDialog(btnSave, e1.getMessage());
				}
				
				
				if(res==0) {
					JOptionPane.showMessageDialog(btnSave,"The data is saved.");
				}
				else {
					JOptionPane.showMessageDialog(btnSave, "The data is not saved.");
				}
			}
		});
		btnNew.setBounds(63, 11, 53, 22);
		panel.add(btnNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(120, 11, 53, 23);
		panel.add(btnEdit);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowAll.setBounds(179, 11, 73, 23);
		panel.add(btnShowAll);
	}
}
