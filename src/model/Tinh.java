package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Tinh implements Serializable{
	private int maTinh;
	private String tenTinh;
	
	public Tinh(int maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}
	
	public int getMaTinh() {
		return maTinh;
	}
	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}
	public String getTenTinh() {
		return tenTinh;
	}
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	

	@Override
	public String toString() {
		return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}

	public static ArrayList<Tinh> getDSTinh() {
		String[] arr_tinh = {"An Giang","Cần Thơ","Tây Ninh","Đông Tháp","Sóc Trăng","Hà Nội","Lào Cai","Lũng Cú","Hà Giang","Đà Nẵng"};
		
		ArrayList<Tinh> listTinh = new ArrayList<Tinh>();
		int i = 0;
		for (String tenTinh : arr_tinh) {
			//tao tung tinh
			Tinh t = new Tinh(i, tenTinh);
			//add tinh vao danh sach
			listTinh.add(t);
		}
		return listTinh;
	}

	public static Tinh getTinhById(int queQuan) {
		
		return Tinh.getDSTinh().get(queQuan);
	}

	public static Tinh getTinhByTen(String string) {
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			if(tinh.tenTinh.equals(listTinh))
				return tinh;
		}
		return null;
	}
	
}
