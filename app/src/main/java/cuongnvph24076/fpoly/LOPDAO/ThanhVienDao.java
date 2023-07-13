package cuongnvph24076.fpoly.LOPDAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import cuongnvph24076.fpoly.LOPPRODUCT.ThanhVien;
import cuongnvph24076.fpoly.SQLopenhelper.CreateData;

public class ThanhVienDao {
    SQLiteDatabase sqLitetv;
    CreateData createData;

    public ThanhVienDao(Context context) {
        createData = new CreateData(context);
        sqLitetv = createData.getWritableDatabase();
    }

    public long ADDTV(ThanhVien thanhVien) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ThanhVien.COL_NAME_HOTEN, thanhVien.getHoTenTV());
        contentValues.put(ThanhVien.COL_NAME_NAMSINH, thanhVien.getNamsinhTV());
        contentValues.put(ThanhVien.COL_TAI_KHOAN, thanhVien.getTaiKhoan());
        return sqLitetv.insert(ThanhVien.TB_NAME, null, contentValues);
    }

    public int UPDATETV(ThanhVien thanhVien) {
        ContentValues values = new ContentValues();
        values.put(ThanhVien.COL_NAME_HOTEN, thanhVien.getHoTenTV());
        values.put(ThanhVien.COL_NAME_NAMSINH, thanhVien.getNamsinhTV());
        return sqLitetv.update(ThanhVien.TB_NAME, values, "maTV=?", new String[]{String.valueOf(thanhVien.getIDTV())});
    }

    public int DELETETV(ThanhVien thanhVien) {
        return sqLitetv.delete(ThanhVien.TB_NAME, "maTV=?", new String[]{String.valueOf(thanhVien.getIDTV())});
    }

    // get tất cả dữ liệu
    public List<ThanhVien> GETTV() {
        String dl = "SELECT * FROM ThanhVien";
        List<ThanhVien> list = getdata(dl);
        return list;
    }

    // get dữ liệu theo id
    public ThanhVien getId(String id) {
        String dl = "SELECT * FROM ThanhVien WHERE maTV==? ";
        List<ThanhVien> list = getdata(dl, id);
        return list.get(0);
    }
// get dữ liệu nhiều tham số
    @SuppressLint("Range")
    private List<ThanhVien> getdata(String dl, String... Arays) {
        List<ThanhVien> list = new ArrayList<>();
        Cursor cursor = sqLitetv.rawQuery(dl, Arays);
        while (cursor.moveToNext()) {
            ThanhVien thanhVien = new ThanhVien();
            thanhVien.setIDTV(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ThanhVien.COL_NAME_ID))));
            thanhVien.setHoTenTV(cursor.getString(cursor.getColumnIndex(ThanhVien.COL_NAME_HOTEN)));
            thanhVien.setNamsinhTV(cursor.getString(cursor.getColumnIndex(ThanhVien.COL_NAME_NAMSINH)));
            thanhVien.setTaiKhoan(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ThanhVien.COL_TAI_KHOAN))));
            list.add(thanhVien);
        }
        return list;
    }

}
