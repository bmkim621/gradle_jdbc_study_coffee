package gradle_jdbc_study_coffee.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import gradle_jdbc_study_coffee.jdbc.ConnectionProvider;

import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoffeeManagementUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;
	private JTextField tfName;
	
	private JButton btnInput;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CoffeeManagementUI() throws SQLException {
		initComponents();
	}
	private void initComponents() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblCode = new JLabel("제품코드");
		pContent.add(lblCode);
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfCode = new JTextField();
		pContent.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblName = new JLabel("제품명");
		pContent.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		
		//제품명
		tfName = new JTextField();
		tfName.setEnabled(false);
		pContent.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblPrice = new JLabel("제품단가");
		pContent.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfPrice = new JTextField();
		pContent.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblblank0 = new JLabel("");
		pContent.add(lblblank0);
		
		JLabel lblblank1 = new JLabel("");
		pContent.add(lblblank1);
		
		JLabel lblSaleCnt = new JLabel("판매수량");
		pContent.add(lblSaleCnt);
		lblSaleCnt.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfSaleCnt = new JTextField();
		pContent.add(tfSaleCnt);
		tfSaleCnt.setColumns(10);
		
		JLabel lblblank2 = new JLabel("");
		pContent.add(lblblank2);
		
		JLabel lblblank3 = new JLabel("");
		pContent.add(lblblank3);
		
		JLabel lblMarginRate = new JLabel("마진율");
		pContent.add(lblMarginRate);
		lblMarginRate.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfMarginRate = new JTextField();
		pContent.add(tfMarginRate);
		tfMarginRate.setColumns(10);
		
		JPanel pButton = new JPanel();
		contentPane.add(pButton, BorderLayout.SOUTH);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		pButton.add(btnInput);
		
		JButton btnSalePrice = new JButton("출력1");
		pButton.add(btnSalePrice);
		
		JButton btnMarginPrice = new JButton("출력2");
		pButton.add(btnMarginPrice);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnInput) {
			do_btnInput_actionPerformed(arg0);
		}
	}
	
	//입력버튼 => 입력한 데이터들이 sale 테이블로
	protected void do_btnInput_actionPerformed(ActionEvent arg0) {
		
	}
	
}
