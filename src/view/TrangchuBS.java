package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TrangchuBS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangchuBS frame = new TrangchuBS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangchuBS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 577);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(102, 205, 170));
		desktopPane.setBounds(0, 0, 161, 540);
		contentPane.add(desktopPane);
		
		JButton btnNewButton = new JButton("THÔG TIN BỆNH NHÂN");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnNewButton.setBackground(Color.CYAN);
            	btnNewButton.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnNewButton.setBackground(UIManager.getColor("CYAN")); // Màu nền mặc định của button
            	btnNewButton.setForeground(UIManager.getColor("WHITE")); // Màu văn bản mặc định của button
            }
        });
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View();
				dispose();
			}
		});
		btnNewButton.setBounds(0, 205, 161, 45);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LẬP BỆNH ÁN");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnNewButton_1.setBackground(Color.CYAN);
            	btnNewButton_1.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnNewButton_1.setBackground(UIManager.getColor("CYAN")); // Màu nền mặc định của button
            	btnNewButton_1.setForeground(UIManager.getColor("Button.foreground")); // Màu văn bản mặc định của button
            }
        });
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_1.setBounds(0, 248, 161, 45);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_1();
				dispose();
			}
		});
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("QUẢN LÝ HỒ SƠ");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(102, 205, 170));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnNewButton_2.setBackground(Color.CYAN);
            	btnNewButton_2.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnNewButton_2.setBackground(UIManager.getColor("CYAN")); // Màu nền mặc định của button
            	btnNewButton_2.setForeground(UIManager.getColor("Button.foreground")); // Màu văn bản mặc định của button
            }
        });
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_2.setBounds(0, 291, 161, 45);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_2();
				dispose();
			}
		});
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("QUẢN LÝ BỆNH NHÂN");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(102, 205, 170));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	btnNewButton_3.setBackground(Color.CYAN);
            	btnNewButton_3.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	btnNewButton_3.setBackground(UIManager.getColor("CYAN")); // Màu nền mặc định của button
            	btnNewButton_3.setForeground(UIManager.getColor("Button.foreground")); // Màu văn bản mặc định của button
            }
        });
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_3();
				dispose();
			}
		});
		btnNewButton_3.setBounds(0, 334, 161, 45);
		desktopPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TrangchuBS.class.getResource("/view/iconbenhvien.png")));
		lblNewLabel.setBounds(10, 37, 141, 113);
		desktopPane.add(lblNewLabel);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(160, 111, 689, 429);
		contentPane.add(desktopPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TrangchuBS.class.getResource("/view/anhbacsi.jpg")));
		lblNewLabel_2.setBounds(0, 0, 689, 429);
		desktopPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("DOCTOR MANAGER");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Eras Bold ITC", Font.BOLD, 40));
		lblNewLabel_1.setBounds(297, 29, 471, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TrangchuBS.class.getResource("/view/Bacsi1.png")));
		lblNewLabel_3.setBounds(181, 0, 120, 131);
		contentPane.add(lblNewLabel_3);
	}
	private void View() {
		ThongTinBenhNhanView view = new ThongTinBenhNhanView();
		view.setVisible(true);
	}
	
	private void View_1() {
		DangKiBenhAn view = new DangKiBenhAn();
		view.setVisible(true);
	}
	
	private void View_2() {
		HoSoBenhAnView view = new HoSoBenhAnView();
		view.setVisible(true);
	}
	
	private void View_3() {
		HienThiView view = new HienThiView();
		view.setVisible(true);
	}
}
