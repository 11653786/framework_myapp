package com.yt.android.help;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yt.android.entity.Attachment;
import com.yt.android.util.InfoUtil;
import com.yt.android.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static final String getListByType = "select * from attachment where type=?";
    //主键查询的sql
    public static final String getAttachmentById = "select * from attachment where id=?";

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
        //初始化新闻数据]
        initNews(InfoUtil.getNews(), db);
        initNews(InfoUtil.getIntroduce(), db);
        initNews(InfoUtil.getXjfc(), db);
        initNews(InfoUtil.getSubject(), db);
    }

    /**
     * 新闻数据加入
     *
     * @param db
     */
    private void initNews(List<Attachment> attachments, SQLiteDatabase db) {
        for (int a = 0; a < attachments.size(); a++) {
            Attachment attachment = attachments.get(a);
            db.execSQL(DataBaseHelper.insertSql, new Object[]{attachment.getTitle(), attachment.getImage(), new Date(), attachment.getType(), attachment.getContent()});
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


    public static SQLiteDatabase createDb(Context context) {
        //上下文,数据库名称,null,版本
        DataBaseHelper dbHelper = new DataBaseHelper(context, DataBaseHelper.dbName, null, DataBaseHelper.VERSION);
        //创建的时候执行
        return dbHelper.getWritableDatabase();
    }

    /**
     * 获取sqlite游标的方法
     *
     * @param context
     * @param params
     * @return
     */
    public static Cursor getCursor(Context context, String sql, String params) {
        SQLiteDatabase db = createDb(context);
        return db.rawQuery(sql, new String[]{params});
    }

    /**
     * 获取实体类的方法
     *
     * @param cursor
     * @return
     */
    public static List<Attachment> getAttachmentList(Cursor cursor) {
        List<Attachment> attachments = new ArrayList<Attachment>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            int image = cursor.getInt(2);
            Date createDate = DateUtil.DateFormatter(cursor, "createDate");
            //String dateFormatter = DateUtil.DateFormatter(date, DateUtil.formatter);
            String types = cursor.getString(4);
            String content = cursor.getString(5);
            Attachment attachment = new Attachment(id, title, image, createDate, types, content);
            attachments.add(attachment);
        }
        return attachments;
    }

    /**
     * 主键查询
     * @param context
     * @param sql
     * @param id
     * @return
     */
    public static Attachment findAttachmentById(Context context, String sql, String id) {
        List<Attachment> attachments = getAttachmentList(getCursor(context, sql, id));
        if (!attachments.isEmpty()) {
            return attachments.get(0);
        }
        return null;
    }
}
