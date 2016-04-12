package com.yt.android.dbhelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.dbhelp
 * @date 2016/4/12 0012 14:36
 * @descption: 疯狂的王麻子团队!
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //版本
    public static final int VERSION = 1;            //数据库版本
    //数据库名称
    public static final String dbName = "test.db";    //数据库名称
    //数据库表的创建
    private static final String createAttachmentSql = "create Table attachment(id integer primary key autoincrement, title varchar(255),image integer,createDate DATETIME DEFAULT CURRENT_TIMESTAMP,type varchar(10),content blob)";
    //学院关系表
    private static final String createSubjectSql = "create Table attachment(id integer primary key autoincrement,attachmentId integer, title varchar(255),image integer,content blob)";

    /**
     * 在SQLiteOpenHelper的子类当中，必须有该构造函数
     *
     * @param context 上下文对象
     * @param name    数据库名称
     * @param factory
     * @param version 当前数据库的版本，值必须是整数并且是递增的状态
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    public DatabaseHelper(Context context, String name) {
        this(context, name, VERSION);
    }

    //该函数是在第一次创建的时候执行，实际上是第一次得到SQLiteDatabase对象的时候才会调用这个方法
    @Override
    public void onCreate(SQLiteDatabase db) {

     /*   //主键
        private int id;
        //标题
        private String title;
        //图片
        private int image;
        //内容
        private String content;
        //只有新闻有createTime
        private Date createDate;
        //类型 1.新闻 2.校园概况 3.校园风采 4.特色展馆 5.院系介绍
        private String type;*/


        System.out.println("create a database");
        //execSQL用于执行SQL语句
        db.execSQL(createAttachmentSql);
        db.execSQL(createSubjectSql);
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
