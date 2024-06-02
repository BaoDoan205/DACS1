package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class DangKi extends JFrame {

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
					DangKi frame = new DangKi();
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
	public DangKi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MẬT KHẨU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(173, 242, 119, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TÊN TÀI KHOẢN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(169, 148, 162, 34);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(360, 150, 250, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ĐĂNG KÝ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_2.setBounds(299, 39, 196, 68);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ĐĂNG KÝ VỚI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(135, 330, 139, 34);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(360, 245, 250, 40);
		contentPane.add(passwordField);
		
		ButtonGroup btg = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton("BÁC SĨ");
		rdbtnNewRadioButton.setBackground(new Color(230, 230, 250));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(341, 329, 78, 40);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("BỆNH NHÂN");
		rdbtnNewRadioButton_1.setBackground(new Color(230, 230, 250));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(501, 329, 109, 40);
		contentPane.add(rdbtnNewRadioButton_1);
		
		btg.add(rdbtnNewRadioButton);
		btg.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_2 = new JButton("ĐĂNG KÝ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(127, 255, 212));
		btnNewButton_2.setBounds(167, 407, 125, 40);
		btnNewButton_2.addActionListener(new ActionListener() {

			private Component DangKi;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnNewRadioButton.isSelected()) {
					try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");
					Statement st = con.createStatement();

					String username = textField.getText();
					String password = new String(passwordField.getPassword());
					String hashedPassword = MD5Util.md5(password);
					
					int n = st.executeUpdate(
							"INSERT INTO doctor(Username, Password)"
									+ "VALUES ('"+username+"','" + hashedPassword + "')");

					if(n > 0) {
						JOptionPane.showMessageDialog(DangKi.this, "Đăng Kí Thành Công");
						int luaChon = JOptionPane.showConfirmDialog(DangKi, "Bạn Muốn Đăng Nhập Ngay", "YES",
								JOptionPane.YES_NO_OPTION);
						if (luaChon == JOptionPane.YES_NO_OPTION) {
							DangNhap1 dn = new DangNhap1();
							dn.setVisible(true);
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(DangKi.this,
								"Tài Khoản Đã Tồn Tại! Yêu cầu Kiểm Tra Lại Thông Tin!");

						st.close();
						con.close();
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}else if(rdbtnNewRadioButton_1.isSelected()) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/management", "root", "");
					Statement st = con.createStatement();
					
					String username = textField.getText();
					String password = new String(passwordField.getPassword());
					String hashedPassword = MD5Util.md5(password);

					int n = st.executeUpdate(
							"INSERT INTO patient(Username, Password)"
									+ "VALUES ('"+username+"','" + hashedPassword + "')");

					if(n > 0) {
						JOptionPane.showMessageDialog(DangKi.this, "Đăng Kí Thành Công");
						int luaChon = JOptionPane.showConfirmDialog(DangKi, "Bạn Muốn Đăng Nhập Ngay", "YES",
								JOptionPane.YES_NO_OPTION);
						if (luaChon == JOptionPane.YES_NO_OPTION) {
							DangNhap1 dn = new DangNhap1();
							dn.setVisible(true);
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(DangKi.this,
								"Tài Khoản Đã Tồn Tại! Yêu cầu Kiểm Tra Lại Thông Tin!");

						st.close();
						con.close();
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				
			}
		});
		
		contentPane.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_3 = new JButton("THOÁT");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBackground(new Color(127, 255, 212));
		btnNewButton_3.setBounds(485, 407, 125, 40);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(DangKi.class.getResource("/view/Bacsi.png")));
		lblNewLabel_4.setBounds(420, 316, 43, 48);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(DangKi.class.getResource("/view/Benhnhan.png")));
		lblNewLabel_5.setBounds(612, 316, 43, 48);
		contentPane.add(lblNewLabel_5);
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
}
