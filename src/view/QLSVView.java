package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.SinhVien;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_maSinhVien;
	public JTable table;
	public JTextField textField1;
	public JTextField textField2;
	public JTextField textField3;
	public JTextField textField4;
	public JTextField textField5;
	public JTextField textField6;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_queQuan1;
	public JRadioButton rdbtn_nam;
	public JRadioButton rdbtn_nu;
	public JTable model_table;
	public JComboBox comboBox_queQuan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 526);
		
		ActionListener actionListener = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.addActionListener(actionListener);
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(actionListener);
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(actionListener);
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(actionListener);
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(actionListener);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuAbout);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About Me");
		mntmNewMenuItem.addActionListener(actionListener);
		menuAbout.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel combobox_queQuan = new JLabel("Quê quán:");
		combobox_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combobox_queQuan.setBounds(10, 13, 66, 22);
		contentPane.add(combobox_queQuan);
		
		JLabel lblMSv = new JLabel("Mã SV:");
		lblMSv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMSv.setBounds(229, 13, 46, 22);
		contentPane.add(lblMSv);
		
		textField_maSinhVien = new JTextField();
		textField_maSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_maSinhVien.setBounds(281, 11, 93, 27);
		contentPane.add(textField_maSinhVien);
		textField_maSinhVien.setColumns(10);
		
		JButton btn_tim = new JButton("Tìm");
		btn_tim.addActionListener(actionListener);
		btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_tim.setBounds(387, 11, 55, 27);
		contentPane.add(btn_tim);
		
		comboBox_queQuan = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(78, 11, 117, 27);
		contentPane.add(comboBox_queQuan);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 46, 503, 2);
		contentPane.add(separator_1);
		
		JLabel lblDanhSchSinh = new JLabel("Danh Sách sinh viên");
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDanhSchSinh.setBounds(20, 49, 487, 22);
		contentPane.add(lblDanhSchSinh);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 SV", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y Sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 79, 503, 146);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 236, 503, 2);
		contentPane.add(separator_1_1);
		
		JLabel Label_thongTinSV = new JLabel("Thông tin sinh viên");
		Label_thongTinSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_thongTinSV.setBounds(20, 236, 209, 22);
		contentPane.add(Label_thongTinSV);
		
		JLabel Label_ID = new JLabel("Mã SV:");
		Label_ID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_ID.setBounds(10, 265, 46, 22);
		contentPane.add(Label_ID);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField1.setColumns(10);
		textField1.setBounds(78, 268, 104, 22);
		contentPane.add(textField1);
		
		JLabel Label_hoTenSV = new JLabel("Họ tên:");
		Label_hoTenSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_hoTenSV.setBounds(10, 300, 46, 22);
		contentPane.add(Label_hoTenSV);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField2.setColumns(10);
		textField2.setBounds(78, 301, 104, 22);
		contentPane.add(textField2);
		
		JLabel Label_queQuan1 = new JLabel("Quê quán:");
		Label_queQuan1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_queQuan1.setBounds(10, 338, 66, 22);
		contentPane.add(Label_queQuan1);
		
		JLabel Label_ngaySinh = new JLabel("Ngày sinh:");
		Label_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_ngaySinh.setBounds(10, 373, 66, 22);
		contentPane.add(Label_ngaySinh);
		
		textField3 = new JTextField();
		textField3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField3.setColumns(10);
		textField3.setBounds(78, 373, 104, 22);
		contentPane.add(textField3);
		
		comboBox_queQuan1 = new JComboBox();
		comboBox_queQuan1.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_queQuan1.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan1.setBounds(78, 336, 104, 22);
		contentPane.add(comboBox_queQuan1);
		
		JLabel Label_gioiTinh1 = new JLabel("Giới tính:");
		Label_gioiTinh1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_gioiTinh1.setBounds(269, 268, 66, 22);
		contentPane.add(Label_gioiTinh1);
		
		rdbtn_nam = new JRadioButton("Nam");
		rdbtn_nam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_nam.setBounds(330, 267, 55, 23);
		contentPane.add(rdbtn_nam);
		
		rdbtn_nu = new JRadioButton("Nữ");
		rdbtn_nu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_nu.setBounds(387, 267, 55, 23);
		contentPane.add(rdbtn_nu);
		
		btn_gioiTinh =  new ButtonGroup();
		btn_gioiTinh.add(rdbtn_nam);
		btn_gioiTinh.add(rdbtn_nu);
		
		textField4 = new JTextField();
		textField4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField4.setColumns(10);
		textField4.setBounds(340, 300, 104, 25);
		contentPane.add(textField4);
		
		JLabel Label_diem1 = new JLabel("Điểm 1:");
		Label_diem1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_diem1.setBounds(269, 300, 61, 22);
		contentPane.add(Label_diem1);
		
		textField5 = new JTextField();
		textField5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField5.setColumns(10);
		textField5.setBounds(338, 338, 104, 22);
		contentPane.add(textField5);
		
		JLabel Label_diem2 = new JLabel("Điểm 2:");
		Label_diem2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_diem2.setBounds(270, 340, 60, 22);
		contentPane.add(Label_diem2);
		
		textField6 = new JTextField();
		textField6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField6.setColumns(10);
		textField6.setBounds(338, 373, 104, 22);
		contentPane.add(textField6);
		
		JLabel Label_diem3 = new JLabel("Điểm 3:");
		Label_diem3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Label_diem3.setBounds(270, 375, 60, 22);
		contentPane.add(Label_diem3);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 406, 503, 2);
		contentPane.add(separator_1_1_1);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(actionListener);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_them.setBounds(20, 419, 76, 27);
		contentPane.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(actionListener);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_xoa.setBounds(106, 419, 66, 27);
		contentPane.add(btn_xoa);
		
		JButton btn_capNhat = new JButton("Cập nhật");
		btn_capNhat.addActionListener(actionListener);
		btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_capNhat.setBounds(182, 419, 93, 27);
		contentPane.add(btn_capNhat);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(actionListener);
		btn_luu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_luu.setBounds(340, 419, 66, 27);
		contentPane.add(btn_luu);
		
		JButton btn_huy = new JButton("Hủy bỏ");
		btn_huy.addActionListener(actionListener);
		btn_huy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_huy.setBounds(416, 419, 82, 27);
		contentPane.add(btn_huy);
		
		JButton btn_huyTim = new JButton("Hủy");
		btn_huyTim.addActionListener(actionListener);
		btn_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_huyTim.setBounds(447, 11, 66, 27);
		contentPane.add(btn_huyTim);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
		textField5.setText("");
		textField6.setText("");
		comboBox_queQuan1.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	public void themSinhVienVaoTable(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {
				sv.getMaSinhVien()+"",
				sv.getTenSinhVien(),
				sv.getQueQuan().getTenTinh(),
				sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth()+1)+"/"+(sv.getNgaySinh().getYear()+1900),
				(sv.isGioiTinh()?"Nam":"Nữ"),
				sv.getDiemMon1()+"",
				sv.getDiemMon2()+"",
				sv.getDiemMon3()+""});
	}
	public void themHoacCapNhatSinhVien(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(sv)) {
			this.model.insert(sv);
			this.themSinhVienVaoTable(sv);
		}else {
			this.model.update(sv);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i,  0)+"";
				if(id.equals(sv.getMaSinhVien()+"")) {
					model_table.setValueAt(sv.getMaSinhVien()+"", i, 0);
					model_table.setValueAt(sv.getTenSinhVien()+"", i, 1);
					model_table.setValueAt(sv.getQueQuan().getTenTinh()+"", i, 2);
					model_table.setValueAt(sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth()+1)+"/"+(sv.getNgaySinh().getYear()+1900)+"", i, 3);
					model_table.setValueAt(sv.isGioiTinh()?"Nam":"Nữ", i, 4);
					model_table.setValueAt(sv.getDiemMon1()+"", i, 5);
					model_table.setValueAt(sv.getDiemMon2()+"", i, 6);
					model_table.setValueAt(sv.getDiemMon3()+"", i, 7);
				}
			}
		}
	}

	
	public SinhVien getSinhVienDaChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int maSinhVien = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenSinhVien = model_table.getValueAt(i_row, 1)+"";
		
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		SinhVien sv = new SinhVien(maSinhVien, textGioiTinh, tinh, ngaySinh, gioiTinh, diemMon3, diemMon3, diemMon3);
		return sv;
	}
	public void hienThiThongTinCapNhat() {
		SinhVien sv = getSinhVienDaChon();
		
		
		this.textField1.setText(sv.getMaSinhVien()+"");
		this.textField2.setText(sv.getTenSinhVien()+"");
		this.comboBox_queQuan1.setSelectedItem(sv.getQueQuan().getTenTinh());
		String s_ngaySinh = sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth()+1)+"/"+(sv.getNgaySinh().getYear()+1900);
		this.textField3.setText(s_ngaySinh+"");
		if(sv.isGioiTinh()) {
			rdbtn_nam.setSelected(true);
		}else {
			rdbtn_nu.setSelected(true);
		}
		this.textField4.setText(sv.getDiemMon1()+"");
		this.textField5.setText(sv.getDiemMon2()+"");
		this.textField6.setText(sv.getDiemMon3()+"");
	}

	public void hienHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc muốn xóa?");
		if(luaChon==JOptionPane.YES_OPTION) {
			SinhVien sv = getSinhVienDaChon();
			this.model.delete(sv);
			model_table.removeRow(i_row);
		}
		
	}

	public void thucHienThem() {
		//get data
		int maSinhVien = Integer.valueOf(this.textField1.getText());
		String tenSinhVien = this.textField2.getText();
		int queQuan = this.comboBox_queQuan1.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField3.getText());
		boolean gioiTinh = true;
		if(this.rdbtn_nam.isSelected()) {
			gioiTinh = true;
		}else if(this.rdbtn_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField4.getText());
		float diemMon2 = Float.valueOf(this.textField5.getText());
		float diemMon3 = Float.valueOf(this.textField6.getText());
		
		SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatSinhVien(sv);
		
	}

	public void thucHienTim() {
		//goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		//thuc hien tim kiem
		int queQuan = this.comboBox_queQuan.getSelectedIndex()-1;
		String maSinhVienTimKiem = this.textField_maSinhVien.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<Integer>();
		if(queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i,  2)+"";
				String id = model_table.getValueAt(i,  0)+"";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if(maSinhVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i,  0)+"";
				
				if(!id.equals(maSinhVienTimKiem)) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaSinhVienCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i,  0)+"";
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (SinhVien sv : this.model.getDsSinhVien()) {
			this.themSinhVienVaoTable(sv);
		}
		
	}

	public void thucThiAbout() {
		JOptionPane.showConfirmDialog(this, "Phần mềm quản lý Sinh Viên");
		
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có mốn thoát khỏi chương trình?", "Exit", JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sv : this.model.getDsSinhVien()) {
				oos.writeObject(sv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void openFile(File file) {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			SinhVien sv = null;
			while((sv = (SinhVien) ois.readObject())!=null) {
				ds.add(sv);
			}
			
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	public void thucHienSave() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
		
	}

	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
		
	}
	
}
