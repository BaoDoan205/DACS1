package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TrangchuBN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangchuBN frame = new TrangchuBN();
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
	public TrangchuBN() {
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
		
		JButton btnNewButton = new JButton("TRA CỨU BỆNH ÁN");
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

			private void View() {
				// TODO Auto-generated method stub
				HoSoBenhAnView view = new HoSoBenhAnView();
				view.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 228, 161, 56);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HỖ TRỢ");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				View1();
				dispose();
			}
		});
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
		btnNewButton_1.setBounds(0, 283, 161, 56);
		desktopPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TrangchuBN.class.getResource("/view/iconbenhvien.png")));
		lblNewLabel.setBounds(10, 37, 141, 113);
		desktopPane.add(lblNewLabel);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(160, 111, 689, 429);
		contentPane.add(desktopPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TrangchuBN.class.getResource("/view/anhbenhnhan.jpg")));
		lblNewLabel_2.setBounds(0, 0, 689, 429);
		desktopPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT MANAGER");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Eras Bold ITC", Font.BOLD, 40));
		lblNewLabel_1.setBounds(297, 29, 471, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TrangchuBN.class.getResource("/view/Benhnhan1.png")));
		lblNewLabel_3.setBounds(181, 0, 120, 131);
		contentPane.add(lblNewLabel_3);
	}

	protected void View1() {
		// TODO Auto-generated method stub
		ManagerChatter manager = new ManagerChatter();
		manager.setVisible(true);
		CLientChatter client = new CLientChatter();
		client.setVisible(true);
	}

}
