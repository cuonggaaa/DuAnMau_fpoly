package cuongnvph24076.fpoly.LOPDAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import cuongnvph24076.fpoly.LOPPRODUCT.Sach;
import cuongnvph24076.fpoly.SQLopenhelper.CreateData;

public class SachDao {
    SQLiteDatabase sqLiteDatabase;
    CreateData createData;

    public SachDao(Context context) {
        createData = new CreateData(context);
        sqLiteDatabase = createData.getWritableDatabase();
    }

    public long ADDS(Sach sach) {
        ContentValues values = new ContentValues();
        values.put(Sach.COL_NAME_MALS, sach.getMals());
        values.put(Sach.COL_NAME_TENS, sach.getTens());
        values.put(Sach.COL_NAME_GIAS, sach.getGias());
        values.put(Sach.COL_NAME_tacgia, sach.getTacgia());
        values.put(Sach.COL_NAME_LUOT_MUA, sach.getLuotMua());
        values.put(Sach.COL_SO_LUONG, sach.getSoLuong());
        return sqLiteDatabase.insert(Sach.TB_NAME, null, values);
    }

    public int DELETES(Sach sach) {
        return sqLiteDatabase.delete(Sach.TB_NAME, "maSach=?", new String[]{String.valueOf(sach.getMas())});
    }

    public int UPDATES(Sach sach) {
        ContentValues values = new ContentValues();
        values.put(Sach.COL_NAME_MALS, sach.getMals());
        values.put(Sach.COL_NAME_TENS, sach.getTens());
        values.put(Sach.COL_NAME_GIAS, sach.getGias());
        values.put(Sach.COL_NAME_tacgia, sach.getTacgia());
        values.put(Sach.COL_NAME_LUOT_MUA, sach.getLuotMua());
        values.put(Sach.COL_SO_LUONG, sach.getSoLuong());
        return sqLiteDatabase.update(Sach.TB_NAME, values, "maSach=?", new String[]{String.valueOf(sach.getMas())});
    }

    public List<Sach> GETS() {
        String dl = "SELECT * FROM Sach";
        List<Sach> list = getdata(dl);
        return list;
    }

    public Sach getId(String id) {
        String sql = "SELECT * FROM Sach WHERE maSach=?";
        List<Sach> list = getdata(sql, id);
        return list.get(0);
    }

    public List<Sach> SachTop10() {
        String sql = "select * from Sach order by 'luotMua' desc limit 10";
        List<Sach> list = getdata(sql);
        return list;
    }

    @SuppressLint("Range")
    private List<Sach> getdata(String dl, String... Arays /* có hoặc không nhiều phần tử*/) {
        List<Sach> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(dl, Arays);
        while (cursor.moveToNext()) {
            Sach sach = new Sach();
            sach.setMas(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Sach.COL_NAME_MAS))));
            sach.setMals(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Sach.COL_NAME_MALS))));
            sach.setTens(cursor.getString(cursor.getColumnIndex(Sach.COL_NAME_TENS)));
            sach.setTacgia(cursor.getString(cursor.getColumnIndex(Sach.COL_NAME_tacgia)));
            sach.setGias(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Sach.COL_NAME_GIAS))));
            sach.setLuotMua(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Sach.COL_NAME_LUOT_MUA))));
            sach.setSoLuong(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Sach.COL_SO_LUONG))));
            list.add(sach);
        }
        return list;
    }
}
