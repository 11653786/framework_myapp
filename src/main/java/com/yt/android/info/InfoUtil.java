package com.yt.android.info;

import com.yt.android.R;
import com.yt.android.entity.Attachment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.info
 * @date 2016/4/12 0012 15:01
 * @descption: 疯狂的王麻子团队!
 */
public class InfoUtil {


    /**
     * 获取校园风采的数据给sqlLite存储
     */
    public static List<Attachment> getXjfc() {
        Attachment attachment = new Attachment("行政楼", R.drawable.xingzhenglou, "行政楼是松江大学城最高的建筑，是上海工程技术大学的标志性建筑之一。行政楼分为A楼B楼，共19层。第19层是行政楼的观光大厅，从观光大厅的玻璃窗向外眺望，整个松江大学城的优美风景引入眼帘", "3");
        Attachment attachment1 = new Attachment("教学楼", R.drawable.jiaoxuelou, "上海工程技术大学教学楼分为ABCDEF楼，教学楼内还设有J号楼，教学楼是同学们平时上课来使用的，也是各个院系辅导员的办公地点，空教室也可供同学们自习使用。教师内配备有完整的电脑，投影仪，音响，新的课桌椅等完善的硬件设施。", "3");
        Attachment attachment2 = new Attachment("师生活动", R.drawable.shishenghuodong, "师生活动中心是离学校南入口最近的学校建筑，是学校为了人性化充实学生的课余时间而建立的一栋集休闲娱乐学习工作于一体的综合建筑。整个师活配备了无线网络sues-wlan，用户名为学号，密码为生日。一楼大厅有无线上网区、学生事务服务中心和校医务室，二楼有报告厅、卡拉ok厅等供学生休闲娱乐的场所。三楼是校团委、学生会和社联办公场所。", "3");
        Attachment attachment3 = new Attachment("食堂", R.drawable.shitang, "行政楼是松江大学城最高的建筑，是上海工程技术大学的标志性建筑之一。行政楼分为A楼B楼，共19层。第19层是行政楼的观光大厅，从观光大厅的玻璃窗向外眺望，整个松江大学城的优美风景引入眼帘", "3");
        Attachment attachment4 = new Attachment("体育馆", R.drawable.tiyuguan, "我校体育场馆总面积为 93951 平方米 ，其中室内场馆面积为 14793 平方米 ，室外场馆面积为 79158 平方米，学校重视体育设施的规划与建设，有步骤的加大运动场馆的建设力度，建成了田径运动场、足球场、网球场、篮球场、排球场、乒乓球、武术、健美健身、体操、单双杠区等完善的运动场馆。体育馆配备了供比赛用的较一流的辅助设施，还得到了中国大学生篮球协会的认可把CUBA 全国大学生篮球联赛十周年庆典放在上海工程技术大学，学校体育馆作为本次庆典的主场地。\n", "3");
        Attachment attachment5 = new Attachment("图书馆楼", R.drawable.tushuguan, "上海工程技术大学图书馆是一所功能齐全、文献载体多样、专业人员结构合理、服务设施和手段较为先进的教学服务型图书馆。馆藏中外文纸质文献100余万册；中外文科技期刊近3000种。图书馆近年来加大了数字图书馆建设的力度，现有国内外数据库二十余种，如国内的超星电子图书、维普中文期刊、国研网等全文数据库；国外的有Springer Link、EBSCO 、Ei、CPCI、SD、IEEE、PQDD、ASME、ISI等数据库；采用镜像方式购买的有万方中国学位论文全文数据库、中国学术会议论文全文数据库以及清华同方期刊全文数据库、Apabi电子书等。", "3");
        Attachment attachment6 = new Attachment("艺术楼", R.drawable.yishulou, "上海工程技术大学艺术楼是中法时装设计师学院的教学地点，是上海第一所获得国家批准的中法合作的时装院校，是由法国国际时装学院IFA Paris和上海工程技术大学于2002年联合成立。学院设在上海工程技术大学艺术楼内，它把丰富的欧洲文化及艺术、巴黎高级时装及成衣的制作和营销技术带到了上海，并致力于艺术与商业的融合，培养独具创造力的综合时装设计人才", "3");
        List<Attachment> list = new ArrayList<Attachment>();
        list.add(attachment);
        list.add(attachment1);
        list.add(attachment2);
        list.add(attachment3);
        list.add(attachment4);
        list.add(attachment5);
        list.add(attachment6);
        return list;
    }

}
