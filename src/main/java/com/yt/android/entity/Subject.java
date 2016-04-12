package com.yt.android.entity;

/**
 * 特色场馆的关系表
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.entity
 * @date 2016/4/12 0012 14:27
 * @descption: 疯狂的王麻子团队!
 */
public class Subject {
    //特色场馆的id
    private int attachmentId;
    private String title;
    private String content;
    private int image;

    public Subject() {
    }

    public Subject(int attachmentId, String title, String content, int image) {
        this.attachmentId = attachmentId;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
