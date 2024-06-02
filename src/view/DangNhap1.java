package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DangNhap1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap1 frame = new DangNhap1();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MẬT KHẨU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(156, 252, 119, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TÊN TÀI KHOẢN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(156, 148, 162, 34);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(373, 148, 250, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(373, 242, 250, 40);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_2.setBounds(270, 39, 278, 68);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ĐĂNG NHẬP VỚI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(132, 343, 162, 34);
		contentPane.add(lblNewLabel_3);
		
		
		ButtonGroup btg = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("BÁC SĨ");
		rdbtnNewRadioButton.setBackground(new Color(230, 230, 250));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(321, 342, 76, 40);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("BỆNH NHÂN");
		rdbtnNewRadioButton_1.setBackground(new Color(230, 230, 250));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(498, 342, 109, 40);
		contentPane.add(rdbtnNewRadioButton_1);
		
		btg.add(rdbtnNewRadioButton);
		btg.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_2 = new JButton("ĐĂNG NHẬP");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(127, 255, 212));
		btnNewButton_2.setBounds(156, 419, 125, 40);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(DangKi.class.getResource("/view/Bacsi.png")));
		lblNewLabel_4.setBounds(403, 329, 43, 48);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(DangKi.class.getResource("/view/Benhnhan.png")));
		lblNewLabel_5.setBounds(613, 329, 43, 48);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				if (rdbtnNewRadioButton.isSelected()) {
					String user = textField.getText();
					String pass = new String(passwordField.getPassword());
					String hashedPassword = MD5Util.md5(pass);
					
					if (Valid(user, hashedPassword)) {
						JOptionPane.showMessageDialog(DangNhap1.this, "Đăng Nhập Thành Công");
						View();
						dispose();
					} else {
						JOptionPane.showMessageDialog(DangNhap1.this,
								"Tài Khoản Không Tồn Tại! Yêu cầu Kiểm Tra Lại Thông Tin!");

					}
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					String user = textField.getText();
					String pass = new String(passwordField.getPassword());
					String hashedPassword = MD5Util.md5(pass);
					
					if (Valid1(user, hashedPassword)) {
						JOptionPane.showMessageDialog(DangNhap1.this, "Đăng Nhập Thành Công");
						View2();
						dispose();
					} else {
						JOptionPane.showMessageDialog(DangNhap1.this,
								"Tài Khoản Không Tồn Tại! Yêu cầu Kiểm Tra Lại Thông Tin!");

					}
				}

			}
		});
		
		contentPane.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_3 = new JButton("THOÁT");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(127, 255, 212));
		btnNewButton_3.setBounds(498, 419, 125, 40);
		contentPane.add(btnNewButton_3);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			private Component DangKi;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int luaChon = JOptionPane.showConfirmDialog(DangKi, "Bạn Muốn Thoát Khỏi Chương Trình", "EXIT",
						JOptionPane.YES_NO_OPTION);
				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});	
	}
	
	private boolean Valid(String user, String hashedPassword) {

		String url = "jdbc:mySQL://localhost:3306/management";
		String username = "root";
		String password = "";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);

			String query = "SELECT * FROM doctor WHERE Username = ? AND Password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, hashedPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			return resultSet.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	private boolean Valid1(String user, String hashedPassword) {

		String url = "jdbc:mySQL://localhost:3306/management";
		String username = "root";
		String password = "";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);

			String query = "SELECT * FROM patient WHERE username = ? AND password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, hashedPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			return resultSet.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	private void View() {
		TrangchuBS view = new TrangchuBS();
		view.setVisible(true);
	}
	
	private void View2() {
		TrangchuBN view = new TrangchuBN();
		view.setVisible(true);
	}
}
