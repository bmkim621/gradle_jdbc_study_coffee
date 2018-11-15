package gradle_jdbc_study_coffee.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import gradle_jdbc_study_coffee.dto.Product;
import gradle_jdbc_study_coffee.dto.Sale;

public class RankListPanel extends JPanel {
	private JTable table;
	//리스트 만들기
	private List<Sale> list;
	
	public void setList(List<Sale> list) {
		this.list = list;
	}
	
	/**
	 * Create the panel.
	 * @param isSale 
	 */
	public RankListPanel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//정렬, 폭 => 메서드 만들고 가변배열로 처리
		setAlignWidth();
	}
	
	//tableCellAlignment, tableSetWidth 추상메서드로 하고 setAlignWidth만 조절하면 됨.
	private void setAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(100, 100, 200, 150, 100, 200, 200, 200, 100, 150);
		
	}
	
	//정렬
	private void tableCellAlignment(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel tcm = table.getColumnModel();
		for(int i = 0 ; i < idx.length ; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	//폭
	private void tableSetWidth(int...width) {
		TableColumnModel tcm = table.getColumnModel();
		for(int i = 0 ; i < width.length ; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	//loadDatas
	public void loadDatas() {
		table.setModel(new DefaultTableModel(
				getDatas(),
				getColumnNames()
			));
	}
	
	//getDatas
	private Object[][] getDatas() {
		//2차원 배열 만들기
		Object[][] datas = new Object[list.size()][];
		for(int i = 0 ; i < list.size() ; i++) {
			datas[i] = getSaleRow(list.get(i));
		}
			
		return datas;
	}

	private Object[] getSaleRow(Sale sale) {
	
		return new Object[] {
				sale.getNo(), sale.getCode(), new Product(sale.getCode()).getName(), sale.getSaleCnt(), 
				sale.getDetail().getSupplytax(), sale.getDetail().getAddtax(), sale.getDetail().getSaleprice(),
				sale.getMarginRate(), sale.getDetail().getMarginprice()
		};
	}

	private String[] getColumnNames() {
		return new String[] {
					"순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액"
				};
	}

}
