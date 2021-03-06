package com.yt.android.util;

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


    /**
     * 获取新闻数据
     *
     * @return
     */
    public static List<Attachment> getNews() {
        List<Attachment> list = new ArrayList<Attachment>();
        Attachment attachment = new Attachment("我校参展第十三届教博会 展示学校“互联网+教育”新成果", R.drawable.xinwen11, "4月8日上午，“第十三届上海教育教博会”在上海展览中心开幕。我校应邀参加此次教博会，在高校展区展示我校建校37周年以来“互联网+教育”所取得的成果。展会首日，副校长史健勇参观了本校展区。参展前，学校向各学院和职能部门征集体现学校、学院办学特色和办学水平的优秀展品，并组织校长办公室、科研处、教务处、大学科技园等职能部门和学院对展品进行遴选、设计，最终将学校近年来在高校知识服务平台建设、互联网领域的专业和课程建设、在线开放课程建设以及大学生创新创业成果等情况展示在公众面前，让社会各界对我校的发展现状以及未来发展的愿景方向有更加深入、更加全面的了解。上海市轨道交通运营安全检测与评估服务协同创新中心基于互联网+大数据的特大城市轨道交通运营安全监测预警平台、高强激光智能加工装备关键技术产学研开发中心3D打印技术、电子电气工程学院支持自适应感知的绿色非核心路由器、智能手表等的展示吸引了众多参观者。", "1");
        Attachment attachment1 = new Attachment("校园好声音，唱响工程大", R.drawable.xinwen22, "11月18日晚，第二届校园好声音工程大选拔赛决赛在志宏堂圆满落下帷幕。此次活动由上海工程技术大学易班发展中心主办，管理学院承办，材料工程学院、化学化工学院、机械工程学院共同协办。校易班发展研究中心阎小奂老师、各学院负责易班工作的辅导员老师及易班工作站站长等出席担任评委工作。\n" +
                "大学的生活缤纷多彩，大学生也是各个身怀绝技，校园好声音为我校青年学子提供了一个展示自我的平台，让声音为我们自由的梦而唱响，让旋律随着我们不羁的心而飘扬。工程大校园好声音选拨赛历经两个月的时间，来自于各个学院70余名本科生和研究生参赛，通过几轮淘汰赛和易班网站线上投票，最终选出校园十强选手入围决赛。\n" +
                "决赛开场十强选手们合唱了《最初的梦想》，唱出了我们青年学生的音乐之梦，也鼓励到场的观众要相信“最初的梦想，绝对会到达”。接下来就是紧张的两场淘汰赛：“帮帮唱“和“个人拉锯战”，在这两个环节中，每一位选手都竭尽全力地展示自己的音乐才能，尽管他们的歌喉或许还没有那么专业，他们的表演或许还不是那么的尽善尽美，但是完完全全展示出了当代大学生对舞台的热爱，对梦想的坚持和对失败的从容。中场抽奖环节把活动带向高潮，趁着这活跃的气氛我们进行了最后的“冠军争夺赛”，在评委老师和大众评委的评分下，最终确定了校园十强好声音选手的排位，轨道交通学院戴光韬同学以一曲《南山南》夺得冠军。由易班发展中心的阎小奂老师和化学化工学院、汽车工程学院、服装学院负责易班工作的辅导员老师为大家颁奖。最后，各位评委老师、十强选手和管理学院易班工作站全体台前幕后工作人员一起合影留念，整场比赛在这温馨中完美谢幕。\n", "1");
        Attachment attachment2 = new Attachment("艺术学院学生党支部赴龙华烈士陵园开展清明祭扫活动", R.drawable.xinwen33, "4月2日上午，艺术设计学院学生第三党支部全体党员在党支部书记崔俊老师的带领下，踏着春雨，怀着无比崇敬的心情来到位于龙华寺西侧的龙华烈士陵园进行清明祭扫活动，深切缅怀革命先烈伟业，弘扬爱国主义精神。\n" +
                "龙华烈士陵园由邓小平同志题写园名，系全国重点文物保护单位和重点烈士纪念建筑物保护单位。这里原为龙华革命烈士就义地，解放后，作为革命烈士纪念地予以保护，素有“上海雨花台”之称。\n" +
                "进入龙华烈士陵园，全体参与清明祭扫的同学在纪念碑前庄严肃穆，向烈士纪念碑鞠躬致敬，缅怀革命先烈。随后全体同学进入龙华烈士纪念馆参观，重温革命历史。纪念馆中，百余名人物革命烈士，千余件革命遗物，使我们了解到了自1840年鸦片战争以来上海英烈的革命历程和英勇事迹，感悟到了我们今天的幸福生活，是无数烈士用生命和鲜血换来的。我们应铭记英雄先烈的事迹，继承先烈的遗志，牢记革命先烈的革命精神和优良传统，增强责任感和使命感；牢记党和人民的重托，明确历史赋予的神圣使命，努力提高自身本领，为党和国家的建设贡献力量。\n", "1");
        Attachment attachment3 = new Attachment("国云数据与电气学院共建大数据实验平台", R.drawable.xinwen44, "3月31日下午，电子电气工程学院在行政楼912会议室举行大数据实验平台协议签约仪式，特邀请到国云数据公司项目执行总监朱琼琼与上海中小学新科学新技术创新课程平台负责人秦浩正教授，会议由曾国辉副院长主持，项目团队教师出席。\n" +
                "首先，朱总监介绍了公司的情况与大数据相关产品，指出了国云数据公司在大数据领域目前所做的工作与取得的成绩。公司计划面向高校免费公益地提供“大数据实验科研平台”以供教学和科研，平台包含大数据课程、教材、教学视频、实验操练环境、海量真实的实验数据、大数据知识问答社区，培养训练学生成为社会急缺的数据分析及大数据人才。\n" +
                "接下来，秦教授从中小学新科学新技术创新课程平台的目的和需求出发，阐述了大数据分析这一先进技术中发散性思维与创造性能力培养的重要性，希望通过此次合作进一步完善中小学科技类创新课程体系。\n" +
                "最后，曾国辉副院长肯定了本次合作对于中小学素质培养以及高校科研能力提升的重要意义。同时他希望借助大数据实验平台，进一步促进校企合作，提升学院大数据分析水平，并为后续相关领域做好服务工作。\n", "1");
        Attachment attachment4 = new Attachment("我校举办上海市优秀志愿者进校园系列主题讲座", R.drawable.xinwen55, "3月29日，上海市优秀志愿者进校园系列主题活动首场“快乐志愿，快乐成长”主题宣讲会在上海工程技术大学图文二报举行。上海市杰出志愿者、全国第一家为白血病患儿提供服务的“阳光爱心”志愿者网站发起人钮俊先生结合自己志愿服务历程，阐述了自己对于志愿理念的看法。\n" +
                "在宣讲会上，钮俊先生说“从事18年志愿服务工作，我从志愿服务中感受到了付出的快乐，同时也感受到了不断成长的快乐，我最大的体会是，要把志愿服务当成锻炼自己、不断成长的平台。一分耕耘一分收获，只有坚定信念、不忘初心，不久的将来你就能成为一名优秀的志愿者，同时也会获得成长的快乐。”在谈到志愿活动开展过程中的一系列困难和克服的方法时，钮骏指出在各种志愿活动中存在的最大问题依然是资源供需之间的平衡问题，志愿平台不健全，无法为志愿者与志愿需求者提供有效的信息沟通。钮骏先生以上海市儿童医院志愿活动开展过程为例，为工程大志愿者们提供了一条平衡志愿供需、有效沟通的方法。\n", "1");
        list.add(attachment);
        list.add(attachment1);
        list.add(attachment2);
        list.add(attachment3);
        list.add(attachment4);
        return list;
    }

    /**
     * 院系介绍
     *
     * @return
     */
    public static List<Attachment> getIntroduce() {
        List<Attachment> list = new ArrayList<Attachment>();
        Attachment attachment = new Attachment("材料工程学院", "上海工程技术大学材料工程学院现设有材料工程系、材料科学系、材料工程中心实验室、激光工业技术研究所和纳米技术应用研究中心。\n" + "材料是现代国民经济和国防建设中的重要支柱之一，是先进制造业发展的基础。材料工程学院以材料的组织结构、性能与用途、设计、制备和加工为主线，着力培养在新材料及其应用、材料成型及控制等领域内从事设计、制造、研究、开发和运行管理等方面工作的具有创新意识的应用型高级工程技术人才。在教学上注重学生综合知识运用、实践和创新思维能力的培养，获得校市二级精品课程和教学成果多项。\n", "5");
        attachment.setImage(R.drawable.ic_launcher);
        Attachment attachment1 = new Attachment("城市轨道交通学院", "上海工程技术大学城市轨道交通学院该学院是由上海工程技术大学和上海地铁运营有限公司相互合作，共同成立的。\n学院机构设置有：院理事会、院学术委员会、专业委员会、各专业教学系。目前学院设置4个本科专业：机械工程及自动化（城市轨道交通车辆工程）、电子信息工程（城市轨道交通通信信号）、交通运输（城市轨道交通运营管理）和交通工程专业；另有4个专科专业：城市轨道交通技术（车辆技术）、城市轨道交通技术（通信信号）、城市轨道交通运营管理、城市轨道交通技术（机电设备）。\n", "5");
        attachment1.setImage(R.drawable.ic_launcher);
        Attachment attachment2 = new Attachment("电子电气学院", "上海工程技术大学电子电气工程学院是以控制科学与工程、计算机科学与技术、电气工程、信息与通信工程学科为主体，结合先进制造业和现代服务业的应用发展进行复合和交叉的电气信息类学院。目前在校学生近2000余人，是全校规模最大的二级学院之一。\n学院设置6个本科专业：计算机科学与技术、自动化、自动化（汽车电子工程）、电气工程及其自动化、电气工程及其自动化（现代建筑电气）、电子信息工程。拥有的校级重点学科是：数字化控制与工程，研究方向重点有：现场总线控制系统、嵌入式系统及应用、检测理论与信息识别\n", "5");
        attachment2.setImage(R.drawable.ic_launcher);
        Attachment attachment3 = new Attachment("服装", "上海工程技术大学服装学院是培养跨世纪的复合型的服装设计人材的高等学府。 上海工程技术大学服装学院具有绘画基础、设计基础、面料设计、面料后整理、服装科技与工艺实践、服装设计及企业形象设计、服装表演与策划、形象设计的全方位立体教学能力，目前已形成参与社会产、学、研相结合的合作教育特色。", "5");
        attachment3.setImage(R.drawable.fuzhuang);
        Attachment attachment4 = new Attachment("管理学院", "管理学院办学层次是以本科教育为主，积极发展研究生教育。是以培养面向经济建设、满足社会需要的高层次应用型经济、管理类人才为目标，具有一定社会影响力的管理学院。在28年的办学过程中逐渐形成管理、经济学科特色鲜明、社会保障学科优势突出、总体教学与科研水平在上海市同行中知名的特点。 管理学院下设工商管理、金融、贸易经济、信息管理4个系和1个中心实验室，学院开设工商管理等10个专业。学院还拥有上海市社会保障问题研究中心和经济研究所 2 个校级交叉学科研究中心，学院研究成果丰硕。", "5");
        attachment4.setImage(R.drawable.ic_launcher);
        Attachment attachment5 = new Attachment("航空运输学院", "航空运输学院•飞行学院现设有飞行技术系、民航运输系、航空运营工程系、航空维修工程系、现代民航工程研究中心、院中心实验室、院办公室、学生工作办公室等部门；院中心实验室下设飞行模拟器训练中心•飞行仿真技术实验室、航空货站模拟实训实验室、航空物流案例分析室、航空发动机实验室、民航客货运实验室•物流系统仿真实验室、航空机务数字模拟实验室、航空综合基础实验室、飞机附件拆装实验室等，涉及航空企业运行的各个业务环节；拥有飞行技术、交通运输（航空器械维修）、工商管理（航空经营管理）、物流管理（航空物流）、航空机电设备维修、空中乘务、民航商务等七个专业，实施飞行技术专业准军事化管理，研究并推出乘务类专业的准军事化管理、机务和管理类专业的民航特色管理，既有航空理论教育、又有航空实践训练，具有涉及学科多、技术类别广等特点，已为上海及其它国内外民航企业培养了大量既有理论知识、又有较强动手能力的民航业各类专业人才。", "5");
        attachment5.setImage(R.drawable.ic_launcher);
        Attachment attachment6 = new Attachment("化学化工学院", "上海工程技术大学化工学院是上海市属本科大学的二级学院，学院成立于2001年，其前身是1978年成立的华东化工学院分院的化学工程和高分子材料与工程专业、上海交通大学机电分校化学教研室和和华东纺织学院分院的纺织化学专业。学院仪器设备总值达4000多万元，拥有400M核磁、GC/MS、LC/MS、高分辨质谱、红外光谱仪、原位红外测试仪、TGA、DSC、DMA、凝胶渗透色谱、备液相色谱仪、高效液相色谱、XRD、X射线单晶衍射仪、SEM、TEM、ICP、离子色谱、电化学综合测试仪、荧光光谱仪、荧光显微镜、在线质谱、紫外光光度计、制备色谱、微波合成仪、化学吸附仪、全自动比表面积与孔径测定仪、催化反应与评价装置等数仪器设备。", "5");
        attachment6.setImage(R.drawable.ic_launcher);
        Attachment attachment7 = new Attachment("汽车工程学院", "汽车工程学院是上海工程技术大学的二级学院  ，坐落于上海松江大学城，是上海市最早创办汽车专业的学院，也是上海市汽车类专业门类相对齐全的学院。包括车用发动机、汽车底盘、车身工程、汽车制造、汽车运用工程、汽车服务工程、汽车营销等专业方向。车辆工程专业为授权硕士点、汽车工程和汽车运用工程专业与美国劳伦斯（LAWRENCE）理工大学合作办学，载运工具学科被上海市教委确定为重点学科，现代汽车运用工程学科被上海市政府确定为重点学科。", "5");
        attachment7.setImage(R.drawable.ic_launcher);
        Attachment attachment8 = new Attachment("社会科学学院", "社会科学学院下设“公共管理系”、 “现代城市公共管理研究中心”，同时与学校管理学院共建了“上海市政府公共决策支持”、“上海市社会调研研究中心上海工程技术大学分中心”等研究基地，学生工作办公室、行政办公室、社会科学资料室。社会科学学院围绕学校创建现代化特色大学的战略目标，积极开展教育教学改革，教学质量和人才培养质量不断提高。获得上海市教学成果二等奖1项,三等奖1项；上海工程技术大学教学成果特等奖2项、一等奖2项、二等奖2项。社会保障概论、公共管理和第三部门组织管理3门课程被列为上海市重点建设课程，17门课程被列为精品课程。先后完成了20余项教学建设项目。“劳动与社会保障”、“公共事业管理”两个专业被列为上海市教育高地。", "5");
        attachment8.setImage(R.drawable.ic_launcher);
        list.add(attachment);
        list.add(attachment1);
        list.add(attachment2);
        list.add(attachment3);
        list.add(attachment4);
        list.add(attachment5);
        list.add(attachment6);
        list.add(attachment7);
        list.add(attachment8);
        return list;
    }

    /**
     * 特色介绍
     *
     * @return
     */
    public static List<Attachment> getSubject() {
        List<Attachment> list = new ArrayList<Attachment>();
        Attachment attachment = new Attachment("轨道展示馆1", R.drawable.guidao1, "看点一、列车沙盘模拟系统\n" + "        上海工程技术大学城市轨道交通学院自主研发的基于无线通信的列车自动运行模拟系统，以上海地铁3、4号线的共线特点为主要素材，模拟实际地铁的运行状况。列车将行车数据发送到控制中心，控制中心实现列车的自动运行控制及信号控制，指示列车自动运行在线路上。整个系统主要采用了无线通信技术、电机驱动控制技术、射频识别技术和智能计算等，整个模拟列车运行控制系统在国内首次模拟实现了基于无线通信的列车运行控制、列车自动防护、计算机联锁、列车自动运行、列车自动监控等功能。\n", "4");
        Attachment attachment1 = new Attachment("轨道展示馆2", R.drawable.guidao2, "看点二、列车模拟驾驶\n" + "        地铁列车模拟驾驶能够真实模拟地铁列车的操作性能以及运行环境。只有经过在模拟驾驶器上的操作合格认定之后才能够进入实车训练，这也是承担重大交通运输安全的其它交通工具正式上岗前所需要进行的必要工作。模拟驾驶装置是真实仿真上海地铁车辆3号线阿尔斯通车型。列车驾驶分为自动驾驶和手动驾驶两种模式。自动驾驶是平时常用模式，而手动驾驶除了应急以外，一般常用于进、出基地与车库，晚上的练习时段，以及自动驾驶模式尚未开通的线路。\n", "4");
        Attachment attachment2 = new Attachment("轨道展示馆3", R.drawable.guidao3, "看点三、列车运营调度\n" + "        列车自动控制系统是城市轨道交通运营系统的中枢，控制列车安全、高效的运行。包含三个子系统：列车自动防护系统、列车自动监控系统、列车自动运行系统。列车自动控制仿真系统是以上海轨道交通3、4号线运营调度中心为原型，设计并实现的，配备80个工作台位及调度显示大屏幕，可实现轨道交通列车运营调度，组织运行方案，尽快恢复列车按原有计划运行，保证我们的列车运行准点畅通。\n", "4");
        Attachment attachment3 = new Attachment("航空展览馆1", R.drawable.hangkong1, "看点一：飞行模拟器训练中心•飞行仿真技术实验室\n        中心主要装备是由我校与飞行仿真技术研究所联合研制的、具有自主知识产权的、达到国内领先水平、国际先进水平的一台三自由度民航飞行模拟器和两台小型固定飞行模拟器。飞行模拟器是在地面模拟飞机各种飞行状态的装置，主要用于飞行训练和科学研究。飞行人员在模拟舱内进行操作，可以练习驾驶、领航等技术，能观察和体验飞行中的现象和感觉。\n", "4");
        Attachment attachment4 = new Attachment("航空展览馆2", R.drawable.hangkong2, "看点二：航空发动机陈列馆\n    发动机陈列室有不同种类型各种风格的共11台发动机的整机、解剖件和分解的零部件。另外四周还制作了多种飞机及发动机附件清晰的彩色结构示教图版，为有效地开展现场教学提供了条件。陈列室是半开放式的，学生在学习期间随时都可以联系参观\n", "4");
        Attachment attachment5 = new Attachment("航空展览馆3", R.drawable.hangkong3, "看点三：实体飞机\n    图文信息中心旁草坪上停放着三架实体飞机可供参观和学习，分别是安－24（Y-7）、初教六和运－五（Y-5）飞机。\n", "4");
        Attachment attachment6 = new Attachment("汽车展示馆1", R.drawable.qiche1, "看点一：汽车科普讲解团队\n" + "        科普基地讲解团是基地自行组织的一支专业知识扎实，实力雄厚的队伍，本讲解团的主要职责是为参观者介绍科普基地的各个实验室，内容涵盖汽车底盘，悬架，发动机，变速器等等。目前讲解团由我校汽车工程学院的近40名优秀的同学组成，并成功接待过上海市副市长等人的参观。\n", "4");
        Attachment attachment7 = new Attachment("汽车展示馆2", R.drawable.qiche2, "看点二：雄厚的展馆陈列\n" + "        汽车科普展示馆的展览馆多达10余种，各个展览馆都有自己的主题，比如柴油喷射系统实验馆，底盘实验馆，发动机部件馆，发动机拆装实验馆，发动机检测实验馆，发动机台架实验馆，悬架展示馆，整车实验馆等等，参观者可以根据自己的喜好，选择不同的展示馆进行参观学习，可以满足人们的不同需求。\n", "4");
        list.add(attachment);
        list.add(attachment1);
        list.add(attachment2);
        list.add(attachment3);
        list.add(attachment4);
        list.add(attachment5);
        list.add(attachment6);
        list.add(attachment7);
        return list;
    }


}
