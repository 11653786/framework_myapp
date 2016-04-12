package com.yt.android.help;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yt.android.entity.Attachment;
import com.yt.android.info.InfoUtil;

import java.util.Date;

/**
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.dbhelp
 * @date 2016/4/12 0012 14:36
 * @descption: 疯狂的王麻子团队!
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    //版本
    public static final int VERSION = 1;            //数据库版本
    //数据库名称
    public static final String dbName = "test.db";    //数据库名称
    //数据库表的创建
    private static final String createAttachmentSql = "create table attachment(id integer primary key autoincrement, title varchar(255),image integer,createDate DATETIME DEFAULT CURRENT_TIMESTAMP,type varchar(10),content blob)";

    public static final String insertSql = "insert into attachment(id,title,image,createDate,type,content) values(null,?,?,?,?,?)";


    /**
     * 在SQLiteOpenHelper的子类当中，必须有该构造函数
     *
     * @param context 上下文对象
     * @param name    数据库名称
     * @param factory
     * @param version 当前数据库的版本，值必须是整数并且是递增的状态
     */
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }

    public DataBaseHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    public DataBaseHelper(Context context, String name) {
        this(context, name, VERSION);
    }

    //该函数是在第一次创建的时候执行，实际上是第一次得到SQLiteDatabase对象的时候才会调用这个方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        //execSQL用于执行SQL语句
        db.execSQL(createAttachmentSql);
        for (int a = 0; a < InfoUtil.getNews().size(); a++) {
            Attachment attachment = InfoUtil.getNews().get(a);
            db.execSQL(DataBaseHelper.insertSql, new Object[]{attachment.getTitle(), attachment.getImage(), new Date(), "1", attachment.getContent()});
        }
    }

    /**
     * 升级sqLite的时候有用,version由自己控制
     *
     * @param arg0
     * @param arg1
     * @param arg2
     */
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        System.out.println("upgrade a database");
    }
}
