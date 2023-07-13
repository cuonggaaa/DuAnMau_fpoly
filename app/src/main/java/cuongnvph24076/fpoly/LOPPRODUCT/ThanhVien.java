package cuongnvph24076.fpoly.LOPPRODUCT;

public class ThanhVien {
    int IDTV;
    String HoTenTV;
    String NamsinhTV;
    int taiKhoan;

    public ThanhVien() {
    }

    public ThanhVien(int IDTV, String hoTenTV, String namsinhTV, int taiKhoan) {
        this.IDTV = IDTV;
        HoTenTV = hoTenTV;
        NamsinhTV = namsinhTV;
        this.taiKhoan = taiKhoan;
    }

    public int getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(int taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public int getIDTV() {
        return IDTV;
    }

    public void setIDTV(int IDTV) {
        this.IDTV = IDTV;
    }

    public String getHoTenTV() {
        return HoTenTV;
    }

    public void setHoTenTV(String hoTenTV) {
        HoTenTV = hoTenTV;
    }

    public String getNamsinhTV() {
        return NamsinhTV;
    }

    public void setNamsinhTV(String namsinhTV) {
        NamsinhTV = namsinhTV;
    }

    public static final String TB_NAME = "ThanhVien";
    public static final String COL_NAME_ID = "maTV";
    public static final String COL_NAME_HOTEN = "hoTen";
    public static final String COL_NAME_NAMSINH = "namSinh";
    public static final String COL_TAI_KHOAN = "taiKhoan";
}
