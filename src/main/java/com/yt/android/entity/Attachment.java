package com.yt.android.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类给sqlite存储数据的
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.entity
 * @date 2016/4/12 0012 14:22
 * @descption: 疯狂的王麻子团队!
 */
public class Attachment implements Serializable {

    //主键
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
    private String type;


    public Attachment() {
    }


    public Attachment(String title, String content, String type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public Attachment(int id, String title, int image, Date createDate, String type, String content) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.createDate = createDate;
        this.type = type;
    }

    public Attachment(String title, int image, String content, String type) {
        this.image = image;
        this.content = content;
        this.title = title;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
